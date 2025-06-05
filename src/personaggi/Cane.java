package personaggi;

import attrezzi.Attrezzo;
import diadia.Partita;

public class Cane extends AbstractPersonaggio {
	private boolean regalo_ricevuto;
	private String cibo_preferito;
	private Attrezzo attrezzo_corrente;

	public Cane(String nome, String presentazione, String cibo, Attrezzo a) {
		super(nome, presentazione);
		cibo_preferito=cibo;
		attrezzo_corrente=a;
		regalo_ricevuto=false;
	}

	@Override
	public void agisci(Partita partita) {
		partita.getGiocatore().decreaseCfu();
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(attrezzo!=null&&attrezzo.getNome().equals(cibo_preferito)) {
			partita.getStanzaCorrente().addAttrezzo(attrezzo_corrente);
			attrezzo_corrente=attrezzo;
			return "che buono!";
		}
		else {
			this.agisci(partita);
			return "disgusting";
		}
	}

}
