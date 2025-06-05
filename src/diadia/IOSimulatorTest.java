package diadia;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IOSimulatorTest {
	private IOSimulator mio_io_sim;

	
	@BeforeEach
	void setUp() throws IOException  {

		mio_io_sim=new IOSimulator();
		DiaDia dia_dia=new DiaDia(mio_io_sim);
		mio_io_sim.setDiaDia(dia_dia);
	}


	//creo uno scenario dove do comando aiuto, vai sud, prendi lanterna
	@Test
	void test() throws Exception {
		//creo la sequenza di istruzioni
		List<String> comandi=new ArrayList<String>();
		comandi.add(0, "aiuto");
		comandi.add(1, "vai sud");
		comandi.add(2, "prendi lanterna");
		this.mio_io_sim.setComandi(comandi);
		
		//eseguo istruzioni e immagazzino risposta programma
		this.mio_io_sim.leggiRiga();
		this.mio_io_sim.leggiRiga();
		this.mio_io_sim.leggiRiga();

		//faccio le veiriche
		assertEquals(mio_io_sim.getStampe().get(0), "vai aiuto fine prendi posa ");

		assertEquals(mio_io_sim.getStampe().get(1), "N10"+"\nUscite: "+" nord"+
				"\nAttrezzi nella stanza: "+"lanterna "+""+"Borsa vuota");

		assertEquals(mio_io_sim.getStampe().get(2), "N10"+"\nUscite: "+" nord"+
				"\nAttrezzi nella stanza: "+"Contenuto borsa ("+"3"+"kg/"+"10"+"kg): "
				+"lanterna ");
	}

}
