package tda;
public class COLA {
	private LISTA cola = new LISTA();
    public COLA(){};
	public void ANULA(){
		cola.ANULA();
	}
	public void PON_EN_COLA(Object x){
		cola.INSERTA(x, cola.FIN());
	}
	
	public void QUITA_DE_COLA (){
		if (!this.VACIA()) {
			cola.SUPRIME(cola.PRIMERO());
		}else{
			System.err.println("No se encontr� FRENTE: COLA vac�a");
		}
	}
	
	public Object RECUPERA(int i){
		return cola.RECUPERA(i);
	}
	
	public Object FRENTE (){
		if (!this.VACIA()) {
			Object a = cola.RECUPERA(cola.PRIMERO());
			this.QUITA_DE_COLA();
			return a;
		}else{
			System.err.println("No se encontr� FRENTE: COLA vac�a");
			return null;	
		}
	}
	public boolean VACIA(){
	    return cola.PRIMERO()==cola.FIN();
	}
	public int CUENTA(){ //AÑADIDA
	    return cola.FIN();
	}
    @Override // util para impresion
    public String toString() {
    	return this.cola.toString();
    }   
}
