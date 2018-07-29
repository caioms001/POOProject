package jogadores;

public class Jogador{

  private String nome;

  private char icone;

  private static Jogador jogador;

  public static Jogador getInstancia(){
    if (jogador == null) {
      this.jogador = new Jogador();
    }
    return jogador;
  }
  private Jogador() {
    //Construtor privado
  }

  public void jogada(){
    //insere a jogada na posição escolhida
  }
}