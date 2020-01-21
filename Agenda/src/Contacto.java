
public class Contacto implements Comparable<Contacto> {

	private String nombre, apellido, direccion, telf;
	
	public Contacto (String nombre, String apellido, String direccion, String telf) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telf = telf;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelf() {
		return telf;
	}		
	
	// Con este toString mostramos todos los datos de un contacto. Lo aprovechamos tanto en la opción 4 como en la 5.
	@Override
	public String toString() {
		return ("Nombre: " + this.getNombre() +"\nApellido(s): " + this.getApellido() + "\nDirección: " + this.getDireccion() + "\nTeléfono: " + this.getTelf()+"\n");
	}
		
	// Con este compareTo ordenamos los contactos y cumplimos la función 6.
	@Override
	public int compareTo(Contacto cnt2) {		
		int res = apellido.compareTo(cnt2.apellido); // Tras haber implementado la interfaz "Comparable", creamos la variable "res" para guardar el resultado de la comparativa entre los apellidos.
		
		if (res == 0) { // Si ambos apellidos son iguales (es decir, devuelve 0), se compara por nombre
			res = nombre.compareTo(cnt2.nombre);
		}		
		return res; // La variable se devuelve al null del sort de Agenda.
	}
}
