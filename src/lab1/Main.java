package lab1;

public class Main {
	
	public static void main(String[] args) {
		// instanciando objetos...
		CartaSorte carta_indenizacao = new CartaSorte(56, "Indenizacao", 0, 1, 200, "", 0, "");
		Peca peca1 = new Peca("vermelha", 0);
		Jogador bia = new Jogador("Beatriz", "08152676306", "https://www.instagram.com/p/C3BsNmUt8sV/", "silvabuarqueb@gmail.com");
		Jogador lulu = new Jogador("Luiza", "08492013957", "https://www.instagram.com/p/C0ePQEELmbj/", "luluabc.com.br");
		
		System.out.println("Carta de Sorte ###\n" + carta_indenizacao.toString() + "\n");
		System.out.println("Peca ###\n" + peca1.toString() + "\n");
		
		// testando e-mails e CPFs válidos (não me afiliem a partido, por favor! hahaha)
		System.out.println("Jogador 1 ###\n" + bia.toString());
		System.out.println("\tCPF de " + bia.getNome() + " valido? " + ((bia.validarCPF())? "Sim" : "Não"));
		System.out.println("\tEmail de " + bia.getNome() + " valido? " + ((bia.validarEmail())? "Sim" : "Não") + "\n");
		// testando e-mails e CPFs inválidos
		System.out.println("Jogador 2 ###\n" + lulu.toString());
		System.out.println("\tCPF de " + lulu.getNome() + " valido? " + ((lulu.validarCPF())? "Sim" : "Não"));
		System.out.println("\tEmail de " + lulu.getNome() + " valido? " + ((lulu.validarEmail())? "Sim" : "Não") + "\n");

		
	}

}
