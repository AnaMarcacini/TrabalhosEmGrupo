package prodcon;

import java.util.concurrent.ThreadLocalRandom;

// Adaptado de https://javarevisited.blogspot.com/2015/06/java-lock-and-condition-example-producer-consumer.html
public class Main {

	public static void main(String[] args) {

		// Cria o buffer compartilhado // no nosso caso seria um por conta
		//Buffer buffer = new Buffer();

		//_________________________________________________________________________________________________________________

		Account ac1 = new Account("ContaMariaEPaulo", 1000);
		Cliente cliente[] = {
			new Cliente("Augustus", ac1),
			new Cliente("Lucius", ac1),
			new Cliente("Claudius", ac1),
			new Cliente("Tiberius", ac1)};


		// Inicializa as threads

		//c1.start(); nn sei dizer se é preciso ja que tanto o retirar quanto a depositar estão no account
		//c2.start(); 
		ac1.start();
		ac2.start();
	}

}
