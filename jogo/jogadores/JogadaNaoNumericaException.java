package jogo.jogadores;

public class JogadaNaoNumericaException extends RuntimeException {
    public JogadaNaoNumericaException(String message){
        super(message);
    }
}