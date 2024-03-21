package lab1;

/* Classe Peca: feita para representar as peças dos jogadores de Banco Imobiliário.
 * - Atributos: cor (cor da peca); posicao (posicao da peca no tabuleiro)
 * - Métodos:	getters e setters, toString().
 */

public class Peca {
	private String cor;
	private int posicao;
	
	// construtor
	
	public Peca(String cor, int posicao) {
		super();
		this.cor = cor;
		this.posicao = posicao;
	}

	// getters e setters
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public int getPosicao() {
		return posicao;
	}
	
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	// toString()
	
	@Override
	public String toString() {
		return "Peca " + cor + "\n\tPosicao: " + posicao;
	}
	
	

}
