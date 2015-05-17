/**
 * 
 */
package fr.perso.couche.entite;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;

/**
 * @author ali
 *
 */
@Entity
@Table(name="JOUEUR")
public class JoueurEntite implements Serializable{
	
	//ATTRIBUTS
	/** Serializable*/
	private static final long serialVersionUID = 1L;
	
	/** identifiant de l'entite*/
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_JOUEUR", nullable = false)
	private Long id;
	
	@Column(name="NOM_JOUEUR", nullable = false)
	private String nom;
	
	@Column(name="PRENOM_JOUEUR", nullable = false)
	private String prenom;
	
	@Column(name="AGE_JOUEUR")
	@Temporal(TemporalType.DATE)
	private Calendar age;
	
	@Column(name="EMAIL_JOUEUR", nullable = false)
	@Email
	private String email;
	
	/** IDEQUIPE*/
	// relation principale Joueur (many) ->  Equipe (one) 
	// implémentée par une clé étrangère (ID_EQUIPE) dans Joueur 
    @ManyToOne
    @JoinColumn(name="ID_EQUIPE", referencedColumnName="ID_EQUIPE", nullable=false) //anotation de la clé étrangère
	private EquipeEntite equipe;

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Calendar getAge() {
		return age;
	}

	public void setAge(Calendar age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EquipeEntite getEquipe() {
		return equipe;
	}

	public void setEquipe(EquipeEntite equipe) {
		this.equipe = equipe;
	}

	//toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JoueurEntite [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", age=");
		builder.append(age);
		builder.append(", email=");
		builder.append(email);
		builder.append(", equipe=");
		builder.append(equipe);
		builder.append("]");
		return builder.toString();
	}
    
    /** Attribut de mise à jour de l'entite*/
//    @Version
//    @Column(name = "LAST_UPDATED_TIME")
//    private Calendar updatedTime;

}
