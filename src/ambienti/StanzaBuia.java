package ambienti;

//La classe StanzaBuia deve avere una variabile di
//istanza di tipo String: memorizza il nome
//dell'attrezzo che consente di avere la descrizione
//completa della stanza
//• Il metodo getDescrizione() va sovrascritto
//affinché produca la descrizione usuale o la stringa
//"qui c'è buio pesto" a seconda che nella
//stanza ci sia o meno l'attrezzo richiesto per
//"vedere"
//• Il nome dell'attrezzo necessario viene impostato
//attraverso il costruttore

public class StanzaBuia extends Stanza {

	private String attrezzo_necessario;

	public StanzaBuia(String nome, String attrezzo_necessario) {
		super(nome);
		this.attrezzo_necessario=attrezzo_necessario;
	}

	@Override
	public String getDescrizione() {
		//controllo se in stanza c'è l'attrezzo necessario
		boolean check=false;
		for(int i=0; i<this.getAttrezzi().length; i++) {
			if(this.getAttrezzi()[i]!=null&&
					this.getAttrezzi()[i].toString().equals(attrezzo_necessario)) {
				check=true;
			}
		}
		if(!check) {
			return super.getDescrizione()+ "qui c'è un buio pesto";
		}
		return super.getDescrizione();
		
	}

}
