package monopoly;

/* Classe Servico Publico: feita para representar um tipo de propriedade: aquelas do Estado
 * 							(em outras versões, companhias públicas ou privadas).
 * - Atributos: jogadores (vetor), propriedades (vetor).
 * - Métodos:	getters e setters; addJogador (adiciona um jogador ao jogo); 
 *   removeJogador (remove um jogador do jogo), addPropriedade e removePropriedade
 *   (simétricos de addJogador e removeJogador).
 */

public class ServicoPublico extends Propriedade {

	public ServicoPublico(String nome, Jogador proprietario, int preco, int aluguel) {
		super(nome, proprietario, preco, aluguel);

	}

	public int calcularAluguel(int dados) {
		int aluguel = this.getAluguel();
		return aluguel * (int)(dados / 2); // relação aluguel x dados criada para teste
	}
	
}
