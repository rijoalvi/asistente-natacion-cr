/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soa.asistenteNatacion.servicios;

import com.soa.asistenteNatacion.modelos.Tiempo;
import java.util.List;
/**
 *
 * @author Joseiby Hernandez
 */
public interface AdministradorTiempos{
    public void guardarTiempo(Tiempo tiempo);
    public List<Tiempo> obtenerTiempos();

}
