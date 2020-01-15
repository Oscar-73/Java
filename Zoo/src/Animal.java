import java.util.Random;

public abstract class Animal implements Esser {

	static Random rnd = new Random();
	
	public abstract String mou (Zoo zoo); // Con eso pasas un objeto de la clase "Zoo"
	public abstract String alimenta (Zoo zoo);
	public abstract String expressa (Zoo zoo);
	
	
	public String accio (Zoo zoo) {
	
		int accio;
		
		accio = rnd.nextInt(3); // Número aleatorio entre 0, 1 y 2
		
		switch(accio) {
			case 0: return mou(zoo);
					
					
			case 1: return alimenta(zoo);
					
			
			case 2: return expressa(zoo);
					
		}
		
		return null;
	
	}
	
}
