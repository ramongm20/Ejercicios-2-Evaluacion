package unidad7;

import java.util.ArrayList;

public class Contratista extends Empleado {

	ArrayList<SociedadAnónima> empresas = new ArrayList<>();
	
	public Contratista(String nombre, String apellidos, String fecha, String cuenta) {
		super(nombre, apellidos, fecha, cuenta);
	}

	public void addEmpresa(SociedadAnónima empresa) {
		empresas.add(empresa);
	}
	
	public void removeEmpresa(SociedadAnónima empresa) {
		empresas.remove(empresa);
	}
	
	public SociedadAnónima [] getEmpresas() {
		return (SociedadAnónima []) empresas.toArray();
	}

	@Override
	public String toString() {
		return "Contratista [empresas=" + empresas + ", toString()=" + super.toString() + "]";
	}

	@Override
	public void realizarPago(double cantidad) {
		System.out.println("Realizando pago de " + cantidad + "€ a " + getNombre() + " en calidad de contratista");
	}
	
	
}
