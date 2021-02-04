package unidad6.excepciones;

import java.util.Scanner;

public class Ecuacion {

	public static double [] resolver(double a, double b, double c) throws IllegalArgumentException, ArithmeticException {
		if (a == 0)
			throw new IllegalArgumentException("No es una ecuación de segundo grado.");
		else if ((b*b)-(4*a*c) < 0)
			throw new ArithmeticException("La ecuación no tiene una solución real.");
		double [] solucion = {
			(-b + Math.sqrt((b*b)-(4*a*c)))/(2*a),
			(-b - Math.sqrt((b*b)-(4*a*c)))/(2*a)
		};
		return solucion;
	} // cierra resolver
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Introduzca los coeficientes 'a', 'b' y 'c' de una ecuación de segundo grado, separados por un espacio.");
		double[] soluciones;
		try {
			soluciones = resolver(in.nextDouble(), in.nextDouble(), in.nextDouble());
			System.out.println("x1 = " + soluciones[0]);
			System.out.println("x2 = " + soluciones[1]);
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		} catch (ArithmeticException ae) {
			System.out.println(ae.getMessage());
		}
	}
}
