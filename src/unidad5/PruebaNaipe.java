package unidad5;


public class PruebaNaipe {
public static void main(String[] args) {
	Mazo mazo = new Mazo();

	mazo.ordenar();
	for (int i=0; i<mazo.size(); i++)
		System.out.println(mazo.get(i).toString());
}
}
