package com.planyi.planyi.dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.planyi.planyi.R;

public class IniciarSesionDialog extends DialogFragment{

    private Button btnIniciarSesion;
    private EditText etEmail, etContra;
    private View.OnClickListener clickListener;

    public IniciarSesionDialog() {
    }

    public static IniciarSesionDialog create() {
        IniciarSesionDialog dialog = new IniciarSesionDialog();
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_iniciar_sesion, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setViews(view);
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow()
                .setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    private void setViews(View view){
        btnIniciarSesion = view.findViewById(R.id.btn_iniciarSesion_ok);
        etEmail = view.findViewById(R.id.et_iniciarSesion_email);
        etContra = view.findViewById(R.id.et_iniciarSesion_contra);

        btnIniciarSesion.setOnClickListener(clickListener);
    }

    public void setClickListener(View.OnClickListener clickListener) {
        this.clickListener = clickListener;
    }
}
