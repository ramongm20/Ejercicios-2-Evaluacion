package unidad7;

public class Lavadora extends Electrodomestico {
private int carga = CargaLavadora.CINCO.getPeso();

public Lavadora(double precio, double peso, Color color, Consumo consumo, int carga) {
	super(precio, peso, color, consumo);
	this.carga = carga;
	if (carga>8) setPrecioFinal(getPrecioFinal() + (getPrecioFinal()* 0.1));
}

public int getCarga() {
	return carga;
}

public void setCarga(int carga) {
	this.carga = carga;
}

@Override
public String toString() {
	String cadena = super.toString();
	return cadena + "Lavadora [carga=" + carga + "]";
}


}
