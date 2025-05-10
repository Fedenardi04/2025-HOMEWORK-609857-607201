package comandi;

import ambienti.Stanza;
import diadia.IOConsole;
import diadia.Partita;

public class ComandoVai implements ComandoIn {
	private String direzione;

	public ComandoVai(String direzione) {
		this.direzione = direzione;
	}
	
	public ComandoVai() {
		this(null);
	}

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		// qui il codice per cambiare stanza ...
		
		IOConsole o=new IOConsole();
		if(this.direzione==null) {
			o.mostraMessaggio("si selezioni una direzione");
			return;
		}
		
		Stanza prossima=partita.getStanzaCorrente().getStanzaAdiacente(this.direzione);
		if(prossima==null) {
			o.mostraMessaggio("direzione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossima);//vuole par. di tipo stanza
		//o.mostraMessaggio(partita.getStanzaCorrente().getNome());
		//aggiorno i cfu
		partita.getGiocatore().decreaseCfu();
		
		//stampo una descrizione della situazione della stanza e del giocatore
		o.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		o.mostraMessaggio(partita.getGiocatore().getDescrizione());
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione=parametro;
		
	}
	@Override
	public String getNome() {
		return "vai";
	}
	@Override
	public String getParametro() {
		return this.direzione;
	}

	@Override
	public String getResponso(Partita partita) {
		this.esegui(partita);
		return partita.getStanzaCorrente().getDescrizione()+""+
				partita.getGiocatore().getDescrizione();
	}
}
