package unidad7;

public class Asalariado extends Empleado{

	private double salario;

	public Asalariado(String nombre, String apellidos, String fecha, String cuenta, double salario) {
		super(nombre, apellidos, fecha, cuenta);
		this.salario = salario;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Asalariado [salario=" + salario + ", toString()=" + super.toString() + "]";
	}

	@Override
	public void realizarPago(double cantidad) {
		System.out.println("Realizando pago de " + cantidad + "€ a " + getNombre() + " en calidad de asalariado");
	}
	
}
