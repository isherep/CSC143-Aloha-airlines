import java.util.*;
/**
 *Seats:  flights have seats arranged in 40 rows of 6 seats each, numbered to include row and seat designations 
 * (e.g., row one consists of 1A, 1B, 1C, 1D, 1E, and 1F). 
 * Seats have an associated price, recline (in whole inches), and meal type.  
 * Once the seat number is assigned to a seat, it cannot be changed.  Other data can be altered. 
 * Make up other data as you see fit (pricing, recline, meal type). 
 */
public abstract class Seat   {
    private int seatNumber;
    private MealType mealType;
    private int recline;
    private int row;
    private int col;
    private Flight myFlight;
    private Confirmation conf;
    private boolean isBooked;

    public enum MealType {Gourmet, Full, Snack }

    //---------------CONSTRUCTOR------------------------------------------

    /**
     * Full constructor for the Seat class
     * 
     * @param myFlight The flight seat belongs to
     * @param row - the row the seat is in.
     * @param col - the column the seat is in
     * @param mealType - the meal type assigned to the seat
     * @param basePrice - the base price of the seat on flight
     * @param recline - the inches of seat recline
     * 
     */
    public Seat(Flight myFlight, int row, int column, MealType mealType, int recline ){
        if(row < 0 || col < 0 || recline < 0){
            throw new IllegalArgumentException(" Row, column or reclineMust be 3 characters cannot be less than 0");
        }
        this.row = row;
        this.col = column;
        this.myFlight = myFlight;
        this.myFlight = myFlight;
        setMealType(mealType);
        setRecline(recline);
        setMealType(mealType);
        setRecline(recline);
    }

    /**
     * Returns seat number as combination of letters representing columns and numbers representing rows
     * @return seat number
     */
    public String getSeatNumber(){
        String[] letters = {"A","B","C","D","E","F", "G", "H"};
        return String.valueOf(this.row) + letters[this.col];
    }

    /**
     * Return meal type assigned to seat
     * 
     * @return - seat meal type 
     */
    public MealType getMealType(){
        return mealType;
    }

    /**
     * Returns seat recline
     * 
     *  @return - the amount of inches of recline
     */
    public int getRecline(){
        return this.recline;

    }
    //------------MUTATORS--------------
    /**
     * Sets meat type for the seat.
     * 
     * @param mealType The type of meal served in a seat class
     */
    public void setMealType(MealType mealType){
        this.mealType = mealType;

    }

    /**
     * Sets recline for the seat.
     * 
     * @param recline The amount of inches of seat recline
     */
    public void setRecline (int recline){
        this.recline =  recline;

    }

    /**
     * Adds a confirmation to the seat. Only one confirmation can be added to the seat.
     * 
     * @param conf the confirmation of booking the seat.
     */
    public void addConfirmation(Confirmation conf){
        if(this.conf!=null){
            throw new IllegalArgumentException("This seat already has confirmation.");
        }
        this.conf = conf;
    }

    /**
     * Checks if the seat is booked
     * 
     * @return boolean showing if seat is booked or not
     */
    public boolean getIsBooked(){
        return this.conf != null;
    }

    /**
     * Retrieves the customer confirmation associated with the seat 
     * 
     * @return The confirmation object
     */
    public Confirmation getConf(){
        if(this.conf == null){
            System.out.println("A confirmation for this seat does not exist");
        }

        return this.conf;
    }

    /**
     * Returns a flight that the seat is on
     * 
     * @return The flight which the seat is on.
     */
    public Flight getFlight(){
        return this.myFlight;
    }

    /**
     * Checks if the customer on consirmation belongs to Aloha discount club.
     * 
     * @return the Aloha status
     */
    public boolean getAloha(){
        if(this.getIsBooked()){
            return this.conf.getAloha();
        } else {
            return false;
        }
    }

    /**
     * Releases the seat, removing customer information.
     * 
     */
    public void releaseSeat(){
        this.conf = null;
    }

    /**
     * Returns the row number in thich the seat is in
     * 
     * @return row number
     */
    public int getRow(){
        return this.row;
    }

    /**
     * Returns the column in thich the seat is in.
     * 
     * @return column number
     */
    public int getCol(){
        return this.col;
    }

    /**
     * Returns the price of the seat
     * 
     * @param discount The discount of the aloha club if the customer belogs to one.
     */
    public double getPrice(double discount){
        if(this.getAloha()){
            return myFlight.getBasePrice() - discount*myFlight.getBasePrice();
        }else{
            return myFlight.getBasePrice();
        }
    }

    /**
     * String representation of a Seat class.
     * 
     * @return String representation of the Seat class
     */
    public String toString(){
        String info = "";
        info += "\nThe seat row is: "       + this.getRow() + "\n";
        info += "The seat column is "       + this.getCol() + "\n";
        info += "The seat confirmation is " + this.getConf()+ "\n";
        info += "Is the seat booked: "      + this.getIsBooked() + "\n";
        info += "The seat mealtype is: "    + this.getMealType() + "\n";
        info += "The seat recline: "        + this.getRecline() + "\n";
        info += "The seat number is "       + this.getSeatNumber() + "\n";
        info += "The seat is in "           + this.getClass().getName() + "class" + "\n";

        return info;
    }

}

