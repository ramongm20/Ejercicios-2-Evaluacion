package unidad6.excepciones;

public class Ejercicio4 {
	 
	public static void main(String[] args) { 
	try { 
	System.out.println("Antes de metodoA"); 
	metodoA(); 
	System.out.println("Despues de metodoA"); 
	} catch (Exception e) { 
	System.out.println("main: " + e); 
	} finally { 
	System.out.println("main: finally"); 
	} 
	} 
	 
	public static void metodoA() { 
	try { 
	System.out.println("Antes de metodoB"); 
	metodoB(); 
	System.out.println("Despues de metodoB"); 
	} catch (Exception e) { 
	System.out.println("metodoA: " + e); 
	} finally { 
	System.out.println("metodoA: finally"); 
	} 
	}
	 
	public static void metodoB() { 
	try { 
	System.out.println("Antes de metodoC"); 
	metodoC(); 
	System.out.println("Despues de metodoC"); 
	} catch (ArrayIndexOutOfBoundsException e) { 
	System.out.println("metodoB: " + e); 
	} finally { 
	System.out.println("metodoB: finally"); 
	} 
	}
	 
	public static void metodoC() { 
	try { 
	System.out.println("Antes de metodoD"); 
	metodoD(); 
	System.out.println("Despues de metodoD"); 
	} catch (NumberFormatException e) { 
	System.out.println("metodoC: " + e); 
	} finally { 
	System.out.println("metodoC: finally"); 
	} 
	}
	
	public static void metodoD() { 
	try { 
	int a[] = new int[4]; 
	a[a.length] = a.length; 
	} catch (ClassCastException e) { 
	System.out.println("metodoD: " + e); 
	} finally { 
	System.out.println("metodoD: finally"); 
	} 
	}
	 
}
