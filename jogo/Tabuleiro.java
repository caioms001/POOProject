package jogo;

public class Tabuleiro{

  Posicao posicoes[][];

  private static Tabuleiro tabuleiro;

  public static Tabuleiro getInstancia() {
    if (tabuleiro == null) {
      tabuleiro = new Tabuleiro();
    }
    return tabuleiro;
  }
  private Tabuleiro() {
    posicoes = new Posicao[3][3];
    for (int linha = 0; linha < 3; ++linha) {
      for (int coluna = 0; coluna < 3; ++coluna) {
        posicoes[linha][coluna] = new Posicao(linha, coluna);
      }
    }
  }

  public void exibir() {
    for(int linha = 0; linha < 3; linha++) {
      for(int coluna = 0; coluna < 3; coluna++) {
        posicoes[linha][coluna].exibir();
        if(coluna != 2) {
          System.out.print("|");
        }
      }
      System.out.println();
      if(linha != 2) {
        System.out.println("-----------");
      }
    }
  }
}