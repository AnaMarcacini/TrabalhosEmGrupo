public class App{
    public static void main(String[] args) throws Exception{

        Arvore x = new Arvore(); 
        x.insert_root(0);
        ArvoreBinaria no1 = new ArvoreBinaria(1);
        ArvoreBinaria no2 = new ArvoreBinaria(2);
        ArvoreBinaria no3 = new ArvoreBinaria(3);
        ArvoreBinaria no4 = new ArvoreBinaria(4);
        ArvoreBinaria no5 = new ArvoreBinaria(5);
        ArvoreBinaria no6 = new ArvoreBinaria(6); 

        x.root.fi1 = no1;
        no1.anterior = x.root;

        x.root.fi2 = no2;
        no2.anterior = x.root;

        no2.fi1 = no3;
        no3.anterior = no2;

        no2.fi2 = no4;
        no4.anterior = no2;

        no3.fi1 = no5;
        no5.anterior = no3;

        no3.fi2 = no6;
        no6.anterior = no3;

        System.out.println("\nPre-Order");
        x.root.preOrder();

        System.out.println("\nPos-Order");
        x.root.posOrder();
        
        System.out.println("\nIn-Order");
        x.root.inOrder();

        x.root.dadoNaArvore(6);

        System.out.println("\nO maior valor é: "+x.root.maiorValor(-9999999));

        System.out.println("\nO menor valor é: "+x.root.menorValor(9999999));

        float[] y = x.root.medAri(new float[] {0,0});
        System.out.println("\nO valor médio é: "+ y[0]/y[1]);

        System.out.println("\nHá "+x.root.qntNull(0)+" Nulls na árvore");

        System.out.println("\nHá "+x.root.qntNos(0)+" Nós na árvore");

        System.out.println("\nHá "+x.root.qntFolhas(0)+" folhas na árvore");

        System.out.println("\nHá "+x.root.altura(0)+" níveis na árvore");
    }
}