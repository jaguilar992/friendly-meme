package proceso;

public class Proceso {
	private int id;
	private int prioridad;
	private int nInst; // Total de instrucciones
	private int nInstBloqueo; // Instrucción donde ocurre el bloqueo
	private int tipoBloqueo;
	private int estado;
	
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public static final int BLOQUEO_ES = 3;
	public static final int BLOQUEO_DISK = 5;
	
	public static final int CICLOS_ES = 13;
	public static final int CICLOS_DISK = 27;
	
	public static final int NUEVO = 0;
	public static final int LISTO= 1;
	public static final int EJECUTANDO = 2;
	public static final int BLOQUEADO = 3;
	public static final int SALIENTE = 4;
	// CAMPOS LOGICOS, ESTADO
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	public int getnInst() {
		return nInst;
	}
	public void setnInst(int nInst) {
		this.nInst = nInst;
	}
	public int getnInstBloqueo() {
		return nInstBloqueo;
	}
	public void setnInstBloqueo(int nInstBloqueo) {
		this.nInstBloqueo = nInstBloqueo;
	}
	public int getTipoBloqueo() {
		return tipoBloqueo;
	}
	public void setTipoBloqueo(int tipoBloqueo) {
		this.tipoBloqueo = tipoBloqueo;
	}
	@Override
	public String toString() {
		return "Proceso {\n\tid:" + id 
				+ ",\n\testado:" + estado 
				+ ",\n\tprioridad:" + prioridad 
				+ ",\n\tinstrucciones:" + nInst 
				+ ",\n\tbloqueo:" + nInstBloqueo
				+ ",\n\ttipo:" + tipoBloqueo + "\n}";
	}
	
	
}
