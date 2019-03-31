# Aloha-airlines

This is an project from  CSC143 class, I worked during free time. Instructor of other class gave it to me as practice.

This project focuses on OOP concepts, inheritance, 2D arrays, ArrayLists.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Here is a project description:
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Aloha Airlines wants a proof of concept for a flight booking system. This project implements supplier code for them.  
**********************************************************************************************************************

Flights:  each flight has a flight number, an origin and a destination (a three-letter, airport codes), and a date.  Once the flight is set up, none of this information can be changed (but should be available, if requested).  Aloha needs a way to get a passenger count (a tally of booked seats), and to render full details from all seats on the flight.   
Airplane configurations include three types of seats. Flights have six First Class rows, each having four seats per row (2 + 2), then eight Comfort rows, each having 6 seats per row (2 + 2 + 2), then 30 Economy rows, each having eight seats per row (2 + 4 + 2).  
**********************************************************************************************************************

First Class seats recline 8 inches; Comfort, 6; Economy, 3. First Class passengers receive a Gourmet meal, Comfort passengers, a Full meal; Economy passengers, a Snack. Customers cannot upgrade meals; they get the one matching their seat assignment.  Also, some First-class seats have the Extra Room feature; this gives passengers two more inches of recline.  In the new plane configuration, the first two first-class rows have this option; the rest don’t. 
Each flight has a base seat price associated with it. Client code must be able to access that base price upon request. Seat pricing is as follows:  Economy seats are priced at the base seat price. Comfort seats are 150% of the base seat price, and First Class 200% of the base price (with Extra Room seats $50 extra). The base seat price may be adjusted later (e.g., as the flight date approaches), which raises the price for new bookings. 
**********************************************************************************************************************

In addition, the company has introduced the Aloha Club. Customers who join the Club get discounted prices on seats. Members get a 10% discount on First Class seats, a 5% discount on Comfort seats, and 2% on Economy seats. . 
**********************************************************************************************************************

Customer Confirmations:  each confirmation includes a customer name and a six-character confirmation code (alphabetic)1.  This data can be altered at any time.  Once a seat is booked by a customer, the confirmation is added to the (existing) seat they have reserved.   Each seat, then, either has a confirmation (booked) or not (not yet booked or released from a previous booking). 
**********************************************************************************************************************
Client Code Requirements Client code must be able to… 
**********************************************************************************************************************

1 Flight :
• Retrieve individual attributes including the date, origin, destination, flight number • Retrieve the passenger count.  Retrieve a detailed list of all flight and seat information • Retrieve a specific seat, either by seat number or row/column2 • Retrieve an array of seat references associated with a specified customer confirmation number 
**********************************************************************************************************************

2 Seat :
 Retrieve individual attributes including seat number, meal type, price, and recline • Make changes to all attributes except the seat number • Retrieve the customer confirmation associated with the seat • Release the seat, removing the existing customer confirmation 
**********************************************************************************************************************

3 Customer Confirmations :
• Retrieve individual attributes including the confirmation number and customer name • Make changes to the attributes 
In addition to what was stipulated in Aloha Part 1, here are some additional requirements:
**********************************************************************************************************************

 • Use a single 2D array to manage all seats; do not store them in separate arrays per seating area.  
• Ensure that when seat details are displayed, each seat describes itself fully, e.g., it should say it’s a first-class seat, a comfort seat, or an economy seat. It should show the price, as well, along with all other pertinent information (including confirmation data). Each seat’s output should fit on one line.
 • In Flight, provide a getSeats method that takes a customer confirmation number as a parameter, and returns an array of seats that correspond to that confirmation number.  It’s okay to use an ArrayList in the process of finding the seats; the return must be an array, however.
 • In Flight, provide a getEmptySeats method that returns an array of seats
**********************************************************************************************************************

