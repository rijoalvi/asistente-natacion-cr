/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soa.asistenteNatacion.servicios;

import com.soa.asistenteNatacion.dao.UsuarioDao;
import com.soa.asistenteNatacion.modelos.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rijoalvi
 */

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class AdministradorUsuariosImpl implements AdministradorUsuarios{

    @Autowired
    UsuarioDao usuarioDao;
    
    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioDao.guardarUsuario(usuario);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuarioDao.obtenerUsuarios();
    }
    
}
