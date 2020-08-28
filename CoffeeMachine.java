package machine;
import java.util.*;

public class CoffeeMachine {

    private final Scanner scanner;

    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;

    private CoffeeMachine() {
        this.scanner = new Scanner(System.in);
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.cups = 9;
        this.money = 550;
    }

    public static void main(String[] args) {
        CoffeeMachine userCoffeeMachine = new CoffeeMachine();

        boolean coffeeMachineStatus;
        do {
            coffeeMachineStatus = userCoffeeMachine.processAction();
        }
        while (coffeeMachineStatus);
    }

    private void buyAction() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String command = this.scanner.nextLine();

        if (command.equals("back")) {
            return;
        }

        this.buy(Integer.parseInt(command));
    }

    private void fillMachine(int water, int milk, int beans, int cups) {
        this.water += water;
        this.milk += milk;
        this.coffeeBeans += beans;
        this.cups += cups;
    }

    public void printSupplies() {
        System.out.println("The coffee machine has:\n" +
                String.format("%d of water\n", this.water) +
                String.format("%d of milk\n", this.milk) +
                String.format("%d of coffee beans\n", this.coffeeBeans) +
                String.format("%d of disposable cups\n", this.cups) +
                String.format("%d of money", this.money)
                );
    }

    private void fillAction() {
        System.out.println("Write how many ml of water do you want to add:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int beans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cups = scanner.nextInt();

        this.fillMachine(water, milk, beans, cups);

    }

    private void takeAction() {
        System.out.printf("I gave you $%d%n", this.money);
        this.take();
    }

    private void take() {
        this.money = 0;
    }

    private void buy(int type) {
        int water = 0;
        int milk = 0;
        int beans = 0;
        int money = 0;

        switch (type) {
            case 1: {
                water = 250;
                milk = 0;
                beans = 16;
                money = 4;
                break;
            }
            case 2: {
                water = 350;
                milk = 75;
                beans = 20;
                money = 7;
                break;
            }
            case 3: {
                water = 200;
                milk = 100;
                beans = 12;
                money = 6;
                break;
            }
            default: {
                break;
            }
        }

        if (this.water < water) {
            System.out.println("Sorry, not enough water!");
        } else if (this.milk < milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (this.coffeeBeans < beans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (this.cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            this.water -= water;
            this.milk -= milk;
            this.coffeeBeans -= beans;
            this.cups--;
            this.money += money;
        }
    }

    public boolean processAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = this.scanner.nextLine();

        switch (action) {
            case "buy": {
                this.buyAction();
                break;
            }
            case "fill": {
                this.fillAction();
                break;
            }
            case "take": {
                this.takeAction();
                break;
            }
            case "remaining": {
                this.printSupplies();
                break;
            }
            case "exit": {
                return false;
            }
            default: {
                break;
            }
        }
        return true;
    }
}
