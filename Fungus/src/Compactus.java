
public class Compactus extends Fungus implements Arrencable {
	
	public Compactus(Colonia colonia) {
		super(colonia);
		// TODO Auto-generated constructor stub
	}

	@Override
	void creix(Cultiu cult) {
		
		Compactus comp1 = new Compactus(colonia);
		Compactus comp2 = new Compactus(colonia);
		Compactus comp3 = new Compactus(colonia);
		Compactus comp4 = new Compactus(colonia);
		Compactus comp5 = new Compactus(colonia);
		Compactus comp6 = new Compactus(colonia);
		Compactus comp7 = new Compactus(colonia);
		Compactus comp8 = new Compactus(colonia);
		
		cult.setFungus(comp1, this.getFila()-1, this.getCol()-1);
		cult.setFungus(comp2, this.getFila()-1, this.getCol());
		cult.setFungus(comp3, this.getFila()-1, this.getCol()+1);
		cult.setFungus(comp4, this.getFila(), this.getCol()-1);
		cult.setFungus(comp5, this.getFila(), this.getCol()+1);
		cult.setFungus(comp6, this.getFila()+1, this.getCol()-1);
		cult.setFungus(comp7, this.getFila()+1, this.getCol());
		cult.setFungus(comp8, this.getFila()+1, this.getCol()+1);

	}
	
	
}
