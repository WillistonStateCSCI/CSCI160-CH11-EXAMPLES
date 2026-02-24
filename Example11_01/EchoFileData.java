/* Reading a Text File
   Anderson, Franceschi
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EchoFileData
{
  public static void main( String [] args )
  { 
    try
    { 
      File inputFile = new File( "data.txt" );
      Scanner file = new Scanner( inputFile );

      while ( file.hasNextInt( ) )
      {    
        int number = file.nextInt( );
        System.out.println( number );
      }
    }
    catch ( FileNotFoundException fnfe )
    {
      System.out.println( "Message: " + fnfe.getMessage( ) );   
      System.out.println( "\ntoString( ): " + fnfe + "\n" );
      fnfe.printStackTrace( );
    }  
  }
}
