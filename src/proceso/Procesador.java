package proceso;
import tda.BLOCK;
import tda.COLA;

public class Procesador {
	private int limite =0; // Limite de ciclos a ejecutar
	private COLA nuevos = new COLA();
	private COLA [] listos = {new COLA(),new COLA(),new COLA()};
	private Proceso ejecutando;
	private BLOCK bloqueados = new BLOCK();
	private COLA salientes;
	
	public Procesador() {
		
	}
}
