package tda;

import java.util.ArrayList;

public class LISTA{
	private ArrayList<Object> arrLista = new ArrayList<>();
	
	public int PRIMERO(){
		return 0; // Siempre retorna la primera cubeta del arreglo
	}
	
	public int ANTERIOR(int pos){
	    if (pos>this.PRIMERO() && pos<=this.FIN()) { // Verifica que la posicion sea valida en lista
	    	return pos-1;
	    }else{
	    	System.out.println("Error en ANTERIOR("+pos+"): Posici�n no existe");
		return -1;
	    }
	}
	
	public int SIGUIENTE(int pos){
	    if(pos>=this.PRIMERO() && pos<this.FIN()){ // Verifica que la posicion sea valida en lista
	    	return pos+1;
	    }else{
		System.out.println("Error en SIGUIENTE("+pos+"): Posici�n no existe");
			return -1;
	    }
	}
	
	public void ANULA(){
		this.arrLista.clear(); // Inicializa el arreglo, Problema: Basura en memoria
	}
	
	public int FIN(){ // Siguiente posicion de inserci�n al final de la lista
		return this.arrLista.size();
	}
	
	public int LOCALIZA(Object x){ // Devuelve la posicion del objeto x en Lista
		for (int i=0;i<this.FIN();i++ ) {
			if (getArrLista().get(i).equals(x)) {
				return i;
			}
		}
		return this.FIN(); // sino lo encuentra devuelve fin
	}
	
	public Object RECUPERA(int pos){
		if (pos>=this.PRIMERO() && pos<this.FIN()) { // Verifica que la posicion sea valida
	    		return getArrLista().get(pos); // Devuelve el dato en la posicion pos
		}else{ // En caso de no existir posicion en lista
			System.out.println("Error en RECUPERA("+pos+"): Posicion no existe");
			return null;
		}
	}
	
	public void INSERTA(Object x,int pos){
		if(pos>=this.PRIMERO() && pos<=this.FIN()){ // Verificar que la insercion sea valida
			this.arrLista.add(pos, x);
       }else{
    	   System.out.println("Error en INSERTA("+pos+"): Posici�n inv�lida");
       }
	}
	
	public void SUPRIME(int pos){
	    if(pos>=this.PRIMERO() && pos<this.FIN()){ // Verificar que suprimir sea valida
	    	this.arrLista.remove(pos);
	    }else{
	    	System.out.println("Error en SUPRIME("+pos+"): posici�n no v�lida");
	    }
	}
	
	public int CUENTA(){ //A�ADIDA
	    return this.FIN();
	}
	
    @Override // util para impresion
    public String toString() {
	String m ="[";
	for (int i = this.PRIMERO(); i <this.FIN(); i++) {
	    m+=(this.arrLista.get(i)).toString();
	    if(i!=this.FIN()-1){
	    	m+=", ";
	    }
	}
	return m+"]";
    }
    
    public ArrayList<Object> getArrLista() {
        return arrLista;
    }
}
