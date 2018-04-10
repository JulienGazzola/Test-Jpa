package Bibliothèque;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** Représente un Client */
@Entity
@Table(name = "client")
public class Client {
	@Id
	private Integer id;

	@Column(name = "NOM", length = 30, nullable = false)
	private String nom;

	@Column(name = "PRENOM", length = 30, nullable = false)
	private String prenom;

	@OneToMany(mappedBy = "client")
	private Set<Emprunt> emprunt;

	/** Constructeur par default */
	public Client() {
		emprunt = new HashSet<Emprunt>();
	}

	/** Getter ID */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter ID
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/** Getter Nom */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter Nom
	 * 
	 * @param Nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getter Prenom */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter Prenom
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/** Getter emprunt */
	public Set<Emprunt> getEmprunt() {
		return emprunt;
	}

	/**
	 * Setter emprunt
	 * 
	 * @param emprunt
	 */
	public void setEmprunt(Set<Emprunt> emprunt) {
		this.emprunt = emprunt;
	}
}
