package banco;
import java.util.concurrent.ThreadLocalRandom;


public class Client extends Thread {
    private Account account;
    public final int[] valores = { 10, 20, 50, 100 };
    public static int valor;
    
	// Construtor
    public Client(String name, Account account) {
        super(name); // chama o construtor de Thread e passa o nome do parâmetro
        this.account = account;
        account.setNclientes(account.getNclientes()+1);
        
    }

    public void execute() throws InterruptedException {

        valor = valores[ThreadLocalRandom.current().nextInt(valores.length)];

        if (ThreadLocalRandom.current().nextInt(0, 2) == 1) {
            account.deposit(valor);
        } else{
            account.withdraw(valor);
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                execute();
                Thread.sleep(200);
            }
        }

        catch (InterruptedException e) {
        }

    }

}