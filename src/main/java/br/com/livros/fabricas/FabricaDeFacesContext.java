package br.com.livros.fabricas;

import javax.faces.context.FacesContext;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;

public class FabricaDeFacesContext {
	
	public FabricaDeFacesContext() {
		
	}
	
	@Produces
	@RequestScoped
	public FacesContext criarFacesContext() {
		
		return FacesContext.getCurrentInstance();
	}

}
