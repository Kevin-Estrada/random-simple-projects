package day2;

public class BankingApplication {
    public static void main(String[] args) {
        BankAccount custOne = new BankAccount("Kevin");
        BankAccount custTwo = new BankAccount("Ana");
        BankAccount custThree = new BankAccount("Richi");
        custOne.showMenu();
        // custOne.showId();
        // custTwo.showId();
        // custThree.showId();
    }
}
