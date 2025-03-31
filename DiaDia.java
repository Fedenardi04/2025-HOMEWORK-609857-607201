package diadia;


import java.util.Scanner;

import ambienti.Stanza;

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

	//array di stringhe
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	
	private IOConsole miaConsole;

	public DiaDia() {
		this.partita = new Partita();
		this.miaConsole= new IOConsole();
	}

	public void prendi(String nomeAtt) {

		if(nomeAtt==null)
			System.out.println("Cosa vuoi prendere ?");
		this.partita.getGiocatore().prendiAttrezzo(this.partita.getStanzaCorrente().getAttrezzo(nomeAtt));
		this.partita.getStanzaCorrente().removeAttrezzo(nomeAtt);



		miaConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		miaConsole.mostraMessaggio(partita.getGiocatore().getDescrizione());
	} 

	public void posa(String nomeAtt) {
		if(nomeAtt==null)
			miaConsole.mostraMessaggio("Cosa vuoi posare ?");
		this.partita.getStanzaCorrente().addAttrezzo(this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAtt));
		this.partita.getGiocatore().posaAttrezzo(nomeAtt);

		miaConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		miaConsole.mostraMessaggio(partita.getGiocatore().getDescrizione());
	}
	////////////////////////////////////////////////////
	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		System.out.println(MESSAGGIO_BENVENUTO);
		//scannerDiLinee = new Scanner(System.in);		
		do		{
			if(partita.isFinita()) {
				this.sconfitta();
				return;
			}
			//istruzione = scannerDiLinee.nextLine();
			istruzione=this.miaConsole.leggiRiga();
		}
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {

		Comando comandoDaEseguire = new Comando(istruzione);
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;  
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		////////////////////////////////////////////////
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			miaConsole.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			miaConsole.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			miaConsole.mostraMessaggio(elencoComandi[i]+" ");
		miaConsole.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			miaConsole.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			miaConsole.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu-1);
		}
		miaConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		miaConsole.mostraMessaggio(partita.getGiocatore().getCfuStringato());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		miaConsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	private void sconfitta() {
		miaConsole.mostraMessaggio("Hai perso!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}