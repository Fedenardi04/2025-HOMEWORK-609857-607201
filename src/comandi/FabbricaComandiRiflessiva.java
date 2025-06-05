package comandi;

import java.util.Scanner;

public class FabbricaComandiRiflessiva implements FabbricaDiComandi {
	@SuppressWarnings("deprecation")
	@Override
	public AbstractComando costruisciComando(String istruzione) throws Exception{
	
		AbstractComando result=null;
		
		//ricevo dall'utente nome e parametro del comando
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next(); // prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next(); // seconda parola: eventuale parametro
		
		//ricavo il nome della classe
		StringBuilder nomeClasse
		= new StringBuilder("comandi.Comando");
		nomeClasse.append( Character.toUpperCase(nomeComando.charAt(0)) );
		nomeClasse.append( nomeComando.substring(1) ) ;
		//creo il comando, noto utilizzo classe'class' 
		result=((Class<AbstractComando>)Class.forName(nomeClasse.toString())).newInstance();
		result.setParametro(parametro);
		
		return result;
	}
}
