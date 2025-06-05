package ambienti;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

import ambienti.Labirinto.LabirintoBuilder;

//Stanze: biblioteca, N10, N11
//Inizio: N10
//Vincente: N11
//Attrezzi: martello 10 biblioteca pinza 2 N10
//Uscite: biblioteca nord N10 biblioteca sud N11

public class CaricatoreLabirinto {

	private Labirinto.LabirintoBuilder l_builder;
	private String nome_file;
	


	public CaricatoreLabirinto(String nome_file) {
		this.l_builder=Labirinto.newBuilder();
		this.nome_file=nome_file;
	}

	

	public void carica() throws IOException {
		BufferedReader reader =
				new BufferedReader(new FileReader(nome_file));
				
		String line;
		//scandisco ogni riga del file, mi aspetto che abbia 5 righe
		//e ricordo che la prima parola è una parola chiave

		//prima linea, le stanze
		line = reader.readLine();
		Scanner scannerLinea = new Scanner(line);
		while(scannerLinea.hasNext()) {
			String word = scannerLinea.next();
			if(!(word.equals("Stanze:"))) {
				l_builder.addStanza(word);
			}
		}

		//seconda linea, stanza iniziale
		line = reader.readLine();
		scannerLinea = new Scanner(line);
		while(scannerLinea.hasNext()) {
			String word = scannerLinea.next();
			if(!word.equals("Inizio:")) {
				l_builder.addStanzaIniziale(word);
			}
		}

		//terza linea, stanza vincente
		line = reader.readLine();
		scannerLinea = new Scanner(line);
		while(scannerLinea.hasNext()) {
			String word = scannerLinea.next();
			if(!word.equals("Vincente:")) {
				l_builder.addStanzaVincente(word);
			}
		}
		//quarta linea, gli attrezzi
		line = reader.readLine();
		scannerLinea = new Scanner(line);
		while(scannerLinea.hasNext()) {
			String word = scannerLinea.next();
			if(!word.equals("Attrezzi:")) {
				String peso=scannerLinea.next();
				String stanza=scannerLinea.next();
				l_builder.addAttrezzo(word, peso, stanza);
			}
		}
		//quinta linea, le adiacenze
		line = reader.readLine();
		scannerLinea = new Scanner(line);
		while(scannerLinea.hasNext()) {
			String word = scannerLinea.next();
			if(!word.equals("Uscite:")) {
				String direzione=scannerLinea.next();
				String adiacente=scannerLinea.next();
				l_builder.addAdiacenza(word, adiacente, direzione);
			}
		}

		reader.close();
	}

	public Stanza getStanzaIniziale() {
		return this.l_builder.getStanzaIniziale();
	}

	public Stanza getStanzaVincente() {
		return this.l_builder.getStanzaVincente();	}

	public Map<String, Stanza> getStanze() {
		return this.l_builder.getMappaStanze();
	}
}
