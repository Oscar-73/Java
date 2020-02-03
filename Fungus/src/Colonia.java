
public class Colonia implements Comparable<Colonia> {
	
	private String nombre;
	private int poblacion;
	
	public int getPoblacion() {
		return poblacion;
	}

	public String getNombre() {
		return nombre;
	}

	public Colonia(String nombre, int poblacion) {
		this.nombre = nombre;
		this.poblacion = poblacion;
	}
	
	public void aumentarPoblacion() {
		poblacion++; 
	}
	
	public void disminuirPoblacion() {
		poblacion--;
	}

	@Override
	public int compareTo(Colonia c) {
		int comp_c;
		
		if (poblacion > c.poblacion) 
			comp_c = 1;		
		else if(poblacion == c.poblacion)
			comp_c = 0;
		else
			comp_c = -1;
		
		return comp_c;
	}
	
	@Override
	public String toString() {
		return "Colonia " + nombre + ", población: "+ poblacion;
	}
}
