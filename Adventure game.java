import java.util.Random;
import java.util.Scanner;

public class TextAdventureGame {

    // Game variables
    private static int score = 0;
    private static int health = 100;
    private static boolean hasTreasure = false;
    private static Scanner scanner = new Scanner(System.in);

    // Main method where the game starts
    public static void main(String[] args) {
        System.out.println("Welcome to the Mystical Forest Adventure!");
        System.out.println("You find yourself at the entrance of a mystical forest.");
        System.out.println("You have two paths ahead. Enter the number for your choice:");
        System.out.println("1. Go left");
        System.out.println("2. Go right");

        // Get the user's first choice
        int firstChoice = getUserInput();

        // Handle the user's first choice
        handleFirstChoice(firstChoice);

        // If the player has found the treasure, explore the mystical village
        if (hasTreasure) {
            exploreMysticalVillage();
        }

        // End the game
        endGame();
    }

    // Method to handle the user's first choice
    private static void handleFirstChoice(int firstChoice) {
        if (firstChoice == 1) {
            handleLeftPath();
        } else if (firstChoice == 2) {
            handleRightPath();
        } else {
            handleInvalidInput();
        }
    }

    // Method to handle the left path
    private static void handleLeftPath() {
        System.out.println("As you venture deeper into the forest, you encounter a talking owl.");
        System.out.println("The owl offers to guide you. Enter the number for your choice:");
        System.out.println("1. Accept the owl's guidance");
        System.out.println("2. Decline and explore on your own");

        // Get the user's second choice
        int secondChoice = getUserInput();

        if (secondChoice == 1) {
            System.out.println("The owl leads you to a hidden treasure. Congratulations, you found the treasure!");
            score += 50;
            hasTreasure = true;
        } else if (secondChoice == 2) {
            System.out.println("You decide to explore on your own and get lost. Game over!");
            endGame();
        } else {
            handleInvalidInput();
        }
    }

    // Method to handle the right path
    private static void handleRightPath() {
        System.out.println("You come across a magical river. Enter the number for your choice:");
        System.out.println("1. Swim across");
        System.out.println("2. Build a bridge");
        System.out.println("3. Fight a creature");

        // Get the user's second choice
        int secondChoice = getUserInput();

        if (secondChoice == 1) {
            // Handle swimming across the river
            System.out.println("You bravely swim across and find a beautiful clearing.");
            System.out.println("In the clearing, you see a mysterious door. Enter the number for your choice:");
            System.out.println("1. Open the door");
            System.out.println("2. Ignore the door");

            // Get the user's third choice
            int thirdChoice = getUserInput();

            if (thirdChoice == 1) {
                // Handle opening the door
                System.out.println("You open the door and discover a portal to another world. Congratulations, you found a magical portal!");
                score += 100;
            } else if (thirdChoice == 2) {
                // Handle ignoring the door
                System.out.println("You choose to ignore the door and continue exploring. Game over!");
                endGame();
            } else {
                handleInvalidInput();
            }

        } else if (secondChoice == 2) {
            // Handle building a bridge
            System.out.println("You spend too much time trying to build a bridge, and the sun sets. Game over!");
            endGame();
        } else if (secondChoice == 3) {
            // Handle fighting a creature
            System.out.println("You encounter a fierce creature. Enter the number for your choice:");
            System.out.println("1. Fight");
            System.out.println("2. Run");

            // Get the user's choice for fighting or running
            int fightChoice = getUserInput();

            if (fightChoice == 1) {
                // Handle the fight
                handleFight();
            } else if (fightChoice == 2) {
                // Handle running away
                System.out.println("You choose to run, but the creature catches you. Game over!");
                endGame();
            } else {
                handleInvalidInput();
            }
        } else {
            handleInvalidInput();
        }
    }

    // Method to explore the mystical village
    private static void exploreMysticalVillage() {
        System.out.println("As you journey further, you come across a mystical village in the heart of the forest.");
        System.out.println("The villagers welcome you and invite you to meet their wise elder.");
        System.out.println("Enter the number for your choice:");
        System.out.println("1. Accept the invitation");
        System.out.println("2. Decline and continue your journey");

        // Get the user's choice to accept or decline the invitation
        int villageChoice = getUserInput();

        if (villageChoice == 1) {
            // Handle meeting the wise elder
            meetWiseElder();
        } else if (villageChoice == 2) {
            // Continue the journey without entering the village
            System.out.println("You decline the invitation and continue your journey through the forest.");
        } else {
            handleInvalidInput();
        }
    }

    // Method to handle meeting the wise elder
    private static void meetWiseElder() {
        System.out.println("You meet the wise elder who tells you about an impending danger to the forest.");
        System.out.println("The elder asks for your help to retrieve a magical artifact that can save the forest.");
        System.out.println("Enter the number for your choice:");
        System.out.println("1. Agree to help");
        System.out.println("2. Refuse and leave the village");

        // Get the user's choice to agree or refuse the elder's request
        int elderChoice = getUserInput();

        if (elderChoice == 1) {
            // Handle agreeing to help and starting the quest
            System.out.println("The elder provides you with a map and directions to the artifact.");
            System.out.println("Your quest to save the mystical forest begins!");
            embarkOnQuest();
        } else if (elderChoice == 2) {
            // Handle refusing to help and leaving the village
            System.out.println("You decide not to help. The elder is disappointed, and you leave the village.");
            endGame();
        } else {
            handleInvalidInput();
        }
    }

    // Method to embark on the quest to retrieve the magical artifact
    private static void embarkOnQuest() {
        System.out.println("You follow the map and face various challenges on your quest.");
        System.out.println("During your journey, you come across a mystical creature guarding the artifact.");
        System.out.println("Enter the number for your choice:");
        System.out.println("1. Fight");
        System.out.println("2. Negotiate");

        // Get the user's choice to fight or negotiate with the creature
        int questChoice = getUserInput();

        if (questChoice == 1) {
            // Handle engaging in a battle with the creature
            System.out.println("You engage in a fierce battle with the mystical creature!");
            handleFight();
        } else if (questChoice == 2) {
            // Handle negotiating with the creature
            System.out.println("You try to negotiate with the creature using your wits.");
            System.out.println("The creature is impressed and allows you to take the artifact peacefully.");
            score += 150;
        } else {
            handleInvalidInput();
        }

        // Display success message for completing the quest
        System.out.println("Congratulations! You successfully retrieve the magical artifact and save the mystical forest!");
    }

    // Method to handle the fight with the mystical creature
    private static void handleFight() {
        int creatureHealth = 80;
        System.out.println("You enter into a fierce battle with the mystical creature!");
        System.out.println("Your health: " + health);
        System.out.println("Creature's health: " + creatureHealth);

        // Continue the battle until either the player or the creature is defeated
        while (health > 0 && creatureHealth > 0) {
            System.out.println("Choose your action. Enter the number for your choice:");
            System.out.println("1. Attack");
            System.out.println("2. Defend");

            // Get the user's choice for attacking or defending
            int action = getUserInput();

            if (action == 1) {
                // Handle the player's attack
                handleAttack(creatureHealth);
            } else if (action == 2) {
                // Handle the player's defense
                handleDefend(creatureHealth);
            } else {
                handleInvalidInput();
            }
        }

        // Check the result of the battle and end the game accordingly
        if (health <= 0) {
            System.out.println("You were defeated in battle. Game over!");
            endGame();
        } else {
            if (health > creatureHealth) {
                System.out.println("You defeated the creature in battle! Congratulations!");
                score += 50;
                System.out.println("You are victorious! You have completed the mystical forest adventure!");
                endGame();
            } else {
                System.out.println("You won the battle, but your health is not enough to continue. Game over!");
                endGame();
            }
        }
    }

    // Method to handle the player's attack during the fight
    private static void handleAttack(int creatureHealth) {
        System.out.println("Choose your attack move. Enter the number for your choice:");
        System.out.println("1. Quick Strike");
        System.out.println("2. Power Slash");
        System.out.println("3. Fireball");

        // Get the user's choice for the attack move
        int attackChoice = getUserInput();

        // Execute the chosen attack move
        switch (attackChoice) {
            case 1:
                quickStrike(creatureHealth);
                break;
            case 2:
                powerSlash(creatureHealth);
                break;
            case 3:
                fireball(creatureHealth);
                break;
            default:
                System.out.println("Invalid choice. You fumbled the attack!");
                break;
        }
    }

    // Method to handle the Quick Strike attack move
    private static void quickStrike(int creatureHealth) {
        int playerAttack = new Random().nextInt(15) + 10; // Random attack between 10 and 25

        // Update creature's health after the player's attack
        creatureHealth -= playerAttack;

        // Display attack details
        System.out.println("You perform a Quick Strike, dealing " + playerAttack + " damage.");
        System.out.println("Your health: " + health);
        System.out.println("Creature's health: " + creatureHealth);
    }

    // Method to handle the Power Slash attack move
    private static void powerSlash(int creatureHealth) {
        int playerAttack = new Random().nextInt(30) + 20; // Random attack between 20 and 50

        // Update creature's health after the player's attack
        creatureHealth -= playerAttack;

        // Display attack details
        System.out.println("You execute a Power Slash, dealing " + playerAttack + " damage.");
        System.out.println("Your health: " + health);
        System.out.println("Creature's health: " + creatureHealth);
    }

    // Method to handle the Fireball attack move
    private static void fireball(int creatureHealth) {
        int playerAttack = new Random().nextInt(25) + 15; // Random attack between 15 and 40

        // Update creature's health after the player's attack
        creatureHealth -= playerAttack;

        // Display attack details
        System.out.println("You unleash a Fireball, dealing " + playerAttack + " damage.");
        System.out.println("Your health: " + health);
        System.out.println("Creature's health: " + creatureHealth);
    }

    // Method to handle the player's defense during the fight
    private static void handleDefend(int creatureHealth) {
        int creatureAttack = new Random().nextInt(20) + 10; // Random attack between 10 and 30
        health -= creatureAttack / 2; // Defending reduces the damage by half

        // Display defense details
        System.out.println("You choose to defend. The creature's attack is reduced to " + (creatureAttack / 2) + " damage.");
        System.out.println("Your health: " + health);
        System.out.println("Creature's health: " + creatureHealth);
    }

    // Method to end the game and display final stats
    private static void endGame() {
        System.out.println("Your adventure ends here. Your final score is: " + score);
        System.out.println("Your health at the end of the adventure: " + health);
        System.exit(0);
    }

    // Method to get user input
    private static int getUserInput() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    // Method to handle invalid input and end the game
    private static void handleInvalidInput() {
        System.out.println("Invalid input. Please enter a valid choice.");
        endGame();
    }
}
