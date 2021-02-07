package unidad5;

public class Hucha {
	private int [][] euros = {{50, 0}, {20, 0}, {10, 0}, {5, 0}, {2, 0}, {1, 0}};
	private boolean cerradura = false;
	private String contrasenia = "";

	public Hucha() {
	} // Constructor hucha vacía

	public Hucha(int b50, int b20, int b10, int b5, int m2, int m1) {
		euros[0][1] = b50;
		euros[1][1] = b20;
		euros[2][1] = b10;
		euros[3][1] = b5;
		euros[4][1] = m2;
		euros[5][1] = m1;
	} // Constructor hucha personalizada

	public Hucha (int euros) {
		int i = 0;
		do {
			this.euros[i][1] = euros / this.euros[i][0];
			euros -= this.euros[i][0] * this.euros[i][1];
			i++;
		} while (euros>0);
	} // Constructor hucha para desglosar

	public boolean getCerradura() {
		return cerradura;
	} // getCerradura
	
	public int getTotal() {
		int total = 0;
		for (int i=0; i<6; i++)
			total += euros[i][0]*euros[i][1];
		return total;
	} // calculaTotal
	
	public void setCerradura(String llave) {
		if (llave.equals(contrasenia))
			cerradura = true;
	} // setCerradura
	
	public void setCerradura() {
		cerradura = false;
	} // setCerradura
	
	public void setIngreso(int ingreso) {
		ingreso = ingreso == 50? 0:ingreso;
		ingreso = ingreso == 20? 1:ingreso;
		ingreso = ingreso == 10? 2:ingreso;
		ingreso = ingreso == 5? 3:ingreso;
		ingreso = ingreso == 2? 4:5;
		euros[ingreso][1]++;
	} // setIngreso
	
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	} // setContrasenia
	
	public String toString() {
		String cabecera = String.format("\n%-5s%-7s%-5s\n", "Valor", "Cantidad", "Total");
		StringBuilder tabla = new StringBuilder(cabecera);
		for (int i=0; i<6; i++) {
			if (euros[i][0]>2 && euros[i][1]>0)
				tabla.append(String.format("%-5s%-12s%-10s\n", (euros[i][0]+"€"), (euros[i][1]+" billetes"), ((euros[i][0]*euros[i][1])+"€")));
			else if (euros[i][0] <= 2 && euros[i][1]>0)
				tabla.append(String.format("%-5s%-12s%-10s\n", (euros[i][0]+"€"), (euros[i][1]+" monedas"), ((euros[i][0]*euros[i][1])+"€")));
		} // for
		
		tabla.append("\nEn la hucha hay un total de " + getTotal() + "€.");
		
		return tabla.toString();
	} // toString

	public String setRetirada(int [] cantidades) {
		StringBuilder cadena = new StringBuilder("\nSe han podido retirar:");
		int contador = 0;
		for (int i=0; i<6; i++) {
			if (euros[i][1] > 0 && euros[i][1] <= cantidades[i]) {
				if (euros[i][0] > 2)
					cadena.append("\n- " + euros[i][1] + " billetes de " + euros[i][0] + "€.");
				else cadena.append("\n- " + euros[i][1] + " monedas de " + euros[i][0] + "€.");
				euros[i][1] -= euros[i][1];
				contador++;
			} else if (cantidades[i] > 0 && euros[i][1] > cantidades[i]) {
				if (euros[i][0] > 2)
					cadena.append("\n- " + cantidades[i] + " billetes de " + euros[i][0] + "€.");
				else cadena.append("\n- " + cantidades[i] + " monedas de " + euros[i][0] + "€.");
				euros[i][1] -= cantidades[i];
				contador++;
			} // else if
		} // for
		cadena.append("\nQuedan " + getTotal() + "€ en la hucha.");
		return contador>0? cadena.toString(): "No se ha podido retirar la cantidad especificada.";
	} // setRetirada

	public String setRetirada(int cantidad) {
		StringBuilder cadena = new StringBuilder("\nSe han retirado:");
		if (cantidad >= getTotal())
			return "Se ha vaciado la hucha";
		else {
			int contador = 0;
			for (int i=0; i<6; i++) {
				while (cantidad >= euros[i][0] && euros[i][1] > 0) {
					euros[i][1]--;
					cantidad -= euros[i][0];
					contador++;
				} // while
				if (euros[i][0] > 2 && contador > 0)
					cadena.append("\n- " + contador + " billetes de " + euros[i][0] + "€.");
				else if (euros[i][0] < 5 && contador > 0)
					cadena.append("\n- " + contador + " monedas de " + euros[i][0] + "€.");
				contador = 0;
		} // for
			cadena.append("\nQuedan " + getTotal() + "€ en la hucha.");
			return cadena.toString();
		}
	} // setRetirada
}
