package uui.ga.lab04;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Glavni {
	private static PrintWriter out;

	public static void main(String args[]) {
		try {
			out = new PrintWriter(new FileWriter("./rezultat/rezultat.txt", true));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Evolucija evolucija = new Evolucija(out);
		evolucija.evoluiraj();
		Jedinka najbolja = evolucija.dohvatiNajboljuJedinku();
//		System.out.println("Kraj\nNajbolja jedinka:");
		out.println("Kraj\nNajbolja jedinka:");
		najbolja.ispisiGene(out);
		out.close();
	}
	
}
