
public abstract class Fungus {
	
	Colonia colonia;
	private int fila, col;
	
	public int getFila() {
		return fila;
	}

	public int getCol() {
		return col;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public Fungus(Colonia colonia) { // Pasamos solo la colonia porque el ejercicio no nos pide más variables de esta clase 
		this.colonia = colonia;
	}
	
	public char getChar() {
		
		if(colonia.getNom().toLowerCase().equals("compactus")) {
			return 'O';
		}
		
		else if(colonia.getNom().toLowerCase().equals("dispersus")) {
			return '+';
		}
		
		else if(colonia.getNom().toLowerCase().equals("agresibus")) {
			return 'x';
		}
		
		return '.';
	}
	
	abstract void creix(Cultiu cult); // Lo hacemos abstract porque la clase Fungus en sí, no va a utilizar el método
						   // lo van a usar sus subclases
	
	public boolean posa(Cultiu c, int fila, int colum) {
		
		boolean posat = false;
		
		if(c.esDins(fila, colum) == true ) {
			
			if(this instanceof Arrencador) {
				if(c.esArrencable(fila, colum) == true) {
					posat = true;
				}
			
				else if(c.NoOcupat(fila, colum) == true) {
					posat = true;
				}
			}
			
			else if(c.NoOcupat(fila, colum) == true) {
				posat = true;
			}
		}	
		
		return posat;
	}
}
	


