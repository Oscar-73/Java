import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class Zoo extends Animal {
	List<Animal> listaAnimales = new ArrayList<Animal>();	 
	Espectador esp = new Espectador();
	Vaca vaca = new Vaca();
	Cocodrilo coco = new Cocodrilo();
	Random rnd = new Random();
	
	public Animal mostrarAnimal() {
		return listaAnimales.get(rnd.nextInt(listaAnimales.size())); // Devuelve un animal aleatorio (Número aleatorio entre el número de posiciones del ArrayList)
	}
	
	public void añadirAnimal(Animal animal) {
		if(animal instanceof Vaca){ 
			listaAnimales.add(vaca);
		}
		
		else if(animal instanceof Cocodrilo) {
			listaAnimales.add(coco);
		}
	}
	
	public void eliminarAnimal(Animal animal) {
		if(animal instanceof Vaca){
			listaAnimales.remove(vaca);
		}
		
		else if(animal instanceof Cocodrilo) {
			listaAnimales.remove(coco);
		}
	}
	
	public void eliminarTodos(Animal animal) {
		if(animal instanceof Vaca){
			while(listaAnimales.contains(vaca)){
				listaAnimales.remove(vaca);
			}
		}
		
		else if(animal instanceof Cocodrilo){
			while(listaAnimales.contains(coco)){
				listaAnimales.remove(coco);
			}
		}
	}
	
	public void mirar() {
		int num, num_animal;
		num = rnd.nextInt(2); // Devuelve un número aleatorio entre 0 y 1
		num_animal = rnd.nextInt(2);
		
		switch(num) {
			case 0: System.out.println(esp.accion(this)); // Acción del espectador
					break;
			
			case 1:	if(listaAnimales.contains(vaca) && listaAnimales.contains(coco)) {
						switch(num_animal) {
							case 0: System.out.println(vaca.accion(this));
							break;
					
							case 1: System.out.println(coco.accion(this));
							break;
						}
					}
				
					else if(listaAnimales.contains(vaca)){
						System.out.println(vaca.accion(this));
						break;
					}
					
					else if(listaAnimales.contains(coco)){
						System.out.println(coco.accion(this));
						break;
					}
		}
	}
	
	@Override
	public String moverse(Zoo zoo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String alimentarse(Zoo zoo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String expresarse(Zoo zoo) {
		// TODO Auto-generated method stub
		return null;
	}
}
