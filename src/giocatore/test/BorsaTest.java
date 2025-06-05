package giocatore.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import attrezzi.Attrezzo;
import giocatore.Borsa;

class BorsaTest {
	
	Borsa mia_borsa=new Borsa();
	private Attrezzo pesante;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;

	@BeforeEach
	void setUp() throws Exception {
		this.pesante=new Attrezzo("pesante", 11);
		this.attrezzo1=new Attrezzo("a1", 3);
		this.attrezzo2=new Attrezzo("a1", 4);
	}

	@Test
	void testTroppoPesante() {
		assertFalse(mia_borsa.addAttrezzo(pesante));
		assertTrue(mia_borsa.isEmpty());
	}
	
	@Test
	void testAggiungoDueAttrezzi() {
		mia_borsa.addAttrezzo(attrezzo1);
		mia_borsa.addAttrezzo(attrezzo2);
		assertTrue(mia_borsa.getPeso()==7);
		assertTrue(mia_borsa.getArrayAttrezzi().size()==2);
		assertTrue(mia_borsa.getArrayAttrezzi().contains(attrezzo1));
		assertTrue(mia_borsa.getArrayAttrezzi().contains(attrezzo2));
	}
	
	@Test
	void testAggiungoDueAttrezzi2() {
		mia_borsa.addAttrezzo(attrezzo1);
		mia_borsa.addAttrezzo(pesante);
		assertTrue(mia_borsa.getArrayAttrezzi().size()==1);
		assertTrue(mia_borsa.getPeso()==3);
	}

	@Test
	void testRimuovo() {
		mia_borsa.addAttrezzo(attrezzo1);
		mia_borsa.removeAttrezzo("a1");
		assertTrue(mia_borsa.isEmpty());
	}
	
	@Test
	void testGetContenutoRaggruppatoPerPeso() {
		mia_borsa.addAttrezzo(attrezzo1);
		mia_borsa.addAttrezzo(attrezzo2);
		Map<Integer,Set<Attrezzo>> result=mia_borsa.getContenutoRaggruppatoPerPeso();
		assertNotNull(result.get(3));
		assertNotNull(result.get(4));
	}
	void testGetContenutoRaggruppatoPerPeso2() {
		mia_borsa.addAttrezzo(attrezzo1);
		Attrezzo a_di_peso_3=new Attrezzo("bo", 3);
		mia_borsa.addAttrezzo(a_di_peso_3);
		Map<Integer,Set<Attrezzo>> result=mia_borsa.getContenutoRaggruppatoPerPeso();
		assertNotNull(result.get(3));
		assertTrue(result.get(3).size()==2);
	}
}
