package comandi;

import diadia.IOConsole;
import diadia.Partita;

public class ComandoPosa implements ComandoIn {
	
	private String nome_attrezzo;
	@Override
	
	// esegue il comando, aggiornando adeguatamente lo stato della partita
	public void esegui(Partita partita) {
		IOConsole o=new IOConsole();
		
		//caso in cui non sia stato dato il nome dell'attrezzo
		if(this.nome_attrezzo==null) {
			o.mostraMessaggio("si scelga l'oggetto da posare");
			return;
		}
		//caso in cui nome dell'attrezzo non sia valido
		if(partita.getGiocatore().getBorsa().getAttrezzo(nome_attrezzo)==null) {
			o.mostraMessaggio("il giocatore non dispone di tale oggetto");
			return;
		}
		
		//caso standard
		partita.getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().getAttrezzo(nome_attrezzo));
		partita.getGiocatore().getBorsa().removeAttrezzo(nome_attrezzo);
		
		//stampo una descrizione della situazione della stanza e del giocatore
		o.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		o.mostraMessaggio(partita.getGiocatore().getDescrizione());
	}

	@Override
	public void setParametro(String parametro) {
		this.nome_attrezzo=parametro;
		
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "posa";
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.nome_attrezzo;
	}

	@Override
	public String getResponso(Partita partita) {
		// TODO Auto-generated method stub
		return null;
	}

}
