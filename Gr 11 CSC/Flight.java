import java.lang.Integer;

public class Flight {

	private String status;
	private String airLine;
	private String flightNumber;
	private String destination;
	private String flightDate;
	private String flightTime;
	private String terminal;
	private String planeType;
	private String price;
	private String canPurchase;
	private int seats;


	// Complete constructor
	public Flight(String status, String airLine, String flightNumber,
	String destination, String flightDate, String flightTime, String terminal, String planeType, String price) {

		this.status = status;
		this.airLine = airLine;
		this.flightNumber = flightNumber;
		this.destination = destination;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.terminal = terminal;
		this.planeType = planeType;
		this.price = price;
	}

		public Flight(String status, String airLine, String flightNumber,
	String destination, String flightDate, String flightTime, String terminal, String planeType) {

		this.status = status;
		this.airLine = airLine;
		this.flightNumber = flightNumber;
		this.destination = destination;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.terminal = terminal;
		this.planeType = planeType;
		this.price = "0";
	}




	public String rStatus(){
		return status;
	}
	public String rAirLine(){
		return airLine;
	}
	public String rFlightNumber(){
		return flightNumber;
	}
	public String rDestination(){
		return destination;
	}
	public String rFlightDate(){
		return flightDate;
	}
	public String rFlightTime(){
		return flightTime;
	}
	public String rTerminal(){
		return terminal;
	}
	public String rPlaneType(){
		return planeType;
	}
	public String rPrice(){
		return price;
	}
	
	public int numberOfSeat(){
		return seats;
	}
	public int rFlightHour(){
		String delims = "[:]";
 		String[] time = flightTime.split(delims);
 		int flightHour = Integer.parseInt(time[0]);

		return flightHour;
	}
	public int rFlightMin(){
		String delims = "[:]";
 		String[] time = flightTime.split(delims);
 		int flightMin = Integer.parseInt(time[1]);

		return flightMin;
	}
	
	public String storeCanPuchase(Flight[] flights){
		
		this.canPurchase = canPurchase;
		return canPurchase;
	}
	
	
}