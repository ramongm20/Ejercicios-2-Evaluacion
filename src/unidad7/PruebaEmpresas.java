package unidad7;

import java.util.ArrayList;

public class PruebaEmpresas {

	public static void main(String[] args) {
		ArrayList<Pagable> pagables = new ArrayList<>();
		pagables.add(new Asalariado("Juan", "Pérez", "1/1/1991", "1", 1000));
		pagables.add(new Contratista("Juan", "Pérez", "1/1/1991", "1"));
		pagables.add(new EmpresaServicios("Telefónica", "telefonía", "2"));
		
		for(Pagable p: pagables) {
			double cantidad;
			if (p instanceof Asalariado)
				cantidad = ((Asalariado) p).getSalario();
			else if (p instanceof Contratista)
				cantidad = 10000;
			else
				cantidad = 5000;
			p.realizarPago(cantidad);
		}
	}

}
