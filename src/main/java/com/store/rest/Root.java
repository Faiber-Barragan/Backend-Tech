package com.store.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Root {
	
	@RequestMapping("/")
	public String guardarProducto() {
	    return "😄😄😄😄😄 Bienvenido a la API ONLINE STORE 😄😄😄😄😄";
	}
	
	@RequestMapping("/documetacion")
	public ModelAndView redirigirDocumentacion() {
		return new ModelAndView("redirect:https://documenter.getpostman.com/view/3388013/TzCV4QRt");
	}
	
}
