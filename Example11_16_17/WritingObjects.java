/* Demonstrating how to write objects to a file
   Anderson, Franceschi
*/

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WritingObjects
{
  public static void main( String [] args )
  {
   // instantiate the objects
   Flight2 fr1 = new Flight2( "AA31", "BWI", "SFO", 200, 235.9 );
   Flight2 fr2 = new Flight2( "CO25", "LAX", "JFK", 225, 419.9 );
   Flight2 fr3 = new Flight2( "US57", "BWI", "DEN", 175, 179.5 );

   try
   {
    FileOutputStream fos = new FileOutputStream
                                  ( "objects", false );
             // false means we will write to objects

    ObjectOutputStream oos = new ObjectOutputStream( fos );

    // write the objects to the file
    oos.writeObject( fr1 );
    oos.writeObject( fr2 );
    oos.writeObject( fr3 );

    // release resources associated with the objects file
    oos.close( );
   }

   catch ( FileNotFoundException fnfe )
   {
     System.out.println( "Unable to write to objects" );
   }

   catch ( IOException ioe )
   {
      ioe.printStackTrace( );
   }
 }
}
