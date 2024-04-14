package monopoly;

/* Classe Propriedade: representa as propriedades no Banco Imobiliário.
 * - Atributos: id, nome, proprietário, preço, aluguel, contador (atributo de classe)..
 * - Métodos:	getters e setters; calcularAluguel(); toString().
 */

public class Propriedade {
	private int id;
	private String nome;
	// tipo de variável modificada para facilitar a compra de propriedades (+ casas ou hotel) e pagamento de aluguel
	private Jogador proprietario; 
	private int preco;
	private int aluguel;
	private static int contador = 0;
	
	public Propriedade(String nome, Jogador proprietario, int preco, int aluguel) {
		super();
		this.id = contador;
		this.nome = nome;
		this.proprietario = proprietario;
		this.preco = preco;
		this.aluguel = aluguel;
		// aumenta o valor do contador (novo valor será o id da próxima propriedade adicionada)
		contador++;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Jogador getProprietario() {
		return proprietario;
	}
	
	public void setProprietario(Jogador proprietario) {
		this.proprietario = proprietario;
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
		return "Propriedade " + id + "\n\tNome: " + nome + "\n\tProprietario: " + ((proprietario == null) ? (proprietario) : (proprietario.getNome())) + "\n\tPreco: " + preco
				+ "\n\tAluguel: " + aluguel + "\n";
	}
	
	
	
}
