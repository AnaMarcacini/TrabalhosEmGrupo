public class Slist{
	private Integer chave;
	private Integer[] coli = new Integer[1000];

	public Slist(Integer codAluno){
		this.chave = codAluno;
		InsereInicio(codAluno);
	}

	public Integer getCodAluno() {
		return chave;
	}

	public void InsereInicio(Integer coi){
		this.coli[tmnColi()] = coi;
	}

	public boolean Colidido(){
		if(this.coli[1] != null){
			return true;
		}
		return false;
	}

	public Integer[] getColi(){
		return coli;
	}

	public Integer tmnColi(){
		int i = 0;
		while(this.coli[i] != null){
			i++;
		}
		return i;
	}
}
