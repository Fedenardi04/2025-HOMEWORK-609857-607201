package comandi;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;

public class ComandoFine extends AbstractComando {

	@Override
	public void esegui(Partita partita) {
		IOConsole o=new IOConsole();
		o.mostraMessaggio("Grazie di aver giocato!");
		partita.setFinita();
		
	}

//	@Override
//	public void setParametro(String parametro) {
//		// TODO Auto-generated method stub
//		
//	}

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
	public void getResponso(Partita partita, IO console) {
		// TODO Auto-generated method stub
		
	}

}
