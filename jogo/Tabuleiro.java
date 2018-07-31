package jogo;
import jogo.jogadores.*;

public class Tabuleiro{

  private static Posicao posicoes[][];
  private static Tabuleiro tabuleiro;
  private int turno;
  
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
    System.out.println();
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

  public void exibirGuia() {
    System.out.println();
    for(int i = 1; i <= 9; i++) {
      System.out.print(" " + i + " ");
      if(i%3 == 0 && i != 9) {
        System.out.println();
        System.out.println("-----------");
      } else {
        if (i != 9) {
          System.out.print("|");
        }
      }
    }
    System.out.println("\n");
  }

  public boolean realizarJogada(int casa, int turno){
   
    this.turno = turno;
    if(verificaJogada(casa)){
      int linha = traduzirPosicao(casa, 0);
      int coluna = traduzirPosicao(casa, 1);
      if(verificaPosicao(linha, coluna)){
        marcarPosicao(posicoes[linha][coluna]);
        return true;
      } else {
        return false;
      }
    }else{
      return false;
    }
  }

  public boolean verificaJogada(int casa){
    if (casa <= 9 && casa > 0) {
      return true;
    } else{
      System.out.println("Entrada incompativel! Jogue Novamente!\n");
      return false;
    }
  }

  public boolean verificaPosicao (int linha, int coluna){
    if(posicoes[linha][coluna].getValor() == ' '){
      return true;
    } else {
      System.out.println("Já há algo nessa casa. Jogue Novamente!\n");
      return false;
    }   
  }
  
  public int traduzirPosicao (int casa, int pos) {
    casa = casa-1;
    if (pos == 0) {
      return casa/3;      
    } else {
      return casa%3;
    }
  }

  public void marcarPosicao(Posicao posicao) {
    if (turno == 0) {
      posicao.setValor('X');
    } else {
      posicao.setValor('O');
    }
  }
  public void marcarPosicao(int linha, int coluna) {
    if (turno == 0) {
      posicoes[linha][coluna].setValor('X');
    } else {
      posicoes[linha][coluna].setValor('O');
    }
  }

  public char verificarEstado(){
    boolean draw = true;
    for(int k = 0; k < 3; k++){
      if(posicoes[k][0].getValor() != ' ' &&
        posicoes[k][0].getValor() == posicoes[k][1].getValor() &&
        posicoes[k][1].getValor() == posicoes[k][2].getValor()){
        return posicoes[k][0].getValor();
      }

      if(posicoes[0][k].getValor() != ' ' &&
        posicoes[0][k].getValor() == posicoes[1][k].getValor() &&
        posicoes[1][k].getValor() == posicoes[2][k].getValor()){
        return posicoes[0][k].getValor();
      }
      
      draw = draw && (posicoes[k][0].getValor() != ' ') &&
                     (posicoes[k][1].getValor() != ' ') && 
                     (posicoes[k][2].getValor() != ' ');
    }

    if(posicoes[0][0].getValor() != ' ' &&
      posicoes[0][0].getValor() == posicoes[1][1].getValor() &&
      posicoes[1][1].getValor() == posicoes[2][2].getValor())
      return posicoes[0][0].getValor();

    if(posicoes[2][0].getValor() != ' ' &&
      posicoes[2][0].getValor() == posicoes[1][1].getValor() &&
      posicoes[1][1].getValor() == posicoes[0][2].getValor())
      return posicoes[2][0].getValor();
    return draw ? 'd' : 'f';
  }
}