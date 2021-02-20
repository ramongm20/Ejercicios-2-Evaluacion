package unidad7;

public class Televisor extends Electrodomestico {
	private int tamaño = 20;
	private String sintetizador = Sintetizador.UNO.getTipo();
	public Televisor(double precio, double peso, Color color, Consumo consumo, int tamaño, String sintetizador) {
		super(precio, peso, color, consumo);
		this.tamaño = tamaño;
		this.sintetizador = sintetizador;
	}
	public int getTamaño() {
		return tamaño;
	}
	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}
	public String getSintetizador() {
		return sintetizador;
	}
	public void setSintetizador(String sintetizador) {
		this.sintetizador = sintetizador;
	}
	@Override
	public String toString() {
		String cadena = super.toString();
		return cadena + "Televisor [tamaño=" + tamaño + ", sintetizador=" + sintetizador + "]";
	}
	
	

}
