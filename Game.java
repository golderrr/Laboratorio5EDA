import java.util.Scanner;

public class Game {
    private String status;
    private String winnerPlayerName;
    private String loserPlayerName;
    private String playerNameA;
    private String playerNameB;
    private ConnectFour connectFour;

    public Game(String playerNameA, String playerNameB) {
        this.playerNameA = playerNameA;
        this.playerNameB = playerNameB;
        connectFour = new ConnectFour();
        this.status = "IN_PROGRESS";
        this.winnerPlayerName = "";
        this.loserPlayerName = "";
    }

    public void play(){

        System.out.println("Empieza el juego");
        Scanner sc = new Scanner(System.in);
        while(!connectFour.isGameOver()){
            System.out.println("Estado actual del juego");
            connectFour.imprimir();
            if(connectFour.getCurrentSymbol() == 'X'){
                System.out.print("Jugador " + playerNameA + " ingrese numero de columna de 1 a 6: ");
            }
            else if(connectFour.getCurrentSymbol() == 'O'){
                System.out.print("Jugador " + playerNameB + " ingrese numero de columna de 1 a 6: ");
            }

            int columna = sc.nextInt();

            if(columna < 1 || columna > 6){
                System.out.println("Numero fuera de rango.");
                continue;
            }

            connectFour.makeMove(columna);

        }

        connectFour.imprimir();

        char c = connectFour.getCurrentSymbol();
        if(c == 'X'){
            this.winnerPlayerName = playerNameB;
            this.loserPlayerName = playerNameA;
            this.status = "VICTORY";
            System.out.println("El jugador " + winnerPlayerName + " ha ganado el juego!");
        }
        else if(c == 'O'){
            this.winnerPlayerName = playerNameA;
            this.loserPlayerName = playerNameB;
            this.status = "VICTORY";
            System.out.println("El jugador " + winnerPlayerName + " ha ganado el juego!");
        }
        else {
            this.status = "DRAW";
            System.out.println("Los jugadores han empatado.");
        }


    }

    public String getWinnerPlayerName() {
        return winnerPlayerName;
    }

    public String getLoserPlayerName(){
        return loserPlayerName;
    }

    public String getStatus() {
        return status;
    }
}
