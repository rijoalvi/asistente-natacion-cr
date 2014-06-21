/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soa.asistenteNatacion.dao;

import com.soa.asistenteNatacion.modelos.Tiempo;

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
@Repository("tiempoDao")
public class TiempoDaoImpl implements TiempoDao{
    
    private final static Logger LOGGER = Logger.getLogger(TiempoDaoImpl.class.getName());
    
    @Autowired
    private SessionFactory sessionfactory;
    
    @Override
    public void guardarTiempo(Tiempo tiempo) {
        sessionfactory.getCurrentSession().saveOrUpdate(tiempo);
    }
    
        @Override
    public List<Tiempo> obtenerTiempos() {
        @SuppressWarnings("unchecked")
        List<Tiempo> lista = sessionfactory.getCurrentSession().createCriteria(Tiempo.class).list();
        return lista;
    }

}
