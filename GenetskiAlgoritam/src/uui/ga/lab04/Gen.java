package uui.ga.lab04;

public class Gen {
	
	private int vrijednost;
	
	public Gen(int vrijednost){
		this.vrijednost = vrijednost;
	}

	public int dohvatiVrijednost() {
		return vrijednost;
	}

	public void postaviVrijednost(int vrijednost){
		this.vrijednost = vrijednost;
	}

}
