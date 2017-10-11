package proceso;
import tda.BLOCK;
import tda.COLA;

public class Procesador {
	private int limite =0; // Limite de ciclos a ejecutar
	public COLA nuevos;
	private COLA [] listos = {new COLA(),new COLA(),new COLA()};
	private Proceso ejecutando;
	private Boolean loaded = false; // Comprueba si hay un proceso cargado en ejecucion
	public BLOCK bloqueados = new BLOCK();
	private COLA salientes = new COLA();
	private int c_ciclo=0; // contador de ciclos de reloj ejecutador por el procesador
	
	public Procesador() {}
	
	public void setLimit(int limit) {
		this.limite = limit;
	}
	
	public int getLimite() {
		return this.limite;
	}
	
	public void loadNuevos() {
		// CARGA COLA [] Prioridades desde Procesos nuevos del archivo de texto 
		// hacia COLA [] de LISTOS
		int n = nuevos.CUENTA();
		for (int i = 0; i < n; i++) {
			Proceso l = (Proceso)nuevos.FRENTE();
			l.setEstado(Proceso.LISTO);
			int prioridad = l.getPrioridad()-1;
			listos[prioridad].PON_EN_COLA(l);
		}
	}
	
	public void rutina() {
		/*
		1. Aumentar contador de cilos (Reloj del procesador)
		2. Encolar a listo(Prioridad[i] los procesos que deben salir del bloqueo, verificar)
		3. Aumentar contador de bloqueo de todos los de la lista de procesos bloqueados
		4. IF :: ejecutando es null (CARGAR PROCESO LISTO)
			-> OBTENER UN PROCESO LISTO SEGUN PRIORIDAD [1][2][3] (SACAR DE LA COLA DE LISTOS)
			ELSE :: 
				-> AUMENTAR (contador de segmento, 
				-> contador de instruccion) del proceso
		    	->IF Verificar si debe ser bloqueado :: 
					-> Mover proceso a bloqueados []
					-> Set procesos ejecutando a null
				->ELSE IF: Verifica si debe disminuirse la prioridad del proceso :: 
					-> Mover proceso a una COLA de prioridad-1
					-> Set procesos ejecutando a null
				-> ELSE:
					-> VERIFICAR SI EL PROCESO DEBE SALIR(Salientes)
		 */
		
		//1
		this.c_ciclo++;
		///2
				this.bloqueados.plusc_bloqueoAll();
		//3
		for(Proceso p : bloqueados.getDesbloqueados()) {
			int prioridad = p.getPrioridad();
			listos[prioridad-1].PON_EN_COLA(p);
		}
		
		//4
		if(ejecutando==null) {
			Proceso ejecutar = this.cargaProceso(); // CARGAR PROCESO DESDE LISTOS
			if(ejecutar!=null) {
				this.ejecutando = ejecutar;
				this.ejecutando.setEstado(Proceso.EJECUTANDO);
				this.loaded = true;
			}
		}
		if(this.loaded){
			this.ejecutando.plusc_inst(); // AUMENTAR CONTADOR DE INSTRUCCION
			this.ejecutando.plusc_seg(this.c_ciclo); // AUMENTAR CONTADOR DE SEGMENTO
			
			// VERFICACION DE BLOQUEO DE PROCESO
			if(this.ejecutando.getc_inst()==this.ejecutando.getnInstBloqueo()) {
				this.ejecutando.resetc_seg(); // RESETEAR CONTADOR DE SEGMENTO
				this.bloqueados.PON_EN_COLA(this.ejecutando);
				this.ejecutando = null;
				this.loaded=false;
			// VERIFICACION DE DECREMENTO DE PRIORIDAD
			}else if(this.ejecutando.getc_seg()>3) {
				int prioridad_bajo = this.ejecutando.getPrioridad()>=3 ? 3 : this.ejecutando.getPrioridad()+1;
				this.ejecutando.setEstado(Proceso.LISTO); // CAMBIAR ESTADO
				this.ejecutando.setPrioridad(prioridad_bajo); //CAMBIAR PRIORIDAD
				this.ejecutando.resetc_seg(); // RESETEAR CONTADOR DE SEGMENTO
				this.listos[prioridad_bajo-1].PON_EN_COLA(this.ejecutando); // MOVER A LISTOS
				this.ejecutando = null;
				this.loaded=false;
			}else {
				if(this.ejecutando.getc_inst() >= this.ejecutando.getnInst()) {
					this.ejecutando.setEstado(Proceso.SALIENTE);
					this.salientes.PON_EN_COLA(this.ejecutando);
					this.ejecutando=null;
					this.loaded=false;
				}
			}
		}
	}
	
	public COLA[] getListos() {
		return this.listos;
	}
	
	public Proceso cargaProceso() {
		if(listos[0].CUENTA()>0) {
			return (Proceso)listos[0].FRENTE();
		} else if(listos[1].CUENTA()>0) {
			return (Proceso)listos[1].FRENTE();
		}else if(listos[2].CUENTA()>0) {
			return (Proceso)listos[2].FRENTE();
		}
		return null;
	}
	
	// GETTERS PARA IMPRESION
	public Proceso getEjecutando() {
		return this.ejecutando;
	}
	
	public BLOCK getBloqueados() {
		return this.bloqueados;
	}
	
	public COLA getSalientes() {
		return this.salientes;
	}
	
}
