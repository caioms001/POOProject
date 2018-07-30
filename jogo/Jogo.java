package jogo;
import jogo.jogadores.*;
import java.util.Scanner;

public class Jogo{

  private static Tabuleiro tabuleiro;
  private Scanner entrada = new Scanner(System.in);
  private Jogador[] jogadores = new Jogador[2];
  private int turno = 0;

  private Jogo(){
      tabuleiro = tabuleiro.getInstancia();
      iniciarInterface();
      do{
        rodada();
      }while(verificarVencedor());
  }

  private static Jogo jogo;

  public static Jogo inicio() {
    if (jogo == null){
        jogo = new Jogo();
    }
    return jogo;
  }

  public void iniciarInterface(){
    System.out.println("Olá jogador, vamos jogar jogo da velha?");

    for (int i= 0;i < 2; i++) {
      escolherJogador(i);
    }
  }

  public void escolherJogador(int i){
      String jogador;
      System.out.println("Digite o nome do jogador ou IA (para computador) e aperte Enter!");
      jogador = entrada.next().toLowerCase();
      criarJogador(jogador, i);
  }
  
  public void criarJogador(String tipo, int i){

    if(tipo.equals("ia")){
      jogadores[i] = new Ia();
      jogadores[i].setNome(tipo);
    }else{
      jogadores[i] = new Pessoa();
      jogadores[i].setNome(tipo);
    }

    if (jogadores[0] != null) {
      jogadores[0].setSimbolo('X');
    }
    if (jogadores[1] != null) {
      jogadores[1].setSimbolo('O');
    }
  }

  public void trocaTurnos(){
    if (turno == 0) {
      turno = 1;
    }else{
      turno = 0;
    }
  }

  public void rodada(){
      boolean jogadaRealizada;
      tabuleiro.exibirGuia();
      System.out.println("Siga o guia acima do campo e entre com a posição da sua jogada!");
      if (turno == 0) {
        do{
          jogadaRealizada = tabuleiro.realizarJogada(jogadores[turno].jogada());
        }while(jogadaRealizada);
      }else{
        tabuleiro.realizarJogada(jogadores[turno].jogada());
      }
      tabuleiro.exibir();
      trocaTurnos();
      System.out.println("\u0007");

  }

  public boolean verificarVencedor(){
    return true;
  }
}