package com.planyi.planyi.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.planyi.planyi.Planyi;
import com.planyi.planyi.R;
import com.planyi.planyi.Session;
import com.planyi.planyi.adapters.ProveedorAdapter;
import com.planyi.planyi.dialogs.InfoProveedorDialog;
import com.planyi.planyi.interfaces.ItemClickInterface;
import com.planyi.planyi.models.Proveedor;
import com.planyi.planyi.utils.Constants;
import com.shrikanthravi.collapsiblecalendarview.data.Day;
import com.shrikanthravi.collapsiblecalendarview.widget.CollapsibleCalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import cn.iwgang.countdownview.CountdownView;

public class PerfilFragment extends Fragment implements CollapsibleCalendar.CalendarListener, ItemClickInterface, View.OnClickListener {


    private TextView tvNombre, tvRol;
    private CountdownView countDownClock;
    private CollapsibleCalendar calendarView;
    private RecyclerView rvProveedores;
    private RecyclerView.Adapter proveedoresAdapter;
    private InfoProveedorDialog infoProveedorDialog;
    private Day day;
    private Context context;

    private List<Proveedor> proveedores;

    public PerfilFragment() {
        // Required empty public constructor
    }

    public static PerfilFragment newInstance() {
        PerfilFragment fragment = new PerfilFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getProveedores();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        setViews(view);
        return view;
    }

    public void setViews(View view) {
        tvNombre = view.findViewById(R.id.tv_perfil_nombre);
        tvRol = view.findViewById(R.id.tv_perfil_rol);
        calendarView = view.findViewById(R.id.calendarView);
        countDownClock = view.findViewById(R.id.countdown);
        rvProveedores = view.findViewById(R.id.rv_proveedores);
        proveedoresAdapter = new ProveedorAdapter(getContext(),proveedores,this);
        Calendar calendar = GregorianCalendar.getInstance();
        day = new Day(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));

        tvNombre.setText(Session.getInstance().getName());
        tvRol.setText(Session.getInstance().getRol());
        countDownClock.start(0);
        calendarView.setCalendarListener(this);
        calendarView.setOnClickListener(this);
        LinearLayoutManager linearLayout = new LinearLayoutManager(getContext());
        linearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvProveedores.setLayoutManager(linearLayout);
        rvProveedores.setAdapter(proveedoresAdapter);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDaySelect() {
        //countDownClock.stop();
        long tiempo =  new GregorianCalendar(day.getYear(),day.getMonth(),day.getDay()).getTimeInMillis() - System.currentTimeMillis();
        if (tiempo < 0){
            tiempo = 0;
        }
        //countDownClock.updateShow(tiempo);
        countDownClock.start(tiempo);

    }

    @Override
    public void onItemClick(View v) {
        if (!Session.getInstance().getEventoReservado()){
            day = calendarView.getSelectedDay();
            calendarView.select(day);
        }else {
            calendarView.select(day);
        }
    }

    @Override
    public void onDataUpdate() {
    }

    @Override
    public void onMonthChange() {

    }

    @Override
    public void onWeekChange(int position) {

    }

    private void showInfoProveedorDialog(Proveedor proveedor, int pos) {
        if (infoProveedorDialog != null){
            infoProveedorDialog.setProveedor(proveedor);
            infoProveedorDialog.setContext(getContext());
            infoProveedorDialog.show(getFragmentManager(),"InfoProveedorDialog");
        } else {
            infoProveedorDialog = InfoProveedorDialog.create();
            showInfoProveedorDialog(proveedor,pos);
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        day = new Day(Session.getInstance().getYear(),Session.getInstance().getMes(),Session.getInstance().getDia());
        calendarView.select(day);

    }

    @Override
    public void onPause() {
        super.onPause();
        Session.getInstance().saveDia(day.getDay());
        Session.getInstance().saveMes(day.getMonth());
        Session.getInstance().saveYear(day.getYear());
    }

    @Override
    public void onItemClicked(Proveedor proveedor, int position) {
        showInfoProveedorDialog(proveedor,position);
    }

    private void getProveedores(){

        proveedores = new ArrayList<>();

        if (Session.getInstance().getSalon() != 0){
            if (Session.getInstance().getSalon() == 1){
                Proveedor proveedor = new Proveedor(Constants.SALONES,context.getString(R.string.salon_1),150000);
                proveedores.add(proveedor);
            }else {
                Proveedor proveedor = new Proveedor(Constants.SALONES,context.getString(R.string.salon_2),120000);
                proveedores.add(proveedor);
            }
        }
        if (Session.getInstance().getFlores() != 0){
            if (Session.getInstance().getFlores() == 1){
                Proveedor proveedor = new Proveedor(Constants.FLORES,context.getString(R.string.floreria_1),8000);
                proveedores.add(proveedor);
            }else {
                Proveedor proveedor = new Proveedor(Constants.FLORES,context.getString(R.string.floreria_2),9500);
                proveedores.add(proveedor);
            }
        }
        if (Session.getInstance().getFoto() != 0){
            if (Session.getInstance().getFoto() == 1){
                Proveedor proveedor = new Proveedor(Constants.FOTO,context.getString(R.string.foto1),1500);
                proveedores.add(proveedor);
            }else {
                Proveedor proveedor = new Proveedor(Constants.FOTO,context.getString(R.string.foto2),4500);
                proveedores.add(proveedor);
            }
        }
        if (Session.getInstance().getBanquete() != 0){
            if (Session.getInstance().getBanquete() == 1){
                Proveedor proveedor = new Proveedor(Constants.BANQUETE,context.getString(R.string.banquete_1),15000);
                proveedores.add(proveedor);
            }else {
                Proveedor proveedor = new Proveedor(Constants.BANQUETE,context.getString(R.string.banquete_2),15500);
                proveedores.add(proveedor);
            }
        }
        if (Session.getInstance().getTraje() != 0){
            if (Session.getInstance().getTraje() == 1){
                Proveedor proveedor = new Proveedor(Constants.TRAJE,context.getString(R.string.trajes1),390);
                proveedores.add(proveedor);
            }else {
                Proveedor proveedor = new Proveedor(Constants.TRAJE,context.getString(R.string.trajes2),1150);
                proveedores.add(proveedor);
            }
        }
        if (Session.getInstance().getMusica() != 0){
            if (Session.getInstance().getMusica() == 1){
                Proveedor proveedor = new Proveedor(Constants.MUSICA,context.getString(R.string.musica1),60000);
                proveedores.add(proveedor);
            }else {
                Proveedor proveedor = new Proveedor(Constants.MUSICA,context.getString(R.string.musica2),65000);
                proveedores.add(proveedor);
            }
        }
        if (Session.getInstance().getInvitacion() != 0){
            if (Session.getInstance().getInvitacion() == 1){
                Proveedor proveedor = new Proveedor(Constants.INVITACIONES,context.getString(R.string.invitaciones1),43);
                proveedores.add(proveedor);
            }else {
                Proveedor proveedor = new Proveedor(Constants.INVITACIONES,context.getString(R.string.invitaciones2),26);
                proveedores.add(proveedor);
            }
        }
        if (Session.getInstance().getVestido() != 0){
            if (Session.getInstance().getVestido() == 1){
                Proveedor proveedor = new Proveedor(Constants.VESTIDOS,context.getString(R.string.vestidos1),500);
                proveedores.add(proveedor);
            }else {
                Proveedor proveedor = new Proveedor(Constants.VESTIDOS,context.getString(R.string.vestidos2),800);
                proveedores.add(proveedor);
            }
        }
    }

    public int getTotal(){
        getProveedores();
        int suma = 0;
        for (Proveedor p : proveedores){
            suma += p.getPrecio();
        }
        return suma;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        if (Session.getInstance().getEventoReservado()){

        }
    }
}
