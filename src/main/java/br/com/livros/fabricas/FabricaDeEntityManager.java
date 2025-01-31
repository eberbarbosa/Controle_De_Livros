package br.com.livros.fabricas;



import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@ApplicationScoped
public class FabricaDeEntityManager {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("bibliotecaPersistence");
	
	@Produces @RequestScoped
	public EntityManager criarEntityManager() {
		
		return factory.createEntityManager();
	}
	
	public void fecharEntityManager(@Disposes EntityManager manager) {
		
		manager.close();
	}
	
	
	
	

}
