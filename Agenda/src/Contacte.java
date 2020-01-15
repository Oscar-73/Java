
public class Contacte implements Comparable<Contacte> {

	private String nom, cognom, adresa, telf;
	
	public Contacte (String nom, String cognom, String adresa, String telf) {
		this.nom = nom;
		this.cognom = cognom;
		this.adresa = adresa;
		this.telf = telf;
	}

	public String getNom() {
		return nom;
	}

	public String getCognom() {
		return cognom;
	}

	public String getAdresa() {
		return adresa;
	}

	public String getTelf() {
		return telf;
	}
	
	
	// 5. VEURE CONTACTES
	
	@Override
	public String toString() {
		return ("Nom: " + this.getNom() +", Cognom(s): " + this.getCognom() + ", Telèfon: " + this.getTelf() + ",  Adreça: " + this.getAdresa());
	}
	
	// 6. ORDENAR CONTACTES
	
	@Override
	public int compareTo(Contacte cnt2) {
		
		int res = cognom.compareTo(cnt2.cognom); // Tras haber implementado la interfaz "Comparable", creamos la variable "res" para guardar el valor de la comparación de los apellidos
		
		if (res == 0) { // Si ambos apellidos son iguales (es decir, devuelve 0), se compara por nombre
			res = nom.compareTo(cnt2.nom);
		}
		
		return res; // La variable se devuelve al null del sort de Agenda
	}
}
