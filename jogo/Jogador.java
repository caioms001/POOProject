/**************************************************************************\
  A classe Jogador é utilizada para ser extendida por Pessoa e IA.
  Nela declaramos os métodos comuns que as duas classes possuem.
\**************************************************************************/

package jogo;

public class Jogador {

  char simbolo = ' ';
  String nome = "";

  // O método setSimbolo recebe um char, e o torna o símbolo do Jogador.
  // No caso, o programa só envia 'X' ou 'O' para esse método.
  public void setSimbolo(char simbolo){
    this.simbolo = simbolo;
  }
  public char getSimbolo(){
    return this.simbolo;
  }

  // Métodos set e get para o Nome do jogador.
  protected void setNome(String nome){
    this.nome = nome;
  }
  public String getNome(){
    return this.nome;
  }

  // Método para o jogador realizar a sua jogada.
  // Esse método deve retornar um valor de 1 a 9 que corresponde a casa desejada.
  public int jogada(){
    return 0;
  }
}