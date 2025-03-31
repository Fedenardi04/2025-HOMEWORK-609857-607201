package giocatore;
//Giocatore ha la responsabilità di gestire i CFU del giocatore e di
//memorizzare gli attrezzi in un oggetto istanza della classe Borsa

import attrezzi.Attrezzo;

public class Giocatore {
	
	private Borsa miaBorsa;
	private int cfu;
	
	public void setGiocatore() {
		this.cfu=5;
		this.miaBorsa=new Borsa(10);
	}
	
	public void increaseCfu() {
		this.cfu=this.cfu+1;
	}
	
	public void decreaseCfu() {
		this.cfu=this.cfu-1;
	}
	
	public void prendiAttrezzo(Attrezzo nuovo) {
		this.miaBorsa.addAttrezzo(nuovo);
	}
	
	public void posaAttrezzo(String nomeAtt) {
		this.miaBorsa.removeAttrezzo(nomeAtt);	
	}
	
	public int getCfu() {
		return this.cfu;
	}
	
	public String getCfuStringato() {
		return " "+this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	
	public String getDescrizione() {
		return this.miaBorsa.toString();
	}
	
	public Borsa getBorsa() {
		return this.miaBorsa;
	}
	

	
	
}
