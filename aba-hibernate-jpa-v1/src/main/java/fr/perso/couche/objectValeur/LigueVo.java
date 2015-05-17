/**
 * 
 */
package fr.perso.couche.objectValeur;

import java.io.Serializable;
import java.util.List;


/**
 * @author ali
 *
 */
public class LigueVo implements Serializable{

	/** Serialisation.*/
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nom;
	
	private List<EquipeVo> listeEquipe;
}
