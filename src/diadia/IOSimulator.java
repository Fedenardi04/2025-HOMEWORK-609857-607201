package diadia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import comandi.AbstractComando;
import comandi.ComandoIn;
import comandi.FabbricaComandiRiflessiva;
import comandi.FabbricaDiComandi;
import comandi.FabbricaDiComandiNonRiflessiva;




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
	
	
	private List<String> comandi; //stringhe inserite dall'utente
	private List<String> stampe;  //stringhe stampate dal programma
	private int num_mesaggi_letti;
	private DiaDia dia_dia;
	
	public IOSimulator(DiaDia dia_dia) {
		this.dia_dia=dia_dia;
		//uso arrayList per sfruttare accesso posizionale in tempo costante
		stampe=new ArrayList<String>();
	}
	
	public IOSimulator() {
		stampe=new ArrayList<String>();
	}

	//immagazzini risposta del programma
	@Override
	public void mostraMessaggio(String responso) {
		this.stampe.add(num_mesaggi_letti, responso);
	}

	//esegue un comando, invocando get resposo avviene immagazzinamento risposta
	@Override
	public String leggiRiga() throws Exception {
		//ottengo il comando da eseguire
		AbstractComando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaComandiRiflessiva();
		comandoDaEseguire = factory.costruisciComando(this.comandi.get(num_mesaggi_letti));
		//ora ho il comando, eseguo e ottengo il responso(ovviamente, lo eseguo sulla partita)
		comandoDaEseguire.getResponso(this.dia_dia.getPartita(), this);
		this.num_mesaggi_letti++;
		return null;
	}
	
	public List<String> getComandi() {
		return this.comandi;
	}
	
	public void setComandi(List<String> comandi) {
		this.comandi=comandi;
	}

	public List<String> getStampe() {
		return this.stampe;
	}
	
	public void setDiaDia(DiaDia diadia) {
		this.dia_dia=diadia;
	}

}
