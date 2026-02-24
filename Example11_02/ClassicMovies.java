/** Classic Movies - Reading from a text file
*   Anderson, Franceschi
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class ClassicMovies
{
  public static void main( String [] args )
  {
    try ( Scanner file = new Scanner( new File ( "movies.txt" ) ) )
    {
      while ( file.hasNext( ) ) // test for the end of the file
      {
        String movieTitle = file.nextLine( );          
          
        if ( ! file.hasNextInt( ) )
        {
          System.out.println( "Invalid file format" );
          String invalidData = file.nextLine( ); // skip the line
        }
        else
        {
          int runningTime = file.nextInt( );
          String newLine = file.nextLine( ); // read newline character
   
          System.out.println( movieTitle + ", " 
                     + runningTime + " minutes" ); 
        }
      }
    }
    
    catch ( FileNotFoundException fnfe )
    {
      System.out.println( "Unable to find movies.txt, exiting" );
    }
    
    catch ( NoSuchElementException nsee )
    {
      System.out.println( "Attempt to read past the end of the file" );
    }
    
    catch ( IllegalStateException ise )
    {
      System.out.println( "Attempt to read after the file is closed" );
    }
  }
}
