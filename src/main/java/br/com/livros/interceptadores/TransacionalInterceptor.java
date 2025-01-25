package br.com.livros.interceptadores;

import java.io.Serializable;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundConstruct;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Interceptor @Transactional
public class TransacionalInterceptor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager entityManager;
	
	@AroundInvoke
	public Object intercept(InvocationContext context) {
		
		Object resultado = null;
		
		try {
			entityManager.getTransaction().begin();
			
			resultado = context.proceed();
			
			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			
			MensagemUtil.addMensagemDeErro("Erro - ", 
					"Detalhes do erro:" + getClass().getName() +"-" + e.getMessage());
			
			e.printStackTrace();
		}
		
		return resultado;
	}

}
