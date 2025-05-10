package comandi;

import diadia.IOConsole;
import diadia.Partita;

public class ComandoAiuto implements ComandoIn {
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};
	@Override
	public void esegui(Partita partita) {
		IOConsole o=new IOConsole();
		
		for(int i=0; i< this.elencoComandi.length; i++) 
			o.mostraMessaggio(this.elencoComandi[i]+" ");
		o.mostraMessaggio("");
		
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
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
	public String getResponso(Partita partita) {
		this.esegui(partita);
		return"vai aiuto fine prendi posa ";
	}

}
