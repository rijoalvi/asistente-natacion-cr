/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soa.asistenteNatacion.servicios;

import com.soa.asistenteNatacion.dao.PruebaDao;
import com.soa.asistenteNatacion.modelos.Prueba;
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
    
    @Override
    @Transactional(readOnly = true)
    public void guardarPrueba(Prueba prueba) {
        pruebaDao.guardarPrueba(prueba);
    }
    
    @Override
    public List<Prueba> obtenerPruebas() {
        return pruebaDao.obtenerPruebas();
    }
}
