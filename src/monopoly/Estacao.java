package monopoly;

/* Classe Estacao: representa um tipo de propriedade: a estacao.
 * - Atributos: id, nome, proprietário, preço, aluguel, contador (atributo de classe).
 * - Métodos:	getters e setters; calcularAluguel().
 */

public class Estacao extends Propriedade {

	public Estacao(String nome, Jogador proprietario, int preco, int aluguel) {
		super(nome, proprietario, preco, aluguel);
		
	}
	
	@Override
	public int calcularAluguel() {
		return this.getAluguel();
	}
}
