package uui.ga.lab04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Populacija {
	
	private ArrayList<Jedinka> nizJedinki = new ArrayList<>();
	private int velicina;
	private double prosjecnaDobrota;
	
	public Populacija() {
		try {
			Scanner in = new Scanner(new FileReader("./konfiguracija/konfiguracija.txt"));
			while(!in.next().equals("Populacija"));
			this.velicina = in.nextInt();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Jedinka> dohvatiPopulaciju() {
		return nizJedinki;
	}
	public void postaviPopulaciju(ArrayList<Jedinka> nizJedinki) {
		this.nizJedinki = nizJedinki;
	}
	
	public void generirajPopulaciju() {
		for(int i = 0; i < velicina; i++) {
			Jedinka jedinka = new Jedinka();
			jedinka.generirajGene();
			nizJedinki.add(jedinka);
		}
	}
	
	public void izracunajProsjecnuDobrotu() {
		double suma = 0.0;
		for(int i = 0; i < nizJedinki.size(); i++) {
			suma += nizJedinki.get(i).dohvatiDobrotu();
		}
		prosjecnaDobrota = suma / nizJedinki.size();
	}
	
	public void izracunajVjerojatnostPrezivljavanja() {
		for(int i = 0; i < nizJedinki.size(); i++) {
			nizJedinki.get(i).postaviVjerojatnostPrezivljavanja(nizJedinki.get(i).dohvatiDobrotu()/prosjecnaDobrota);
		}
	}
	
	public double dohvatiProsjecnuDobrotu() {
		return prosjecnaDobrota;
	}
	
	public void sortirajPopulaciju() {
		nizJedinki.sort(new Comparator<Jedinka>() {

			@Override
			public int compare(Jedinka j1, Jedinka j2) {
				if(j1.dohvatiDobrotu() > j2.dohvatiDobrotu()) return -1;
				else if(j1.dohvatiDobrotu() < j2.dohvatiDobrotu()) return 1;
				else return 0;
			}
		});;
	}
	
	public void smanjiPopulaciju() {
		while(nizJedinki.size() > velicina) {
			nizJedinki.remove(nizJedinki.size()-1);
		}
	}

}
