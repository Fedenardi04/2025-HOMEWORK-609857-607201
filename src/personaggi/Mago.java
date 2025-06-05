package personaggi;

import attrezzi.Attrezzo;
import diadia.Partita;

public class Mago extends AbstractPersonaggio {

	private Attrezzo mio_attrezzo;

	public Mago(String nome, String presentazione, Attrezzo atrrezzo) {
		super(nome, presentazione);
		this.mio_attrezzo=mio_attrezzo;
	}

	@Override
	public void agisci(Partita partita) {
		partita.getGiocatore().prendiAttrezzo(mio_attrezzo);
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		attrezzo.SetPeso(attrezzo.getPeso()/2);
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		return"trovi l'attrezzo a peso dimezzato nella stanza";
	}
	
	

}
