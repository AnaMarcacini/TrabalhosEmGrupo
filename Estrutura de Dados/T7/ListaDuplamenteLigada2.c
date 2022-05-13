#include <stddef.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#define Tamanho_Lista 8
#define Valores_Iniciais {{5,9,-1}, {2,16,7}, {3,4,5}, {-1,1,2}}
#define L 7

typedef struct arranjo{
    int chave;
    int proximo;
    int anterior;
}Arranjo;

Arranjo inserir(Arranjo arranjo[], Arranjo chave);
Arranjo remover(Arranjo arranjo[], int chave);
void imprimir(Arranjo arranjo[]);
int validar(char invalidado, int valido);

int main(){
    //Declaração de variáveis
    int opcao, valor, anterior, validaNUM, valido, ValInit[4][3] = Valores_Iniciais;
    Arranjo removido, lista[Tamanho_Lista], auxi;
    char validaSTR; //O valor entre [] no validarSTR é o tamanho max da ListaDLigada em si

    do{
        printf("\n(1) - Iniciar\n(2) - Inserir\n(3) - Remover\n(4) - Imprimir\n(5) - Sair\nOpção: ");
        validaSTR = scanf("%s", validaSTR);
        opcao = validar(validaSTR, valido);
        printf("\n");

        switch(opcao){
            case 1:
				lista[L].anterior = -1;
                validaNUM = 0;
                while(validaNUM == 0){
                    printf("Lista padrão? [s/n]\n");
                    scanf("%s", &validaSTR);
                    if(validaSTR=='s'){
                        for(int x = 0; x != -1; x = ValInit[x][2]){
							auxi.proximo = ValInit[x][0];
							auxi.chave = ValInit[x][1];
							auxi.chave = ValInit[x][2];
                            lista[x] = inserir(lista, auxi);
                        }
                        validaNUM = 1;
                    } else if(validaSTR=='n'){
                        for(int x=0; x < 4; x++){
                            printf("Digite um valor [%i/4]: ", (x+1));
                            validaSTR = scanf("%s", validaSTR);
                            valor = validar(validaSTR, valido);
                            if(valor != -999999999){
								auxi.proximo = -1;
								auxi.chave = valor;
								auxi.chave = -1;
                                lista[x] = inserir(lista, auxi);
                            } else{
                                x--;
                            }
                        }
                        validaNUM = 1;
                    }  else{
                        printf("Resposta inválida!\n");
                    }
                }
                printf("\n");
                printf("Lista iniciada:\n");
                imprimir(lista);
                break;
            case 2:
                printf("Digite um valor: ");
                validaSTR = scanf("%s", validaSTR);
                valor = validar(validaSTR, valido);
                if(valor != -999999999){
					auxi.proximo = -1;
					auxi.chave = valor;
					auxi.chave = -1;
                    lista[L] = inserir(lista, auxi);
                    imprimir(lista);
                }
                printf("\n");
                break;
            case 3:
                printf("Digite um valor para a remoção: ");
                validaSTR = scanf("%s", validaSTR);
                valor = validar(validaSTR, valido);
                validaNUM = 0;

                for(int x=0; x<Tamanho_Lista; x++){
                    removido = remover(lista, valor);
                    if(removido.chave){
                        validaNUM++;
                    }
                }

                printf("\n");
                if(validaNUM){
                    printf("Elemento removido: %i\nAgora a lista se apresenta assim:\n", valor);
                    imprimir(lista);
                } else{
                    printf("Elemento não encontrado!\n");
                }
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

Arranjo inserir(Arranjo arranjo[], Arranjo chave){
    Arranjo aux[Tamanho_Lista], novo;

    if(novo.chave){
        novo.chave = chave.chave;
        novo.proximo = -1;

        if(arranjo == NULL){
            arranjo[0] = novo;
            novo.anterior = -1;
        } else{
            aux[0] = arranjo[0];
            while(aux[0].proximo)
                aux[0] = aux[aux[0].proximo];
            aux[1] = novo;
            novo = aux[1];
        }
    } else{
        printf("A lista está cheia!\n");
    }
}

Arranjo remover(Arranjo arranjo[], int chave){
    Arranjo aux[Tamanho_Lista], remover;

    if(arranjo[0].chave){

        if(arranjo[0].chave == chave){
            remover = arranjo[0];
            arranjo[0] = remover;

            if(arranjo[0].chave){
                arranjo[0].anterior = -1;
            }
        } else{
            aux[0] = arranjo[0];

            while(aux[0].proximo && aux[0].chave != chave){
                aux[0] = aux[aux[0].proximo];
            }

            if(aux[0].proximo){
                remover = arranjo[aux[0].proximo];
                aux[0].proximo = remover.proximo;
                if(aux[0].proximo){
                    (aux[aux[0].proximo]).anterior = aux[0].proximo;
                }
            }
        }
    }
       
    return remover;
}

void imprimir(Arranjo arranjo[]){
    printf("\n=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=\n§Lista: ");
	int x = L;
    while(arranjo[x].chave){
        printf("%i\t", arranjo[x].chave);
		x = arranjo[x].proximo;
    }
    printf("\n=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=\n");
}

int validar(char invalidado, int valido){
    char *fim;
	char aa[1];
	
	aa[0] = invalidado;

	int aux = strlen(aa);
    if(aux>9){
        printf("Valor muito grande!");
        return -999999999;
    }

    valido = strtol(aa, &fim, 10);

    if(fim == aa){
        printf("Valor inválido!\n");
        return -999999999;
    } else{
        return valido;
    }
}