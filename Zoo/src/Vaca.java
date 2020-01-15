
public class Vaca extends Animal {

	@Override
	public String mou(Zoo zoo) {
		
		return "\nUna vaca es posa a dormir.";
	}

	@Override
	public String alimenta(Zoo zoo) {

		return "\nUna vaca comença a pastar amb tranquil·litat.";
	}

	@Override
	public String expressa(Zoo zoo) {
		
		return "\nUna vaca fa mu.";
	}

}
