package banque;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Assurance_vie")
public class AssuranceVie extends Compte {
	
	@Column(name = "date_fin", nullable = false)
	private LocalDate dateFin;
	
	@Column(name = "taux", nullable = false)
	private double taux;
	
	public AssuranceVie(){
		
	}
	
	public AssuranceVie(String numero, double solde, Client client, double taux, LocalDate dateFin){
		super(numero, solde, client);
		this.taux = taux;
		this.dateFin = dateFin;
	}
	
	/**
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}
	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
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
