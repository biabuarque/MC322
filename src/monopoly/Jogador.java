package monopoly;

/* Classe Jogador: feita para descrever os jogadores de Banco Imobiliário.
 * - Atributos: id, dinheiro, nome, CPF, foto, email, contador (atributo de classe).
 * - Métodos:	getters e setters; prejuizo; lucro; toString().
 */

public class Jogador {
	private int id;
	private int dinheiro;
	private String nome;
	private String cpf;
	private String foto;
	private String email;
	private static int contador = 0;
	
	public Jogador(String nome, String cpf, String foto, String email) {
		super();
		this.id = contador;
		this.dinheiro = 2558000; // conforme as regras do jogo :)
		this.nome = nome;
		this.cpf = cpf;
		this.foto = foto;
		this.email = email;
		// aumenta o valor do contador (novo valor será o id do próximo jogador adicionado)
		contador++;
	}	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDinheiro() {
		return dinheiro;
	}
	
	// ao invés de setDinheiro, considerei melhores as funções prejuizo/lucro
	public void prejuizo(int prejuizo) {
		this.dinheiro -= prejuizo;
	}
	
	public void lucro(int lucro) {
		this.dinheiro += lucro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Jogador " + nome + "\n\tCPF: " + cpf + "\n\tFoto: " + foto + "\n\tEmail: " + email
				+ "\n\tDinheiro: " + dinheiro + "\n";
	}

}
