package Test;

import java.io.IOException;
import java.util.ArrayList;

import proceso.Parser;
import proceso.Procesador;
import proceso.Proceso;
import proceso.ProcessFile;
import tda.BLOCK;
import tda.COLA;
import tda.LISTA;

public class Prueba1 {
	public static void main(String[] args) throws IOException {
		ProcessFile file = new ProcessFile("resource/procesos_1.txt");
		ArrayList<String> lista = file.readlines();
		COLA nuevos = new COLA();
		
		for (String string : lista) {
			//System.out.println(string);
		}
		
		
		for(int i=0; i<lista.size();i++ ) {
			Parser c = new Parser(lista.get(i));
			if(c.isOK) {
				Proceso p = c.getProceso();
				nuevos.PON_EN_COLA(p);
				//System.out.println(p);
			}
		}
		
		//System.out.println(nuevos);
		//Procesador core = new Procesador();
		//core.nuevos = nuevos;
		//core.loadNuevos();
		//System.out.println(core.nuevos);
		
		//System.out.println(core.getListos()[0]);
		//System.out.println(core.getListos()[1]);
		//System.out.println(core.getListos()[2]);
		
		BLOCK n = new BLOCK();
		int p = nuevos.CUENTA();
		for(int i=0 ; i<p; i++) {
			n.PON_EN_COLA(nuevos.FRENTE());
		}
		
		
		for (int i = 0; i < 27; i++) {
			n.plusc_bloqueoAll();
		}
		
		
		System.out.println(n);
		
		for (Proceso mm : n.getDesbloqueados()) {
			System.out.println(mm);
		}
		
		
	}
}
