import java.util.Random;

public class Cultivo {

	Fungus[][] terreny; // Matriz de objetos de la clase Fungus
	private int filas;
	private int columnas;
	
	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}
	
	public Cultivo(int i, int j) {
		terreny = new Fungus[i][j];
		filas=i;
		columnas=j;
	}
	
	// M�todo con el cual asignamos un hongo en la posici�n enviada por par�metro siempre que esta est� dentro de los l�mites del cultivo
	public void setFungus(Fungus fong, int fila, int columna) {
		if(fong.ocupar(this, fila, columna) == true) {
			if(NoOcupado(fila, columna) == true) { // Si la posici�n no est� ocupada, asignamos al hongo y aumentamos la poblaci�n de la colonia
				fong.colonia.aumentarPoblacion();
			}
			else {
				terreny[fila][columna].colonia.disminuirPoblacion(); // Si la posici�n est� ocupada, asignamos el hongo sustituyendo al otro, reducimos la poblaci�n de la colonia del hongo sustituido y aumentamos la del hongo reci�n asignado
				fong.colonia.aumentarPoblacion();
			}
			
			terreny[fila][columna] = fong;
			fong.setCol(columna);
			fong.setFila(fila);
		}
	}
	
	// M�todo que comprueba que la posici�n enviada por par�metro est� dentro de los l�mites del cultivo
	public boolean estaDentro(int fila, int columna) {
		if(fila > -1 && fila < filas && columna > -1 && columna < columnas)
			return true;
		
		else
			return false;
	}
	
	// M�todo que comprueba si la posici�n enviada por par�metro est� ocupada o no por otro hongo 
	public boolean NoOcupado (int fila, int columna) {
		if(terreny[fila][columna] instanceof Compactus || terreny[fila][columna] instanceof Agresivus || terreny[fila][columna] instanceof Dispersus)
			return false;
		else
			return true;
	}
    
	// M�todo que comprueba si el hongo en la posici�n enviada por par�metro puede ser sustituido por otro
	public boolean esArrancable(int fila, int columna) {
		if(terreny[fila][columna] instanceof Ejecutable)
			return true;
		else
			return false;
	}
	
	// Con este m�todo, mediante dos Random obtenemos una posici�n aleatoria y si en esta hay un hongo (es decir, est� ocupada), lo hacemos crecer llamando al m�todo con el mismo nombre
	public void tiempo() {
		Random rnd = new Random();
		
		int fila = rnd.nextInt(filas);
		int columna = rnd.nextInt(columnas);
		
		if(NoOcupado(fila, columna) == false) {
			terreny[fila][columna].crecer(this);
			System.out.println("\n");
			imprimirCultivo();
		}
	}
	
	// M�todo que imprime el cultivo
	public void imprimirCultivo() {
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < columnas; j++) {
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
