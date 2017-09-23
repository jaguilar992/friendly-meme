package main;

import java.util.ArrayList;
import proceso.Parser;
import proceso.Proceso;
import proceso.ProcessFile;
import tda.COLA;

public class Main {
	public static void main(String[] args) {
		
		COLA cargados = new COLA();
		COLA listos[] = new COLA[3];
		listos[0] = new COLA();
		listos[1] = new COLA();
		listos[2] = new COLA();
		
		if (args.length==1) {
			ProcessFile file = new ProcessFile(args[0]);
			ArrayList<String> lineas = file.readlines();
			for (String string : lineas) {
				Parser conversor = new Parser();
				conversor.setLinea(string);
				if (conversor.isOK) {
					Proceso p = conversor.getProceso();
					if(!repite(cargados,p)){
						cargados.PON_EN_COLA(p);
					}else{
						System.out.println("  |ID repetido, linea omitida: ID -> "+p.getId()+"\n");
					}
				}else{
					System.out.println("  |Error en: "+string+"\n");
				}
			}
		}else{
			System.out.println("\tUSO: java -jar Gestor.jar <filename>");
		}		
		
//		if (!cargados.VACIA()) {
//			System.out.println("\nTotal Cargados: "+cargados.CUENTA());
//			System.out.println(cargados);
//		}
	
		for (int i = 0; i < cargados.CUENTA(); i++) {
			Proceso l = (Proceso)cargados.RECUPERA(i);
			int prioridad = l.getPrioridad();
			listos[prioridad-1].PON_EN_COLA(l);
		}
		
		System.out.println("Procesos Listos: ");
		System.out.println("\nCOLA Prioridad 1:");
		System.out.println(listos[0]);
		System.out.println("\nCOLA Prioridad 2:");
		System.out.println(listos[1]);
		System.out.println("\nCOLA Prioridad 3:");
		System.out.println(listos[2]);
			
	}
	
	public static boolean repite(COLA cargados, Proceso p){
		boolean repetido = false;
		for (int i = 0; i < cargados.CUENTA(); i++) {
			Proceso actual = (Proceso)cargados.RECUPERA(i);
			if (actual.getId() == p.getId()) {
				repetido = true;
				break;
			}
		}
		return repetido;
	}
	
	
}
