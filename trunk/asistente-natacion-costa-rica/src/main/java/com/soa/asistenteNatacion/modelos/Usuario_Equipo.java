/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soa.asistenteNatacion.modelos;

import java.io.Serializable;
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
@Table(name = "usuario_equipo")
public class Usuario_Equipo implements Serializable{
    
    @Id
    @Column(name = "id_equipo")
    private int id_equipo;
    
    @Id
    @Column(name = "id_usuario")
    private int id_usuario;

    public int getId_equipo() {
        return id_equipo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}
