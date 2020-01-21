import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {

	static Scanner sc = new Scanner(System.in);
	static Agenda agn = new Agenda();
	
	public static void main(String[] args) {
		int opcion;
		
		try {
			do {
				System.out.println("Agenda de contactos");
				System.out.println("=====================");
				System.out.println("  1) Añadir contacto");
				System.out.println("  2) Eliminar contacto por nombre y apellido(s)");
				System.out.println("  3) Modificar contacto");
				System.out.println("  4) Buscar contacto");
				System.out.println("  5) Ver todos los contactos");
				System.out.println("  6) Ordenar contactos");
				System.out.println("  0) Salir del programa");
			
				System.out.print("\nIntroduce una opción: ");
				opcion = sc.nextInt();
			
				switch(opcion) {			
					case 1: añadirContacto();							
							break;				
					
					case 2: eliminarContacto();
							break;				
					
					case 3: modificarContacto();						
							break;
					
					case 4: buscarContacto();
							break;
					
					case 5: verContactos();
							break;
						
					case 6: ordenarContactos();							
							break;
						
					default: System.out.println("\nOpción no reconocida.\n");
							 break;
					
					case 0: System.out.println("\n¡Que tengas un buen día!");
							break;
				}
			} while (opcion != 0);			
		} catch(InputMismatchException e) {
			System.out.println("\n¡La opción ha de ser un número!\nFinalizando programa...");
		}
	}
	
	public static void añadirContacto() {		
		String nombre, apellido, direccion, telf;
		sc.nextLine();
			
		System.out.println("\nIntroduce un nombre: ");
		nombre = sc.nextLine();
				
		while(nombre.isEmpty()) {
			System.out.println("\nDebes introducir un nombre: ");
			nombre = sc.nextLine();
		}
		
		System.out.println("\nIntroduce un apellido: ");
		apellido = sc.nextLine();
		
		while(apellido.isEmpty()) {
			System.out.println("\nDebes introducir un(os) apellido(s): ");
			apellido = sc.nextLine();
		}

		System.out.println("\nIntroduce una dirección: ");
		direccion = sc.nextLine();
		
		while(direccion.isEmpty()) {
			System.out.println("\nDebes introducir una dirección: ");
			direccion = sc.nextLine();			
		}

		System.out.println("\nIntroduce un teléfono: ");
		telf = sc.nextLine();
		
		while(telf.isEmpty()) {
			System.out.println("\nDebes introducir un teléfono: ");
			telf = sc.nextLine();
		}			
		
		Pattern p = Pattern.compile("^[0-9]{9}$"); // Con Pattern y Matcher comprobamos que el número de teléfono introducido no contenga letras y sea de la longitud adecuada
	    Matcher m = p.matcher(telf);

	    while(!m.find()) {
	    	System.out.println("\nNúmero de teléfono de formato incorrecto (han de ser nueve números).");
	    	System.out.println("\nIntroduce un teléfono: ");
	    	telf = sc.nextLine();
	    	m = p.matcher(telf);
	    }
	    
		Contacto cnt = new Contacto(nombre, apellido, direccion, telf); // Con esto, creamos un objeto de la clase Contacto para encapsular todo lo introducido y pasárselo a Agenda (para que lo meta en el ArrayList)
		
		agn.añadir(cnt); // Enviamos todos los datos al método "añadir" de Agenda con el objeto "cnt"	
	}

	public static void eliminarContacto() {
		if(agn.agenda.size()>0) {
			sc.nextLine();
			
			String nombre, apellido;
			
			System.out.println("\nIntroduce el nombre del contacto que quieras eliminar: ");
			nombre = sc.nextLine();
			
			while(nombre.isEmpty()) {
				System.out.println("\nDebes introducir un nombre: ");
				nombre = sc.nextLine();
			}
			
			System.out.println("\nIntroduce el(los) apellido(s) del contacto que quieras eliminar: ");
			apellido = sc.nextLine();
			
			while(apellido.isEmpty()) {
				System.out.println("\nDebes introducir un(os) apellido(s): ");
				apellido = sc.nextLine();
			}
			
			if(agn.eliminar(nombre, apellido) == true) // Llama a la función boolean "eliminar" de Agenda y si esta devuelve "true", significa que ha eliminado correctamente el contacto
				System.out.println("\n¡Contacto eliminado!\n");		
			else
				System.out.println("\nNo se ha podido eliminar el contacto (posiblemente no exista).\n");
		}
		else
			System.out.println("\nLa agenda está vacía. Añade algún contacto con la primera opción.\n");
	}
	
	public static void modificarContacto() {
		if(agn.agenda.size()>0) {
			sc.nextLine();
			
			String nombre, apellido;
			String n_nombre = null, n_apellido = null, n_direccion = null, n_telf = null;
			Contacto old_cnt; // Creamos un objeto de la clase Contacto para agrupar en él los viejos valores
			int opcion;						
			
			System.out.println("\nIntroduce el nombre del contacto que quieras modificar: ");
			nombre = sc.nextLine();
			
			System.out.println("\nIntroduce el(los) apellido(s) del contacto que quieras modificar: ");
			apellido = sc.nextLine();
			
			old_cnt = agn.buscar(nombre, apellido); // Llamamos al método "buscar" de la clase Agenda para ver si los datos introducidos corresponden con los de algún usuario 
			
			if(old_cnt != null) { // Si ha encontrado algo...			
				System.out.println("\nContacto encontrado.");				
				System.out.println("   1) Nombre\n   2) Apellido\n   3) Dirección\n   4) Teléfono");
				System.out.print("\n¿Qué campo quieres modificar? (Introduce el número de la opción): ");
				opcion = sc.nextInt();
							
				if (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4) {
					while(opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4) {
						System.out.println("\nOpción no reconocida. Introduce una de las siguientes, por favor.");
						System.out.println("   1) Nombre\n   2) Apellido\n   3) Dirección\n   4) Teléfono");
						opcion = sc.nextInt();
					}
				}
				
				if(opcion == 1) {
					System.out.println("\nIntroduce el nuevo nombre: ");
					sc.nextLine();
					
					n_nombre = sc.nextLine();
					
					while(n_nombre.isEmpty()) {
						System.out.println("\nHas de introducir un nuevo nombre: ");
						n_nombre = sc.nextLine();
					}
					
					n_apellido = old_cnt.getApellido();
					n_direccion = old_cnt.getDireccion();
					n_telf = old_cnt.getTelf();
				}
				
				else if (opcion == 2) {
					System.out.println("\nIntroduce el(los) nuevo(s) apellido(s): ");
					n_apellido = sc.nextLine();
					
					n_nombre = old_cnt.getNombre();
					n_direccion = old_cnt.getDireccion();
					n_telf = old_cnt.getTelf();
					
				}
				
				else if (opcion == 3) {
					System.out.println("\nIntroduce la nueva dirección: ");
					n_direccion = sc.nextLine();
					
					n_nombre = old_cnt.getNombre();
					n_apellido = old_cnt.getApellido();
					n_telf = old_cnt.getTelf();
				}
				
				else if (opcion == 4) {
					System.out.println("\nIntroduce el nuevo teléfono: ");
					n_telf = sc.nextLine();
					
					n_nombre = old_cnt.getNombre();
					n_apellido = old_cnt.getApellido();
					n_direccion = old_cnt.getDireccion();
				}			
	
				Contacto new_cnt = new Contacto(n_nombre, n_apellido, n_direccion, n_telf); // Creamos un objeto de la clase Contacto que encapsula todo lo introducido y se lo pasamos a Agenda (para que lo meta en el ArrayList)
				
				agn.modificar(nombre, apellido, new_cnt);  // Enviamos todos los datos al método "modificar" de Agenda
				
				System.out.println("¡Contacto modificado!\n");
			}		
			else
				System.out.println("\nContacto no encontrado.\n");
		} else			
			System.out.println("\nLa agenda está vacía. Añade algún contacto con la primera opción.\n");
	}
	
	public static void buscarContacto() {
		if(agn.agenda.size()>0) {
			String nombre = null, apellido = null, direccion = null, telf = null;
			sc.nextLine();
			
			System.out.println("\nIntroduce el nombre del contacto (dejar en blanco si no se quiere buscar por este campo): ");
			nombre = sc.nextLine();
			
			System.out.println("\nIntroduce el(los) apellido(s) del contacto (dejar en blanco si no se quiere buscar por este campo): ");
			apellido = sc.nextLine();
			
			System.out.println("\nIntroduce la dirección del contacto (dejar en blanco si no se quiere buscar por este campo): ");
			direccion = sc.nextLine();			
			
			System.out.println("\nIntroduce el teléfono del contacto (dejar en blanco si no se quiere buscar por este campo): ");
			telf = sc.nextLine();			
			
			Contacto atributo = new Contacto(nombre, apellido, direccion, telf);
			
			List<Contacto> resultado = agn.buscar(atributo);
			if (resultado.size() > 0) {				
				System.out.println("\nLos siguientes contactos coinciden con lo introducido:");
				
				for (Contacto c : resultado) {
					System.out.println("\nNombre: "+c.getNombre()+"\nApellido(s): "+c.getApellido()+"\nDirección: "+c.getDireccion()+"\nTeléfono: "+c.getTelf()+"\n");			
				}				
			} else {
				System.out.println("\nNo existe ningún contacto con esos datos.\n");
			}
		} else
			System.out.println("\nLa agenda está vacía. Añade algún contacto con la primera opción.\n");
	}

	public static void verContactos() {
		if(agn.agenda.size()>0)
			System.out.println(agn.toString());
		else
			System.out.println("\nLa agenda está vacía. Añade algún contacto con la primera opción.\n");
	}

	public static void ordenarContactos() {
		if(agn.agenda.size()>1)
			agn.ordenar();
		else if(agn.agenda.size()==1)
			System.out.println("\nLa agenda solo cuenta con un contacto. Añade otro con la primera opción.\n");
		else
			System.out.println("\nLa agenda está vacía. Añade algún contacto con la primera opción.\n");			
	}
}
