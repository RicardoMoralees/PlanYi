package com.planyi.planyi.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.planyi.planyi.R;
import com.planyi.planyi.Session;
import com.planyi.planyi.interfaces.ItemClickInterface;
import com.planyi.planyi.models.Proveedor;
import com.planyi.planyi.utils.Constants;

import java.util.List;

public class ProveedorAdapter extends RecyclerView.Adapter<ProveedorAdapter.ViewHolder> {

    private List<Proveedor> proveedores;
    private ItemClickInterface itemClickInterface;
    private Context context;

    public ProveedorAdapter(Context context,List<Proveedor> proveedores, ItemClickInterface clickInterface) {
        this.proveedores = proveedores;
        itemClickInterface = clickInterface;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View view = inflater.inflate(R.layout.item_proveedor, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Proveedor proveedor = proveedores.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickInterface.onItemClicked(proveedor,position);
            }
        });

        switch (proveedor.getProveedorId()){
            case Constants.SALONES:
                if (Session.getInstance().getSalon() == 1){
                    holder.ivLogo.setImageDrawable(context.getDrawable(R.drawable.luxemburgo));
                }else {
                    holder.ivLogo.setImageDrawable(context.getDrawable(R.drawable.via_esperanza));
                }
                holder.ivIcono.setImageDrawable(context.getDrawable(R.drawable.placeholder));
                break;
            case Constants.FLORES:
                if (Session.getInstance().getFlores() == 1){
                    holder.ivLogo.setImageDrawable(context.getDrawable(R.drawable.casablancalogo));
                }else {
                    holder.ivLogo.setImageDrawable(context.getDrawable(R.drawable.floresselogo));
                }
                holder.ivIcono.setImageDrawable(context.getDrawable(R.drawable.flores));
                break;
            case Constants.FOTO:
                if (Session.getInstance().getFoto() == 1){
                    holder.ivLogo.setImageDrawable(context.getDrawable(R.drawable.albertoguadarramalogo));
                }else {
                    holder.ivLogo.setImageDrawable(context.getDrawable(R.drawable.jacobologo));
                }
                holder.ivIcono.setImageDrawable(context.getDrawable(R.drawable.camara));
                break;
            case Constants.BANQUETE:
                if (Session.getInstance().getBanquete() == 1){
                    holder.ivLogo.setImageDrawable(context.getDrawable(R.drawable.banquetesleonlogo));
                }else {
                    holder.ivLogo.setImageDrawable(context.getDrawable(R.drawable.banquetescasablancalogo));
                }
                holder.ivIcono.setImageDrawable(context.getDrawable(R.drawable.banquete));
                break;
            case Constants.TRAJE:
                if (Session.getInstance().getTraje() == 1){
                    holder.ivLogo.setImageDrawable(context.getDrawable(R.drawable.gallegoslogo));
                }else {
                    holder.ivLogo.setImageDrawable(context.getDrawable(R.drawable.dpaullogo));
                }
                holder.ivIcono.setImageDrawable(context.getDrawable(R.drawable.gancho));
                break;
            case Constants.MUSICA:
                if (Session.getInstance().getMusica() == 1){
                    holder.ivLogo.setImageDrawable(context.getDrawable(R.drawable.grupoversatil));
                }else {
                    holder.ivLogo.setImageDrawable(context.getDrawable(R.drawable.cafecafe));
                }
                holder.ivIcono.setImageDrawable(context.getDrawable(R.drawable.musica));
                break;
            case Constants.INVITACIONES:
                if (Session.getInstance().getInvitacion() == 1){
                    holder.ivLogo.setImageDrawable(context.getDrawable(R.drawable.diferlogo));
                }else {
                    holder.ivLogo.setImageDrawable(context.getDrawable(R.drawable.stronkalogo));
                }
                holder.ivIcono.setImageDrawable(context.getDrawable(R.drawable.invitaciones));
                break;
            case Constants.VESTIDOS:
                if (Session.getInstance().getVestido() == 1){
                    holder.ivLogo.setImageDrawable(context.getDrawable(R.drawable.losoyadresslogo));
                }else {
                    holder.ivLogo.setImageDrawable(context.getDrawable(R.drawable.queendresslogo));
                }
                holder.ivIcono.setImageDrawable(context.getDrawable(R.drawable.vestido));
                break;
        }

    }

    @Override
    public int getItemCount() {
        return proveedores.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivLogo, ivIcono;

        public ViewHolder(View itemView) {
            super(itemView);

            ivIcono = itemView.findViewById(R.id.iv_icono_proveedor);
            ivLogo = itemView.findViewById(R.id.iv_proveedor);
        }
    }
}
