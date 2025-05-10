package ambienti.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ambienti.Stanza;
import ambienti.StanzaBuia;
import attrezzi.Attrezzo;

class StanzaBuiaTest {
	
	private Stanza mia_stanza_buia;

	@BeforeEach
	void setUp()  {
		mia_stanza_buia=new StanzaBuia("sb", "lanterna");
	}

	@Test
	void test_senza_lanterna() {
		assertEquals(mia_stanza_buia.getDescrizione(), 
		"sb"+"\nUscite: "+"\nAttrezzi nella stanza: "+"qui c'è un buio pesto");
	}
	
	@Test
	void test_con_lanterna() {
		Attrezzo lanterna=new Attrezzo("lanterna", 3);
		mia_stanza_buia.addAttrezzo(lanterna);
		assertEquals(mia_stanza_buia.getDescrizione(), 
		"sb"+"\nUscite: "+"\nAttrezzi nella stanza: "+"lanterna ");
	}

}
