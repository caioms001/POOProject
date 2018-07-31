/**************************************************************************\
  A classe IA é utilizada para ser um jogador que joga por si só.
\**************************************************************************/

package jogo.jogadores;

public class Ia extends jogo.Jogador implements Jogada{
    
    // Construtor modificado para receber o nome IA
    public Ia(String nome) {
    	super.setNome(nome);
    }

    // Método jogada para a IA realizar a jogada dela.
    @Override
    public int jogada(){
        return (int) Math.max(1,Math.ceil(Math.random()*9));
  }
}