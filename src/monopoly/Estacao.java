package monopoly;

/* Classe Estacao: representa um tipo de propriedade: a estacao.
 * - Atributos: id, nome, proprietário, preço, aluguel, contador (atributo de classe).
 * - Métodos:	getters e setters; calcularAluguel().
 */

public class Estacao extends Propriedade {

	public Estacao(String descricao, Jogador dono, String nome, int preco, int aluguel) {
		super(descricao, dono, nome, preco, aluguel);
		
	}
	
	@Override
	public int calcularAluguel() {
		return this.getAluguel();
	}
}
