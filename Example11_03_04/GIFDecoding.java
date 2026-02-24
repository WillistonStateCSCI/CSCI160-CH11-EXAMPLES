/* GIF decoding class
   Anderson, Franceschi
*/

import java.io.*;
import java.util.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GIFDecoding
{
  private int width; // the width of the GIF

  // ArrayList instance variables:
  // colorList stores Color references
  // lengthList stores integers, the length of each run 
  private ArrayList<Color> colorList;
  private ArrayList<Integer> lengthList;
  
  /* GIFDecoding constructor
   * @param file a Scanner, already open for reading a GIF file
   * initializes width with the first int in file
   * fills the two ArrayLists with the 
   * ints and colors stored in filen
  */
  public GIFDecoding( Scanner file )
  {
    colorList = new ArrayList<Color>( );
    lengthList = new ArrayList<Integer>( );
    
    try
    {
      width = file.nextInt( );
      int length;
      double red, green, blue;
      
      while ( file.hasNext( ) )
      {
        length = file.nextInt( );
        lengthList.add( length );
        
        red = file.nextDouble( );
        green = file.nextDouble( );
        blue = file.nextDouble( );
        colorList.add( Color.color( red, green, blue ) );
      }
    }
    catch ( InputMismatchException ime )
    {
      System.out.println( "Invalid file format; exiting" );
    }
    catch ( Exception e )
    {
      System.out.println( e.getMessage( ) );
    }
    finally
    {
      file.close( );
    }
  } 
         
  /*
   * drawGIF method
   * @param gc a GraphicsContext reference, the Graphics context
   * @param x an int, the drawing's upper left corner x coordinate
   * @param y an int, the drawing's upper left corner y coordinate
  */
  public void drawGIF( GraphicsContext gc, int x, int y  )
  {
    // draw the gif
    Color currentColor;
    int index = 0;
    int deltaX = 0;
    for ( int length : lengthList )
    {
      currentColor = colorList.get( index ); 
      gc.setStroke( currentColor );
      
      // draw one or more lines using length pixels with currentColor
      while ( length >= width - deltaX )
      {
        gc.strokeLine( x + deltaX, y, x + width, y );
        y++;
        length = length - ( width - deltaX );
        deltaX = 0;
      }

      if ( length > 0 )
        gc.strokeLine( x + deltaX, y, x + deltaX + length, y );
      
      deltaX = deltaX + length;
      index++;
    }
  }  
}