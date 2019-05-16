package uui.ga.lab04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Evolucija {
	
	private int brojIteracija;
	
	public Evolucija() {
		try {
			Scanner in = new Scanner(new FileReader("konfiguracija.txt"));
			while(!in.next().equals("Iteracije"));
			this.brojIteracija = in.nextInt();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
