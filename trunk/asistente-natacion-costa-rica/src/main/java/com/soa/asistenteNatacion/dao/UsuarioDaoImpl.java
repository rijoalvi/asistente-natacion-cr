/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soa.asistenteNatacion.dao;

import com.soa.asistenteNatacion.modelos.Usuario;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author r.alvarado
 */
@Repository("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

    @Autowired
    private SessionFactory sessionfactory;
    
    @Override
    public void guardarUsuario(Usuario usuario) {
        sessionfactory.getCurrentSession().saveOrUpdate(usuario);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        @SuppressWarnings("unchecked")
	List<Usuario> listaUsuarios = sessionfactory.getCurrentSession().createCriteria(Usuario.class).list();
	return listaUsuarios;
    }

}
