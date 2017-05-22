package org.jcb.framework;

import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.jcb.framework.Divisao;
import org.jcb.framework.Multiplicacao;
import org.jcb.framework.Nodo;
import org.jcb.framework.Soma;
import org.jcb.framework.Subtracao;
import org.jcb.framework.Valor;


//@Stateless
//@Remote(Nodo.class)
public class CalcOO implements Nodo {
	
	@PostConstruct
	public String StartCalc(int num1, int num2, int opcao){
		// criando um objeto c a apartir do metodo calc
        
		// declarando as varíaveis
		//return "teste return " + opcao;
		
		Nodo resultado = new Valor(0);
		String saida = "";
		/*int opcao = 5;
		int num1;
		int num2;
		Scanner input = new Scanner(System.in);
		System.out.println("- Escolha uma opção -");
		System.out.println("1. Soma");
		System.out.println("2. Subtracao");
		System.out.println("3. Multiplicacao");
		System.out.println("4. Divisao");
		System.out.println("0. Sair");
		System.out.println("Operação: ");
		opcao = input.nextInt();*/
		while (opcao != 0) {
			//Scanner input1 = new Scanner(System.in);
			//System.out.println("Qual o primeiro numero: ");
			//num1 = input1.nextInt();
			Nodo esquerda = new Valor(num1);
			//System.out.println("Qual o segundo numero: ");
			//num2 = input1.nextInt();
			Nodo direita = new Valor(num2);
			if (opcao == 1) {
				resultado = new Soma(esquerda, direita);
				saida = "\nO resultado da soma é: ";
				break;
			} else if (opcao == 2) {
				resultado = new Subtracao(esquerda, direita);
				saida = "\nO resultado da subtração é: ";
				break;
			} else if (opcao == 3) {
				resultado = new Multiplicacao(esquerda, direita);
				saida = "\nO resultado da multiplicação é:";
				break;
			} else if (opcao == 4) {
				resultado = new Divisao(esquerda, direita);
				saida = "\nO resultado da divisão é:";
				break;
			} else {
				saida = "????";
				break;
			}
		
		}// fim do while - usuario optou por sair
		saida +=" " + resultado.calcula();
		return saida;
	} // fim do metodo principal

	@Override
	public int calcula() {
		// TODO Auto-generated method stub
		return 0;
	}
}
