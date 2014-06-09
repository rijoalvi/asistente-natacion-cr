package com.soa.asistenteNatacion.modelos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author r.alvarado
 */
public class Entrenamiento implements Serializable{
    
    private String id;
    private String id_equipo;
    private Date fecha;
    private Prueba[] pruebas;

    public Entrenamiento(String id, String id_equipo, Date fecha, Prueba[] pruebas) {
        this.id = id;
        this.id_equipo = id_equipo;
        this.fecha = fecha;
        this.pruebas = pruebas;
    }

    public String getId() {
        return id;
    }

    public String getId_equipo() {
        return id_equipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public Prueba[] getPruebas() {
        return pruebas;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setId_equipo(String id_equipo) {
        this.id_equipo = id_equipo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setPruebas(Prueba[] pruebas) {
        this.pruebas = pruebas;
    }

    @Override
    public String toString() {
        return "Entrenamiento{" + "id=" + id + ", id_equipo=" + id_equipo + ", fecha=" + fecha + ", pruebas=" + pruebas + '}';
    }
    
}