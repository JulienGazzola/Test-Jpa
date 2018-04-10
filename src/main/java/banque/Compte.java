package banque;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Compte")
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "numero", length = 30, nullable = false)
	private String numero;
	@Column(name = "solde", nullable = false)
	private double solde;

	@ManyToMany
	@JoinTable(name = "Appartenance", joinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID"))
	private Set<Client> client;
	
	@OneToMany(mappedBy = "compte")
	private Set<Operation> operation;

	public Compte(){
		client = new HashSet<Client>();
		operation = new HashSet<Operation>();
	}
	
	public Compte(String numero, double solde, Client client){
		this.numero = numero;
		this.solde = solde;
		this.client = new HashSet<Client>();
		this.operation = new HashSet<Operation>();
		this.client.add(client);
	}
	
	public Compte(String numero, double solde, Set<Client> client){
		this.numero = numero;
		this.solde = solde;
		this.client = new HashSet<Client>();
		this.operation = new HashSet<Operation>();
		for (Client c : client){
			this.client.add(c);
		}
	}
	
	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * @param solde
	 *            the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	/**
	 * @return the client
	 */
	public Set<Client> getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Set<Client> client) {
		this.client = client;
	}

}
