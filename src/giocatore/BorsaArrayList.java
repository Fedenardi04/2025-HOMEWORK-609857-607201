package giocatore;
import java.util.*;

import attrezzi.Attrezzo;

public class BorsaArrayList extends Borsa {
	
	private ArrayList<Attrezzo> array_di_attrezzi;
	
	public BorsaArrayList() {
		super(DEFAULT_PESO_MAX_BORSA);
		this.array_di_attrezzi=new ArrayList<Attrezzo>();
	}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo==null) {
			return false;
		}
		return array_di_attrezzi.add(attrezzo);
	}
	
	@Override
	public void removeAttrezzo(String nome_attrezzo) {
		Iterator<Attrezzo> it=this.array_di_attrezzi.iterator();
		Attrezzo a=null;
		while(it.hasNext()) {
			a=it.next();
			if(a!=null&&a.getNome().equals(nome_attrezzo)) {
				it.remove();
				//rimuove ultimo elem estratto da chiamata di next
				//ricordo che posso modificare solo attreverso iteratore durente iteraz.
			}
		}
	}
	
	public ArrayList<Attrezzo> getArray(){
		return this.array_di_attrezzi;
	}
}
