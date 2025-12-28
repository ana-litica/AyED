package ParcialesViejosGrafos;

public class Usuario {
	private String nombre;
	private int distancia;
	
	public Usuario(String nombre, int distancia) {
		this.nombre=nombre;
		this.distancia=distancia;
	}
	
	public String toString() {
		return "("+this.nombre+", "+ this.distancia+")";
	}
}
