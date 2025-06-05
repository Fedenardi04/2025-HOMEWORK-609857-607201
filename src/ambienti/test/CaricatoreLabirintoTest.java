package ambienti.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ambienti.*;
import ambienti.Labirinto;
import ambienti.Stanza;
import attrezzi.Attrezzo;
import direzioni.Direzione;

class CaricatoreLabirintoTest {
	
//	"C:\Users\carlo\OneDrive\Desktop\labirinto1.txt"
	
	//Stanze: biblioteca, N10, N11
	//Inizio: N10
	//Vincente: N11
	//Attrezzi: martello 10 biblioteca, pinza 2 N10
	//Uscite: biblioteca nord N10, biblioteca sud N11
	
	private Labirinto labirinto;
	@BeforeEach
	void setUp() throws Exception {
		labirinto=Labirinto.newBuilder("C://Users//carlo//OneDrive//Desktop//labirinto111.txt");
		
	}

	@Test
	void test() {
		assertEquals(3, labirinto.getMappaStanze().size());
		
		assertEquals(new Stanza("N10"), labirinto.getStanzaIniziale());
		assertEquals(new Stanza("N11"), labirinto.getStanzaVincente());
		
		assertEquals(new Attrezzo("martello", 10), labirinto.getMappaStanze().get("biblioteca").getAttrezzo("martello"));
		assertEquals(new Attrezzo("pinza", 2), labirinto.getMappaStanze().get("N10").getAttrezzo("pinza"));
		
		assertEquals(new Stanza("N10"), labirinto.getMappaStanze().get("biblioteca").
				getStanzaAdiacente(Direzione.valueOf("nord")));
	}
}
