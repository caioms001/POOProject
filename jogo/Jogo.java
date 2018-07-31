/**************************************************************************\
  A classe Jogo é responsável por gerenciar todo o resto. É através dela
  que instanciamos tudo o que precisamos e fazemos todas as chamadas.
\**************************************************************************/

package jogo;

import jogo.jogadores.*;
import java.util.Scanner;

public class Jogo {

  private static Jogo jogo;
  private static Tabuleiro tabuleiro;
  private Jogador[] jogadores = new Jogador[2];
  private Scanner entrada = new Scanner(System.in);
  private int turno = 0;
  private char estadoJogo;
  private boolean jogadaRealizada;

  // Como utilizamos Singleton, só podemos acessar o objeto jogo chamando
  // jogo.inicio(). Isso nos garante que só teremos uma instância de Jogo.
  public static Jogo inicio() {
    if (jogo == null) {
      jogo = new Jogo();
    }
    return jogo;
  }

  // Métodos get e set para o atributo estadoJogo.
  public char getEstadoJogo() {
    return this.estadoJogo;
  }
  public void setEstadoJogo(char estadoJogo) {
    this.estadoJogo = estadoJogo;
  }

  // Alteramos também seu construtor para quando ele for chamado, ele realizar
  // todas as chamadas necessárias.
  private Jogo() {
    tabuleiro = tabuleiro.getInstancia();
    iniciarInterface();
    do {
      rodada();
      setEstadoJogo(tabuleiro.verificarEstado());
    } while (getEstadoJogo() == 'f');
    informarResultado();
  }

  // O método iniciarInterface faz o início do jogo, realizando duas chamadas de
  // escolher jogador.
  private void iniciarInterface() {
    System.out.println();
    System.out.println("Olá jogador, vamos jogar jogo da velha?");
    for (int i = 0; i < 2; i++) {
      escolherJogador(i);
    }
  }

  // O método escolherJogador recebe o índice do jogador, pergunta se será um
  // jogador físico ou uma IA. E então cria o jogador.
  private void escolherJogador(int i) {
    String jogador;
    System.out.println("Digite o nome do jogador " + (i + 1) + " ou IA (para computador) e aperte Enter!");
    jogador = entrada.next().toLowerCase();
    criarJogador(jogador, i);
  }

  // O método criarJogador recebe o nome do jogador, e qual o índice necessário.
  // Através do nome do jogador, ele decide se deve instanciar uma IA, ou um jogador físico.
  private void criarJogador(String tipo, int i) {
    try {
      if (tipo.equals("ia")) { 
        jogadores[i] = new Ia(tipo);
      } else {
        jogadores[i] = new Pessoa(tipo);
      }

      if (jogadores[0] != null) {
        jogadores[0].setSimbolo('X');
      }
      if (jogadores[1] != null) {
        jogadores[1].setSimbolo('O');
      }
    } catch(Exception e) {
      System.out.println("Erro ao setar jogadores " + e);
    }
  }

  // Métodos get e set para o atributo turno.
  public int getTurno() {
    return this.turno;
  }
  public void setTurno(int turno) {
    this.turno = turno;
  }

  // Método utilizado para realizar a troca de turnos.
  private void trocaTurnos() throws Exception {
    if (getTurno() == 0) {
      setTurno(1);
    } else if (getTurno() == 1) {
      setTurno(0);
    } else {  
      throw new Exception("Turno Invalido");
    }
  }

  // Método que realiza a rodada, ou seja, pede que os jogadores joguem, exibe o tabuleiro
  // e troca os turnos.
  public void rodada() {
    tabuleiro.exibirGuia();
    System.out.println("Siga o guia acima do campo e entre com a posição da sua jogada!");
    do {
      jogadaRealizada = tabuleiro.realizarJogada(jogadores[turno].jogada(), turno);
    } while (!jogadaRealizada);
    tabuleiro.exibir();
    try {
      trocaTurnos();
    } catch(Exception e) {
      System.out.println("Erro ao trocar turno: " + e);
    }
    System.out.println("\u0007");
  }

  // Método para exibir de uma maneira elegante, quem ganhou ou se deu velha.
  public void informarResultado() {
    switch (getEstadoJogo()) {
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
        System.out.println(" _____              __      __  _ _           _ _ ");
        System.out.println("|  __ \\             \\ \\    / / | | |         | | |");
        System.out.println("| |  | | ___ _   _   \\ \\  / /__| | |__   __ _| | |");
        System.out.println("| |  | |/ _ \\ | | |   \\ \\/ / _ \\ | '_ \\ / _` | | |");
        System.out.println("| |__| |  __/ |_| |    \\  /  __/ | | | | (_| |_|_|");
        System.out.println("|_____/ \\___|\\__,_|     \\/ \\___|_|_| |_|\\__,_(_|_)");
        break;
      default:
        break;
    }
    System.out.println();
  }
}