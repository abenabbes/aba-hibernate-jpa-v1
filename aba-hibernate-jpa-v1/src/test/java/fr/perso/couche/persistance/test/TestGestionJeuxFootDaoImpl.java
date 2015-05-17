/**
 * 
 */
package fr.perso.couche.persistance.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

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
	
	@Test
	public void testListerJoueur(){
		 
		List<JoueurVo> listerTousLesJoueurs = gestionJeuxFootDao.listerTousLesJoueurs();
		
		Assert.assertNotNull(listerTousLesJoueurs);
	}

}
