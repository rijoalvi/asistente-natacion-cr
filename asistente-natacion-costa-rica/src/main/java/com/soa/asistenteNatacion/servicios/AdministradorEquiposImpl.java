/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soa.asistenteNatacion.servicios;

import com.soa.asistenteNatacion.dao.EquipoDao;
import com.soa.asistenteNatacion.modelos.Equipo;
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
public class AdministradorEquiposImpl implements AdministradorEquipos{

    @Autowired
    EquipoDao equipoDao;
    
    @Override
    public void guardarEquipo(Equipo equipo) {
        equipoDao.guardarEquipo(equipo);
    }
    
    @Override
    public List<Equipo> obtenerEquipos() {
        return equipoDao.obtenerEquipos();
    }
    
    @Override
    public List<Equipo> obtenerEquipos(int idUsuario) {
        return equipoDao.obtenerEquipos(idUsuario);
    }
}
