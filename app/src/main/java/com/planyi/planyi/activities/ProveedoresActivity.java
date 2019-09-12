package com.planyi.planyi.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.planyi.planyi.R;
import com.planyi.planyi.Session;
import com.planyi.planyi.dialogs.DetalleProveedorDialog;
import com.planyi.planyi.utils.Constants;

public class ProveedoresActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvTitulo, tvNombre1, tvNombre2;
    private ImageView ivLogo1, ivLogo2;
    private Button btnVerMas1, btnVerMas2;
    private int proveedorSeleccionado = 0, detalleNum = 0;

    private DetalleProveedorDialog proveedorDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proveedores);
        setViews();
        setContent();

    }

    private void setContent() {
        proveedorSeleccionado = getIntent().getIntExtra(Constants.INTENT_PROVEEDOR, 0);
        switch (proveedorSeleccionado){
            case Constants.SALONES:
                setInfo(
                        getString(R.string.title_salones),
                        getString(R.string.salon_1),
                        getString(R.string.salon_2));
                ivLogo1.setImageDrawable(getDrawable(R.drawable.luxemburgo));
                ivLogo2.setImageDrawable(getDrawable(R.drawable.via_esperanza));
                break;
            case Constants.FLORES:
                setInfo(
                        getString(R.string.title_flores),
                        getString(R.string.floreria_1),
                        getString(R.string.floreria_2));
                ivLogo1.setImageDrawable(getDrawable(R.drawable.casablancalogo));
                ivLogo2.setImageDrawable(getDrawable(R.drawable.floresselogo));
                break;
            case Constants.FOTO:
                setInfo(
                        getString(R.string.title_fotos),
                        getString(R.string.foto1),
                        getString(R.string.foto2));
                ivLogo1.setImageDrawable(getDrawable(R.drawable.albertoguadarramalogo));
                ivLogo2.setImageDrawable(getDrawable(R.drawable.jacobologo));
                break;
            case Constants.BANQUETE:
                setInfo(
                        getString(R.string.title_banquetes),
                        getString(R.string.banquete_1),
                        getString(R.string.banquete_2));
                ivLogo1.setImageDrawable(getDrawable(R.drawable.banquetesleonlogo));
                ivLogo2.setImageDrawable(getDrawable(R.drawable.banquetescasablancalogo));
                break;
            case Constants.TRAJE:
                setInfo(
                        getString(R.string.title_trajes),
                        getString(R.string.trajes1),
                        getString(R.string.trajes2));
                ivLogo1.setImageDrawable(getDrawable(R.drawable.gallegoslogo));
                ivLogo2.setImageDrawable(getDrawable(R.drawable.dpaullogo));
                break;
            case Constants.MUSICA:
                setInfo(
                        getString(R.string.title_musica),
                        getString(R.string.musica1),
                        getString(R.string.musica2));
                ivLogo1.setImageDrawable(getDrawable(R.drawable.grupoversatil));
                ivLogo2.setImageDrawable(getDrawable(R.drawable.cafecafe));
                break;
            case Constants.INVITACIONES:
                setInfo(
                        getString(R.string.title_invitaciones),
                        getString(R.string.invitaciones1),
                        getString(R.string.invitaciones2));
                ivLogo1.setImageDrawable(getDrawable(R.drawable.diferlogo));
                ivLogo2.setImageDrawable(getDrawable(R.drawable.stronkalogo));
                break;
            case Constants.VESTIDOS:
                setInfo(
                        getString(R.string.title_vestidos),
                        getString(R.string.vestidos1),
                        getString(R.string.vestidos2));
                ivLogo1.setImageDrawable(getDrawable(R.drawable.losoyadresslogo));
                ivLogo2.setImageDrawable(getDrawable(R.drawable.queendresslogo));
                break;
        }
    }

    private void showDetalleProveedorDialog(int proveedor, int detalleNum) {
        if (proveedorDialog != null){
            proveedorDialog.setClickListener(this);
            proveedorDialog.setContext(this);
            proveedorDialog.setDetalleNum(detalleNum);
            proveedorDialog.show(getSupportFragmentManager(),"DetalleProveedorDialog");
        } else {
            proveedorDialog = DetalleProveedorDialog.create(proveedor, detalleNum);
            showDetalleProveedorDialog(proveedor,detalleNum);
        }
    }

    private void setInfo(String titulo, String nombre1, String nombre2){
        tvTitulo.setText(titulo);
        tvNombre1.setText(nombre1);
        tvNombre2.setText(nombre2);
    }

    public void setViews(){
        tvTitulo = findViewById(R.id.tv_proveedor_title);
        tvNombre1 = findViewById(R.id.tv_proveedor_1_nombre);
        tvNombre2 = findViewById(R.id.tv_proveedor_2_nombre);
        ivLogo1 = findViewById(R.id.iv_proveedor_1_logo);
        ivLogo2 = findViewById(R.id.iv_proveedor_2_logo);
        btnVerMas1 = findViewById(R.id.btn_proveedor_1_vermas);
        btnVerMas2 = findViewById(R.id.btn_proveedor_2_vermas);

        btnVerMas2.setOnClickListener(this);
        btnVerMas1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnVerMas1.getId()){
            detalleNum = 1;
            showDetalleProveedorDialog(proveedorSeleccionado, detalleNum);
        }
        if (v.getId() == btnVerMas2.getId()){
            detalleNum = 2;
            showDetalleProveedorDialog(proveedorSeleccionado, detalleNum);
        }
        if (v.getId() == R.id.btn_detalle_adquirir){
            switch (proveedorSeleccionado){
                case Constants.SALONES:
                    Session.getInstance().saveSalon(detalleNum);
                    break;
                case Constants.FLORES:
                    Session.getInstance().saveFlores(detalleNum);
                    break;
                case Constants.FOTO:
                    Session.getInstance().saveFoto(detalleNum);
                    break;
                case Constants.BANQUETE:
                    Session.getInstance().saveBanquete(detalleNum);
                    break;
                case Constants.TRAJE:
                    Session.getInstance().saveTraje(detalleNum);
                    break;
                case Constants.MUSICA:
                    Session.getInstance().saveMusica(detalleNum);
                    break;
                case Constants.INVITACIONES:
                    Session.getInstance().saveInvitacion(detalleNum);
                    break;
                case Constants.VESTIDOS:
                    Session.getInstance().saveVestido(detalleNum);
                    break;
            }
            proveedorDialog.dismiss();
            finish();
        }
    }
}
