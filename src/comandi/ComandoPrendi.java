package comandi;

import diadia.IOConsole;
import diadia.Partita;

public class ComandoPrendi implements ComandoIn {

	private String nome_attrezzo;
	
	// esegue il comando, aggiornando adeguatamente lo stato della partita
	@Override
	public void esegui(Partita partita) {
		IOConsole o=new IOConsole();
		
		//caso in cui non sia stato dato il nome dell'attrezzo
		if(this.nome_attrezzo==null) {
			o.mostraMessaggio("si scelga l'oggetto da posare");
			return;
		}
		
		//caso in cui la stanza non disponga dell'attrezzo scelto
		if(partita.getStanzaCorrente().getAttrezzo(nome_attrezzo)==null) {
			o.mostraMessaggio("la stanza non dispone di tale oggetto");
			return;
		}
		
		//caso standard
		partita.getGiocatore().getBorsa().addAttrezzo(partita.getStanzaCorrente().getAttrezzo(nome_attrezzo));
		partita.getStanzaCorrente().removeAttrezzo(nome_attrezzo);
		
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
		return "prendi";
	}
	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.nome_attrezzo;
	}
	@Override
	public String getResponso(Partita partita) {
		this.esegui(partita);
		return partita.getStanzaCorrente().getDescrizione()+""+
		partita.getGiocatore().getDescrizione();
	}

	
	
}
