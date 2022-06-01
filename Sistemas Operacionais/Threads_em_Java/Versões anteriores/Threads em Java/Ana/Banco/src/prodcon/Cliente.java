package prodcon;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Cliente extends Thread {
    //private String nome;
    private Account conta;
    //Buffer buffer; // Referência para buffer compartilhado
    private final int[] valores = {10,20,50,100};
    private static int valor;


	// Construtor
	public Cliente(String nome,Account conta) {
		super(nome); // chama o construtor de Thread e passa o nome do parâmetro
		//this.buffer = new Buffer();
        this.conta = conta;
        conta.setNclientes(conta.getNclientes()+1);

	}
	@Override
    public void run() {
        execute();
    }
	
    private void execute(){ //
        //lista de valores



        try {
			// Tenta produzir um número inteiro aleatório
			while (true) {
		        valor = valores[ThreadLocalRandom.current().nextInt(valores.length)];

                if(ThreadLocalRandom.current().nextInt(2)==1){
                    conta.depositar(valor);
                    //conta.buffer.put(valor);
				    Thread.sleep(200);
                }
        
                else{
                    //conta.retirar(valor);
                    conta.buffer.get();
				    Thread.sleep(200);
        
                }
            
                
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        

    }



    
}


