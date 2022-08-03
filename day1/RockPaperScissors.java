package day1;

import java.io.IOException;
import java.util.*;

import java.util.Random;

public class RockPaperScissors {
    Scanner sc = new Scanner(System.in);
    String[] gameArr = new String[] { "Rock", "Paper", "Scissors" };

    public void startGame() {
        System.out.println("Welcome to the rock paper scissors game! Would you like to play? Enter [Y] or [N].");
        boolean condition = true;
        while (condition) {
            String choice = sc.nextLine().toLowerCase();
            System.out.println();
            if (choice.equals("y")) {
                condition = false;
            } else if (choice.equals("n")) {
                System.out.println("Thank you for trying out the game!");
                System.exit(0);
            } else {
                System.out.println("The input is invalid please try again!");
                System.out.println("Would you like to play? Enter [Y] or [N].");
            }
        }
        int playerChoice = getPlayerChoice();
        int computerChoice = createComputerChoice();
        chooseWinner(computerChoice, playerChoice);
    }

    public int createComputerChoice() {
        int choice;
        Random rand = new Random();
        choice = rand.nextInt(3);
        return choice;
    }

    public int getPlayerChoice() {
        while (true) {
            try {
                boolean playAgain = true;
                while (playAgain) {
                    System.out.println("Please enter 0[Rock], 1[Paper], or 2[Scissors]");
                    int choice = Integer.parseInt(sc.nextLine());
                    System.out.println();
                    if (choice > 2 || choice < 0) {
                        throw new Exception();
                    } else {
                        return choice;
                    }
                }
            } catch (Exception e) {
                System.out.println();
                System.out.println("The entered value was not valid, please try again.");
            }
        }
    }

    public void chooseWinner(int computerChoice, int playerChoice) {
        String human = gameArr[playerChoice];
        String computer = gameArr[computerChoice];
        if (human.equals("Rock") && computer.equals("Scissors")) {
            System.out.println("Player choice is " + human);
            JavaArt.rockSign();
            System.out.println("====================================\n");
            System.out.println("Computer choice is " + computer);
            JavaArt.scissorsSign();
            System.out.println();
            System.out.println("The winner is the player!!!");
            playAgain();
        } else if (human.equals("Paper") && computer.equals("Rock")) {
            System.out.println("Player choice is " + human);
            JavaArt.paperSign();
            System.out.println("====================================\n");
            System.out.println("Computer choice is " + computer);
            JavaArt.rockSign();
            System.out.println();
            System.out.println("The winner is the player!!!");
            playAgain();
        } else if (human.equals("Scissors") && computer.equals("Paper")) {
            System.out.println("Player choice is " + human);
            JavaArt.scissorsSign();
            System.out.println("====================================\n");
            System.out.println("Computer choice is " + computer);
            JavaArt.paperSign();
            System.out.println();
            System.out.println("The winner is the player!!!");
            playAgain();
        } else if (human.equals("Rock") && computer.equals("Paper")) {
            System.out.println("Player choice is " + human);
            JavaArt.rockSign();
            System.out.println("====================================\n");
            System.out.println("Computer choice is " + computer);
            JavaArt.paperSign();
            System.out.println();
            System.out.println("The winner is the computer!!!");
            playAgain();
        } else if (human.equals("Paper") && computer.equals("Scissors")) {
            System.out.println("Player choice is " + human);
            JavaArt.paperSign();
            System.out.println("====================================\n");
            System.out.println("Computer choice is " + computer);
            JavaArt.scissorsSign();
            System.out.println();
            System.out.println("The winner is the computer!!!");
            playAgain();
        } else if (human.equals("Scissors") && computer.equals("Rock")) {
            System.out.println("Player choice is " + human);
            JavaArt.scissorsSign();
            System.out.println("====================================\n");
            System.out.println("Computer choice is " + computer);
            JavaArt.rockSign();
            System.out.println();
            System.out.println("The winner is the computer!!!");
            playAgain();
        } else {
            if (playerChoice == 0) {
                System.out.println("Player choice is " + human);
                JavaArt.rockSign();
                System.out.println("====================================\n");
                System.out.println("Computer choice is " + computer);
                JavaArt.rockSign();
                System.out.println();
                System.out.println("It is a tie!!!!");
                playAgain();
            } else if (playerChoice == 1) {
                System.out.println("Player choice is " + human);
                JavaArt.paperSign();
                System.out.println("====================================\n");
                System.out.println("Computer choice is " + computer);
                JavaArt.paperSign();
                System.out.println();
                System.out.println("It is a tie!!!!");
                playAgain();
            } else {
                System.out.println("Player choice is " + human);
                JavaArt.scissorsSign();
                System.out.println("====================================\n");
                System.out.println("Computer choice is " + computer);
                JavaArt.scissorsSign();
                System.out.println();
                System.out.println("It is a tie!!!!");
                playAgain();
            }
        }
    }

    public void playAgain() {
        boolean condition = true;
        System.out.println();
        System.out.println("Would you like to play again? Enter [Y] or [N].");
        while (condition) {
            String choice = sc.nextLine().toLowerCase();
            System.out.println();
            if (choice.equals("y")) {
                int playerReChoice = getPlayerChoice();
                int computerReChoice = createComputerChoice();
                chooseWinner(computerReChoice, playerReChoice);
            } else if (choice.equals("n")) {
                System.out.println("Thank you for trying out the game!");
                System.exit(0);
            } else {
                System.out.println("The input is invalid please try again!");
                System.out.println("Would you like to play again? Enter [Y] or [N].");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        RockPaperScissors rps = new RockPaperScissors();
        rps.startGame();
    }
}