import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class Agenda {
	
	List<Contacte> agenda; // Lista de Contactos (clase) llamada "agenda". De esta forma, podemos cambiar de ArrayList a LinkedList sin problemas.
	
	
	
	public Agenda() {
		agenda = new ArrayList<Contacte>(); // Especificamos que agenda sea ArrayList en un constructor para que se inicialice cuando lo llames en el main
	}
	
	
	// 1. AFEGIR CONTACTES
	
	public void afegirContacte(Contacte cnt) {
		
		agenda.add(cnt); // Con esto añadimos los datos encapsulados en cnt al ArrayList "agenda"
	}
	
	// 2. ESBORRAR CONTACTE
	
	public boolean eliminar(String nom, String cognom) {
		
		Contacte cnt = new Contacte (nom, cognom, "", "");
		
		boolean eliminat = false;
		
		for (Contacte cnt2: agenda)
			if (cnt2.compareTo(cnt) == 0) {
				agenda.remove(agenda.indexOf(cnt2)); // "indexOf" devuelve la primera ocurrencia del elemento especificado en el ArrayList
				eliminat = true; // El boolean "eliminat" se pasa a true y se devuelve
				break; // Con esto rompemos el "for" de golpe al encontrar al contacto
			}

		return eliminat;
	}
	
	// 3. MODIFICAR CONTACTE
	
	public Contacte cercar(String nom, String cognom) { // Primero el método para buscar al contacto
		
		Contacte c = new Contacte(nom, cognom, "", "");
		
		Contacte cerca = null;
		
		int posicio = Collections.binarySearch(agenda, c);
		
		if (posicio >= 0) {
			cerca = agenda.get(posicio); 
		}
		
		return cerca;
	}
	
	public boolean modificar(String nom, String cognom, Contacte new_cnt) {
		
		boolean modificat = eliminar(nom, cognom); // Llamamos al método "eliminar" para eliminar los antiguos valores de nom y cognom
		
		if(modificat) {
			afegirContacte(new_cnt); // Añadimos los nuevos datos como nuevo contacto
		}
		
		return modificat;
	}
	
	// 4. CERCAR CONTACTE
	
	public List<Contacte> cerca(Contacte atribut) {
		
		List<Contacte> resultat = new ArrayList<Contacte>(agenda);
		
		ListIterator<Contacte> iterador;
		
		Contacte cnt;
		
		if (!atribut.getNom().equals("")) {
			iterador = resultat.listIterator();
			while (iterador.hasNext()) {
				cnt = iterador.next();
				if (!cnt.getNom().equals(atribut.getNom()))
					iterador.remove();
			}
		}
		if (!atribut.getCognom().equals("")) {
			iterador = resultat.listIterator();
			while (iterador.hasNext()) {
				cnt = iterador.next();
				if (!cnt.getCognom().equals(atribut.getCognom()))
					iterador.remove();
			}
		}
		if (!atribut.getAdresa().equals("")) {
			iterador = resultat.listIterator();
			while (iterador.hasNext()) {
				cnt = iterador.next();
				if (!cnt.getAdresa().equals(atribut.getAdresa()))
					iterador.remove();
			}
		}
		if (!atribut.getTelf().equals("")) {
			iterador = resultat.listIterator();
			while (iterador.hasNext()) {
				cnt = iterador.next();
				if (!cnt.getTelf().equals(atribut.getTelf()))
					iterador.remove();
			}
		}
		return resultat;
	}
	    
	
	
	
	// 5. VEURE CONTACTES
	
	@Override
	public String toString() {

		String cadena = "";
		for (Contacte cnt: agenda)
			cadena = cadena + "\n" + cnt.toString(); // Este bucle hace que el String "cadena" vaya almacenando los valores del toString de Contacte
		return cadena;
	}
	
	// 6. ORDENAR CONTACTES
	
	public void ordenar() {
	
		agenda.sort(null); // Con ".sort", el ArrayList "agenda" se ordenará según las especificaciones del compareTo de la clase "Contacte"
	}
	
}
