package monopoly;

import java.util.ArrayList;

/* Classe Jogador: feita para descrever os jogadores de Banco Imobiliário.
 * - Atributos: id, dinheiro, nome, CPF, foto, email, contador (atributo de classe), cartas.
 * - Métodos:	getters e setters; prejuizo; lucro; associarPeca; adicionarCarta; removerCarta; toString().
 */

public class Jogador {
	private int id;
	private int dinheiro;
	private String nome;
	private String cpf;
	private String foto;
	private String email;
	ArrayList<Carta> cartas;
	Peca peca;
	private static int contador = 0;
	
	public Jogador(String nome, String cpf, String foto, String email) {
		super();
		this.id = contador;
		this.dinheiro = 2458; // conforme as regras do jogo :)
		this.nome = nome;
		this.cpf = cpf;
		this.foto = foto;
		this.email = email;
		this.cartas = new ArrayList<Carta>();
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
		if (ValidarDados.validarCPF(cpf)) {
			this.cpf = cpf;
		}
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
	
	public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	// ao invés de setDinheiro, considerei melhores as funções prejuizo/lucro
	public void prejuizo(int prejuizo) throws PlayerException {
		if (this.dinheiro < prejuizo) {
			throw new PlayerException();
		}	
		this.dinheiro -= prejuizo;
	}
	
	public void lucro(int lucro) {
		this.dinheiro += lucro;
	}
		
	public boolean associarPeca(Peca peca) {
		if (this.peca == null) {
			this.peca = peca;
			return true;
		}
		
		return false;
	}
	
	public boolean adicionarCarta(Carta carta) {
		carta.setDono(this);
		return cartas.add(carta);
	}
	
	// como remover carta seria usado em vendas de propriedade ou para retornar uma carta sorte ao tabuleiro:
	public Carta removerCarta(int id) {
		int index = -1;
		for (int i = 0; i < cartas.size(); i++) {
			if (cartas.get(i).getId() == id) {
				index = i;
				break;
			}
		}
		
		return cartas.remove(index);
	}
	
	@Override
	public String toString() {
		return "Jogador " + nome + "\n\tCPF: " + cpf + "\n\tFoto: " + foto + "\n\tEmail: " + email
				+ "\n\tDinheiro: " + dinheiro + "\n";
	}

}
