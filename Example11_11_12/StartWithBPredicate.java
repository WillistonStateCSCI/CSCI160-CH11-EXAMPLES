/** Predicate testing whether a String starts with B
    Anderson, Franceschi
*/
import java.util.function.*;

public class StartWithBPredicate<T> implements Predicate<T>
{
  public boolean test( T t )
  {
    if ( !( t instanceof String ) )
      return false;
    else
    {
      String s = ( String ) t;
      return s.charAt( 0 ) == 'B';
    }
  } 
}