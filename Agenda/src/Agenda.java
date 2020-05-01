import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class Agenda {
	
	List<Contacto> agenda; // Lista de Contactos (clase) llamada "agenda". Al ser List, podemos cambiar de ArrayList a LinkedList sin problemas.
	
	public Agenda() {
		agenda = new ArrayList<Contacto>(); // Especificamos que agenda sea ArrayList en un constructor para que se inicialice cuando sea llamado en "Menu"
	}
	
	public void añadir(Contacto cnt) {		
		agenda.add(cnt); // Con esto añadimos los datos encapsulados en cnt al ArrayList "agenda"
		System.out.println("\n¡Contacto añadido!\n");
	}
	
	public boolean eliminar(String nombre, String apellido) {		
		Contacto cnt = new Contacto(nombre, apellido, "", "");
		
		boolean eliminado = false;
		
		for (Contacto cnt2: agenda)
			if (cnt2.compareTo(cnt) == 0) {
				agenda.remove(agenda.indexOf(cnt2)); // "indexOf" devuelve la primera ocurrencia del elemento especificado en el ArrayList
				eliminado = true; // El boolean "eliminado" se pasa a true y se devuelve
				break; // Con esto rompemos el "for" de golpe al encontrar al contacto
			}
		return eliminado;
	}
	
	// Primero el método para buscar al contacto
	public Contacto buscar(String nombre, String apellido) {		
		Contacto c = new Contacto(nombre, apellido, "", null);
		
		Contacto busqueda = null;
		
		int posicion = Collections.binarySearch(agenda, c);
		
		if (posicion >= 0) {
			busqueda = agenda.get(posicion); 
		}		
		return busqueda;
	}
	
	public boolean modificar(String nom, String cognom, Contacto new_cnt) {		
		boolean modificat = eliminar(nom, cognom); // Llamamos al método "eliminar" para eliminar los antiguos valores de nombre y apellido
		
		if(modificat) {
			añadir(new_cnt); // Añadimos los nuevos datos como nuevo contacto
		}		
		return modificat;
	}
	
	public List<Contacto> buscar(Contacto atributo) {		
		List<Contacto> resultado = new ArrayList<Contacto>(agenda);
		
		ListIterator<Contacto> iterador;
		
		Contacto cnt;
		
		if (!atributo.getNombre().equals("")) {
			iterador = resultado.listIterator();
			while (iterador.hasNext()) {
				cnt = iterador.next();
				if (!cnt.getNombre().equals(atributo.getNombre()))
					iterador.remove();
			}
		}
		if (!atributo.getApellido().equals("")) {
			iterador = resultado.listIterator();
			while (iterador.hasNext()) {
				cnt = iterador.next();
				if (!cnt.getApellido().equals(atributo.getApellido()))
					iterador.remove();
			}
		}
		if (!atributo.getDireccion().equals("")) {
			iterador = resultado.listIterator();
			while (iterador.hasNext()) {
				cnt = iterador.next();
				if (!cnt.getDireccion().equals(atributo.getDireccion()))
					iterador.remove();
			}
		}
		if (!atributo.getTelf().equals("")) {
			iterador = resultado.listIterator();
			while (iterador.hasNext()) {
				cnt = iterador.next();
				if (!cnt.getTelf().equals(atributo.getTelf()))
					iterador.remove();
			}
		}
		return resultado;
	}
	    
	@Override
	public String toString() {
		String cadena = "";
		
		for (Contacto cnt: agenda)
			cadena = cadena + "\n" + cnt.toString(); // Este bucle hace que el String "cadena" vaya almacenando los valores del toString de Contacte
		return cadena;
	}
	
	public void ordenar() {	
		agenda.sort(null); // Con ".sort", el ArrayList "agenda" se ordenará según las especificaciones del compareTo de la clase "Contacto"
		System.out.println("\n¡Contactos ordenados!\n");
	}
}
