public class Jogo{

    private Tabuleiro tabuleiro;



    public void iniciar() {
        //esse método inicia o jogo
        //criar instância tabuleiro
        //chamar método adversário

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