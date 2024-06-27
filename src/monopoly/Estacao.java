package monopoly;

/* Classe Estacao: representa um tipo de propriedade: a estacao.
 * - Atributos: id, nome, proprietário, preço, aluguel, contador (atributo de classe).
 * - Métodos:	getters e setters; calcularAluguel().
 */

public class Estacao extends Propriedade {
	/* Na classe Estacao, adicione a propriedade tarifa. Ela será a base para o cálculo do aluguel*/
	private double tarifa;
	
	public Estacao(String descricao, Jogador dono, String nome, int preco, int aluguel, double tarifa) {
		super(descricao, dono, nome, preco, aluguel);
		this.tarifa = tarifa;
	}
	
	public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

	@Override
	public int calcularAluguel() {
		int aluguel = (int) (this.getAluguel() * (1 + tarifa));
		return aluguel;
	}

}
