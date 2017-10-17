package proceso;

public class Proceso {
	private int id;
	private int prioridad;
	private int nInst; // Total de instrucciones
	private int nInstBloqueo; // Instrucción donde ocurre el bloqueo
	private int tipoBloqueo;
	private int estado;
	
	private int ejecutadesde; // Almacena el valor del ciclo de reloj desde que se está ejecutando la instruccion, util para calculo de segmento
	private int c_seg=1; // Contador del número de segmentos consecutivos ejecutados en el procesador, default=1
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
	
	// GETTERS AND SETTERS DE CAMPOS DE PROCESO
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
	}	// END GETTERS AND SETTERS DE CAMPOS DE PROCESO
	
	// Devuelve el valor de contador de instruccion
	public int getc_inst() {
		return this.c_inst;
	}
	
	// Devuelve el valor de contador en bloqueo
	public int getc_bloqueo() {
		return this.c_bloqueo;
	}
	
	// AUmenta en 1 el contador de instruccion que se inicia desde que se ejecuta 
	// por primera vez el proceso 
	public void plusc_inst() {
		this.c_inst++;
	}
	
	// AUmenta en 1 el valor de contador de bloqueo que se lleva desde que se bloquea el proceso
	public void plusc_bloqueo() {
		this.c_bloqueo++;
	}
	
	// Vuelve cero el numero de segmento
	public void resetc_seg() {
		this.c_seg=1;
	}
	
	// Setea el numero de segmento consecutivo 
	// enque se está ejecutando desde que inicio el proceso
	// Param: int, recibe el contador de ciclos reloj de un procesador.
	public void plusc_seg(int contador) {
		if((contador-this.ejecutadesde+1) % 5 == 0) {
			this.c_seg++;
		}
	}
	// Devuelve el valor del segmento en que se está ejecutando el proceso
	public int getc_seg() {
		return this.c_seg;
	}
	
	// Modifica el numero de instruccion desde la cual se empezó a ejecutar el proceso
	public void setEjecutadesde(int ejecutadesde) {
		this.ejecutadesde = ejecutadesde;
	}

	@Override
	public String toString() {
		return "Proceso [id=" + id + ", prioridad=" + prioridad + ", nInst=" + nInst + ", nInstBloqueo=" + nInstBloqueo
				+ ", tipoBloqueo=" + tipoBloqueo + ", estado=" + estado + ", ejecutadesde=" + ejecutadesde + ", c_seg="
				+ c_seg + ", c_inst=" + c_inst + ", c_bloqueo=" + c_bloqueo + "]";
	}

	
	
	
	
}
