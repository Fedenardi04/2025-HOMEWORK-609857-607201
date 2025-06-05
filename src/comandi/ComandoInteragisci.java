package comandi;

import diadia.IO;
import diadia.Partita;
import personaggi.AbstractPersonaggio;

public class ComandoInteragisci extends AbstractComando {

	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio=
				partita.getStanzaCorrente().getPersonaggio();
		//non c'è alcun personaggio nella stanza corrente
		if(personaggio==null)
			return;
		personaggio.agisci(partita);
		return;
	}

	@Override
	public String getNome() {
		
		return "interagisci";
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getResponso(Partita partita, IO console) {
		// TODO Auto-generated method stub
		
	}

}
