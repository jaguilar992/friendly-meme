package tda;
import java.util.ArrayList;
import proceso.Proceso;

public class BLOCK extends COLA{

	// Remueve de la lista de bloqueados un proceso
	
	// Suma 1 a todos los contadores de proceso mientras estan en estado de bloqueado
	public void plusc_bloqueoAll() {
		int n = this.CUENTA();
		for(int i=0; i<n; i++) {
			Proceso p_i = (Proceso)this.FRENTE();
			p_i.plusc_bloqueo();
			this.PON_EN_COLA(p_i);
		}
	}
	
	// Obtiene los procesos que salen del bloqueo
	public ArrayList<Proceso> getDesbloqueados(){
		ArrayList<Proceso> desbloq = new ArrayList<>();
		int n = this.CUENTA();
		for(int i=0; i<n; i++) {
			Proceso p_i = ((Proceso)this.FRENTE());
			switch (p_i.getTipoBloqueo()) {
			case Proceso.BLOQUEO_DISK:
				if(p_i.getc_bloqueo()==Proceso.CICLOS_DISK) {
					p_i.setEstado(Proceso.LISTO);
					desbloq.add(p_i);
				}else {
					this.PON_EN_COLA(p_i);
				}
				break;
			case Proceso.BLOQUEO_ES:
				if(p_i.getc_bloqueo()==Proceso.CICLOS_ES) {
					p_i.setEstado(Proceso.LISTO);
					desbloq.add(p_i);
				}else {
					this.PON_EN_COLA(p_i);
				}
				break;
			default:
				break;
			}
		}
		return desbloq;
	}
	
	@Override
	public void PON_EN_COLA(Object x) {
		Proceso p = (Proceso)x;
		p.setEstado(Proceso.BLOQUEADO);
		super.PON_EN_COLA(p);
	}
	
}
