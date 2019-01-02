
/**
 * This is a model of comfort-class seat.
 * 
 * Comfort Class passengers receive a Full meal, and has 6 inches of recline
 *
 * @author Iryna Sherepot
 * @version 11/20/18
 */
public class ComfortSeat extends Seat{
    // instance variables - replace the example below with your own
    private MealType type;
    private double alohaDiscount = 0.1;
    
    private static final MealType MEAL_TYPE = MealType.Full;
    private static final double PRICE_MARKUP = 1.50;
    private static final int RECLINE_INCH = 6;

    /**
     * Constructor of Comfort class seat
     * 
     * @row - the row the seat is in. Must be between 6 and 14 inclusive
     * @col - the column te seat is in. must be between 0 and 6 inclusive
     */
    public ComfortSeat(Flight myFlight,int row, int col){
        super(myFlight, row, col, MEAL_TYPE, RECLINE_INCH );
        if(col > 6 || row < 6 || row >14){
            throw new IllegalArgumentException("Row/Column numbers beyond Comfort class.Comfort class seats only in a first 6 rows and 4 columns.");
        }
    }

    /**
     * Returns back of a seat recline
     * 
     * @return - the amount of inches of recline
     */
    public int getRecline(){
        return RECLINE_INCH;
    }

    /**
     * Returns meat type
     */
    public MealType getMealType(){
        return MealType.Full;
    }

    /**
     * Returns the seat price
     * 
     * * @return the price of the seat
     */
    public double getPrice() {
        return this.getPrice(alohaDiscount) * PRICE_MARKUP;
    }
    
    public String toString(){
         String info = super.toString();
        info += "This seat price is : "  + this.getPrice(alohaDiscount);
        return info;
    }
    
}
