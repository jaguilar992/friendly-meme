package tda;
import java.util.ArrayList;

import proceso.Proceso;

public class BLOCK extends LISTA{

	// Remueve de la lista de bloqueados un proceso
	public Object popProceso(int i) {
		Object o = super.RECUPERA(i);
		super.SUPRIME(i);
		return o;
	}
	
	// Suma 1 a todos los contadores de proceso mientras estan en estado de bloqueado
	public void plusc_bloqueoAll() {
		for(int i=0; i<this.CUENTA(); i++) {
			Proceso p_i = ((Proceso)this.RECUPERA(i));
			if(p_i.getc_bloqueo() == Proceso.BLOQUEADO) {
				p_i.plusc_bloqueo();
			}
		}
	}
	
	// Obtiene los procesos que salen del bloqueo
	public ArrayList<Proceso> getDesbloqueados(){
		ArrayList<Proceso> desbloq = new ArrayList<>();
		for(int i=0; i<this.CUENTA(); i++) {
			Proceso p_i = ((Proceso)this.RECUPERA(i));
			switch (p_i.getTipoBloqueo()) {
			case Proceso.BLOQUEO_DISK:
				if(p_i.getc_bloqueo()==Proceso.CICLOS_DISK) {
					desbloq.add(p_i);
					this.SUPRIME(i);
				}
				break;
			case Proceso.BLOQUEO_ES:
				if(p_i.getc_bloqueo()==Proceso.CICLOS_ES) {
					desbloq.add(p_i);
					this.SUPRIME(i);
				}
				break;
			default:
				break;
			}
		}
		return desbloq;
	}
	
	
}
