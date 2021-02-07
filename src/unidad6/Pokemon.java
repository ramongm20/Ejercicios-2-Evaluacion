package unidad6;

public class Pokemon {

	private String nombre;
	private String elemento;
	private int salud;
	
	public Pokemon(String nombre, String elemento, int salud) {
		this.nombre = nombre;
		this.elemento = elemento;
		this.salud = salud;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}
	
	public int addSalud(int salud) {
		return this.salud += salud;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getElemento() {
		return elemento;
	}

	@Override
	public String toString() {
		return "Pokemon [nombre=" + nombre + ", elemento=" + elemento + ", salud=" + salud + "]";
	}
	
}
