package uui.ga.lab04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Populacija {
	
	private ArrayList<Jedinka> nizJedinki = new ArrayList<>();
	private int velicina;
	
	public Populacija() {
		try {
			Scanner in = new Scanner(new FileReader("konfiguracija.txt"));
			while(!in.next().equals("Populacija"));
			this.velicina = in.nextInt();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Jedinka> postaviPopulaciju() {
		return nizJedinki;
	}
	public void dohvatiPopulaciju(ArrayList<Jedinka> nizJedinki) {
		this.nizJedinki = nizJedinki;
	}
	
	public void generirajPopulaciju() {
		for(int i = 0; i < velicina; i++) {
			Jedinka jedinka = new Jedinka();
			jedinka.generirajGene();
			nizJedinki.add(jedinka);
		}
	}

}
