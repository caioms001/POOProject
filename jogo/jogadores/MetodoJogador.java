package jogadores;

public interface MetodoJogador {
    // Retorna o nome do usuário autenticado (null significa que a autenticacao falhou)
    Jogador jogada() throws JogadaErradaException;

}