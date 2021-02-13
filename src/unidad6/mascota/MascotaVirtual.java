package unidad6.mascota;

import java.util.Random;

public class MascotaVirtual {
	private static Random r = new Random();
	private String nombre;
	private int energia;
	private boolean enferma = false;
	private Estado estado;
	private boolean indiferencia = false;
	private boolean dead = false;
	
	public MascotaVirtual(String nombre) {
		this.nombre = nombre;
		energia = 20;
		estado = Estado.ALEGRIA;
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
/**
 * Ajusta la energía si la mascota no está muerta y pasa mensajes necesarios.
 * @param energia Cantidad de energía que se pierde o se gana.
 * @throws Exception Varias excepciones de otros métodos.
 */
	private void setEnergia(int energia) throws Exception {
		isDead();
		this.energia += energia;
		setEnferma();
		setDead();
	}
	/**
	 * Comprueba si la mascota está muerta y devueleve si está enferma. 
	 * @return 
	 * @throws Exception Pasa la excepción que se manda en isdead()
	 */
	public boolean getEnferma() throws Exception {
		isDead();
		return enferma;
	}
	/**
	 * Pone enferma a la mascoa
	 * @throws Exception Obliga a comprobar si la mascota está enferma
	 */
	public void setEnferma() throws Exception {
		if (!getEnferma()) {
		enferma = energia <5 || energia >50 ? true: false;
		} else throw new Exception("Usa getEnferma() para saber si la mascota está enferma, y en ese caso aplica mortificar() en lugar de la aación solicitada, y avisa de ello.");
		controlIndiferencia();
	}
	/**
	 * Aumenta la energía si la mascota no está enferma o muerta, con una probabilidad del 30% de las veces.
	 * @throws Exception
	 */
	public void comer() throws Exception {
		isDead();
		int congestion = r.nextInt(9)+1;
		if (congestion <4) {
			enferma = true;
			if (energia > 10 && energia <= 50)
				energia = 10;
		} else setEnergia(5);
	}
	
	public void dormir() throws Exception {
		setEnergia(2);
	}
	
	public void ejercicio() throws Exception {
		setEnergia(3);
	}
	
	public void curar() throws Exception {
		if (enferma) {
			energia = 20;
			enferma = false;
		} else throw new Exception("Usa getEnferma() para verificarr si la mascota está enferma antes de curarla. Si está sana avisa de ello.");
	}
	/**
	 * Para esto se utilizan los tipos enumerados.
	 * @return
	 */
	public String getEstado() {
		if (!enferma) {
			if (energia <47 && energia >8)
				estado = Estado.ALEGRIA;
			else if ((energia > 5 && energia <8) || (energia > 47 && energia <50))
				estado = Estado.APATIA;
		} else estado = Estado.MALESTAR;
		indiferencia = false;
		return estado.getOnomatopeya();
	}
	/**
	 * Controla que el cliente se preocupe siempre por el estado de la mascota después de cada acción.
	 * @throws Exception
	 */
	private void controlIndiferencia() throws Exception {
		indiferencia = indiferencia == false ? true: false;
		if (!indiferencia)
			throw new Exception("Se debe consultar el estado después de cada actividad.");
	}
	/**
	 * Mata a la mascota.
	 */
	private void setDead() {
		if (this.energia < 0 || this.energia > 55)
			dead = true;
	}
	public boolean getDead() {
		return dead;
	}
	/**
	 * Obliga a hacer la comprobación en el cliente de la muerte de la mascota.
	 * @throws Exception
	 */
	private void isDead() throws Exception {
		if (dead)
		throw new Exception("Es necesario usar getDead() después de cada acción para saber si la mascota ha muerto y en ese caso eliminarla, y anunciar dicho acontecimiento.");
	}
	/**
	 * Método alternativo para aplicar a la mascota enferma.
	 * @throws Exception
	 */
	public void mortificar() throws Exception {
		isDead();
			if (energia > 50)
				energia += 1;
			else energia -= 1;
			setDead();
	}
}
