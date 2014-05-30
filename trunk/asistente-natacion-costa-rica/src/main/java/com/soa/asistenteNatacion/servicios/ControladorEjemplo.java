package com.soa.asistenteNatacion.servicios;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class ControladorEjemplo {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printHello(ModelMap model) {
        ModelAndView modelAndView =  new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("message" , "Spring 3 MVC Hello World");
        return modelAndView;
       // model.addAttribute("message", "Spring 3 MVC Hello World");
        //return "hello";

    }
}
