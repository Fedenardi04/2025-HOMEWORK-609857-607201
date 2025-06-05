package ambienti;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import attrezzi.Attrezzo;
import direzioni.Direzione;

public class Labirinto {

	private Stanza stanzaIniziale;// stanza di ingresso
	private Stanza stanzaVincente;// stanza di uscita
	private Map<String ,Stanza> stanze;


	public static class LabirintoBuilder extends Labirinto {

		private Stanza ultima_stanza_aggiunta;

		public LabirintoBuilder() {
			super();
			this.ultima_stanza_aggiunta=null;
		}

		public LabirintoBuilder(String file) throws IOException {
			super(file);
			this.ultima_stanza_aggiunta=null;
		}


		public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
			Stanza s=new Stanza(nomeStanza);
			this.setStanzaIniziale(s);
			return this.addStanza(nomeStanza, true, false);
		}

		public LabirintoBuilder addStanzaVincente(String nomeStanza) {
			Stanza s=new Stanza(nomeStanza);
			this.setStanzaVincente(s);
			return this.addStanza(nomeStanza, false, true);
		}

		public LabirintoBuilder addStanza(String nomeStanza, boolean isIniziale, boolean isVincente) {
			//aggiungo stanza
			Stanza s=new Stanza(nomeStanza);
			this.getMappaStanze().put(nomeStanza, s);
			//aggiorno ultima_stanza
			this.ultima_stanza_aggiunta=s;
			if(isIniziale)
				this.setStanzaIniziale(s);
			if(isVincente)
				this.setStanzaVincente(s);

			return this;
		}

		public LabirintoBuilder addStanza(String nomeStanza) {
			return this.addStanza(nomeStanza, false, false);
		}
		public LabirintoBuilder addAdiacenza(String conAdiacenza, String adiacente, String direzione_string) {
			Direzione direzione=Direzione.valueOf(direzione_string);
			if(this.getMappaStanze().get(adiacente)!=null&&this.getMappaStanze().get(conAdiacenza)!=null) {
				this.getMappaStanze().get(conAdiacenza).impostaStanzaAdiacente(direzione, this.getMappaStanze().get(adiacente));


			}
			return this;
		}


		// dove? fa riferimento all’ultima stanza aggiunta
		public LabirintoBuilder addAttrezzo(String nome,int peso) {
			if(this.ultima_stanza_aggiunta==null)
				return null;
			Attrezzo a = new Attrezzo(nome, peso);
			this.ultima_stanza_aggiunta.addAttrezzo(a);
			return this;
		}

		public LabirintoBuilder addAttrezzo(String nome, String peso, String stanza) {
			if(peso!=null) {
				int peso_intero=Integer.parseInt(peso);
				this.getMappaStanze().get(stanza).addAttrezzo(new Attrezzo(nome, peso_intero));
			}
			return this;
		}

		public LabirintoBuilder getLabirinto() {
			return this;
		}

		public Collection<Stanza> getListaStanze() {

			return this.getMappaStanze().values();
		}

		public LabirintoBuilder addStanzaMagica(String nomeStanzaMagica, int sogliaMagica) {
			//caso in cui chiave sia già presente, non sovrascrivo
			if(this.getMappaStanze().get(nomeStanzaMagica)!=null)
				return null;
			//aggiungo stanza
			Stanza s=new StanzaMagica(nomeStanzaMagica, sogliaMagica);
			this.getMappaStanze().put(nomeStanzaMagica, s);
			//aggiorno ultima_stanza
			this.ultima_stanza_aggiunta=s;

			return this;
		}

		public LabirintoBuilder addStanzaBloccata(String nome, String direzione, String toolMagico) {
			//caso in cui chiave sia già presente, non sovrascrivo
			if(this.getMappaStanze().get(nome)!=null)
				return null;
			//aggiungo stanza
			Stanza s=new StanzaBloccata(nome, direzione, toolMagico);
			this.getMappaStanze().put(nome, s);
			//aggiorno ultima_stanza
			this.ultima_stanza_aggiunta=s;

			return this;
		}

		public LabirintoBuilder addStanzaBuia(String nome, String tool) {
			//caso in cui chiave sia già presente, non sovrascrivo
			if(this.getMappaStanze().get(nome)!=null)
				return null;
			//aggiungo stanza
			Stanza s=new StanzaBuia(nome, tool);
			this.getMappaStanze().put(nome, s);
			//aggiorno ultima_stanza
			this.ultima_stanza_aggiunta=s;

			return this;
		}

	}

	private Labirinto(String nomeFile) throws IOException {
		CaricatoreLabirinto c =
				new CaricatoreLabirinto(nomeFile);
		c.carica();
		this.stanzaIniziale = c.getStanzaIniziale();
		this.stanzaVincente = c.getStanzaVincente();
		this.stanze=c.getStanze();
	}

	private Labirinto() {
		this.stanze=new HashMap<String, Stanza>();
	}




	public static LabirintoBuilder newBuilder() {
		return new LabirintoBuilder();
	}

	public static LabirintoBuilder newBuilder(String file) throws IOException {
		return new LabirintoBuilder(file);
	}



	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}

	public Stanza getStanzaVincente() {
		return  this.stanzaVincente;
	}

	public void setStanzaIniziale(Stanza stanza) {
		this.stanzaIniziale=stanza;
	}

	public void setStanzaVincente(Stanza stanza) {
		this.stanzaVincente=stanza;
	}


	public Map<String ,Stanza> getMappaStanze(){
		return this.stanze;
	}

}

