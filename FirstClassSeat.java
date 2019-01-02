
/**
 * This is a model of first-class seat. Rows 1 thru 6 are First Class
 * 
 *  First Class passengers receive a Gourmet meal and have 8 inches of seat recline;
 *
 * @author Iryna Sherepot
 * @version 11/20/18
 */
public class FirstClassSeat extends Seat{

    private MealType type;
    private double alohaDiscount = 0.1;
    
    private static final MealType MEAL_TYPE = MealType.Gourmet;
    private static final int RECLINE_INCH = 8;
    private static final double PRICE_MARKUP = 2.00;

    /**
     * Constructor of First class seat
     * 
     * @row - the row the seat is in. Must be 0 to 5 inclusive
     * @col - the column te seat is in. Must be 0 to 4 inclusive.
     */
    public FirstClassSeat(Flight myFlight, int row, int col){
        super(myFlight, row, col, MEAL_TYPE,RECLINE_INCH);
        
        if(col > 4 || row >5){
            throw new IllegalArgumentException("Row/Column numbers beyond first class.First class seats only in a first 6 rows and 4 columns.");
        }
    }

    /**
     * Returns seat recline
     * 
     *  @return - the amount of inches of recline
     */
    public int getRecline(){
        return RECLINE_INCH;
    }

    /**
     * Return meal type assigned to seat
     * 
     * @return - first class seat meal type 
     */
    public MealType getMealType(){
        return MEAL_TYPE;
    }

    /**
     * Returns seat price
     * 
     * @return the price of the seat
     */
    public double getPrice() {
         return (this.getPrice(alohaDiscount) * PRICE_MARKUP);
    }
    
    public String toString(){
        String info = super.toString();
        info += "This seat price is : " + this.getPrice(alohaDiscount);
        
        return info;
    }
    
}
