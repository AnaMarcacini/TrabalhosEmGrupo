public class ArvoreBinaria{
    Integer conteudo;
    ArvoreBinaria anterior;
    ArvoreBinaria fi1;
    ArvoreBinaria fi2;

    public ArvoreBinaria(Integer conteudo){
        this.conteudo = conteudo;
        this.anterior = null;
        this.fi1 = null;
        this.fi2 = null;
    }
	//2
	public void preOrder(){
		System.out.println(this.conteudo);

        if(this.fi1 != null){
			this.fi1.preOrder();
		}
		if(this.fi2 != null){
			this.fi2.preOrder();
		}
    } 
	//2
    public void posOrder(){
        if(this.fi1 != null){
			this.fi1.posOrder();
		}
		if(this.fi2 != null){
			this.fi2.posOrder();
		}

		System.out.println(this.conteudo);
    }
	//2
	public void InOrder(){
        if(this.fi1 != null){
            this.fi1.InOrder();
		}

        System.out.println(this.conteudo);

        if (this.fi2 != null){
            this.fi2.InOrder();
		}
    }
    //3
	public void dadoNaArvore(Integer k){
		if(this.conteudo == k){
			System.out.println("\nTem na Árvore");
			return;
		}
		if(this.fi1 != null){
			this.fi1.dadoNaArvore(k);
		}
		if(this.fi2 != null){
			this.fi2.dadoNaArvore(k);
		}
		//	System.out.println("\nNão tem na Árvore");
	}
	//4
	public void maiorValor(){
		Integer x = 0;
		if(this.conteudo > x){
			x = this.conteudo;
			System.out.println("\nO maior valor é: "+x);
		}
		this.fi1.maiorValor();
		this.fi2.maiorValor();
	}

	


    public void imprimeFilhos(){
        if (this.fi1 == null)
            System.out.println("O Node (" + this.conteudo + ") não tem filhos....");
        else{
            ArvoreBinaria trab = this.fi1;
            while (trab != null){
                System.out.println(trab.conteudo);
                trab = trab.fi2;
            }
        }
    }
    
    public ArvoreBinaria pai() {
        if (this.anterior == null)
            return null;
        else 
            return (this.anterior);
    }
    
    public void imprime_Pai(){
        if (this.anterior != null)
            System.out.println("Pai: " + this.anterior.conteudo);
        else
            System.out.println("Este nó (" + this.conteudo + ") é root, não tem pai...");
    } 
   
    public boolean ehInterno(){
        if (this.fi1 != null)
            return true;
        else 
            return false;
    }
    
    public void imprimeFilhosFolhas(){
        ArvoreBinaria trab = this.fi1;
        int i = 0;
        while (true){
            if (trab != null){
                if (trab.fi1 == null){
                    i++;
                    System.out.println("Filho-Folha " + i + ": " + trab.conteudo);
                }
                trab = trab.fi2;
            } else{
                break;
            }
        }
    }
    
    
    
    public ArvoreBinaria dobraFilhos(){
        if (this.fi1 != null){
            ArvoreBinaria trab = this.fi1;
            while (trab != null){
                trab.conteudo *= 2;
                trab = trab.fi2;
            }
        }
        return this;
    }
    
    public ArvoreBinaria dobraPai(){
        if (this.anterior != null){
            this.anterior.conteudo *= 2;
        }
        return this;
    } 
}