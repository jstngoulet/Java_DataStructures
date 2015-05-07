package KrashKourse;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;


public class CarSelect extends JFrame
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public static final int HEIGHT = 150, WIDTH = 350;
   private JPanel cars = new JPanel();
   private JPanel pics = new JPanel();
   private JButton save= new JButton("Select Car");
   private JLabel carPic = new JLabel();
   private JLabel current = new JLabel("Current Car in use:");
   private int selectedIndex;
   String carChoice = null;
   
   String carList[] =  {"Please Select Car", "Red Car", "Police Car", "Blue Car",
         "Pink Car", "Taxi", "Green Car", "Yellow Car", "White and Black"};
         
   JComboBox<String> carOptions = new JComboBox<String>(carList);
   String chosen;


   public CarSelect()
   {
   //Constructor
      super("Car Select");
      setSize(WIDTH, HEIGHT);
      setLayout(new GridLayout(1,2));
      setResizable(false);
      addComp();
      
      //Add two frames. One for the info, one to show the car
      //that the user selected
      add(cars);
      add(pics);
      
      //center the frame
      setLocationRelativeTo(null);
      setVisible(true);
     
   }
   
   public void addComp()
   {
   //Adds items to screen
      carOptions.addActionListener(new getIndex());
      save.addActionListener(new Save());
      cars.setLayout(new FlowLayout(5, 5, 15));
      cars.setBackground(Color.LIGHT_GRAY);
      cars.add(current);
      cars.add(carOptions);
      cars.add(save, BorderLayout.SOUTH);
      
      Scanner inputStream = null;
      try
      {
      //Reads in current car
         inputStream = new Scanner(new FileInputStream("CarChosen.txt"));
         while(inputStream.hasNext())
         { 
            carChoice = inputStream.next();
         }
         inputStream.close();
      
      }
      
      catch(FileNotFoundException e)
      {
         System.out.println("No Cars saved yet");
      }
      
      //If there is not a current car saved, show a default
      if(carChoice == null)
      {
         carChoice = "CarOne.png";
      }
   
      //Set the icon of the car saved
      carPic.setIcon(new ImageIcon(carChoice));
      pics.setBackground(Color.LIGHT_GRAY);
      pics.add(carPic);
     
      
   }
   
   
   public static void main(String [] args)
   {
   //To run class by itself for testing
      new CarSelect();
   }
   
   
   private class getIndex implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         selectedIndex = carOptions.getSelectedIndex();
         
         //get the car the user selected from the drop down menu
         //and set the car to match the users choice
         switch(selectedIndex)
         {
            case 0:
               chosen = "CarOne.png";
               break;
            case 1:
               chosen = "CarOne.png";
               break;
            case 2:
               chosen = "UserCopCar.png";
               break;
            case 3:
               chosen = "UserBlueCar.png";
               break;
            case 4:
               chosen = "UserPinkandBlack.png";
               break;
            case 5:
               chosen = "Taxi.png";
               break;
            case 6:
               chosen = "UserGreenCar.png";
               break;
            case 7:
               chosen = "UserYellowCar.png";
               break;
            case 8:
               chosen = "UserWhiteAndBlack.png";
               break;
            default:
               chosen = "CarOne.png";
               break;
         
         }  
         //Set the new car
         carPic.setIcon(new ImageIcon(chosen));
      }
   }
   private class Save implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
                     
         PrintWriter outputStream = null;
            //Save to a File
         try{
            outputStream = new PrintWriter(new FileOutputStream("CarChosen.txt"));
         }
         catch(FileNotFoundException a)
         {
            dispose();
         }    
         outputStream.println(chosen);
         //Close the stream
         outputStream.close(); 
         //Close the window
         dispose();    
      }
   }   
}
