
public class Agresibus extends Fungus implements Arrencador, Arrencable {

	public Agresibus(Colonia colonia) {
		super(colonia);
		// TODO Auto-generated constructor stub
	}

	@Override
	void creix(Cultiu cult) {
		
		Agresibus amunt = new Agresibus(colonia);
		Agresibus avall = new Agresibus(colonia);
		Agresibus dreta = new Agresibus(colonia);
		Agresibus esquerra = new Agresibus(colonia);
		
		cult.setFungus(amunt, this.getFila()-1, this.getCol());
		cult.setFungus(avall, this.getFila()+1, this.getCol());
		cult.setFungus(dreta, this.getFila(), this.getCol()+1);
		cult.setFungus(esquerra, this.getFila(), this.getCol()-1);
	}

	
}
