package QAP2;

import java.util.Scanner;
public class MovieTheatre {
    public static void displayMenu(){

        try (Scanner scanner = new Scanner(System.in)) {
            while(true){
                System.out.println("\nWelcome to the Movie Theatre! Please Browse our menu options: ");
                System.out.println("1. Reserve Seat(s)");
                System.out.println("2. Cancel Seat(s)");
                System.out.println("3. View Seating Chart");
                System.out.println("4. Exit");
                System.out.println("");
                System.out.println("Please enter your option: ");

                int choice = scanner.nextInt();

                switch(choice){
                    case 1: 
                        reserveSeats(scanner);
                        break;
                    case 2: 
                        cancelSeats(scanner);
                        break;
                    case 3:
                        viewSeatingChart();
                        break;
                    case 4:
                        System.out.println("Thanks for visiting! Exiting menu...");
                        return;
                    default: 
                        System.out.println("INvalid menu option entered. Please enter 1, 2, 3 or 4.");
                }
            }
        }
    }

    public static void reserveSeats(Scanner scanner){

    }

    public static void cancelSeats(Scanner scanner){

    }

    public static void viewSeatingChart(){

    }
}

