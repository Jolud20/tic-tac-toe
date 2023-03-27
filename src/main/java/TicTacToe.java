public class TicTacToe {
    private final char[][] board;
    private char currentPlayerMark;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayerMark = 'X';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
    public char getCurrentPlayerMark() {
        return currentPlayerMark;
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean play(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Неверный ход. Пожалуйста попробуйте снова.");
            return false;
        }

        if (board[row][col] != '-') {
            System.out.println("Эта клетка уже занята. Пожалуйста попробуйте снова.");
            return false;
        }

        board[row][col] = currentPlayerMark;

        if (hasWon()) {
            System.out.println("Поздравляю! Игрок " + currentPlayerMark + " победил в игре!");
            return true;
        }

        if (isBoardFull()) {
            System.out.println("Ничья!");
            return true;
        }

        changePlayer();
        return false;
    }

    private void changePlayer() {
        if (currentPlayerMark == 'X') {
            currentPlayerMark = 'O';
        } else {
            currentPlayerMark = 'X';
        }
    }
    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean hasWon() {
        // Проверяем, есть ли выигрышные комбинации в строках
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return true;
            }
        }

        // Проверяем, есть ли выигрышные комбинации в столбцах
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
                return true;
            }
        }

        // Проверяем, есть ли выигрышные комбинации в диагоналях
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
            return true;
        }
        return false;
    }
}
