package fp.daw.naipes;

public enum Rango {
	A("A"), DOS("2"), TRES("3"), CUATRO("4"), CINCO("5"), SEIS("6"),
	SIETE("7"), OCHO("8"), NUEVE("9"), DIEZ("10"), J("J"), Q("Q"), K("K");
	
	private String nombre;
	
	private Rango(String nombre) {
		this.nombre = nombre;
	}

	public boolean esFigura() {
		return this == A || this == J || this == Q || this == K;
	}
	
	public String toString() {
		return nombre;
	}
	
}
