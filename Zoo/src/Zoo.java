import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Zoo extends Animal {

	List<Animal> llistaAnimals = new ArrayList<Animal>();	 
	
	Espectador esp = new Espectador();
	
	Random rnd = new Random();
	
	Vaca vaca = new Vaca();
	
	Cocodril coco = new Cocodril();
	
	
	public Animal mostraAnimal() {
		return llistaAnimals.get(rnd.nextInt(llistaAnimals.size())); // Devuelve un animal aleatorio (Número aleatorio entre el número de posiciones del ArrayList)
	}
	
	public void afegeixAnimal(String animal) {
		if(animal.toLowerCase().equals("vaca")){ // Así pasamos la cadena a minúscula para evitar errores 
			llistaAnimals.add(vaca);
		}
		
		else if(animal.toLowerCase().equals("cocodril")) {
			llistaAnimals.add(coco);
		};
	}
	
	public void suprimeixAnimal(String animal) {
		if(animal.toLowerCase().equals("vaca")){
			llistaAnimals.remove(vaca);
		}
		
		else if(animal.toLowerCase().equals("cocodril")) {
			llistaAnimals.remove(coco);
		};
	}
	
	public void suprimeixAnimal(Animal animal) { // Sobrecargamos el método para que reciba un objeto de tipo Animal y lo elimine de la lista
		if(animal instanceof Vaca){
			llistaAnimals.remove((Vaca)animal);
		}
		
		else if(animal instanceof Cocodril) {
			llistaAnimals.remove((Vaca)animal);
		};
	}
	
	public void suprimeixTots(String animal) {
	
		if(animal.toLowerCase().equals("vaca")){
				while(llistaAnimals.contains(vaca)){
					llistaAnimals.remove(vaca);
				}
			}
		
		if(animal.toLowerCase().equals("cocodril")){
			while(llistaAnimals.contains(coco)){
				llistaAnimals.remove(coco);
			}
		}
	}
	
	public void mira() {
	
		int num, num_animal;
		
		num = rnd.nextInt(2); // Devuelve un número aleatorio entre 0 y 1
		
		num_animal = rnd.nextInt(2);
		
		switch(num) {
		
			case 0: System.out.println(esp.accio(this)); // Con eso le pasaremos el objeto Zoo del main
					break;
			
			case 1:	if(llistaAnimals.contains(vaca) && llistaAnimals.contains(coco))
				switch(num_animal) {
				case 0: System.out.println(vaca.accio(this));
				break;
					
				case 1: System.out.println(coco.accio(this));
				break;
			}		
				
			else if(llistaAnimals.contains(vaca)){
						System.out.println(vaca.accio(this));
						break;
					}
					
			else if(llistaAnimals.contains(coco)){
						System.out.println(coco.accio(this));
						break;
					}
				
		}
	}
	
	@Override
	public String mou(Zoo zoo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String alimenta(Zoo zoo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String expressa(Zoo zoo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
