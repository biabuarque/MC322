package monopoly;

/* Classe Servico Publico: feita para representar um tipo de propriedade: aquelas do Estado
 * 							(em outras versões, companhias públicas ou privadas).
 * - Atributos: herdados de Propriedade.
 * - Métodos:	getters e setters; calcularAluguel().
 */

public class ServicoPublico extends Propriedade {

	public ServicoPublico(String descricao, Jogador dono, String nome, int preco, int aluguel) {
		super(descricao, dono, nome, preco, aluguel);
		
	}

	public int calcularAluguel(int dados) {
		int aluguel = this.getAluguel();
		return aluguel * (int)(dados / 2); // relação aluguel x dados criada para teste
	}
	
}
