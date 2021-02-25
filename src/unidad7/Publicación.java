package unidad7;

public abstract class Publicación {
	private static int contador = 0;
	private int código;
	private String título;
	private int año;
	
	public Publicación(String título, int año) {
		this.código = ++contador;
		this.título = título;
		this.año = año;
	}

	public int getCódigo() {
		return código;
	}

	public String getTítulo() {
		return título;
	}

	public int getAño() {
		return año;
	}

	@Override
	public String toString() {
		return código + ", " + título + ", " + año;
	}
	
}
