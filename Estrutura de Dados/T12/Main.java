import java.util.Random;

public class Main{
	private static final int qnt = 9; // qntanho do vetor a ser criado
	public static void main(String[] args) throws Exception{

		Random alet = new Random();
		int[] vetorDesordenado = new int[qnt];
		String retorno = "[";

		// Números aleatórios para o vetor
		for(int i = 0; i < qnt; i++){
			vetorDesordenado[i] = alet.nextInt(100);
		}
		
		// Enfeitando a saída
        for(int valor : vetorDesordenado){
			if(vetorDesordenado[qnt-1] != valor){
				retorno += String.format("%02d ", valor);
			} else{
				retorno += String.format("%02d]", valor);
			}
        }

		System.out.println("Vetor desordenado:\t"+retorno);

        Heapsort.heapsort(vetorDesordenado); // Chama a função de ordenação
        
		retorno = "[";
        // Enfeitando a saída
        for(int valor : vetorDesordenado){
			if(vetorDesordenado[qnt-1] != valor){
				retorno += String.format("%02d ", valor);
			} else{
				retorno += String.format("%02d]", valor);
			}
        }
        
        System.out.println("Vetor ordenado:\t\t"+retorno);
    }
}
