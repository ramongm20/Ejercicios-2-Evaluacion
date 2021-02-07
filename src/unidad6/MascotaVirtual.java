package unidad6;

import java.util.Random;

public class MascotaVirtual {
	private static Random r = new Random();
	private String nombre;
	private int energia;
	private boolean enferma = false;
	
	public MascotaVirtual(String nombre) {
		this.nombre = nombre;
		energia = 20;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}
	
	public boolean getEnferma() {
		return enferma;
	}
	
	public void setEnferma() {
		enferma = true;
	}
	
	public String comer() {
		if (!enferma) {
			int congestion = r.nextInt(9)+1;
			if (congestion <4) {
				enferma = true;
				if (energia > 10)
					energia = 10;
			} else energia +=5;
		} else energia--;
		return getEstado();
	}
	
	public String dormir() {
		if (!enferma)
			energia += 2;
		else energia--;
		return getEstado();
	}
	
	public String ejercicio() {
		if (!enferma)
		energia -= 3;
		else energia--;
		return getEstado();
	}
	
	public void curar() throws Exception {
		if (enferma)
			energia = 20;
		else throw new Exception(nombre + " no necesita tratamiento.");
	}
	
	private String getEstado() {
		if (!enferma) {
			if (energia <47 && energia >8)
				return "Alegría";
			else if ((energia > 5 && energia <8) || (energia > 47 && energia <50))
				return "Apatía";
		} else return "Malestar";
		return null;
	}
	
	
}
