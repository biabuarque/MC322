package monopoly;

/* Classe CartaSorte: feita para englobar as Cartas de Sorte do Banco Imobiliário.
 * - Atributos: id (identificador da carta); descricao (ou nome da carta); movimento (caso mover-se no tabuleiro
 * 				seja uma consequência da carta); efeito (positivo, negativo ou neutro); valor (caso haja mudança
 * 				no saldo do jogador); acao (caso a consequência não se encaixe em movimento ou valor); tempo
 * 				(quando a carta podera ser usada); restricao
 * - Métodos:	getters e setters, toString().
 */

public class CartaSorte {
	private int id;
	private String descricao;
	private int movimento;
	private int efeito;
	private float valor;
	private String acao;
	private int tempo;
	private String restricao;
	
	public CartaSorte(int id, String descricao, int movimento, int efeito, float valor, String acao, int tempo,
			String restricao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.movimento = movimento;
		this.efeito = efeito;
		this.valor = valor;
		this.acao = acao;
		this.tempo = tempo;
		this.restricao = restricao;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		return "Carta de Sorte " + id + "\n\tDescricao: " + descricao + "\n\tMovimento: " + movimento + "\n\tEfeito: " + efeito
				+ "\n\tValor: " + valor + "\n\tAcao: " + acao + "\n\tTempo: " + tempo + "\n\tRestricao: " + restricao + "\n";
	}
	
	

}
