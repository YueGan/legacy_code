import java.io.*;
import java.util.*;
import java.lang.*;

public class Counter {

	public static void main (String args[]) throws IOException{

		String userInput = "";
		int inputMenu = 0;
		int amountFlight = 0;
		int flightNum = 0;
		Flight[] flights  = new Flight[100];
		boolean logOff = true;

		java.text.DateFormat fDate = new java.text.SimpleDateFormat("dd/MM/yyyy");
		java.text.DateFormat fHour = new java.text.SimpleDateFormat("HH");
		java.text.DateFormat fMin = new java.text.SimpleDateFormat("mm");

		String date = fDate.format(new Date());
     	int hour = Integer.parseInt(fHour.format(new Date()));
     	int min = Integer.parseInt(fMin.format(new Date()));

		Scanner keyboard = new Scanner(System.in);

		while (logOff) {

				System.out.println();
				System.out.println("************ MAIN MENU ************");
				System.out.println("1. Update Database");
				System.out.println("2. Display Arrivals");
				System.out.println("3. Display Departures");
				System.out.println("4. Display Air Canada Flights");
				System.out.println("5. Purchase Tickets");
				System.out.println("6. Refund Tickets");
				System.out.println("7. Logoff");

				System.out.print("Please enter a menu number: ");
				userInput = keyboard.nextLine();

				if (userInput.equals("1") || userInput.equals("2") || userInput.equals("3") || userInput.equals("4")
					|| userInput.equals("5") || userInput.equals("6") || userInput.equals("7")){
					inputMenu = Integer.parseInt(userInput);
					System.out.println("");
					}

				else
					inputMenu = 0;

				switch (inputMenu) {

				case 1:
					amountFlight = updateDatabase(flights, amountFlight);
				break;

				case 2:
					displayArrivals(flights, amountFlight, flightNum, date);
				break;

				case 3:
					displayDepartures(flights, amountFlight, flightNum, date, hour, min);
				break;

				case 4:
					displayAirCanada(flights, amountFlight, flightNum, date, hour, min);
				break;

				case 5:
					purchaseTickets(flights, amountFlight, flightNum, date, hour, min);
				break;

				case 6:
					refundTickets();
				break;

				case 7:
					logoff(flights);
					logOff = false;
				break;

				default:
					System.out.println("Invalid menu entry!");
				break;

			}
		}
	}

	// Complete the folllowing methods

	public static int updateDatabase(Flight[] flights, int amountFlight) throws IOException {
		String[][] storage = new String [100][9];
		String delims = "[,]";
		//String file = "DataBase.txt";
		BufferedReader inputStream = null;
		String information = null;
		String [] update = new String [100] ;

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Please enter the full name of the data base file: ");
		String file = keyboard.nextLine();
		
		if(file != "database.txt"){
		
			String fileWithout = (file + ".txt");
			file = fileWithout;
		}

		System.out.println("The updated information is: ");

		try {
			try {
				inputStream = new BufferedReader(new FileReader(file));

				do {
					information = inputStream.readLine();

					if (information == null)
						break;

					update[amountFlight] = information;
					System.out.println(update [amountFlight]);

					amountFlight++;
				} while (information != null);

				for(int i = 0; i < amountFlight; i++){
					 String[] storageBuffer = update[i].split(delims);
					 for (int x = 0; x < storageBuffer.length; x++) {
					 	storage[i][x] = storageBuffer[x];
					}
				}

	 			for (int i = 0; i< amountFlight; i++){
	 				flights[i] = new Flight((storage[i][0]), (storage[i][1]), (storage[i][2]), (storage[i][3]), (storage[i][4]),
	 					 					 (storage[i][5]), (storage[i][6]), (storage[i][7]), (storage[i][8]));
	 			}
				System.out.println("Information updated.");
			}

			catch (FileNotFoundException exception) {
				System.out.println("Error opening file.");
				inputStream.close();
			}

			catch (NullPointerException exception) {
				System.out.println("Error updating data.");
				System.out.println("Please restart the program to prevent errors.");
				inputStream.close();
			}

			catch (ArrayIndexOutOfBoundsException exception) {
				System.out.println("Wrong data format.");
				System.out.println("Please restart the program to prevent errors.");
				inputStream.close();
			}

			inputStream.close();
		}

		catch (NullPointerException exception) {
			System.out.println("Error updating data.");
			System.out.println("Please enter an appropriate name of the file next time.");
		}

		return amountFlight;
	}

	public static void displayArrivals(Flight[] flights, int amountFlight, int flightNum, String date) throws IOException {
		
		int ifHas = 0;
		int numberAvaPerch = 0;
		String[] canPurchase = new String[100];
		Ticket[] tickets = new Ticket[100];
		
		
		try{
			System.out.println ("The current time is: " + date);
			System.out.println ("Arrivals for today are: ");
			System.out.println ("Airline" + "\t" + "\t" + "\t"  + "Flight Number" + "\t" + "Destination" + "\t" + "\t"
								+ "Date" + "\t" + "\t" +	"Time" + "\t" +	"Terminal");
			System.out.println(flights[flightNum].rStatus());
			while (amountFlight!= 0 ){
				if (flights[flightNum].rStatus().equals("ARR")){
					ifHas++;
					canPurchase[ifHas].equals(flights[flightNum]);
					if (flights[flightNum].rFlightDate().equals(date)){
						ifHas ++;
						System.out.println(flights[flightNum].rAirLine() + "\t" + "\t" + flights[flightNum].rFlightNumber()
											+ "\t" + "\t" + "\t" + flights[flightNum].rDestination() + "\t" + "\t" + "\t"
											+ flights[flightNum].rFlightDate() + "\t" + flights[flightNum].rFlightTime()
											+ "\t" + flights[flightNum].rTerminal());
					}
				}
				
				flightNum++;
				amountFlight--;

			}
			if (ifHas == 0)
				System.out.println("There is no arrivals today!");
		}
		catch (NullPointerException exception) {
				System.out.println("An error has occured.");
				System.out.println("It is probably caused by the error in the process of updating data base.");
				System.out.println("Please restart the program to prevent errors.");
		}
	}

	public static void displayDepartures(Flight[] flights, int amountFlight, int flightNum, String date, int hour, int min) throws IOException {
		System.out.println ("The current time is: " + date + " " + hour + ":" + min);
		System.out.println ("Departures for today are: ");
		System.out.println ("Airline" + "\t" + "\t" + "\t"  + "Flight Number" + "\t" + "Destination" + "\t" + "\t"
							+ "Date" + "\t" + "\t" +	"Time" + "\t" +	"Terminal");

		try {
			while (amountFlight!= 0 ){
				if (flights[flightNum].rStatus().equals("DEP"))
					if (flights[flightNum].rFlightDate().equals(date))
						if (flights[flightNum].rFlightHour() > hour || flights[flightNum].rFlightHour() == hour && flights[flightNum].rFlightMin() > min)
							System.out.println(flights[flightNum].rAirLine() + "\t" + "\t" + flights[flightNum].rFlightNumber()
												+ "\t" + "\t" + "\t" + flights[flightNum].rDestination() + "\t" + "\t" + "\t"
												+ flights[flightNum].rFlightDate() + "\t" + flights[flightNum].rFlightTime()
												+ "\t" + flights[flightNum].rTerminal());

				flightNum++;
				amountFlight--;
			}
		}
		catch (NullPointerException exception) {
				System.out.println("An error has occured.");
				System.out.println("It is probably caused by the error in the process of updating data base.");
				System.out.println("Please restart the program to prevent errors.");
		}

	}

	public static void displayAirCanada(Flight[] flights, int amountFlight, int flightNum, String date, int hour, int min) {
		System.out.println ("The current time is: " + date + " " + hour + ":" + min);
		System.out.println ("All Air Canada flights for today are: ");
		System.out.println ("Status" + "\t" + "Flight Number" + "\t" + "Destination" + "\t" + "\t" + "Date"
							+ "\t" + "\t" +	"Time" + "\t" +	"Terminal");

		try {
			while (amountFlight!= 0 ){
				if (flights[flightNum].rAirLine().equals("Air Canada"))
					if (flights[flightNum].rFlightDate().equals(date))
						if (flights[flightNum].rFlightHour() > hour || flights[flightNum].rFlightHour() == hour && flights[flightNum].rFlightMin() > min)
							System.out.println(flights[flightNum].rStatus() + "\t" + "\t" + flights[flightNum].rFlightNumber()
												+ "\t" + "\t" + "\t" + flights[flightNum].rDestination() + "\t" + "\t" + "\t"
												+ flights[flightNum].rFlightDate() + "\t" + flights[flightNum].rFlightTime()
												+ "\t" + flights[flightNum].rTerminal());

				flightNum++;
				amountFlight--;
			}
		}
		catch (NullPointerException exception) {
				System.out.println("An error has occured.");
				System.out.println("It is probably caused by the error in the process of updating data base.");
				System.out.println("Make sure to not leave any blank lines at the end of the data base.");
				System.out.println("Please restart the program to prevent errors.");
		}
	}

	public static void purchaseTickets(Flight[] flights, int amountFlight, int flightNum, String date, int hour, int min)throws IOException {
		
		int counter = 0;
		int[] flightCan = new int[100];
		
		Scanner keyboard1 = new Scanner(System.in);
		Scanner keyboard2 = new Scanner(System.in);
		Scanner keyboard3 = new Scanner(System.in);
		
		try{
			
			System.out.println ("The current time is: " + date);
			System.out.println ("You can purchase the following: ");
			System.out.println ("Choice" + "\t" + "\t"  + "Flight Number" + "\t" + "Destination" + "\t" + "\t"
								+ "Date" + "\t" + "\t" +	"Time" + "\t" +	"Terminal" + "\t" + "Seat Left" + "\t" + "Price");
			
			while (amountFlight!= 0 ){
				if (flights[flightNum].rStatus().equals("ARR")){
						counter++;		
						flightCan[counter] = flightNum;
						System.out.println((counter) + "\t" + "\t" + flights[flightNum].rAirLine() + "\t" + "\t" + flights[flightNum].rFlightNumber()
											+ "\t" + "\t" + "\t" + flights[flightNum].rDestination() + "\t" + "\t" + "\t"
											+ flights[flightNum].rFlightDate() + "\t" + flights[flightNum].rFlightTime()
											+ "\t" + flights[flightNum].rTerminal() + "\t" + "300" + "\t" + flights[flightNum].rPrice() );
					
				}
				
				flightNum++;
				amountFlight--;

			}
			
			System.out.println("Which flight would you like?");
			int getFlight = keyboard1.nextInt();
			System.out.println("What is your name?");
			String getName = keyboard2.nextLine();
			System.out.println("How many tickets would you like to purchase?");
			int getQty = keyboard3.nextInt();
			

			
		}
		catch (NullPointerException exception) {
				System.out.println("An error has occured.");
				System.out.println("It is probably caused by the error in the process of updating data base.");
				System.out.println("Please restart the program to prevent errors.");
		}
	

	}

	public static void refundTickets() {

	}

	public static void logoff(Flight[] flights) {
		System.out.println("Thank you for using AirCanada!");

	}

}