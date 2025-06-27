package com.igor.gaseta.controller;

import android.content.SharedPreferences;

import com.igor.gaseta.CombustivelDAO.CombustivelDAO;
import com.igor.gaseta.model.Combustivel;
import com.igor.gaseta.view.MainActivity;

public class Controller {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private CombustivelDAO combustivelDAO;
    private static final String NOME_PREFERENCES = "GASETA";
    public Controller(MainActivity mainActivity) {
        combustivelDAO = new CombustivelDAO(mainActivity);
        combustivelDAO.open();
        sp = mainActivity.getSharedPreferences(NOME_PREFERENCES,0);
        editor = sp.edit();
    }
    public String CalcularPrecos(Combustivel combustivel){
        double gas = combustivel.getGasolina();
        double eta = combustivel.getEtanol();
        double divisao = eta/gas;
        if(divisao <= 0.70){
            combustivel.setComparacao("Etanol Compensa");
        }
        else{
            combustivel.setComparacao("Gasolina Compensa");
        }
        return combustivel.getComparacao();
    }
    public void Limpar(){
        combustivelDAO.deleteAllCombustiveis();
        editor.clear();
        editor.commit();
    }
    public void Salvar(Combustivel combustivel){
        combustivelDAO.addCombustivel(combustivel.getTextoGas(),combustivel.getTextoEta());
        editor.putString("Gasolina", combustivel.getTextoGas());
        editor.putString("Etanol", combustivel.getTextoEta());
        editor.putString("Comparacao",combustivel.getComparacao());
        editor.commit();
    }
    public Combustivel Buscar(Combustivel combustivel){
        combustivel.setTextoGas(sp.getString("Gasolina","NA"));
        combustivel.setTextoEta(sp.getString("Etanol","NA"));
        combustivel.setComparacao(sp.getString("Comparacao","NA"));
        return combustivel;
    }
    public void Finalizar(){
        combustivelDAO.close();
    }
}
