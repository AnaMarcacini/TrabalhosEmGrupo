package prodcon;

import java.util.concurrent.ThreadLocalRandom;

public class Cliente {
    private String nome;
    private Account conta;
    Buffer buffer; // Referência para buffer compartilhado


	// Construtor
	public Cliente(Buffer buffer, String nome) {
		super(nome); // chama o construtor de Thread e passa o nome do parâmetro
		this.buffer = buffer;
        this.nome = nome;
	}








    public Cliente(String nome, Account conta) {
        this.nome = nome;
        this.conta = conta;
    }

    private void execute(int valor){
        if(ThreadLocalRandom.current().nextInt(2)==1)
        conta.depositar(valor);
        else{
            conta.retirar(valor);
        }
        // retirar
    }



    
}


