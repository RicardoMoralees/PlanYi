package com.planyi.planyi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {

    private static Session instance;
    private SharedPreferences pref;

    private final String PREF_NAME = "NOMBRE";
    private final String PREF_EMAIL = "EMAIL";
    private final String PREF_CONTRA = "CONTRA";
    private final String PREF_ROL = "ROL";
    private final String PREF_DIA = "DIA";
    private final String PREF_MES = "MES";
    private final String PREF_ANO = "ANO";

    private final String ACTUAL_TAB = "ACTUAL_TAB";

    private final String SALON_SELEC = "SALON";
    private final String FLORES_SELEC = "FLORES";
    private final String FOTO_SELEC = "FOTO";
    private final String BANQUETE_SELEC = "BANQUETE";
    private final String TRAJE_SELEC = "TRAJE";
    private final String MUSICA_SELEC = "MUSICA";
    private final String INVITACION_SELEC = "INVITACION";
    private final String VESTIDOS_SELEC = "VESTIDOS";

    private final String EVENTO_RESERVADO = "EVENTO_RESERVADO";

    private Session() {
        super();
    }

    public static Session getInstance(){
        if (instance == null){
            instance = new Session();
        }
        return instance;
    }

    public void init(Context context) {
        pref = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void saveName(String nombre){
        pref.edit().putString(PREF_NAME, nombre).apply();
    }

    public String getName(){
        return pref.getString(PREF_NAME, "Invitado");
    }

    public void saveEmail(String email){
        pref.edit().putString(PREF_EMAIL, email).apply();
    }

    public String getEmail(){
        return pref.getString(PREF_EMAIL, "");
    }

    public void saveContra(String contra){
        pref.edit().putString(PREF_CONTRA, contra).apply();
    }

    public String getContra(){
        return pref.getString(PREF_CONTRA, "");
    }

    public void saveRol(String rol){
        pref.edit().putString(PREF_ROL, rol).apply();
    }

    public String getRol(){
        return pref.getString(PREF_ROL,"Sin rol");
    }

    public void saveYear(int year){
        pref.edit().putInt(PREF_ANO, year).apply();
    }

    public int getYear(){
        return pref.getInt(PREF_ANO,2019);
    }

    public void saveMes(int mes){
        pref.edit().putInt(PREF_MES, mes).apply();
    }

    public int getMes(){
        return pref.getInt(PREF_MES,1);
    }

    public void saveDia(int dia){
        pref.edit().putInt(PREF_DIA, dia).apply();
    }

    public int getDia(){
        return pref.getInt(PREF_DIA,1);
    }


    public void saveSalon(int selec){
        pref.edit().putInt(SALON_SELEC, selec).apply();
    }

    public int getSalon(){
        return pref.getInt(SALON_SELEC,0);
    }

    public void saveFlores(int selec){
        pref.edit().putInt(FLORES_SELEC, selec).apply();
    }

    public int getFlores(){
        return pref.getInt(FLORES_SELEC,0);
    }

    public void saveFoto(int selec){
        pref.edit().putInt(FOTO_SELEC, selec).apply();
    }

    public int getFoto(){
        return pref.getInt(FOTO_SELEC,0);
    }

    public void saveBanquete(int selec){
        pref.edit().putInt(BANQUETE_SELEC, selec).apply();
    }

    public int getBanquete(){
        return pref.getInt(BANQUETE_SELEC,0);
    }

    public void saveTraje(int selec){
        pref.edit().putInt(TRAJE_SELEC, selec).apply();
    }

    public int getTraje(){
        return pref.getInt(TRAJE_SELEC,0);
    }

    public void saveMusica(int selec){
        pref.edit().putInt(MUSICA_SELEC, selec).apply();
    }

    public int getMusica(){
        return pref.getInt(MUSICA_SELEC,0);
    }

    public void saveInvitacion(int selec){
        pref.edit().putInt(INVITACION_SELEC, selec).apply();
    }

    public int getInvitacion(){
        return pref.getInt(INVITACION_SELEC,0);
    }

    public void saveVestido(int selec){
        pref.edit().putInt(VESTIDOS_SELEC, selec).apply();
    }

    public int getVestido(){
        return pref.getInt(VESTIDOS_SELEC,0);
    }

    public void saveActualTab(int selec){
        pref.edit().putInt(ACTUAL_TAB, selec).apply();
    }

    public int getActualTab(){
        return pref.getInt(ACTUAL_TAB,1);
    }

    public void saveEventoReservado(boolean reservado){
        pref.edit().putBoolean(EVENTO_RESERVADO, reservado).apply();
    }

    public boolean getEventoReservado(){
        return pref.getBoolean(EVENTO_RESERVADO,false);
    }

    public void cerrarSesion(){
        pref.edit().clear().apply();
    }
}
