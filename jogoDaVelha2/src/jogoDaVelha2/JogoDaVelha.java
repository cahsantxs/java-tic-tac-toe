package jogoDaVelha2;
import java.util.Scanner;
public class JogoDaVelha {
	//A classe 'main' apenas chamará os métodos
	public static void main(String[] args) {
		try (Scanner ler = new Scanner(System.in)) {
			// Instanciar o objeto
			JV jogo = new JV();

			String posicao;
			//'Jogadas' será o contador das jogadas
			int valida = 0, Jogadas = 0;
			
			while(true) {			

				System.out.println("| # |JOGO DA VELHA | O |");
				System.out.println("\n");

				    //imprimir a matriz pelo método 'Mostrar' no objeto 'jogo'
					jogo.Mostrar();
				
					do { //inicia jogador 1 ---------------------------------------------------

						System.out.println("Jogador n°1, informe uma posição: ");
						posicao = ler.next();

						while(!jogo.Valido(posicao)) {

							System.out.println("Jogada inválida, tente novamente!");
							System.out.println("Jogador nº1, informe sua posição: ");
							posicao = ler.next();					
						}
						jogo.Jogada(posicao, "X"); //contém 2 parâmetros: Posição e Jogador
						valida = 1;

					}while(valida == 0); //Fim jogador 1
				
					Jogadas++;
					valida = 0;
					jogo.Mostrar();
					
					String vencedor = jogo.Ganhou(Jogadas);
					
		               if (vencedor != null) {
		                    System.out.println("O " + vencedor + " venceu!");
		                    break;
		               }

					do { //inicia jogador 2 --------------------------------------------------

						System.out.println("Jogador n°2, informe uma posição: ");
						posicao = ler.next();

						while(!jogo.Valido(posicao)) {

							System.out.println("Jogada inválida, tente novamente!");
							System.out.println("Jogador nº2, informe sua posição: ");
							posicao = ler.next();
						}
						jogo.Jogada(posicao, "O"); //contém 2 parâmetros: Posição e Jogador
						valida = 1;

					}while(valida == 0); //Fim jogador 2
					
					Jogadas++;
					valida = 0;
					jogo.Mostrar();

	                vencedor = jogo.Ganhou(Jogadas);
	                if (vencedor != null) {
	                    System.out.println("O " + vencedor + " venceu!");
	                    break;
				}
			} //--------------------------------------------------------------------------------
			
		}	
	}
}
