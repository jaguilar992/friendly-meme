package main;

import java.util.Scanner;
import proceso.Parser;
import tda.PILA;

public class Main {
	public static void main(String[] args) {
		
		PILA procesos = new PILA();

		Scanner scan = new Scanner(System.in);
		String resp = "N";
		String linea="";
		
		
		System.out.println("Gestor de procesos");
		System.out.println("Síntaxis de proceso: "
				+ "[0-9]{,4}/[0-4]/[1-3]/[0-9]{,3}/[0-9]{,3}/[3,5]"
				+ "\nEjemplo: 1111/0/1/10/2/3");
		
		System.out.print("¿Desea ingresar un proceso? (S/N): ");
		resp=scan.nextLine().toUpperCase();
		while(resp.equals("S")){
			System.out.print("Ingrese Proceso: ");
			linea = scan.nextLine();
			Parser p = new Parser("1001/0/1/84/52/5");
			System.out.println(p.getLinea());
			if(p.isOK){
				procesos.METE(p.getProceso());;
			}	
			System.out.print("¿Desea ingresar un proceso? (S/N): ");
			resp=scan.nextLine().toUpperCase();
		}
		
		System.out.println("PILA de PROCESOS NUEVOS:\n"+procesos);
	}
			
}
