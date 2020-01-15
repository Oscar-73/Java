import java.util.List;
import java.util.Scanner;

public class Menu {

	static Scanner sc = new Scanner(System.in);
	static Agenda agn = new Agenda();
	
	public static void main(String[] args) {

		System.out.println("Agenda");
		
		int opcio;
		
		do {
			System.out.println("\n1. Afegir contacte.");
			System.out.println("2. Esborrar contacte pel seu nom.");
			System.out.println("3. Modificar contacte.");
			System.out.println("4. Cercar contacte.");
			System.out.println("5. Veure tots els contactes.");
			System.out.println("6. Ordenar els contactes.");
			System.out.println("0. Sortir.");
			
			System.out.println("\nIntrodueix l'opció: ");
			opcio = sc.nextInt();
			
			
			switch(opcio) {
			
			case 1: afegirContacte();
					System.out.println("\nContacte afegit!");
					break;
				
			case 2: esborrarContacte();
					break;
				
			case 3: modificarContacte();
					System.out.println("Contacte modificat!");
					break;
				
			case 4: cercarContacte();
					break;
				
			case 5: veureContactes();
					break;
					
			case 6: ordenarContactes();
					System.out.println("\nContactes ordenats!");
					break;
				
			case 0: default:
					System.out.println("\nHave a nice day.");
			
			}
			
		} while (opcio != 0);
				
	}
	
	// 1. AFEGIR CONTACTES
	
	public static void afegirContacte() {
		
		String nom, cognom, adresa, telf;
		
		Scanner sc2 = new Scanner(System.in);
			
		System.out.println("\nIntrodueix el nom: ");
		nom = sc2.nextLine();
		
		System.out.println("\nIntrodueix el cognom: ");
		cognom = sc2.nextLine();
		
		System.out.println("\nIntrodueix l'adreça: ");
		adresa = sc2.nextLine();
		
		System.out.println("\nIntrodueix el telèfon: ");
		telf = sc2.nextLine();
			
		Contacte cnt = new Contacte(nom, cognom, adresa, telf); // Con esto, creamos un objeto de la clase Contacte para encapsular todo lo introducido y pasárselo a Agenda (para que lo meta en el ArrayList)
		
		agn.afegirContacte(cnt); // Enviamos todos los datos al método afegirContacte de Agenda con cnt
	
	}
	
	// 2. ESBORRAR CONTACTE
	
	public static void esborrarContacte() {
		
		String nom, cognom;
		
		Scanner sc2 = new Scanner(System.in);
		
		System.out.println("Introdueix el nom del contacte a esborrar: ");
		nom = sc2.nextLine();
		
		System.out.println("\nIntrodueix el(s) cognom(s) del contacte a esborrar: ");
		cognom = sc2.nextLine();
		
		if(agn.eliminar(nom, cognom) == true) { // Llama a la función boolean "eliminar" de Agenda y si esta le devuelve "true", significa que borró el contacto
			System.out.println("\nContacte esborrat!");
		}
		
		else
			System.out.println("No s'ha pogut esborrar el contacte (posiblement no existeix)");
	}
	
	// 3. MODIFICAR CONTACTE
	
	public static void modificarContacte() {
		
		String nom, cognom;
		String n_nom = null, n_cognom = null, n_adresa = null, n_telf = null;
		Contacte old_cnt; // Creamos un objeto de la clase Contacte para agrupar en él los viejos valores
		int opcio;
		
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		System.out.println("\nIntrodueix el nom del contacte a modificar: ");
		nom = sc.nextLine();
		
		System.out.println("\nIntrodueix els cognoms del contacte a modificar: ");
		cognom = sc.nextLine();
		
		old_cnt = agn.cercar(nom, cognom); // Llamamos al método "cercar" de la clase Agenda para ver si los datos introducidos corresponden a algún usuario 
		
		if(old_cnt != null) { // Si ha encontrado algo...
			
			System.out.println("\nContacte trobat.");
			System.out.println("\nQuin camp vols modificar?");
			System.out.println("1 -> Nom, 2 -> Cognom, 3 -> Adresa, 4 -> Telf");
			opcio = sc2.nextInt();
						
			if (opcio != 1 && opcio != 2 && opcio != 3 && opcio != 4) {
				while(opcio != 1 && opcio != 2 && opcio != 3 && opcio != 4) {
					System.out.println("\nOpció no reconeguda.");
					System.out.println("1 -> Nom, 2 -> Cognom, 3 -> Adresa, 4 -> Telf");
					opcio = sc2.nextInt();
				}
			}
			
			if(opcio == 1) {
				System.out.println("\nIntrodueix el nou nom: ");
				n_nom = sc.nextLine();
				
				n_cognom = old_cnt.getCognom();
				n_adresa = old_cnt.getAdresa();
				n_telf = old_cnt.getTelf();
			}
			
			else if (opcio == 2) {
				System.out.println("\nIntrodueix el nou cognom: ");
				n_cognom = sc.nextLine();
				
				n_nom = old_cnt.getNom();
				n_adresa = old_cnt.getAdresa();
				n_telf = old_cnt.getTelf();
				
			}
			
			else if (opcio == 3) {
				System.out.println("\nIntrodueix la nova adresa: ");
				n_adresa = sc.nextLine();
				
				n_nom = old_cnt.getNom();
				n_cognom = old_cnt.getCognom();
				n_telf = old_cnt.getTelf();
			}
			
			else if (opcio == 4) {
				System.out.println("\nIntrodueix el nou telefon: ");
				n_telf = sc.nextLine();
				
				n_nom = old_cnt.getNom();
				n_cognom = old_cnt.getCognom();
				n_adresa = old_cnt.getAdresa();
			}
			
			Contacte new_cnt = new Contacte(n_nom, n_cognom, n_adresa, n_telf); //Con esto, creamos un objeto de la clase Contacte para encapsular todo lo introducido y pasárselo a Agenda (para que lo meta en el ArrayList)
			
			agn.modificar(nom, cognom, new_cnt);  // Enviamos todos los datos al método "modificar" de Agenda
		}
		
		else
			System.out.println("Contacte no trobat.");
		
	}
	
	// 4. CERCAR CONTACTE
	
	public static void cercarContacte() {
		
		String nom = null, cognom = null, adresa = null, telf = null;
				
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nIntrodueix el nom del contacte (en blanc per no cercar per nom): ");
		nom = sc.nextLine();
		System.out.println("\nIntrodueix el(s) cognom(s) del contacte (en blanc per no cercar per cognom): ");
		cognom = sc.nextLine();
		System.out.println("\nIntrodueix el telèfon del contacte (en blanc per no cercar per telèfon): ");
		telf = sc.nextLine();
		System.out.println("\nIntrodueix l'adreça del contacte (en blanc per no cercar per adreça): ");
		adresa = sc.nextLine();
		
		Contacte atribut = new Contacte(nom, cognom, adresa, telf);
		
		List<Contacte> resultat = agn.cerca(atribut);
		if (resultat.size() > 0) {
			
			System.out.println("Els seguents contactes concideixen:");
			
			for (Contacte c : resultat) {
				System.out.println("\nNom: "+c.getNom()+"  Cognoms: "+c.getCognom());
				System.out.println("Adreça: "+c.getAdresa());
				System.out.println("Telèfon: "+c.getTelf());
				System.out.println();
			}
			
		} else {
			System.out.println("No hi ha cap contacte que compleixi aquests criteris.");
		}
		
	}
	
	
	// 5. VEURE CONTACTES
	
	public static void veureContactes() {
		System.out.println(agn.toString()); // Llamamos al método toString de Agenda
	}
	
	// 6. ORDENAR CONTACTES
	
	public static void ordenarContactes() {
		agn.ordenar();
	}

}
