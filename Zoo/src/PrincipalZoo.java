import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalZoo {

	public static void main(String[] args) {
				
		Zoo zoo = new Zoo();
		
		String animal;
		
		int opcio = 0;
		
		Scanner sc = new Scanner(System.in);
		
		do{System.out.println("\nEl zoo obre les seves portes.");
		
		System.out.println("\nQuè vols fer?");
		System.out.println("\n 1 - Afegir vaca / afegir cocodril");
		System.out.println("\n 2 - Eliminar vaca / eliminar cocodril");
		System.out.println("\n 3 - Eliminar totes les vaques / eliminar tots els cocodrils");
		System.out.println("\n 4 - Mirar als animals");
		System.out.println("\n 0 - Sortir");

		System.out.println("\nElecció: ");
		
		opcio = sc.nextInt();
		
		switch(opcio) {
			
			case 1: System.out.println("\nQuè vols afegir? Una vaca o un cocodril?: ");
					
					animal = sc.next(); // Ponemos "Next" a secas porque "NextLine" pilla el salto de línia y lo "anula" 
				
					if(animal.toLowerCase().equals("vaca")) {
						zoo.afegeixAnimal("vaca");
						System.out.println("\nHa arribat al zoo una enorme vaca.");
						break;
					}
					
					else if(animal.toLowerCase().equals("cocodril")) {
						zoo.afegeixAnimal("cocodril");
						System.out.println("\nHa arribat al zoo un perillós cocodril.");
						break;
					}
					
					else
						System.out.println("\nAnimal no reconegut.");
						System.out.println("");
						break;
			
			case 2: System.out.println("\nQuè vols eliminar? Una vaca o un cocodril?: ");
			
					animal = sc.next();
			
					if(animal.toLowerCase().equals("vaca")) {
						
						if(zoo.llistaAnimals.contains(zoo.vaca)) {
							zoo.suprimeixAnimal("vaca");
							System.out.println("\nS'ha traslladat a una vaca a un altre zoo.");
							break;
						}
						
						else
							System.out.println("\nNo hi han vaques al zoo.");
							break;
					}
					
					else if(animal.toLowerCase().equals("cocodril")) {
						
						if(zoo.llistaAnimals.contains(zoo.coco)) {
							zoo.suprimeixAnimal("cocodril");
							System.out.println("\nS'ha traslladat a una cocodril a un altre zoo.");
							break;
						}
						
						else
							System.out.println("\nNo hi han cocodrils al zoo.");
							break;
					}
					
					else
						System.out.println("\nAnimal no reconegut.");
						System.out.println("");
						break;
						
			case 3: System.out.println("\nQuè vols eliminar? Totes les vaques o els cocodrils?: ");
			
					animal = sc.next();
			
					if(animal.toLowerCase().equals("vaca")) {
						
						if(zoo.llistaAnimals.contains(zoo.vaca)) {
							zoo.suprimeixTots("vaca");
							System.out.println("\nEl zoo deixa de tenir vaques.");
							break;
						}
						
						else
							System.out.println("\nNo hi han vaques al zoo.");
							break;
					}
					
					else if(animal.toLowerCase().equals("cocodril")) {
					
						if(zoo.llistaAnimals.contains(zoo.coco)) {
							zoo.suprimeixTots("cocodril");
							System.out.println("\nEl zoo deixa de tenir cocodrils.");
							break;
						}
						
						else
							System.out.println("\nNo hi han cocodrils al zoo.");
							break;
					}
					
					else
						System.out.println("\nAnimal no reconegut.");
						System.out.println("");
						break;
			
			case 4: if(zoo.llistaAnimals.isEmpty()) {
						System.out.println("\nQuin zoo més avorrit! No té cap animal.");
					}
			
					else
						zoo.mira();
			
					break;
					
		}
		
	}while(opcio != 0);
		
		System.out.println("\nEsperem que hagis disfrutat l'estància al nostre peculiar zoo!");
	}
}
