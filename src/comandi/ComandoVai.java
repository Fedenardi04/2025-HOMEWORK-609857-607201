package comandi;

import ambienti.Stanza;
import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;
import direzioni.Direzione;

public class ComandoVai extends AbstractComando {
//	private String parametro;

	public ComandoVai(String direzione) {
		this.parametro = direzione;
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
		if(this.parametro==null) {
			o.mostraMessaggio("si selezioni una direzione");
			return;
		}
		
//		Stanza prossima=partita.getStanzaCorrente().getStanzaAdiacente(this.parametro);
		Stanza prossima=partita.getStanzaCorrente().getStanzaAdiacente(Direzione.valueOf(this.parametro));
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
	public String getNome() {
		return "vai";
	}
	@Override
	public String getParametro() {
		return this.parametro;
	}


	@Override
	public void getResponso(Partita partita, IO console) {
		this.esegui(partita);
		console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione()+""+
				partita.getGiocatore().getDescrizione());
	}
}
