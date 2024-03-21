package lab1;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Classe Jogador: feita para descrever os jogadores de Banco Imobiliário.
 * - Atributos: nome (nome do jogador); cpf (CPF do jogador); foto (link para foto a ser anexada
 * 				ao jogador); email (e-mail do jogador)
 * - Métodos:	getters e setters; validarCPF (publico, retorna true se o CPF for válido); validarEmail 
 * 				(publico, retorna true se o e-mail for válido); digitoVerificador (privado, retorna o
 * 				decimo ou decimo primeiro digito do CPF de acordo com o cálculo dos digitos verificadores);
 * 				digitosIguais (privado, retorna true se todos os digitos do CPF forem iguais), toString().
 */

public class Jogador {
	private String nome;
	private String cpf;
	private String foto;
	private String email;
	
	public Jogador(String nome, String cpf, String foto, String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.foto = foto;
		this.email = email;
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
	
	public boolean validarCPF() {
		cpf = cpf.replaceAll("^]0-9]", "");
		int digitodez = digitoVerificador(9);
		int digitoonze = digitoVerificador(10);
		
		// tamanho do cpf excede 11?
		if (cpf.length() != 11) {
			return false;
		}
		// todos os caracteres são iguais?
		else if (digitosIguais()) { //checar se realmente faz sentido
			return false;
		}
		// dígitos verificadores correspondem?
		else if ((Character.getNumericValue(cpf.charAt(9)) != digitodez) || Character.getNumericValue(cpf.charAt(10)) != digitoonze){
			return false;
		}
		
		return true;
	}
	
	public boolean validarEmail() {
		// menor que o comprimento máximo?
		if (email.length() > 256) {
			return false;
		}
		
		/* pesquisei como checar padroes de string em Java e me convenceram a apanhar para regular expressions!
		 * entretanto, talvez o código pudesse ser otimizado para que essa parte não fique redundante com outros ifs
		 */
		
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
		
		/* para o domínio:
		 * possui um "."
		 * parte antes do "." possui pelo menos 1 caractere, parte depois do ponto, pelo menos 2 caracteres
		 */
		if (!dominio.contains(".")) {
			return false;
		}
		else if (dominio.substring(0, dominio.indexOf(".")).length() < 1 ||  dominio.substring(dominio.indexOf(".")).length() < 2) { // REVER
			return false;
		}
		/*para a parte local:
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
	
	// perguntar para Esther: é válido usar um método privado para não ter toda a info de DV no public? Resposta: SIM :D
	private int digitoVerificador(int fim) {
		int digito = 0;
		for (int i = 0; i < fim; i++) {
			digito += Character.getNumericValue(cpf.charAt(i)) * ((fim == 9) ? i + 1 : i);
		}
		return digito % 11;
	}
	
	private boolean digitosIguais() {
		int primeiro = cpf.charAt(0);
		for (int i = 1; i < 11; i++) {
			if (primeiro != (int)cpf.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Jogador " + nome + "\n\tCPF: " + cpf + "\n\tFoto: " + foto + "\n\tEmail: " + email;
	}

}
