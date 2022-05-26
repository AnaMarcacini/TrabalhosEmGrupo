package prodcon;

import java.util.concurrent.ThreadLocalRandom;

// Adaptado de https://javarevisited.blogspot.com/2015/06/java-lock-and-condition-example-producer-consumer.html
public class Main {

	public static void main(String[] args) {

		// Cria o buffer compartilhado
		Buffer buffer = new Buffer();

		//lista de valores
		int valores[] = new int[4];
		valores[0] = 10;
		valores[1] = 20;
		valores[2] = 50;
		valores[3] = 100;
		int valor;

		valor = valores[ThreadLocalRandom.current().nextInt(valores.length)];
//_________________________________________________________________________________________________________________



		// Cria as threads de produtor e consumidor
		Producer p1 = new Producer(buffer, "PRODUTOR 1");
		Producer p2 = new Producer(buffer, "PRODUTOR 2");
		Consumer c1 = new Consumer(buffer, "CONSUMIDOR 1");
		Consumer c2 = new Consumer(buffer, "CONSUMIDOR 2");
		// Inicializa as threads
		p1.start();
		p2.start();
		c1.start();
		c2.start();
	}

}