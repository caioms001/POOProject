package jogo;

public class Posicao {
	private char valor;
	private int coluna, linha;

	public Posicao(int col, int lin) {
		this.coluna = col;
		this.linha = lin;
		limpar();
	}

	public void limpar() {
		this.valor = ' ';
	}
  
  public char getValor() {
    return this.valor;
  }

  public void setValor(char valor) {
    this.valor = valor;
  }

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