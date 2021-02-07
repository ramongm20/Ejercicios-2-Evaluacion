package unidad5;

public class Autor {
private String nombre = "";
private String email = "";
private String genero = "";

public Autor(String nombre, String email, String genero) {
	this.nombre = nombre;
	this.email = email;
	this.genero = genero;
} // constructor

public String getNombre() {
	return nombre;
} // getNombre

public String getEmail() {
	return email;
} // getEmail

public String getGenero() {
	return genero;
} // getGenero

public void setEmail(String email) {
	this.email = email;
} // setEmail

public String toString() {
	return nombre + " (" + genero + ") " + email;
} // toString
}
