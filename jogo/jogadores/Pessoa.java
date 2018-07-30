package jogo.jogadores;
import java.util.Scanner;

public class Pessoa extends jogo.Jogador implements Jogada{
    private Scanner entrada = new Scanner(System.in);
    @Override
    public int jogada(){
        int casa;
        System.out.println("\nTurno do jogador " + getNome().toUpperCase() + " com símbolo " + this.getSimbolo());
        System.out.print("Qual posição você escolhe? ");
        casa = entrada.nextInt();
        return casa;
  }
}