package TP2;

public class Operaciones {
	private int suma,diferencia;
	
	public Operaciones(int suma, int diferencia) {
		this.suma=suma;
		this.diferencia=diferencia;
	}

	public void setSuma(int suma) {
		this.suma=suma;
	}
	
	public void setDiferencia(int diferencia) {
		this.diferencia=diferencia;
	}
	
	@Override
	public String toString() {
		return this.suma+" | "+this.diferencia;
	}
	
}
