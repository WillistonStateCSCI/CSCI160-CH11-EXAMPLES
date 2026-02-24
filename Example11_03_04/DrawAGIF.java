/* Drawing a GIF
   Anderson, Franceschi
*/

import java.io.*;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
 
public class DrawAGIF extends Application 
{
  final int WIDTH = 500;
  final int HEIGHT = 300;
    
  @Override
  public void start( Stage stage ) 
  {                   
    Scanner scan = new Scanner( System.in ); 
    Scanner file = null; 
    String filename = "";   
    boolean fileFound = false;
    
    do 
    { 
      try 
      {
        System.out.print( "Enter the name of the file > " );
        filename = scan.next( );
       
        File inputFile = new File( filename );
        file = new Scanner( inputFile );
        fileFound = true;
      }
      catch ( FileNotFoundException fnf )
      {
        System.out.println( "Unable to find " + filename );
      } 
    } while ( !fileFound );       
              
    // set up window title and size
    GraphicsContext gc = JIGraphicsUtility.setUpGraphics( 
            stage, "Draw a flag", WIDTH, HEIGHT );          
    gc.setFill( Color.LIGHTSKYBLUE );
    gc.fillRect( 0, 0, WIDTH, HEIGHT );   

    GIFDecoding flag = new GIFDecoding( file );
    flag.drawGIF( gc, 50, 50 );
  }    
    
  public static void main( String [] args ) 
  {
    launch( args );
  }    
}