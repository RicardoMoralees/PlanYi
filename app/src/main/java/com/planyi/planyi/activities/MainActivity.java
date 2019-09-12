package com.planyi.planyi.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.planyi.planyi.Planyi;
import com.planyi.planyi.R;
import com.planyi.planyi.dialogs.IniciarSesionDialog;
import com.planyi.planyi.dialogs.RegistrarDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnRegistrar, btnIniciarSesion, btnMasTarde;
    private VideoView videoView;
    private RegistrarDialog registrarDialog;
    private IniciarSesionDialog iniciarSesionDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Planyi.init(this);

        btnRegistrar = findViewById(R.id.btn_registrar);
        btnIniciarSesion = findViewById(R.id.btn_iniciar_sesion);
        btnMasTarde = findViewById(R.id.btn_mas_tarde);

        btnRegistrar.setOnClickListener(this);
        btnIniciarSesion.setOnClickListener(this);
        btnMasTarde.setOnClickListener(this);

        videoView = findViewById(R.id.videoView);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.vino;
        videoView.setVideoPath(path);

        //videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.start();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnRegistrar.getId()){
            showRegistrarDialog();
        }
        if (v.getId() == btnIniciarSesion.getId()){
            showIniciarSesionDialog();
        }
        if (v.getId() == btnMasTarde.getId()){
            Intent i = new Intent(this,TabsActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }
        if (v.getId() == R.id.btn_iniciarSesion_ok){
            Intent i = new Intent(this, TabsActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }
        if (v.getId() == R.id.btn_registro_ok){
            Planyi.session.saveName(registrarDialog.getNombre());
            Planyi.session.saveEmail(registrarDialog.getEtEmail());
            Planyi.session.saveContra(registrarDialog.getEtContra());
            Planyi.session.saveRol(registrarDialog.getRol());
            Intent i = new Intent(this, TabsActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }
    }

    private void showIniciarSesionDialog() {
        if (iniciarSesionDialog != null){
            iniciarSesionDialog.show(getSupportFragmentManager(),"IniciarSesionDialog");
        } else {
            iniciarSesionDialog = IniciarSesionDialog.create();
            iniciarSesionDialog.setClickListener(this);
            showIniciarSesionDialog();
        }
    }

    private void showRegistrarDialog(){
        if (registrarDialog != null){
            registrarDialog.show(getSupportFragmentManager(),"RegistrarDialog");
        } else {
            registrarDialog = RegistrarDialog.create();
            registrarDialog.setClickListener(this);
            showRegistrarDialog();
        }
    }
}
