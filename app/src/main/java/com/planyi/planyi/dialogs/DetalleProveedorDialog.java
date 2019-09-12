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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.planyi.planyi.R;
import com.planyi.planyi.utils.Constants;

public class DetalleProveedorDialog extends DialogFragment implements View.OnClickListener {

    private TextView tvTitulo, tvNombre, tvDescripcion, tvServicios, tvCosto;
    private ImageView ivImagen, ivClose;
    private Button btnAdquirir;
    private View.OnClickListener clickListener;
    private int proveedor = 0, detalleNum = 0;
    private Context context;

    public DetalleProveedorDialog() {
    }

    public static DetalleProveedorDialog create(int proveedor, int detalle){
        DetalleProveedorDialog fragment = new DetalleProveedorDialog();
        fragment.proveedor = proveedor;
        fragment.detalleNum = detalle;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_detalle_proveedor, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setViews(view);
        setContent();
    }

    private void setContent() {
        switch (proveedor){
            case Constants.SALONES:
                if (detalleNum == 1){
                    setInfo(context.getString(R.string.title_salones),
                            context.getString(R.string.salon_1),
                            context.getString(R.string.salon1_descripcion),
                            getServicios(context.getResources().getStringArray(R.array.luxemburgo)),
                            context.getString(R.string.salon1_costo));
                    ivImagen.setImageDrawable(context.getDrawable(R.drawable.lux));
                }else {
                    setInfo(context.getString(R.string.title_salones),
                            context.getString(R.string.salon_2),
                            context.getString(R.string.salon2_descripcion),
                            getServicios(context.getResources().getStringArray(R.array.via_esperanza)),
                            context.getString(R.string.salon2_costo));
                    ivImagen.setImageDrawable(context.getDrawable(R.drawable.viaesperanza));
                }
                break;
            case Constants.FLORES:
                if (detalleNum == 1){
                    setInfo(context.getString(R.string.title_flores),
                            context.getString(R.string.floreria_1),
                            context.getString(R.string.floreria1_desc),
                            getServicios(context.getResources().getStringArray(R.array.floreria_casablanca)),
                            context.getString(R.string.floreria1_costo));
                    ivImagen.setImageDrawable(context.getDrawable(R.drawable.casablancadetalle));
                }else {
                    setInfo(context.getString(R.string.title_flores),
                            context.getString(R.string.floreria_2),
                            context.getString(R.string.floreria2_desc),
                            getServicios(context.getResources().getStringArray(R.array.floreria_floresse)),
                            context.getString(R.string.floreria2_costo));
                    ivImagen.setImageDrawable(context.getDrawable(R.drawable.floressedetalle));
                }

                break;
            case Constants.FOTO:
                if (detalleNum == 1){
                    setInfo(context.getString(R.string.title_fotos),
                            context.getString(R.string.foto1),
                            context.getString(R.string.foto1_desc),
                            getServicios(context.getResources().getStringArray(R.array.foto_alberto)),
                            context.getString(R.string.foto1_costo));
                    ivImagen.setImageDrawable(context.getDrawable(R.drawable.albertodetalle));
                }else {
                    setInfo(context.getString(R.string.title_fotos),
                            context.getString(R.string.foto2),
                            context.getString(R.string.foto2_desc),
                            getServicios(context.getResources().getStringArray(R.array.foto_fernando)),
                            context.getString(R.string.foto2_costo));
                    ivImagen.setImageDrawable(context.getDrawable(R.drawable.jacobodetalle));
                }

                break;
            case Constants.BANQUETE:
                if (detalleNum == 1){
                    setInfo(context.getString(R.string.title_banquetes),
                            context.getString(R.string.banquete_1),
                            context.getString(R.string.banquete1_desc),
                            getServicios(context.getResources().getStringArray(R.array.banquetes_leon)),
                            context.getString(R.string.banquete1_costo));
                    ivImagen.setImageDrawable(context.getDrawable(R.drawable.leondetalle));
                }else {
                    setInfo(context.getString(R.string.title_banquetes),
                            context.getString(R.string.banquete_2),
                            context.getString(R.string.banquete2_desc),
                            getServicios(context.getResources().getStringArray(R.array.banquetes_casablanca)),
                            context.getString(R.string.banquete2_costo));
                    ivImagen.setImageDrawable(context.getDrawable(R.drawable.banquetecasablancadetalle));
                }
                break;
            case Constants.TRAJE:
                if (detalleNum == 1){
                    setInfo(context.getString(R.string.title_trajes),
                            context.getString(R.string.trajes1),
                            context.getString(R.string.trajes1_desc),
                            getServicios(context.getResources().getStringArray(R.array.trajes_gallegos)),
                            context.getString(R.string.trajes1_costo));
                    ivImagen.setImageDrawable(context.getDrawable(R.drawable.gallegosdetalle));
                }else {
                    setInfo(context.getString(R.string.title_trajes),
                            context.getString(R.string.trajes2),
                            context.getString(R.string.trajes2_desc),
                            getServicios(context.getResources().getStringArray(R.array.trajes_dPaul)),
                            context.getString(R.string.trajes2_costo));
                    ivImagen.setImageDrawable(context.getDrawable(R.drawable.dpauldetalle));
                }

                break;
            case Constants.MUSICA:
                if (detalleNum == 1){
                    setInfo(context.getString(R.string.title_musica),
                            context.getString(R.string.musica1),
                            context.getString(R.string.musica1_desc),
                            getServicios(context.getResources().getStringArray(R.array.musica_versatil)),
                            context.getString(R.string.musica1_costo));
                    ivImagen.setImageDrawable(context.getDrawable(R.drawable.grupoversatil));
                }else {
                    setInfo(context.getString(R.string.title_musica),
                            context.getString(R.string.musica2),
                            context.getString(R.string.musica2_desc),
                            getServicios(context.getResources().getStringArray(R.array.musica_cafe)),
                            context.getString(R.string.musica2_costo));
                    ivImagen.setImageDrawable(context.getDrawable(R.drawable.cafecafe));
                }
                break;
            case Constants.INVITACIONES:
                if (detalleNum == 1){
                    setInfo(context.getString(R.string.title_invitaciones),
                            context.getString(R.string.invitaciones1),
                            context.getString(R.string.invitaciones1_desc),
                            getServicios(context.getResources().getStringArray(R.array.invitaciones_difer)),
                            context.getString(R.string.invitaciones1_costo));
                    ivImagen.setImageDrawable(context.getDrawable(R.drawable.diferdetalle));
                }else {
                    setInfo(context.getString(R.string.title_invitaciones),
                            context.getString(R.string.invitaciones2),
                            context.getString(R.string.invitaciones2_desc),
                            getServicios(context.getResources().getStringArray(R.array.invitaciones_stronka)),
                            context.getString(R.string.invitaciones2_costo));
                    ivImagen.setImageDrawable(context.getDrawable(R.drawable.stronkasociales));
                }

                break;
            case Constants.VESTIDOS:
                if (detalleNum == 1){
                    setInfo(context.getString(R.string.title_vestidos),
                            context.getString(R.string.vestidos1),
                            context.getString(R.string.vestidos1_desc),
                            getServicios(context.getResources().getStringArray(R.array.vestidos_losoya)),
                            context.getString(R.string.vestidos1_costo));
                    ivImagen.setImageDrawable(context.getDrawable(R.drawable.losoyadresslogo));
                }else {
                    setInfo(context.getString(R.string.title_vestidos),
                            context.getString(R.string.vestidos2),
                            context.getString(R.string.vestidos2_desc),
                            getServicios(context.getResources().getStringArray(R.array.vestidos_queen)),
                            context.getString(R.string.vestidos2_costo));
                    ivImagen.setImageDrawable(context.getDrawable(R.drawable.queendresslogo));
                }
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow()
                .setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    private void setViews(View view){
        tvCosto = view.findViewById(R.id.tv_detalle_costo);
        tvDescripcion = view.findViewById(R.id.tv_detalle_descripcion);
        tvNombre = view.findViewById(R.id.tv_detalle_nombre);
        tvServicios = view.findViewById(R.id.tv_detalle_servicios);
        tvTitulo = view.findViewById(R.id.tv_detalle_titulo);
        ivImagen = view.findViewById(R.id.iv_detalle_imagen);
        ivClose = view.findViewById(R.id.iv_close_detalleProveedorDialog);
        btnAdquirir = view.findViewById(R.id.btn_detalle_adquirir);

        btnAdquirir.setOnClickListener(clickListener);
        ivClose.setOnClickListener(this);
    }

    public void setClickListener(View.OnClickListener clickListener) {
        this.clickListener = clickListener;
    }

    private void setInfo(String titulo,
                         String nombre,
                         String descripcion,
                         String servicios,
                         String costo){
        tvTitulo.setText(titulo);
        tvNombre.setText(nombre);
        tvDescripcion.setText(descripcion);
        tvServicios.setText(servicios);
        tvCosto.setText(costo);
    }

    private String getServicios(String[] array){
        StringBuilder stringBuilder = new StringBuilder();

        for (String c:array) {
            stringBuilder.append(c).append("\n");
        }
        return stringBuilder.toString();
    }

    public void setDetalleNum(int detalleNum) {
        this.detalleNum = detalleNum;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        dismiss();
    }
}
