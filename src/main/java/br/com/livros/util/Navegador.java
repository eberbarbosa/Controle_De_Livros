package br.com.livros.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;

import jakarta.inject.Inject;

public class Navegador {
	
	@Inject
	private NavigationHandler navigationHandler;
	@Inject
	private FacesContext      facesContext;
	
	public void redirecionar(String url) {
		
		navigationHandler.handleNavigation(facesContext, null, url  + "?faces-redirect=true");
		facesContext.renderResponse();
	}


}
