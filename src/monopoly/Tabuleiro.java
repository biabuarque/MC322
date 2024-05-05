package monopoly;

import java.util.ArrayList;

/* Classe Tabuleiro: feita para representar o tabuleiro do jogode Banco Imobiliário.
 * - Atributos: jogadores (vetor de objetos Jogador), propriedades (vetor de objetos Propriedade).
 * - Métodos:	getters e setters; addJogador (adiciona um jogador ao jogo); 
 *   removeJogador (remove um jogador do jogo), addPropriedade e removePropriedade
 *   (simétricos de addJogador e removeJogador).
 */

import java.util.Scanner;

public class Tabuleiro {
	private ArrayList<Jogador> jogadores; 
	private ArrayList<Propriedade> propriedades;

	public Tabuleiro() {
		super();
		this.jogadores = new ArrayList<Jogador>();
		this.propriedades = new ArrayList<Propriedade>();
	}
	
	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	public ArrayList<Propriedade> getPropriedades() {
		return propriedades;
	}

	public boolean addJogador() {
		// REGRAS DO JOGO: o número máximo de jogadores é 6.
		if (jogadores.size() == 6) {
			return false;
		}
		Scanner input = new Scanner(System.in);
		
		System.out.print("Adicione um jogador!"
				+ "\n\tNome: ");
		String nome = input.nextLine();
		
		String cpf, email;
		do {
			System.out.print("\n\tCPF (válido): ");
			cpf = input.nextLine();
		} while(!ValidarDados.validarCPF(cpf));
		
		do {
			System.out.print("\n\tE-mail (válido): ");
			email = input.nextLine();
		} while(!ValidarDados.validarEmail(email));
		
		System.out.print("\n\tLink para foto: ");
		String foto = input.nextLine();
		
		Jogador jog = new Jogador(nome, cpf, foto, email);
		
		System.out.print("\n\tCor da peca: ");
		String cor = input.nextLine();
		
		Peca peca = new Peca(cor, 0);
		jog.associarPeca(peca);
		
		return jogadores.add(jog);
	}
	
	public boolean removeJogador(int id) {
		return jogadores.remove(jogadores.get(id));
	}
	
	// LAB2: Por enquanto, preferi passar a propriedade como parâmetro.
	// TODO: entrada de dados p/ add propriedade!
	public boolean addPropriedade(Propriedade p) {
		// REGRAS DO JOGO: o número máximo de propriedades é 28.
		return propriedades.add(p);
	}
	
	public boolean removePropriedade(int id) {
		int index = -1;
		for (int i = 0; i < propriedades.size(); i++) {
			if (propriedades.get(i).getId() == id) {
				index = i;
				break;
			}
		}
		
		return propriedades.remove(propriedades.get(index));
	}
}
