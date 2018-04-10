package manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Bibliothèque.Client;
import Bibliothèque.Emprunt;
import Bibliothèque.Livre;

public class ApplyBibliotheque {

	private static final Logger LOG = LoggerFactory.getLogger(ApplyBibliotheque.class);

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();

		Livre livre = em.find(Livre.class, 1);
		if (livre != null) {
			LOG.info(livre.getTitre());
			LOG.info(livre.getAuteur());
		}

		TypedQuery<Livre> query = em.createQuery("SELECT l FROM Livre l WHERE l.titre = 'Germinal'", Livre.class);
		Livre livre2 = query.getResultList().get(0);
		if (livre2 != null) {
			LOG.info(livre2.getTitre());
			LOG.info(livre2.getAuteur());
		}

		Emprunt emprunt = em.find(Emprunt.class, 2);
		if (emprunt != null) {
			for (Livre l : emprunt.getLivre()) {
				LOG.info(l.toString());
			}
		}

		Client client = em.find(Client.class, 1);
		if (client != null) {
			for (Emprunt e : client.getEmprunt()) {
				LOG.info(e.toString());
			}
		}

		em.close();
		entityManagerFactory.close();
	}
}
