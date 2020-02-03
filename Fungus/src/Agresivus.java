
public class Agresivus extends Fungus implements Ejecutor, Ejecutable {

	public Agresivus(Colonia colonia) {
		super(colonia);
	}

	// Los hongos Agresivus crecen en cuatro direcciones devorando a quien esté en alguna de estas.
	// Son representados como "x".
	@Override
	void crecer(Cultivo cult) {
		Agresivus arriba = new Agresivus(colonia);
		Agresivus abajo = new Agresivus(colonia);
		Agresivus derecha = new Agresivus(colonia);
		Agresivus izquierda = new Agresivus(colonia);
		
		cult.setFungus(arriba, this.getFila()-1, this.getCol());
		cult.setFungus(abajo, this.getFila()+1, this.getCol());
		cult.setFungus(derecha, this.getFila(), this.getCol()+1);
		cult.setFungus(izquierda, this.getFila(), this.getCol()-1);
	}
}
