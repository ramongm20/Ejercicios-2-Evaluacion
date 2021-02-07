package unidad5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
/**
 * 
 * @author Ramón García
 *
 */
public class CartaMasAlta {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean salir = false;
	static Mazo mazo;
	static Mazo manoHumano = new Mazo(0);
	static Mazo manoMaquina = new Mazo(0);
	static int turno;
	static int [] marcador = new int[2];
	static Naipe nHumano, nMaquina;
	static Collection<Naipe> nRetirados = new ArrayList<Naipe>();

	public static void main(String[] args) throws IOException{
		int [] valores = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		Naipe.setValorRangos(valores);
		
System.out.println("La carta más alta");

		while (!salir) {
			System.out.println("\nSelecciona una opción:\n1. Instrucciones\n2. Empezar\n3. Salir");
			switch (Integer.parseInt(br.readLine())) {
			case 1:
				System.out.println("En cada partida se reparten 13 cartas para cada jugador. Quien lleve el turno mostrará una carta, que el rival tratará de superar. Quien haya sacado la carta más alta suma un punto. En caso de que las cartas valgan lo mismo se descartan. Gana el jugador que acumule más puntos en la partida. Cuando la ventaja de un bando sea irreversible, la partida terminará. Las partidas se juegan hasta que las cartas del mazo se acaben.");
				break;
			case 2:
				configuracion();
				break;
			case 3:
				System.out.println("Adiós.");
				salir = true;
				break;
				default: System.out.println("Seleccione una opción 1-3.");
			} // switch
		} // while
	} // main

	static void configuracion() throws NumberFormatException, IOException {
		System.out.println("¿Con cuántos mazos quieres jugar?\n1. Solo un mazo con 52 cartas (2 partidas)\n2. Más de un mazo");
		if (Integer.parseInt(br.readLine()) == 1) {
			mazo = new Mazo();
		} else {
			System.out.print("Número de mazos: ");
			int nMazos = Integer.parseInt(br.readLine());
			mazo = new Mazo(nMazos);
			System.out.println("De acuerdo, jugamos con " + mazo.size() + " cartas. " + (mazo.size() / 4) + " partidas.");
		} // else
		jugar();
		while (!salir) {
			if (turno == 0) turnoHumano();
			else turnoMaquina();
			turno = nHumano == null ? 0:1;
		if (manoHumano.size() == manoMaquina.size()) {
			if (nHumano.getValor() == nMaquina.getValor()) {
				System.out.println("Empate, las cartas se retiran.");
				turno = turno == 0 ? 1:0;
			} else if (nHumano.getValor() > nMaquina.getValor()) {
				marcador[0]++;
				System.out.println("Sumas un punto. Tienes " + marcador[0] + " en total, y la máquina, " + marcador[1] + ".");
				turno = 0;
			} else if (nHumano.getValor() < nMaquina.getValor()) {
				marcador[1]++;
				System.out.println("La máquina suma un punto. Tienes " + marcador[0] + " en total, y la máquina, " + marcador[1] + ".");
				turno = 1;
			}
			nRetirados.add(nHumano);
			nHumano = null;
			nRetirados.add(nMaquina);
			nMaquina = null;
			int ganador = marcador[0] > marcador[1] ? 0:1;
			int perdedor = ganador>0? 0:1;
			int ventajaGanador = marcador[ganador] - marcador[perdedor];
			if ((manoHumano.size() == 0 && manoMaquina.size() == 0) || ventajaGanador > manoMaquina.size()) {
				System.out.println(marcador[0] > marcador[1] ? "Has ganado la partida.": "La máquina ha ganado la partida.");
				if (mazo.size() > 0)
					jugar();
				else {
					System.out.println("¿Jugar otra vez (s/n)?");
					if (br.readLine().charAt(0) == 115) {
						for (int i=0; i<manoHumano.size(); i++) {
							nRetirados.add(manoHumano.remove(i));
							nRetirados.add(manoMaquina.remove(i));
						} // for
						mazo.addAll(nRetirados);
						jugar();
					} else {
						System.out.println("Adiós.");
						salir = true;
					} // else
				} // if
			}
		} // if
		} // while
	} // configuracion

	static void turnoMaquina() {
		if (nHumano == null)
			nMaquina = manoMaquina.getMaxMin(1);
		else
			nMaquina = manoMaquina.getCartaSuperior(nHumano);
		System.out.println("La maquina pone: " + nMaquina.toString());
	} // turnoMaquina

	static void turnoHumano() throws NumberFormatException, IOException {
		System.out.println("Es tu turno. Escoge una opción:");
		for (int i=0; i<manoHumano.size(); i++)
			System.out.println((i+1) + ". " + manoHumano.get(i).toString());
		
		int opcion = Integer.parseInt(br.readLine());
		nHumano = manoHumano.remove(opcion-1);
		System.out.println("Pones la carta: " + nHumano.toString());
	} // turnoHumano

	static void jugar() throws IOException {
		marcador[0] = 0;
		marcador[1] = 0;
		System.out.println("Comienza una nueva partida. Pulsa Enter para sacar una carta aleatoria del mazo. La máquina hará lo mismo. Empezará quien saque la carta más alta.");
		br.readLine();

		nHumano = new Naipe(0, 0);
		nMaquina = new Naipe(0, 0);
		while (nHumano.compareTo(nMaquina) == 0) {
		nHumano = mazo.get();
		nMaquina = mazo.get();
		} // while
		
		System.out.println("Tu carta: " + nHumano.toString() + "\nCarta de la máquina: " + nMaquina.toString() + "\n" + (nHumano.compareTo(nMaquina) > 0 ? "Tú empiezas.": "La máquina empieza."));
		turno = nHumano.compareTo(nMaquina) > 0 ? 0: 1;
		nHumano = null;
		nMaquina = null;
		
		for (int i=0; i<13; i++) {
			manoHumano.add(mazo.remove());
			manoMaquina.add(mazo.remove());
		} // for i

	} // jugar
}