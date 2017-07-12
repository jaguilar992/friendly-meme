package main;

import tda.LISTA;

public class Main {
	public static void main(String[] args) {
		LISTA procesos = new LISTA();
		LISTA p = new LISTA();
		p.INSERTA("a", p.FIN());
		p.INSERTA("b", p.FIN());
		p.INSERTA("c", p.FIN());
		
		procesos.INSERTA(1, procesos.FIN());
		procesos.INSERTA(2, procesos.FIN());
		procesos.INSERTA(3, procesos.FIN());
		procesos.INSERTA(4, procesos.FIN());
		procesos.INSERTA(5, procesos.FIN());
		
		System.out.println(procesos);
		procesos.SUPRIME(procesos.PRIMERO());
		System.out.println(procesos);
		System.out.println(procesos.CUENTA());
		procesos.INSERTA(p, procesos.ANTERIOR(procesos.FIN()));
		System.out.println(procesos);
	}
}
