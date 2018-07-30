package jogo;

public class Posicao {
	char estado;
	int coluna, linha;

	public Posicao(int col, int lin) {
		this.coluna = col;
		this.linha = lin;
		limpar();
	}

	public void limpar() {
		this.estado = ' ';
	}
  
  public char getValor(){
    return this.estado;
  }

	public void exibir() {
    switch (this.estado) {
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