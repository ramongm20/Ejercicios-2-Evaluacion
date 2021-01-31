package unidad6.excepciones;

import java.io.FileInputStream; 
import java.util.Scanner; 
 
public class Ejercicio2 { 
 
Ejercicio2 e = new Ejercicio2(); 
 
public static void main(String[] args) { 
Scanner in = new Scanner(System.in); 
String opcion; 
while (!(opcion = in.next()).equalsIgnoreCase("fin")) {
	try {
lanzarExcepcion(Integer.parseInt(opcion));
	} catch(RuntimeException re) {
		System.out.println("Unchecked: "+ re);
	} catch (Exception ex) {
		System.out.println("Checked: " + ex);
	}
} // cierra while
in.close(); 
} 
 
static void lanzarExcepcion(int opcion) throws Exception { 
switch (opcion) { 
case 1: 
System.out.println(1 / 0); 
break; 
case 2: 
int [] a = new int[10]; 
a[a.length] = a.length; 
break; 
case 3: 
FileInputStream in = new FileInputStream("este fichero no existe"); 
break; 
case 4: 
Object o = null; 
System.out.println(o.toString()); 
break; 
case 5: 
Ejercicio2 e = new Ejercicio2(); 
break; 
default: 
Class.forName("UnaClase"); 
} 
}
}