package unidad6.excepciones;

public class Ejercicio1 {

	public static void main(String[] args) {
String [] n = {"3", "tres", "3.0", "3,0", "-3"};
for (int i=0; i<n.length; i++) {
	if (isInt(n[i]))
		System.out.println(n[i] + " representa a un entero.");
	else System.out.println(n[i] + " no se puede convertir a un entero.");
	if (isDouble(n[i]))
		System.out.println(n[i] + " representa a un double.");
	else System.out.println(n[i] + " no se puede convertir a double.");
} // cierra for
	} // cierra main

	public static boolean isInt(String n) {
		try {
			Integer.parseInt(n);
			return true;
		} catch(NumberFormatException ex) {
			return false;
		} // cierra catch
	} // cierra isInt

public static boolean isDouble(String n) {
	try {
		Double.parseDouble(n);
		return true;
	} catch (NumberFormatException ex) {
		return false;
	} // cierra catch
} // isDouble
}
