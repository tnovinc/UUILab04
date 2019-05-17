package uui.ga.lab04;

public class Glavni {
	private static Evolucija evolucija = new Evolucija();

	public static void main(String args[]) {
		evolucija.evoluiraj();
		Jedinka najbolja = evolucija.dohvatiNajboljuJedinku();
		System.out.println("Kraj\nNajbolja jedinka:");
		najbolja.ispisiGene();
		return;
	}
	
}
