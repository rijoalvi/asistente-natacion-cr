/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soa.asistenteNatacion.dao;

import com.soa.asistenteNatacion.modelos.Entrenamiento;
import java.util.List;
/**
 *
 * @author Joseiby Hernandez
 */
public interface EntrenamientoDao {
    
    public void guardarEntrenamiento(Entrenamiento entrenamiento);
    public List<Entrenamiento> obtenerEntrenamientos();
}
