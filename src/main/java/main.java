import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.printBoard();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Игрок " + game.getCurrentPlayerMark() + ", Введите строку и столбец (0-2) разделенные пробелом:");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (game.play(row, col)) {
                game.printBoard();
                break;
            } else {
                game.printBoard();
            }
        }
    }
}
