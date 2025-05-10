package comandi.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import attrezzi.Attrezzo;
import comandi.ComandoIn;
import comandi.ComandoPosa;
import comandi.ComandoPrendi;
import diadia.Partita;


/*per testare le suddette classi mi occore una partita con labirinto e giocatore
 * gi� impostati, sfrutto l'inizializzazione di un oggetto di classe partita
 * 
 */
class ComandoPrendiEPosaTest {

	Partita mia_partita;
	ComandoIn comando_prendi;
	ComandoIn comando_posa;

	@BeforeEach
	void setUp() {
		mia_partita=new Partita();
		comando_prendi=new ComandoPrendi();
		comando_posa=new ComandoPosa();
	}

	@Test
	void test_classe_prendi_assert_same() {
		//il giocatore si trova nella stanza "atrio" dove c'� "osso"
		comando_prendi.setParametro("osso");
		comando_prendi.esegui(mia_partita);
		//so che rif a osso si trover� al posto zero dell'array attrezzi della borsa
		Attrezzo atteso=mia_partita.getGiocatore().getBorsa().getArrayAttrezzi()[0];
		assertSame(mia_partita.getGiocatore().getBorsa().getAttrezzo("osso"), atteso);
		assertNull(mia_partita.getStanzaCorrente().getAttrezzo("osso"));

	}


	//ho fatto si che il m. toString si attrezzo sovrascrivesse quello di object
	//->assertEquals mi compare stringa e non il suo indirizzo
	//NB ci� perch� classe stringa � speciale e overrida  metodo equals
	@Test
	void test_classe_prendi_assert_equals() {
		//il giocatore si trova nella stanza "atrio" dove c'� "osso"
		comando_prendi.setParametro("osso");
		comando_prendi.esegui(mia_partita);
		assertEquals(mia_partita.getGiocatore().getBorsa().getAttrezzo("osso").toString(), "osso");
		//stanza corrente � di default atrio
		assertNull(mia_partita.getStanzaCorrente().getAttrezzo("osso"));
	}

	@Test 
	void test_classe_posa() {
		//il giocatore si trova nella stanza "atrio" dove c'� "osso"
		comando_prendi.setParametro("osso");
		comando_prendi.esegui(mia_partita);
		//ora giocatore ha osso, lo so perch� test classe prendi funzionano
		//noto ch� non � possibile posare senza aver mai preso->noto ordine cronologico
		//nel testing
		comando_posa.setParametro("osso");
		comando_posa.esegui(mia_partita);
		assertEquals(mia_partita.getStanzaCorrente().getAttrezzo("osso").toString(), "osso");
		assertNull(mia_partita.getGiocatore().getBorsa().getAttrezzo("osso"));
	}

}
