/*  Reading file data into a Stream and processing it
*   Anderson, Franceschi
*/

import java.io.IOException;
import java.nio.file.*;
import java.text.NumberFormat;
import java.util.stream.Stream;

public class FilterAndProcessStream
{
  public static void main( String [] args ) 
  {
   NumberFormat money = NumberFormat.getCurrencyInstance( );
	String cityFile = "cities.txt";
   String expenseFile = "expenses.txt";
	try 
   {
     // build a Stream using cities.txt
     Stream<String> cityStream = 
       Files.lines( Paths.get( cityFile ) );
     // select cities starting with a B and count them
     long count = cityStream.filter( city -> city.charAt( 0 ) == 'B' )
                            .count( );
     System.out.println( "Number of cities starting with B: " + count );
     
     // build a Stream using expenses.txt
     Stream<String> numberStream = 
       Files.lines( Paths.get( expenseFile ) );
     // select positive costs and calculate a sum
     double sum = 
       numberStream.mapToDouble( data -> Double.parseDouble( data ) )
                   .filter( cost -> cost > 0.0 )
                   .sum( );
     System.out.println( "Total expenses: " + money.format( sum ) );   
	} 
   
   catch ( InvalidPathException ipe ) 
   {
	  System.out.println( ipe.getMessage( ) );
	}
   
   catch ( IOException ioe ) 
   {
	  System.out.println( "Could not find file: " + ioe.getMessage( ) );
	}
   
   catch ( SecurityException se ) 
   {
	  System.out.println( se.getMessage( ) );
	}
  }
}