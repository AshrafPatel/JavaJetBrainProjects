package cinema;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Cinema {
    public static Scanner scan = new Scanner(System.in);
    public static int purchasedTickets = 0;
    public static int currentIncome = 0;
    public static String[][] cinema;

    public static void main(String[] args) {
        // Write your code here
        /*System.out.println("Cinema:\n" +
                "  1 2 3 4 5 6 7 8\n" +
                "1 S S S S S S S S\n" +
                "2 S S S S S S S S\n" +
                "3 S S S S S S S S\n" +
                "4 S S S S S S S S\n" +
                "5 S S S S S S S S\n" +
                "6 S S S S S S S S\n" +
                "7 S S S S S S S S");
         */

        System.out.println("Enter the number of rows:");
        int rows = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter the number of seats in each row:");
        int seats = scan.nextInt();
        cinema = makeCinema(rows, seats);
        printCinema(cinema);
        String option = "";
        loop: while (option != "0") {
            System.out.println("\n1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            option = scan.next();

            switch(option) {
                case "1":
                    printCinema(cinema);
                    break;
                case "2":
                    getSeatPrice(rows, seats);
                    break;
                case "3":
                    getStatistics(rows, seats);
                    break;
                case "0":
                    break loop;
                default:
                    System.out.println("Option is invalid");
            }
        }
    }

    private static void getStatistics(int rows, int seats) {
        double percentage = (double) purchasedTickets /(rows*seats);
        percentage *= 100;
        System.out.printf("Number of purchased tickets:" + purchasedTickets + "\n" +
                "Percentage: " + "%.2f" + "%%\n" +
                "Current income: $" + currentIncome + "\n" +
                "Total income: $" + getTotal(rows, seats), percentage);
    }

    public static int getTotal(int rows, int seats) {
        int price = Integer.MIN_VALUE;
        if (rows*seats <= 60)
            price = rows*seats*10;
        else if (rows*seats > 60) {
            int firstRow = rows/2;
            int secondRow = rows/2;

            if (firstRow+secondRow != rows)
                secondRow++;

            int firstPrice = firstRow*seats*10;
            int secondPrice = secondRow*seats*8;
            price = firstPrice+secondPrice;
        }
        return price;
    }

    public static String[][] makeCinema(int rows, int seats) {
        String[][] cinema = new String[rows+1][seats+1];
        cinema[0][0] = " ";
        for (int i = 1; i <= seats; i++) {
            cinema[0][i] = i + "";
        }
        for (int i = 1; i <= rows; i++) {
            for (int j= 0; j <= seats; j++) {
                cinema[i][j] = j==0 ? i + "" : "S";
            }
        }
        return cinema;
    }

    public static void printCinema(String[][] cinema) {
        System.out.println("\nCinema:");
        for (int i =0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                System.out.print(cinema[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void getSeatPrice(int rows, int seats) {
        int price = Integer.MIN_VALUE;
        System.out.println("\nEnter a row number:");
        int row = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter a seat number in that row:");
        int seat = scan.nextInt();

        while (row > rows || seat > seats) {
            System.out.println("Wrong input!");
            getSeatPrice(rows, seats);
        }

        while (cinema[row][seat] == "B") {
            System.out.println("That ticket has already been purchased!");
            getSeatPrice(rows, seats);
        }

        if (rows*seats <= 60) {
            price = 10;
        }
        else if (rows*seats > 60) {
            int firstRow = rows/2;
            int secondRow = rows/2;

            if (row > firstRow)
                price = 8;
            else
                price = 10;
        }
        System.out.println("Ticket price: $" + price + "\n");
        purchasedTickets++;
        currentIncome += price;
        makeBooking(row, seat);
    }

    public static void makeBooking(int row, int seat) {
        cinema[row][seat] = "B";
    }
}