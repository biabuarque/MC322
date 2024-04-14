package monopoly;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Tabuleiro tab = new Tabuleiro();
		Scanner input = new Scanner(System.in);
		
		/* LAB2: todos os testes feitos no Main podem, futuramente, se tornar funcoes.
		 * Isto nao foi feito no LAB atual, tanto porque nao foi explicitamente requisitado,
		 * quanto porque, quando for, pode incluir mais detalhes ou funcionar diferentemente.
		 * Por enquanto, os testes foram feitos para garantir que as classes estao bem
		 * implementadas e prever futuras dificuldades no acesso seguro dos objetos do
		 * tabuleiro (o qual considero que seja apenas pelas funcoes getPropriedades
		 * e getJogadores). :)
		 */
		System.out.println("--------------------------------------------------------------------");
		// TESTANDO: adicionar carta sorte-revés
		CartaSorte livro = new CartaSorte(0, "Lancou um livro sobre astronautas. Grande sucesso de vendas!", 0, 1, 1000.00f, "Receba 1000", 0, null);
		System.out.println("Carta de Sorte adicionada! Seguem informacoes:\n"
				+ livro);
		
		System.out.println("--------------------------------------------------------------------");
		// TESTANDO: adicionar propriedades
		
		Terreno oscarfreire = new Terreno("Rua Oscar Freire", null, 3000, 180, 0, 2000,
				2500, false);
		if (tab.addPropriedade(oscarfreire)) {
			System.out.println("Propriedade adicionada! Seguem informacoes:\n"
					+ tab.getPropriedades()[0]);
		}
		
		ServicoPublico energia = new ServicoPublico("Companhia de Luz e Energia", null, 3000, 40);
		if (tab.addPropriedade(energia)) {
			System.out.println("Propriedade adicionada! Seguem informacoes:\n"
					+ tab.getPropriedades()[1]);
		}
		
		System.out.println("--------------------------------------------------------------------");
		// TESTANDO: adicionar jogador e peca
		if (tab.addJogador()) {
			System.out.println("Jogador adicionado! Seguem informacoes:\n"
					+ tab.getJogadores()[0]);
			Peca vermelha = new Peca("vermelho", 0);
			System.out.println("Peca adicionada! Seguem informacoes:\n"
					+ vermelha);
		}
		
		if (tab.addJogador()) {
			System.out.println("Jogador adicionado! Seguem informacoes:\n"
					+ tab.getJogadores()[1]);
			Peca azul = new Peca("azul", 0);
			System.out.println("Peca adicionada! Seguem informacoes:\n"
					+ azul);
		}

		System.out.println("--------------------------------------------------------------------");
		// TESTANDO: comprar propriedade
		tab.getPropriedades()[0].setProprietario(tab.getJogadores()[0]);
		tab.getJogadores()[0].prejuizo(tab.getPropriedades()[0].getPreco());
		System.out.println("Propriedade comprada! Veja os dados alterados: \n"
				+ tab.getPropriedades()[0] + "\n"
				+ tab.getJogadores()[0]);
		
		System.out.println("--------------------------------------------------------------------");
		/* TESTANDO: adicionar casas (como se pode ver, teríamos que usar "casting" com 
		 * ((tab.getPropriedades()[i].getClass()) para toda propriedade i de subclasse diferente...)
		 */
		
		((Terreno) tab.getPropriedades()[0]).comprarCasa();
		System.out.println("Casa comprada! Veja os dados alterados: \n"
				+ tab.getPropriedades()[0] + "\n"
				+ tab.getJogadores()[0]);
		
		// TESTANDO: pagamento de aluguel
		
		tab.getJogadores()[1].prejuizo(tab.getPropriedades()[0].getAluguel());
		tab.getJogadores()[0].lucro(tab.getPropriedades()[0].getAluguel());
		System.out.println("Aluguel pago! Veja os dados alterados: \n"
				+ tab.getJogadores()[0] + "\n"
				+ tab.getJogadores()[1]);
		
		input.close();
	}

}
