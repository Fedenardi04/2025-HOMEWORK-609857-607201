package ambienti.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ambienti.Stanza;
import ambienti.StanzaBloccata;
import attrezzi.Attrezzo;
import direzioni.Direzione;

//La «stanza bloccata»: una delle direzioni della
//stanza non può essere seguita a meno che nella
//stanza non sia presente un oggetto con un nome
//particolare (ad esempio "passepartout")

class StanzaBloccataTest {
	
	Stanza mia_stanza_bloccata;

	@BeforeEach
	void setUp()  {
		this.mia_stanza_bloccata=new StanzaBloccata("s_bl","passpartout","ovest");
	}

	@Test
	void test_stanza_senza_pass() {
		//test getDescrizione
		String effettiva=mia_stanza_bloccata.getDescrizione();
		String attesa="s_bl"+"\nUscite: "+"\nAttrezzi nella stanza: "+
		"c'è una direzione bloccata";
		assertEquals(attesa, effettiva);
		//test getStanzaAdiacente
		Stanza nuova=new Stanza("nuova");
		//imposto stanza adiacente in direzione bloccata e non
//		this.mia_stanza_bloccata.impostaStanzaAdiacente("ovest", nuova);
//		this.mia_stanza_bloccata.impostaStanzaAdiacente("nord",nuova);
		this.mia_stanza_bloccata.impostaStanzaAdiacente(Direzione.valueOf("ovest"), nuova);
		this.mia_stanza_bloccata.impostaStanzaAdiacente(Direzione.valueOf("nord"), nuova);
		//vado nella direzione bloccata
		assertSame(this.mia_stanza_bloccata.getStanzaAdiacente(Direzione.valueOf("ovest")), this.mia_stanza_bloccata);
		//vado nella direzione non bloccata
		assertSame(this.mia_stanza_bloccata.getStanzaAdiacente(Direzione.valueOf("nord")), nuova);
	}
	
	@Test
	void test_stanza_con_pass() {
		//pass viene messo in stanza
		Attrezzo pass=new Attrezzo("passpartout", 3);
		mia_stanza_bloccata.addAttrezzo(pass);
		//test getDescrizione
		String effettiva=mia_stanza_bloccata.getDescrizione();
		String attesa="s_bl"+"\nUscite: "+"\nAttrezzi nella stanza: "+"passpartout ";
		assertEquals(attesa, effettiva);
		//test getStanzaAdiacente
		Stanza nuova=new Stanza("nuova");
		this.mia_stanza_bloccata.impostaStanzaAdiacente(Direzione.valueOf("ovest"), nuova);
		assertSame(this.mia_stanza_bloccata.getStanzaAdiacente(Direzione.valueOf("ovest")), nuova);
	}

}
