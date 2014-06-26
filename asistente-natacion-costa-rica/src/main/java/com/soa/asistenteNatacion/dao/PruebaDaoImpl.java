/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soa.asistenteNatacion.dao;

import com.soa.asistenteNatacion.modelos.Prueba;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Joseiby Hernandez
 */
@Repository("pruebaDao")
public class PruebaDaoImpl implements PruebaDao{
    
    private final static Logger LOGGER = Logger.getLogger(PruebaDaoImpl.class.getName());
    
    @Autowired
    private SessionFactory sessionfactory;
    
    @Override
    public void guardarPrueba(Prueba prueba) {
        sessionfactory.openSession().saveOrUpdate(prueba);
    }
    
    @Override
    public List<Prueba> obtenerPruebas() {
        @SuppressWarnings("unchecked")
        List<Prueba> lista = sessionfactory.openSession().createCriteria(Prueba.class).list();
        return lista;
    }

}
