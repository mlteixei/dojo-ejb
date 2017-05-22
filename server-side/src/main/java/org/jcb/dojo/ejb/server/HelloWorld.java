package org.jcb.dojo.ejb.server;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface HelloWorld {

	public String hello(String nome);

	public List<String> historico();
	
	public String StartCalc(int num1 ,int num2 , int opcao);
}
