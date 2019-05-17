package uui.ga.lab04;

import java.io.PrintWriter;
import java.util.ArrayList;

public class Jedinka {
	
	private ArrayList<Gen> nizGena = new ArrayList<>();
	private double dobrota;
	private FunkcijaDobrote funkcijaDobrote = new FunkcijaDobrote();
	private boolean krizan = false;
	private double vjerojatnostPrezivljavanja;

	public ArrayList<Gen> dohvatiGene() {
		return nizGena;
	}

	public void postaviGene(ArrayList<Gen> nizGena) {
		this.nizGena = nizGena;
	}
	
	public void generirajGene() {
		int broj = (int)(Math.random() * 1023);
		dobrota = funkcijaDobrote.dobrota(broj);
		while(broj != 0) {
			int bit = broj % 2;
			Gen gen = new Gen(bit);
			nizGena.add(0, gen);
			broj /= 2;
		}
		while(nizGena.size() < 10) {
			nizGena.add(0, new Gen(0));
		}
	}
	
	public void izracunajDobrotu() {
		int broj = 0;
		for(int i = 0; i < nizGena.size(); i++) {
			broj += nizGena.get(i).dohvatiVrijednost()*Math.pow(2, 9-i);
		}
		dobrota = funkcijaDobrote.dobrota(broj);
	}

	public boolean jeKrizan() {
		return krizan;
	}

	public void postaviKrizan(boolean krizan) {
		this.krizan = krizan;
	}

	public double dohvatiDobrotu() {
		return dobrota;
	}

	public double dohvatiVjerojatnostPrezivljavanja() {
		return vjerojatnostPrezivljavanja;
	}

	public void postaviVjerojatnostPrezivljavanja(double vjerojatnostPrezivljavanja) {
		this.vjerojatnostPrezivljavanja = vjerojatnostPrezivljavanja;
	}
	
	public void ispisiGene(PrintWriter out) {
//		System.out.print("Binarno = ");
//		nizGena.forEach(g -> System.out.print(g.dohvatiVrijednost()));
//		System.out.print("; Dekadski = ");
		out.print("Binarno = ");
		nizGena.forEach(g -> out.print(g.dohvatiVrijednost()));
		out.print("; Dekadski = ");
		int broj = 0;
		for(int i = 0; i < nizGena.size(); i++) {
			broj += nizGena.get(i).dohvatiVrijednost()*Math.pow(2, 9-i);
		}
//		System.out.print(broj);
//		System.out.print("; Dobrota = " + dobrota);
		out.print(broj);
		out.print("; Dobrota = " + dobrota);
	}

}
