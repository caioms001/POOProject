public class Tabuleiro{

    private char matriz[][] = new char[3][3];

    public void exibir(){
        //exibe a matriz tabuleiro com as casas preenchidas

        for(int i = 0; i<3; i++){

            for(int j = 0; j<3; j++){

                System.out.print( matriz[i][j] );

                if(j!=2){

                    System.out.print("|");

                }

            }

            System.out.println();

            if(i!=2){

            System.out.println("-------");

            }

        }

    }

}