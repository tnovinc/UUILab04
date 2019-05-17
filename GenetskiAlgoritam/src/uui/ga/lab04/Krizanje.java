package uui.ga.lab04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Krizanje {
	
	private double vjerojatnost;
	
	public Krizanje() {
		try {
			Scanner in = new Scanner(new FileReader("./konfiguracija/konfiguracija.txt"));
			while(!in.next().equals("Krizanje"));
			this.vjerojatnost = in.nextDouble();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Populacija krizaj(Populacija populacija) {
		int brojKrizanja = populacija.dohvatiPopulaciju().size()/2;
		for(int i = 0; i < brojKrizanja; i++) {
			Jedinka roditelj1 = populacija.dohvatiPopulaciju().get((int)(Math.random() * (populacija.dohvatiPopulaciju().size()-1)));
			while(roditelj1.jeKrizan()) {
				roditelj1 = populacija.dohvatiPopulaciju().get((int)(Math.random() * (populacija.dohvatiPopulaciju().size()-1)));
			}
			
			Jedinka roditelj2 = populacija.dohvatiPopulaciju().get((int)(Math.random() * (populacija.dohvatiPopulaciju().size()-1)));
			while(roditelj1 == roditelj2 || roditelj2.jeKrizan()) {
				roditelj2 = populacija.dohvatiPopulaciju().get((int)(Math.random() * (populacija.dohvatiPopulaciju().size()-1)));
			}
			
			roditelj1.postaviKrizan(true);
			roditelj2.postaviKrizan(true);
			
			if(Math.random() < vjerojatnost) {
				Jedinka dijete = new Jedinka();
				for(int j = 0; j < roditelj1.dohvatiGene().size(); j++) {
					if(Math.random() > 0.5 && (roditelj1.dohvatiGene().get(j).dohvatiVrijednost() != roditelj2.dohvatiGene().get(j).dohvatiVrijednost())) {
						dijete.dohvatiGene().add(new Gen(roditelj2.dohvatiGene().get(j).dohvatiVrijednost()));
					}
					else {
						dijete.dohvatiGene().add(new Gen(roditelj1.dohvatiGene().get(j).dohvatiVrijednost()));
					}
				}
				dijete.izracunajDobrotu();
				populacija.dohvatiPopulaciju().add(dijete);
			}		
		}
		for(int i = 0; i < populacija.dohvatiPopulaciju().size(); i++) {
			populacija.dohvatiPopulaciju().get(i).postaviKrizan(false);
		}
		return populacija;
	}

}
