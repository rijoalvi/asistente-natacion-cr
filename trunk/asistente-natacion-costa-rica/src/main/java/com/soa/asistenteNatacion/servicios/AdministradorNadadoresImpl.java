/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soa.asistenteNatacion.servicios;

import com.soa.asistenteNatacion.dao.NadadorDao;
import com.soa.asistenteNatacion.modelos.Nadador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Joseiby Hernandez
 */

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class AdministradorNadadoresImpl implements AdministradorNadadores{

    @Autowired
    NadadorDao nadadorDao;
    
    @Override
    public void guardarNadador(Nadador nadador) {
        nadadorDao.guardarNadador(nadador);
    }
    
    @Override
    public List<Nadador> obtenerNadadores() {
        return nadadorDao.obtenerNadadores();
    }
}
