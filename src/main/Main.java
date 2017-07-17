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
		
		
		System.out.println("***** Gestor de procesos ***** "
				+ "\n \tCARGA");
		System.out.println("\nSíntaxis de proceso: "
				+ "[0-9]{4}/[0-4]/[1-3]/[0-9]{3}/[0-9]{3}/[3,5]"
				+ "\t\nEjemplo: 1111/0/1/010/002/3;");
		
		System.out.print("\n¿Desea ingresar un proceso? (S/N): ");
		resp=scan.nextLine().toUpperCase();
		while(resp.equals("S")){
			System.out.print("\tIngrese Proceso: ");
			linea = scan.nextLine();
			Parser p = new Parser(linea);
			if(p.isOK){
				procesos.METE(p.getProceso());
				System.out.println("Proceso agregado a PILA exitosamente.");
			}	
			System.out.print("¿Desea ingresar un proceso? (S/N): ");
			resp=scan.nextLine().toUpperCase();
		}
		scan.close();
		System.out.println("\nPILA de PROCESOS NUEVOS:\n"+procesos);
	}
			
}
