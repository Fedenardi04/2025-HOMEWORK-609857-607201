package comandi.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import attrezzi.Attrezzo;
import comandi.AbstractComando;
import comandi.ComandoIn;
import comandi.ComandoPosa;
import comandi.ComandoPrendi;
import diadia.Partita;


/*per testare le suddette classi mi occore una partita con labirinto e giocatore
 * già impostati, sfrutto l'inizializzazione di un oggetto di classe partita
 * 
 */
class ComandoPrendiEPosaTest {

	private Partita mia_partita;
	private AbstractComando comando_prendi;
	private AbstractComando comando_posa;

	@BeforeEach
	void setUp() throws IOException {
		mia_partita=new Partita("C://Users//carlo//OneDrive//Desktop//labirinto1.txt");
		comando_prendi=new ComandoPrendi();
		comando_posa=new ComandoPosa();
	}


	@Test
	void test_classe_prendi_assert_equals() {
		//il giocatore si trova nella stanza "atrio" dove c'è "osso"
		comando_prendi.setParametro("osso");
		comando_prendi.esegui(mia_partita);
		assertEquals(mia_partita.getGiocatore().getBorsa().getAttrezzo("osso").toString(), "osso");
		//stanza corrente è di default atrio
		assertNull(mia_partita.getStanzaCorrente().getAttrezzo("osso"));
	}

	@Test 
	void test_classe_posa() {
		//il giocatore si trova nella stanza "atrio" dove c'è "osso"
		comando_prendi.setParametro("osso");
		comando_prendi.esegui(mia_partita);
		//ora giocatore ha osso, lo so perché test classe prendi funzionano
		//noto ché non è possibile posare senza aver mai preso->noto ordine cronologico
		//nel testing
		comando_posa.setParametro("osso");
		comando_posa.esegui(mia_partita);
		assertEquals(mia_partita.getStanzaCorrente().getAttrezzo("osso").toString(), "osso");
		assertNull(mia_partita.getGiocatore().getBorsa().getAttrezzo("osso"));
	}

}
