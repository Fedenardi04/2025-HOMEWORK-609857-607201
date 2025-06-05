package comandi;

import diadia.IO;
import diadia.Partita;

public interface ComandoIn {
	/**
	 * esecuzione del comando
	 */
	public void esegui(Partita partita);
	
	/**
	* set parametro del comando
	*/
	public void setParametro(String parametro);

	public String getNome();

	public String getParametro();
	
	//esegue il comando e restituisce le stampe avvenute a seguito dell'esecuzione
//	public String getResponso(Partita partita);

	public void getResponso(Partita partita, IO console);
}
