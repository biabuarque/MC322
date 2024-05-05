package monopoly;

/* Classe CartaSorte: feita para representar as cartas sorte-reves de Banco Imobiliário.
 * - Atributos: herdados de Carta + movimento, efeito, valor, acao, tempo, restricao
 * - Métodos:	getters e setters, toString().
 */

public class CartaSorte extends Carta {
	
	private int movimento;
	private int efeito;
	private float valor;
	private String acao;
	private int tempo;
	private String restricao;
	
	public CartaSorte(String descricao, Jogador dono, int movimento, int efeito, float valor, String acao,
			int tempo, String restricao) {
		super(descricao, dono);
		this.movimento = movimento;
		this.efeito = efeito;
		this.valor = valor;
		this.acao = acao;
		this.tempo = tempo;
		this.restricao = restricao;
	}

	public int getMovimento() {
		return movimento;
	}

	public void setMovimento(int movimento) {
		this.movimento = movimento;
	}

	public int getEfeito() {
		return efeito;
	}

	public void setEfeito(int efeito) {
		this.efeito = efeito;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public String getRestricao() {
		return restricao;
	}

	public void setRestricao(String restricao) {
		this.restricao = restricao;
	}
	
	@Override
	public String toString() {
		return "Carta de Sorte " + this.getId() + "\n\tDescricao: " + this.getDescricao() + "\n\tDono: " + "\n\tDono: " + ((this.getDono() == null) ? (this.getDono()) : (this.getDono().getNome())) + "\n\tMovimento: " + movimento + "\n\tEfeito: " + efeito
				+ "\n\tValor: " + valor + "\n\tAcao: " + acao + "\n\tTempo: " + tempo + "\n\tRestricao: " + restricao + "\n";
	}

}
