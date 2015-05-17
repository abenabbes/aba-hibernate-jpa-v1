/**
 * 
 */
package fr.perso.couche.objectValeur;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;


/**
 * @author ali
 *
 */
public class EquipeVo implements Serializable{

   /** Serialisation.*/
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nom;
	
	private String localite;
	
	private Calendar dateCreation;
	
	private List<JoueurVo> listeJoueurs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLocalite() {
		return localite;
	}

	public void setLocalite(String localite) {
		this.localite = localite;
	}

	public Calendar getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Calendar dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<JoueurVo> getListeJoueurs() {
		return listeJoueurs;
	}

	public void setListeJoueurs(List<JoueurVo> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EquipeVo [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", localite=");
		builder.append(localite);
		builder.append(", dateCreation=");
		builder.append(dateCreation);
		builder.append(", listeJoueurs=");
		builder.append(listeJoueurs);
		builder.append("]");
		return builder.toString();
	}
	
//	private LigueVo ligue;

}
