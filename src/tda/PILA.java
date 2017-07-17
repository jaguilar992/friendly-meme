package tda;
public class PILA {
    private LISTA pila;
    public PILA(){
        this.pila = new LISTA();
    };
    public void ANULA(){
        pila.ANULA();
    }
    public void METE(Object x){
        pila.INSERTA(x, pila.FIN());
    }
    public boolean VACIA(){
        return pila.PRIMERO()==pila.FIN();     
    }
    public Object TOPE(){
        if (this.VACIA()!=true) {
            return pila.RECUPERA(pila.ANTERIOR(pila.FIN()));
        }else{
            System.err.println("No se hall� TOPE: PILA vac�a");
            return null;
        }
    }
    public void SACA(){
        if (this.VACIA()!=true) {
            pila.SUPRIME(pila.ANTERIOR(pila.FIN()));
        }else{
            System.err.println("No se hall� TOPE: PILA vac�a");
        }   
    }
    public int CUENTA() { // A�ADIDA: DEVUELVE EL NUMERO DE ELEMENTOS EN PILA
    return pila.FIN();
    }
   @Override // util para impresion
    public String toString() {
	   return this.pila.toString();
    } 
}
