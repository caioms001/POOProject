import jogo.*;
import java.util.Scanner;

public class Main{

  public static Scanner entrada = new Scanner(System.in);
  public static String adversario;

  public static Jogo jogo;


  private static boolean inicializaJogo(String player) throws Exception{
      
    player = player.toLowerCase();
    if(player.equals("jogador") || player.equals("ia")){
      jogo.inicio(player);
      return true;
    }else{
      System.out.println("Tipo de jogador invalido! Entre Jogador ou IA");
      return false;
    }
  }

  public static void main (String[] Args) throws Exception{

    System.out.println("Olá jogador, vamos jogar jogo da velha?");
    do{

      System.out.println("Contra quem deseja jogar? Digite Jogador ou IA e aperte Enter");
      adversario = entrada.next();

    } while(!inicializaJogo(adversario));
  }
}