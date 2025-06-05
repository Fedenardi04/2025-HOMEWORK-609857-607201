package comandi.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ambienti.Labirinto;
import ambienti.Labirinto;
import comandi.AbstractComando;
import comandi.ComandoIn;
import comandi.ComandoVai;
import diadia.DiaDia;
import diadia.IOConsole;
import diadia.Partita;

class ComandoVaiTest {

	private Labirinto.LabirintoBuilder mio_labirinto;
	private DiaDia mio_diadia;;
	private AbstractComando comando_vai;
	private String nomeStanzaIniziale;
	private String nomeStanzaVincente;

	@BeforeEach
	void setUp() throws Exception {
		mio_labirinto=new Labirinto.LabirintoBuilder();
		comando_vai=new ComandoVai();
		this.nomeStanzaIniziale="atrio";
		this.nomeStanzaVincente="uscita";
	}

	@Test
	public void testBilocale() {
		this.mio_labirinto
		.addStanzaIniziale(nomeStanzaIniziale)
		.addStanzaVincente(nomeStanzaVincente)
		.addAdiacenza(nomeStanzaIniziale, nomeStanzaVincente, "nord");

		this.mio_diadia=new DiaDia(new IOConsole(), mio_labirinto);
		this.comando_vai.setParametro("nord");
		this.comando_vai.esegui(this.mio_diadia.getPartita());
		assertTrue(this.mio_diadia.getPartita().isFinita());
	}

	@Test
	public void testBilocaleVadoInDirezioneSenzaAdiacenza() {
		this.mio_labirinto
		.addStanzaIniziale(nomeStanzaIniziale)
		.addStanzaVincente(nomeStanzaVincente)
		.addAdiacenza(nomeStanzaIniziale, nomeStanzaVincente, "nord");
		
		this.mio_diadia=new DiaDia(new IOConsole(), mio_labirinto);
		this.comando_vai.setParametro("est");
		this.comando_vai.esegui(this.mio_diadia.getPartita());
		
		assertEquals(nomeStanzaIniziale, this.mio_diadia.getPartita().getStanzaCorrente().getNome());		
	}
	
	@Test
	public void testTrilocaleAvantiEIndietro() {
		this.mio_labirinto
		.addStanzaIniziale(nomeStanzaIniziale)
		.addStanzaVincente(nomeStanzaVincente)
		.addStanza("stanza")
		.addAdiacenza(nomeStanzaIniziale, "stanza", "nord")
		.addAdiacenza("stanza", nomeStanzaIniziale, "sud");
		
		this.mio_diadia=new DiaDia(new IOConsole(), mio_labirinto);
		this.comando_vai.setParametro("nord");
		this.comando_vai.esegui(this.mio_diadia.getPartita());
		assertEquals("stanza", this.mio_diadia.getPartita().getStanzaCorrente().getNome());
		
		this.comando_vai.setParametro("sud");
		this.comando_vai.esegui(this.mio_diadia.getPartita());
		assertEquals(nomeStanzaIniziale, this.mio_diadia.getPartita().getStanzaCorrente().getNome());
	}

}
