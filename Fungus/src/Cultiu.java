import java.util.Random;

public class Cultiu {

	Fungus[][] terreny; // Matriz de objetos de la clase Fungus
	private int files;
	private int columnes;
	
	public int getFiles() {
		return files;
	}

	public int getColumnes() {
		return columnes;
	}
	
	public Cultiu(int i, int j) {
		terreny = new Fungus[i][j];
		files=i;
		columnes=j;
	}
	
	public void setFungus(Fungus fong, int fila, int columna) {
		
		if(fong.posa(this, fila, columna) == true) {
			
			if(NoOcupat(fila, columna) == true) {
				
				fong.colonia.augmentaPoblacio();	
			}
	
			else {
				
				terreny[fila][columna].colonia.disminueixPoblacio();
				fong.colonia.augmentaPoblacio();
			}
			
			terreny[fila][columna] = fong;
			fong.setCol(columna);
			fong.setFila(fila);
		}
			
	}
	
	public boolean esDins(int fila, int columna) {
		if(fila > -1 && fila < files && columna > -1 && columna < columnes) {
			return true;
		}
		
		else
			return false;
	}
	
	public boolean NoOcupat (int fila, int columna) {
		if( terreny[fila][columna] instanceof Compactus || terreny[fila][columna] instanceof Agresibus || terreny[fila][columna] instanceof Dispersus) {
			
			return false;
		}
		
		else
			return true;
	}
    
	public boolean esArrencable(int fila, int columna) {
		
		if(terreny[fila][columna] instanceof Arrencable) {
			return true;
		}
		
		else
			return false;
	}
	
	public void temps() {
		
		Random rnd = new Random();
		
		int fila = rnd.nextInt(files);
		int columna = rnd.nextInt(columnes);
		
		if(NoOcupat(fila, columna) == false) {
			terreny[fila][columna].creix(this);
		}
	}
	
	public void dibuixa() {
	
		for(int i = 0; i < files; i++) {
			
			for(int j = 0; j < columnes; j++) {
				
				try {	
					System.out.print(terreny[i][j].getChar());
				}
				
				catch(Exception NoFungus) {
					System.out.print(".");
				}
			}
			
			System.out.println();
		}

	}
}
