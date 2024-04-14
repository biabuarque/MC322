package monopoly;

/* Classe Tabuleiro: feita para representar o tabuleiro do jogode Banco Imobiliário.
 * - Atributos: jogadores (vetor de objetos Jogador), propriedades (vetor de objetos Propriedade).
 * - Métodos:	getters e setters; addJogador (adiciona um jogador ao jogo); 
 *   removeJogador (remove um jogador do jogo), addPropriedade e removePropriedade
 *   (simétricos de addJogador e removeJogador).
 */

import java.util.Scanner;

public class Tabuleiro {
	private Jogador[] jogadores; 
	private Propriedade[] propriedades;

	public Tabuleiro() {
		super();
		this.jogadores = new Jogador[6];
		this.propriedades = new Propriedade[28];
	}
	
	public Jogador[] getJogadores() {
		return jogadores;
	}

	public Propriedade[] getPropriedades() {
		return propriedades;
	}

	public boolean addJogador() {
		// REGRAS DO JOGO: o número máximo de jogadores é 6.
		if (jogadores[5] != null) {
			return false;
		}
		Scanner input = new Scanner(System.in);
		
		System.out.print("Adicione um jogador!"
				+ "\n\tNome: ");
		String nome = input.nextLine();
		
		String cpf, email;
		do {
			System.out.print("\n\tCPF: ");
			cpf = input.nextLine();
		} while(!ValidarDados.validarCPF(cpf));
		
		do {
			System.out.print("\n\tE-mail: ");
			email = input.nextLine();
		} while(!ValidarDados.validarEmail(email));
		
		System.out.print("\n\tLink para foto: ");
		String foto = input.nextLine();
		
		Jogador jog = new Jogador(nome, cpf, email, foto);
		jogadores[jog.getId()] = jog;
		
		return true;
	}
	
	public boolean removeJogador(int id) {
		if (jogadores[id] == null) {
			return false;
		}
		jogadores[id] = null;
		return true;
	}
	
	// LAB2: Por enquanto, preferi passar a propriedade como parâmetro.
	// TODO: entrada de dados p/ add propriedade!
	public boolean addPropriedade(Propriedade p) {
		// REGRAS DO JOGO: o número máximo de propriedades é 28.
		if (propriedades[p.getId()] != null || p.getId() > 27) {
			return false;
		}
		propriedades[p.getId()] = p;
		return true;
	}
	
	public boolean removePropriedade(int id) {
		if (propriedades[id] == null) {
			return false;
		}
		propriedades[id] = null;
		return true;
	}
}
