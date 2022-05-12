import java.util.concurrent.ThreadLocalRandom;

import javax.lang.model.util.ElementScanner6;
//threads
public class Client {
    private String nome;
    private Account account;
    final int valores[] = new int[]{10,20,50,100};


    public Client(String nome, Account account) {
        this.nome = nome;
        this.account = account;
    }


    int execute(){
        // sorteia o valor a ser retirado

        int valor = valores[ThreadLocal.current().nextInt(valores.length)];

        //sorteia se chama o deposito ou retirada
        int sorteio = ThreadLocal.current().nextInt(1);
        if(sorteio == 1){
            this.account.deposit();
        }
        else{
            this.account.withdraw();

        }
        return 0
    }
    
}
