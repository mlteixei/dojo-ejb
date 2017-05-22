
package org.jcb.framework;

import javax.ejb.Remote;

/**
 *
 * @author jean
 */
@Remote
public interface Nodo {
    int calcula();
    String StartCalc(int num1, int num2, int opcao);
}
