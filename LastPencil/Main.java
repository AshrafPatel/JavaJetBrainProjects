package lastpencil;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int pencils;
    static String name1;
    static String name2;
    public static void main(String[] args) {
        /*TASK 1
        System.out.println("|||");
        System.out.println("Your turn!");
        */

        /*TASK 2
        System.out.println("How many pencils would you like to use:");
        int pencils = scanner.nextInt();
        System.out.println("Who will be the first (John, Jack):");
        String name1 = scanner.next();
        scanner.nextLine();
        String pencilScore = "";
        for (int i = 0; i < pencils; i++)
            pencilScore += "|";
        System.out.println(pencilScore);
        System.out.println(name1 + " is going first!");
        */

        /*TASK 3*/
        System.out.println("How many pencils would you like to use:");
        checkPencilUse();

        System.out.println("Who will be the first (John, Jack):");
        checkName();

        boolean player1Turn = true;
        String pencilScore = "";
        while (pencils > 0) {
            for (int i = 0; i < pencils; i++) {
                pencilScore += "|";
            }
            System.out.println(pencilScore);
            if (player1Turn) {
                System.out.println(name1 + "'s turn!");
            } else {
                System.out.println(name2 + "'s turn!");
            }
            checkPencilsTaken();
            player1Turn = !player1Turn;
            pencilScore = "";
        }

        if (player1Turn) {
            System.out.println(name1 + "won");
        } else {
            System.out.println(name2 + "won");
        }
    }

    public static void checkPencilUse() {
        while (true) {
            String pencilCount = scanner.nextLine();
            if (pencilCount.matches("\\d+")) {
                pencils = Integer.parseInt(pencilCount);
                if (pencils <= 0)
                    System.out.println("The number of pencils should be positive");
                else
                    break;
            } else {
                System.out.println("The number of pencils should be numeric");
            }
        }
    }

    public static void checkName() {
        while (true) {
            name1 = scanner.nextLine();
            if (!name1.equals("John") && !name1.equals("Jack")) {
                System.out.println("Choose between John and Jack");
            } else {
                if (name1.equals("John")) {
                    name2 = "Jack";
                }
                else {
                    name2 = "John";
                }
                break;
            }
        }
    }

    public static void checkPencilsTaken() {
        while (true) {
            String pencilCount = scanner.nextLine();
            int pencilTaken;
            if (pencilCount.matches("\\d+")) {
                pencilTaken = Integer.parseInt(pencilCount);
                if (pencilTaken <= 0) {
                    System.out.println("Possible values: '1', '2' or '3'");
                } else if (pencilTaken > 3) {
                    System.out.println("Possible values: '1', '2' or '3'");
                } else if (pencilTaken > pencils) {
                    System.out.println("Too many pencils were taken");
                } else {
                    pencils -= pencilTaken;
                    break;
                }
            } else {
                System.out.println("Possible values: '1', '2' or '3'");
            }
        }
    }
}
