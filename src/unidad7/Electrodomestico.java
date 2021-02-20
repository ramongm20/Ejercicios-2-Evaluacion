package unidad7;

public class Electrodomestico {
	private double precioBase = 100;
	private Color color = Color.BLANCO;
	private Consumo consumo = Consumo.F;
	private double peso = 5;
	private double precioFinal;
	
	private static double incrementoPeso(double peso) {
		if (peso<20) return 0.05;
		else if (peso >19 && peso<50) return 0.1;
		else if (peso>49 && peso<80) return 0.15;
		else return 0.2;
	}
	private static double incrementoConsumo(Consumo consumo) {
		if (consumo==Consumo.A) return 0.3;
		else if (consumo==Consumo.B) return 0.25;
		else if (consumo==Consumo.C) return 0.2;
		else if (consumo==Consumo.D) return 0.15;
		else if (consumo==Consumo.E) return 0.1;
		else return 0.05;
	}
	public Electrodomestico(double precio, double peso) {
		this.precioBase = precio;
		this.peso = peso;
		precioFinal = precio+(precio*incrementoPeso(peso))+(precio*incrementoConsumo(consumo));
	}
	public Electrodomestico(double precio, double peso, Color color, Consumo consumo) {
		this(precio, peso);
		this.color = color;
		this.consumo = consumo;
	}
	public double getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Consumo getConsumo() {
		return consumo;
	}
	public void setConsumo(Consumo consumo) {
		this.consumo = consumo;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getPrecioFinal() {
		return precioFinal;
	}
	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}
	@Override
	public String toString() {
		return "Electrodomestico [precioBase=" + precioBase + ", color=" + color + ", consumo=" + consumo + ", peso="
				+ peso + ", precioFinal=" + precioFinal + "]";
	}
	
	
	

}
