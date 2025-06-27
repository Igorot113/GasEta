package com.igor.gaseta.model;

public class Combustivel {
    private double Gasolina;
    private double Etanol;
    private long id;
    private String Comparacao;
    private String TextoGas;
    private String TextoEta;
    public Combustivel(){}
    public Combustivel(long id, String textoGas, String textoEta) {
        this.id = id;
        TextoGas = textoGas;
        TextoEta = textoEta;
    }
    public Combustivel(double gasolina, double etanol){
        Gasolina = gasolina;
        Etanol = etanol;
    }
    public Combustivel(double gasolina, double etanol,String textoGas, String textoEta) {
        Gasolina = gasolina;
        Etanol = etanol;
        TextoGas = textoGas;
        TextoEta = textoEta;
    }
    public double getGasolina() { return Gasolina; }
    public double getEtanol() {
        return Etanol;
    }
    public String getComparacao() { return  Comparacao; }
    public void setComparacao(String comparacao) { Comparacao = comparacao; }
    public String getTextoGas() { return TextoGas; }
    public String getTextoEta() { return TextoEta; }
    public void setTextoGas(String textoGas) { TextoGas = textoGas; }
    public void setTextoEta(String textoEta) { TextoEta = textoEta; }
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
}
