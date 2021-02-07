package unidad6;

import java.util.ArrayList;
import java.util.Iterator;

public class Entrenador {
	
	private String nombre;
	private ArrayList<Pokemon> pokemons;
	private int insignias;
	
	public Entrenador(String nombre) {
		this.nombre = nombre;
		pokemons = new ArrayList<>();
		insignias = 0;
	}

	public Entrenador(String nombre, ArrayList<Pokemon> pokemons) {
		this.nombre = nombre;
		this.pokemons = new ArrayList<>(pokemons);
		insignias = 0;
	}
	
	public Entrenador(String nombre, ArrayList<Pokemon> pokemons, int insignias) {
		this.nombre = nombre;
		this.pokemons = new ArrayList<>(pokemons);
		this.insignias = insignias;
	}

	public int getInsignias() {
		return insignias;
	}

	public void setInsignias(int insignias) {
		this.insignias = insignias;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void addPokemon(Pokemon p) {
		pokemons.add(p);
	}
	
	public void jugar(String elemento) {
		boolean gana = false;
		for(Pokemon p: pokemons)
			if (p.getElemento().equals(elemento)) {
				gana = true;
				insignias++;
			}
		if (!gana) {
			Iterator<Pokemon> i = pokemons.iterator();
			while (i.hasNext()) {
				Pokemon p = i.next();
				if (p.addSalud(-10) <= 0)
					i.remove();
			}
		}
	}
	
	@Override
	public String toString() {
		return nombre + " " + insignias + " " + pokemons.size();
	}
	
}
