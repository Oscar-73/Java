
public class Pokemon {
	private int id, suma, ps, ataque, defensa, ataque_especial, defensa_especial, velocidad, generacion; 
	private String nombre, tipo1, tipo2;
	private boolean legendario;
		
	public Pokemon(int id, String nombre, String tipo1, String tipo2, int suma, int ps, int ataque, int defensa, int ataque_especial, int defensa_especial, int velocidad, int generacion, boolean legendario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
		this.suma = suma;
		this.ps = ps;
		this.ataque = ataque;
		this.defensa = defensa;
		this.ataque_especial = ataque_especial;
		this.defensa_especial = defensa_especial;
		this.velocidad = velocidad;
		this.generacion = generacion;		
		this.legendario = legendario;
	}

	public int getId() {
		return id;
	}

	public int getSuma() {
		return suma;
	}

	public int getPs() {
		return ps;
	}

	public int getAtaque() {
		return ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public int getAtaque_especial() {
		return ataque_especial;
	}

	public int getDefensa_especial() {
		return defensa_especial;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public int getGeneracion() {
		return generacion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo1() {
		return tipo1;
	}

	public String getTipo2() {
		return tipo2;
	}

	public boolean isLegendario() {
		return legendario;
	}
}
