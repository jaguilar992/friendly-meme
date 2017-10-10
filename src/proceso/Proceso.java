package proceso;

public class Proceso {
	private int id;
	private int prioridad;
	private int nInst; // Total de instrucciones
	private int nInstBloqueo; // Instrucción donde ocurre el bloqueo
	private int tipoBloqueo;
	private int estado;
	
	private int c_inst = 0;
	private int c_bloqueo = 0;
	
	public static final int BLOQUEO_ES = 3;
	public static final int BLOQUEO_DISK = 5;
	
	public static final int CICLOS_ES = 13;
	public static final int CICLOS_DISK = 27;
	
	public static final int NUEVO = 0;
	public static final int LISTO= 1;
	public static final int EJECUTANDO = 2;
	public static final int BLOQUEADO = 3;
	public static final int SALIENTE = 4;
	
	public int getEstado() {
		return estado;
	}
	
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
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
	
	public int getc_inst() {
		return this.c_inst;
	}
	
	public int getc_bloqueo() {
		return this.c_bloqueo;
	}
	
	public void plusc_inst() {
		this.c_inst++;
	}
	
	public void plusc_bloqueo() {
		this.c_bloqueo++;
	}
	
	@Override
	public String toString() {
		return "Proceso {id:" + id 
				+ ", estado:" + estado 
				+ ", prioridad:" + prioridad 
				+ ", instrucciones:" + nInst 
				+ ", bloqueo:" + nInstBloqueo
				+ ", tipo:" + tipoBloqueo + "}";
	}
	
	
}
