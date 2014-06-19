/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soa.asistenteNatacion.dao;

import com.soa.asistenteNatacion.modelos.Usuario;
import java.util.List;

/**
 *
 * @author r.alvarado
 */
public interface UsuarioDao {
    
    public void guardarUsuario(Usuario usuario);
    public List<Usuario> obtenerUsuarios();
    
}
