package com.planyi.planyi.fragments;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.planyi.planyi.Planyi;
import com.planyi.planyi.R;
import com.planyi.planyi.Session;
import com.planyi.planyi.activities.MainActivity;

import static android.content.Context.CLIPBOARD_SERVICE;

public class AyudaFragment extends Fragment implements View.OnClickListener {

    private TextView tvComparte, tvNosotros, tvCerrarSesion;

    public AyudaFragment() {
        // Required empty public constructor
    }


    public static AyudaFragment newInstance() {
        AyudaFragment fragment = new AyudaFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ayuda, container, false);
        tvCerrarSesion = view.findViewById(R.id.tv_cerrar_sesion);
        tvComparte = view.findViewById(R.id.tv_comparte);
        tvNosotros = view.findViewById(R.id.tv_nosotros);

        tvNosotros.setOnClickListener(this);
        tvComparte.setOnClickListener(this);
        tvCerrarSesion.setOnClickListener(this);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_cerrar_sesion){
            Session.getInstance().cerrarSesion();
            Intent i = new Intent(getContext(), MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }
        if (v.getId() == R.id.tv_nosotros){
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

            builder.setTitle("Nosotros")
                    .setMessage("-Luis Grano Borboa (Director General) \n" +
                            "-Larissa Sauceda Villegas (Director ejecutivo) \n" +
                            "-Jonathan Noriega Millán (Director Marketing Digital) \n" +
                            "-Alison Beltrán López (Director Administrativo) \n" +
                            "-Zuleth Sánchez López (Director Creativo)\n\n\n" +
                            "Todos los derechos reservados Mayo 2019.")
                    .setPositiveButton("Aceptar",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).create().show();

        }
        if (v.getId() == R.id.tv_comparte){
            ClipboardManager clipboard = (ClipboardManager) getContext().getSystemService(CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("link", "https://drive.google.com/open?id=1btqIX6PDysZA0ue01WPeXZ3zVnZaM43o");
            clipboard.setPrimaryClip(clip);

            Toast.makeText(getContext(),"Enlace copiado!",Toast.LENGTH_SHORT).show();
        }
    }
}
