package unidad5;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Animal {
	private String nombre;
	private LocalDate fecha;
	
	public Animal(String nombre, LocalDate fecha) {
		this.nombre = nombre;
		this.fecha = fecha;
	}
	public Animal(String nombre) {
		this.nombre = nombre;
		this.fecha = LocalDate.now();
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getFecha() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return formato.format(fecha);
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String toString() {
		Period edad = Period.between(fecha, LocalDate.now());
		if (edad.getYears()== 0)
			return nombre + " acaba de nacer.";
		else return "Nombre: " + nombre + " – Edad: " + edad.getYears() + " años.";
	}
}
