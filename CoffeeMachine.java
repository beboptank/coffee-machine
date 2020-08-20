package machine;
import java.util.*;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userAction = scanner.nextLine();

        int water = 400;
        int milk = 540;
        int coffeeBeans = 120;
        int cups = 9;
        int money = 550;

        while (!userAction.equals("exit")) {

            switch (userAction) {
                case "buy":
                    System.out.println();
                    System.out.print("What do you want to buy?");
                    System.out.println(" 1 - espresso, 2 - latte, 3 - cappuccino:");
                    String userOrder = scanner.nextLine();

                    switch (userOrder) {
                        case "1":
                            if (water >= 250 && milk >= 0 && coffeeBeans >= 16 && cups > 0) {
                                System.out.println("I have enough resources, making you a coffee!");
                                water -= 250;
                                coffeeBeans -= 16;
                                cups -= 1;
                                money += 4;
                            } else if (water < 250) {
                                System.out.println("Sorry, not enough water!");
                            } else if (coffeeBeans < 16) {
                                System.out.println("Sorry, not enough coffee!");
                            } else if (cups == 0) {
                                System.out.println("Sorry, not enough cups!");
                            } else {
                                System.out.println("Sorry, not enough resources!");
                            }

                            System.out.println();
                            System.out.println("Write action (buy, fill, take, remaining, exit):");
                            userAction = scanner.nextLine();
                            break;
                        case "2":
                            if (water >= 350 && milk >= 75 && coffeeBeans >= 20 && cups > 0) {
                                System.out.println("I have enough resources, making you a coffee!");
                                water -= 350;
                                milk -= 75;
                                coffeeBeans -= 20;
                                cups -= 1;
                                money += 7;
                            } else if (water < 350) {
                                System.out.println("Sorry, not enough water!");
                            } else if (milk < 75) {
                                System.out.println("Sorry, not enough milk!");
                            } else if (coffeeBeans < 20) {
                                System.out.println("Sorry, not enough coffee!");
                            } else if (cups == 0) {
                                System.out.println("Sorry, not enough cups!");
                            } else {
                                System.out.println("Sorry, not enough resources!");
                            }

                            System.out.println();
                            System.out.println("Write action (buy, fill, take, remaining, exit):");
                            userAction = scanner.nextLine();
                            break;
                        case "3":
                            if (water >= 200 && milk >= 100 && coffeeBeans >= 12 && cups > 0) {
                                System.out.println("I have enough resources, making you a coffee!");
                                water -= 200;
                                milk -= 100;
                                coffeeBeans -= 12;
                                cups -= 1;
                                money += 6;
                            } else if (water < 200) {
                                System.out.println("Sorry, not enough water!");
                            } else if (milk < 100) {
                                System.out.println("Sorry, not enough milk!");
                            } else if (coffeeBeans < 12) {
                                System.out.println("Sorry, not enough coffee!");
                            } else if (cups == 0) {
                                System.out.println("Sorry, not enough cups!");
                            } else {
                                System.out.println("Sorry, not enough resources!");
                            }

                            System.out.println();
                            System.out.println("Write action (buy, fill, take, remaining, exit):");
                            userAction = scanner.nextLine();
                            break;
                        default:
                            System.out.println("Error, please enter 1, 2, or 3.");

                            System.out.println();
                            System.out.println("Write action (buy, fill, take, remaining, exit):");
                            userAction = scanner.nextLine();
                            break;
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add:");
                    int addWater = scanner.nextInt();
                    System.out.println("Write how many ml of milk do you want to add:");
                    int addMilk = scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    int addCoffeeBeans = scanner.nextInt();
                    System.out.println(("Write how many disposable cups of coffee do you want to add:"));
                    int addCoffeeCups = scanner.nextInt();
                    water += addWater;
                    milk += addMilk;
                    coffeeBeans += addCoffeeBeans;
                    cups += addCoffeeCups;

                    System.out.println();
                    System.out.println("Write action (buy, fill, take, remaining, exit):");
                    userAction = scanner.nextLine();
                    break;
                case "take":
                    System.out.println("I gave you $" + money);
                    money = 0;
                    System.out.println();
                    System.out.println("Write action (buy, fill, take, remaining, exit):");
                    userAction = scanner.nextLine();
                    break;
                case "remaining":
                    System.out.println();
                    System.out.println("The coffee machine has:");
                    System.out.println(water + " of water");
                    System.out.println(milk + " of milk");
                    System.out.println(coffeeBeans + " of coffee beans");
                    System.out.println(cups + " of disposable cups");
                    System.out.println(money + " of money");

                    System.out.println();
                    System.out.println("Write action (buy, fill, take, remaining, exit):");
                    userAction = scanner.nextLine();
                    break;
                default:
                    System.out.println("Error, please try again.");
                    System.out.println();
                    System.out.println("Write action (buy, fill, take, remaining, exit):");
                    userAction = scanner.nextLine();
                    break;
            }
        }
    }

}