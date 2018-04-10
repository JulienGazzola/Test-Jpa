package Bibliothèque;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/** Représente un livre */
@Entity
@Table(name = "livre")
public class Livre {
	@Id
	private Integer id;
	
	@Column(name = "TITRE", length = 30, nullable = false)
	private String titre;
	
	@Column(name = "AUTEUR", length = 30, nullable = false)
	private String auteur;
	
	@ManyToMany
	@JoinTable(name="compo",
	joinColumns = @JoinColumn(name="ID_LIV", referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID"))
	private Set<Livre> livre;
	
	/** Constructeur par default */
	public Livre(){
		livre = new HashSet<Livre>();
	}

	/** Getter ID */
	public Integer getId() {
		return id;
	}
	/** Setter ID
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/** Getter Titre */
	public String getTitre() {
		return titre;
	}
	/** Setter Titre
	 * 
	 * @param titre
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/** Getter Auteur */
	public String getAuteur() {
		return auteur;
	}
	/** Setter Auteur
	 * 
	 * @param auteur
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	/** Getter Livre*/
	public Set<Livre> getLivre() {
		return livre;
	}

	/** Setter Livre
	 *  
	 * @param livre
	 */
	public void setLivre(Set<Livre> livre) {
		this.livre = livre;
	}
	
	
}
