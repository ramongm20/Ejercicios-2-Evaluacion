package unidad5;

import java.time.LocalDate;

public class PruebaAnimal {

	public static void main(String[] args) {
		Animal perro = new Animal("Bobo", LocalDate.of(2000, 3, 2));
		Animal gato = new Animal("Chess");
		System.out.println(perro.getNombre() + " nació el " + perro.getFecha());
		System.out.println(gato.getFecha() + " es la fecha de nacimiento de " + gato.getNombre() + ".");
		gato.setFecha(LocalDate.of(2011, 1, 30));
		perro.setFecha(LocalDate.now());
		perro.setNombre("Golfo");
		gato.setNombre("Cheers");
		System.out.println(perro.toString());
		System.out.println(gato.toString());
	}

}
