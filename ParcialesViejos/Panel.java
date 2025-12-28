package ParcialesViejos;

public class Panel {
	private boolean estado;
	private String identificador;
	
	public Panel(boolean estado, String identificador) {
		this.estado = estado;
		this.identificador = identificador;
	}

	public boolean isEstado() {
		return estado;
	}

	public String getIdentificador() {
		return identificador;
	}

	
}
