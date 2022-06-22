public class NoDaArvore{
	Integer chave;
	NoDaArvore antecessor;
	NoDaArvore fi1;
	NoDaArvore fi2;

	public NoDaArvore(Integer chave){
		this.chave = chave;
		this.antecessor = null;
		this.fi1 = null;
		this.fi2 = null;
	}

	public void preOrder(){
		System.out.println(this.chave);

		if(this.fi1 != null){
			this.fi1.preOrder();
		}
		if(this.fi2 != null){
			this.fi2.preOrder();
		}
	}

	public void posOrder(){
        if(this.fi1 != null){
			this.fi1.posOrder();
		}
		if(this.fi2 != null){
			this.fi2.posOrder();
		}

		System.out.println(this.chave);
    }

	public void inOrder(){
        if(this.fi1 != null){
            this.fi1.inOrder();
		}

        System.out.println(this.chave);

        if (this.fi2 != null){
            this.fi2.inOrder();
		}
    }
}
