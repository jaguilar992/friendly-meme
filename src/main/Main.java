package main;

import java.util.ArrayList;
import proceso.Parser;
import proceso.Procesador;
import proceso.Proceso;
import proceso.ProcessFile;
import tda.COLA;

public class Main {
	public static void main(String[] args) {
		
		COLA nuevos = new COLA();
		COLA listos[] = new COLA[3];
		listos[0] = new COLA();
		listos[1] = new COLA();
		listos[2] = new COLA();
		
		// LEER ARCHIVO Y CREAR COLA DE NUEVOS
		if (args.length==1) {
			ProcessFile file = new ProcessFile(args[0]);
			ArrayList<String> lineas = file.readlines();
			for (String string : lineas) {
				Parser conversor = new Parser();
				conversor.setLinea(string);
				if (conversor.isOK) {
					Proceso p = conversor.getProceso();
					if(!repite(nuevos,p)){
						nuevos.PON_EN_COLA(p);
					}else{
						System.out.println("  |ID repetido, linea omitida: ID :: "+p.getId()+"\n");
					}
				}else{
					System.out.println("  |Error en: "+string+"\n");
				}
			}
		}else{
			System.out.println("\tUSO: java -jar Gestor.jar <filename>");
		}		
		
		
		// PROCESAMIENTO (GESTOR)
		int limite = 50;
		Procesador core = new Procesador();
		core.setLimit(limite);
		core.nuevos = nuevos;
		core.loadNuevos();
		
		
		// LOOP DEL PROCESAROR, A ejecutarse <core.getLimit()> veces
		for (int i = 0; i<core.getLimite() ;i++) {
			core.rutina();
		}
		
		
		
			
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
