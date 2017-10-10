package proceso;
import tda.BLOCK;
import tda.COLA;

public class Procesador {
	private int limite =0; // Limite de ciclos a ejecutar
	public COLA nuevos = new COLA();
	private COLA [] listos = {new COLA(),new COLA(),new COLA()};
	private Proceso ejecutando;
	private BLOCK bloqueados = new BLOCK();
	private COLA salientes;
	private int c_ciclo=0;
	
	public Procesador() {}
	
	public void setLimit(int limit) {
		this.limite = limit;
	}
	
	public int getLimite() {
		return this.limite;
	}
	
	public void loadNuevos() {
		// CARGA COLA [] Prioridades desde Procesos nuevos del archivo de texto
		for (int i = 0; i < nuevos.CUENTA(); i++) {
			Proceso l = (Proceso)nuevos.FRENTE();
			int prioridad = l.getPrioridad();
			listos[prioridad-1].PON_EN_COLA(l);
		}
	}
	
	public void rutina() {
		/*
		1. Aumentar contador de cilos (Reloj del procesador)
		2. Encolar a listo(Prioridad[i] los procesos que deben salir del bloqueo, verificar)
		3. Aumentar contador de bloqueo de todos los de la lista de procesos bloqueados
		4. IF  ejecutando es null -> CARGAR PROCESOS
			-> OBTENER UN PROCESO LISTO SEGUN PRIORIDAD [1][2][3] (SACAR DE LA COLA DE LISTOS)
			-> AUMENTAR (contador de segmento, contador de instruccion) del proceso
		    
		    ->IF Verificar si debe ser bloqueado :: 
				-> Mover proceso a bloqueados []
				-> Set procesos ejecutando a null
			->ELSE IF: Verifica si debe disminuirse la prioridad del proceso :: 
				-> Mover proceso a una COLA de prioridad-1
				-> Set procesos ejecutando a null
			-> ELSE:
				-> continue
		 */
		
		//1
		this.c_ciclo++;
		//2
		for(Proceso p :bloqueados.getDesbloqueados()) {
			
		}
	}
	
	public COLA[] getListos() {
		return this.listos;
	}
	
}
