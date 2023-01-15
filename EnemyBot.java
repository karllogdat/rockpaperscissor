import java.util.Random;

public class EnemyBot {
    static int choiceBound = 3;

    public String generateChoice() {
        Random choice = new Random();

        int intChoice = choice.nextInt(choiceBound);
        
        switch(intChoice) {
            case 0:
                return "Rock";
            case 1: 
                return "Paper";
            case 2: 
                return "Scissor";
            default:
                return "ERROR";
        }
    }
}