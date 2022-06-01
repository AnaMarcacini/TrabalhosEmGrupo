/*
1
        a   ok
        b   ok
        c   ok
        d   ok
        e   falta
        f   ok
        g   ok
2
        a   
        b   
        c   
        d   
*/


public class Node_Tree {
    Integer item;
    Node_Tree parent;
    Node_Tree firstChild;
    Node_Tree next;
    public Node_Tree(Integer item) {
        this.item = item;
        this.parent = null;
        this.firstChild = null;
        this.next = null;
    }
//1a
    public void imprimeFilhos() {
        if (this.firstChild == null)
            System.out.println("Node nao tem filhos....");
        else {
            Node_Tree trab = this.firstChild;
            while (trab != null ) {
                System.out.println(trab.item);
                trab = trab.next;
                }
        }
    }
//1b
    public Node_Tree pai() {
        if (this.parent == null)
        return null;
        else return (this.parent );
        }

//1c
    public void imprime_Pai() {
        if (this.parent != null)
        System.out.println("Pai: " + this.parent.item );
        else
        System.out.println("Este nó é root, não tem pai...");
    } 
   //1d 
    public boolean ehInterno() {
        if (this.firstChild != null)
        return true;
        else return false;
        }







    //1f

    public void preorder() {
        System.out.println(this.item );
        Node_Tree trab = this.firstChild;
        while (trab != null ) {
            trab.preorder();
            trab = trab.next;
        }
    } 
    //1g

    public void posorder() {
        Node_Tree trab = this.firstChild;
        while (trab != null ) {
            trab.posorder();
            trab = trab.next;
        }
        System.out.println(this.item );
        } 











}
