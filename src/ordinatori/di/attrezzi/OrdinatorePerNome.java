package ordinatori.di.attrezzi;

import java.util.Comparator;

import attrezzi.Attrezzo;

public class OrdinatorePerNome implements Comparator<Attrezzo> {

	@Override
	public int compare(Attrezzo o1, Attrezzo o2) {
		if( o1.getNome().compareTo(o2.getNome())!=0 )
			return o1.getNome().compareTo(o2.getNome());
		return o1.getPeso()-o2.getPeso();
	}

}
