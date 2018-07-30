package jogo.jogadores;
import java.util.Scanner;

public class Ia extends jogo.Jogador implements Jogada{
    private Scanner entrada = new Scanner(System.in);
    
    @Override
    public int jogada(){
        return (int) Math.max(1,Math.floor(Math.random()*9));
  }
}