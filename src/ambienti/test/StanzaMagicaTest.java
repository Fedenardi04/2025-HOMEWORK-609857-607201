package ambienti.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ambienti.Stanza;
import ambienti.StanzaMagica;
import attrezzi.Attrezzo;

class StanzaMagicaTest {

	Stanza mia_stanza_magica;//noto tipo statico
	Attrezzo lanterna;
	Attrezzo clava;

	@BeforeEach
	void setUp()  {
		mia_stanza_magica=new StanzaMagica("sm");//soglia è uno di default
		lanterna=new Attrezzo("lanterna", 2);
		clava=new Attrezzo("clava", 3);
	}

	@Test
	void test() {
		mia_stanza_magica.addAttrezzo(lanterna);
		mia_stanza_magica.addAttrezzo(clava);
		Attrezzo avalc=new Attrezzo("avalc", 6);
		//		assertEquals(mia_stanza_magica.getAttrezzi()[0].getNome(), "lanterna");
		//		assertEquals(mia_stanza_magica.getAttrezzi()[1].getNome(), "avalc");
		assertTrue(mia_stanza_magica.getAttrezzi().contains(avalc));
		assertTrue(mia_stanza_magica.getAttrezzi().contains(lanterna));
		//verifico pesi
		//		assertEquals(mia_stanza_magica.getAttrezzi()[0].getPeso(), 2);
		//		assertEquals(mia_stanza_magica.getAttrezzi()[1].getPeso(), 6);
	}

}
