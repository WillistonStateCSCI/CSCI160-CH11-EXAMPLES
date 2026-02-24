 /* Demonstrating how to parse a String with the Scanner class
    Anderson, Franceschi
 */

 import java.util.Scanner;
 import java.util.InputMismatchException;
 import java.util.NoSuchElementException;

 public class UsingScannerToParseAString
 {
   public static void main( String [ ] args )
   {
     String flightRecord1 = "AA123,BWI,SFO,235,239.5";
     
     try ( Scanner parse = new Scanner( flightRecord1 ) )
     {
       // set the delimiter to a comma
       parse.useDelimiter( "," );
       
       System.out.println( parse.next( ) ); // flight number
       System.out.println( parse.next( ) ); // origin airport
       System.out.println( parse.next( ) ); // destination airport
       System.out.println( parse.nextInt( ) ); // number of passengers
       System.out.println( parse.nextDouble( ) ); // average ticket price
     }
     catch ( InputMismatchException ime )
     {
       System.out.println( "Error in data format" );
     }
     catch ( NoSuchElementException nse )
     {
       System.out.println( "No more tokens" );
     }
     catch ( IllegalStateException ise )
     {
       ise.printStackTrace ( );
     }
   }
 }