package jogo;

public class Tabuleiro{

  private char matriz[][] = new char[3][3];

  private static Tabuleiro tabuleiro;

  public static Tabuleiro getInstancia() {
    if (tabuleiro == null) {
      tabuleiro = new Tabuleiro();
    }
    return tabuleiro;
  }
  private Tabuleiro() {
    // Construtor privado
  }

  public void exibir() {
    //exibe a matriz tabuleiro com as casas preenchidas
    for(int linha = 0; linha < 3; linha++) {
      for(int coluna = 0; coluna < 3; coluna++) {
        exibirPosicao(matriz[linha][coluna]);
        if(coluna != 2) {
          System.out.print("|");
        }
      }
      System.out.println();
      if(linha!=2) {
        System.out.println("-------");
      }
    }
  }

  public void exibirPosicao(char content) {
      switch (content) {
         case 'X':  System.out.print(" X "); break;
         case 'O': System.out.print(" O "); break;
         default: System.out.print("   "); break;
      }
   }
}