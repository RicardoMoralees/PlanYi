package com.planyi.planyi.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.planyi.planyi.R;
import com.planyi.planyi.Session;
import com.planyi.planyi.activities.ProveedoresActivity;
import com.planyi.planyi.utils.Constants;

public class ProveedoresFragment extends Fragment implements View.OnClickListener {

    private LinearLayout llSalon, llFlores, llFoto, llBanquete,
                            llTraje, llMusica, llInvitaciones, llVestidos;

    public ProveedoresFragment() {
        // Required empty public constructor
    }


    public static ProveedoresFragment newInstance() {
        ProveedoresFragment fragment = new ProveedoresFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_proveedores, container, false);
        setViews(view);
        return view;
    }

    private void setViews(View view){
        llSalon = view.findViewById(R.id.ll_proveedor_salon);
        llFlores = view.findViewById(R.id.ll_proveedor_flores);
        llFoto = view.findViewById(R.id.ll_proveedor_foto);
        llBanquete = view.findViewById(R.id.ll_proveedor_banquete);
        llTraje = view.findViewById(R.id.ll_proveedor_traje);
        llMusica = view.findViewById(R.id.ll_proveedor_musica);
        llInvitaciones = view.findViewById(R.id.ll_proveedor_invitaciones);
        llVestidos = view.findViewById(R.id.ll_proveedor_vestidos);

        llSalon.setOnClickListener(this);
        llFlores.setOnClickListener(this);
        llFoto.setOnClickListener(this);
        llBanquete.setOnClickListener(this);
        llTraje.setOnClickListener(this);
        llMusica.setOnClickListener(this);
        llInvitaciones.setOnClickListener(this);
        llVestidos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (!Session.getInstance().getEventoReservado()){
            Intent intent = new Intent(getContext(), ProveedoresActivity.class);
            switch (v.getId()){
                case R.id.ll_proveedor_salon:
                    intent.putExtra(Constants.INTENT_PROVEEDOR, Constants.SALONES);
                    break;
                case R.id.ll_proveedor_flores:
                    intent.putExtra(Constants.INTENT_PROVEEDOR, Constants.FLORES);
                    break;
                case R.id.ll_proveedor_foto:
                    intent.putExtra(Constants.INTENT_PROVEEDOR, Constants.FOTO);
                    break;
                case R.id.ll_proveedor_banquete:
                    intent.putExtra(Constants.INTENT_PROVEEDOR, Constants.BANQUETE);
                    break;
                case R.id.ll_proveedor_traje:
                    intent.putExtra(Constants.INTENT_PROVEEDOR, Constants.TRAJE);
                    break;
                case R.id.ll_proveedor_musica:
                    intent.putExtra(Constants.INTENT_PROVEEDOR, Constants.MUSICA);
                    break;
                case R.id.ll_proveedor_invitaciones:
                    intent.putExtra(Constants.INTENT_PROVEEDOR, Constants.INVITACIONES);
                    break;
                case R.id.ll_proveedor_vestidos:
                    intent.putExtra(Constants.INTENT_PROVEEDOR, Constants.VESTIDOS);
                    break;
            }
            startActivity(intent);
        }
    }
}
