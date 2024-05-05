package monopoly;

/* Classe Propriedade: representa as propriedades no Banco Imobiliário.
 * - Atributos: id, nome, proprietário, preço, aluguel, contador (atributo de classe)..
 * - Métodos:	getters e setters; calcularAluguel(); toString().
 */

public class Propriedade extends Carta{
	private String nome;
	private int preco;
	private int aluguel;
	
	public Propriedade(String descricao, Jogador dono, String nome, int preco, int aluguel) {
		super(descricao, dono);
		this.nome = nome;
		this.preco = preco;
		this.aluguel = aluguel;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getPreco() {
		return preco;
	}
	
	public void setPreco(int preco) {
		this.preco = preco;
	}
	
	public int getAluguel() {
		return aluguel;
	}
	
	public void setAluguel(int aluguel) {
		this.aluguel = aluguel;
	}
	
	public int calcularAluguel() {
		// REGRAS DO JOGO: caso a propriedade não seja especificada, o valor do aluguel é o que consta na carta.
		return aluguel;
	}

	@Override
	public String toString() {
		return "Propriedade " + this.getId() + "\n\tDescricao: " + this.getDescricao() + "\n\tDono: " + "\n\tDono: " + ((this.getDono() == null) ? (this.getDono()) : (this.getDono().getNome())) + "\n\tNome: " + nome + "\n\tPreco: " + preco
				+ "\n\tAluguel: " + aluguel + "\n";
	}
	
	
	
}
