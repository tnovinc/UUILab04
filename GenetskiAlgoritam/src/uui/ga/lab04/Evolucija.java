package uui.ga.lab04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Evolucija {
	
	private int brojIteracija;
	private Jedinka najboljaJedinka;
	private Populacija populacija = new Populacija();
	private Krizanje funkcijaKrizanja = new Krizanje();
	private Mutacija funkcijaMutacije = new Mutacija();
	
	public Evolucija() {
		try {
			Scanner in = new Scanner(new FileReader("./konfiguracija/konfiguracija.txt"));
			while(!in.next().equals("Iteracije"));
			this.brojIteracija = in.nextInt();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		populacija.generirajPopulaciju();
		pronadiNajboljuJedinku();
		populacija.izracunajProsjecnuDobrotu();
		populacija.izracunajVjerojatnostPrezivljavanja();
	}
	
	public void evoluiraj() {
		ispis(0);
		for(int i = 0; i < brojIteracija; i++) {
			if(najboljaJedinka.dohvatiDobrotu() == 270.0) {
				ispis(i+1);
				System.out.println("Rjesenje pronadeno nakon " + (i+1) + " iteracija.");
				break;
			}
			selekcija();
			populacija = funkcijaKrizanja.krizaj(populacija);
			populacija = funkcijaMutacije.mutiraj(populacija);
			populacija.izracunajProsjecnuDobrotu();
			populacija.izracunajVjerojatnostPrezivljavanja();
			pronadiNajboljuJedinku();
			ispis(i+1);
		}		
	}
	
	public Jedinka dohvatiNajboljuJedinku() {
		return najboljaJedinka;
	}
	
	private void pronadiNajboljuJedinku() {
		double maxDobrota = 0;
		for(int i = 0; i < populacija.dohvatiPopulaciju().size(); i++) {
			if(populacija.dohvatiPopulaciju().get(i).dohvatiDobrotu() > maxDobrota) {
				najboljaJedinka = populacija.dohvatiPopulaciju().get(i);
				maxDobrota = najboljaJedinka.dohvatiDobrotu();
			}
		}
	}
	
	private void selekcija() {
		for(int i = 0; i < populacija.dohvatiPopulaciju().size(); i++) {
			if(Math.random() > populacija.dohvatiPopulaciju().get(i).dohvatiVjerojatnostPrezivljavanja() && (populacija.dohvatiPopulaciju().get(i) != najboljaJedinka)) {
				populacija.dohvatiPopulaciju().remove(i);
			}
		}
	}
	
	private void ispis(int iteracija) {
		System.out.println(iteracija + ". Iteracija");
		System.out.println("Maksimalna dobrota = " + najboljaJedinka.dohvatiDobrotu());
		System.out.println("Normirane vrijednosti:");
		for(int i = 0; i < populacija.dohvatiPopulaciju().size(); i++) {
			System.out.println((i+1) + ". jedinka = " + populacija.dohvatiPopulaciju().get(i).dohvatiVjerojatnostPrezivljavanja());
		}
		System.out.println("Prosjecna dobrota = " + populacija.dohvatiProsjecnuDobrotu());
	}

}
