package unidad7;

public class Libro extends Publicación implements Prestable {
	
	private String autor;
	private boolean prestado = false;

	public Libro(String título, int año, String autor) {
		super(título, año);
		this.autor = autor;
	}

	public String getAutor() {
		return autor;
	}

	@Override
	public String toString() {
		return "Libro [" + super.toString() + ", " + autor + ", " + prestado + "]";
	}
	
	@Override
public void prestarPublicación() {
	if (!prestado) prestado = true;
	else prestado = false;
}
}
