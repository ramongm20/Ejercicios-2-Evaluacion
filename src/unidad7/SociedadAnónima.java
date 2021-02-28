package unidad7;

import java.util.ArrayList;

public class SociedadAnónima extends Empresa {

	private ArrayList<String> trabajos;
	
	public SociedadAnónima(String nombre) {
		super(nombre);
	}

	public void addTrabajo(String trabajo) {
		trabajos.add(trabajo);
	}
	
	public void removeTrabajo(String trabajo) {
		trabajos.remove(trabajo);
	}
	
	public String [] getTrabajos() {
		return (String[]) trabajos.toArray();
	}

	@Override
	public String toString() {
		return "SociedadAnónima [trabajos=" + trabajos + "]";
	}
	
}
