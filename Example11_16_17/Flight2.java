/* The Flight2 Record class
   Anderson, Franceschi
*/

import java.io.Serializable;

record Flight2( String flightNumber,
                String origin, String destination,
                int numPassengers, double avgTicketPrice )
                implements Serializable { }