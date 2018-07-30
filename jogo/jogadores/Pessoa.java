package jogadores;

public class Pessoa implements MetodoJogador{

  private String nome;

  private char icone;

  private static Pessoa pessoa;

  public static Pessoa getInstancia(){
    if (pessoa == null) {
      this.pessoa = new Pessoa();
    }
    return pessoa;
  }
  private Pessoa() {
    //Construtor privado
  }
}