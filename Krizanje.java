package uui.ga.lab04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Krizanje {
	
	private double vjerojatnost;
	
	public Krizanje() {
		try {
			Scanner in = new Scanner(new FileReader("konfiguracija.txt"));
			while(!in.next().equals("Krizanje"));
			this.vjerojatnost = in.nextDouble();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
