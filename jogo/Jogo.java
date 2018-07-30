package jogo;
import jogo.jogadores.*;
import java.util.Scanner;

public class Jogo{

  private static Tabuleiro tabuleiro;
  private Scanner entrada = new Scanner(System.in);
  private Jogador[] jogadores = new Jogador[2];
  private int turno = 0;
  private char estadoJogo;

  private Jogo(){
      tabuleiro = tabuleiro.getInstancia();
      iniciarInterface();
      do{
        rodada();
        this.estadoJogo = tabuleiro.verificarEstado();
      }while(this.estadoJogo == 'f');
      informarResultado();
  }

  private static Jogo jogo;

  public static Jogo inicio() {
    if (jogo == null){
        jogo = new Jogo();
    }
    return jogo;
  }

  public void iniciarInterface(){
    System.out.println();
    System.out.println("Olá jogador, vamos jogar jogo da velha?");
    for (int i= 0;i < 2; i++) {
      escolherJogador(i);
    }
  }

  public void escolherJogador(int i){
      String jogador;
      System.out.println("Digite o nome do jogador " + (i+1) + " ou IA (para computador) e aperte Enter!");
      jogador = entrada.next().toLowerCase();
      criarJogador(jogador, i);
  }

  public int getTurno(){
    return this.turno;
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
      do{
        jogadaRealizada = tabuleiro.realizarJogada(jogadores[turno].jogada(), turno);
      }while(!jogadaRealizada);
      tabuleiro.exibir();
      trocaTurnos();
      System.out.println("\u0007");

  }

  public void informarResultado(){
    switch (this.estadoJogo) {
      case 'X': 
        System.out.println("__   __   _____             _                 _ _ ");
        System.out.println("\\ \\ / /  / ____|           | |               | | |");
        System.out.println(" \\ V /  | |  __  __ _ _ __ | |__   ___  _   _| | |");
        System.out.println("  > <   | | |_ |/ _` | '_ \\| '_ \\ / _ \\| | | | | |");
        System.out.println(" / . \\  | |__| | (_| | | | | | | | (_) | |_| |_|_|");
        System.out.println("/_/ \\_\\  \\_____|\\__,_|_| |_|_| |_|\\___/ \\__,_(_|_)");
        break;
      case 'O':
        System.out.println("  ____      _____             _                 _ _ ");
        System.out.println(" / __ \\    / ____|           | |               | | |");
        System.out.println("| |  | |  | |  __  __ _ _ __ | |__   ___  _   _| | |");
        System.out.println("| |  | |  | | |_ |/ _` | '_ \\| '_ \\ / _ \\| | | | | |");
        System.out.println("| |__| |  | |__| | (_| | | | | | | | (_) | |_| |_|_|");
        System.out.println(" \\____/    \\_____|\\__,_|_| |_|_| |_|\\___/ \\__,_(_|_)");
        break;
      case 'd':   
        System.out.println(" ______                       _        ");
        System.out.println("|  ____|                     | |       ");
        System.out.println("| |__   _ __ ___  _ __   __ _| |_ ___  ");
        System.out.println("|  __| | '_ ` _ \\| '_ \\ / _` | __/ _ \\ ");
        System.out.println("| |____| | | | | | |_) | (_| | ||  __/ ");
        System.out.println("|______|_| |_| |_| .__/ \\__,_|\\__\\___| ");
        System.out.println("                 | |                   ");
        System.out.println("                 |_|                   ");
        break;
    }
    System.out.println();
  }
}