
/**
 * Represents Customer Confirmationsclass.
 * Each confirmation includes a customer name and a six-character confirmation code (alphabetic)1.  This data can be altered at any time.  
 * Once a seat is booked by a customer, the confirmation is added to the (existing) seat they have reserved.   
 * Each seat, then, either has a confirmation (booked) or not (not yet booked or released from a previous booking). 

 * @author Iryna Sherepot
 * @version 10/6/2018
 */
public class Confirmation{
    private String custName;
    private String confNumber;
    private boolean Aloha;

    
    /**
     * Constructor for objects of class Confirmation
     * 
     * @param custName The name of customer on a confirmation
     * @param confNumber The confirmation number - 6 characters
     * @param Aloha The status if the customer belongs to Aloha discount club
     */
    public Confirmation(String custName, String confNumber, boolean Aloha){
        if(confNumber.length() != 6){
            throw new IllegalArgumentException("Confirmation must be 6 characters long");
        }
        setConfirmation(custName, confNumber, Aloha); 
    }

    
    /**
     * Assigns values to the confirmation
     * 
     * @param custName the name of the customer
     * @param confNumber The confirmation number
     * @param Aloha  customer belonging to the Aloha discount club
     */
    public void setConfirmation(String custName, String confNumber, boolean Aloha){
        // put your code here
        this.custName = custName;
        this.confNumber = confNumber;
        this.Aloha = Aloha;
    }
    //----------------------------------------------------------------------------------
    //2.3 Customer Confirmations • 
    //Retrieve individual attributes including the confirmation number and customer name  
    //Make changes to the attributes 
    // /**
    // * returns a completer confimation number
    // */
    //don't need this method
    // public String getConfirmation(){
    // return custName + confNumber;
    // }
    /**
     * Returns customer name on a confimation.
     *
     * @return customer name.
     */
    public String getName(){
        return custName;   
    }

    /**
     *  Returns a complete confimation number.
     *  
     *  @return confimation number.
     */
    public String getConfNumber(){
        return confNumber;   
    }

    /**
     * Returns boolen showing if a customer belongs to Aloha discount club.
     * 
     * @return belonging to Aloha club.
     */
    public boolean getAloha(){
        //if(confirmation is not null)
        return this.Aloha;
    }
    
    public String toString(){
        String info = "";
        System.out.println();
        info += "\nThe confimation name is : "       + this.getName() + "\n";
        info += "The Confirmation number is "       + this.getConfNumber() + "\n";
        info += "The Full confirmation number is: " + this.getName()+ this.getConfNumber() +  "\n";

        return info;
}
}
