/*  Appends to a file
    Anderson, Franceschi
*/

import java.io.*;
import java.util.*;

public class AppendToFlagFile
{      
  static final int PIXELS = 10;
  
  public static void main( String [] args )
  {
    int lines = 0;   
    Scanner scan = new Scanner( System.in );
    boolean goodInput = false;
    
    do
    {
      try
      {
        // prompt for input; expected value is an int
        System.out.print( "Enter a number of lines (20 to 50) "
                        + "to append > " );
        lines = scan.nextInt( );
        if ( lines >= 20 && lines <= 50 )
          goodInput = true;
      }
      
      catch ( InputMismatchException ime )
      {
        // consume invalid data left in input stream
        String garbage = scan.nextLine( );
        System.out.print( "You did not enter an integer; "
                        + "please enter an integer > " );
      }
    } while ( !goodInput );
  
    try
    {    
      FileWriter fw = new FileWriter( "ItalianFlag.txt", true );
      PrintWriter pw = new PrintWriter( fw );
      // append lines of color and pixels data for this flag
      for ( int i = 0; i < lines; i++ )
      {
        pw.println( PIXELS + " 0.0 1.0 0.0" ); // PIXELS green pixels   
        pw.println( PIXELS + " 1.0 1.0 1.0" ); // PIXELS white pixels
        pw.println( PIXELS + " 1.0 0.0 0.0" ); // PIXELS red pixels
      } 
      pw.close( );
    }
    
    catch ( IOException ioe )
    {
      System.out.println( ioe.getMessage( ) );
    }
  }
}