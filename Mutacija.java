package uui.ga.lab04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Mutacija {
	
	private double vjerojatnost;
	
	public Mutacija() {
		try {
			Scanner in = new Scanner(new FileReader("konfiguracija.txt"));
			while(!in.next().equals("Mutacija"));
			this.vjerojatnost = in.nextDouble();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
