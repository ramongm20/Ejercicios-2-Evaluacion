package fp.daw.naipes;

public enum Palo {
	PICAS('\u2660'), CORAZONES('\u2665'), TREBOLES('\u2663'), DIAMANTES('\u2666');
	
	private char simbolo;
	
	private Palo(char simbolo) {
		this.simbolo = simbolo;
	}

	@Override
	public String toString() {
		return String.valueOf(simbolo);
	}
}
