package fp.daw.naipes;

public class Naipe {
	
	private Palo palo;
	private Rango rango;
	private int valor;
	
	public Naipe(Palo palo, Rango rango) {
		this.palo = palo;
		this.rango = rango;
	}
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Palo getPalo() {
		return palo;
	}

	public Rango getRango() {
		return rango;
	}
		
	@Override
	public String toString() {
		return  "" + rango + palo;
	}
}
