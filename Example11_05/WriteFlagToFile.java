/*  Writes a GIF encoding to a file
    Anderson, Franceschi
*/

import java.io.*;

public class WriteFlagToFile
{  
  private static final int HEIGHT = 10;
  
  public static void main( String [] args )
  {
    try
    {    
      FileWriter fw = new FileWriter( "ItalianFlag.txt", false );
      PrintWriter pw = new PrintWriter( fw );
      pw.println( 30 ); // width of GIF
      // write HEIGHT lines of color and pixels data
      for ( int i = 0; i < HEIGHT; i++ ) 
      {
        pw.print( 10 ); // 10 green pixels
        pw.print( ' ' ); // white space character
        pw.print( 0.0 ); // red color component
        pw.println( " 1.0 0.0" ); // green and blue color components
        
        pw.println( "10 1.0 1.0 1.0" ); // 10 white pixels
        pw.println( "10 1.0 0.0 0.0" ); // 10 red pixels
      }
      
      pw.close( );
    }
    
    catch ( IOException ioe )
    {
      System.out.println( ioe.getMessage( ) );
    }
  }
}