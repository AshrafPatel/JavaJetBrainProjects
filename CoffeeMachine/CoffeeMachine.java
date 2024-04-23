package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        /*
        Project 2
        System.out.println("Write how many cups of coffee you will need:");
        int cupsCoffee = scanner.nextInt();
        System.out.println("For " + cupsCoffee + " cups of coffee you will need:");
        System.out.println((cupsCoffee * 200) + " ml of water");
        System.out.println((cupsCoffee * 50) + " ml of milk");
        System.out.println((cupsCoffee * 15) +" g of coffee beans");
        */

        /*
        Project3
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffee = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        int requiredWater = cups*200;
        int requiredMilk = cups*50;
        int requiredCoffee = cups*15;

        if (water >= requiredWater+200 && milk >= requiredMilk+50 && coffee >= requiredCoffee+15) {
            int potentialWater = requiredWater;
            int potentialMilk = requiredMilk;
            int potentialCoffee = requiredCoffee;
            int potentialCups = cups;

            while (water >= potentialWater && milk >= potentialMilk && coffee >= potentialCoffee) {
                potentialWater += 200;
                potentialMilk += 50;
                potentialCoffee += 15;
                potentialCups++;
            }
            potentialCups -= cups;
            potentialCups--;
            System.out.println("Yes, I can make that amount of coffee (and even " + potentialCups + " more than that)");
        } else if (water >= requiredWater && milk >= requiredMilk && coffee >= requiredCoffee) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            int potentialWater = 0;
            int potentialMilk = 0;
            int potentialCoffee = 0;
            int potentialCups = 0;

            while (water >= potentialWater && milk >= potentialMilk && coffee >= potentialCoffee) {
                potentialWater+=200;
                potentialMilk+=50;
                potentialCoffee+=15;
                potentialCups++;
            }
            potentialCups--;
            System.out.println("No, I can make only " + potentialCups + " cup(s) of coffee");
        }
        */


        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String option = scanner.nextLine();

            switch(option) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "exit":
                    return;
                case "remaining":
                    remaining();
                    break;
                default:
                    System.out.println("Invalid option, Please try again!");
                    break;
            }
        }
    }

    public static void remaining() {
        System.out.println("The coffee machine has:\n" +
                water + " ml of water\n" +
                milk + " ml of milk\n" +
                beans + " g of coffee beans\n" +
                cups + " disposable cups\n" +
                "$" + money + " of money");
    }

    public static void buy() {
        Scanner scan = new Scanner(System.in);

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String option = scan.nextLine();
        boolean canMake = true;

        switch (option) {
            case "1":
                if (water - 250 < 0) {
                    System.out.println("Sorry, not enough water!");
                    canMake = false;
                }
                if (beans - 16 < 0) {
                    System.out.println("Sorry, not enough beans!");
                    canMake = false;
                }
                if (cups - 1 < 0) {
                    System.out.println("Sorry, not enough cups!");
                    canMake = false;
                }

                if (canMake) {
                    water -= 250;
                    beans -= 16;
                    money += 4;
                    cups--;
                }

                break;
            case "2":
                if (water - 350 < 0) {
                    System.out.println("Sorry, not enough water!");
                    canMake = false;
                }
                if (milk - 75 < 0) {
                    System.out.println("Sorry, not enough milk!");
                    canMake = false;
                }
                if (beans - 20 < 0) {
                    System.out.println("Sorry, not enough beans!");
                    canMake = false;
                }
                if (cups - 1 < 0) {
                    System.out.println("Sorry, not enough cups!");
                    canMake = false;
                }

                if (canMake) {
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    money += 7;
                    cups--;
                }

                break;
            case "3":
                if (water - 200 < 0) {
                    System.out.println("Sorry, not enough water!");
                    canMake = false;
                }
                if (milk - 100 < 0) {
                    System.out.println("Sorry, not enough milk!");
                    canMake = false;
                }
                if (beans - 12 < 0) {
                    System.out.println("Sorry, not enough beans!");
                    canMake = false;
                }
                if (cups - 1 < 0) {
                    System.out.println("Sorry, not enough cups!");
                    canMake = false;
                }

                if (canMake) {
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    money+= 6;
                    cups--;
                }

                break;
            case "back":
                break;
            default:
                System.out.println("Unrecognised input, Terminating...");
                break;
        }
    }

    public static void fill() {
        System.out.println("Write how many ml of water you want to add: ");
        water+=scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milk+= scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        beans+= scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        cups+= scanner.nextInt();
    }

    public static void take() {
        money -= money;
    }
}
