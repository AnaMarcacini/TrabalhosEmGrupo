package prodcon;

public class Account extends Thread {
    private float balance; //saldo
    private int nclientes;

	// Construtor
	public Account(String nomeConta, float saldoInicial) {
		super(nomeConta); // chama o construtor de Thread e passa o nome do parâmetro
        this.balance = saldoInicial;
        System.out.println(String.format("Conta criada com saldo inicial de: R$.2f", this.balance));
	}












    public String visualizarSaldo(){
             return(String.format("R$.2f",balance));
         }

    public boolean depositar(double valor){
        //if(valor < 0) 
        //    return false; /// erro impossivel (lista de valores nn tem valores negativos)
    this.balance += valor;
    return true;
}

 public boolean retirar(double valor){
     if(valor > balance) return false; // esperar buffer
            //if(valor < 0) return false; // erro impossivel (lista de valores nn tem valores negativos)
     this.balance -= valor;
     return true;
 }




















 public int getNclientes() {
    return nclientes;
}

public void setNclientes(int nclientes) {
    this.nclientes = nclientes;
}






}


//realizar um depósito ou uma retirada
//(jogue uma moeda antes de executar e escolha ...).


//O banco não aceita que retiradas sejam executadas quando a conta não possui saldo sufi- ciente (não se admite saldo negativo). Os clientes podem continuamente realizar depósitos ou retiradas e cabe ao seu programa sincronizar como isso será feito, de modo a manter a consistência e integridade da conta-corrente







// }
// public boolean transferirDinheiro(double valor, Conta destino){
//     if(!sacar(valor)) return false;
//     if(!destino.depositar(valor)) return false;
//     return true;
// }
