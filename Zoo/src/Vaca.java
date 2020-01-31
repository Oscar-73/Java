
public class Vaca extends Animal {
	@Override
	public String moverse(Zoo zoo) {
		return "\nUna vaca se pone a dormir.";
	}

	@Override
	public String alimentarse(Zoo zoo) {
		return "\nUna vaca empieza a pastar tranquilamente.";
	}

	@Override
	public String expresarse(Zoo zoo) {
		return "\nUna vaca hace mu.";
	}
}
