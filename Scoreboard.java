import java.util.*;
import java.io.*;

public class Scoreboard {
    private int playedGames;
    BST winTree = new BST();
    private HashST<String, Player> players = new HashST<>();

    public Scoreboard() {
        this.playedGames = 0;
    }

    public void addGameResult(String nombreWin, String nombreLoss, boolean draw){

        playedGames++;

        Player winner = players.get(nombreWin);
        Player loser = players.get(nombreLoss);

        if(draw){
            winner.addDraw();
            loser.addDraw();
        }
        else{
            winner.addWin();
            loser.addLoss();
            winTree.insert(winner.getWins(), nombreWin);
        }
    }

    public void registerPlayer(String playerName){
        if(!players.containsKey(playerName)){
            players.put(playerName, new Player(playerName));
            System.out.println(playerName + " registrado.");
        }
        else{
            System.out.println("Ya existe el jugador.");
        }
    }

    public boolean checkPlayer(String playerName){
        if(players.containsKey(playerName)) return true;
        return false;
    }

    public ArrayList<Map.Entry<Integer, String>> winRange(int lo, int hi){
        ArrayList<Map.Entry<Integer, String>> cumple = new ArrayList<>();

        winTree.range(winTree.root, lo, hi, cumple);

        return cumple;
    }

    public ArrayList<Map.Entry<Integer, String>> winSuccessor(int wins){
        ArrayList<Map.Entry<Integer, String>> cumple = new ArrayList<>();

        TreeNode successor = winTree.search(winTree.root, wins);
        winTree.addList(winTree.root, successor, cumple);

        return cumple;
    }
}



