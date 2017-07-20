package main;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import proceso.Parser;
import tda.PILA;

public class Main {
	public static void main(String[] args) {
		
		PILA procesos = new PILA();
		Parser conversor = new Parser();
		
		ArrayList<String> lineas;
		try {
			if (args.length==1) {
				lineas =  readLines(args[0]);
				for (String string : lineas) {
					conversor.setLinea(string);
					if (conversor.isOK) {
						procesos.METE(conversor.getProceso());
					}else{
						System.out.println("  |Error en: "+string);
					}
				}
			}else{
				System.out.println("\tUSO: java -jar Gestor.jar <filename>");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Debe especificar un archivo donde se almacenen los procesos");
		}
		
		System.out.println("\nTotal Cargados: "+procesos.CUENTA());
		System.out.println("PILA: \n"+procesos);
			
	}
	
	public static ArrayList<String> readLines(String file){
		ArrayList<String> lineas = new ArrayList<>();
		Path p = Paths.get(file);
		try {
			BufferedReader b = Files.newBufferedReader(p);
			String linea;
			while((linea=b.readLine())!=null){
				if(linea!=""){
					lineas.add(linea);
				}
			}
		} catch (Exception e) {
			
		}
		return lineas;
	}
}
