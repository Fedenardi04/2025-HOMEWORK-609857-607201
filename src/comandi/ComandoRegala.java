package comandi;

import attrezzi.Attrezzo;
import diadia.IO;
import diadia.Partita;

public class ComandoRegala extends AbstractComando {
	
	@Override
	public void esegui(Partita partita) {
		//se giocatore non ha l'attrezzo non lo può regalare 
		//se non c'è personaggio a cui fare il regalo...
		if(partita.getStanzaCorrente().getPersonaggio()==null
				||
			!(partita.getGiocatore().getBorsa().hasAttrezzo(parametro)))
			return;
		
		partita.getStanzaCorrente().getPersonaggio().riceviRegalo(partita.getGiocatore().getBorsa().getAttrezzo(parametro) ,partita);
		
		partita.getGiocatore().getBorsa().removeAttrezzo(parametro);
		return;
	}
	

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
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
