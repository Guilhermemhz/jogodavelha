import java.security.cert.X509CRL;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Bem vindo ao jogo da velha!");
        
        char[][] jogo = inicializarJogo();
        char player = 'X';        

        while (true) {
            printJogo(jogo);
            System.out.println("É a vez do jogador " + player + "!");
            System.out.print("Digite a linha: ");
            int linha = sc.nextInt();
            System.out.print("Digite a coluna: ");
            int coluna = sc.nextInt();

            boolean sucesso = makeMove(jogo, linha - 1, coluna - 1, player);

            if (!sucesso) {
                System.out.println("Jogada Invalida! TENTE NOVAMENTE!");
                System.out.println();
                continue;
            }
            if (ganhador(player, jogo)) {
                System.out.println();
                printJogo(jogo);
                System.out.println("GANHADOR JOGADOR: " + player + "!"); 
                System.out.println("PARABENS!!!!!");
                break;
            }
            if (!verificarEmpate(jogo)) {
                System.out.println();
                printJogo(jogo);
                System.out.println("Partida terminou Empatada!");
                break;
            }

            player = (player == 'X') ? 'O' : 'X';

            System.out.println();
        }
        
        sc.close();
    }

    public static char[][] inicializarJogo(){
        char[][] jogo = new char[3][3];

        for(int i = 0; i < jogo.length; i++){
            for(int j = 0; j < jogo[i].length; j++){
                jogo[i][j] = '.';
            }
        }

        return jogo;
    }

    public static void printJogo(char[][] jogo){
        for(int i = 0; i < jogo.length; i++){
            for(int j = 0; j < jogo[i].length; j++){
                System.out.print(jogo[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean makeMove(char[][] jogo, int linha, int coluna, char player){
        if (jogo[linha][coluna] == '.') {
            jogo[linha][coluna] = player;
            return true;
        }
        return false;
    }

    public static boolean ganhador(char player, char[][] jogo){
        // Vitoria por linha
        if (jogo[0][0] == player && jogo[0][1] == player && jogo[0][2] == player) {
            return true;
        }
        if (jogo[1][0] == player && jogo[1][1] == player && jogo[1][2] == player) {
            return true;
        }
        if (jogo[2][0] == player && jogo[2][1] == player && jogo[2][2] == player) {
            return true;
        }
        // Vitoria por coluna
        if (jogo[0][0] == player && jogo[1][0] == player && jogo[2][0] == player) {
            return true;
        }
        if (jogo[0][1] == player && jogo[1][1] == player && jogo[2][1] == player) {
            return true;
        }
        if (jogo[0][2] == player && jogo[1][2] == player && jogo[2][2] == player) {
            return true;
        }
        // Vitoria por diagonal
        if (jogo[0][0] == player && jogo[1][1] == player && jogo[2][2] == player) {
            return true;
        }
        if (jogo[0][2] == player && jogo[1][1] == player && jogo[2][0] == player) {
            return true;
        }
        return false;
    }
     
    public static boolean verificarEmpate(char[][] jogo){
        for(int i = 0; i < jogo.length; i++){
            for(int j = 0; j < jogo[i].length; j++){
                if(jogo[i][j] == '.'){
                    return true;
                }
            }
        }
        return false;
    }

}
