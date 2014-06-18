package com.soa.asistenteNatacion.modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author r.alvarado
 */

@Entity
@Table(name = "nadador")
public class Nadador {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellido")
    private String apellido;
    
    @Column(name = "edad")
    private int edad;
    
    @Column(name = "categoria")
    private int categoria;
    
    @Column(name = "especialidad")
    private int especialidad;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public int getCategoria() {
        return categoria;
    }

    public int getEspecialidad() {
        return especialidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public void setEspecialidad(int especialidad) {
        this.especialidad = especialidad;
    }
}