public class App{
    public static void main(String[] args) throws Exception{
        ArvoreBinariaDeBusca arvore = new ArvoreBinariaDeBusca();

        //1
        int[] array = {3,7,8,9,10,5};
        for(int chave : array){
            arvore.novoNo(chave);
        }

        final NoDaArvore primordial = arvore.origem;

        //2
        int k = 2;
        arvore.novoNo(k);

        //3
        System.out.println("PreOrder\n");
        arvore.origem.preOrder();

        //4
        System.out.println("\nPosOrder\n");
        arvore.origem.posOrder();

        //5
        System.out.println("\nInOrder\n");
        arvore.origem.inOrder();

        //6
        int K = 6;
        arvore.taPresente(K, primordial);
        
        //7
        arvore.maisMenor(primordial);

        //8
        Integer qntDeNos = arvore.qntNos(primordial);
        System.out.println("A árvore tem "+qntDeNos+" nós criados\n");

        //9
        double media = arvore.medNos(primordial)/qntDeNos;
        System.out.println("A média dos valores da árvore é: "+media+"\n");

        //10
        System.out.println("A árvore tem tamanho de "+(arvore.altArvore(primordial)-1)+"\n");

        //11
        System.out.println("A ávore possui "+arvore.qntNull(primordial)+" folhas (nulls)\n");

        //12
        System.out.println("Há "+arvore.mult2(primordial)+" valores na árvore que são divisíveis por 2\n");

        //13
        System.out.println("A soma de todos os elementos da árvore é: "+arvore.somaTudo(primordial)+"\n");
    }
}
