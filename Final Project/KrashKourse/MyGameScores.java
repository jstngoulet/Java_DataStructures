package KrashKourse;

import java.text.DecimalFormat;



public class MyGameScores 
{
   private String name;
   private Integer score;
	
	//No-arg constructor
   public MyGameScores()
   {
      name = "";
      score = 0;
   }
	
	//This constructor accepts a String argument which is
	//assigned to the name field.
   public MyGameScores(String d)
   {
      name = d;
      score = 0;
   }
	 
	 //This constructor accepts a String argument which is
	 //assigned to the name field and an Integer argument
	 //which is assigned to the score field.
   public MyGameScores(String d, Integer u)
   {
      name = d;
      score = u;
   }
	 
	 //This constructor accepts an Integer argument
	 //which is assigned to the score field.
   public MyGameScores(Integer u)
   {
      score = u;
   }
	 
   public void setName(String d)
   {
      name = d;
   }
	 
   public void setScore(Integer u)
   {
      score = u;
   }
	 
   public String getName()
   {
      return name;
   }
	 
   public Integer getScore()
   {
      return score;
   }
   
   public String toString(String name, Integer score)
   {
	   //Format score
	   DecimalFormat df = new DecimalFormat("###,###,##0");
	   
      return "Player Name: " + name + "\tScore: " +  df.format(score) + "\t";
   }
}