package ordinatori.di.attrezzi;

import java.util.Comparator;

import attrezzi.Attrezzo;

//in ordine crescente
public class OrdinatorePerPeso implements Comparator<Attrezzo> {

	@Override
	public int compare(Attrezzo o1, Attrezzo o2) {
		if(o1.getPeso()-o2.getPeso()!=0)
			return o1.getPeso()-o2.getPeso();
		return o1.getNome().compareTo(o2.getNome());
	}

}
