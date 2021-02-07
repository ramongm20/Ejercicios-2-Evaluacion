package unidad5;

import java.util.ArrayList;
import java.util.Scanner;

public class PruebaAutomovil {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	ArrayList<Automovil> autos = new ArrayList<Automovil>();
	System.out.print("Número de automóviles: ");
	int n = in.nextInt();
	System.out.println("En las siguientes líneas se introducen los datos de cada automóvil con el formato siguiente: <modelo> <capacidad del depósito> <litros en el depósito> <consumo>");
	for (int i=1; i<=n; i++) {
		in.nextLine();
		System.out.print(i + ".: ");
		autos.add(new Automovil(in.next(), in.nextDouble(), in.nextDouble(), in.nextDouble()));
	} // cierra for i
	
	System.out.println("Desplazamientos que han de realizar los automóviles con el formato siguiente: desplazar <modelo> <kilómetros>. Para dejar de mover coches, escribir \"fin\": ");
	boolean salir = false;
	while (!salir) {
		in.nextLine();
		String accion = in.next();
		if (accion.equals("desplazar")) {
			String modelo = in.next();
			for (int i=0; i<autos.size(); i++) {
				if (autos.get(i).getModelo().equalsIgnoreCase(modelo)) {
					Double consumido = autos.get(i).desplazar(in.nextInt());
					if (consumido != null)
						System.out.printf("%s %.2f %.2f\n", autos.get(i).getModelo(), autos.get(i).getCantidadCombustible(), consumido);
					else System.out.println("Combustible insuficiente para este desplazamiento.");
				}
			} // cierra for i
		} else if (accion.equals("fin")) {
			in.close();
			salir = true;
		}
	} // cierra while
	
	for (int i=0; i<autos.size(); i++)
		System.out.println(autos.get(i).toString());
}
}
