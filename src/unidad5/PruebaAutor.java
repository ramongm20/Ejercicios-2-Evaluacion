package unidad5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PruebaAutor {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Introduzca el nombre del autor:");
		String nombre = br.readLine();
		
		String email = "";
		while (!isValid(email)) {
			System.out.println("Introduzca su email:");
			email = br.readLine();
		} // while

		String genero = "";
		while (!genero.equals("1") && !genero.equals("2")) {
			System.out.println("Seleccione el género:\n1. masculino\n2. Femenino");
			genero = br.readLine();
		} // while
		genero = Integer.parseInt(genero)==1? "masculino": "femenino";

		Autor autor1 = new Autor(nombre, email, genero);

		System.out.println("Nombre: " + autor1.getNombre());
		System.out.println("Email: " + autor1.getEmail());
		System.out.println("Género: " + autor1.getGenero());

		System.out.println("Introduzca un nuevo email para el autor:");
		autor1.setEmail(br.readLine());

		System.out.println(autor1.toString());

	} // main
	
	static boolean isValid(String email) {
		return email.matches("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
	} // isValid

}
