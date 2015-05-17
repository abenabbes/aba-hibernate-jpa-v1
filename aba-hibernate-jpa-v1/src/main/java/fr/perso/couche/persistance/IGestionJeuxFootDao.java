/**
 * 
 */
package fr.perso.couche.persistance;

import java.util.List;

import fr.perso.couche.objectValeur.JoueurVo;

/**
 * @author ali
 *
 */
public interface IGestionJeuxFootDao {

	/** Méthode pour rechercher un joueur*/
	public JoueurVo rechercherJoueurParId(final Long id);
	
	/** créer ou mettre à jour un joueur*/
	public void createOrUpdateJoueur(JoueurVo joueur);
	
	/** Rechercher tous les joueurs*/
	public List<JoueurVo> listerTousLesJoueurs();
}
