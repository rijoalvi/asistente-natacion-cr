/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soa.asistenteNatacion.servicios;

import com.soa.asistenteNatacion.modelos.EntrenamientoDTO;
import com.soa.asistenteNatacion.modelos.NadadorDTO;
import com.soa.asistenteNatacion.negocios.Prueba;
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
    @Autowired
    Prueba prueba;

    
    /************************Seccion de consulta de entrenamiento*********************************/
    @RequestMapping(value = "/entrenamiento/fecha",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json",
                    produces = "application/json",
                    consumes = "application/json")
    public ResponseEntity consultaEntrenamiento(HttpServletRequest request, @RequestBody EntrenamientoDTO entrenamientoDTO) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Access-Control-Allow-Origin", "*");
        MultiValueMap<String, String> result = new LinkedMultiValueMap<String, String>();
        result.add("nombre", prueba.hola());
        result.add("id", entrenamientoDTO.getId());

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
    
    /******************************Seccion de consulta de nadador*********************************/
    
    @RequestMapping(value = "/nadador",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json",
                    produces = "application/json",
                    consumes = "application/json")
    public ResponseEntity consultaNadador(HttpServletRequest request, @RequestBody NadadorDTO nadadorDTO) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Access-Control-Allow-Origin", "*");
        MultiValueMap<String, String> result = new LinkedMultiValueMap<String, String>();
        result.add("nombre", nadadorDTO.getName());
        result.add("id", nadadorDTO.getId());

        return new ResponseEntity(result, headers, HttpStatus.OK);
        // model.addAttribute("message", "Spring 3 MVC Hello World");
        //return "hello";
    }

    @RequestMapping(value = "/nadador",
                    method = RequestMethod.GET)
    public ModelAndView descripcionConsultaNadador(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vista_descripcion_servicio");
        modelAndView.addObject("message", "Descripci&oacute;n de c&oacute;mo funciona el m&eacute;todo /nadador");
        return modelAndView;
        // model.addAttribute("message", "Spring 3 MVC Hello World");
        //return "hello";
    }
    /*********************************************************************************************/
    
    /************************Seccion de consulta de nadador por prueba****************************/
    
    @RequestMapping(value = "/nadador/prueba",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json",
                    produces = "application/json",
                    consumes = "application/json")
    public ResponseEntity consultaNadadorPrueba(HttpServletRequest request, @RequestBody NadadorDTO nadadorDTO) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Access-Control-Allow-Origin", "*");
        MultiValueMap<String, String> result = new LinkedMultiValueMap<String, String>();
        result.add("nombre", nadadorDTO.getName());
        result.add("id", nadadorDTO.getId());

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
    }
}
