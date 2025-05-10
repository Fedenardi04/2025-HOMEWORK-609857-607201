package comandi.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import comandi.ComandoAiuto;
import comandi.ComandoIn;
import comandi.ComandoNonValido;
import comandi.ComandoVai;
import comandi.FabbricaDiComandi;


//Scrivere i test di unità su questa classe concreta
//ma limitarsi alla sola verifica del corretto
//riconoscimento dei comandi

class FabbricaDiComandiTest {
	
	FabbricaDiComandi mia_fabbrica;
	ComandoIn comando_vai;
	ComandoIn comando_aiuto;
	ComandoIn comando_non_valido;
	
	@BeforeEach
	void setUp()  {
		mia_fabbrica=new FabbricaDiComandi();
		comando_vai=new ComandoVai();
		comando_aiuto=new ComandoAiuto();	
		comando_non_valido=new ComandoNonValido();
		}

	@Test
	void test() {
		comando_vai.setParametro("nord");
		ComandoIn v=mia_fabbrica.costruisciComando("vai nord");
		//
		assertEquals(v.getNome(), comando_vai.getNome());
		assertEquals(v.getParametro(), comando_vai.getParametro());
		//aiuto
		ComandoIn a=mia_fabbrica.costruisciComando("aiuto");
		assertEquals(a.getNome(), comando_aiuto.getNome());
		assertNull(a.getParametro());
		//comando non valido
		ComandoIn n1=mia_fabbrica.costruisciComando("aiu");//parola non valida
		assertEquals(n1.getNome(), comando_non_valido.getNome());
		assertEquals(n1.getParametro(), comando_non_valido.getParametro());
		//superfluo
		assertNull(n1.getNome());
	}

}
