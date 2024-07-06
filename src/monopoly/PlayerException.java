package monopoly;

/* Excecao de jogador: excecao que será capturada quando os atributos de um jogador
 * for insuficiente para realizar uma operação.
 */

public class PlayerException extends Exception {
    public PlayerException() {
        super("Saldo insuficiente."); // mais comum
    }
    
    public PlayerException(String mensagem) {
        super(mensagem);
    }

    public PlayerException(Throwable causa) {
        super(causa);
    }

    public PlayerException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
    
}
