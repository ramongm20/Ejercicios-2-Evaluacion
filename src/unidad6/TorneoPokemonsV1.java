package unidad6;

import java.util.ArrayList;
import java.util.Scanner;

public class TorneoPokemonsV1 {

	private static Scanner in = new Scanner(System.in);
	private static ArrayList<Entrenador> entrenadores = new ArrayList<>();
	
	public static void main(String[] args) {
		 while (quieroJugar()) {
			 obtenerEntrenadores();
			 if (entrenadores.size() > 0)
				 jugar();
			 else
				 System.out.println("No hay entrenadores para jugar el torneo");
		 }
	}
	
	static void obtenerEntrenadores() {
		String linea = in.nextLine();
		while (!linea.equalsIgnoreCase("torneo")) {
			String [] items = linea.split(" ");
			if (items.length != 4)
				System.out.println("Entrada de datos incorrecta, vuelve a introducirlos");
			else {
				String entrenador = items[0];
				String pokemon = items[1]; 
				String elemento = items[2];
				try {
					int salud = Integer.parseInt(items[3]);
					actualizarEntrenador(entrenador, pokemon, elemento, salud);
				} catch (NumberFormatException e) {
					System.out.println("Entrada de datos incorrecta, vuelve a introducirlos");
				}
			}
			linea = in.nextLine();
		}
	}
	
	static void actualizarEntrenador(String nombre, String pokemon, String elemento, int salud) {
		Entrenador entrenador = null;
		for (Entrenador e: entrenadores)
			if (e.getNombre().equals(nombre)) {
				entrenador = e;
				break;
			}
		if (entrenador == null) {
			entrenador = new Entrenador(nombre);
			entrenadores.add(entrenador);
		}
		entrenador.addPokemon(new Pokemon(pokemon, elemento, salud));
	}
	
	static void jugar() {
		String linea = in.nextLine();
		while (!linea.equalsIgnoreCase("fin")) {
			for (Entrenador e: entrenadores)
				e.jugar(linea);
			linea = in.nextLine();
		}
		entrenadores.forEach(p -> System.out.println(p));
	}
	
	static boolean quieroJugar() {
		boolean quieroJugar;
		boolean correcta;
		do {
			System.out.print("¿Jugar un torneo? (s/n): ");
			String respuesta = in.nextLine().toLowerCase();
			correcta = (quieroJugar = respuesta.equals("s")) || respuesta.equals("n");
			if (!correcta)
				System.out.println("Respuesta incorrecta");
		} while (!correcta);
		return quieroJugar;
	}

}

/*
Ash Charizard fuego 100
Brock Squirtle agua 38 
Ash Pikachu electricidad 10
torneo
fuego
electricidad
fin
*/

/*
Misty Blastoise agua 18
Clemont Pikachu electricidad 22
Millo Kadabra psíquico 90
torneo
fuego
electricidad
fuego
fin
*/
