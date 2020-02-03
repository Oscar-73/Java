
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

	public Fungus(Colonia colonia) { 
		this.colonia = colonia;
	}
	
	// Método con el cual asignamos un símbolo a cada clase de hongo
	public char getChar() {
		if(colonia.getNombre().toLowerCase().equals("compactus")) {
			return 'O';
		}
		
		else if(colonia.getNombre().toLowerCase().equals("dispersus")) {
			return '+';
		}
		
		else if(colonia.getNombre().toLowerCase().equals("agresivus")) {
			return 'x';
		}
		
		return '.';
	}
	
	// Lo hacemos abstract porque la clase Fungus en sí, no va a utilizar el método, lo van a usar sus subclases
	abstract void crecer(Cultivo cult); 
	
	public boolean ocupar(Cultivo c, int fila, int colum) {
		boolean puesto = false;
		
		if(c.estaDentro(fila, colum) == true) {
			if(this instanceof Ejecutor) {
				if(c.esArrancable(fila, colum) == true)
					puesto = true;
				else if(c.NoOcupado(fila, colum) == true)
					puesto = true;
			}
			
			else if(c.NoOcupado(fila, colum) == true) {
				puesto = true;
			}
		}	
		return puesto;
	}
}