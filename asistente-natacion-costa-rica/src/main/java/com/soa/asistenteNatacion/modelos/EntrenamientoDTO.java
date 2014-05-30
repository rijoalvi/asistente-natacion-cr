package com.soa.asistenteNatacion.modelos;

import java.io.Serializable;

/**
 *
 * @author r.alvarado
 */
public class EntrenamientoDTO implements Serializable{
    
    private String name; 
    private String id; 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String toString(){
        return "\n\n" +
               "Name     "  + getName()+ "\n" +
               "id       "  + getId()       + "\n" ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}