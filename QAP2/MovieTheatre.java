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

    private static boolean[][] seatsAvailable = new boolean[15][15];

    public static void reserveSeats(Scanner scanner){
        while(true){
            System.out.println("Please enter the row number you wish to sit in (1-15): ");
            int rowSelected = scanner.nextInt();
            System.out.println("Please enter the seat number you wish to sit in (1-15): ");
            int seatSelected = scanner.nextInt();
    
            if(rowSelected >= 0 && rowSelected < 15 && 
            seatSelected >=0 && seatSelected < 15){
                if(seatsAvailable[rowSelected][seatSelected]){
                    System.out.println("Oops! This seat is taken, please choose a new seat.");
                } else {
                    seatsAvailable[rowSelected][seatSelected] = true;
                    System.out.println("Your seat has been reserved! See you soon!");
                }
            } else {
                System.out.println("Invalid seat number entered. Please re-enter your desired seat.");
            }
        break;
        }
    }

    public static void cancelSeats(Scanner scanner){
        while(true){
            System.out.println("Please enter the row number you wish to sit in (1-15): ");
            int rowSelected = scanner.nextInt();
            System.out.println("Please enter the seat number you wish to sit in (1-15): ");
            int seatSelected = scanner.nextInt();
    
            if(rowSelected >= 0 && rowSelected < 15 && 
            seatSelected >=0 && seatSelected < 15){
                if(!seatsAvailable[rowSelected][seatSelected]){
                    System.out.println("That seat isn't currently reserved, please review your reservation and enter the correct seat.");
                } else {
                    seatsAvailable[rowSelected][seatSelected] = false;
                    System.out.println("Your reservation was cancelled ): Hope to see you soon!");
                }
            } else {
                System.out.println("Invalid seat number entered. Please re-enter your reserved seat.");
            }
        break;
        }
    }

    public static void viewSeatingChart(){

    }
}

