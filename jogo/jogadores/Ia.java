package jogo.jogadores;

public class Ia extends jogo.Jogador implements Jogada{
    
    public Ia(String nome) {
    	super.setNome(nome);
    }

    @Override
    public int jogada(){
        return (int) Math.max(1,Math.ceil(Math.random()*9));
  }
}