import java.util.Random;

public abstract class Animal implements Ser {

	static Random rnd = new Random();
	
	public abstract String moverse (Zoo zoo); // M�todos que tendr�n que sobreescribir las clases que extiendan de esta.
	public abstract String alimentarse (Zoo zoo);
	public abstract String expresarse (Zoo zoo);
	
	public String accion (Zoo zoo) { // El m�todo "accion" devuelve uno de los siguientes m�todos de forma aleatoria
		int accion;
		accion = rnd.nextInt(3); // N�mero aleatorio entre 0, 1 y 2
		
		switch(accion) {
			case 0: return moverse(zoo);
			case 1: return alimentarse(zoo);
			case 2: return expresarse(zoo);
		}
		return null;
	}
}
