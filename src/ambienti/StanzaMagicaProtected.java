package ambienti;

import attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected {
	private int contatoreAttrezziPosati;
	//noto come numero attrezzi posati non coincida con numero totale degli attrezzi
	private int sogliaMagica;
	static final int SOGLIA_MAGICA_DEFAULT = 1;

	//costruttori
	public StanzaMagicaProtected(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati=0;
		this.sogliaMagica=soglia;
	}

	public StanzaMagicaProtected(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}


	//riceve attrezzo ne crea uno con nome invertito e peso doppio
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {

		//null check
		if(attrezzo==null) {
			return null;
		}
		int lunghezzaNome=attrezzo.getNome().length();
		String nome=attrezzo.getNome();		
		//costruisco nuovo nome
		StringBuilder sb = new StringBuilder();
		for(int i=lunghezzaNome-1; i>=0; i--) {
			sb.append(nome.charAt(i));
		}
		String nuovoNome=sb.toString();			
		Attrezzo a=new Attrezzo(nuovoNome, attrezzo.getPeso()*2);
		return a;
	}

	//aggiunge attrezzo modificato alla stanza
	@Override
	//comunica a compilatore che parametri devono essere gli stessi del supertipo
	public boolean addAttrezzo(Attrezzo attrezzo) {

		if (this.contatoreAttrezziPosati>=this.sogliaMagica)
			attrezzo = this.modificaAttrezzo(attrezzo);
		if(super.addAttrezzo(attrezzo)) {
			this.contatoreAttrezziPosati++;
			return true;
		}
		return false;

	}
}
