package monopoly;

/* Classe Peca: feita para representar as peças dos jogadores de Banco Imobiliário.
 * - Atributos: cor (cor da peca); posicao (posicao da peca no tabuleiro)
 * - Métodos:	getters e setters, toString().
 */

public class Peca {
	private String cor;
	private int posicao;
	
	public Peca(String cor, int posicao) {
		super();
		this.cor = cor;
		this.posicao = posicao;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public int getPosicao() {
		return posicao;
	}
	
	public void andar(int casas) {
		this.posicao += casas;
		this.posicao %= 40;
	}
	
	@Override
	public String toString() {
		return "Peca " + cor + "\n\tPosicao: " + posicao + "\n";
	}
	
	

}
