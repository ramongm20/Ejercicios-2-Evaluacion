package unidad5;

import java.util.Scanner;

public class PruebaHucha {
static int estado = 0;
static Scanner in = new Scanner(System.in);
static boolean salir = false;
static Hucha miHucha;
	public static void main(String[] args) {
		
		System.out.println("Gestor de huchas");
		while (!salir) {
			menu();
		} // while
	} // main

	static void menu() {
		if (estado ==0) {
			System.out.println("\nEscoja una opción:\n1. Crear hucha\n2. Salir");
			switch (in.nextInt()) {
			case 1:
				System.out.println("¿Cómo desea crear la hucha?\n1. Con una cantidad específica de billetes y monedas\n2. Con una cantidad total en euros");
				switch (in.nextInt()) {
				case 1:
					int [] cantidades = cantidadEspecifica();
					miHucha = new Hucha(cantidades[0], cantidades[1], cantidades[2], cantidades[3], cantidades[4], cantidades[5]);
					System.out.println("Ha llenado la hucha con " + miHucha.getTotal() + "€.");
					primeraContrasenia();
					break;
				case 2:
					System.out.print("Introduzca la cantidad con la que desea iniciar la hucha: ");
					int cantidad = controlDinero();
					if (cantidad > 0)
						miHucha = new Hucha(cantidad);
					else miHucha = new Hucha();
					System.out.println("Ha llenado la hucha con " + miHucha.getTotal() + "€.");
					primeraContrasenia();
					break;
				default: System.out.println("Escoja número entre 1 y 2.");
				} // switch
				break;
			case 2:
				salir = preguntaSalida();
				break;
			default: System.out.println("Escoja número entre 1 y 2.");
			} // switch
		} else if (estado == 1) {
			System.out.println("\nEscoja una opción:\n1. Consultar estado\n2. Ingresar dinero\n3. Retirar dinero\n4. Cambiar contraseña\n5. Salir");
			switch (in.nextInt()) {
			case 1:
				controlCerradura();
				System.out.println(miHucha.toString());
				miHucha.setCerradura();
				break;
			case 2:
				System.out.println("La hucha solo admite una moneda o billete de cada vez. Escriba el valor unitario de la moneda o billete que desea ingresar:");
				int ingreso = in.nextInt();
				while (ingreso != 50 && ingreso != 20 && ingreso != 10 && ingreso != 5 && ingreso != 2 && ingreso != 1) {
					System.out.println("Solo se admiten billetes de 50, 20, 10 y 5€, o mendas de 1 y 2€.");
					ingreso = in.nextInt();
				} // while
				miHucha.setIngreso(ingreso);
				if (ingreso > 2)
					System.out.println("Ha ingresado un billete de " + ingreso + "€ en la hucha.");
				else System.out.println("Ha ingresado unamoneda de " + ingreso + "€ en la hucha.");
				System.out.println("Ahora dispone de un total de " + miHucha.getTotal() + "€ en la hucha.");
				break;
			case 3:
				if (miHucha.getTotal() == 0)
					System.out.println("La hucha está vacía. Deberá ingresar algún dinero antes de poder hacer retiradas.");
				else {
					System.out.println("\n¿Cómo desea retirar su dinero?\n1. Escojiendo la cantidad específica de billetes y monedas\n2. Escogiendo el monto total en euros");
					switch (in.nextInt()) {
					case 1:
						controlCerradura();
						System.out.println(miHucha.setRetirada(cantidadEspecifica()));
						miHucha.setCerradura();
						break;
					case 2:
						controlCerradura();
						System.out.println("Introduzca el monto a retirar:");
						System.out.println(miHucha.setRetirada(controlDinero()));
						miHucha.setCerradura();
						break;
					default: System.out.println("Escoja número entre 1 y 2.");
					} // switch
				} // else
				break;
			case 4:
				controlCerradura();
				System.out.println("Escriba la nueva contraseña:");
				miHucha.setContrasenia(in.nextLine());
				System.out.println("La contraseña se ha cambiado correctamente.");
				miHucha.setCerradura();
				break;
			case 5:
				salir = preguntaSalida();
				break;
			default: System.out.println("Escoja número entre 1 y 5.");
			} // switch
			
		}
	} // menu

	static boolean preguntaSalida() {
		in.nextLine();
		if (!(miHucha == null) && miHucha.getTotal() > 0) {
			System.out.println("La hucha tiene fondos que se perderán si sale ahora. Esta acción es irreversible. ¿Salir (s/n)?");
			if (in.next().charAt(0) == 115) {
				System.out.println("Gracias por utilizar el gestor de huchas.");
				return true;
			} else return false;
		} else {
			System.out.println("Gracias por utilizar el gestor de huchas.");
			return true;
		} // else
	}
	
	static void controlCerradura() {
		in.nextLine();
		while (!miHucha.getCerradura()) {
			System.out.println("Introduzca la contraseña de la hucha:");
			miHucha.setCerradura(in.nextLine());
		} // while
	} // controlCerradura

	static int [] cantidadEspecifica() {
		int [] euros = new int [6];
		System.out.print("¿Cuántos billetes de 50€? ");
		euros[0] = controlDinero();
		System.out.print("¿Cuántos billetes de 20€? ");
		euros[1] = controlDinero();
		System.out.print("¿Cuántos billetes de 10€? ");
		euros[2] = controlDinero();
		System.out.print("¿Cuántos billetes de 5€? ");
		euros[3] = controlDinero();
		System.out.print("¿Cuántas monedas de 2€? ");
		euros[4] = controlDinero();
		System.out.print("¿Cuántas monedas de 1€? ");
		euros[5] = controlDinero();
		return euros;
	} // cantidadEspecifica

	static void primeraContrasenia() {
		in.nextLine();
		estado = 1;
		System.out.println("La hucha ha sido creada con éxito. Escriba una contraseña para protegerla:");
		miHucha.setContrasenia(in.nextLine());
		System.out.println("Ahora la hucha está cerrada, lo que significa que solo podrá ingresar billetes o monedas. Para consultar el saldo o retirar fondos deberá abrir la hucha con la contraseña que acaba de proporcionar.");
	} // primeraContrasenia

	static int controlDinero() {
		int dinero = in.nextInt();
		while (dinero <0) {
			System.out.println("La cantidad debe ser igual o mayor que 0.");
			dinero = in.nextInt();
		} // while
			return dinero;
	} // controlDinero
}
