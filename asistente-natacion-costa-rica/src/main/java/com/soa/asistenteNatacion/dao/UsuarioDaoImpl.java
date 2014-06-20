/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soa.asistenteNatacion.dao;

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
 * @author r.alvarado
 */
@Repository("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {
    
    private final static Logger LOGGER = Logger.getLogger(UsuarioDaoImpl.class.getName());
    @Autowired
    private SessionFactory sessionfactory;

    @Override
    public void guardarUsuario(Usuario usuario) {
        LOGGER.info("antes de mameluquear");
        LOGGER.info(sessionfactory.toString());
        LOGGER.info("antes de mameluquear2");
        try {
            sessionfactory.getCurrentSession();
        }
        catch(Exception e) {
            //sessionfactory.openSession();
            LOGGER.info("abri sesion");
        }
        sessionfactory.openSession().saveOrUpdate(usuario);
        LOGGER.info("NO MAMELUCO");
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        @SuppressWarnings("unchecked")
        List<Usuario> listaUsuarios = sessionfactory.getCurrentSession().createCriteria(Usuario.class).list();
        return listaUsuarios;
    }
}
