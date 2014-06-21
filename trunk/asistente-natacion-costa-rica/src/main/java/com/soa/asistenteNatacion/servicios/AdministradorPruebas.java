/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soa.asistenteNatacion.servicios;

import com.soa.asistenteNatacion.modelos.Prueba;
import java.util.List;
/**
 *
 * @author Joseiby Hernandez
 */
public interface AdministradorPruebas{
    public void guardarPrueba(Prueba entrenamiento);
    public List<Prueba> obtenerPruebas();

}
