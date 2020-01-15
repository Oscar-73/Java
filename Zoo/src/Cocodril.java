
public class Cocodril extends Animal {

	@Override
	public String mou(Zoo zoo) {
		
		return "\nUn cocodril neda estany amunt estany avall.";
	}

	@Override
	public String alimenta(Zoo zoo) {
		
		Animal animal = zoo.mostraAnimal(); // Creas un objeto de la clase animal para poder guardarlo en el método al que llamas
		
		String missatge;
		
		if(animal instanceof Vaca) {
			missatge = "\nUn cocodril es menja una vaca!";
			zoo.suprimeixAnimal(animal);
		}
		
		else if(animal instanceof Cocodril && animal != this) { // Con "&& animal != this" evitamos que el cocodrilo se coma así mismo en el caso que sea el único animal del Zoo
			missatge = "\nUn cocodril es menja un altre cocodril!";
			zoo.suprimeixAnimal(animal);
		}
		
		else
			missatge = "\nUn cocodril busca a qui es pot menjar.";
	
			return missatge;
	}

	@Override
	public String expressa(Zoo zoo) {

		return "\nUn cocodril obre una boca plena de dents";
	}

}
