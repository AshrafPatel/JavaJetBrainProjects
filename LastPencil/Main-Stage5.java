import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int pencils;
    static String name1;
    static String name2;

    public static void main(String[] args) {
        System.out.println("How many pencils would you like to use:");
        checkPencilUse();

        System.out.println("Who will be the first (John, Jack):");
        checkName();
        displayPencils();

        boolean player1Turn = true;
        while (pencils > 0) {
            if (player1Turn) {
                System.out.println(name1 + "'s turn!");
                if (name1.equals("Jack"))
                    botTakePencil();
                else
                    checkPencilsTaken();
                displayPencils();
            } else {
                System.out.println(name2 + "'s turn:");
                if (name2.equals("Jack"))
                    botTakePencil();
                else
                    checkPencilsTaken();
                displayPencils();
            }

            player1Turn = !player1Turn;
        }

        if (player1Turn) {
            System.out.println(name1 + " won!");
        } else {
            System.out.println(name2 + " won!");
        }
    }

    public static void displayPencils() {
        String pencilStr = "";
        for (int i = 0; i < pencils; i++) {
            pencilStr += "|";
        }
        if (pencils > 0)
            System.out.println(pencilStr);
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
                } else {
                    name2 = "John";
                }
                break;
            }
        }
    }

    public static void checkPencilsTaken() {
        while (true) {
            String pencilCount = scanner.nextLine();
            if (String.valueOf(pencilCount).matches("\\d+")) {
                int pencilTaken = Integer.parseInt(pencilCount);
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

    public static void botTakePencil() {
        int pencilsTaken;
        if (pencils == 1) {
            pencilsTaken = 1;
        } else {
            int strategy;
            for (strategy = 0; strategy <= 3; strategy++) {
                if ((pencils + strategy - 1) % 4 == 0) {
                    break;
                }
            }
            if (strategy == 0) {
                pencilsTaken = new Random().nextInt(1,4);
            } else {
                pencilsTaken = 3 - (strategy - 1);
            }
        }
        System.out.println(String.valueOf(pencilsTaken));
        pencils -= pencilsTaken;
    }
}
