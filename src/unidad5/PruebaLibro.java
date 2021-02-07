package unidad5;

import java.util.ArrayList;
import java.util.Collection;

public class PruebaLibro {

	public static void main(String[] args) {
		Autor autor1 = new Autor("Pedro Rosales", "rosales-pedro@correo.es", "masculino");
		Autor autor2 = new Autor("Felisa Rubio", "felisarumar@correo.es", "femenino");
		Autor autor3 = new Autor("Claudia Montes", "clamon@correo.es", "femenino");
		Autor autor4 = new Autor("Felipe Suárez", "felipesu@correo.es", "masculino");
		
		Collection<Autor> autoresLibro1 = new ArrayList<Autor>();
		Collection<Autor> autoresLibro2 = new ArrayList<Autor>();
		autoresLibro1.add(autor1);
		autoresLibro1.add(autor2);
		autoresLibro2.add(autor3);
		autoresLibro2.add(autor4);
		
		Libro libro1 = new Libro("Felicidad: una aproximación", autoresLibro1, 20.90f);
		Libro libro2 = new Libro("Java para niños", autoresLibro2, 19.90f, 5);
		
		System.out.println("Título: " + libro1.getTitulo());
		System.out.println("Datos de los autores: " + libro1.getAutores().toString());
		System.out.println("Precio: " + libro1.getPrecio());
		System.out.println("Stock: " + libro1.getStock());
		
		libro1.setPrecio(19.5f);
		libro1.setStock(10);
		
		System.out.println(libro1.toString());
		
		

	}

}
