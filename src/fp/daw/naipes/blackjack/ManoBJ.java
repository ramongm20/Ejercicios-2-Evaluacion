package fp.daw.naipes.blackjack;

import fp.daw.naipes.Mazo;
import fp.daw.naipes.Naipe;
import fp.daw.naipes.Rango;

public class ManoBJ extends Mazo {

	private String nombre;
	private int valor = 0;
	
	public ManoBJ(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	@Override
	public void add(Naipe naipe) {
		super.add(naipe);
		if (naipe.getRango() == Rango.A)
			naipe.setValor(11);
		else if (naipe.getRango().esFigura())
			naipe.setValor(10);
		else
			naipe.setValor(naipe.getRango().ordinal() + 1);
		valor += naipe.getValor();
		for (int i = naipes.size() - 1; i >= 0 && valor > 21; i--) {
			Naipe n = naipes.get(i);
			if (n.getRango() == Rango.A && n.getValor() == 11) {
				n.setValor(1);
				valor -= 10;
			}
		}
	}
	
	public int getValor() {
		return valor;
	}
	
	public boolean blackjack() {
		return valor == 21 && naipes.size() == 2;
	}
	
	public String toString(boolean ocultar) {
		StringBuilder sb = new StringBuilder();
		if (ocultar) {
			sb.append(naipes.get(0).toString());
			sb.append(" **");
		}
		else {
			for (Naipe naipe: naipes) {
				sb.append(naipe.toString());
				sb.append("(");
				sb.append(naipe.getValor());
				sb.append(") ");
			}
			sb.append("= ");
			sb.append(valor);
			if (blackjack())
				sb.append(" (BLACKJACK)");
		}
		return sb.toString();
	}
	
	@Override
	public void descartar(Mazo mazo) {
		super.descartar(mazo);
		valor = 0;
	}
	
}
