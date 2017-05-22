package org.jcb.framework;
/**
 *
 * @author jean
 */
public class Valor implements Nodo {

    private final int val;

    public Valor(int val) {
        this.val = val;
    }

    @Override
    public int calcula() {
        return this.val;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }

	@Override
	public String StartCalc(int num1, int num2, int opcao) {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}
