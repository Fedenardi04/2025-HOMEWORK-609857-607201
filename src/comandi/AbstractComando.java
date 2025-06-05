package comandi;

import diadia.IO;
import diadia.Partita;

public abstract class AbstractComando {
	protected String parametro;
	
	/**
	 * esecuzione del comando
	 */
	public abstract void esegui(Partita partita);
	
	/**
	* set parametro del comando
	*/
	public void setParametro(String parametro) {
		this.parametro=parametro;
	}

	public abstract String getNome();

	public abstract String getParametro();
	
	//esegue il comando e restituisce le stampe avvenute a seguito dell'esecuzione
//	public String getResponso(Partita partita);

	public abstract void getResponso(Partita partita, IO console);
}
