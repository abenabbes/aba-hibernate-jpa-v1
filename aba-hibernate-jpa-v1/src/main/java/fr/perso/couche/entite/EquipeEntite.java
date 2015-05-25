/**
 * 
 */
package fr.perso.couche.entite;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.perso.couche.utils.PersistanceUtils;

/**
 * @author ali
 *
 */
@Entity
@Table(name="EQUIPE")
@NamedQueries
({
	@NamedQuery(name= PersistanceUtils.REQ_RECHERCHE_LISTE_EQUIPE, 
			    query= "SELECT equipe FROM EquipeEntite equipe"
			    ),
			
	@NamedQuery(name=PersistanceUtils.REQ_RECHERCHER_EQUIPE_DU_JOUEUR, 
	            query=" SELECT equipe"
	            	+ " FROM EquipeEntite equipe"
	            	+ " INNER JOIN equipe.listeJoueurs joueur"
	            	+ " WHERE joueur.nom=:" + PersistanceUtils.NOM_JOUEUR
	            )
})
public class EquipeEntite implements Serializable{
	
	//ATTRIBUTS
	/** Serializable*/
	private static final long serialVersionUID = 1L;

	/** identifiant de l'entite*/
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_EQUIPE", unique=true ,nullable = false)
	private Long id;
	
	/** Nom de l'equipe*/
	@Column(name="NOM_EQUIPE", nullable = false)
	private String nom;
	
	/** Region de l'equipe*/
	@Column(name="LOCALITE_EQUIPE", nullable = false)
	private String localite;
	
	/** la date de creation de l'equipe*/
	@Column(name="DATECREATION_EQUIPE", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dateCreation;
	
	/**Liste des joueurs appartenant à l'equipe*/
	// relation inverse Equipe (one) -> Joueur (many) de la relation Joueur (many) -> Equipe (one) 
	// cascade insertion Equipe -> insertion Joueur 
    // cascade maj Equipe -> maj Joueur 
    // cascade suppression Equipe -> suppression Joueur 
    @OneToMany(mappedBy="equipe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<JoueurEntite> listeJoueurs;

    //GETTER && SETTER
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

	public List<JoueurEntite> getListeJoueurs() {
		return listeJoueurs;
	}

	public void setListeJoueurs(List<JoueurEntite> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}

	//toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EquipeEntite [id=");
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
	
	/** la ligue à laquelle appartient l'equipe*/
//	private LigueEntite ligue;

}
