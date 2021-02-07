package unidad5;

import java.util.Collection;
import java.util.Iterator;

public class Libro {
	private String titulo = "";
	private Collection<Autor> autores;
	private float precio = 0.0f;
	private int stock = 0;
	
	public Libro(String titulo, Collection<Autor> autores, float precio) {
		this.titulo = titulo;
		this.autores = autores;
		this.precio = precio;
	} // constructor
	
	public Libro(String titulo, Collection<Autor> autores, float precio, int stock) {
		this.titulo = titulo;
		this.autores = autores;
		this.precio = precio;
		this.stock = stock;
	} // constructor
	
	public String getTitulo() {
		return titulo;
	} // getTitulo
	
	public Collection<Autor> getAutores() {
		return autores;
	} // getAutores
	
	public float getPrecio() {
		return precio;
	} // getPrecio
	
	public int getStock() {
		return stock;
	} // getStock
	
	public void setPrecio(float precio) {
		this.precio = precio;
	} // setPrecio
	
	public void setStock(int stock) {
		this.stock = stock;
	} // setStock
	
	public String toString() {
		StringBuilder cadena = new StringBuilder(titulo + " (");
		Iterator<Autor> it = autores.iterator();
		while (it.hasNext())
			cadena.append(it.next().getNombre() + ", ");
		cadena.delete(cadena.length()-2, cadena.length());
		
		cadena.append(") " + precio + " €" + " - " + stock + " unidades en stock");
		return cadena.toString();
	} // toString
	
}
