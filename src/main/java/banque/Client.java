package banque;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** Représente un client */
@Entity
@Table(name="Client")
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nom", length = 30, nullable = false)
	private String nom;
	@Column(name = "prenom", length = 30, nullable = false)
	private String prenom;
	@Column(name = "date_naissance", nullable = false)
	private LocalDate dateNaissance;

	@Embedded
	private Adresse adresse;

	@ManyToOne
	@JoinColumn(name = "ID_banque")
	private Banque banque;

	
	@ManyToMany
	@JoinTable(name = "Appartenance", joinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID"),
										inverseJoinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "ID"))
	private Set<Compte> compte;

	public Client() {
		compte = new HashSet<Compte>();
	}
	
	public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse, Banque banque){
		this.nom = nom;
		this.prenom=prenom;
		this.dateNaissance=dateNaissance;
		this.adresse=adresse;
		this.banque=banque;
		compte = new HashSet<Compte>();
	}

	/** getter nom */
	public String getNom() {
		return nom;
	}

	/**
	 * setter nom
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** getter prenom */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * setter prenom
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/** getter date de naissance */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * setter date de naissance
	 * 
	 * @param dateNaissance
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/**
	 * @param banque
	 *            the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/**
	 * @return the compte
	 */
	public Set<Compte> getCompte() {
		return compte;
	}

	/**
	 * @param compte the compte to set
	 */
	public void setCompte(Set<Compte> compte) {
		this.compte = compte;
	}

}
