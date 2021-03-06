package unidad7;

import java.util.ArrayList;

public class Biblioteca {

	public static void main(String[] args) {
ArrayList<Publicación> publicaciones = new ArrayList<>(); // publicaciones es una estructura de datos polimórfica porque admite almacenar tanto objetos de tipo Libro, como objetos de tipo Revista, que son subclases de Publicación.

		publicaciones.add(new Libro("El Quijote", 1605, "Cervantes"));
		publicaciones.add(new Revista("x", 1, 1, 2021, 100));
		publicaciones.add(new Revista("Enigma", 1, 1, 2021, 100));
		publicaciones.add(new Libro("El buscón", 1603, "Quevedo"));
		
		for (Publicación p: publicaciones) // p está referenciando a un objeto de tipo Publicación en tiempo de compilación, pero en tiempo de ejecución referenciará a los tipos de sus subclases.
			System.out.println(p); // Las subclases de Publicación tienen definido el método toString, por lo que este método imprime por la salida del sistema la información especificada en la clase correspondiente al objeto en que cada caso haga referencia p.
		
		
		System.out.println("Libros prestados:");
		for (Publicación p: publicaciones) {
			if (p instanceof Libro) {
				((Libro) p).prestarPublicación(); // Debido a la característica polimórfica del contenedor, no todos los objetos que almacena son del mismo tipo, así que nos aseguramos de que el objeto referenciado en tiempo de ejecución es del tipo que implementa la interfaz prestable y por lo tanto tiene definido el método prestarPublicación.
				System.out.println(p);
			}
		}
	}

}
