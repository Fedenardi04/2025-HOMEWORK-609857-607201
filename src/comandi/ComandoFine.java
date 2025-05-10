package comandi;

import diadia.IOConsole;
import diadia.Partita;

public class ComandoFine implements ComandoIn {

	@Override
	public void esegui(Partita partita) {
		IOConsole o=new IOConsole();
		o.mostraMessaggio("Grazie di aver giocato!");
		partita.setFinita();
		
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "fine";
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getResponso(Partita partita) {
		// TODO Auto-generated method stub
		return null;
	}

}
