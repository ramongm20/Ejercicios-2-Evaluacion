package unidad5;

/**
 * Naipe.java
 * @author Ramón García
 *
 */
public class Naipe implements Cloneable, Comparable<Naipe> {
	private static String [] palos = {"tréboles", "diamantes", "corazones", "picas"};
	private static String [] rangos = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
	private static int [] valorRangos = new int [13];
private String palo = "";
private String rango = "";
private int valor = 0;
/**
 * Constructor de naipes
 * @param palo Número de índice del array de palos de la baraja
 * @param rango Índice del array de rangos de la baraja
 */
public Naipe(int palo, int rango) {
	this.palo = palos[palo];
	this.rango = rangos[rango];
	valor = valorRangos[rango];
} // constructor
/**
 * Obtiene el valor de un naipe establecido por el juego a su rango
 * @return Entero con el valor
 */
public int getValor() {
	return valor;
} // getValor
/**
 * Asigna el valor establecido por el juego a cada rango
 * @param valores Array de valores de cada rango
 */
public static void setValorRangos(int [] valores) {
	valorRangos = valores;
} // setValorRangos
/**
 * Define qué información imprimir de un naipe 
 */
@Override
public String toString() {
	return rango + " de " + palo;
} // toString
/**
 * Hace que un naipe se pueda clonar para evitar el problema de usar referencias
 */
public Object clone() {
	Object clone = null;
	try {
		clone = super.clone();
	} catch(CloneNotSupportedException e)
	{ System.out.println("No se soporta la clonación.");
	} // catch
	return clone;
} // clone
/**
 * Hace posible comparar dos naipes por el valor de su rango
 */
public int compareTo(Naipe n) {
	if (valor<n.valor) return -1;
	else if (valor==n.valor) return 0;
	else return 1;
} // compareTo
}
