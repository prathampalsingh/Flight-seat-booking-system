package project;
import java.util.Scanner;
public class SeatBookingSystem {
    public static void main(String[] args) {
		System.out.println("Welcome to Flight booking system");
		System.out.println("                       __|__\r\n"
				+ "------------------@--@--(_)--@--@------------------");
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter your name");
		String name=sc.next();
		System.out.println("                          /\\\r\n"
				+ "                         |  |\r\n"
				+ "                        |    | '.\r\n"
				+ "                       |      |\r\n"
				+ "                      |        |\r\n"
				+ "                      |        |\r\n"
				+ "                 _ - |          | - _\r\n"
				+ "            _ -     1|ABC    DFG|     - _\r\n"
				+ "        _ -          |          |         - _\r\n"
				+ "    _ -             2|ABC    DFG|             - _\r\n"
				+ " _-                 3|ABC    DFG|                 - _\r\n"
				+ "|__________....------\\        //--------....________|\r\n"
				+ "                     |          |\r\n"
				+ "                      |        |\r\n"
				+ "                       |      |\r\n"
				+ "                        |    |\r\n"
				+ "                        |    |");
        int rows = 3; // Adjust the number of rows as needed
        int seatsPerRow = 6;
        char[][] seatingChart = new char[rows][seatsPerRow];
        initializeSeatingChart(seatingChart);
        Scanner scanner = new Scanner(System.in);
        boolean bookingInProgress = true;
        while (bookingInProgress) {
            displaySeatingChart(seatingChart);
            System.out.print("Enter the row number (1-" + rows + "): ");
            int rowNumber = scanner.nextInt();
            System.out.print("Enter the seat number (1-" + seatsPerRow + "): ");
            int seatNumber = scanner.nextInt();
            if (isValidInput(rowNumber, seatNumber, rows, seatsPerRow)) {
                if (isSeatAvailable(seatingChart, rowNumber, seatNumber)) {
                    bookSeat(seatingChart, rowNumber, seatNumber);
                    System.out.println("Seat booked successfully!");
                } else {
                    System.out.println("Seat is already booked.");
                }
            } else {
                System.out.println("Invalid  input. Please try again.");
            }
            System.out.print("Do you want to continue booking? (y/n): ".toLowerCase());
            char choice = scanner.next().charAt(0);
            if(choice =='y') {
            	bookingInProgress = (choice == 'y' || choice == 'Y');
            }else if(choice =='n') {
            	System.out.println("thank you for choosing Verstappen airlines "+name);
            }else {
            	System.out.println("Invalid choice");
            }
        }
        
        scanner.close();
    }
    
    private static void initializeSeatingChart(char[][] seatingChart) {
        for (int i = 0; i < seatingChart.length; i++) {
            for (int j = 0; j < seatingChart[i].length; j++) {
                seatingChart[i][j] = (char) ('A' + j);
            }
        }
    }
    private static void displaySeatingChart(char[][] seatingChart) {
        System.out.println("Seating Chart:");
        for (int i = 0; i < seatingChart.length; i++) {
            for (int j = 0; j < seatingChart[i].length; j++) {
                System.out.print(seatingChart[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static boolean isValidInput(int rowNumber, int seatNumber, int rows, int seatsPerRow) {
        return rowNumber >= 1 && rowNumber <= rows && seatNumber >= 1 && seatNumber <= seatsPerRow;
    }
    private static boolean isSeatAvailable(char[][] seatingChart, int rowNumber, int seatNumber) {
        return seatingChart[rowNumber - 1][seatNumber - 1] != 'X';
    }
    private static void bookSeat(char[][] seatingChart, int rowNumber, int seatNumber) {
        seatingChart[rowNumber - 1][seatNumber - 1] = 'X';
    }}