package main;

import proceso.Conversor;

public class Main {
	public static void main(String[] args) {
		String linea = "1111/1/1/10/1/6;";
		Conversor c = new Conversor(linea);
		if(c.isOK){
			System.out.println(c.getProceso());
		}
	}
}
