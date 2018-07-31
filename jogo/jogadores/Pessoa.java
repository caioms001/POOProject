package jogo.jogadores;
import java.util.Scanner;

public class Pessoa extends jogo.Jogador implements Jogada {
  private Scanner entrada = new Scanner(System.in);
  private String dado;
  public Pessoa(String nome) {
  	super.setNome(nome);
  }

  @Override
  public int jogada(){
    int casa = 0;
      System.out.println("\nTurno do jogador " + getNome().toUpperCase() + " com símbolo " + this.getSimbolo());
      System.out.println("Qual posição você escolhe? ");
      try{
        if (entrada.hasNextInt()) {
          dado = entrada.next();
          casa = Integer.parseInt(dado); 
        } else{
          throw new JogadaNaoNumericaException(entrada.next()+" Não é inteiro");
        }       
        
      }catch(JogadaNaoNumericaException e){
        System.out.println(e);
      }
    return casa;
  }
}