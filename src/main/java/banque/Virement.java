package banque;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Virement")
public class Virement extends Operation {
	
	@Column(name = "beneficiaire", length = 30, nullable = false)
	private String beneficiaire;

	public Virement() {

	}
	
	public Virement(LocalDateTime date, double montant, String motif, Compte compte, String beneficiaire){
		super(date, montant, motif, compte);
		this.beneficiaire = beneficiaire;
	}

	/**
	 * @return the beneficiaire
	 */
	public String getBeneficiaire() {
		return beneficiaire;
	}

	/**
	 * @param beneficiaire
	 *            the beneficiaire to set
	 */
	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

}
