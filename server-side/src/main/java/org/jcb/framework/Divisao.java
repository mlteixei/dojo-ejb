package org.jcb.framework;
/**
 *
 * @author jean
 */
public class Divisao extends Operacao {

    public Divisao(Nodo esquerda, Nodo direita) {
        super(esquerda, direita);
    }

    @Override
    protected int executa(int esquerda, int direita) {
        return esquerda / direita;
    }

    @Override
    protected String simbolo() {
        return "/";
    }

	@Override
	public String StartCalc(int num1, int num2, int opcao) {
		// TODO Auto-generated method stub
		return null;
	}

}
