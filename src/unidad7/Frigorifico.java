package unidad7;

public class Frigorifico extends Electrodomestico {
private boolean noFrost = false;

public Frigorifico(double precio, double peso, Color color, Consumo consumo, boolean noFrost) {
	super(precio, peso, color, consumo);
	this.noFrost = noFrost;
}

public boolean isNoFrost() {
	return noFrost;
}

public void setNoFrost(boolean noFrost) {
	this.noFrost = noFrost;
}

@Override
public String toString() {
	String cadena = super.toString();
	return cadena + "Frigorifico [noFrost=" + noFrost + "]";
}



}
