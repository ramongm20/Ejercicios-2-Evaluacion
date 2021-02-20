package unidad7;

public enum CargaLavadora {
	CUATRO(4), CINCO(5), SEIS(6), SIETE(7), OCHO(8), DIEZ(10), ONCE(11), TRECE(13);

private int peso;

private CargaLavadora(int peso) {
	this.peso = peso;
}

public int getPeso() {
	return peso;
}


}