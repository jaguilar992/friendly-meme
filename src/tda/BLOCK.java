package tda;

public class BLOCK extends LISTA{

	public Object getProceso(int i) {
		Object o = super.RECUPERA(i);
		super.SUPRIME(i);
		return o;
	}
	
	
}
