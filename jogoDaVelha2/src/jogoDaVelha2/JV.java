package jogoDaVelha2;
//Corpo da classe: Métodos
public class JV {

	/*Tabuleiro preenchido
	 O encapsulamento de dados será aplicado com a palavra reservada 'private'
	 pois não será diretamente utilizada pela classe 'main' */
	private String[][] m = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
	
	/*Método para mostrar a matriz do tipo 'public'
	  pois será visto pela outra classe*/
		public String Mostrar() {

		//varrer linha da matriz
		for (int li=0; li<3; li++) {

			//varrer coluna da matriz
			for (int co=0; co<3; co++) {
				//imprimir linha na coluna 
				System.out.printf("  " + m[li][co]);				
			}
			//quebra de linha 
			System.out.println("\n");
		}

		//deve haver um retorno para sanar o erro no código
		return null;
		
	}  //-------------------------------------------------------
		/*Método para verificar se a jogada é válida: 
		 Como o boolean será utilizado, é necessário criar 
		 um parâmetro da posiçãp da jogada dentro do método. No caso,'p' quer dizer 'posição'.*/
		
		public boolean Valido(String p) {
			for (int li=0;  li<3; li++) {
				for (int co=0; co<3; co++) {
					/*'.equals' é a melhor forma de comparar duas Strings. 
					'==' pode gerar erro no cód.*/
					if (m[li][co].equals(p)) 
						return true;
				}
		}

			return false;
	} //---------------------------------------------------------------------------
		/*Método que verifica a posição na matriz (de acordo com a escolha do jogador), 
		 e substitui o número da posição pelo símbolo. 
		 Como esse método não retornará nada, será 'public void'.*/
		
		public void Jogada(String p, String j) { //'j' de jogador 
			if (p.equals("1"))
				m[0][0] = j;
				else if (p.equals("2"))
					m[0][1] = j;
				else if (p.equals("3"))
					m[0][2] = j;
				else if (p.equals("4"))
					m[1][0] = j;
				else if (p.equals("5"))
					m[1][1] = j;
				else if (p.equals("6"))
					m[1][2] = j;
				else if (p.equals("7"))
					m[2][0] = j;
				else if (p.equals("8"))
					m[2][1] = j;
				else if (p.equals("9"))
					m[2][2] = j;

			} //---------------------------------------------------------------------------------
		/*Método que retornará o vencedor: ele deve saber o número de jogadas ja feitas,
		  pois o jogo acaba ao final das 9 jogadas. */
		public String Ganhou(int jogadas) {

			//vetor de 8 posições, porque há 8 possibilidades de vitória no jogo. 
			String[] T = new String[8];

			//inicializa-se nulo pois ainda não há vencedor.
			String vencedor = null;

			//se o jogo chegar a 9 jogadas, é porque não houve vencedor, já que todos os campos foram utilizados (9 campos).
			if (jogadas == 9) {
				vencedor = "EMPATE";
			}else {
				//linhas
				T[0] = m[0][0] + m[0][1] + m[0][2];
				T[1] = m[1][0] + m[1][1] + m[1][2];
				T[2] = m[2][0] + m[2][1] + m[2][2];
				//colunas
				T[3] = m[0][0] + m[1][0] + m[2][0];
				T[4] = m[0][1] + m[1][1] + m[2][1];
				T[5] = m[0][2] + m[1][2] + m[2][2];
				//diagonais
				T[6] = m[0][0] + m[1][1] + m[2][2];
				T[7] = m[0][2] + m[1][1] + m[2][0];
				//varrer vetor
				for (int i = 0; i < T.length; i++) {
					if (T[i].equals("XXX")) {
						vencedor = "Jogador 1"; 
						break;
					}else if (T[i].equals("OOO")) {
					vencedor = "Jogador 2";
					break;
					}	
				}			
		}
		return vencedor;	
	}
}

