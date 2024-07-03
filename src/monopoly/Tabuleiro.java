package monopoly;

import java.util.ArrayList;
import java.util.Scanner;

public class Tabuleiro implements Salvavel{
	private ArrayList<Jogador> jogadores; 
	private ArrayList<Propriedade> propriedades;

	public Tabuleiro() {
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

	public void salvaLog(){
		// TODO
	}


	/* O método distribuirCartas() em Tabuleiro deve ser implementado conforme a lógica do jogo; */
	public void distribuirCartas(){
		if (propriedades.size() == 0) {
			System.out.println("Nao ha propriedades para distribuir cartas.");
			return;
		}
		else if (jogadores.size() == 0) {
			System.out.println("Nao ha jogadores para distribuir cartas.");
			return;
		}
		else if (jogadores.size() > propriedades.size()) {
			System.out.println("Ha mais jogadores do que propriedades.");
			return;
		}
		for (int i = 0; i < jogadores.size(); i++) {
			jogadores.get(i).adicionarCarta(propriedades.get(i));
		}
	}
}
