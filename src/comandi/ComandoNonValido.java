package comandi;

import diadia.Partita;

public class ComandoNonValido implements ComandoIn {

	@Override
	public void esegui(Partita partita) {
		System.out.println("il comando selezionato non è valido");

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

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
	public String getResponso(Partita partita) {
		// TODO Auto-generated method stub
		return null;
	}

}
