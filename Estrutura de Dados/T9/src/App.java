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

        //1
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

        //2
        /*
        System.out.println("\nPre-Order");
        x.root.preOrder();

        System.out.println("\nPos-Order");
        x.root.posOrder();
        
        System.out.println("\nIn-Order");
        x.root.InOrder();
        */

        //3
        x.root.dadoNaArvore(9);

        x.root.maiorValor();
    }
}