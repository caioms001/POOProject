package jogo;

import jogadores.*;


public class Jogo{

    private static Jogo jogo;

     public static Jogo partida(String jogador1) {
        if (jogo == null){
            this.jogo = new Jogo(jogador1);
        }
        return jogo;
    }

    public static Jogo partida(String jogador1, String jogador2) {
        if (jogo == null){
            this.jogo = new Jogo(jogador1, jogador2);
        }
        return jogo;
    }

    private Jogo(String jogador1){    
        private Tabuleiro tabuleiro;
        
    }

    private Jogo(String jogador1, String jogador2){

        private Tabuleiro tabuleiro;
    }


    public void iniciar() {

        this.tabuleiro = new Tabuleiro();

        tabuleiro.exibir();

    }

    public void encerrar() {
        //esse método encerra o jogo
        //exibe mensagem "obrigado pela partida"
    }

    public void adversario() {
        //esse método seleciona se o jogo será contra P2 ou IA
    }

    public void verificar() {
        //esse método verifica se há vencedor na rodada
    }

}