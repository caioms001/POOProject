/**************************************************************************\
  A classe posição é utilizada para representar uma célula do tabuleiro.
  Cada Posição possuí 3 atributos, valor (que representa se a célula está
  vazia, ou qual jogardor jogou nela), linha e coluna (que representam qual
  a localização da célula no tabuleiro). Ela possui também alguns métodos,
  que iremos explicar a funcionalidade em cima de cada método.
\**************************************************************************/

package jogo;

public class Posicao {

	private char valor;
  private int linha;
  private int coluna;


  // A classe só é construída recebendo já sua linha e coluna.
	public Posicao(int linha, int coluna) {
		this.linha = linha;
    this.coluna = coluna;
		limpar();
	}

  // Método para limpar a célula atribuindo um caracter em branco a ela.
	public void limpar() {
		this.valor = ' ';
	}
  
  // Métodos get e set para valor.
  public char getValor() {
    return this.valor;
  }

  public void setValor(char valor) {
    this.valor = valor;
  }

  // Método para exibir o valor da célula já formatado para a exibição do tabuleiro.
	public void exibir() {
    switch (this.valor) {
      case 'X': 
        System.out.print(" X ");
        break;
      case 'O':
        System.out.print(" O ");
        break;
      default:
        System.out.print("   ");
        break;
    }
  }
}