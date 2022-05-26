package prodcon;

import java.util.concurrent.ThreadLocalRandom;

public class Cliente {
    private String nome;
    private Account conta;
    Buffer buffer;


    public Cliente(String nome, Account conta) {
        this.nome = nome;
        this.conta = conta;
    }

    private Void execute(int valor){
        if(ThreadLocalRandom.current().nextInt(2)==1)
        conta.depositar(valor);
        else{
            conta.retirar(valor);
        }
        // retirar
    }



    
}


