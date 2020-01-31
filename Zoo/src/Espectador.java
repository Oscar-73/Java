
public class Espectador implements Ser {

	public String accion(Zoo zoo) {
		Animal a = zoo.mostrarAnimal(); // Creamos un objeto de la clase "Animal" para poder guardarlo tras llamar a ese método
		String mensaje;
		
		if(a instanceof Vaca) {
			mensaje = "\nUn espectador mira a una vaca.";
		}
		
		else if (a instanceof Cocodrilo) {
			mensaje = "\nUn espectador mira a un peligroso cocodrilo.";
		}
		
		else {
			mensaje = "\nUn espectador no sabe adónde mirar porque no hay animales.";
		}
		
		return mensaje;
	}
}
