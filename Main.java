import java.util.Scanner;

class Main {
    // For input purposes
    static Scanner input = new Scanner(System.in);
    
    static String getPlayerChoice() {
        System.out.println("\nEnter choice: ");
        System.out.println("0: Rock");
        System.out.println("1: Paper");
        System.out.println("2: Scissor\n");

        String choice = input.nextLine();

        switch (choice) {
            case "0":
                return "Rock";
            case "1":
                return "Paper";
            case "2":
                return "Scissor";
        }

        return "error";
    }

    static int compareChoice(String choice1, String choice2) {
        // 0 = draw
        // 1 = lose
        // 2 = win

        switch (choice1) {
            case "Rock":
                switch (choice2) {
                    case "Rock":
                        return 0;
                    case "Paper":
                        return 1;
                    case "Scissor":
                        return 2;
                }

            case "Paper":
                switch (choice2) {
                    case "Rock":
                        return 2;
                    case "Paper":
                        return 0;
                    case "Scissor":
                        return 1;
                }

            case "Scissor":
                switch (choice2) {
                    case "Rock":
                        return 1;
                    case "Paper":
                        return 2;
                    case "Scissor":
                        return 0;
                }
        }

        // Indicates an error
        return 3;
    }

    static String displayResult(int result) {
        switch (result) {
            case 0:
                return "draw";
            case 1:
                return "loss";
            case 2: 
                return "victory";
        }

        return "error";
    }

    static boolean continueGame() {
        System.out.println("\nContinue game? ");
        System.out.println("0: No - 1: Yes\n");

        if (Integer.parseInt(input.nextLine()) == 0)
            return false;
        else 
            return true;
    }

    public static void main(String[] args) {
        // Why the fuck do I need to separate class files
        EnemyBot enemy = new EnemyBot();
        boolean gameState = true;

        while(gameState != false) {
            System.out.printf("\nThe game ended in a %s\n", displayResult(compareChoice(getPlayerChoice(), enemy.generateChoice())));

            gameState = continueGame();
        }
    }
}