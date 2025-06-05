package comandi;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;

public class ComandoPrendi extends AbstractComando {

//	private String parametro;
	
	// esegue il comando, aggiornando adeguatamente lo stato della partita
	@Override
	public void esegui(Partita partita) {
		IOConsole o=new IOConsole();
		
		//caso in cui non sia stato dato il nome dell'attrezzo
		if(this.parametro==null) {
			o.mostraMessaggio("si scelga l'oggetto da posare");
			return;
		}
		
		//caso in cui la stanza non disponga dell'attrezzo scelto
		if(partita.getStanzaCorrente().getAttrezzo(parametro)==null) {
			o.mostraMessaggio("la stanza non dispone di tale oggetto");
			return;
		}
		
		//caso standard
		partita.getGiocatore().getBorsa().addAttrezzo(partita.getStanzaCorrente().getAttrezzo(parametro));
		partita.getStanzaCorrente().removeAttrezzo(parametro);
		
		//stampo una descrizione della situazione della stanza e del giocatore
		o.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		o.mostraMessaggio(partita.getGiocatore().getDescrizione());
		}
//	@Override
//	public void setParametro(String parametro) {
//		this.parametro=parametro;
//	}
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "prendi";
	}
	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.parametro;
	}

	
	@Override
	public void getResponso(Partita partita, IO console) {
		this.esegui(partita);
		console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione()+""+
		partita.getGiocatore().getDescrizione());
	}

	
	
}
