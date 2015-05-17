/**
 * 
 */
package fr.perso.couche.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import fr.perso.couche.entite.JoueurEntite;
import fr.perso.couche.objectValeur.EquipeVo;
import fr.perso.couche.objectValeur.JoueurVo;

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
		
		//Requête
		StringBuilder req = new StringBuilder();
		req.append("SELECT joueur FROM JoueurEntite joueur");
		
		//Resultat de requête
		
		List<JoueurEntite> resulListJoueur = null;
		
		try {
			Query query = entityManager.createQuery(req.toString());
			resulListJoueur = query.getResultList();
		
		} catch (Exception e) {
			e.getStackTrace();
			log.debug("Exception dans la persistance");
		}
			
		if(CollectionUtils.isNotEmpty(resulListJoueur)){
			
			for (JoueurEntite joueurEntite : resulListJoueur) {
				
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
