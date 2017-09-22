package Test;

import java.io.IOException;
import java.util.ArrayList;

import proceso.ProcessFile;

public class Prueba1 {
	public static void main(String[] args) throws IOException {
		ProcessFile file = new ProcessFile("resource/procesos_1.txt");
		ArrayList<String> lista = file.readlines();
		
		for (String string : lista) {
			System.out.println(string);
		}
	}
}
