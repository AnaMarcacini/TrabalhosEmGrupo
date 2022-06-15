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
	public void inOrder(){
        if(this.fi1 != null){
            this.fi1.inOrder();
		}

        System.out.println(this.conteudo);

        if (this.fi2 != null){
            this.fi2.inOrder();
		}
    }
    //3
	public void dadoNaArvore(Integer k){
        ArvoreBinaria aux = this;
		if(aux.conteudo == k){
			System.out.println("\nTem na Árvore");
			return;
		}
		if(aux.fi1 != null){
			aux.fi1.dadoNaArvore(k);
		}
		if(aux.fi2 != null){
			aux.fi2.dadoNaArvore(k);
		}
		//	System.out.println("\nNão tem na Árvore");
	}
	//4
	public int maiorValor(int x){
        if(this.conteudo > x){
            x = this.conteudo;
        }
        if(this.fi1 != null){
            x = this.fi1.maiorValor(x);
        }
        if(this.fi2 != null){
            x = this.fi2.maiorValor(x);
        }

        return x;
	}
    //5
    public int menorValor(int x){
        if(this.conteudo < x){
            x = this.conteudo;
        }
        if(this.fi1 != null){
            x = this.fi1.menorValor(x);
        }
        if(this.fi2 != null){
            x = this.fi2.menorValor(x);
        }
        return x;
	}
    //6
    public float[] medAri(float x[]){
        x[0] += this.conteudo;
        x[1]++;

        if(this.fi1 != null){
            x = this.fi1.medAri(x);
        }
        if(this.fi2 != null){
            x = this.fi2.medAri(x);
        }
        return x;
	}
    //7
    public int qntNull(int x){
        if(this.fi1 != null){
            x = this.fi1.qntNull(x);
        } else{
            x++;
        }
        if(this.fi2 != null){
            x = this.fi2.qntNull(x);
        } else{
            x++;
        }
        return x;
	}
    //8
    public int qntNos(int x){
        if(this != null){
            x++;
        }

        if(this.fi1 != null){
            x = this.fi1.qntNos(x);
        }
            
        if(this.fi2 != null){
            x = this.fi2.qntNos(x);
        }

        return x;
	}
    //9
    public int qntFolhas(int x){
        if(this.fi1 == null && this.fi2 == null){
            x++;
        }

        if(this.fi1 != null){
            x = this.fi1.qntFolhas(x);
        }
            
        if(this.fi2 != null){
            x = this.fi2.qntFolhas(x);
        }

        return x;
	}
    //10
    public int altura(int x){
        if(this.fi1 != null || this.fi2 != null){
            x++;
        }

        if(this.fi1 != null){
            x = this.fi1.altura(x);
        }
            
        if(this.fi2 != null){
            x = this.fi2.altura(x);
        }

        return x;
	}
}