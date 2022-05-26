package prodcon;

import java.util.concurrent.ThreadLocalRandom;

public class Cliente {
    private String nome;
    private Account conta;
    Buffer buffer; // Referência para buffer compartilhado
    private final int valores[] = new int[4];
    private static int valor;


	// Construtor
	public Cliente(Buffer buffer, String nome,Account conta) {
		super(nome); // chama o construtor de Thread e passa o nome do parâmetro
		this.buffer = buffer;
        this.nome = nome;
        this.conta = conta;

        //lista de valores
		valores[0] = 10;
		valores[1] = 20;
		valores[2] = 50;
		valores[3] = 100;
	}








    private void execute(){
        //lista de valores


		valor = valores[ThreadLocalRandom.current().nextInt(valores.length)];
//

        
        if(ThreadLocalRandom.current().nextInt(2)==1)
        conta.depositar(valor);
        else{
            conta.retirar(valor);
        }
    }



    
}


