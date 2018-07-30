package jogo;

public class Jogador {

  char simbolo = ' ';
  String nome = "";

  public void setSimbolo(char simbolo){
    this.simbolo = simbolo;
  }

  public char getSimbolo(){
    return this.simbolo;
  }
  
  protected void setNome(String nome){
    this.nome = nome;
  }

  public String getNome(){
    return this.nome;
  }

  public int jogada(){
    return 0;
  }
}