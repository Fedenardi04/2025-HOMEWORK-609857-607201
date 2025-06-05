package personaggi;

import attrezzi.Attrezzo;
import diadia.Partita;

//
public abstract class AbstractPersonaggio {
	private String nome;
	private String presentazione;
	private boolean ha_salutato;


	public AbstractPersonaggio(String nome, String presentazione) {
		this.nome=nome;
		this.presentazione=presentazione;
		ha_salutato=false;
	}

	public boolean haSalutato() {
		return this.ha_salutato;
	}

	public abstract void agisci(Partita partita);
	
	public abstract String riceviRegalo(Attrezzo attrezzo, Partita partita);

	public String saluta() {
		StringBuilder risposta =
				new StringBuilder("Ciao, io sono ");

		risposta.append(this.getNome()+".");
		if (!haSalutato())
			risposta.append(this.getPresentazione());

		else
			risposta.append("Ci siamo gia' presentati!");

		this.ha_salutato = true;
		return risposta.toString();
	}

	public String getPresentazione() {
		return this.presentazione;
	}

	public String getNome() {
		return this.nome;
	}

	
}
