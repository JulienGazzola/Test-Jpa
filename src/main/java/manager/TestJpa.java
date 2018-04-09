package manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJpa {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		System.out.println("l'apply se lance");
		
		em.close();
		entityManagerFactory.close();
	}
}
