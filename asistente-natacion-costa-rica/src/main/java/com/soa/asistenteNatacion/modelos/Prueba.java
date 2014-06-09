/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soa.asistenteNatacion.modelos;

/**
 *
 * @author rijoalvi
 */
public class Prueba {
    private int distancia;
    private String estilo;
    private int consecutivo;

    public Prueba(int distancia, String estilo, int consecutivo) {
        this.distancia = distancia;
        this.estilo = estilo;
        this.consecutivo = consecutivo;
    }

    public int getDistancia() {
        return distancia;
    }

    public String getEstilo() {
        return estilo;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    @Override
    public String toString() {
        return "Prueba{" + "distancia=" + distancia + ", estilo=" + estilo + ", consecutivo=" + consecutivo + '}';
    }
    
}
