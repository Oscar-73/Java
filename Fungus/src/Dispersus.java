import java.util.Random;

public class Dispersus extends Fungus implements Arrencador, Arrencable  {

	public Dispersus(Colonia colonia) {
		super(colonia);
		// TODO Auto-generated constructor stub
	}

	@Override
	void creix(Cultiu cult) {
		
		Random rand = new Random();
		
		Dispersus disp1 = new Dispersus(colonia);
		Dispersus disp2 = new Dispersus(colonia);
		Dispersus disp3 = new Dispersus(colonia);
		Dispersus disp4 = new Dispersus(colonia);
		
		cult.setFungus(disp1, rand.nextInt(cult.getFiles()), rand.nextInt(cult.getColumnes()));
		cult.setFungus(disp2, rand.nextInt(cult.getFiles()), rand.nextInt(cult.getColumnes()));
		cult.setFungus(disp3, rand.nextInt(cult.getFiles()), rand.nextInt(cult.getColumnes()));
		cult.setFungus(disp4, rand.nextInt(cult.getFiles()), rand.nextInt(cult.getColumnes()));
	}

	
}
