/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soa.asistenteNatacion.dao;
import com.soa.asistenteNatacion.modelos.Equipo;
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
@Repository("equipoDao")
public class EquipoDaoImpl implements EquipoDao{
    
    private final static Logger LOGGER = Logger.getLogger(EquipoDaoImpl.class.getName());
    
    @Autowired
    private SessionFactory sessionfactory;
    
    @Override
    public List<Equipo> obtenerEquipos() {
        @SuppressWarnings("unchecked")
        List<Equipo> listaEquipos = sessionfactory.openSession().createCriteria(Equipo.class).list();
        return listaEquipos;
    }

    @Override
    public void guardarEquipo(Equipo equipo) {
        sessionfactory.openSession().saveOrUpdate(equipo);
    }

}