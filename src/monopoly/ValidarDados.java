package monopoly;

/* Classe ValidarDados(): biblioteca de funções para validar dados dos jogadores..
 * - Atributos:
 * - Métodos:	validarCPF (valida o CPF) de um jogador; validarEmail (valida o e-mail de um jogador);
 * 				digitoVerificador (método privado, calcula os dígitos verificadores de um CPF), 
 * 				digitosIguais (método privado, verifica se os dígitos de uma string numérica são iguais).
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarDados {
	public static boolean validarCPF(String cpf) {
		cpf = cpf.replaceAll("^]0-9]", "");
		int digitodez = digitoVerificador(cpf, 9);
		int digitoonze = digitoVerificador(cpf, 10);
		
		// tamanho do cpf excede 11?
		if (cpf.length() != 11) {
			return false;
		}
		// todos os caracteres são iguais?
		else if (digitosIguais(cpf)) { //checar se realmente faz sentido
			return false;
		}
		// dígitos verificadores correspondem?
		else if ((Character.getNumericValue(cpf.charAt(9)) != digitodez) || Character.getNumericValue(cpf.charAt(10)) != digitoonze){
			return false;
		}
		
		return true;
	}
	
	public static boolean validarEmail(String email) {
		email = email.strip();
		// menor que o comprimento máximo?
		if (email.length() > 256) {
			return false;
		}
		
		/* LAB1: pesquisei como checar padroes de string em Java e me convenceram a apanhar para regular expressions!
		 * entretanto, talvez o código pudesse ser otimizado para que essa parte não fique redundante com outros ifs...
		 * LAB2: honestamente, essa forma é mais legível do que deixar só o regex (se eu fosse ler o código, mesmo
		 * sabendo como funciona, não gostaria de ver só esse hieróglifo).
		 */
		
		// cada seção tem apenas seus caracteres permitidos?
		String padrao = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	    Pattern regex = Pattern.compile(padrao);
	    Matcher matcher = regex.matcher(email);

		if (!matcher.matches()) {
			return false;
		}
		
		
		String[] secoes = email.split("@");
		if (secoes.length != 2) {
			return false;
		}
		
		String local = secoes[0];
		String dominio = secoes[1];
		
		/* Para o domínio:
		 * possui um "."
		 * parte antes do "." possui pelo menos 1 caractere, parte depois do ponto, pelo menos 2 caracteres
		 */
		if (!dominio.contains(".")) {
			return false;
		}
		else if (dominio.substring(0, dominio.indexOf(".")).length() < 1 ||  dominio.substring(dominio.indexOf(".")).length() < 2) { // REVER
			return false;
		}
		
		/* Para a parte local:
		 * não possui caracteres especiais consecutivos ou no final da parte local
		 * não possui . no começo da parte local
		 */
		if (local.startsWith(".") || local.endsWith(".") || local.endsWith("-") || local.endsWith("_")) {
			return false;
		}
		else if (local.contains("..") || local.contains("__") || local.contains("--")) { 
			return false;
		}
		return true;
	}
	
	private static int digitoVerificador(String cpf, int fim) {
		int digito = 0;
		for (int i = 0; i < fim; i++) {
			digito += Character.getNumericValue(cpf.charAt(i)) * ((fim == 9) ? i + 1 : i);
		}
		return digito % 11;
	}
	
	private static boolean digitosIguais(String cpf) {
		int primeiro = cpf.charAt(0);
		for (int i = 1; i < 11; i++) {
			if (primeiro != (int)cpf.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
