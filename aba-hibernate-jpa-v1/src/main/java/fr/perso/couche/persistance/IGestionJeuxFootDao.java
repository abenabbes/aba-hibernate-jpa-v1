/**
 * 
 */
package fr.perso.couche.persistance;

import java.util.List;

import fr.perso.couche.entite.EquipeEntite;
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
	
	/** Rechercher toutes les equipes*/
	public List<EquipeEntite> listerTousLesEquipess();
	
	/** 
	 * Rechercher l'équipe d'un joueur.<br>
	 * La recherche s'effectue par le non du joueur.
	 * @param nom nom du joueur
	 * @return une equipe
	 */
	public EquipeEntite rechercherEquipeDunJoueur(String nom);
}
