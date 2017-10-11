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
		
		String path = "resource/procesos_1.txt";
		
		if (path!=null) {
			ProcessFile file = new ProcessFile(path);
			ArrayList<String> lineas = file.readlines();
			for (String string : lineas) {
				Parser conversor = new Parser(string);
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
		}
		
		
		// PROCESAMIENTO (GESTOR)
		int limite = 1000;
		Procesador core = new Procesador();
		core.setLimit(limite);
		core.nuevos = nuevos;
		core.loadNuevos(); // MUEVE LOS PROCESOS NUEVOS A LISTOS
		
		
		// LOOP DEL PROCESAROR, A ejecutarse <core.getLimit()> veces
		for (int i = 0; i<core.getLimite() ;i++) {
			core.rutina();
		}
		
		
		// IMPRESION DE COLAS DE ESTADO
		
		// LISTOS
		COLA listoss[] = core.getListos();
		System.out.println("PRIORIDAD 1");
		System.out.println(listoss[0]);
		System.out.println("PRIORIDAD 2");
		System.out.println(listoss[1]);
		System.out.println("PRIORIDAD 3");
		System.out.println(listoss[2]);
		
		// EJECUTANDO
		System.out.println("EJECUTANDO");
		System.out.println(core.getEjecutando());
		
		// BLOQUEADOS
		System.out.println("BLOQUEADOS");
		System.out.print(core.getBloqueados());
		
		//SALIENTES
		System.out.println("SALIENTES");
		System.out.println(core.getSalientes());
		
		
		
			
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
