package monopoly;

/* Classe Terreno: representa um tipo de propriedade, a imobiliária. Podem ser adicionados casas e hotéis.
 * - Atributos: id, nome, proprietário, preço, aluguel, contador (atributo de classe), numeroCasas (quantas
 * 				casas foram colocadas no terreno), valorCasa (preço para adicionar uma casa), valorHotel 
 * 				(preço para formar um hotel), hotel (true se o terreno tem hotel, false caso contrário).
 * - Métodos:	getters e setters; calcularAluguel(); comprarCasa(); comprarHotel(); toString().
 */

public class Terreno extends Propriedade {
	
	private int numeroCasas;
	private int valorCasa;
	private int valorHotel;
	private boolean hotel;

	public Terreno(String nome, Jogador proprietario, int preco, int aluguel, int numeroCasas, int valorCasa,
			int valorHotel, boolean hotel) {
		super(nome, proprietario, preco, aluguel);
		this.numeroCasas = numeroCasas;
		this.valorCasa = valorCasa;
		this.valorHotel = valorHotel;
		this.hotel = hotel;
	}

	public int getNumeroCasas() {
		return numeroCasas;
	}

	public void setNumeroCasas(int numeroCasas) {
		this.numeroCasas = numeroCasas;
	}

	public int getValorCasa() {
		return valorCasa;
	}

	public void setValorCasa(int valorCasa) {
		this.valorCasa = valorCasa;
	}

	public int getValorHotel() {
		return valorHotel;
	}

	public void setValorHotel(int valorHotel) {
		this.valorHotel = valorHotel;
	}

	public boolean isHotel() {
		return hotel;
	}

	public void setHotel(boolean hotel) {
		this.hotel = hotel;
	}

	@Override
	public int calcularAluguel() {
		int aluguel = this.getAluguel();
		if(numeroCasas >= 1) {
			aluguel *= 5;
		}
		if (numeroCasas >= 2) {
			for (int i = 2; i <= numeroCasas; i++) {
				aluguel *= 2.5; // autocasting, taxa para teste
			}
		}
		if (hotel) {
			aluguel *= 1.25; // taxa para teste também
		}
		return aluguel;
	}
	
	public boolean comprarCasa() {
		// REGRAS DO JOGO: podem ser construídas até 4 casas.
		if (numeroCasas > 4 || this.getProprietario().getDinheiro() < valorCasa) {
			return false;
		}
		else {
			numeroCasas++;
			this.getProprietario().prejuizo(valorCasa);
		}
		
		return true;
	}
	
	public boolean comprarHotel() {
		// REGRAS DO JOGO: só é possível se o terreno já tiver 4 casas.
		if (numeroCasas <= 4 || this.getProprietario().getDinheiro() < valorHotel) {
			return false;
		}
		else {
			hotel = true;
			this.getProprietario().prejuizo(valorCasa);
		}
		return true;
	}
	
	public String toString() {
		return "Propriedade " + this.getId() + "\n\tNome: " + this.getNome() + "\n\tProprietario: " + ((this.getProprietario() == null) ? (this.getProprietario()) : (this.getProprietario().getNome())) 
				+ "\n\tPreco: " + this.getPreco() + "\n\tAluguel: " + this.getAluguel() + "\n\tNumero de casas: " + numeroCasas + "\n\tPreco Casa: " + valorCasa + "\n\tPreco Hotel: " + valorHotel + "\n";
	}
}
