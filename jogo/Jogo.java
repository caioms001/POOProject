package jogo;
import jogo.jogadores.*;
import java.util.Scanner;

public class Jogo{

  private String adversario;
  private static Tabuleiro tabuleiro;
  private Scanner entrada = new Scanner(System.in);
  
  private Jogo(){
      tabuleiro = tabuleiro.getInstancia();
      iniciarInterface();
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
    escolherAdversario();
    rodada();
    tabuleiro.exibirGuia();
    tabuleiro.exibir();

  }

  public void escolherAdversario(){
    Boolean valido = false;
    do{
      System.out.println("Contra quem deseja jogar? Digite Jogador ou IA e aperte Enter");
      adversario = entrada.next().toLowerCase();
      if(adversario.equals("jogador") || adversario.equals("ia")){
        this.adversario = adversario;
        valido = true;
      }else{
        System.out.println("Tipo de jogador invalido! Entre Jogador ou IA");
        valido = false;
      }
    } while(!valido);
  }

  public void rodada(){
    System.out.println("Adversário é" + adversario);
  }
  // public static void jogador(String tipo) {
  //   if (tipo.equals("jogador")) {
  //     System.out.println("Vai jogar contra um amigo então?");    
  //     // this.metodoJogador = Pessoa.getInstancia(); 
  //   }else{
  //     System.out.println("Você nunca vai ganhar de mim!");
  //     // this.metodoJogador = Ia.getInstancia();
  //   }
  // }
}