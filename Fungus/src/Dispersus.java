import java.util.Random;

public class Dispersus extends Fungus implements Ejecutor, Ejecutable  {

	public Dispersus(Colonia colonia) {
		super(colonia);
	}

	// Los hongos Dispersus crecen en cuatro posiciones aleatorias del cultivo, devorando a todo aquel que estuviera ya en esa posición.
	// Son representados como "+".
	@Override
	void crecer(Cultivo cult) {
		Random rand = new Random();
		
		Dispersus disp1 = new Dispersus(colonia);
		Dispersus disp2 = new Dispersus(colonia);
		Dispersus disp3 = new Dispersus(colonia);
		Dispersus disp4 = new Dispersus(colonia);
		
		cult.setFungus(disp1, rand.nextInt(cult.getFilas()), rand.nextInt(cult.getColumnas()));
		cult.setFungus(disp2, rand.nextInt(cult.getFilas()), rand.nextInt(cult.getColumnas()));
		cult.setFungus(disp3, rand.nextInt(cult.getFilas()), rand.nextInt(cult.getColumnas()));
		cult.setFungus(disp4, rand.nextInt(cult.getFilas()), rand.nextInt(cult.getColumnas()));
	}
}
