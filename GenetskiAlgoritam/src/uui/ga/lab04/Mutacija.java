package uui.ga.lab04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Mutacija {
	
	private double vjerojatnost;
	
	public Mutacija() {
		try {
			Scanner in = new Scanner(new FileReader("./konfiguracija/konfiguracija.txt"));
			while(!in.next().equals("Mutacija"));
			this.vjerojatnost = in.nextDouble();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Populacija mutiraj(Populacija populacija) {
		for(int i = 0; i < populacija.dohvatiPopulaciju().size(); i ++) {
			for(int j = 0; j < populacija.dohvatiPopulaciju().get(i).dohvatiGene().size(); j++) {
				Gen trenutniGen = populacija.dohvatiPopulaciju().get(i).dohvatiGene().get(j);
				if(Math.random() < vjerojatnost) {
					trenutniGen.postaviVrijednost(trenutniGen.dohvatiVrijednost()^1);
				}
			}
			populacija.dohvatiPopulaciju().get(i).izracunajDobrotu();
		}
		return populacija;
	}

}
