package comandi;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;

public class ComandoPosa extends AbstractComando {
	
//	private String parametro;
	@Override
	
	// esegue il comando, aggiornando adeguatamente lo stato della partita
	public void esegui(Partita partita) {
		IOConsole o=new IOConsole();
		
		//caso in cui non sia stato dato il nome dell'attrezzo
		if(this.parametro==null) {
			o.mostraMessaggio("si scelga l'oggetto da posare");
			return;
		}
		//caso in cui nome dell'attrezzo non sia valido
		if(partita.getGiocatore().getBorsa().getAttrezzo(parametro)==null) {
			o.mostraMessaggio("il giocatore non dispone di tale oggetto");
			return;
		}
		
		//caso standard
		partita.getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().getAttrezzo(parametro));
		partita.getGiocatore().getBorsa().removeAttrezzo(parametro);
		
		//stampo una descrizione della situazione della stanza e del giocatore
		o.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		o.mostraMessaggio(partita.getGiocatore().getDescrizione());
	}

//	@Override
//	public void setParametro(String parametro) {
//		this.parametro=parametro;
//		
//	}

	@Override
	public String getNome() {
		return "posa";
	}

	@Override
	public String getParametro() {
		
		return this.parametro;
	}

	@Override
	public void getResponso(Partita partita, IO console) {
		// TODO Auto-generated method stub
		
	}

}
