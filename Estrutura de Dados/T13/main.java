public class main {
	public static void main(String[] args){

		Integer[] tabChaves = new Integer[] {23, 45, 77, 11, 33, 49, 10, 4, 89, 14} ;
		Integer[] tabhash = new Integer[10];

		Integer coli = 0;
		Integer hashCode = null;
		for(int chave : tabChaves){
			hashCode = hash(chave);
			if(tabhash[hashCode] == null){
				tabhash[hashCode] = chave;
			} else{
				coli++;
				if(rehashing(tabhash, hashCode) == null){
					System.out.println("\n=============================================\n" + 
										"Tabela Hash está lotada, encerrando operação\n" +
										"=============================================\n");
					break;
				}
				tabhash[rehashing(tabhash, hashCode)] = chave;
			}
		}
		System.out.println("Colisões: " + coli);
		
		for (int i = 0 ; i < tabhash.length; i++){
			if(tabhash[i] == null){
				System.out.println("Slot " + i + " ---> Valor nulo");
				System.out.println("--------------------------");
			} else{
				System.out.print ("Slot " + i + " ---> " + tabhash[i] + '\n');
				System.out.println("--------------------------");
			}
		}
	}
	public static Integer hash(Integer key){
		// hash h = mod(n)
		return (key%10);
	}

	public static Integer rehashing(Integer[] tabhash, Integer indice) {
			for (Integer i = indice + 1 ; i < tabhash.length ; i ++) {
			if (tabhash[i] == null )
			return i;
		}
			for (Integer i = 0 ; i < indice ; i++ ) {
			if (tabhash[i] == null )
			return i;
		}
			return null;
	}
}
