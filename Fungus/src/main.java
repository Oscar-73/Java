import java.util.ArrayList;
import java.util.Collections;

public class main {

	public static void main(String[] args) {
		
		ArrayList<Colonia> ordrecolon = new ArrayList<Colonia>(); 
		
		Colonia compactus = new Colonia("compactus", 0);
		Colonia dispersus = new Colonia("dispersus", 0);
		Colonia agresibus = new Colonia("agresibus", 0);
		
		Cultiu cult1 = new Cultiu(10, 10); // Creamos un cultiu (matriz) de 10x10
		
		Compactus comp = new Compactus(compactus);
		Dispersus disp = new Dispersus(dispersus);
		Dispersus agre = new Dispersus(agresibus);
		
		cult1.setFungus(comp, 1, 4);
		cult1.setFungus(agre, 7, 4);
		cult1.setFungus(disp, 4, 4);
		
		System.out.println("Estat inicial.");
		
		cult1.dibuixa();
		
		
		for(int i = 0; i < 100; i++) {
			cult1.temps();
		}
		
		System.out.println("\nEstat final.");
		
		cult1.dibuixa();
		
		ordrecolon.add(compactus);
		ordrecolon.add(dispersus);
		ordrecolon.add(agresibus);
		
		System.out.println("\n");
		
		ordrecolon.sort(Collections.reverseOrder());
		
		for(Colonia c: ordrecolon) {
			System.out.println(c); // Llama automáticamente al método toString de la clase Colonia
		}
			

	}
}
