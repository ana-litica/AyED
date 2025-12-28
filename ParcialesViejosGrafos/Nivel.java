package ParcialesViejosGrafos;

public class Nivel {
	private int amigos;
	private boolean esPopular;
	
	public Nivel (int amigos) {
		this.amigos=amigos;
	}
	
	public void setPopularidad(boolean pop) {
		this.esPopular=pop;
	}
	
	public String toString() {
		return "("+this.amigos+", "+this.esPopular+")"; 
	}
}
