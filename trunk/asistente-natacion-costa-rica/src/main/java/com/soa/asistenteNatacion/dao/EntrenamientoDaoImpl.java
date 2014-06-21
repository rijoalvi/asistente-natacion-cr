/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soa.asistenteNatacion.dao;

import com.soa.asistenteNatacion.modelos.Entrenamiento;
import com.soa.asistenteNatacion.modelos.Usuario;
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
@Repository("entrenamientoDao")
public class EntrenamientoDaoImpl implements EntrenamientoDao{
    
    private final static Logger LOGGER = Logger.getLogger(EntrenamientoDaoImpl.class.getName());
    
    @Autowired
    private SessionFactory sessionfactory;
    
    @Override
    public void guardarEntrenamiento(Entrenamiento entrenamiento) {
        sessionfactory.getCurrentSession().saveOrUpdate(entrenamiento);
    }
    
        @Override
    public List<Entrenamiento> obtenerEntrenamientos() {
        @SuppressWarnings("unchecked")
        List<Entrenamiento> listaEntrenamientos = sessionfactory.getCurrentSession().createCriteria(Entrenamiento.class).list();
        return listaEntrenamientos;
    }

}
