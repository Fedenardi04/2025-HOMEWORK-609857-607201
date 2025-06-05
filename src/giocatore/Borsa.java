package giocatore;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import attrezzi.Attrezzo;
import ordinatori.di.attrezzi.OrdinatorePerNome;
import ordinatori.di.attrezzi.OrdinatorePerPeso;


//NB: si assume che iin labirinto non ci siano attrezzi con nome uguale &&
//uso hashSet per borsa->non mi sforzo di sistemare equals e hash code di attrezzo 
public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	//private Attrezzo[] attrezzi;
	//private int numeroAttrezzi;
	private Set<Attrezzo> attrezzi;
	private int pesoMax;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		//		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		//	    this.numeroAttrezzi = 0;
		this.attrezzi = new HashSet<Attrezzo>();
		this.pesoMax = pesoMax;
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		return this.attrezzi.add(attrezzo);
		//		if (this.numeroAttrezzi==10)
		//			return false;
		//		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		//		this.numeroAttrezzi++;
		//		return true;
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		//		Attrezzo a = null;
		//		for (int i= 0; i<this.numeroAttrezzi; i++)
		//			if (this.attrezzi[i]!=null&&this.attrezzi[i].getNome().equals(nomeAttrezzo))
		//				a = attrezzi[i];
		//
		//		return a;
		return this.getAttrezzo(nomeAttrezzo);
	}


	public int getPeso() {
		//		int peso = 0;
		//		for (int i= 0; i<this.numeroAttrezzi; i++) {
		//			if(attrezzi[i]!=null) {
		//				peso += this.attrezzi[i].getPeso();
		//			}
		//		}
		//
		//		return peso;
		int peso = 0;
		for(Attrezzo a : this.attrezzi) {
			peso=peso+a.getPeso();
		}
		return peso;
	}
	public boolean isEmpty() {
		//		return this.numeroAttrezzi == 0;
		return this.attrezzi.isEmpty();
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	public void removeAttrezzo(String nomeAttrezzo) {

		//		for(int i=0; i<10; i++) {
		//			if(this.attrezzi[i]!=null&&this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
		//				this.attrezzi[i]=null;
		//				//this.numeroAttrezzi--;
		//			}
		//		}
		Iterator<Attrezzo> it=this.attrezzi.iterator();
		Attrezzo a=null;
		while(it.hasNext()) {
			a=it.next();
			if(a!=null&&a.getNome().equals(nomeAttrezzo)) {
				it.remove();
				//rimuove ultimo elem estratto da chiamata di next
				//ricordo che posso modificare solo attreverso iteratore durente iteraz.
			}
		}
	}
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			//			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			//			for (int i= 0; i<this.numeroAttrezzi; i++) {
			//				if(attrezzi[i]!=null) {
			//					s.append(attrezzi[i].toString()+" ");
			//				}
			//			}
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (Attrezzo a : attrezzi) {
				if(a!=null) {
					s.append(a.toString()+" ");
				}
			}
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}

	public Set<Attrezzo> getArrayAttrezzi() {
		return this.attrezzi;
	}

	List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> result=new LinkedList<Attrezzo>();
		result.addAll(this.attrezzi);
		OrdinatorePerPeso order=new OrdinatorePerPeso();
		result.sort(order);

		return result;		
	}

	SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		OrdinatorePerNome order=new OrdinatorePerNome();
		SortedSet<Attrezzo> result= new TreeSet<>(order);
		result.addAll(this.attrezzi);

		return result;
	}

	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> result=new HashMap<Integer, Set<Attrezzo>>();
		//scorro i miei attrezzi e aggiungo...
		for(Attrezzo corrente : this.attrezzi) {
			Integer peso_attrezzo_corrente=corrente.getPeso();
			Set<Attrezzo> s=result.get(peso_attrezzo_corrente);
			//c'è già un set associato a questa chiave?
			if(s==null) {
				s=new HashSet<Attrezzo>();
				result.put(peso_attrezzo_corrente, s);
			}
			s.add(corrente);
		}
		return result;
	}
	
	public void stampaRaggruppandoPerPeso() {
		Map<Integer,Set<Attrezzo>> da_stampare=this.getContenutoRaggruppatoPerPeso();
		for(Integer chiave_corrente : da_stampare.keySet()) {
			StringBuilder s = new StringBuilder();
			for(Attrezzo attrezzo_corrente : da_stampare.get(chiave_corrente)) {
				s.append(" "+attrezzo_corrente.toString());
			}
			System.out.println("attrezzi di peso "+chiave_corrente+s);
		}
	}
	
	SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		OrdinatorePerPeso order=new OrdinatorePerPeso();
		SortedSet<Attrezzo> result= new TreeSet<>(order);
		result.addAll(this.attrezzi);

		return result;
	}
}