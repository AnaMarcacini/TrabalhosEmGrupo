package prodcon;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
	
	private double Dinheiro_Conta;
	public double valor_retirado;

	// Variável de lock para acessar a fila compartilhada
	private final Lock lock = new ReentrantLock();
	// Variável de condição do produtor que libera o consumidor para consumir
	private final Condition bufferNotFull = lock.newCondition();
	// Variável de condição do consumidor que libera o produtor para produzir
	private final Condition bufferNotEmpty = lock.newCondition();

	// Armazena um número na fila
	public void put(int number) throws InterruptedException {
		lock.lock();
		try {
			// Se buffer estiver cheio, aguarda o consumidor consumir algum número 
			// devemos mudar a condição para o numero do bufer maior que o pedido
			while (Dinheiro_Conta > valor_retirado) {//
				bufferNotEmpty.await();
			}

		} finally {
			lock.unlock();
		}
	}

	// Remove um número da fila
	public void get() throws InterruptedException { // para o consumidor // quando está vazio
		lock.lock();
		try {
			// Se buffer estiver vazio, aguarda o produtor produzir algum número
			while (Dinheiro_Conta > valor_retirado) {
				System.out.println(Thread.currentThread().getName() +
						" : Saldo Insuficiente, aguardando...");
				bufferNotFull.await(); /// COMANDO DE PARADA
			}
			Dinheiro_Conta -= valor_retirado;
			
		} finally {
			lock.unlock();
		}
	}

}


// public boolean retirar(double valor){
// 	if(valor > balance) {
// 		this.buffer.valor_retirado = valor;
// 	} // esperar buffer
// 	this.balance -= valor;
// 	return true;
// }