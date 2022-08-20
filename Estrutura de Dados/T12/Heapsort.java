public class Heapsort{
    // Declarando de variáveis globais
    private static int tam;
    private static int[] vetor;
	
    public static void heapsort(int[] vet){
        vetor = vet;          		// vetor recebe outro vetor
        tam = vetor.length - 1;     // tamanho do vetor
        
        criaHeap();
        
        // Loop que troca o valor do topo com o valor da última posição da Heap
        for (int i = tam; i > 0; i--){
            troca(0, tam);		// Troca a posição
            tam -= 1;				// Diminui tam para as próximas iterações
            ordenaHeap(0);	// necessário fazer heap novamente
        }
    }

    private static void criaHeap(){
        // Último elemento da penúltima se encontra bem no meio do vetor tam/2:
        int meio = (int) (tam/2);
        
        // Para cada elemento do penúltimo nível encontra o maior elemento e coloca como ancestral
        for (int i = (meio - 1); i >= 0; i--){
            ordenaHeap(i);
        }
    }
    
    // Função de troca de posição dos valores
    private static void troca(int i, int j){
        int aux;

        aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;
    }
    
    // Compara os valores do Heap e coloca como ancestral o maior
    private static void ordenaHeap(int ancestral){
        int maior = ancestral,            // O maior elemento é o ancestral
            esquerda = 2 * ancestral + 1, // posição do filho da esquerda
            direita = 2 * ancestral + 2;  // posição do filho da direita
        
        // Se o filho da esquerda existe e é maior que o ancestral
        if (esquerda <= tam && vetor[esquerda] > vetor[maior]){
            maior = esquerda;
		}
        
        // Se o filho da esquerda existe e é maior que o ancestral e o filho esquerdo
        if (direita <= tam && vetor[direita] > vetor[maior]){
            maior = direita;
		}

        // Se ao chegar até aqui o ancestral deixou de ser o maior valor
        if (maior != ancestral){
            troca(ancestral, maior);      // Troca de posição
            ordenaHeap(maior);    // Continua o heap com o valor trocado
        }
    }
}