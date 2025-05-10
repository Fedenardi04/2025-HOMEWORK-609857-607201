package ambienti.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ambienti.Stanza;


class GetStanzaAdiacenteTestTest {
	
	private Stanza non_circondata;
	private Stanza circondata_nord;
	private Stanza stanza_test;
	private Stanza circondata_sud;
	
	@BeforeEach
	void setUp() {
		this.non_circondata=new Stanza("non_circondata");
		this.stanza_test=new Stanza("stanza_test");
	}

	@Test
	/*metodo che verifica che stanza non inizializzata sia non circondata da stanze*/
	void testStanzaNonCircondataNord() {
		assertEquals(this.non_circondata.getStanzaAdiacente("nord"), null);
	}
	
	@Test
	void testStanzaNonCircondataSud() {
		assertEquals(this.non_circondata.getStanzaAdiacente("sud"), null);
	}
	@Test
	void testStanzaNonCircondataEst() {
		assertEquals(this.non_circondata.getStanzaAdiacente("est"), null);
	}
	@Test
	void testStanzaNonCircondataOvest() {
		assertEquals(this.non_circondata.getStanzaAdiacente("ovest"), null);
	}
	
	/*metodi che verificano che stanza inizializzata sia circondata correttamente*/
	@Test
	void testStanzaCircondataNord() {
		this.circondata_nord=new Stanza("circondata_nord");
		this.circondata_nord.impostaStanzaAdiacente("nord", this.stanza_test);
		assertEquals(this.circondata_nord.getStanzaAdiacente("nord"), this.stanza_test);
	}
	@Test
	void testStanzaCircondataSud() {
		this.circondata_sud=new Stanza("circondata_sud");
		this.circondata_sud.impostaStanzaAdiacente("sud", this.stanza_test);
		assertEquals(this.circondata_sud.getStanzaAdiacente("sud"), this.stanza_test);
	}
	
}
