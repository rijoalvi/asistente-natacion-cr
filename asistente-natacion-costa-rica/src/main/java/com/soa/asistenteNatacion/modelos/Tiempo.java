/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soa.asistenteNatacion.modelos;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rijoalvi
 */

@Entity
@Table(name = "tiempo")
public class Tiempo {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_prueba")
    private int id_prueba;
    
    @Column(name = "id_nadador")
    private int id_nadador;
    
    @Column(name = "tiempo")
    private Date tiempo;

    public int getId() {
        return id;
    }

    public int getId_prueba() {
        return id_prueba;
    }

    public int getId_nadador() {
        return id_nadador;
    }

    public Date getTiempo() {
        return tiempo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_prueba(int id_prueba) {
        this.id_prueba = id_prueba;
    }

    public void setId_nadador(int id_nadador) {
        this.id_nadador = id_nadador;
    }

    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }
}
