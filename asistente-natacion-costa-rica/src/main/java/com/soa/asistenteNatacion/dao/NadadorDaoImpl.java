/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soa.asistenteNatacion.dao;

import com.soa.asistenteNatacion.modelos.Nadador;
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
@Repository("nadadorDao")
public class NadadorDaoImpl implements NadadorDao{
    
    private final static Logger LOGGER = Logger.getLogger(NadadorDaoImpl.class.getName());
    
    @Autowired
    private SessionFactory sessionfactory;
    
    @Override
    public void guardarNadador(Nadador nadador) {
        sessionfactory.openSession().saveOrUpdate(nadador);
    }
    
    @Override
    public List<Nadador> obtenerNadadores() {
        @SuppressWarnings("unchecked")
        List<Nadador> lista = sessionfactory.openSession().createCriteria(Nadador.class).list();
        return lista;
    }

}
