package P5;

public class Persona {
	private String nombre,domicilio;
	private boolean esJubilado;
	
	public Persona(String nombre,String domicilio,boolean jubilado) {
		this.nombre=nombre;
		this.domicilio=domicilio;
		this.esJubilado=jubilado;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public boolean isJubilado() {
		return esJubilado;
	}
	
	public String toString() {
		return this.getNombre();
	}
	
}
