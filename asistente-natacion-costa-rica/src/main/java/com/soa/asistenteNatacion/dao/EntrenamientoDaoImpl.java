/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soa.asistenteNatacion.dao;

import com.soa.asistenteNatacion.modelos.Entrenamiento;
import com.soa.asistenteNatacion.modelos.Usuario;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.criterion.Restrictions;
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
        LOGGER.info(sessionfactory.toString());
        try {
            sessionfactory.getCurrentSession();
        }
        catch(Exception e) {
            //sessionfactory.openSession();
            LOGGER.info("abri sesion");
        }
        sessionfactory.openSession().saveOrUpdate(entrenamiento);
        LOGGER.info("NO MAMELUCO");
    }
    
    @Override
    public List<Entrenamiento> obtenerEntrenamientos() {
        @SuppressWarnings("unchecked")
        List<Entrenamiento> listaEntrenamientos = sessionfactory.openSession().createCriteria(Entrenamiento.class).list();
        return listaEntrenamientos;
    }
    
    @Override
    public List<Entrenamiento> obtenerEntrenamientos(int idEquipo) {
        List<Entrenamiento> resp;
        Criteria c = sessionfactory.openSession().createCriteria(Entrenamiento.class);
	c.add(Restrictions.eq("id_equipo",idEquipo));
        resp = c.list();
        return resp;
    }
    
    @Override
    public Entrenamiento obtenerEntrenamientoFecha(int idEquipo, Date fecha) {
        Entrenamiento resp;
        Criteria c = sessionfactory.openSession().createCriteria(Entrenamiento.class);
	c.add(Restrictions.eq("id_equipo", idEquipo));
        c.add(Restrictions.eq("fecha", fecha));
        resp = (Entrenamiento)c.uniqueResult();
        return resp;
    }

}
