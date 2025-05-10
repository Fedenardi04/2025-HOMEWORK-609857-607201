package diadia;

import java.util.Scanner;

import comandi.ComandoIn;
import comandi.FabbricaDiComandi;

//I metodi mostraMessaggio() e leggiRiga() dovranno
//rispettivamente scrivere / leggere i messaggi che sono
//scritti a video / letti da tastiera
//– Possono essere letti/conservati in array definiti come variabili di
//istanza
//– Il metodo leggiRiga() consentirà di “iniettare” le righe che
//desideriamo far figurare come istruzioni (di solito immesse
//dall’utente)
//– Il metodo mostraMessaggio() consentirà di conoscere i
//messaggi stampati durante la partita (a supporto di eventuali
//asserzioni)
public class IOSimulator implements IO {
	
	
	private String[] comandi;    //stringhe inserite dall'utente
	private String[] stampe;     //stringhe stampate dal programma
	private int num_mesaggi_letti;
	private DiaDia dia_dia;
	
	public IOSimulator(DiaDia dia_dia) {
		this.dia_dia=dia_dia;
		stampe=new String[10];
	}
	
	//immagazzina risposta di diadia al comando iniettato
	//tale comando è il par formale
	//->immagazzina al posto num_messaggi_letti-1
	@Override
	public void mostraMessaggio(String responso) {
		this.stampe[num_mesaggi_letti-1]=responso;
	}

	//inietta in dia dia un comando,
	//deve ritornare la stampa fatta dal diadia(il responso) a seguito del comando
	@Override
	public String leggiRiga() {
		//ottengo il comando da eseguire
		ComandoIn comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandi();
		comandoDaEseguire = factory.costruisciComando(this.comandi[num_mesaggi_letti]);
		//ora ho il comando, eseguo e ottengo il responso(ovviamente, lo eseguo sulla partita)
		String da_ritornare=comandoDaEseguire.getResponso(this.dia_dia.getPartita());
		this.num_mesaggi_letti++;
		return da_ritornare;
	}
	
	public String[] getComandi() {
		return this.comandi;
	}
	
	public void setComandi(String[] comandi) {
		this.comandi=comandi;
	}

	public Object[] getStampe() {
		return this.stampe;
	}

}
