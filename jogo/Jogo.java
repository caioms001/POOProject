package jogo;
// import jogadores.*;

public class Jogo{

  private static Tabuleiro tabuleiro;
  // private static MetodoJogador metodoJogador;

  private Jogo(){

      tabuleiro = tabuleiro.getInstancia();
      tabuleiro.exibir();

  }

  private static Jogo jogo;

  public static Jogo inicio(String tipo) {
    if (jogo == null){
        jogo = new Jogo();
    }
    jogada(tipo);
    return jogo;
  }


  public static void iniciar() {


  }

  public void encerrar() {
    //esse método encerra o jogo
    //exibe mensagem "obrigado pela partida"
  }

  public static void jogada(String tipo) {
    if (tipo.equals("jogador")) {
      System.out.println("Vai jogar contra um amigo então?");    
      // this.metodoJogador = Pessoa.getInstancia(); 
    }else{
      System.out.println("Você nunca vai ganhar de mim!");
      // this.metodoJogador = Ia.getInstancia();
    }
  }

  public void verificar() {
    //esse método verifica se há vencedor na rodada
  }
}