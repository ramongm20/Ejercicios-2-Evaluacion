package unidad6.mascota;
public enum Estado {
	ALEGRIA("Yuuuujuu"), APATIA("Pff"), MALESTAR("Puagg");
	private String onomatopeya;
	
	private Estado(String onomatopeya) {
		this.onomatopeya = onomatopeya;
	}
public String getOnomatopeya() {
	return onomatopeya;
}
	
}
