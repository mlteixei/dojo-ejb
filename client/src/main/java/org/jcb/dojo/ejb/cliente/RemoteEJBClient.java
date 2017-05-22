
package org.jcb.dojo.ejb.cliente;

import java.util.Hashtable;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jcb.dojo.ejb.server.HelloWorld;
import org.jcb.framework.Nodo;
import org.jcb.dojo.ejb.server.StatefulHelloWorld;

public class RemoteEJBClient {

	public static void main(String[] args) throws Exception {
		System.out.println("###########################\nexecutando remoto");

		invokeCalcOO();
		//invokeHelloWorld();
//		invokeStatefulHelloWorld();
	}

	private static void invokeCalcOO() throws NamingException {
		final HelloWorld nd = lookupRemoteHelloWorld();
		System.out.println("############## Executando Calculadora !!!");
		int op = 5;
		while (op != 0) {
			int n1 = 0;
			int n2 = 0;
			Scanner input = new Scanner(System.in);
			System.out.println("- Escolha uma opção -");
			System.out.println("1. Soma");
			System.out.println("2. Subtracao");
			System.out.println("3. Multiplicacao");
			System.out.println("4. Divisao");
			System.out.println("0. Sair");
			System.out.println("Operação: ");
			op = input.nextInt();
		
			if(op != 0){
				Scanner input1 = new Scanner(System.in);
				System.out.println("Qual o primeiro numero: ");
				n1 = input1.nextInt();
				//Nodo esquerda = new Valor(num1);
				System.out.println("Qual o segundo numero: ");
				n2 = input1.nextInt();
				//Nodo direita = new Valor(num2);
				System.out.println(nd.StartCalc(n1, n2, op));
				System.out.println("\n##############\n");	
			}else{
				System.out.println("ADEUS! \n##############\n");
			}			
		}
		//System.out.println(op.historico());
	}
	
	private static Nodo lookupRemoteNodo() throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable<>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);

		return (Nodo) context
				.lookup("ejb:/wildfly-ejb-remote-server-side/CalcOO!" + Nodo.class.getName());
	}
	
	private static void invokeHelloWorld() throws NamingException {
		final HelloWorld hw = lookupRemoteHelloWorld();
		System.out.println("############## Executando HELLO !!!");
		System.out.println(hw.hello("jader"));
		System.out.println(hw.historico());
	}
	
	private static void invokeStatefulHelloWorld() throws NamingException {
		final StatefulHelloWorld hw = lookupRemoteStatefulHelloWorld();
		System.out.println("############## Executando HELLO Stateful!!!");
		System.out.println(hw.hello("jader"));
		System.out.println(hw.historico());
	}

	private static HelloWorld lookupRemoteHelloWorld() throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable<>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);

		// The JNDI lookup name for a stateless session bean has the syntax of:
		// ejb:<appName>/<moduleName>/<distinctName>/<beanName>!<viewClassName>
		//
		// <appName> The application name is the name of the EAR that the EJB is
		// deployed in
		// (without the .ear). If the EJB JAR is not deployed in an EAR then
		// this is
		// blank. The app name can also be specified in the EAR's
		// application.xml
		//
		// <moduleName> By the default the module name is the name of the EJB
		// JAR file (without the
		// .jar suffix). The module name might be overridden in the ejb-jar.xml
		//
		// <distinctName> : EAP allows each deployment to have an (optional)
		// distinct name.
		// This example does not use this so leave it blank.
		//
		// <beanName> : The name of the session been to be invoked.
		//
		// <viewClassName>: The fully qualified classname of the remote
		// interface. Must include
		// the whole package name.

		// let's do the lookup
		return (HelloWorld) context
				.lookup("ejb:/wildfly-ejb-remote-server-side/HelloWorldBean!" + HelloWorld.class.getName());
	}

	private static StatefulHelloWorld lookupRemoteStatefulHelloWorld() throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable<>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);

		// The JNDI lookup name for a stateless session bean has the syntax of:
		// ejb:<appName>/<moduleName>/<distinctName>/<beanName>!<viewClassName>
		//
		// <appName> The application name is the name of the EAR that the EJB is
		// deployed in
		// (without the .ear). If the EJB JAR is not deployed in an EAR then
		// this is
		// blank. The app name can also be specified in the EAR's
		// application.xml
		//
		// <moduleName> By the default the module name is the name of the EJB
		// JAR file (without the
		// .jar suffix). The module name might be overridden in the ejb-jar.xml
		//
		// <distinctName> : EAP allows each deployment to have an (optional)
		// distinct name.
		// This example does not use this so leave it blank.
		//
		// <beanName> : The name of the session been to be invoked.
		//
		// <viewClassName>: The fully qualified classname of the remote
		// interface. Must include
		// the whole package name.

		// let's do the lookup
		return (StatefulHelloWorld) context.lookup("ejb:/wildfly-ejb-remote-server-side/StatefulHelloWorldBean!"
				+ StatefulHelloWorld.class.getName() + "?stateful");
	}

}