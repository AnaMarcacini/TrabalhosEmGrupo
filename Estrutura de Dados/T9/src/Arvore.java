public class Arvore{
    ArvoreBinaria root;
    int size;
    
    public Arvore(){
        this.root = null;
        this.size = 0;
    }

    public void insert_root(Integer valor){
        ArvoreBinaria node = new ArvoreBinaria(valor);
        this.root = node;
        this.size = 1;
    }

    public ArvoreBinaria getRoot(){
        return root;
    }

    public int getSize(){
        return size;
    }
}