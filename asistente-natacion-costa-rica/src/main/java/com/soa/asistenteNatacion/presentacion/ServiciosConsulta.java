/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soa.asistenteNatacion.presentacion;

import com.soa.asistenteNatacion.modelos.Entrenamiento;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author r.alvarado
 */
@Controller
@RequestMapping("/consulta")
public class ServiciosConsulta {

    private final static Logger LOGGER = Logger.getLogger(ServiciosConsulta.class.getName());

    
    /************************Seccion de consulta de entrenamiento*********************************/
    @RequestMapping(value = "/entrenamiento/fecha",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json",
                    produces = "application/json",
                    consumes = "application/json")
    public ResponseEntity consultaEntrenamiento(HttpServletRequest request, @RequestBody Entrenamiento entrenamiento) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Access-Control-Allow-Origin", "*");
        MultiValueMap<String, String> result = new LinkedMultiValueMap<String, String>();
        result.add("id",  Integer.toString(entrenamiento.getId()));

        return new ResponseEntity(result, headers, HttpStatus.OK);
        // model.addAttribute("message", "Spring 3 MVC Hello World");
        //return "hello";
    }

    @RequestMapping(value = "/entrenamiento/fecha",
                    method = RequestMethod.GET)
    public ModelAndView descripcionConsultaEntrenamiento(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vista_descripcion_servicio");
        modelAndView.addObject("message", "Descripci&oacute;n de c&oacute;mo funciona el m&eacute;todo/entrenamiento/fecha");
        return modelAndView;
        // model.addAttribute("message", "Spring 3 MVC Hello World");
        //return "hello";
    }
    /*********************************************************************************************/
    
    /************************Seccion de consulta de nadador por prueba****************************/
   /* 
    @RequestMapping(value = "/nadador/prueba",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json",
                    produces = "application/json",
                    consumes = "application/json")
    public ResponseEntity consultaNadadorPrueba(HttpServletRequest request, @RequestBody Nadador nadador) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Access-Control-Allow-Origin", "*");
        MultiValueMap<String, String> result = new LinkedMultiValueMap<String, String>();
        result.add("nombre", nadador.getNombre());
        result.add("id", Integer.toString(nadador.getId()));

        return new ResponseEntity(result, headers, HttpStatus.OK);
        // model.addAttribute("message", "Spring 3 MVC Hello World");
        //return "hello";
    }

    @RequestMapping(value = "/nadador/prueba",
                    method = RequestMethod.GET)
    public ModelAndView descripcionConsultaNadadorPrueba(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vista_descripcion_servicio");
        modelAndView.addObject("message", "Descripci&oacute;n de c&oacute;mo funciona el m&eacute;todo /nadador/prueba");
        return modelAndView;
        // model.addAttribute("message", "Spring 3 MVC Hello World");
        //return "hello";
    }*/
}
