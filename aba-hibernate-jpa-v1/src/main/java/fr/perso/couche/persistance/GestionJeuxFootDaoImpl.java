/**
 * 
 */
package fr.perso.couche.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import fr.perso.couche.entite.EquipeEntite;
import fr.perso.couche.entite.JoueurEntite;
import fr.perso.couche.objectValeur.EquipeVo;
import fr.perso.couche.objectValeur.JoueurVo;
import fr.perso.couche.utils.PersistanceUtils;

/**
 * @author ali
 *
 */
@Repository
public class GestionJeuxFootDaoImpl implements IGestionJeuxFootDao {

	//ATTRIBUTS
	/**Logger de la classe.*/
	private static Logger log = LoggerFactory.getLogger(GestionJeuxFootDaoImpl.class);
	
	/** EntityManager*/
	@PersistenceContext
	private EntityManager entityManager;
	
	//METHODES IMPLEMENTES

	@SuppressWarnings("unchecked")
	@Override
	public List<JoueurVo> listerTousLesJoueurs() {
		
		log.debug("DEBUT persistance - [listerTousLesJoueurs]");
		
		//Liste retour
		List<JoueurVo> listerJoueurRetour = new ArrayList<JoueurVo>();
		
		//Liste de resultat de la reqête
		List<JoueurEntite> resulListJoueur = null;
		
		//Execution de la requête nommée
		Query query = entityManager.createNamedQuery(PersistanceUtils.REQ_RECHERCHE_LISTE_JOUEUR, JoueurEntite.class);
		
		try {
			//Resultat de requête
			resulListJoueur = query.getResultList();
		
		} catch (Exception e) {
			e.getStackTrace();
			log.debug("Exception dans la persistance");
		}
			
		if(CollectionUtils.isNotEmpty(resulListJoueur)){
			
			for (JoueurEntite joueurEntite : resulListJoueur) {
				
				//Transformation de l'entité en Vo
				JoueurVo joueurRetour = new JoueurVo();
				joueurRetour.setAgeJoueur(joueurEntite.getAge());
				joueurRetour.setEmailJoueur(joueurEntite.getEmail());
				joueurRetour.setNomJoueur(joueurEntite.getNom());
				joueurRetour.setPrenomJoueur(joueurEntite.getPrenom());
				
				//Equipe
				EquipeVo voRetour = new EquipeVo();
				voRetour.setDateCreation(joueurEntite.getEquipe().getDateCreation());
				voRetour.setId(joueurEntite.getEquipe().getId());;
				voRetour.setLocalite(joueurEntite.getEquipe().getLocalite());
				voRetour.setNom(joueurEntite.getEquipe().getNom());
				List<JoueurVo> listeJoueurs = new ArrayList<JoueurVo>();
				listeJoueurs.add(joueurRetour);
				voRetour.setListeJoueurs(listeJoueurs);
				joueurRetour.setEquipe(voRetour);
				
				//Remplissage de la liste retour
				listerJoueurRetour.add(joueurRetour);
			}
		
		}
		
		log.debug("FIN persistance - [listerTousLesJoueurs]");
		return listerJoueurRetour;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EquipeEntite> listerTousLesEquipess() {
		log.debug("DEBUT persistance - [listerTousLesJoueurs]");
		
		//Liste de resultat de la reqête
		List<EquipeEntite> resulListEquipe = null;
		
		//Execution de la requête nommée
		Query query = entityManager.createNamedQuery(PersistanceUtils.REQ_RECHERCHE_LISTE_EQUIPE, EquipeEntite.class);
		
		
		try {
			//Resultat de requête
			resulListEquipe = query.getResultList();
		
		} catch (Exception e) {
			e.getStackTrace();
			log.debug("Exception dans la persistance");
		}
		
		return resulListEquipe;
	}

	@Override
	public EquipeEntite rechercherEquipeDunJoueur(String nom) {

		log.debug("DEBUT persistance - [rechercherEquipeDunJoueur]");
		
		//Retour de la recherche 
		EquipeEntite equipeRetour = null;
		
		//Requête nommmé de recherche
		Query query = entityManager.createNamedQuery(PersistanceUtils.REQ_RECHERCHER_EQUIPE_DU_JOUEUR);
		query.setParameter(PersistanceUtils.NOM_JOUEUR, nom);
		
		try {
			
			equipeRetour = (EquipeEntite) query.getSingleResult();
			
		} catch (NoResultException e) {
			e.getStackTrace();
			log.debug("Exception dans la persistance");
		}
		return equipeRetour;
	}

	@Override
	public JoueurVo rechercherJoueurParId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createOrUpdateJoueur(JoueurVo joueur) {
		// TODO Auto-generated method stub
		
	}

	//GETTER && SETTER
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
