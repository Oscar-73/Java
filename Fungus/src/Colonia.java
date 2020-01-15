
public class Colonia implements Comparable<Colonia> {
	
	private String nom;
	private int poblacio;
	
	public int getPoblacio() {
		return poblacio;
	}

	public String getNom() {
		return nom;
	}

	public Colonia(String nom, int poblacio) {
		this.nom = nom;
		this.poblacio = poblacio;
	}
	
	public void augmentaPoblacio() {
		poblacio++;  
	}
	
	public void disminueixPoblacio() {
		poblacio--;
	}

	@Override
	public int compareTo(Colonia c) {
		
		int comp_c;
		
		if (poblacio > c.poblacio) { 
			comp_c = 1;
		}
		
		else if(poblacio == c.poblacio) {
			comp_c = 0;
		}
			
		else
			comp_c = -1;
		
		return comp_c;
	}
	
	@Override
	public String toString() {

		String cadena = "";
		
		System.out.println("Colònia " + nom + " , població: "+ poblacio);
		
		return cadena;
	}

}
