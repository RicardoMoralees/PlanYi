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
import android.widget.RadioButton;

import com.planyi.planyi.R;

public class RegistrarDialog extends DialogFragment {

    private EditText etNombre, etEmail, etContra;
    private Button btnOk;
    private RadioButton rbBoda, rbGraduacion, rbXvs, rbOtro;
    private View.OnClickListener clickListener;

    public RegistrarDialog() {
    }

    public static RegistrarDialog create(){

        RegistrarDialog dialog = new RegistrarDialog();

        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_registrar, container);
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
                .setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
    }

    private void setViews(View view){
        etContra = view.findViewById(R.id.et_registro_contra);
        etEmail = view.findViewById(R.id.et_registro_email);
        etNombre = view.findViewById(R.id.et_registro_nombre);
        btnOk = view.findViewById(R.id.btn_registro_ok);
        rbBoda = view.findViewById(R.id.rb_boda);
        rbGraduacion = view.findViewById(R.id.rb_graduacion);
        rbXvs = view.findViewById(R.id.rb_xvs);
        rbOtro = view.findViewById(R.id.rb_otro);

        btnOk.setOnClickListener(clickListener);
    }

    public void setClickListener(View.OnClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public String getNombre() {
        return etNombre.getText().toString();
    }

    public String getEtEmail() {
        return etEmail.getText().toString();
    }

    public String getEtContra() {
        return etContra.getText().toString();
    }

    public String getRol(){
        if (rbBoda.isChecked()){
            return "Boda";
        }
        if (rbGraduacion.isChecked()){
            return "Graduación";
        }
        if (rbXvs.isChecked()){
            return "XV's";
        }
        if (rbOtro.isChecked()){
            return "Otro";
        }
        return "";
    }
}
