
public class Cocodrilo extends Animal {

	@Override
	public String moverse(Zoo zoo) {
		return "\nUn cocodrilo nada de arriba a abajo.";
	}

	@Override
	public String alimentarse(Zoo zoo) {
		Animal animal = zoo.mostrarAnimal();
		String missatge;
		
		if(animal instanceof Vaca) {
			missatge = "\n¡Un cocodrilo se come a una vaca!";
			zoo.eliminarAnimal(animal);
		}
		
		else if(animal instanceof Cocodrilo && animal != this) { // Con "&& animal != this" evitamos que el cocodrilo se coma así mismo en el caso que sea el único animal del Zoo
			missatge = "\n¡Un cocodrilo se come a otro cocodrilo!";
			zoo.eliminarAnimal(animal);
		}
		
		else
			missatge = "\nUn cocodrilo busca a quién comerse.";
	
			return missatge;
	}

	@Override
	public String expresarse(Zoo zoo) {
		return "\nUn cocodrilo muestra su afilada dentadura.";
	}

}
