public class Tree{
    Node_Tree root;
    int size;
    
    public Tree(){
        this.root = null;
        this.size = 0;
    }

    public void insert_root(Integer valor){
        Node_Tree node = new Node_Tree(valor);
        this.root = node;
        this.size = 1;
    }

    public Node_Tree getRoot(){
        return root;
    }

    public int getSize(){
        return size;
    }
}