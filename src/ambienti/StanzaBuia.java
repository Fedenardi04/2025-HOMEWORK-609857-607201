package ambienti;

//La classe StanzaBuia deve avere una variabile di
//istanza di tipo String: memorizza il nome
//dell'attrezzo che consente di avere la descrizione
//completa della stanza
//� Il metodo getDescrizione() va sovrascritto
//affinch� produca la descrizione usuale o la stringa
//"qui c'� buio pesto" a seconda che nella
//stanza ci sia o meno l'attrezzo richiesto per
//"vedere"
//� Il nome dell'attrezzo necessario viene impostato
//attraverso il costruttore

public class StanzaBuia extends Stanza {

	private String attrezzo_necessario;

	public StanzaBuia(String nome, String attrezzo_necessario) {
		super(nome);
		this.attrezzo_necessario=attrezzo_necessario;
	}

	@Override
	public String getDescrizione() {
		//controllo se in stanza c'� l'attrezzo necessario
		boolean check=false;
		for(int i=0; i<this.getAttrezzi().length; i++) {
			if(this.getAttrezzi()[i]!=null&&
					this.getAttrezzi()[i].toString().equals(attrezzo_necessario)) {
				check=true;
			}
		}
		if(!check) {
			return super.getDescrizione()+ "qui c'� un buio pesto";
		}
		return super.getDescrizione();
		
	}

}
