package com.heron.cadpessoas.cadpessoas_heron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InicioController {

    @RequestMapping("/")
    public String redirect(){
        return "redirect:/inicio";
    }

    @RequestMapping("/inicio")
    public ModelAndView inicio(){
        return new ModelAndView("index");
    }

}
