/**
 * 
 */
package fr.perso.couche.objectValeur;

import java.io.Serializable;
import java.util.Calendar;


/**
 * @author ali
 *
 */
public class JoueurVo implements Serializable{

	/** Serialisation.*/
	private static final long serialVersionUID = 1L;
	
	//ATTRIBUTS
	/** identifiant*/
	private Long idJoueur;
	
	/** nom du joueur*/
	private String nomJoueur;
	
	/** prenom du joueur*/
	private String prenomJoueur;
	
	/** age du joueur*/
	private Calendar ageJoueur;
	
	/** email du joueur*/
	private String emailJoueur;
	
	/** equipe du joueur*/
	private EquipeVo equipe;

	public Long getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(Long idJoueur) {
		this.idJoueur = idJoueur;
	}

	public String getNomJoueur() {
		return nomJoueur;
	}

	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	public String getPrenomJoueur() {
		return prenomJoueur;
	}

	public void setPrenomJoueur(String prenomJoueur) {
		this.prenomJoueur = prenomJoueur;
	}

	public Calendar getAgeJoueur() {
		return ageJoueur;
	}

	public void setAgeJoueur(Calendar ageJoueur) {
		this.ageJoueur = ageJoueur;
	}

	public String getEmailJoueur() {
		return emailJoueur;
	}

	public void setEmailJoueur(String emailJoueur) {
		this.emailJoueur = emailJoueur;
	}

	public EquipeVo getEquipe() {
		return equipe;
	}

	public void setEquipe(EquipeVo equipe) {
		this.equipe = equipe;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JoueurVo [idJoueur=");
		builder.append(idJoueur);
		builder.append(", nomJoueur=");
		builder.append(nomJoueur);
		builder.append(", prenomJoueur=");
		builder.append(prenomJoueur);
		builder.append(", ageJoueur=");
		builder.append(ageJoueur);
		builder.append(", emailJoueur=");
		builder.append(emailJoueur);
		builder.append(", equipe=");
		builder.append(equipe);
		builder.append("]");
		return builder.toString();
	}

}
