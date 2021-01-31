package unidad6.excepciones;

public class Ejercicio5 {
	StringBuilder cadena = new StringBuilder("a"); 
	 
	void metodoA() { 
	try { 
	cadena.append("b"); 
	metodoB(); 
	} catch (Exception e) { 
	cadena.append("c"); 
	} 
	} 
	 
	void metodoB() throws Exception { 
	try { 
	cadena.append("d"); 
	metodoC(); 
	} catch (Exception e) { 
	throw new Exception(); 
	} finally { 
	cadena.append("e"); 
	} 
	cadena.append("f"); 
	 
	} 
	 
	void metodoC() throws Exception { 
	throw new Exception(); 
	} 
	 
	String getCadena() { 
	return cadena.toString(); 
	} 
	 
	public static void main(String[] args) { 
	Ejercicio5 e = new Ejercicio5(); 
	e.metodoA(); 
	System.out.println(e.getCadena()); 
	} 
	 
	} 
