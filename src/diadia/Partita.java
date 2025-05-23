package diadia;

import ambienti.Labirinto;
import ambienti.Stanza;
import giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private boolean finita;
	
	private Labirinto mioLabirinto;
	
	private Giocatore mioGiocatore;
	
	public Partita(){
		
		this.mioLabirinto=new Labirinto();
		this.mioLabirinto.setLabirinto();
		
		this.mioGiocatore=new Giocatore();
		this.mioGiocatore.setGiocatore();
		
		this.stanzaCorrente=this.mioLabirinto.getStanzaIniziale();
		this.stanzaVincente=this.mioLabirinto.getStanzaVincente();
		
		this.finita = false;
	}
	
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	
	
	public Labirinto getLabirinto() {
		return this.mioLabirinto;
	}
	
	public Giocatore getGiocatore() {
		return this.mioGiocatore;
	}
	

	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
	}
	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (mioGiocatore.getCfu()== 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}


	public void setStanzaCorrente(Stanza prossimaStanza) {
		this.stanzaCorrente=prossimaStanza;
		
	}

	public boolean giocatoreIsVivo() {
		return this.mioGiocatore.getCfu()!=0;
	}	
}
