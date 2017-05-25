package org.jcb.dojo.ejb.server;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.jcb.dojo.ejb.server.*;
import org.jcb.framework.CalcOO;

import javax.ejb.Remote;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Stateless;

@Stateless
@Remote(HelloWorld.class)
public class HelloWorldBean implements HelloWorld {
	
List<String> nomes;
	
	@PostConstruct	
	private void incia(){
		System.out.println("Inicia com @PostConstruct");
		nomes = new ArrayList<>();
	}
	public String hello(String nome){
		nomes.add(nome);
		return "Alo "+ nome;
	}
	
	public List<String> historico(){
		return nomes;
	}
	
	
	@PreDestroy
	private void finaliza(){
		System.out.println("finaliza com @PreDestroy");
		nomes = null;
	}
	
	@Override
	public String StartCalc(int num1 ,int num2 , int opcao) {
		// TODO Auto-generated method stub
		CalcOO fraCalc = new CalcOO();
		String resultado = fraCalc.StartCalc(num1, num2, opcao);
		System.out.println("chamada remota" + resultado);
		return resultado;
	}

}
