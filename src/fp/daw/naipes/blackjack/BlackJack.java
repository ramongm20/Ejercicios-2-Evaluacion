package fp.daw.naipes.blackjack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fp.daw.naipes.Mazo;

public class BlackJack {

	private ManoBJ crupier = new ManoBJ("Crupier");
	private List<ManoBJ> jugadores = new ArrayList<>();
	private List<ManoBJ> jugando = new ArrayList<>();
	private int sgte;
	private Mazo mazo = new Mazo(6);
	private Mazo descarte = new Mazo();
	
	
	public void unirse(String nombre) {
		if (jugadores.size() == 6)
			throw new RuntimeException("no se se admiten más de seis jugadores");
		nombre = nombre.strip();
		for (ManoBJ jugador: jugadores)
			if (jugador.getNombre().equals(nombre))
				throw new RuntimeException("el nombre '" + nombre + "' ya está en uso");
		jugadores.add(new ManoBJ(nombre));
	}

	public void retirarse(String nombre) {
		if (jugadores.isEmpty())
			throw new RuntimeException("no se encuentra el jugador");
		if (!jugando.isEmpty())
			throw new RuntimeException("no te puedes retirar con la partida iniciada");
		nombre = nombre.strip();
		Iterator<ManoBJ> i = jugadores.iterator();
		boolean encontrado = false;
		while (i.hasNext())
			if (i.next().getNombre().equals(nombre)) {
				encontrado = true;
				i.remove();
			}
		if (!encontrado)
			throw new RuntimeException("jugador no encontrado");
	}
	
	public void repartir() {
		if (!jugando.isEmpty())
			throw new RuntimeException("no se puede repartir, la mano está en juego");
		if (jugadores.isEmpty())
			throw new RuntimeException("no se puede repartir, no hay jugadores");
		jugando.addAll(jugadores);
		sgte = 0;
		if (mazo.size() <= 70)
			descarte.descartar(mazo);
		if (crupier.size() > 0)
			crupier.descartar(descarte);
		for (ManoBJ jugador : jugadores)
			if (jugador.size() > 0)
				jugador.descartar(descarte);
		for (int i = 0; i < 2; i++) {
			crupier.add(mazo.remove());
			for (ManoBJ jugador : jugadores) {
				jugador.add(mazo.remove());
				if (i == 1 && jugador.getValor() == 21) 
					jugando.remove(jugador);
			}
		}
		if (jugando.isEmpty())
			finalizarMano();
	}

	public String sgte() {
		return jugando.get(sgte).getNombre();
	}

	public void pedir() {
		if (jugando.isEmpty())
			throw new RuntimeException("no se puede pedir antes de repartir");
		ManoBJ jugador = jugando.get(sgte);
		jugador.add(mazo.remove());
		if (jugador.getValor() >= 21)
			plantarse();
		else {
			if (++sgte == jugando.size())
				sgte = 0;
		}
	}

	public void plantarse() {
		if (jugando.isEmpty())
			throw new RuntimeException("no se puede plantar");
		jugando.remove(sgte);
		if (jugando.isEmpty())
			finalizarMano();
		else if (sgte == jugando.size())
			sgte = 0;
			
	}
	
	private void finalizarMano() {
		while (crupier.getValor() < 17)
			crupier.add(mazo.remove());
	}

	public boolean finalizado() {
		return jugando.isEmpty();
	}

	private String resultado(ManoBJ jugador) {
		int vc = crupier.getValor();
		int vj = jugador.getValor();
		if (vj > 21)
			return "La banca gana";
		else if (jugando.isEmpty()) {
			if (vc > 21 || vj > vc || (jugador.blackjack() && !crupier.blackjack()))
				return "El jugador gana";
			else if (vj < vc || (!jugador.blackjack() && crupier.blackjack()))
				return "La banca gana";
			else
				return "Empate";
		}
		else {
			if (!jugando.contains(jugador))
				return "plantado";
			else
				return "en juego";
		}
	}
	
	public String toString() {
		String resultado = "Crupier: " + crupier.toString(!jugando.isEmpty()) + "\n";
		for (ManoBJ jugador: jugadores)
			resultado += jugador.getNombre() + ": " + jugador.toString(false) + " - " + resultado(jugador) + "\n";
		return resultado;
	}

}
