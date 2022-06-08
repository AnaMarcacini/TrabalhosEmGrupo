public class Node_Tree{
    Integer item;
    Node_Tree parent;
    Node_Tree firstChild;
    Node_Tree next;

    public Node_Tree(Integer item){
        this.item = item;
        this.parent = null;
        this.firstChild = null;
        this.next = null;
    }
    //1a
    public void imprimeFilhos(){
        if (this.firstChild == null)
            System.out.println("O Node (" + this.item + ") não tem filhos....");
        else{
            Node_Tree trab = this.firstChild;
            while (trab != null){
                System.out.println(trab.item);
                trab = trab.next;
            }
        }
    }
    //1b
    public Node_Tree pai() {
        if (this.parent == null)
            return null;
        else 
            return (this.parent);
    }
    //1c
    public void imprime_Pai(){
        if (this.parent != null)
            System.out.println("Pai: " + this.parent.item);
        else
            System.out.println("Este nó (" + this.item + ") é root, não tem pai...");
    } 
    //1d 
    public boolean ehInterno(){
        if (this.firstChild != null)
            return true;
        else 
            return false;
    }
    //1e
    public void imprimeFilhosFolhas(){
        Node_Tree trab = this.firstChild;
        int i = 0;
        while (true){
            if (trab != null){
                if (trab.firstChild == null){
                    i++;
                    System.out.println("Filho-Folha " + i + ": " + trab.item);
                }
                trab = trab.next;
            } else{
                break;
            }
        }
    }
    //1f
    public void preorder(){
        System.out.println(this.item );
        Node_Tree trab = this.firstChild;
        while (trab != null){
            trab.preorder();
            trab = trab.next;
        }
    } 
    //1g
    public void posorder(){
        Node_Tree trab = this.firstChild;
        while (trab != null){
            trab.posorder();
            trab = trab.next;
        }
        System.out.println(this.item );
    }
    //2c
    public Node_Tree dobraFilhos(){
        if (this.firstChild != null){
            Node_Tree trab = this.firstChild;
            while (trab != null){
                trab.item *= 2;
                trab = trab.next;
            }
        }
        return this;
    }
    //2d
    public Node_Tree dobraPai(){
        if (this.parent != null){
            this.parent.item *= 2;
        }
        return this;
    } 
}