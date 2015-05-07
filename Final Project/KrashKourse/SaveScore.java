package KrashKourse;

import java.io.*;

public class SaveScore
{

   public SaveScore(String name, int score)
   {
      //This method takes in the players name and their score and 
      //saved the information to a file
      //Write score to appended file
      PrintWriter outputStream = null;
      try
      {
         outputStream = new PrintWriter(new FileOutputStream("scores.txt", true));
      }
      catch(FileNotFoundException a)
      {
         System.out.println("No File Found");
      }    
      outputStream.println(name + " " + score);
      outputStream.close(); 
   }


}