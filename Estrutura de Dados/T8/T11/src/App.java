public class App{
    public static void main(String[] args) throws Exception{

        Tree x = new Tree(); 
        x.insert_root(5);
        Node_Tree no_1 = new Node_Tree(4);
        Node_Tree no_2 = new Node_Tree(3);
        Node_Tree no_3 = new Node_Tree(7);
        Node_Tree no_4 = new Node_Tree(1);
        Node_Tree no_5 = new Node_Tree(2); 
        Node_Tree no_6 = new Node_Tree(8);
        Node_Tree no_7 = new Node_Tree(0);
        Node_Tree no_8 = new Node_Tree(6);
        Node_Tree no_9 = new Node_Tree(21);
        Node_Tree no_10 = new Node_Tree(12);

        /*
        Node_Tree no_10 = new Node_Tree(2); 
        Node_Tree no_11 = new Node_Tree(4);
        Node_Tree no_12 = new Node_Tree(3);
        Node_Tree no_13 = new Node_Tree(7);
        Node_Tree no_14 = new Node_Tree(1);
        Node_Tree no_15 = new Node_Tree(2); 
        */

        x.root.firstChild = no_1;
        no_1.parent = x.root; //4
        no_1.next = no_2;
        no_2.parent = x.root;//3
        no_2.next = no_3;
        no_3.parent = x.root;//7

        no_1.firstChild = no_4;//4
        no_4.parent = no_1;//1
        no_4.next = no_5;//next:2
        no_5.parent = no_1; //2 : pai :4

        no_2.firstChild = no_6; //3 : filho:8
        no_6.parent = no_2; //8
       
        no_3.firstChild = no_7; //7 filho 0
        no_7.parent = no_3;//0
        no_7.next = no_8;//0 : next:6
        no_5.parent = no_3; 

        no_6.firstChild = no_9;//8 filho 21
        no_9.parent = no_6;
        no_9.next = no_10;//irmão 12
        no_10.parent = no_6; 
       
        /*
        no_2.firstChild = no_4;
        no_4.parent = no_2;
        no_4.next = no_5;
        no_5.parent = no_2; 
        */

        x.root.imprimeFilhos();
        no_5.imprimeFilhos();
        no_6.imprimeFilhosFolhas();

        no_5.imprimeFilhos();
        no_8.imprime_Pai();
        no_8.dobraFilhos();
        no_2.dobraPai();
    }
}

/*
x.root.firstChild = no_1;
no_1.parent = x.root;
no_1.next = no_2;
no_2.parent = x.root;
no_2.next = no_3;
no_3.parent = x.root;
no_2.firstChild = no_4;
no_4.parent = no_2;
no_4.next = no_5;
no_5.parent = no_2; 
*/