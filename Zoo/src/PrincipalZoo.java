import java.util.InputMismatchException;
import java.util.Scanner;

public class PrincipalZoo {
	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		String animal;
		Vaca vaca = new Vaca();
		Cocodrilo cocodrilo = new Cocodrilo();
		int opcion = 999;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nEl zoo abre sus puertas.");
		
		do{
			System.out.println("\n¿Qué quieres hacer?");
			System.out.println("\n 1 - Añadir vaca/cocodrilo");
			System.out.println(" 2 - Eliminar vaca/cocodrilo");
			System.out.println(" 3 - Eliminar todas las vacas/cocodrilos");
			System.out.println(" 4 - Mirar a los animales");
			System.out.println(" 0 - Salir");
	
			try {
				System.out.println("\nElección: ");
				opcion = sc.nextInt();
				sc.nextLine();
			} catch(InputMismatchException e) {
				System.out.println("\n¡La elección ha de ser un número!\nCerrando programa...");
				break;
			}
			
			switch(opcion) {
				case 1: System.out.println("\n¿Qué quieres añadir? ¿Una vaca o un cocodrilo?: ");
						animal = sc.nextLine(); 
					
						if(animal.toLowerCase().equals("vaca")) {
							zoo.añadirAnimal(vaca);
							System.out.println("\nHa llegado al zoo una enorme vaca.");
							break;
						}
						
						else if(animal.toLowerCase().equals("cocodrilo")) {
							zoo.añadirAnimal(cocodrilo);
							System.out.println("\nHa llegado al zoo un peligroso cocodrilo.");
							break;
						}
						
						else {
							System.out.println("\nAnimal no reconocido.\n");
							break;
						}
				
				case 2: System.out.println("\n¿Qué quieres eliminar? ¿Una vaca o un cocodrilo?: ");
						animal = sc.next();
				
						if(animal.toLowerCase().equals("vaca")) {
							if(zoo.listaAnimales.contains(zoo.vaca)) {
								zoo.eliminarAnimal(vaca);
								System.out.println("\nSe ha trasladado una vaca a otro zoo.");
								break;
							}
							else {
								System.out.println("\nNo hay vacas en el zoo.");
								break;
							}
						}
						
						else if(animal.toLowerCase().equals("cocodrilo")) {
							if(zoo.listaAnimales.contains(zoo.coco)) {
								zoo.eliminarAnimal(cocodrilo);
								System.out.println("\nSe ha trasladado un cocodrilo a otro zoo.");
								break;
							}
							else {
								System.out.println("\nNo hay cocodrilos en el zoo.");
								break;
							}
						}
						
						else {
							System.out.println("\nAnimal no reconocido.");							
							break;
						}
						
				case 3: System.out.println("\n¿Qué quieres eliminar? ¿Todas las vacas o todos los cocodrilos?: ");
						animal = sc.next();
				
						if(animal.toLowerCase().equals("vaca") || animal.toLowerCase().equals("vacas")) {
							if(zoo.listaAnimales.contains(zoo.vaca)) {
								zoo.eliminarTodos(vaca);
								System.out.println("\nEl zoo deja de tener vacas.");
								break;
							}
							else {
								System.out.println("\nNo hay vacas en el zoo.");
								break;
							}
						}
						
						else if(animal.toLowerCase().equals("cocodrilo") || animal.toLowerCase().equals("cocodrilos")) {
							if(zoo.listaAnimales.contains(zoo.coco)) {
								zoo.eliminarTodos(cocodrilo);
								System.out.println("\nEl zoo deja de tener cocodrilos.");
								break;
							}
							else {
								System.out.println("\nNo hay cocodrilos en el zoo.");
								break;
							}
						}
						
						else {
							System.out.println("\nAnimal no reconocido.");
							System.out.println("");
							break;
						}
				
				case 4: if(zoo.listaAnimales.isEmpty()) {
							System.out.println("\n¡Qué zoo más aburrido! No tiene ningún animal.");
							break;
						}
						else {
							zoo.mirar();
							break;
						}						

				case 0: System.out.println("\n¡Esperamos que hayas disfrutado tu estancia en nuestro peculiar zoo!");
						break;
				
				default: System.out.println("\nOpción no reconocida.");
						 break;
			}
		}while(opcion != 0);
	}
}
