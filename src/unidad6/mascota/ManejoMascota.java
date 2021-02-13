package unidad6.mascota;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ManejoMascota {
	private static ArrayList<MascotaVirtual> mascotas = new ArrayList<MascotaVirtual>();
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private static MascotaVirtual mascota;

	public static void main(String[] args) {
		boolean salir = false;
		
		while (!salir) {
			System.out.print("> ");
			try {
				Scanner sc = new Scanner(in.readLine());
				String accion = sc.next("crear|comer|dormir|ejercicio|curar|salir");
				if (sc.hasNext()) {
					String nombre = sc.next();
					mascota = getMascota(nombre, accion);
					if (mascota != null) {
						if (!mascota.getEnferma()) {
							actuar(accion);
						} else actuarEnferma(accion);
						System.out.println(mascota.getEstado());
						if (mascota.getDead()) {
							System.out.println(mascota.getNombre() + " ha fallecido después de una larga enfermedad. RIP.");
							mascotas.remove(mascotas.indexOf(mascota));
						}
					} else if (mascota == null)
						System.out.println("La mascota no existe.");
				} else if (accion.equalsIgnoreCase("salir"))
					salir = true;
			} catch (IOException e) {
				e.printStackTrace();
			} catch(NoSuchElementException nsee) {
				System.out.println("Comando no válido.");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} // cierra while
	}

	private static MascotaVirtual getMascota(String nombre, String accion) {
		for (int i=0; i<mascotas.size(); i++) {
			if (mascotas.get(i).getNombre().equalsIgnoreCase(nombre))
				return mascotas.get(i);
		}
		if (accion.equalsIgnoreCase("crear")) {
			mascotas.add(new MascotaVirtual(nombre));
			return mascotas.get(mascotas.size()-1);
		}
		return null;
	} // cierra getMascota

	public static void actuar(String accion) throws Exception {
		switch (accion.toLowerCase()) {
		case "comer":
	mascota.comer();
	break;
		case "dormir":
			mascota.dormir();
			break;
		case "ejercicio":
			mascota.ejercicio();
			break;
		case "curar":
			System.out.println(mascota.getNombre() + " no requiere medicina.");
			break;
			default:
		} // cierra switch
	}
	public static void actuarEnferma(String accion) throws Exception {
		switch (accion.toLowerCase()) {
		case "comer":
		case "dormir":
		case "ejercicio":
		mascota.mortificar();
		System.out.println(mascota.getNombre() + " está enferma y no le ha sentado bien esto.");
		break;
		case "curar":
			mascota.curar();
			break;
			default:
		} // switch
	}
}
