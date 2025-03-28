package stanza.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import diadia.Stanza;

import static org.junit.jupiter.api.Assertions.*;

/*test della funzione impostaStanzaAdiacente,
verifico caso in cui riceve stanza che ha già
una stanza assegnata alla direzione che riceve e
caso in cui ciò non avviene
*/

class ImpostaStanzaAdiacenteTest {
	private Stanza stanzaNonInizializzata;
	private Stanza stanzaInizializzata;
	private Stanza s_adiacente_post_metodo;
	
	@BeforeEach
	public void SetUp() {
		this.stanzaNonInizializzata=new Stanza("s_non_inizializzata");
		
		
		this.stanzaInizializzata=new Stanza("s_inizializzata");
		Stanza s_adiacente_pre_metodo=new Stanza("s_adiacente_pre_metodo");
		this.stanzaInizializzata.impostaStanzaAdiacente("nord", s_adiacente_pre_metodo);
		
		this.s_adiacente_post_metodo=new Stanza("s_adiacente_post_metodo");
		
	}
	

	@Test 
	
	void testImpostaStanzaAdiacenteDirezioneNordConStanzaNonInizializzata() {
		//Stanza s_adiacente_post_metodo=new Stanza("s_adiacente_post_metodo");
		
		this.stanzaNonInizializzata.impostaStanzaAdiacente("nord", this.s_adiacente_post_metodo);
		
		assertEquals(s_adiacente_post_metodo, this.stanzaNonInizializzata.getStanzaAdiacente("nord"));
	}
	
	void testImpostaStanzaAdiacenteDirezioneNordConStanzaInizializzata() {
		//Stanza s_adiacente_post_metodo=new Stanza("s_adiacente_post_metodo");
		
		this.stanzaInizializzata.impostaStanzaAdiacente("nord", this.s_adiacente_post_metodo);
		
		assertEquals(s_adiacente_post_metodo, this.stanzaInizializzata.getStanzaAdiacente("nord"));
		
	}
	
}
