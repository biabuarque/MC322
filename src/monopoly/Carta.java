package monopoly;

/* Classe Carta: feita para representar as cartas dos jogadores de Banco Imobiliário.
 * - Atributos: id, descricao, dono, contador (atributo de classe)
 * - Métodos:	getters e setters.
 */

public class Carta {
		private int id;
		private String descricao;
		private Jogador dono;
		private static int contador = 0;
		
		public Carta(String descricao, Jogador dono) {
			this.id = contador;
			this.descricao = descricao;
			this.dono = dono;
			contador++;
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

		public Jogador getDono() {
			return dono;
		}

		public void setDono(Jogador dono) {
			this.dono = dono;
		}

		
}
