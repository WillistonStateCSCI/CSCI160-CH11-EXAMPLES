/*  JSON Parsing
*   Anderson, Franceschi
*/

import org.json.*;

public class JsonParsing
{
  public static void main( String [] args )
  {
    try
    {
      String json1 = "[Paris, New York, Rio]";    
      JSONArray jsonArr = new JSONArray( json1 );
      String city1 = jsonArr.getString( 1 );
      System.out.println( "city1 is " + city1 );
    
      String json2 = 
        "{'city':'Miami', 'state':'FL', 'country':'USA'}";
      JSONObject jsonObj = new JSONObject( json2 );
      String state = jsonObj.getString( "state" );
      System.out.println( "state is " + state );   
    }
    catch( JSONException je )
    {
      System.out.println( "exception: " + je.toString( ) );
    }
  }
}
