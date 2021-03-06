package fp.daw.naipes.blackjack;

import java.util.Scanner;

public class BlackJackConsola {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String linea;
		BlackJack juego = new BlackJack();
		mostrarLinea(juego);
		linea = in.nextLine();
		while (!linea.equals("fin")) {
			String [] cmd = linea.split(" ");
			try {
				switch (cmd[0]) {
				case "unirse":
					if (cmd.length != 2)
						System.out.println("no lo entiendo: " + linea);
					else
						juego.unirse(cmd[1]);
					break;
				case "retirarse":
					if (cmd.length != 2)
						System.out.println("no lo entiendo: " + linea);
					else
						juego.retirarse(cmd[1]);
					break;
				case "repartir":
					if (cmd.length > 1)
						System.out.println("no lo entiendo: " + linea);
					else
						juego.repartir();
					System.out.println(juego);
					break;
				case "pedir":
					if (cmd.length > 1)
						System.out.println("no lo entiendo: " + linea);
					else
						juego.pedir();
					System.out.println(juego);
					break;
				case "plantarse":
					if (cmd.length > 1)
						System.out.println("no lo entiendo: " + linea);
					else
						juego.plantarse();
					System.out.println(juego);
					break;
				default:
					System.out.println("no lo entiendo: " + linea);
				}	
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
			mostrarLinea(juego);
			linea = in.nextLine();
		}
		in.close();
	}
	
	static void mostrarLinea(BlackJack juego) {
		System.out.print("Blackjack");
		if (!juego.finalizado())
			System.out.print( " (" + juego.sgte() + ")");
		System.out.print("> ");
	}

}
