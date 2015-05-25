/**
 * 
 */
package fr.perso.couche.persistance.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import fr.perso.couche.entite.EquipeEntite;
import fr.perso.couche.objectValeur.JoueurVo;
import fr.perso.couche.persistance.IGestionJeuxFootDao;
import fr.perso.couche.test.utils.AbstractTest;


/**
 * @author ali
 *
 */
@ContextConfiguration(locations={ "classpath:spring/test-appli-context.xml" }) 
public class TestGestionJeuxFootDaoImpl extends AbstractTest{
	
	/** Persistance*/
	@Autowired
	private IGestionJeuxFootDao gestionJeuxFootDao;
	
	/**
	 * Pour tester la récupération de la liste des joueurs.
	 */
	@Test
	public void testListerJoueur(){
		 
		List<JoueurVo> listerTousLesJoueurs = gestionJeuxFootDao.listerTousLesJoueurs();
		
		Assert.assertNotNull(listerTousLesJoueurs);
	}
	
	/**
	 * Pour tester la récupération de la liste des equipe.
	 */
	@Test
	public void testListerEquipe(){
		 
		List<EquipeEntite> listerToutesLesEquipes = gestionJeuxFootDao.listerTousLesEquipess();
		
		Assert.assertNotNull(listerToutesLesEquipes);
	}

	/**
	 * CAS NOMINAL.<br>
	 * Pour tester la recherche d'une equipe d'un joueur.<br>
	 * 
	 */
	@Test
	public void testerRechercherEquipeDuJoueurCasNominal(){
		String nomJoueur="NOM_JOUEUR_888111";
		
		EquipeEntite equipeRechercher = gestionJeuxFootDao.rechercherEquipeDunJoueur(nomJoueur);
	    
		Assert.assertNotNull(equipeRechercher);
		Assert.assertEquals("Verification du nom de l'equipe", equipeRechercher.getNom(), "EQUIPE_888111");
		
	}
	
	/**
	 * CAS ERREUR.<br>
	 * Pour tester la recherche d'une equipe d'un joueur.<br>
	 * 
	 */
	@Test
	public void testerRechercherEquipeDuJoueurCasErreur(){
		
		log.debug("Teste méthode : [testerRechercherEquipeDuJoueurCasErreur]");
		
		String nomJoueur="test";
		
		EquipeEntite equipeRechercher = gestionJeuxFootDao.rechercherEquipeDunJoueur(nomJoueur);
	    
		Assert.assertNull(equipeRechercher);
		
	}
}
