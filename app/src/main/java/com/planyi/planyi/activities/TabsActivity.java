package com.planyi.planyi.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.planyi.planyi.R;
import com.planyi.planyi.Session;
import com.planyi.planyi.fragments.AyudaFragment;
import com.planyi.planyi.fragments.PerfilFragment;
import com.planyi.planyi.fragments.ProveedoresFragment;

public class TabsActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private TextView tvTotal, tvEventoReservado;
    private PerfilFragment perfilFragment;
    private ProveedoresFragment proveedoresFragment;
    private AyudaFragment ayudaFragment;
    private Button btnReservar;
    private LinearLayout tabContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        tvTotal = findViewById(R.id.tv_total);
        perfilFragment = PerfilFragment.newInstance();
        perfilFragment.setContext(this);
        proveedoresFragment = ProveedoresFragment.newInstance();
        ayudaFragment = AyudaFragment.newInstance();
        btnReservar = findViewById(R.id.btn_reservar);
        btnReservar.setOnClickListener(this);
        tvEventoReservado = findViewById(R.id.tv_evento_reservado);
        tabContainer = findViewById(R.id.tab_container);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        changeFragment(perfilFragment);
    }


    private boolean changeFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.tab_container,fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.navigation_home:
                fragment = perfilFragment;
                Session.getInstance().saveActualTab(1);
                break;
            case R.id.navigation_proveedores:
                fragment = proveedoresFragment;
                Session.getInstance().saveActualTab(2);
                break;
            case R.id.navigation_ayuda:
                fragment = ayudaFragment;
                Session.getInstance().saveActualTab(3);
                break;
        }
        return changeFragment(fragment);
    }

    @Override
    protected void onResume() {
        super.onResume();
        switch (Session.getInstance().getActualTab()){
            case 1:
                changeFragment(perfilFragment);
                break;
            case 2:
                changeFragment(proveedoresFragment);
                break;
            case 3:
                changeFragment(ayudaFragment);
                break;
        }
        tvTotal.setText("$" + perfilFragment.getTotal());
    }


    @Override
    public void onClick(View v) {
        if (!tvTotal.getText().toString().equals("$0")){
            showConfirmDialog();
        }
    }

    private void showConfirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Reservar evento")
                .setMessage("¿Estás seguro? ")
                .setPositiveButton("Si",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                showAlertDialog();
                                dialog.dismiss();
                            }
                        })
                .setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create().show();
    }

    private void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("¡Listo!").setMessage("Tu evento ha sido reservado con éxito. \n" +
                        "En breve nos comunicaremos contigo.")
                .setPositiveButton("Entendido",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                tvEventoReservado.setVisibility(View.VISIBLE);
                                btnReservar.setEnabled(false);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                    btnReservar.setBackgroundColor(getColor(R.color.gris_fuerte));
                                }
                                Session.getInstance().saveEventoReservado(true);
                                dialog.dismiss();
                            }
                        }).create().show();
    }
}
