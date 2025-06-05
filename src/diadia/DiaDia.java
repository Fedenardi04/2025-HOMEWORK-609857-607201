package diadia;


import java.io.IOException;
import java.util.Scanner;

import ambienti.Labirinto;
import ambienti.Stanza;
import comandi.AbstractComando;
import comandi.ComandoIn;
import comandi.FabbricaDiComandi;
import comandi.FabbricaDiComandiNonRiflessiva;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";


	private Partita partita;

	private IO miaConsole;

	public DiaDia(IO console) throws IOException {
		this.partita = new Partita();
		this.miaConsole=console;
	}
	
	public DiaDia(IO console, Labirinto labirinto) {
		this.miaConsole=console;
		this.partita = new Partita(labirinto);
		
	}


	////////////////////////////////////////////////////
	public void gioca() throws Exception {
		String istruzione; 

		this.miaConsole.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do		{
			if(partita.isFinita()) {
				this.sconfitta();
				return;
			}
			istruzione=this.miaConsole.leggiRiga();
		}
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 * @throws Exception 
	 */

	public boolean processaIstruzione(String istruzione) throws Exception {
		AbstractComando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiNonRiflessiva();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())

			this.miaConsole.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())

			this.miaConsole.mostraMessaggio("Hai esaurito i CFU...");

		return this.partita.isFinita();
	}


	private void sconfitta() {
		miaConsole.mostraMessaggio("Hai perso!");  // si desidera smettere
	}

	public static void main(String[] argc) throws Exception {
		IO console=new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	}


	public Partita getPartita() {
		return this.partita;
	}
}