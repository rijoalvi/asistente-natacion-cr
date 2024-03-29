/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soa.asistenteNatacion.servicios;

import com.soa.asistenteNatacion.dao.EntrenamientoDao;
import com.soa.asistenteNatacion.dao.PruebaDao;
import com.soa.asistenteNatacion.modelos.Entrenamiento;
import com.soa.asistenteNatacion.modelos.Prueba;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Joseiby Hernandez
 */

@Service("administradorPruebas")
@Transactional
public class AdministradorPruebasImpl implements AdministradorPruebas{

    @Autowired
    PruebaDao pruebaDao;
    
    @Autowired
    EntrenamientoDao entrenamientoDao;
    
    @Override
    @Transactional(readOnly = true)
    public void guardarPrueba(Prueba prueba) {
        pruebaDao.guardarPrueba(prueba);
    }
    
    @Override
    public List<Prueba> obtenerPruebas() {
        return pruebaDao.obtenerPruebas();
    }
    
    @Override
    public List<Prueba> obtenerPruebas(int idEquipo, Date fecha) {
        Entrenamiento entreno = entrenamientoDao.obtenerEntrenamientoFecha(idEquipo, fecha);
        List<Prueba> resp = null;
        if (entreno != null) {
            resp = pruebaDao.obtenerPruebas(entreno.getId());
        }
        return resp;
    }
}
