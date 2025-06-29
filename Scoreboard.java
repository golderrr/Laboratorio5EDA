import java.util.*;
import java.io.*;

public class Scoreboard {
    private BST winTree = new BST();
    private Hashtable<String, Player> players = new Hashtable<>();
    int playedGames = 0;

    public void registerPlayer(String playerName) {
        if (!players.containsKey(playerName)) {
            Player player = new Player(playerName);
            players.put(playerName, player);
            winTree.insert(0, playerName);
        }
    }

    public boolean checkPlayer(String playerName) {
        return players.containsKey(playerName);
    }

    public Player[] winRange(int lo, int hi) {
        HashSet<String> cumplen = new HashSet<>();
        if (lo > hi) return new Player[0];

        TreeNode root2 = winTree.getRoot();
        fillHashSet(root2, lo, hi, cumplen);

        List<Player> listaJugadores = new ArrayList<>();
        for (String nombre : cumplen) {
            Player p = players.get(nombre);
            if (p != null) {
                listaJugadores.add(p);
            }
        }

        Player[] result = new Player[listaJugadores.size()];
        return listaJugadores.toArray(result);
    }

    private void fillHashSet(TreeNode node, int lo, int hi, HashSet<String> cumplen) {
        if (node == null) return;

        if (node.victorias >= lo && node.victorias <= hi) {
            cumplen.add(node.nombre);
        }

        fillHashSet(node.left, lo, hi, cumplen);
        fillHashSet(node.right, lo, hi, cumplen);
    }

    public Player[] winSuccessor(int wins) {
        HashSet<String> cumplen = new HashSet<>();
        int wins2 = revisar(winTree.getRoot(), wins);

        checkSuccessors(winTree.getRoot(), wins2, cumplen);

        if(cumplen.size() == 0) return new Player[0];

        List<Player> listaJugadores = new ArrayList<>();
        for (String nombre : cumplen) {
            Player p = players.get(nombre);
            if (p != null) {
                listaJugadores.add(p);
            }
        }

        Player[] result = new Player[listaJugadores.size()];
        return listaJugadores.toArray(result);

    }
    private int revisar(TreeNode root, int wins){
        if(root == null) return wins;

        if(root.victorias >= wins) return root.victorias;
        return revisar(root.right, wins);
    }

    private void checkSuccessors(TreeNode node, int wins, HashSet<String> cumplen) {
        if (node == null) return;

        if (node.victorias == wins){
            cumplen.add(node.nombre);
        }

        checkSuccessors(node.left, wins, cumplen);
        checkSuccessors(node.right, wins, cumplen);
    }

    public void addGameResult(String winnerPlayerName, String looserPlayerName, boolean draw) {
        if(draw){
            Player p1 = players.get(winnerPlayerName);
            Player p2 = players.get(looserPlayerName);
            if (p1 != null) p1.addDraw();
            if (p2 != null) p2.addDraw();
            playedGames++;
            return;
        }

        if (!draw) {
            Player winner = players.get(winnerPlayerName);
            Player looser = players.get(looserPlayerName);

            if (winner == null || looser == null) return;
            winTree.borrarPorNombre(winnerPlayerName);

            winner.addWin();
            looser.addLoss();

            winTree.insert(winner.getWins(), winnerPlayerName);
            playedGames++;
        }
    }

}


