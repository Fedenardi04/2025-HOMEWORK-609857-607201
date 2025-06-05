package personaggi;

import java.util.Collection;

import ambienti.Stanza;
import attrezzi.Attrezzo;
import diadia.Partita;

public class Strega extends AbstractPersonaggio {


	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}

	//porta il personaggio nella stanza con più atttrezzi
	@Override
	public void agisci(Partita partita) {
		
		Collection<Stanza> stanze_adiacenti=
				partita.getStanzaCorrente().getMapStanzeAdiacenti().values();
		
		Stanza scelta=null;
		if(haSalutato()) {
			int max_attrezzi=0;//stanza non ha meno di zero attrezzi
			for(Stanza s : stanze_adiacenti) {
				if(s.getNumeroAttrezzi()>=max_attrezzi) {
					scelta=s;
					max_attrezzi=s.getNumeroAttrezzi();
				}
			}
		}
		else {
			int min_attrezzi=50;//numero->infinito
			for(Stanza s : stanze_adiacenti) {
				if(s.getNumeroAttrezzi()<=min_attrezzi) {
					scelta=s;
					min_attrezzi=s.getNumeroAttrezzi();
				}
			}
		}
		//non ci sono stanze adiacenti, non avviene nulla
		if(scelta==null)
			return;
		partita.setStanzaCorrente(scelta);
		return;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita p) {
		return "ahahahah molto utile";
	}
}
