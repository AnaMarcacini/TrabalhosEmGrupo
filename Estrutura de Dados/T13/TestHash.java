public class TestHash{
	public static void main(String[] args){

		Slist[] tabKeys = new Slist[100000];
		Slist[] tabHash = new Slist[1000];

		tabKeys[1] = new Slist(21);
		tabKeys[2] = new Slist(22);
		tabKeys[3] = new Slist(24);
		tabKeys[4] = new Slist(35);
		tabKeys[5] = new Slist(60);
		tabKeys[6] = new Slist(44);
		tabKeys[7] = new Slist(57);
		tabKeys[8] = new Slist(80);
		tabKeys[9] = new Slist(90);
		tabKeys[10] = new Slist(10);

		Integer coli = 0;
		Integer hashCode = null, chave;
		for (int i=1; i<tabKeys.length; i++){
			if(tabKeys[i] != null){
				chave = (tabKeys[i].getCodAluno());
			} else{
				break;
			}
			hashCode = hash(chave);
			System.out.println("Chave = " + chave + " mapeada para hascode = " + hashCode);

			if(tabHash[hashCode] == null ){
				tabHash[hashCode] = tabKeys[i];
			} else{
				coli++;
				tabHash[hashCode].InsereInicio(chave);
				System.out.println("** Colisao no slot da Tabela Hash ** " );
				System.out.println("Chave " + tabKeys[i].getCodAluno() + " FOI ENCADEADA\n" );
			}
		}

		System.out.println("\nTabela Keys: ");
		System.out.println("--------------------------");
		for(int i = 1 ; i < tabKeys.length; i++){
			if(tabKeys[i] != null){
				System.out.print ("Slot " + i + " ---> " + tabKeys[i].getCodAluno() + '\n');
				System.out.println("--------------------------");
			} else{
				break;
			}
		}

		System.out.println("\nTabela HASH: ");
		System.out.println("--------------------------");

		for (int i = 0 ; i < tabHash.length; i++){
			if(tabHash[i] == null){
				System.out.println("Slot " + i + " ---> Valor nulo");
				System.out.println("--------------------------");
			} else{
				System.out.print ("Slot " + i + " ---> " + tabHash[i].getCodAluno() + '\n');
				if(tabHash[i].Colidido()){
					for(int j = 1 ; j < tabHash[i].tmnColi(); j++){
						System.out.println("\t|---" + tabHash[i].getColi()[j]);
					}
				}
				System.out.println("--------------------------");
			}
		}

		System.out.println("Colisões: " + coli);
	}
	public static Integer hash(Integer key){
		// hash h = mod(n)
		return (key%1000);
	}
}
