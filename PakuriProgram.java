import java.util.Scanner;

public class PakuriProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pakudex pakudex;
        // display the welcome message
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        // prompt for a capacity reading and confirm it
        int capacity = 0;
        String capac;
        while (capacity <= 0) {
            System.out.println("Enter max capacity of the Pakudex: ");
            try {
                capac = scanner.next();
                capacity = Integer.parseInt(capac);
                if (capacity < 0)
                    throw new Exception();
            } catch (Exception e) {
                System.out.println("Please enter a valid size.");
            }
        }
        System.out.println("The Pakudex can hold " + capacity + " species of Pakuri.");
        pakudex = new Pakudex(capacity);
        boolean continueApp = true;
        while (continueApp) {
            // menu display
            System.out.println("Pakudex Main Menu \n" + "----------------- \n" + "1. List Pakuri \n" + "2. Show Pakuri \n" + "3. Add Pakuri \n" + "4. Evolve Pakuri \n" + "5. Sort Pakuri \n" + "6. Exit \n");
            // ask user for input
            System.out.println("\nWhat would you like to do? ");
            String response = scanner.next();
            int res = -1;
            try {
                res = Integer.parseInt(response);
            }
            catch (Exception e) {
            }
            // if user chooses a menu option that isn't an option
            if (res < 1 || res > 6) {
                System.out.println("Unrecognized menu selection!");
            }
            // if user chooses option 1
            if(res == 1) {
                String[] speciesArr = pakudex.getSpeciesArray();
                if (speciesArr == null) {
                    System.out.println("No Pakuri in Pakudex yet!");
                    continue;
                }
                System.out.println("Pakuri In Pakudex:");
                int sizePakudex = pakudex.getSize();
                for (int index = 0; index < sizePakudex; ++index) {
                    String species = speciesArr[index];
                    System.out.println((index + 1) + ". " + species);
                }
            }
            // if user chooses option 2
            else if(res == 2) {
                System.out.println("Enter the name of the species to display: ");
                String species = scanner.next();
                int [] statistics = pakudex.getStats(species);
                if(statistics == null) {
                    System.out.println("Error: No such Pakuri!");
                    continue;
                }
                System.out.println("\nSpecies: " + species);
                System.out.println("Attack: " + statistics[0]);
                System.out.println("Defense: " + statistics[1]);
                System.out.println("Speed: " + statistics[2] + "\n");
            }
            // if user chooses option 3
            else if(res == 3) {
                int size = pakudex.getSize();
                if(size == capacity) {
                    System.out.println("Error: Pakudex is full!");
                    continue;
                }
                System.out.println("Enter the name of the species to add: ");
                String species = scanner.next();
                boolean answer = pakudex.addPakuri(species);
                if(answer)
                    System.out.println("Pakuri species " + species + " successfully added!");
                else
                    System.out.println("Error: Pakudex already contains this species!");
            }
            // if user chooses option 4
            else if(res == 4) {
                System.out.println("Enter the name of the species to evolve: ");
                String species = scanner.next();
                boolean answer = pakudex.evolveSpecies(species);
                if(answer)
                    System.out.println(species + " has evolved!");
                else
                    System.out.println("Error: No such Pakuri!");
            }
            // if user chooses option 5
            else if(res == 5) {
                pakudex.sortPakuri();
                System.out.println("Pakuri have been sorted!");
            }
            // if user chooses option 6
            else if(res == 6) {
                continueApp = false;
                System.out.println("Thanks for using Pakudex! Bye!");
            }
        }
    }
}