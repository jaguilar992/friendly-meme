package main;

import proceso.Conversor;

public class Main {
	public static void main(String[] args) {
		String linea = "1111/1/3/10/5/3;";
		Conversor c = new Conversor(linea);
		if(c.isOK){
			System.out.println(c.getProceso());
		}
	}
}
