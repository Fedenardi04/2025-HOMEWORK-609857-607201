package diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IOSimulatorTest {
	private IOSimulator mio_io_sim;

	@BeforeEach
	void setUp()  {
		IO console=new IOConsole();
		DiaDia dia_dia=new DiaDia(console);
		mio_io_sim=new IOSimulator(dia_dia);
	}

	//creo uno scenario dove do comando aiuto, vai sud, prendi lanterna
	@Test
	void test() {
		//creo la sequenza di istruzioni
		String[] comandi=new String[3];
		comandi[0]="aiuto";
		comandi[1]="vai sud";
		comandi[2]="prendi lanterna";
		this.mio_io_sim.setComandi(comandi);
		
		//eseguo la sequenza in diadia, contestualmente inserisco in array stampe
		//primo comando
		String s1=this.mio_io_sim.leggiRiga();
		this.mio_io_sim.mostraMessaggio(s1);
		//secondo
		String s2=this.mio_io_sim.leggiRiga();
		this.mio_io_sim.mostraMessaggio(s2);
		//terzo
		String s3=this.mio_io_sim.leggiRiga();
		this.mio_io_sim.mostraMessaggio(s3);
		
		//faccio le veiriche
		assertEquals(mio_io_sim.getStampe()[0], "vai aiuto fine prendi posa ");
		
		assertEquals(mio_io_sim.getStampe()[1], "Aula N10"+"\nUscite: "+" nord est ovest"+
		"\nAttrezzi nella stanza: "+"lanterna "+""+"Borsa vuota");
		
		assertEquals(mio_io_sim.getStampe()[2], "Aula N10"+"\nUscite: "+" nord est ovest"+
		"\nAttrezzi nella stanza: "+"Contenuto borsa ("+"3"+"kg/"+"10"+"kg): "
		+"lanterna ");
	}

}
