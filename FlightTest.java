
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.text.ParseException;

/**
 * The test class FlightTest.
 *
 * @author  Iryna Sherepot
 * @version 12/31/18
 */
public class FlightTest{
    Flight myFlight;
    /**
     * Default constructor for test class FlightTest
     */
    public FlightTest(){
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()throws ParseException{
        this.myFlight = new Flight(12,"SEA", "JFK", "05/20/2019", 100.00);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown(){
    }

    @Test
    public void testFlightFullConstructor(){
        assertEquals("SEA",myFlight.getFfligtOrigin());
        assertEquals("JFK", myFlight.getFlightDest());
        assertEquals(12, myFlight.getFlightNumer());
        assertEquals("05/20/2019", myFlight.getFlightDate());
        assertEquals(100.00, myFlight.getBasePrice(), 2);
    }
    //====================SEAT TESTS===========================
    @Test
    public void testFirstSeatConstructor(){
        FirstClassSeat firstSeat =(FirstClassSeat) myFlight.getSeat(1,2);
        assertEquals(1, firstSeat.getRow());
        assertEquals(2, firstSeat.getCol());
        assertEquals("1C", firstSeat.getSeatNumber());
        assertEquals(8, firstSeat.getRecline());
        assertEquals(Seat.MealType.Gourmet, firstSeat.getMealType());
        assertEquals(200.00, firstSeat.getPrice(), 2);
        assertEquals(false, firstSeat.getIsBooked());

    }

    @Test
    public void testAddConfirmationMethod(){
        FirstClassSeat firstSeat = (FirstClassSeat)myFlight.getSeat(1, 2);
        Confirmation firstConf = new Confirmation("Alex", "123456", false);
        firstSeat.addConfirmation(firstConf);
        assertEquals("Alex", firstSeat.getConf().getName());
        assertEquals("123456", firstSeat.getConf().getConfNumber());
        assertEquals(false, firstSeat.getConf().getAloha());
        Confirmation secondConf = new Confirmation("Alex", "12345A", true);
        assertEquals(false, firstSeat.getConf().getAloha());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddConfirmationMoreThanOne(){
        FirstClassSeat firstSeat = new FirstClassSeat(myFlight, 1, 2);
        Confirmation firstConf = new Confirmation("Alex", "123456", false);
        firstSeat.addConfirmation(firstConf);
        Confirmation secondConf = new Confirmation("Maria", "123456", true);
        firstSeat.addConfirmation(secondConf);
    }

    @Test
    public void testComfortSeatConstructor() throws ParseException{
        Flight myFlight = new Flight(12,"SEA", "JFK", "11/20/2020", 100.00);
        ComfortSeat comfySeat = new ComfortSeat(myFlight, 7, 2);
        assertEquals(7, comfySeat.getRow());
        assertEquals(2, comfySeat.getCol());
        assertEquals("7C",comfySeat.getSeatNumber());
        assertEquals(6, comfySeat.getRecline());
        assertEquals(Seat.MealType.Full, comfySeat.getMealType());
        assertEquals(150.00, comfySeat.getPrice(), 2);
        assertEquals(false, comfySeat.getIsBooked());
    }

    @Test
    public void testEconomSeatConstructor(){
        EconomySeat economSeat = (EconomySeat) myFlight.getSeat( 43, 7);
        assertEquals(43, economSeat.getRow());
        assertEquals(7, economSeat.getCol());
        assertEquals("43H",economSeat.getSeatNumber());
        assertEquals(3, economSeat.getRecline());
        assertEquals(Seat.MealType.Snack, economSeat.getMealType());
        assertEquals(100.00, economSeat.getPrice(), 2);
        assertEquals(false, economSeat.getIsBooked());
    }

    //first class seats 
    @Test(expected = IllegalArgumentException.class)
    public void testFistSeatWrongRowConstructor(){
        FirstClassSeat firstSeat = new FirstClassSeat(myFlight, 7, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFistSeatWrongColConstructor()throws ParseException{
        Flight myFlight = new Flight(50,"AAA", "FFF", "05/20/2019", 100.00);
        FirstClassSeat firstSeat = new FirstClassSeat(myFlight, 6, 5);
    }
    //comfort class seats 
    @Test(expected = IllegalArgumentException.class)
    public void testComfySeatWrongRowConstructor() throws ParseException{
        Flight myFlight = new Flight(50,"AAA", "FFF", "05/20/2019", 100.00);
        ComfortSeat firstSeat = new ComfortSeat(myFlight, 0, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testComfySeatWrongRColConstructor() throws ParseException{
        Flight myFlight = new Flight(50,"AAA", "FFF", "11/20/2020", 100.00);
        ComfortSeat firstSeat = new ComfortSeat(myFlight, 0, 8);
    }

    //economy class seats  
    @Test(expected = IllegalArgumentException.class)
    public void testEconSeatWrongRowConstructor() throws ParseException{
        Flight myFlight = new Flight(50,"AAA", "FFF", "11/20/2020", 100.00);
        EconomySeat firstSeat = new EconomySeat(myFlight, 13, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEconSeatWrongColConstructor() throws ParseException{
        Flight myFlight = new Flight(50,"AAA", "FFF", "11/20/2020", 100.00);
        EconomySeat firstSeat = new EconomySeat(myFlight, 0, -2);
    }

    @Test
    public void testReleaseSeatMethod(){
        FirstClassSeat firstSeat = (FirstClassSeat) myFlight.getSeat( 1, 2);
        Confirmation firstConf = new Confirmation("Alex", "ABZ56Y", false);
        firstSeat.addConfirmation(firstConf); 
        firstSeat.releaseSeat(); 
        firstSeat.getConf();
    }

    @Test
    public void testGetPassengerCount(){
        FirstClassSeat firstSeat = (FirstClassSeat) myFlight.getSeat( 1, 2);
        Confirmation firstConf = new Confirmation("Alex", "ABZ56Y", false);
        firstSeat.addConfirmation(firstConf);
        assertEquals(1, myFlight.getPassCount());        
    }

    //===========FLIGHT CONSTRUCTOR PRECONDITION TESTS===============  
    @Test(expected = IllegalArgumentException.class)
    public void testNegNumFlightConstructor() throws ParseException{
        Flight myFlight = new Flight(-10, "SEA", "JFK", "11/20/2020", 100.00);        
    }

    
    @Test(expected = java.text.ParseException.class)
    public void testNegDateFlightConstructor() throws ParseException{
    Flight myFlight = new Flight(10, "SEA", "JFK", "-11/20/2020", 100.00);  
    }
    
   
    @Test(expected = IllegalArgumentException.class)
    public void testNullDepFlightConstructor() throws ParseException{
        Flight myFlight = new Flight(-10, null, "JFK", "11/20/2020", 100.00);  
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullDeSTFlightConstructor() throws ParseException{
        Flight myFlight = new Flight(-10, "JFK", null, "11/20/2020", 100.00);  
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringLengthFlightConstructor() throws ParseException{
        Flight myFlight = new Flight(10, "JFKK", "AZA", "11/20/2020", 100.00);  
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegPriceFlightConstructor() throws ParseException{
        Flight myFlight = new Flight(10, "SEA", "JFK", "11/20/2020", -100.00);  
    }

    //========= CONFIRMATION TESTING=========================
    public void testConfirmationConstructor(){         
        Confirmation conf1 = new Confirmation("Alex", "ABZ56Y", false);
        assertEquals("Alex", conf1.getName());
        assertEquals("ABZ56Y", conf1.getConfNumber());
        assertEquals(false, conf1.getAloha());
    }

}
