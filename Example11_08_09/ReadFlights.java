 /* Reading structured data from a text file
    Anderson, Franceschi
 */

 import java.io.File;
 import java.io.FileNotFoundException;
 
 import java.util.Scanner;
 import java.util.InputMismatchException;
 import java.util.ArrayList;

 public class ReadFlights
 {
   public static void main( String [ ] args )
   {
     // instantiate ArrayList to hold Flight objects
     ArrayList<Flight> listFlights = new ArrayList<Flight>( );

     try
     {
       Scanner file = new Scanner( new File( "flights.txt" ) );

       while ( file.hasNext( ) ) // test for the end of the file
       {
         // read a line
         String stringRead = file.nextLine( );

         // process the line read
         Scanner parse = new Scanner( stringRead );
         parse.useDelimiter( "," );
         String flightNumber = parse.next( );
         String origin = parse.next( );
         String destination = parse.next( );

         try
         {
           int numPassengers = parse.nextInt( );
           double avgTicketPrice = parse.nextDouble( );

           Flight frTemp = new Flight( flightNumber, origin, 
               destination, numPassengers, avgTicketPrice );

           // add FlightRecord obj to listFlightRecords
           listFlights.add( frTemp );
         }

         catch ( InputMismatchException ime )
         {
           System.out.println( "Error in flight record: "
           + stringRead + "; record ignored" );
         }
       }

       // release resources associated with flights.txt
       file.close( );
     }

     catch ( FileNotFoundException fnfe )
     {
       System.out.println( "Unable to find flights.txt" );
     }

     catch ( Exception e )
     {
       e.printStackTrace( );
     }

     // print the FlightRecords read
     for ( Flight flight : listFlights )
       System.out.println( flight );
   }
 }
