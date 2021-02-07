package unidad5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
/**
 * @author Ramón García
 */
public class Mazo {
	private static Random r = new Random();
private ArrayList<Naipe> mazo = new ArrayList<Naipe>();
/**
 * Constructor para un mazo con las 52 cartas de la baraja inglesa
 */
public Mazo() {
	for (int palo=0; palo<4; palo++) {
		for (int rango=0; rango<13; rango++)
			mazo.add(new Naipe(palo, rango));
	} // for
} // Constructor sin parámetros
/**
 * Constructor para mazo vacío o varios mazos
 * @param n Número de mazos. Si es menor que 1, no añade cartas al mazo.
 */
public Mazo(int n) {
	if (n >= 1) {
		for (int i=0; i<n; i++) {
			for (int palo=0; palo<4; palo++) {
				for (int rango=0; rango<13; rango++)
					mazo.add(new Naipe(palo, rango));
			} // for palo
		} // for i
	} // if
} // Constructor n
/**
 * Toma una carta aleatoria del mazo
 * @return Carta aleatoria sin retirarla del mazo
 */
public Naipe get() {
	return mazo.get(r.nextInt(mazo.size()));
} // get
/**
 * Toma una carta concreta del mazo
 * @param numNaipe Número de la posición de la carta en el ArrayList
 * @return Carta especificada sin eliminarla del mazo
 */
public Naipe get(int numNaipe) {
	return mazo.get(numNaipe);
} // get

/**
 * Método para buscar la carta más alta o más baja del mazo
 * @param comparador 1 para la carta más alta y -1, para la más baja
 * @return La carta escogida
 */
	public Naipe getMaxMin(int comparador) {
		int candidata = 0;
		for (int i=1; i<mazo.size(); i++) {
			if (mazo.get(i).compareTo(mazo.get(candidata)) == comparador)
				candidata = i;
		} // for i
		Naipe carta = (Naipe) mazo.get(candidata).clone();
	mazo.remove(candidata);
	return carta;
		} // getMaxMin
	/**
	 * Encuentra la carta superior, igual o mínima del mazo
	 * 
	 * @param carta Contra la que se compara
	 * @return Carta superior si la hay, la más baja posible, si no, la que sea igual en valor, y si no, la mínima del mazo
	 */
public Naipe getCartaSuperior(Naipe carta) {
	int iSuperior = -1;
	int iIgual = -1;
	for (int i=0; i<mazo.size(); i++) {
		if (carta.compareTo(mazo.get(i)) == 0)
			iIgual = i;
		else if (carta.compareTo(mazo.get(i)) == -1) {
			if (iSuperior == -1)
				iSuperior = i;
			else if (iSuperior != -1 && mazo.get(i).compareTo(mazo.get(iSuperior)) == -1)
				iSuperior = i;
		}
	} // for i
	if (iSuperior != -1) {
		Naipe cSuperior = (Naipe) mazo.get(iSuperior).clone();
		mazo.remove(iSuperior);
		return cSuperior;
	} else if (iIgual != -1) {
		Naipe cIgual = (Naipe) mazo.get(iIgual).clone();
		mazo.remove(iIgual);
		return cIgual;
	} else return getMaxMin(-1);
} // getCartaSuperior
/**
 * Elimina un naipe aleatorio del mazo
 * 
 * @return Naipe eliminado
 */
public Naipe remove() {
	int numNaipe = r.nextInt(mazo.size());
	Naipe naipeAleatorio = (Naipe) mazo.get(numNaipe).clone();
	mazo.remove(numNaipe);
	return naipeAleatorio;
} // remove
/**
 * Elimina un naipe específico
 * @param numNaipe Posición del naipe a eliminar en el ArrayList
 * @return Naipe eliminado
 */
public Naipe remove(int numNaipe) {
	Naipe naipe = (Naipe) mazo.get(numNaipe).clone();
	mazo.remove(numNaipe);
	return naipe;
} // remove
/**
 * Obtiene la cantidad de cartas en el mazo
 * @return Cantidad de cartas en el mazo
 */
public int size() {
	return mazo.size();
} // size
/**
 * Añade un naipe al mazo
 * @param nuevoNaipe Naipe a introducir en el mazo
 */
public void add(Naipe nuevoNaipe) {
	mazo.add(nuevoNaipe);
} // add
/**
 * Añade una colección de naipes al mazo
 * @param naipes Colección de naipes para añadir
 */
public void addAll(Collection<Naipe> naipes) {
	Iterator<Naipe> it = naipes.iterator();
	while (it.hasNext())
		mazo.add(it.next());
} // addAll

}
