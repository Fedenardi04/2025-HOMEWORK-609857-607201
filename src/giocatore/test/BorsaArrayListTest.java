package giocatore.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import attrezzi.Attrezzo;
import giocatore.BorsaArrayList;

class BorsaArrayListTest {
	private BorsaArrayList mia_borsa;
	
	@BeforeEach
	public void setUp() {
		mia_borsa=new BorsaArrayList();
	}

	@Test
	void testAdd() {
		assertTrue(mia_borsa.getArray().isEmpty());
		Attrezzo a=new Attrezzo("osso", 3);
		mia_borsa.addAttrezzo(a);
		assertSame(mia_borsa.getArray().get(0), a);
	}
	
	@Test
	void testRemove() {
		String da_rimuovere="osso";
		
		Attrezzo a=new Attrezzo("osso", 3);
		mia_borsa.getArray().add(a);
		Attrezzo b=new Attrezzo("mazza", 3);
		mia_borsa.getArray().add(b);
		assertSame(2, mia_borsa.getArray().size());
		mia_borsa.removeAttrezzo(da_rimuovere);	
		assertSame(1, mia_borsa.getArray().size());
	}

}
