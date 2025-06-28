public class ConnectFour {
    private char[][] grid;
    private char currentSymbol;
    private char winner;

    public ConnectFour() {
        grid = new char[7][6];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                grid[i][j] = ' ';
            }
        }
        currentSymbol = 'X';
        winner = ' ';
    }

    public void makeMove(int n) {
        int num = n - 1;
        for (int i = 6; i >= 0; i--) {
            if (grid[i][num] == ' ') {
                grid[i][num] = currentSymbol;
                if (currentSymbol == 'X') {
                    currentSymbol = 'O';
                }
                else if (currentSymbol == 'O') {
                    currentSymbol = 'X';
                }
                return  ;
            }
        }
        System.out.println("La columna está llena.");
    }

    public boolean isGameOver() {
        if(isFull()){
            return true;
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                int counter = 0;
                char c = grid[i][j];
                if (c == ' ') continue;

                    if(j + 3 < 6 && c == grid[i][j+1] && c == grid[i][j+2] && c == grid[i][j+3]){
                        this.winner = c;
                        return true;
                    }

                    if(i + 3 < 7 && c == grid[i+1][j] && c == grid[i+2][j] && c == grid[i+3][j]){
                        this.winner = c;
                        return true;
                    }

                    if(i + 3 < 7 && j + 3 < 6 && c == grid[i+1][j+1] && c == grid[i+2][j+2] && c == grid[i+3][j+3]){
                        this.winner = c;
                        return true;
                    }
            }
        }
        return false;
    }

    public boolean isFull(){
        int casilla = 0;
        for (int i = 0; i < 6; i++) {
            if (grid[0][i] != ' ') {
                casilla++;
            }
        }
        if (casilla < 6) {
            return false;
        }
        return true;
    }

    public void imprimir(){
        System.out.println("| 1 | 2 | 3 | 4 | 5 | 6 |");
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print("| " + grid[i][j] + " ");
            }
            System.out.println(" |");
        }
    }

    public char getCurrentSymbol() {
        return currentSymbol;
    }

    public char getWinner() {
        return winner;
    }
}
