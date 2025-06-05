package comandi;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;

public class ComandoAiuto extends AbstractComando {
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};
	@Override
	public void esegui(Partita partita) {
		IOConsole o=new IOConsole();
		
		for(int i=0; i< this.elencoComandi.length; i++) 
			o.mostraMessaggio(this.elencoComandi[i]+" ");
		o.mostraMessaggio("");
		
	}


	@Override
	public String getNome() {
		
		return "aiuto";
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void getResponso(Partita partita, IO console) {
		this.esegui(partita);
		console.mostraMessaggio("vai aiuto fine prendi posa ");
	}

}
