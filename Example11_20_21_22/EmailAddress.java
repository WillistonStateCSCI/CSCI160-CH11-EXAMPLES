/* The EmailAddress class
   Anderson, Franceschi
*/

public class EmailAddress
{
  public static final char AT_SIGN = '@';
  private String email;

  /**
  * Constructor:<br/>
  * initializes email<br/>
  * @param email the new email of email
  */
  public EmailAddress( String email )
                     throws IllegalEmailException
  {
    if ( email.indexOf( AT_SIGN ) != -1 )
       this.email = email;
    else
       throw new IllegalEmailException
             ( "Email address does not contain " + AT_SIGN );
  }

  /**
  * getHost method:<br/>
  * Retirves the host of this email address<br/>
  * @return a String, the host within this email address
  */
  public String getHost( )
  {
    int index = email.indexOf( AT_SIGN );
    return email.substring( index + 1, email.length( ) );
  }
}
