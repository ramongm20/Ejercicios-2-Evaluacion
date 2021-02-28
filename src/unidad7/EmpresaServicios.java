package unidad7;

public class EmpresaServicios extends Empresa implements Pagable {

	private String servicio;
	private String cuenta;
	
	public EmpresaServicios(String nombre, String servicio, String cuenta) {
		super(nombre);
		this.servicio = servicio;
		this.cuenta = cuenta;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getServicio() {
		return servicio;
	}

	@Override
	public String toString() {
		return "EmpresaServicios [servicio=" + servicio + ", cuenta=" + cuenta + ", toString()=" + super.toString()
				+ "]";
	}

	@Override
	public void realizarPago(double cantidad) {
		System.out.println("Realizando pago de " + cantidad + " en concepto de servicio de " + servicio + " a " + getNombre());
	}

}
