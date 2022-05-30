

/*Trabalho Sistemas Operacionais
Ana Helena Marcacini RA: 20.01305-0
Ettore Padula Dalben RA: 20.00387-0
Pedro Henrique Hein RA: 20.00134-7
feito pelo VSCode
*/

package bank;

import sun.misc.Signal;

public class Main {
    public static void main(String[] args) {
        Account ac1 = new Account(1000);

        Client clientes[] = {

			new Client("Augustus", ac1),
			new Client("Lucius", ac1),
			new Client("Claudius", ac1),
			new Client("Tiberius", ac1)};


        Signal.handle(new Signal("INT"), // CTRL+C
                (Signal signal) -> {
                    System.out.println("\nTerminando a simulação...");
                    for (Client cliente : clientes) {
                        System.out.println("Cliente " + cliente.getName() + " encerrando..."
                        );
                        cliente.interrupt();
                        
                    }
                });
        for (Client cliente : clientes) {
            cliente.start();
        }

    }
}

