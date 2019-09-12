package com.planyi.planyi.dialogs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.planyi.planyi.R;
import com.planyi.planyi.Session;
import com.planyi.planyi.models.Proveedor;
import com.planyi.planyi.utils.Constants;

public class InfoProveedorDialog extends DialogFragment implements View.OnClickListener {

    private ImageView ivLogo, ivClose;
    private TextView tvTitulo, tvContent;
    private Proveedor proveedor;
    private Context context;

    public InfoProveedorDialog() {
    }

    public static InfoProveedorDialog create() {
        InfoProveedorDialog dialog = new InfoProveedorDialog();
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_info_proveedor, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivLogo = view.findViewById(R.id.iv_info_logo);
        ivClose = view.findViewById(R.id.iv_close_infoDialog);
        tvTitulo = view.findViewById(R.id.tv_info_title);
        tvContent = view.findViewById(R.id.tv_info_contenido);
        ivClose.setOnClickListener(this);

        setContent(proveedor.getProveedorId());
        tvTitulo.setText(proveedor.getNombre());
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    private void setContent(int proveedor){
        String[] contenido = null;
        switch (proveedor){
            case Constants.SALONES:
                if (Session.getInstance().getSalon() == 1){
                    contenido = context.getResources().getStringArray(R.array.luxemburgo);
                    ivLogo.setImageDrawable(context.getDrawable(R.drawable.luxemburgo));
                }else {
                    contenido = context.getResources().getStringArray(R.array.via_esperanza);
                    ivLogo.setImageDrawable(context.getDrawable(R.drawable.via_esperanza));
                }
                break;
            case Constants.FLORES:
                if (Session.getInstance().getFlores() == 1){
                    contenido = context.getResources().getStringArray(R.array.floreria_casablanca);
                    ivLogo.setImageDrawable(context.getDrawable(R.drawable.casablancalogo));
                }else {
                    contenido = context.getResources().getStringArray(R.array.floreria_floresse);
                    ivLogo.setImageDrawable(context.getDrawable(R.drawable.floresselogo));
                }
                break;
            case Constants.FOTO:
                if (Session.getInstance().getFoto() == 1){
                    contenido = context.getResources().getStringArray(R.array.foto_alberto);
                    ivLogo.setImageDrawable(context.getDrawable(R.drawable.albertoguadarramalogo));
                }else {
                    contenido = context.getResources().getStringArray(R.array.foto_fernando);
                    ivLogo.setImageDrawable(context.getDrawable(R.drawable.jacobologo));
                }
                break;
            case Constants.BANQUETE:
                if (Session.getInstance().getBanquete() == 1){
                    contenido = context.getResources().getStringArray(R.array.banquetes_leon);
                    ivLogo.setImageDrawable(context.getDrawable(R.drawable.banquetesleonlogo));
                }else {
                    contenido = context.getResources().getStringArray(R.array.banquetes_casablanca);
                    ivLogo.setImageDrawable(context.getDrawable(R.drawable.banquetescasablancalogo));
                }
                break;
            case Constants.TRAJE:
                if (Session.getInstance().getTraje() == 1){
                    contenido = context.getResources().getStringArray(R.array.trajes_gallegos);
                    ivLogo.setImageDrawable(context.getDrawable(R.drawable.gallegoslogo));
                }else {
                    contenido = context.getResources().getStringArray(R.array.trajes_dPaul);
                    ivLogo.setImageDrawable(context.getDrawable(R.drawable.dpaullogo));
                }
                break;
            case Constants.MUSICA:
                if (Session.getInstance().getMusica() == 1){
                    contenido = context.getResources().getStringArray(R.array.musica_versatil);
                    ivLogo.setImageDrawable(context.getDrawable(R.drawable.grupoversatil));
                }else {
                    contenido = context.getResources().getStringArray(R.array.musica_cafe);
                    ivLogo.setImageDrawable(context.getDrawable(R.drawable.cafecafe));
                }
                break;
            case Constants.INVITACIONES:
                if (Session.getInstance().getInvitacion() == 1){
                    contenido = context.getResources().getStringArray(R.array.invitaciones_difer);
                    ivLogo.setImageDrawable(context.getDrawable(R.drawable.diferlogo));
                }else {
                    contenido = context.getResources().getStringArray(R.array.invitaciones_stronka);
                    ivLogo.setImageDrawable(context.getDrawable(R.drawable.stronkalogo));
                }
                break;
            case Constants.VESTIDOS:
                if (Session.getInstance().getVestido() == 1){
                    contenido = context.getResources().getStringArray(R.array.vestidos_losoya);
                    ivLogo.setImageDrawable(context.getDrawable(R.drawable.losoyadresslogo));
                }else {
                    contenido = context.getResources().getStringArray(R.array.vestidos_queen);
                    ivLogo.setImageDrawable(context.getDrawable(R.drawable.queendresslogo));
                }
                break;
        }
        StringBuilder stringBuilder = new StringBuilder();

        for (String c:contenido) {
            stringBuilder.append(c).append("\n");
        }
        tvContent.setText(stringBuilder.toString());
    }
    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow()
                .setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        dismiss();
    }
}
