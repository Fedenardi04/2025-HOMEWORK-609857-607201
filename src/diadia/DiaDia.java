package diadia;


import java.util.Scanner;

import ambienti.Stanza;
import comandi.ComandoIn;
import comandi.FabbricaDiComandi;

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

	public DiaDia(IO console) {
		this.partita = new Partita();
		this.miaConsole=console;
	}


	////////////////////////////////////////////////////
	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		System.out.println(MESSAGGIO_BENVENUTO);		
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
	 */

	public boolean processaIstruzione(String istruzione) {
		ComandoIn comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandi();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())

			System.out.println("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())

			System.out.println("Hai esaurito i CFU...");

		return this.partita.isFinita();
	}


	private void sconfitta() {
		miaConsole.mostraMessaggio("Hai perso!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IO console=new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	}


	public Partita getPartita() {
		return this.partita;
	}
}