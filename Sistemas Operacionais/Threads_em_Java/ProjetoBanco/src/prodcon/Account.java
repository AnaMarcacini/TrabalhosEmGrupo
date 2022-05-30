package bank;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private Integer balance;
    private int nclientes;
    private final Lock lock = new ReentrantLock();
    private final Condition lowBalance = lock.newCondition();

    public Account(Integer saldoInicial) {
        this.balance = saldoInicial;
        System.out.println("Conta criada com saldo inicial de: R$ "+ this.balance +",00");

    }

    // Deposita um valor na conta
    public boolean deposit(Integer value){
        lock.lock(); 

        try {
            this.balance = value + this.balance;
            System.out.println("Cliente: " + Thread.currentThread().getName() + " depositou " + value);
            System.out.println("Conta: saldo atualizado de " + this.balance);
            lowBalance.signalAll(); // "Acorda" demais Threads que estejam "dormindo"
 
            return true;
        }

        finally {
            lock.unlock();
        }

    }

    // Retira um valor da conta
    public boolean withdraw(Integer value) throws InterruptedException{
        lock.lock();
        try{
            // "Dorme" enquanto o valor da conta for insuficiente para ser retirado
            while(value > this.balance){
                System.out.println("Saldo insuficiente, esperando...");
                lowBalance.await();
            }  
            
            this.balance = this.balance - value;
            System.out.println("Cliente: " + Thread.currentThread().getName() + " retirou " + value);
            System.out.println("Conta: saldo atualizado de " + this.balance);
            return true;
        }
        finally{
            lock.unlock();
        }
    }

    
    public void setNclientes(int nclientes) {
        this.nclientes = nclientes;
    }
    public int getNclientes() {
        return nclientes;
    }

}
