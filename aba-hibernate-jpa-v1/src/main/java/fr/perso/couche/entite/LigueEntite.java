/**
 * 
 */
package fr.perso.couche.entite;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ali
 *
 */
@Entity
@Table(name="LIGUE")
public class LigueEntite implements Serializable{
	
	//ATTRIBUTS
	/** Serializable*/
	private static final long serialVersionUID = 1L;

	/** identifiant de l'entite*/
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_LIGUE", nullable = false)
	private Long id;
	
	/** attribut nom*/
	@Column(name="NOM_LIGUE", nullable = false)
	private String nom;
	
	/** attribut prenom*/
	
//	private List<EquipeEntite> listeEquipe;
	
}
