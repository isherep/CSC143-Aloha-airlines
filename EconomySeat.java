
/**
 * This is a model of economy-class seat.
 * 
 *  Economy Class passengers receive a Snack meal and have 2 inches of recline
 *
 * @author Iryna Sherepot
 * @version 11/20/18
 */
public class EconomySeat extends Seat{
   
    private Confirmation confirm;
    private double alohaDiscount = 0.02;
    
    private static final MealType MEAL_TYPE = MealType.Snack;
    private static final int RECLINE_INCH = 3;
    

    /**
     * Constructor of Economy class seat 
     * 
     * @param flight1 - the flight which seat is on
     * @row - the row the seat is in. Must be bew\twen 15 and 44 inclusive 
     * @col - the column te seat is in. Must be between 0 to 8 inclusive.
     */
    public EconomySeat(Flight flight1, int row, int col){
        super( flight1,row, col,MEAL_TYPE, RECLINE_INCH );
        if(col > 8 || row < 15 || row >44){
            throw new IllegalArgumentException("Row/Column numbers beyond Economy class.Economy class seats only in a first 6 rows and 4 columns.");
        }
    }

    /**
     * Returns seat recline
     * 
     * @return - the amount of inches of recline
     */
    public int getRecline(){
        return RECLINE_INCH;
    }

    /**
     * Return meal type assigned to seat
     * 
     * @return - economy class seat meal type 
     */
    public MealType getMealType(){
        return MealType.Snack;
    }

    /**
     * Returns seat price
     * 
     * @return the price of the seat
     */
    public double getPrice() {
        return this.getPrice(alohaDiscount) ;
       
    }
    
    public String toString(){
        String info = super.toString();
        info+="This seat price is : " + this.getPrice(alohaDiscount) + "\n";
        
        return info;
    }
}

