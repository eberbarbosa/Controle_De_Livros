package br.com.livros.fabricas;

import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;



public class FabricaDeNavigationHandler {
	
	@Inject
	FacesContext facesContext;
	
	@Produces 
	@RequestScoped
	public NavigationHandler criarNavigationHandler() {
		
		if(facesContext != null) {
			Application application = facesContext.getApplication();
				if(application != null) {
					return application.getNavigationHandler();
				}
		}
		
		return null;
	}

}
