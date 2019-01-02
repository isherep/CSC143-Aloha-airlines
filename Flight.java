import java.text.SimpleDateFormat;
import java.util.Date;
import  java.util.*;
import java.text.ParseException;  
/**
 * This is a representation of Aloha airlies Flight class. 
 * 
 * The flight has3 types of seats, origin, destination, date and base price
 * 
 * Flights have six First Class rows, each having four seats per row (2 + 2), 
 * then eight Comfort rows, each having 6 seats per row (2 + 2 + 2), 
 * then 30 Economy rows, each having eight seats per row (2 + 4 + 2).
 * 
 * @author Iryna Sherepot
 * @version 9 October 2018
 */
public class Flight{
    // instance variables - replace the example below with your own
    private int flightNum;
    private String flightOrigin;
    private String flightDest;
    private String flightDate;
    private Seat[][] seatArray; 
    private Seat seat;
    private double basePrice;
    private int row,col;

    private static final int FIRST_CLASS_ROWS = 6;
    private static final int FIRST_CLASS_SEATS_PER_ROW = 4;
    private static final int COMFORT_ROWS = 8;
    private static final int COMFORT_SEATS_PER_ROW = 6;
    private static final int ECONOMY_ROWS = 30;
    private static final int ECONOMY_SEATS_PER_ROW = 8;
    private int month, day, year;
    private Date flDate;
    private Calendar myCal;
    private Seat.MealType mealType; 

    /**
     * Constructor for objects of class Flight
     * 
     * @param flightNumber The number of a flight, proided from outside. Must be over 0.
     */
    public Flight(int flightNumber){
        if (flightNum <= 0) {
            throw new IllegalArgumentException("Flight number must be > 0 and not null");
        }
        this.flightNum = flightNumber;
    }

    /**
     * Full Constructor for objects of class Flight
     * 
     * @param flightNum the flight number
     * @param flightOrigin The flight origin. Must be 3 characters
     * @param flightDest The destination of flight. Must be 3 characters
     * @param flightDate The date of flight in a format "MM/DD/YYYY".
     * @param basePrice The base flight of a flight.
     */
    public Flight(int flightNum,        String flightOrigin, String flightDest, String flightDate, double basePrice) throws ParseException{ 
        if (flightNum <= 0 || flightOrigin == null || flightDest == null || basePrice <0.00 || flightDate == null) {
            throw new IllegalArgumentException("Arguments must be > 0 and not null");
        }

        if (flightOrigin.length() > 3 || flightDest.length() > 3 ) {
            throw new IllegalArgumentException("too many characters in origin or destination. Must have 3 characters");
        }

        if(month< 0) {
            throw new IllegalArgumentException("negative month");
        }

        this.flightNum      = flightNum;
        this.flightOrigin   = flightOrigin;
        this.flightDest     = flightDest;
        this.basePrice      = basePrice;
        this.flightDate     = flightDate;

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        df.setLenient(false);
        flDate = df.parse(flightDate);
        myCal  = new GregorianCalendar();
        myCal.setTime(flDate);

        month = this.myCal.get(Calendar.MONTH) + 1;
        day   = this.myCal.get(Calendar.DATE);
        year  = this.myCal.get(Calendar.YEAR);

        //------------ARRAY OF SEAT REFFERENCES---------------------------------
        seatArray = new Seat[44][];
        //creating first class seats
        for (row = 0; row < FIRST_CLASS_ROWS; row++) {
            seatArray[row] = new FirstClassSeat[FIRST_CLASS_SEATS_PER_ROW];

            for( col = 0; col<FIRST_CLASS_SEATS_PER_ROW; col++){
                seatArray[row][col] = new FirstClassSeat(this,row,col);  
            }
        } 

        //creating comfort seats
        for(row = FIRST_CLASS_ROWS + 1; row < COMFORT_ROWS + FIRST_CLASS_ROWS; row++){
            seatArray[row] = new ComfortSeat[COMFORT_SEATS_PER_ROW];

            for(col = 0; col<COMFORT_SEATS_PER_ROW; col++){
                seatArray[row][col] = new ComfortSeat(this,row,col);  
            }
        }
        //creating economy seats
        for ( row = COMFORT_ROWS + FIRST_CLASS_ROWS + 1;  row < ECONOMY_ROWS + COMFORT_ROWS + FIRST_CLASS_ROWS; row++){
            seatArray[row] = new EconomySeat[ECONOMY_SEATS_PER_ROW];

            for( col = 0; col<ECONOMY_SEATS_PER_ROW; col++){
                seatArray[row][col] = new EconomySeat(this, row,col);  
            }
        }
    }

    /**
     * @return The Seat at specified row and column
     */
    public Seat getSeat(int row, int col){
        return  seatArray[row][col];
    }

    /**
     * Returns the month of flight date
     * 
     * @return The month of a flight
     */
    public int getMonth (){
        return month;
    }

    /**
     * Returns te day of flight date
     * 
     * @return The day of a flight
     */
    public int getDay() {
        return this.day;
    }

    /**
     * Returns the year of flightdate.
     * 
     * @return The year of a flight
     */
    public int getYear(){
        return this.year;
    }

    /**
     * Retruns an First Class Seat seat at the specified row and column
     * 
     * @param row The row in an comfort section. Must be between 0 and 6.
     * @param col The column in a comfort flight section. Must be betweeb 0 and 4.
     * 
     * @return Comfort Seat.
     */
    public FirstClassSeat getFirstClassSeat(int row, int col){
        return (FirstClassSeat) getSeat(row, col);

    }

    /**
     * Retruns an Comfort seat at the specified row and column
     * 
     * @param row The row in an comfort section. Must be between 7 and 14.
     * @param col The column in a comfort flight section. Must be betweeb 0 and 6.
     * 
     * @return Comfort Seat.
     */
    public ComfortSeat getComfortSeat(int row, int col){
        return (ComfortSeat) getSeat(row, col);

    }

    /**
     * Retruns an Economy seat at the specified row and column
     * 
     * @param row The row in an economy section. Must be between 15 and 44.
     * @param col The column in a economy flight section. Must be betweeb 0 and 8.
     * 
     * @return Economy Seat.
     */
    public EconomySeat getEconomySeat(int row, int col){
        // check if in right row
        return (EconomySeat) getSeat(row, col);

    }

    /**
     * Returns flight number
     * 
     * @return flight number
     * 
     */
    public int getFlightNumer(){
        return this.flightNum;
    }

    /**
     * Returns origin of a flight
     * 
     * @return flight origin
     * 
     */
    public String getFfligtOrigin(){
        return this.flightOrigin;
    }

    /**
     * Returns destination of a flight
     * 
     * @return flight destination
     */
    public String getFlightDest(){
        return this.flightDest;
    }

    /**
     * Returns flight date
     * 
     * @return date of flihgt
     */
    public String getFlightDate(){
        return this.flightDate;
    }

    /**
     * This method has to ask seat class how many seats were booked
     * 
     * @return The passenger count (a tally of booked seats).
     */
    public int getPassCount(){
        int passCount = 0;
        for (row = 0; row < FIRST_CLASS_ROWS; row++) {
            for( int col = 0; col<FIRST_CLASS_SEATS_PER_ROW; col++){
                if(seatArray[row][col].getIsBooked()){
                    passCount++;
                }
            }
        }

        for(row = FIRST_CLASS_ROWS + 1; row < COMFORT_ROWS + FIRST_CLASS_ROWS; row++){
            for( int col = 0; col<COMFORT_SEATS_PER_ROW; col++){
                if(seatArray[row][col].getIsBooked()){
                    passCount++;
                }
            }
        }

        for (row = COMFORT_ROWS + FIRST_CLASS_ROWS + 1;  row < ECONOMY_ROWS + COMFORT_ROWS + FIRST_CLASS_ROWS; row++){
            for( int col = 0; col<ECONOMY_SEATS_PER_ROW; col++){
                if(seatArray[row][col].getIsBooked()){
                    passCount++;
                }       
            }
        }
        return passCount;
    }

    /**
     *  Returns an array of empty seats on a plane.
     *  
     *  @return The array of empty seat refferences.
     */
    public Seat[] getEmptySeat(){
        ArrayList<Seat> emptySeats = new ArrayList<Seat>();
        //the array will be only as big as the size of an array list
        //iterating thru first class seats
        for (row = 0; row < FIRST_CLASS_ROWS; row++) {
            for( int col = 0; col<FIRST_CLASS_SEATS_PER_ROW; col++){
                if(!seatArray[row][col].getIsBooked()){
                    emptySeats.add(seatArray[row][col]);
                }
            }
        }
        //iterating thru comfort class seats
        for(row = FIRST_CLASS_ROWS + 1; row < COMFORT_ROWS + FIRST_CLASS_ROWS; row++){
            for( int col = 0; col<COMFORT_SEATS_PER_ROW; col++){
                if(!seatArray[row][col].getIsBooked()){
                    emptySeats.add(seatArray[row][col]);
                }    
            }
        }
        //iterating thru economy seats
        for (row = COMFORT_ROWS + FIRST_CLASS_ROWS + 1;  row < ECONOMY_ROWS + COMFORT_ROWS + FIRST_CLASS_ROWS; row++){
            for( int col = 0; col<ECONOMY_SEATS_PER_ROW; col++){
                if(!seatArray[row][col].getIsBooked()){
                    emptySeats.add(seatArray[row][col]);
                }       
            }
        }

        Seat[] emptyArray = emptySeats.toArray( new Seat[emptySeats.size()]);
        return emptyArray;
    }

    /**
     * Retrieve an array of seat references associated with 
     * a specified customer confirmation number 
     * 
     * @param The booking confirmation 
     * 
     * @return The array of seats that are assigned to given confirmation
     */
    public Seat[][] getSeats(Confirmation conf){

        Seat[][] mySeats = new Seat[44][];
        //iterating thru first class seats
        for (row = 0; row < FIRST_CLASS_ROWS; row++) {
            for( int col = 0; col<FIRST_CLASS_SEATS_PER_ROW; col++){
                if(seatArray[row][col].getConf()== conf){
                    mySeats[row][col] = seatArray[row][col];
                }else{
                    System.out.println( "This   is not a valid confirmation");
                } 
            }  
            //iterating thru comfort seats
            for(row = FIRST_CLASS_ROWS + 1; row < COMFORT_ROWS + FIRST_CLASS_ROWS; row++){
                for( int col = 0; col<COMFORT_SEATS_PER_ROW; col++){
                    if(seatArray[row][col].getConf()== conf){
                        mySeats[row][col] = seatArray[row][col];  
                    } else{
                        System.out.println( "This   is not a valid confirmation");
                    }
                }
            }
            //iterating thru economy seats
            for (row = COMFORT_ROWS + FIRST_CLASS_ROWS + 1;  row < ECONOMY_ROWS + COMFORT_ROWS + FIRST_CLASS_ROWS; row++){
                for( int col = 0; col<ECONOMY_SEATS_PER_ROW; col++){
                    if(seatArray[row][col].getConf()== conf){
                        mySeats[row][col] = seatArray[row][col];  
                    } else{
                        System.out.println( "This   is not a valid confirmation");
                    }
                }
            }
        }
        return mySeats;
    }

    /**
     * Returns base price for this flight
     * @return the base flight price
     */
    public double getBasePrice(){
        return this.basePrice;

    }

    /**
     * Adjusts base flight seat price
     * 
     * @param basePrice the basic seat price
     */
    public void setBasePrice (double basePrice){    
        this.basePrice = basePrice;
    }
    //====================================================================================
    //================= STATIC SEAT METHODS===============================================
    //===================================================================================
    /*
     * static methods for
     * (1) turning a row and column into a seat number, 
     * (2) turning a seat number into a row, and 
     * (3) turning a seat number into a column.  
     * Leverage these in your code.   
     */

    /**
     * Turns seat and column nummber into seat number
     */
    public static String turnRowColInSeatNumber(int row, int col){
        String[] letters = {"A","B","C","D","E","F"};
        return String.valueOf(row)+ letters[col];
    }

    /**
     * Turns seat number into row
     */
    public static int turnSeatNumInRow(String seatNumber){
        int result = 0;

        if(seatNumber.length() == 2){
            result = Integer.parseInt(seatNumber.substring(0,1));
        }
        else if(seatNumber.length() == 3){
            result = Integer.valueOf(seatNumber.substring(0,2));
        }
        System.out.println("This seat is in a  " + result + " row");

        return result;
    }

    /**
     * Turns seat number into column
     * 
     * @param seatNumber The full seat number
     */
    public static String turnSeatNumInCol(String seatNumber){
        String result = "";

        if(seatNumber.length() == 2){
            result = seatNumber.substring(1);
        }
        else if(seatNumber.length() == 3){
            result = seatNumber.substring(2);
        }
        System.out.println("This seat is in a " + result + " column");

        return result;
    }

    //================TOSTRING========================================================
    /**
     * Returns string representation of flight class
     * 
     * @return String representation of flight class
     */
    public String toString(){
        String info = " ";
        info += "The base price is: "           + this.basePrice + "\n";
        info += "The column amount is: "        + this.col + "\n";
        info += "The flight date is: "          + this.flightDate + "\n";
        info += "The flight destination is: "   + this.flightDest+ "\n";
        info += "The flight number is: "        + this.flightNum + "\n";
        info += "The flight originis: "         + this.flightOrigin + "\n";
        info += "The flight row count is: "     + this.row + "\n";
        info += "The seat price is "            + this.getBasePrice() + "\n";
        info += Arrays.toString(this.getEmptySeat());
        System.out.println();

        return info;
    }
}

