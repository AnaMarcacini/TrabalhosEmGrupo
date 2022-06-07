#include <stddef.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
// Inicialização de valores--------------------------------------------------------------------------------------------------------------------------------------------------------------
#define Tamanho_Lista 8
#define Valores_Iniciais {{5,9,-1}, {2,16,7}, {3,4,5}, {-1,1,2}}
#define L 7

// Criação do tipo arranjo--------------------------------------------------------------------------------------------------------------------------------------------------------------
typedef struct arranjo{
    int proximo;
    int chave;
    int anterior;
}Arranjo;

//____________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________
// Funções
    Arranjo inserir(Arranjo arranjo[], Arranjo add);
    Arranjo remover(Arranjo arranjo[], int chave);
    void imprimir(Arranjo arranjo[]);
    int validar(char invalidado[], int valido);
//____________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

int main(){
    int opcao, valor, validaNUM, valido, ValInit[4][3] = Valores_Iniciais, auxint = L;
    // menu ; do dado, endereço, ver se é numero, retorno(ver se é numero), valores ini     ciais (facilitar a inicalização), tamanho da lista
    Arranjo lista[Tamanho_Lista], auxi;
    char validaSTR[1];

    for(auxint = 0; auxint < Tamanho_Lista; auxint++){
        lista[auxint].proximo = -9999999;
        lista[auxint].chave = -9999999;
        lista[auxint].anterior = -9999999;
    }

    do{
        printf("\n(1) - Iniciar\n(2) - Inserir\n(3) - Remover\n(4) - Imprimir\n(5) - Sair\nOpção: ");
        scanf("%s", &validaSTR);// pegar input
        opcao = validar(validaSTR, valido);// valida se tem uma string
        printf("\n");
        auxint = L; // tamanho da lista
        validaNUM = 0; // ver se o é numero 

        switch(opcao){
            case 1:
                while(validaNUM == 0){

                    // Zerar a lista
                    for(int x = 0; x<Tamanho_Lista; x++){
                        lista[x].chave = -9999999;
                        lista[x].anterior = -9999999;
                        lista[x].proximo = -9999999;
                    }

                    printf("Lista padrão? [s/n]\n");
                    scanf("%s", &validaSTR);

                    if(validaSTR[0]=='s'){
                        for(int x = 0; x < 4; x++){
							auxi.proximo = ValInit[x][0];
							auxi.chave = ValInit[x][1];
							auxi.anterior = ValInit[x][2];
                            inserir(lista, auxi);
                        }

                        validaNUM = 1;

                    } else if(validaSTR[0]=='n'){
                        for(int x=0; x < 4; x++){
                            printf("Digite um valor [%i/4]: ", (x+1));
                            scanf("%s", &validaSTR);
                            valor = validar(validaSTR, valido);

                            if(valor != -9999999){
                                auxi.proximo = -1;
                                auxi.chave = valor;
                                auxi.anterior = -9999999;
                                inserir(lista, auxi);
                            } else{
                                x--;
                            }
                        }

                        validaNUM = 1;

                    } else{
                        printf("Resposta inválida!\n");
                    }
                }

                printf("\n");
                printf("Lista iniciada:\n");
                imprimir(lista);
                break;
            case 2:
                printf("Digite um valor: ");
                scanf("%s", &validaSTR);
                valor = validar(validaSTR, valido);

                if(valor != -9999999){
					auxi.proximo = -1;
					auxi.chave = valor;
					auxi.anterior = -9999999;
                    inserir(lista, auxi);
                    imprimir(lista);
                }

                printf("\n");
                break;
            case 3:
                printf("Digite um valor para a remoção: ");
                scanf("%s", &validaSTR);
                valor = validar(validaSTR, valido);
                remover(lista, valor);
                imprimir(lista);
                break;
            case 4:
                imprimir(lista);
                break;
            default:
                if(opcao != 5){
                    printf("Opção inválida!\n");
                }
        }
    }while(opcao != 5);

    return 0;
}

Arranjo inserir(Arranjo arranjo[], Arranjo add){
    Arranjo aux;
    int auxint;
    auxint = L;
    
    for(int x = 0; x<Tamanho_Lista; x++){
        if(arranjo[x].chave==-9999999){
            break;
        } else{
            printf("A lista está cheia!\n");
            add.chave = arranjo[auxint].chave;
            return arranjo[auxint];
        }
    }
    
    if(add.anterior == -1){
		arranjo[auxint].chave = add.chave;
		arranjo[auxint].anterior = add.anterior;
		arranjo[auxint].proximo = add.proximo;
    } else if(add.anterior < 8 && add.anterior >= 0){
        auxint = arranjo[add.anterior].proximo;

        if(arranjo[add.anterior].proximo != -1){
            arranjo[auxint].chave = add.chave;
            arranjo[auxint].anterior = add.anterior;
            arranjo[auxint].proximo = add.proximo;
        }
    } else if(add.proximo == -1){
        auxint = rand() % 8;

        while(arranjo[auxint].chave != -9999999){
            auxint = rand() % 8;
        }
        for(int x = 0; x<Tamanho_Lista; x++){
            if(arranjo[x].proximo == -1){
                arranjo[auxint].chave = add.chave;
                arranjo[auxint].anterior = x;
                arranjo[auxint].proximo = add.proximo;
                break;
            } else if(x==(Tamanho_Lista-1)){
            arranjo[auxint].chave = add.chave;
            arranjo[auxint].anterior = -1;
            arranjo[auxint].proximo = add.proximo;
            }
        }
        for(int x = 0; x<Tamanho_Lista; x++){
            if(arranjo[x].proximo==-1 && x!=auxint){
                arranjo[x].proximo = auxint;
                break;
            }
        }
    } else{
        printf("Valor inválido!\n");
        return arranjo[-1];
    }

    return arranjo[-1];
}

Arranjo remover(Arranjo arranjo[], int chave){
    Arranjo aux[Tamanho_Lista], remover;
    int auxint;

    for(int x = 0; x<Tamanho_Lista; x++){
        if(arranjo[x].chave==chave){
            arranjo[arranjo[x].anterior].proximo = arranjo[x].proximo;
            arranjo[arranjo[x].proximo].anterior = arranjo[x].anterior;
            arranjo[x].proximo = -9999999;
            arranjo[x].chave = -9999999;
            arranjo[x].anterior = -9999999;
            auxint = x;
        }
    }
    return arranjo[Tamanho_Lista];
}

void imprimir(Arranjo arranjo[]){
    int init = 0;

	for(int x = 0; x<Tamanho_Lista; x++){
        if(arranjo[x].anterior==-1){
            init = x;
            break;
        }
    }

    int auxint = init;
    Arranjo aux;
    aux = arranjo[init];
    if(aux.proximo != -9999999){
        printf("\n=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=\n");
        printf("§Próximo:\t");

        for(int x = init; aux.proximo != -1; x = aux.proximo){
            printf("%i\t", aux.proximo);
            aux = arranjo[aux.proximo];
        }

        auxint = aux.proximo;
        printf("%i\t", auxint);
        printf("\n§Chave:\t\t");

        for(int x = init; arranjo[x].proximo != -1; x = arranjo[x].proximo){
            printf("%i\t", arranjo[x].chave);
        }

        printf("%i\t", aux.chave);
        printf("\n§Anterior:\t");

        for(int x = init; arranjo[x].proximo != -1; x = arranjo[x].proximo){
            printf("%i\t", arranjo[x].anterior);
        }
        
        printf("%i\t", aux.anterior);
        printf("\n=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=\n");
    } else{
        printf("A lista está vazia");
    }
}

int validar(char invalidado[], int valido){
    char *fim = NULL;
	
    if(strlen(invalidado)>9){
        printf("Valor muito grande!");
        return -9999999;
    }

    valido = strtol(invalidado, &fim, 10);

    if(fim == invalidado || *fim != '\0'){
        printf("Valor inválido!\n");
        return -9999999;
    } else{
        return valido;
    }
}