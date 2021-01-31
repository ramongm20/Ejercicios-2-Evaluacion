package unidad6.excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Triangulo {
private int a = 0;
private int b = 0;

public int getA() {
	return a;
}

public void setA(int a) {
	this.a = a;
}

public int getB() {
	return b;
}

public void setB(int b) {
	this.b = b;
}

public double getC() {
	return Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)));
} // cierra getC

public static Scanner in = new Scanner(System.in);
public static void main(String[] args) {
	Triangulo t = new Triangulo();
	boolean salir = false;
	while (!salir) {
		System.out.print("> ");
		switch (in.next()) {
		case "A":
				t.setA(checkIn());
			break;
		case "B":
			t.setB(checkIn());
			break;
		case "C":
			in.nextLine();
			if (t.getA() < 1)
				System.out.println("Falta la medida del cateto A.");
			else if (t.getB() < 1)
				System.out.println("Falta la medida del cateto B.");
			else {
				System.out.println(t.getC());
				t.setA(0);
				t.setB(0);
			}
			break;
		case "F":
			salir = true;
			break;
			default:
				System.out.println("Introduzca un comando válido.");
		} // cierra switch
	} // cierra while
} // cierra main

public static int checkIn() {
	try {
		int cm = in.nextInt();
		if (cm > 0)
		return cm;
		else throw new InputMismatchException();
	} catch (InputMismatchException imme) {
		System.out.println("La medida del cateto debe ser un entero mayor que 0.");
		in.nextLine();
	}
	return 0;
} // cierra checkIn
}
