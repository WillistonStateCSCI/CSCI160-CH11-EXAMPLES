/* A class to analyze data from movies
   Anderson, Franceschi
*/

import java.io.*;
import java.util.*;
import org.json.*;

public class Movies {
  public static void main(String args[]) {
    String fileName = "Example11_14_15/movies.json";

    try {
      File fileObj = new File(fileName);
      Scanner file = new Scanner(fileObj);
      String json = "";
      String s = null;
      while (file.hasNext()) {
        s = file.nextLine();
        json += s;
      }
      file.close();

      JSONArray jsonArray = new JSONArray(json);
      System.out.println("There are " + jsonArray.length()
          + " movies");

      // Build ArrayList of MovieRecord objects
      ArrayList<Movie> movies = new ArrayList<Movie>();

      for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject jsonMovie = jsonArray.getJSONObject(i);
        String title = jsonMovie.getString("title");
        int year = jsonMovie.getInt("year");
        if (title.equals(""))
          System.out.println("Discarding (no title)");
        else
          movies.add(new Movie(title, year));
      }

      // Ask user to enter a year
      Scanner scan = new Scanner(System.in);
      System.out.print("Please enter a year > ");
      int year = scan.nextInt();
      scan.close();
      // Retrieve number of movies for that year
      long count = movies.stream()
          .filter(movie -> movie.year() == year)
          .count();
      System.out.println("There were " + count
          + " movies in " + year);
    } catch (IOException ioe) {
      System.out.println(ioe.getMessage());
    } catch (JSONException jsone) {
      System.out.println(jsone.getMessage());
    }
  }
}