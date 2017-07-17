package proceso;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Recibe una cadena en formato 1001/0/1/84/52/5;
 * Devuelve (Despúes de depurar) un Proceso a insertar en la pila de Nuevos y Posteriormente
 * Separar por prioridades en una Lista de Procesos nuevos.
 * */
public class Conversor {

	public String linea;
	private Proceso proceso;
	private String [] campos;
	/*
	 * campos[0] // ID
	 * campos[1] // ESTADO
	 * campos[2] // PRIORIDAD
	 * campos[3] // CANTIDAD DE INSTRUCCIONES
	 * campos[4] // INSTRUCCION DE BLOQUEO
	 * campos[5] // EVENTO DE BLOQUEO
	 * */
	public boolean isOK = false; // Almacena un valor lógico, si la conversión es exitosa.
	
	public Conversor(){}
	public Conversor(String linea){
		this.linea = linea;
		this.separar();
		this.crearProceso();
	}
	
	
	
	public Proceso getProceso() {
		return proceso;
	}
	public void setLinea(String linea) {
		this.linea = linea;
		this.separar();
		this.crearProceso();
	}
	public void separar(){
		if(this.linea!=null && !haveChars() && cheSyntax()){
			String [] campos = new String[6];
			String pattern = "(\\d*[^A-Za-z\\W])";
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(this.linea);
			int count = 0;
			while(m.find()){
				campos[count]=m.group(0);
				count++;
			}
			if(count==6){
				this.campos = campos;
			}
		}
	}
	
	public boolean haveChars(){
			String pattern = "([a-zA-Z]*[^\\/0-9;])";
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(this.linea);
			while(m.find()){
				return true;
			}
			return false;
	}
	
	// Verifica número correcto de plecas
	public boolean cheSyntax(){
		//contar slashes
		String pattern = "\\/";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(this.linea);
		int cs = 0;
		while(m.find()){
			cs++;
		}
		// Verificar el punto y coma del final
		pattern = ";$";
		p = Pattern.compile(pattern);
		m = p.matcher(this.linea);
		boolean fin = false;
		while(m.find()){
			fin=true;
		}
		if(cs==5 && fin){
			return true;
		}else return false;
	}
	
	public boolean checkCampos (){
		try {
			int[] len = {4,1,1,3,3,1};
			for (int i = 0; i < this.campos.length; i++) {
				if (this.campos[i].length()>len[i] || Integer.parseInt(this.campos[i])==0) {
					System.out.println("|Error en la longitud de los campos.\n|Línea omitida");
					return false;
				}
			}
			if (!(
					Integer.parseInt(this.campos[5])==Proceso.BLOQUEO_DISK || 
					Integer.parseInt(this.campos[5])==Proceso.BLOQUEO_ES
			)) {
				System.out.println("|No se reconoce tipo de evento de bloqueo.\n|Línea omitida");
				return false;
			}
			if (Integer.parseInt(this.campos[3])<Integer.parseInt(this.campos[4])) {
				System.out.println("|Instruccion de bloqueo excede al total de instrucciones.\n|Línea omitida");
				return false;
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("|Sintaxis de proceso incorrecta.\n|Instrucción omitida");
			return false;
		}
		return true;
	}
	
	public void crearProceso(){
		if (checkCampos()) {
			this.proceso  = new Proceso();
			this.proceso.setId(Integer.parseInt(this.campos[0]));
			this.proceso.setEstado(Integer.parseInt(this.campos[1]));
			this.proceso.setPrioridad(Integer.parseInt(this.campos[2]));
			this.proceso.setnInst(Integer.parseInt(this.campos[3]));
			this.proceso.setnInstBloqueo(Integer.parseInt(this.campos[4]));
			this.proceso.setTipoBloqueo(Integer.parseInt(this.campos[5]));
			this.isOK = true;
		}
	}
}
