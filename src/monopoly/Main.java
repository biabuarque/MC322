package monopoly;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		menu();
	}
	
	public static int menu(){
		Scanner input = new Scanner(System.in);
		int opt;
		System.out.println("Bem Vindo ao Banco Imobiliario!"
				+ "\n\t Deseja comecar um novo jogo?"
				+ "\n\t\t (1) Sim (2) Nao");
		opt = input.nextInt();
		if (opt == 2) {
			input.close();
			return 0;
		}
		
		Tabuleiro tabuleiro = new Tabuleiro();
		ArrayList<Carta> totalCartas= new ArrayList<Carta>();
		System.out.println("Novo tabuleiro criado.");
		do {
			System.out.println("Escolha uma opcao"
					+ "\n\t(1) Jogadores"
					+ "\n\t(2) Cartas"
					+ "\n\t(3) Acoes" 
					+ "\n\t(4) Sair");
			opt = input.nextInt();
			switch (opt) {
			case 1: // Jogadores
				menuJogadores(tabuleiro);
				break;
			case 2: // Cartas
				menuCartas(tabuleiro, totalCartas);
				break;
			case 3: // Ações
				menuAcoes(tabuleiro, totalCartas);
				break;
			case 4: // Sair
				System.out.println("Ate logo! :)");
			}
		} while(opt != 4);
		
		input.close();
		return 0;
	}
	
	public static int menuJogadores(Tabuleiro tab) {
		Scanner input = new Scanner (System.in);
		int opt;
		do {
		System.out.println("Escolha uma opcao"
				+ "\n\t(1) Adicionar Jogador"
				+ "\n\t(2) Editar Jogador"
				+ "\n\t(3) Remover Jogador" 
				+ "\n\t(4) Voltar");
		opt = input.nextInt();
			switch (opt) {
			
			case 1: // Adicionar Jogador
				boolean verificador = tab.addJogador();
				if (verificador) {
					System.out.println("\nJogador adicionado! :)\n\t" + tab.getJogadores().get(tab.getJogadores().size() - 1));
				}
				else {
					System.out.println("Algo deu errado :( Verifique se o numero maximo foi atingido.\nTente Novamente!");
				}
				break;
			
			case 2: // Editar Jogador
				System.out.println("Qual jogador você deseja editar?\n");
				for (int i = 0; i < tab.getJogadores().size(); i++) {
					System.out.println("\t(" + i + ")" + tab.getJogadores().get(i).getNome() + "\n");
				}
				int idEdit = input.nextInt();
				System.out.println("O que você deseja editar?"
						+ "\n\t(1) Nome " + tab.getJogadores().get(idEdit).getNome()
						+ "\n\t(2) E-mail " + tab.getJogadores().get(idEdit).getEmail()
						+ "\n\t(3) CPF " + tab.getJogadores().get(idEdit).getCpf()
						+ "\n\t(4) Foto " + tab.getJogadores().get(idEdit).getFoto()
						+ "\n\t(5) Voltar");
				int edit = input.nextInt();
				switch (edit) {
					case 1: // Nome
						System.out.println("Digite o novo nome:");
						tab.getJogadores().get(idEdit).setNome(input.nextLine());
						break;
					case 2: // E-mail
						System.out.println("Digite o novo e-mail:");
						tab.getJogadores().get(idEdit).setEmail(input.nextLine());
						break;
					case 3: // CPF
						System.out.println("Digite o novo CPF:");
						tab.getJogadores().get(idEdit).setCpf(input.nextLine());
						break;
					case 4: // Foto
						System.out.println("Digite a nova foto:");
						tab.getJogadores().get(idEdit).setFoto(input.nextLine());
						break;
					case 5: // Voltar
						break;
				}
				break;
			case 3: // Remover Jogador
				System.out.println("Qual jogador você deseja remover?\n");
				for (int i = 0; i < tab.getJogadores().size(); i++) {
					System.out.println("\t(" + i + ")" + tab.getJogadores().get(i).getNome() + "\n");
				}
				int idRemocao = input.nextInt();
				System.out.println("Jogador removido!\n" + tab.removeJogador(idRemocao));
				
				break;
			case 4: // Voltar
				break;
			}
		} while (opt != 4);
		return 0;
	}
	
	public static int menuCartas(Tabuleiro tab, ArrayList<Carta> cartas) {
		Scanner input = new Scanner (System.in);
		int opt;
		do {
			System.out.println("Escolha uma opcao"
					+ "\n\t(1) Adicionar Carta"
					+ "\n\t(2) Remover Carta"
					+ "\n\t(3) Voltar");
			opt = input.nextInt();
				switch (opt) {
					case 1: // Adicionar Carta
						System.out.println("Qual o tipo da carta?"
								+ "\n\t(1) Sorte-Reves"
								+ "\n\t(2) Propriedade"
								+ "\n\t(3) Cancelar");
						int optCarta = input.nextInt();
						input.nextLine();
						
						if (optCarta == 3) {
							break;
						}
						
						Propriedade prop;
						System.out.println("\n\tDescricao: "); // comum a ambas
						String descricao = input.nextLine();
						
						if (optCarta == 1) { // Sorte-Revés
							System.out.println("\n\tMovimento (casas):");
							int movimento = input.nextInt();
							System.out.println("\n\tEfeito:"
									+ "\n\t\t(-1) Negativo"
									+ "\n\t\t(0) Neutro"
									+ "\n\t\t(1) Positivo");
							int efeito = input.nextInt();
							System.out.println("\n\tValor de pagamento/recebimento: ");
							float valor = input.nextFloat();
							input.nextLine();
							System.out.println("\n\tAcao especifica: ");
							String acao = input.nextLine();
							System.out.println("\n\tTempo de aplicacao (rodadas): ");
							int tempo = input.nextInt();
							input.nextLine();
							System.out.println("\n\tRestricoes de uso: ");
							String restricao = input.nextLine();
							CartaSorte carta = new CartaSorte(descricao, null, movimento, efeito, valor, acao, tempo, restricao);
							cartas.add(carta);
							
							System.out.println("Carta adicionada!\n" + carta);
						}
						
						else if (optCarta == 2) {
							System.out.println("Qual o tipo da carta?"
									+ "\n\t(1) Terreno"
									+ "\n\t(2) Servico Publico"
									+ "\n\t(3) Estacao"
									+ "\n\t (4) Cancelar");
							int optProp = input.nextInt();
							input.nextLine();
							if (optProp == 4) {
								break;
							}
							else {
								System.out.println("\n\tNome:");
								String nome = input.nextLine();
								System.out.println("\n\tPreco:");
								int preco = input.nextInt();
								System.out.println("\n\tAluguel:");
								int aluguel = input.nextInt();
								if (optProp == 1) {
									System.out.println("\n\tPreco de uma casa:");
									int valorCasa = input.nextInt();
									System.out.println("\n\tPreco de um hotel:");
									int valorHotel = input.nextInt();
								prop = new Terreno(descricao, null, nome, preco, aluguel, 0, valorCasa, valorHotel, false);
								}
								else if (optProp == 2) {
									prop = new ServicoPublico(descricao, null, nome, preco, aluguel);
								}
								else {
									prop = new Estacao(descricao, null, nome, preco, aluguel);
								}
							}
							cartas.add(prop);
							tab.getPropriedades().add(prop);
							System.out.println("Carta adicionada!\n" + prop);
						}
						break;
					case 2: // Remover Carta
						System.out.println("Qual carta você deseja remover?\n");
						for (int i = 0; i < cartas.size(); i++) {
							System.out.println("\t(" + i + ")" + cartas.get(i).getDescricao() + "\n");
						}
						int idRemocao = input.nextInt();
						Carta cartaRemocao = cartas.remove(idRemocao);
						System.out.println("Carta removida!\n" + cartaRemocao);
						if (tab.getPropriedades().contains(cartaRemocao)) {
							tab.removePropriedade(idRemocao);
						}
						break;
					case 3: // Voltar
						break;
				}
		} while (opt != 3);
		return 0;
	}
	
	public static int menuAcoes(Tabuleiro tab, ArrayList<Carta> cartas) {
		Scanner input = new Scanner (System.in);
		System.out.println("Qual jogador ira agir?\n");
		for (int i = 0; i < tab.getJogadores().size(); i++) {
			System.out.println("\t(" + i + ")" + tab.getJogadores().get(i).getNome() + "\n");
		}
		int idJogador = input.nextInt();
		Jogador jog = tab.getJogadores().get(idJogador);
		int opt;
		do {
			System.out.println("Escolha uma opcao"
					+ "\n\t(1) Andar"
					+ "\n\t(2) Cobrar aluguel"
					+ "\n\t(3) Melhorar terreno"
					+ "\n\t(4) Pegar carta"
					+ "\n\t(5) Voltar");
			opt = input.nextInt();
				switch (opt) {
				case 1: //Andar
					System.out.println("Quantas casas?");
					int casas = input.nextInt();
					tab.getJogadores().get(idJogador).getPeca().andar(casas);
					break;
				case 2: //Cobrar aluguel
					System.out.println("Qual aluguel?\n");
					for (int i = 0; i < jog.getCartas().size() && jog.getCartas().get(i) instanceof Propriedade; i++) {
						System.out.println("\t(" + i + ")" + ((Propriedade)jog.getCartas().get(i)).getNome() + " R$" + ((Propriedade)jog.getCartas().get(i)).calcularAluguel() + "\n");
					}
					int idProp = input.nextInt();
					Propriedade prop = (Propriedade)jog.getCartas().get(idProp);
					System.out.println("De qual jogador?\n");
					for (int i = 0; i < tab.getJogadores().size(); i++) {
						System.out.println("\t(" + i + ")" + tab.getJogadores().get(i).getNome() + "\n");
					}
					int idCobrado = input.nextInt();
					Jogador cobrado = tab.getJogadores().get(idCobrado);
					
					cobrado.prejuizo(prop.calcularAluguel());
					jog.lucro(prop.calcularAluguel());
					
					break;
					
				case 3: //Melhorar terreno
					System.out.println("Qual terreno?\n");
					for (int i = 0; i < jog.getCartas().size() && jog.getCartas().get(i) instanceof Terreno; i++) {
						System.out.println("\t(" + i + ")" + tab.getPropriedades().get(i).getNome() + " R$" + tab.getPropriedades().get(i).calcularAluguel() + "\n");
					}
					int idTerreno = input.nextInt();
					Terreno terreno = (Terreno)jog.getCartas().get(idTerreno);
					System.out.println("Escolha uma opcao"
							+ "\n\t(1) Comprar casa"
							+ "\n\t(2) Cobrar hotel"
							+ "\n\t(3) Voltar");
					int optTerreno = input.nextInt();
					
					if (optTerreno == 1) {
						if (terreno.comprarCasa()) {
							System.out.println("Casa comprada!\n" + terreno);
						}
						else {
							System.out.println("Falha na compra :( Verifique se a qtd. maxima de casas foi atingida!");
						}
					}
					else if (optTerreno == 2) {
						if (terreno.comprarHotel()) {
							System.out.println("Hotel comprado!\n" + terreno);
						}
						else {
							System.out.println("Falha na compra :( Verifique se o terreno tem 4 casas ou se já possui hotel!");
						}
						
					}
					break;
				case 4: //Pegar carta
					for (int i = 0; i < cartas.size(); i++) {
						if (cartas.get(i).getDono() == null) {
							jog.adicionarCarta(cartas.get(i));
							System.out.println("Carta adicionada ao baralho do jogador:" + cartas.get(i));
							// por enquanto, deixei para que, se for uma carta sorte-revés, o jogador faça as mudanças manualmente
							break;
						}
						System.out.println("Pilha de cartas esgotada!");
					}
					break;
				case 5: //Voltar
					break;
				}
		} while (opt!= 5);
		return 0;
	}

}
