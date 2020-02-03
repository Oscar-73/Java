import java.util.ArrayList;
import java.util.Collections;

public class main {

	public static void main(String[] args) {
		Colonia colCompactus = new Colonia("compactus", 0);
		Colonia colDispersus = new Colonia("dispersus", 0);
		Colonia colAgresivus = new Colonia("agresivus", 0);
		
		Compactus fungComp = new Compactus(colCompactus);
		Dispersus fungDisp = new Dispersus(colDispersus);
		Agresivus fungAgre = new Agresivus(colAgresivus);
		
		
		Cultivo cult = new Cultivo(10, 10); // Creamos un Cultivo (matriz) de 10x10 en los que colocar los hongos
		
		// Posiciones iniciales de los hongos
		cult.setFungus(fungComp, 1, 4);
		cult.setFungus(fungDisp, 4, 4);
		cult.setFungus(fungAgre, 7, 4);
		
		System.out.println("Estado inicial.");
		cult.imprimirCultivo(); // Imprimimos el estado inicial del cultivo
		
		for(int i = 0; i < 100; i++) {
			cult.tiempo(); // Llamamos al método "tiempo()" cien veces
		}
		
		System.out.println("\nEstado final.");
		cult.imprimirCultivo(); // Imprimimos el estado final del cultivo

		ArrayList<Colonia> ordenColonia = new ArrayList<Colonia>(); // Creamos un ArrayList de Colonia para introducir las colonias tras su estado final 
		
		ordenColonia.add(colCompactus);
		ordenColonia.add(colDispersus);
		ordenColonia.add(colAgresivus);
		
		System.out.println("\n");
		
		ordenColonia.sort(Collections.reverseOrder()); // Ordenamos las colonias por su población
		
		for(Colonia c: ordenColonia) {
			System.out.println(c); // Llama automáticamente al método toString de la clase Colonia
		}
	}
}
