package jogo;
import java.util.Scanner;

public class Jogador {

  char simbolo = ' ';
  String nome = "";
  private Scanner entrada = new Scanner(System.in);
  tabuleiro.getInstance();
  public int jogada(){
    int casa;
    System.out.println("Jogador: " + this.getNome() + " com símbolo: " + this.getSimbolo());
    System.out.print("Qual posição você escolhe? ");
    casa = entrada.nextInt();
    System.out.println("A casa é: " + casa);
    return casa;
  }

  public void setSimbolo(char simbolo){
    this.simbolo = simbolo;
  }

  public char getSimbolo(){
    return this.simbolo;
  }
  
  public void setNome(String nome){
    this.nome = nome;
  }

  public String getNome(){
    return this.nome;
  }
}