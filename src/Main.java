import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your Tamagotchi's name: ");
        String name = scanner.nextLine();

        Tamagotchi tamagotchi = new Tamagotchi(name);

            while (tamagotchi.getAlive()){
                System.out.println("What would you like to do?");
                System.out.println("1. Feed your Tamagotchi");
                System.out.println("2. Teach your Tamagotchi a new word");
                System.out.println("3. Print your Tamagotchi's stats");
                System.out.println("4. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        tamagotchi.feed();
                        break;
                    case 2:
                        System.out.println("Enter a word to teach your Tamagotchi: ");
                        String word = scanner.nextLine();
                        tamagotchi.teach(word);
                        break;
                    case 3:
                        tamagotchi.printStats();
                        break;
                    case 4:
                        System.out.println("Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

                tamagotchi.tick();

            }
        System.out.println("Your Tamagotchi has died");

    }
}