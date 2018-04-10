package manager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import banque.Adresse;
import banque.AssuranceVie;
import banque.Banque;
import banque.Client;
import banque.Compte;
import banque.LivretA;
import banque.Operation;
import banque.Virement;

public class ApplyBanque {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");

		/** Ajoute a la base une banque / client / compte / opération */
		Adresse adresseA = new Adresse(12, "rue toto", 91230, "TUTUtown");
		Banque banqueA = new Banque("BanqueA");
		Client clientA = new Client("JeanLuc", "Michel", LocalDate.of(1994, 1, 2), adresseA, banqueA);
		Compte compteA = new Compte("A5478B", 250, clientA);
		Operation operation = new Operation(LocalDateTime.of(2018, 4, 1, 18, 25), 500, "Anniversaire", compteA);

		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(banqueA);
		em.persist(clientA);
		em.persist(compteA);
		em.persist(operation);
		et.commit();

		/**
		 * Ajoute a la base une banque / un client / un livretA / une assurance
		 * vie / un virement
		 */
		Adresse adresseC = new Adresse(12, "rue titi", 91230, "TyTytown");
		Banque banqueC = new Banque("BanqueC");
		Client clientC = new Client("JeanMarc", "Philippe", LocalDate.of(1985, 12, 25), adresseC, banqueC);

		Adresse adresseB = new Adresse(18, "rue tutu", 91230, "ToTotown");
		Banque banqueB = new Banque("BanqueB");
		Client clientB = new Client("JeanLouis", "Arthuro", LocalDate.of(1990, 11, 20), adresseB, banqueB);

		Compte compteC = new LivretA("C7418D", 100, clientC, 1.2);
		Compte compteB = new AssuranceVie("FG7584C", -25, clientB, 0.5, LocalDate.of(2020, 12, 31));
		Operation operationC = new Virement(LocalDateTime.of(2018, 3, 1, 15, 18), 68, "Pour le plaisir d'offir",
				compteC, "Jean Mich");

		em = entityManagerFactory.createEntityManager();
		et = em.getTransaction();
		et.begin();
		em.persist(banqueC);
		em.persist(clientC);
		em.persist(compteC);

		em.persist(banqueB);
		em.persist(clientB);
		em.persist(compteB);

		em.persist(operationC);
		et.commit();

		/** ajoute a la base un client / un compte a plusieurs clients */
		Adresse adresseD = new Adresse(25, "rue ploud", 45841, "ploudTown");
		Client clientD = new Client("Jeannette", "Charlotte", LocalDate.of(1985, 12, 25), adresseD, banqueA);
		Set<Client> clients = new HashSet<Client>();
		clients.add(clientA);
		clients.add(clientD);

		Compte compteD = new Compte("GH8457H", 10000, clients);

		em = entityManagerFactory.createEntityManager();
		et = em.getTransaction();

		et.begin();

		em.persist(clientD);
		em.persist(compteD);

		et.commit();

		em.close();
		entityManagerFactory.close();
	}

}
