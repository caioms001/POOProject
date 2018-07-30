package jogadores;

public class Jogador {
    private char simbolo;
    private String nome; 
    
    private static Jogador jogador;

  public static Jogador getInstancia() {
    if (jogador == null) {
      jogador = new Jogador();
    }
    return jogador;
  }
  
  private Jogador() {
    
  }
}