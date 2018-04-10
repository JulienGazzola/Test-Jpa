package banque;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="LivretA")
public class LivretA extends Compte {
	@Column(name = "taux", nullable = false)
	private double taux;

	public LivretA(){
		
	}
	
	public LivretA(String numero, double solde, Client client, double taux){
		super(numero, solde, client);
		this.taux = taux;
	}
	
	/**
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}

	/**
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	
}
