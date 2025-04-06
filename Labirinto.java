package ambienti;

import attrezzi.Attrezzo;

public class Labirinto {
	
	Stanza stanzaIniziale;// stanza di ingresso
	Stanza stanzaVincente;// stanza di uscita
	
	
	
	
	
	
	public void setLabirinto() {
		/* set gli attrezzi */
    	lanterna = new Attrezzo("lanterna",3);
		osso = new Attrezzo("osso",1);
    	
		/* set stanze del labirinto */
		atrio = new Stanza("Atrio");
		aulaN11 = new Stanza("Aula N11");
		aulaN10 = new Stanza("Aula N10");
		laboratorio = new Stanza("Laboratorio Campus");
		biblioteca = new Stanza("Biblioteca");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		
		// il gioco comincia nell'atrio
        this.stanzaIniziale = atrio;  
		this.stanzaVincente = biblioteca;
	}
	
	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
	
	public Stanza getStanzaVincente() {
		return  this.stanzaVincente;
	}
	
	
}
	
