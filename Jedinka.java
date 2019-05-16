package uui.ga.lab04;

import java.util.ArrayList;

public class Jedinka {
	
	private ArrayList<Gen> nizGena = new ArrayList<>();

	public ArrayList<Gen> dohvatiGene() {
		return nizGena;
	}

	public void postaviGene(ArrayList<Gen> nizGena) {
		this.nizGena = nizGena;
	}
	
	public void generirajGene() {
		int broj = (int)(Math.random() * 1024);
		while(broj != 0) {
			int bit = broj % 2;
			Gen gen = new Gen(bit);
			nizGena.add(0, gen);
			broj /= 2;
		}
	}

}
