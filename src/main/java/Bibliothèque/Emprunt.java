package Bibliothèque;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** Représente un Emprunt */
@Entity
@Table(name = "emprunt")
public class Emprunt {
	@Id
	private Integer id;

	@Column(name = "DATE_DEBUT", nullable = false)
	private LocalDate debut;

	@Column(name = "DATE_FIN", nullable = false)
	private LocalDate fin;

	@Column(name = "DELAI", nullable = false)
	private int delai;

	@ManyToOne
	@JoinColumn(name = "ID_CLIENT")
	private Client client;

	@ManyToMany
	@JoinTable(name = "compo", joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"))
	private Set<Livre> livre;

	/** Constructeur par default */
	public Emprunt() {
		livre = new HashSet<Livre>();
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

	/** Getter debut */
	public LocalDate getDebut() {
		return debut;
	}

	/**
	 * Setter debut
	 * 
	 * @param debut
	 */
	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}

	/** Getter fin */
	public LocalDate getFin() {
		return fin;
	}

	/**
	 * Setter fin
	 * 
	 * @param fin
	 */
	public void setPrenom(LocalDate fin) {
		this.fin = fin;
	}

	/** Getter livre */
	public Set<Livre> getLivre() {
		return livre;
	}

	/**
	 * Setter livre
	 * 
	 * @param livre
	 */
	public void setLivre(Set<Livre> livre) {
		this.livre = livre;
	}

}