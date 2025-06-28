import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scoreboard scoreboard = new Scoreboard();

        while (true) {
            System.out.print("Nombre del jugador A: ");
            String jugadorA = sc.nextLine();

            System.out.print("Nombre del jugador B: ");
            String jugadorB = sc.nextLine();

            scoreboard.registerPlayer(jugadorA);
            scoreboard.registerPlayer(jugadorB);

            Game partida = new Game(jugadorA, jugadorB);
            partida.play();

            boolean draw = false;

            if(partida.getStatus().equals("DRAW")){
                draw = true;
                scoreboard.addGameResult(jugadorA, jugadorB, draw);
            } else {
                String winner = partida.getWinnerPlayerName();
                String loser = partida.getLoserPlayerName();
                scoreboard.addGameResult(winner, loser, draw);
            }

            System.out.print("\n¿Desean jugar otra vez? (s/n): ");
            String respuesta = sc.nextLine().toLowerCase();
            if (!respuesta.equals("s")) {
                System.out.println("Gracias por jugar!");
                break;
            }
        }
    }
}