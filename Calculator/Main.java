package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*Stage1
        System.out.println("Prices:");
        System.out.println("Bubblegum: $2");
        System.out.println("Toffee: $0.2");
        System.out.println("Ice cream: $5");
        System.out.println("Milk chocolate: $4");
        System.out.println("Doughnut: $2.5");
        System.out.println("Pancake: $3.2");
         */

        String[] items = new String[]{
            "Bubblegum", "Toffee", "Ice cream", "Milk chocolate", "Doughnut", "Pancake"
        };
        int[] amounts = new int[] {
            202, 118, 2250, 1680, 1075, 80
        };

        int totalAmounts = 0;
        System.out.println("Earned amount:");
        for (int i = 0; i < amounts.length; i++) {
            System.out.println(items[i] + ": $" + amounts[i]);
            totalAmounts += amounts[i];
        }

        System.out.println("\nIncome: $"+totalAmounts + ".0");
        System.out.println("Staff expenses:");
        int staffExpenses = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Other expenses:");
        int otherExpenses = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Net income: $" + (totalAmounts - staffExpenses - otherExpenses));
    }
}