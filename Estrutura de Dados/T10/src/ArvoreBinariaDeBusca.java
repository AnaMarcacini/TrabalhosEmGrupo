public class ArvoreBinariaDeBusca{
	NoDaArvore origem;
	Integer tamanho;

	public ArvoreBinariaDeBusca(){
		origem = null;
		tamanho = 0;
	}

	public void insereOrigem(NoDaArvore no){
        NoDaArvore raiz = new NoDaArvore(no.chave);
        origem = raiz;
        tamanho = 1;
    }

	public void novoNo(Integer chave){
		NoDaArvore no;
		
		if(chave != null){
			no = new NoDaArvore(chave);
		} else{
			return;
		}

		if(origem == null){
			this.insereOrigem(no);
		} else{
			NoDaArvore aux = origem;
			while(aux != null){
				if(chave < aux.chave){
					if(aux.fi1 == null){
						aux.fi1 = no;
						no.antecessor = aux;
						break;
					} else{
						aux = aux.fi1;
					}
				} else if(chave > aux.chave){
					if(aux.fi2 == null){
						aux.fi2 = no;
						no.antecessor = aux;
						break;
					} else{
						aux = aux.fi2;
					}
				} else{
					break;
				}
			}
		}
	}

	public void taPresente(Integer chave, NoDaArvore aux){
		if(aux != null){
			if(chave == aux.chave){
				System.out.println("\nValor encontrado\n");
			} else if(chave > aux.chave){
				taPresente(chave, aux.fi2);
			} else if(chave < aux.chave){
				taPresente(chave, aux.fi1);
			}
		} else{
			System.out.println("\nValor "+chave+" não encontrado na árvore\n");
		}
	}

	public void maisMenor(NoDaArvore aux){
		while(aux.fi1 != null){
			aux = aux.fi1;
		}
		System.out.println("O menor valor da árvore é: "+aux.chave+"\n");
	}

	public Integer qntNos(NoDaArvore aux){
		Integer qnt = 1;
		if(aux.fi1 != null){
			qnt += qntNos(aux.fi1);
		}
		if(aux.fi2 != null){
			qnt += qntNos(aux.fi2);
		}
		return qnt;
	}

	public double medNos(NoDaArvore aux){
		Double med = Double.valueOf(aux.chave);;
		if(aux.fi1 != null){
			med += medNos(aux.fi1);
		}
		if(aux.fi2 != null){
			med += medNos(aux.fi2);
		}
		return med;
	}

	public int altArvore(NoDaArvore aux){
		Integer t = 1, t1 = 0, t2 = 0;
		if(aux.fi1 != null){
			t1 = altArvore(aux.fi1);
		}
		if(aux.fi2 != null){
			t2 =altArvore(aux.fi2);
		}
		if(t1 > t2){
			t += t1;
		} else{
			t += t2;
		}
		return t;
	}

	public int qntNull(NoDaArvore aux){
		Integer qnt = 0;
		if(aux == null){
			qnt++;
		} else{
			if(aux.fi1 != null){
				qnt += qntNull(aux.fi1);
			} else{
				qnt++;
			}
			if(aux.fi2 != null){
				qnt += qntNull(aux.fi2);
			} else{
				qnt++;
			}
		}
		return qnt;
	}

	public int mult2(NoDaArvore aux){
		Integer mults = 0;
		if((aux.chave % 2) == 0){
			mults++;
		}
		if(aux.fi1 != null){
			mults += mult2(aux.fi1);
		}
		if(aux.fi2 != null){
			mults += mult2(aux.fi2);
		}
		return mults;
	}

	public int somaTudo(NoDaArvore aux){
		Integer soma = 0;
		soma += aux.chave;
		if(aux.fi1 != null){
			soma += somaTudo(aux.fi1);
		}
		if(aux.fi2 != null){
			soma += somaTudo(aux.fi2);
		}
		return soma;
	}
}
