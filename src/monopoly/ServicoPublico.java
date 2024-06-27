package monopoly;

/* Classe Servico Publico: feita para representar um tipo de propriedade: aquelas do Estado
 * 							(em outras versões, companhias públicas ou privadas).
 * - Atributos: herdados de Propriedade.
 * - Métodos:	getters e setters; calcularAluguel().
 */

public class ServicoPublico extends Propriedade {
	/* Na classe ServicoPublico, adicione a propriedade multiplicador. 
	Ela será a base para o cálculo do
	aluguel e representa o número referente ao dado */ 
	private int multiplicador;

	public ServicoPublico(String descricao, Jogador dono, String nome, int preco, int aluguel, int multiplicador) {
		super(descricao, dono, nome, preco, aluguel);
		this.multiplicador = multiplicador;
	}

	public int getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }
	
    @Override
	public int calcularAluguel() {
		int aluguel = this.getAluguel();
		return aluguel * (int)(multiplicador / 2); // relação aluguel x dados criada para teste
	}
	
}
