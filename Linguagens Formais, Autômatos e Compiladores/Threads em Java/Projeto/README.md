## Projeto

Criação de um banco 
conta corrente(classe account) compartilhda por 4 clientes 
cada cliente pode realizar um deposito/ ou retirada(randon)

Cuidado: saldo negativo

    em caso de saldo negativo ele deve esperar antes de fazer a transação

# classe account
    *priv balance (saldo)
        -->construtor para criação da conta(saldo inicial)
    *metodo de deposito deposit()
    *metodo retiradas withdraw(). 
.

    *conta compartilhada pelos clientes 

# Classe clientes (Client)
    * campo privado nome, account(armazenr referencias da conta )
    *Metodos
        contrutor(nome ;associar a conta existente[criada no prgrama principal])
        
        execute : sorteia se vamos depositar ou retirar dinheiro
    ''valores a serem depositados ou retirados devem ser escolhidos aleatoriamente entre 10,20,50,100
.
''Mostrar as mensagem das transações