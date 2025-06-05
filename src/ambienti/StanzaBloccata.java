package ambienti;

import direzioni.Direzione;

public class StanzaBloccata extends Stanza {
	
	String mio_pass;
	String  mia_direzione_bloccata;

	public StanzaBloccata(String nome, String pass, String direzione_bloccata) {
		super(nome);
		this.mio_pass=pass;
		this.mia_direzione_bloccata=direzione_bloccata;
	}
	
	@Override 
	public String getDescrizione() {
		boolean check=this.getAttrezzo(mio_pass)!=null;
		if(!check) {
			return super.getDescrizione()+ "c'è una direzione bloccata";
		}
		return super.getDescrizione();
		
	}
	
	@Override
//	– se nella stanza non è presente l'attrezzo sbloccante, il
//	metodo ritorna un riferimento alla stanza corrente
//	– altrimenti ha l’usuale comportamento (ritorna la stanza
//	corrispondente all'uscita specificata)
	public Stanza getStanzaAdiacente(Direzione dir) {
		//caso in cui direzione deisderata sia diversa da direzione bloccata
		//oppure c'è l'attrezzo pass->restituisco stanza ad normalmente
		if(!dir.equals(mia_direzione_bloccata)||
			this.getAttrezzo(this.mio_pass)!=null) {
//			return super.getStanzaAdiacente(dir);
			return super.getStanzaAdiacente(dir);
		}
		
		return this;
	}

	
	
	
	private String getDirezioneBloccata() {		
		return this.mia_direzione_bloccata;
	}

}
