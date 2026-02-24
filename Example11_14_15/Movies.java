/* A class to analyze data from movies
   Anderson, Franceschi
*/

import java.io.*;
import java.net.*;
import java.util.*;
import org.json.*;

public class Movies
{
  public static void main( String args [ ] ) 
  {
    String GITHUB = "https://raw.githubusercontent.com/";
	 String fileName = GITHUB +
      "prust/wikipedia-movie-data/master/movies.json";
    
	 try 
    {
      URL url = new URL( fileName );
      InputStream is = url.openStream( );
      Scanner file = new Scanner( is );
      String json = "";
      String s = null;
      while ( file.hasNext( ) )
      {
        s = file.nextLine( );
        json += s;
      }
      
      JSONArray jsonArray = new JSONArray( json );
      System.out.println( "There are " + jsonArray.length( ) 
                                       + " movies" );
                                 
      // Build ArrayList of MovieRecord objects
      ArrayList<Movie> movies = new ArrayList<Movie>( );
      
      for ( int i = 0; i < jsonArray.length( ); i++ )
      {
        JSONObject jsonMovie = jsonArray.getJSONObject( i ); 
        String title = jsonMovie.getString( "title" );
        int year = jsonMovie.getInt( "year" );
        if ( title.equals( "" ) )
          System.out.println( "Discarding (no title)" );
        else
          movies.add( new Movie( title, year ) );
      }                               
                
      // Ask user to enter a year
      Scanner scan = new Scanner( System.in );
      System.out.print( "Please enter a year > " );
      int year = scan.nextInt( );
      
      // Retrieve number of movies for that year
      long count = movies.stream( )
                         .filter( movie -> movie.year( ) == year )
                         .count( );
      System.out.println( "There were " + count 
                          + " movies in " + year );
    } 
    catch( MalformedURLException murle ) 
    {
		System.out.println( murle.getMessage( ) );
	 }
    catch( IOException ioe ) 
    {
		System.out.println( ioe.getMessage( ) );
	 }
    catch( JSONException jsone )
    {
      System.out.println( jsone.getMessage( ) );
    }
  }
}