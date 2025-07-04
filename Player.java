public class Player {
    private String playerName;
    private int wins;
    private int draws;
    private int losses;

    public Player(String playerName) {
        this.playerName = playerName;
        this.wins = 0;
        this.draws = 0;
        this.losses = 0;
    }

    public void addWin(){
        this.wins++;
    }
    public void addDraw(){
        this.draws++;
    }
    public void addLoss(){
        this.losses++;
    }
    public double winRate(){
        int total = this.wins + this.draws + this.losses;
        if (total != 0) {
            double porcentaje = this.wins / total;
            return porcentaje;
        }
        else {
            return 0;
        }
    }
    public String getPlayerName() {
        return playerName;
    }
    public int getWins() {
        return wins;
    }
    public int getDraws() {
        return draws;
    }
    public int getLosses() {
        return losses;
    }
}
