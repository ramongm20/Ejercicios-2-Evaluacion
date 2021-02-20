package unidad7;

public enum Sintetizador {
UNO("DVB-T"), DOS("DVB-T2");

	private String tipo;
private Sintetizador(String tipo) {
}
public String getTipo() {
	return tipo;
}
}
