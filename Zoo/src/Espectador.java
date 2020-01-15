
public class Espectador implements Esser {

	public String accio(Zoo zoo) {
		
		Animal a = zoo.mostraAnimal(); // Creas un objeto de la clase animal para poder guardarlo en el m�todo al que llamas
		
		String missatge;
		
		if(a instanceof Vaca) {
			missatge = "\nUn espectador mira una vaca.";
		}
		
		else if (a instanceof Cocodril) {
			missatge = "\nUn espectador mira a un perill�s cocodril.";
		}
		
		else {
			missatge = "\nUn espectador no sap a on mirar perqu� no troba animals";
		}
		
		return missatge;
			
	}
	
}
