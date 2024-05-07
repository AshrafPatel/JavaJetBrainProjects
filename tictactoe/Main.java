package tictactoe;

import java.util.Scanner;

public class Main {
    public static Scanner scan;
    public static void main(String[] args) {

        /*Stage 1
        System.out.println("X O X");
        System.out.println("O X O");
        System.out.println("X X O");
        */

        scan = new Scanner(System.in);
        char[] inputArr = new char[]{'_','_','_','_','_','_','_','_','_'};
        char[][] gameArr = createGameStateArr(inputArr);
        printGame(gameArr);
        boolean player1 = true;
        boolean draw;
        while (checkWins(gameArr).length() <= 1) {
            draw = true;
            for (int i = 0; i < gameArr.length; i++) {
                for (int j = 0; j < gameArr[i].length; j++) {
                    if (gameArr[i][j] == '_') {
                        draw = false;
                        break;
                    }
                }
            }

            if (draw) {
                System.out.println("Draw");
                break;
            }

            makeMove(gameArr, player1);
            printGame(gameArr);
            player1 = !player1;
        }
        if (checkWins(gameArr).length() >= 2) {
            System.out.print(checkWins(gameArr));
        }
    }

    public static void printGame(char[][] gameStateArr) {
        System.out.println("---------");
        for (int i = 0; i < gameStateArr.length; i++) {
            System.out.printf("| %s %s %s |%n", gameStateArr[i][0], gameStateArr[i][1], gameStateArr[i][2]);
        }
        System.out.println("---------");
    }

    public static char[][] createGameStateArr(char[] inputArr) {
        char[][] gameStateArr = new char[3][3];
        int j = 0;
        while (j < 3) {
            for (int i = 0; i < inputArr.length; i+=3) {
                gameStateArr[j][0] = inputArr[i];
                gameStateArr[j][1] = inputArr[i+1];
                gameStateArr[j][2] = inputArr[i+2];
                j++;
            }
        }
        return gameStateArr;
    }

    public static void makeMove(char[][] gameState, boolean player1) {
        String coordinates = scan.nextLine();
        String[] coorArr = coordinates.split(" ");

        if (coorArr.length != 2 || coorArr[0].contains(".*\\\\d.*") || coorArr[1].contains(".*\\\\d.*")) {
            System.out.println("You should enter numbers!");
            makeMove(gameState, player1);
        }
        int row = Integer.parseInt(coorArr[0]);
        int col = Integer.parseInt(coorArr[1]);
        if (row > 3 || row < 1 || col > 3 || col < 1) {
            System.out.println("Coordinates should be from 1 to 3!");
            makeMove(gameState, player1);
        } else if (gameState[row-1][col-1] == 'X' || gameState[row-1][col-1] == 'O') {
            System.out.println("This cell is occupied! Choose another one!");
            makeMove(gameState, player1);
        } else {
            if (player1)
                gameState[row-1][col-1] = 'X';
            else
                gameState[row-1][col-1] = 'O';
        }
    }


    public static String checkWins (char[][] gameState) {
        String winnerOutput = "";
        //Horizontal Wins
        if (gameState[0][0] == gameState[0][1] && gameState[0][1] == gameState[0][2]) {
            if (gameState[0][0] == 'X')
                winnerOutput += "\nX wins";
            else if (gameState[0][0] == 'O')
                winnerOutput += "\nO wins";
        }
        if (gameState[1][0] == gameState[1][1] && gameState[1][1] == gameState[1][2]) {
            if (gameState[1][0] == 'X')
                winnerOutput += "\nX wins";
            else if (gameState[1][0] == 'O')
                winnerOutput += "\nO wins";
        }
        if (gameState[2][0] == gameState[2][1] && gameState[2][1] == gameState[2][2]) {
            if (gameState[2][0] == 'X')
                winnerOutput += "\nX wins";
            else if (gameState[2][0] == 'O')
                winnerOutput += "\nO wins";
        }
        //Vertical Wins
        if (gameState[0][0] == gameState[1][0] && gameState[1][0] == gameState[2][0]) {
            if (gameState[0][0] == 'X')
                winnerOutput += "\nX wins";
            else if (gameState[0][0] == 'O')
                winnerOutput += "\nnO wins";
        }
        if (gameState[0][1] == gameState[1][1] && gameState[1][1] == gameState[2][1]) {
            if (gameState[0][1] == 'X')
                winnerOutput += "\nX wins";
            else if (gameState[0][1] == 'O')
                winnerOutput += "\nO wins";
        }
        if (gameState[0][2] == gameState[1][2] && gameState[1][2] == gameState[2][2]) {
            if (gameState[0][2] == 'X')
                winnerOutput += "\nX wins";
            else if (gameState[0][2] == 'O')
                winnerOutput += "\nO wins";
        }
        //Diagonal Wins
        if (gameState[0][0] == gameState[1][1] && gameState[1][1] == gameState[2][2]) {
            if (gameState[0][0] == 'X')
                winnerOutput += "\nX wins";
            else if (gameState[0][0] == 'O')
                winnerOutput += "\nO wins";
        }
        if (gameState[2][0] == gameState[1][1] && gameState[1][1] == gameState[0][2]) {
            if (gameState[2][0] == 'X')
                winnerOutput += "\nX wins";
            else if (gameState[2][0] == 'O')
                winnerOutput += "\nO wins";
        }
        return winnerOutput;
    }

    /*
    FOR STAGE 3 AND 4
    public static boolean checkImpossible(char[] inputArr, String winnerOutput) {
        String xCount = "";
        String oCount = "";
        int difference;
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] == 'X')
                xCount += "X";
            else if (inputArr[i] == 'O')
                oCount += "O";
        }
        if (xCount.length() > oCount.length())
            difference = xCount.length() - oCount.length();
        else
            difference = oCount.length() - xCount.length();
        if (difference > 1)
            return true;

        if (winnerOutput.length() > 1) {
            if (winnerOutput.contains("O") && winnerOutput.contains("X"))
                return true;
        }
        return false;
    }
    */
}
