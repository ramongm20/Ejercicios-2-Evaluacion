package unidad7;

public abstract class Empleado implements Pagable{

	private String nombre;
	private String apellidos;
	private String fecha;
	private String cuenta;

	public Empleado(String nombre, String apellidos, String fecha, String cuenta) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha = fecha;
		this.cuenta = cuenta;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getFecha() {
		return fecha;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", apellidos=" + apellidos + ", fecha=" + fecha + ", cuenta=" + cuenta
				+ "]";
	}

}
