package fp.daw.naipes;

import java.util.ArrayList;
import java.util.Random;

public class Mazo {
	
	private static Random r = new Random();
	
	protected ArrayList<Naipe> naipes;;
	
	public Mazo() {
		 naipes = new ArrayList<>();
	}
	
	public Mazo(int barajas) {
		this();
		for (int i=0; i<barajas; i++)
			for (Palo p: Palo.values())
				for (Rango r: Rango.values())
					naipes.add(new Naipe(p, r));
	}
	
	public void add(Naipe naipe) {
		naipes.add(naipe);
	}
	
	public void descartar(Mazo mazo) {
		mazo.naipes.addAll(naipes);
		naipes.clear();
	}
	
	public Naipe get() {
		return naipes.get(r.nextInt(naipes.size()));
	}
	
	public Naipe remove() {
		return naipes.remove(r.nextInt(naipes.size()));
	}
	
	public Naipe[] getNaipes() {
		return (Naipe []) naipes.toArray();
	}
	
	public int size() {
		return naipes.size();
	}
	
	public boolean isEmpty() {
		return naipes.isEmpty();
	}
}
