/**************************************************************************\
  A classe tabuleiro é utilizada para representar ao tabuleiro em si.
  Então é nele que existe uma matriz de Posicao, para criar o tabuleiro.
  Temos o método para exibir o tabuleiro atual, o tabuleiro guia,
  o método que verifica se alguém ganhou, o método que realiza a jogada,
  e também os métodos que auxiliam esse método.
\**************************************************************************/

package jogo;

import jogo.jogadores.*;

public class Tabuleiro{

  private static Posicao posicoes[][];
  private static Tabuleiro tabuleiro;
  private int turno;
  
  // Como utilizamos Singleton, só podemos acessar o objeto tabuleiro
  // chamando tabuleiro.getInstancia(). Isso nos garante que só teremos
  // uma instância de Tabuleiro.
  public static Tabuleiro getInstancia() {
    if (tabuleiro == null) {
      tabuleiro = new Tabuleiro();
    }
    return tabuleiro;
  }
  
  // Alteramos também o seu construtor para quando ele ser chamado,
  // ele já instanciar todas as posições do tabuleiro.
  private Tabuleiro() {
    posicoes = new Posicao[3][3];
    for (int linha = 0; linha < 3; ++linha) {
      for (int coluna = 0; coluna < 3; ++coluna) {
        posicoes[linha][coluna] = new Posicao(linha, coluna);
      }
    }
  }

  // O método exibir serve para mostrar o tabuleiro no estado atual.
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

  // O método exibirGuia serve para mostrar o tabuleiro com os números
  // das casas para guiar a jogada do usuário.
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

  // O método realizarJogada é quem faz todas as chamadas para que a jogada
  // seja realizada. Ele recebe a casa que o usuário escolheu e qual usuário
  // escolheu. Após isso, ele realiza as chamadas necessárias.
  public boolean realizarJogada(int casa, int turno){
    this.turno = turno;
    if(verificarJogada(casa)){
      int linha = traduzirPosicao(casa, 0);
      int coluna = traduzirPosicao(casa, 1);
      if(verificarPosicao(linha, coluna)){
        marcarPosicao(posicoes[linha][coluna]);
        return true;
      } else {
        return false;
      }
    }else{
      return false;
    }
  }

  // O método verificarJogada serve para analisar se o usuário selecionou
  // uma casa que exista.
  public boolean verificarJogada(int casa){
    if (casa <= 9 && casa > 0) {
      return true;
    } else{
      System.out.println("Entrada incompativel! Jogue Novamente!\n");
      return false;
    }
  }

  // O método verificarPosicao serve para analizar se a casa que o
  // usuário selecionou está vazia.
  public boolean verificarPosicao (int linha, int coluna){
    if(posicoes[linha][coluna].getValor() == ' '){
      return true;
    } else {
      System.out.println("Já há algo nessa casa. Jogue Novamente!\n");
      return false;
    }   
  }
  
  // O método traduzirPosicao serve para receber a casa que o usuário
  // selecionou e transformar isso para a linha e coluna da matriz do tabuleiro.
  public int traduzirPosicao (int casa, int pos) {
    casa = casa - 1;
    if (pos == 0) {
      return casa/3;      
    } else {
      return casa%3;
    }
  }

  // O método marcarPosicao é sobrecarregado pois deixamos duas opções para a
  // implementação. Uma que recebe diretamente o objeto Posição que você quer
  // alterar, ou então ele pode receber a linha e coluna desejada, e ele acessa
  // o objeto desejado.
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

  // O método verificarEstado serve para sabermos se temos um vencedor e
  // quem é, ou se foi um empate, ou se ainda há possibilidades de jogadas.
  // Se há um vencendor, ele retorna o seu ícone, 'd' para empate e 'f' se 
  // ainda há possibilidades.
  public char verificarEstado(){
    boolean velha = true;
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
      
      velha = velha && (posicoes[k][0].getValor() != ' ') &&
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
    return velha ? 'd' : 'f';
  }
}