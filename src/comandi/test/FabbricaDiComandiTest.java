package comandi.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import comandi.AbstractComando;
import comandi.ComandoAiuto;
import comandi.ComandoIn;
import comandi.ComandoNonValido;
import comandi.ComandoVai;
import comandi.FabbricaDiComandi;
import comandi.FabbricaDiComandiNonRiflessiva;


//Scrivere i test di unità su questa classe concreta
//ma limitarsi alla sola verifica del corretto
//riconoscimento dei comandi

class FabbricaDiComandiTest {
	
	FabbricaDiComandi mia_fabbrica;
	AbstractComando comando_vai;
	AbstractComando comando_aiuto;
	AbstractComando comando_non_valido;
	
	@BeforeEach
	void setUp()  {
		mia_fabbrica=new FabbricaDiComandiNonRiflessiva();
		comando_vai=new ComandoVai();
		comando_aiuto=new ComandoAiuto();	
		comando_non_valido=new ComandoNonValido();
		}

	@Test
	void test() throws Exception {
		comando_vai.setParametro("nord");
		AbstractComando v=mia_fabbrica.costruisciComando("vai nord");
		//
		assertEquals(v.getNome(), comando_vai.getNome());
		assertEquals(v.getParametro(), comando_vai.getParametro());
		//aiuto
		AbstractComando a=mia_fabbrica.costruisciComando("aiuto");
		assertEquals(a.getNome(), comando_aiuto.getNome());
		assertNull(a.getParametro());
		//comando non valido
		AbstractComando n1=mia_fabbrica.costruisciComando("aiu");//parola non valida
		assertEquals(n1.getNome(), comando_non_valido.getNome());
		assertEquals(n1.getParametro(), comando_non_valido.getParametro());
		//superfluo
		assertNull(n1.getNome());
	}

}
