package KrashKourse;

/** Final Project
*   File Name:          RaceGame.java
*   Programmer:         Justin Goulet
*   Date Last Modified: May. 7, 2015
*
*   Problem Statement: (what you want the code to do)
*   
*   Create a game similar to the iOS game I put on the app store a few months ago.
*   
*   <Updated links>
*   		<a href="https://itunes.apple.com/cn/app/krash-kourse/id870366244?l=en&mt=8">Krash Kourse</a>			//Original
*   		<a href="https://itunes.apple.com/cn/app/krash-kourse-2/id968211755?l=en&mt=8">Krash Kourse 2</a>		//Second Version
*   </Updated links>
*   	
*   This game allows you to control a car on a road with oncoming traffic.
*   You keep going until you hit an oncoming car. As you play, the car moves 
*   faster and dodging cars gets harder
*    
*   Overall Plan (step-by-step, how you want the code to make it happen):
*	1. Create a PAnel for each of my menus
*      
*      1)There should be one for the menu, game, and the high scores menu
*      
*	2. Create another, smaller frame for the user to select a car
*	
*   3. Add items to the main menu
*	
*   4. Add a menu bar with proper action listeners. Each item should
*      do something. The menu option should take you to the main menu,
*      the scores should take you to the the scores menu, and the quit 
*      option should close the game
*   
*   5. After the menuBar is functional, setup the main menu. This is the 
*      screen that all players see, so it needs to look good. Add images, 
*      labels,  and buttons that allow the user to interact with the menu.
*         
*         1) the Play game btn should hide the main menu and build a road 
*         on the screen. After the road is built, the players car will be 
*         added and the oncoming trafic will be hidden from view
*         
*         2) the High Scores btn should take the user to the high scores
*         screen where they can view their top scores. This screen needs to
*         look good too because people are always checking their personal bests.
*         Make them want to play more!
*         
*         3) the select car btn brings up the frame to the user that allows them
*         to change their car. This car is then saved to a file and is brought
*         back up when the game loads.
*         
*   6. Now that the menu is functional, lets build the game
*         
*         1) Add an array of labels that each of an imageIcon of a roadPiece
*         This is so we can show the user a road that makes it look like the
*         car is moving on the road, not the other way around.
*         
*         2) using the game timer, adjust the Y value of each roadpiece to make it 
*         appear that the car is moving. To make this visually appealing and 
*         realisitc, we need to add a row or two that the user does not see to the 
*         bottom of the screen.
*         
*         3) As we adjust the road pieces based on the timer, we will notice that the 
*         road moves down, but deos not reset. This is why we made another row. Set in
*         the timer listener to check if the y value of the road piece is greater
*         than that of the height of the frame, reset t a negative Y value so the 
*         row appears above the top of the frame and rolls down the screen, like an
*         endless conveyor belt.
*         
*         4) We have a moving road. Now, lets add our car to it. Set the Y value to be
*         a constant so it deos not move up and down. We only want to move left and right
*         to avoid traffic. In the timer listener class, we want to check to see if the 
*         car is still in bounds. But wait, how do we make it move?
*         
*         5) add a mouse listener to check if the user clicks the frame. If the user 
*         clicks to the right of the car, move the car right. if the user clicks to 
*         the left. move it left. The timer listener will be checking to see if the 
*         car has left the screen or not. We want the car to not be able to cheat the 
*         game, so we set the X value to the greatest(or least) possible and change the 
*         variable to the carMovement so they car easily enter the other direection
*         again.
*         
*         6) Check to see if the user hits another car or not. This is also happening
*         in the timer listener because we want to check everytime the game moves.
*         As of right now, we cant see what the cars look like, so we need to add 
*         some images.
*         
*         7) create methods that will enable each of the three cars to choose a random
*         color. Them, after the car is selected, we want the car to be moved to a random
*         lane so the game is different every time the user plays. Call this method every 
*         time the oncoming car's Y vlaue is greater than the height of the frame.
*         
*         8) now that we can see the cars we hit, we need to show the user a gameOver screen 
*         as well as stop all actitivy that is going on in the game. we want to stop the timer
*         which stops all movement in the road, car, and oncoming traffic. Then, show the user
*         a game over screen that will allow them to see their scores of return to the main menu
*        
*         9) at this point, we need to save the score from the game. We will do this by 
*         calling a different class that allows us to save the player name and score to a file.
*         We will append this file so the user can save all scores earned while playing.
*        
*   7. Now that the game is functional, now for the high scores menu
*   
*         1)Add an image to the screen that tells the user that they are in teh 
*         High Scores Screen
*         
*         2) Add images for user appeal. This is the reason for the two cars on 
*         the left and right
*         
*         3) Add a JTextArea that is not editable, but will load in the scores read from
*         a file. This will be done using the readFileIntoHashMap class that will
*         first import the name and score of the very first game and add each item to 
*         our hashmap. This will keep going until all scores in the file are added.
*         
*         4) Now we need to sort the scores array. This is so we can get the scores
*         array from least to greatest. Why is this helpful? this helps us sort
*         the list from greatest to smallest using recursion in a later step.
*         This is so we can see the descending list of scores, becasue we really
*         only car about the top few.
*         
*         5) Now that the scores are sorted, we lost the corresponding name. To 
*         match the scores back up with the person that earned it, we need to 
*         create a search method that will search for the player name by the score
*         they recieved.
*         
*         6) after the scores are matched up with their players, we need to add the
*         information to a string that will be returned and sent to another class via
*         another method. We now have a foramtted String with the matched up user names
*         and scores.
*         
*         7) add the string to the text area.
*         
*         8) Change the font of the text area so the scores are easier to read
*         
*
*   etc.
*
*   Classes needed and Purpose (Input, Processing, Output)
*   main class - RaceGame.java
*   CarSelect.java
*   SaveScore.java
*   readFileIntoArrayList.java
*   MyGameScores.java
*  
*
*/


import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Random;

public class RaceGame extends JFrame
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//For Main Menu
   private static int HEIGHT = 800, WIDTH = 700;
   private JPanel scorePanel = new JPanel();
   private JPanel movementPanel = new JPanel();
   private JPanel menu = new JPanel();
   private JLabel topScore = new JLabel();
   
   JLabel title = new JLabel(new ImageIcon("KrashKourseMain.png"));
   JButton playGame = new JButton(new ImageIcon("PlayGame.png"));
   JButton selectCar = new JButton(new ImageIcon("SelectCar.png"));
   JLabel carOne = new JLabel(new ImageIcon("CarOne.png"));
   JLabel carTwo = new JLabel(new ImageIcon("CarTwo.png"));
   
   String[] carArray = {"BlueCar.png", "CopCar.png", "OrangeCar.png", "OncomingCar.png", "PinkCar.png"};
   
   
   //For high Scores Screen
   private JLabel header = new JLabel(new ImageIcon("HighScoresHeader.png"));
   private String carChoice = null;
   JLabel carOne2 = new JLabel(new ImageIcon("CarOne.png"));
   JLabel carTwo2 = new JLabel(new ImageIcon("CarTwo.png"));
   JButton highScores = new JButton(new ImageIcon("HighScores.png"));
   private JPanel scoreSheet = new JPanel();
   
   //For Main Game
   private JLabel car = new JLabel();
   JLabel scoreLbl = new JLabel("Score: ");
   JLabel oncomingOne = new JLabel(" ");
   JLabel oncomingTwo = new JLabel(" ");
   JLabel oncomingThree = new JLabel(" ");
   private int movement = 1, speed = 3;
   private Timer timer = new Timer(speed, new TimerListener());
   private JLabel roadOne[] = new JLabel[5];
   private JLabel roadTwo[] = new JLabel[5];
   private JLabel roadThree[] = new JLabel[5];
   private JLabel roadFour[] = new JLabel[5];
   private JLabel roadFive[] = new JLabel[5];
   private static int xOffset = 0, yOffset = 0;
   private static int roadOneY = -254;
   private int carMovement = 0, gameScore = 0;
   private JPanel mainScreen = new JPanel();
   private int lane = 0, secondLane = 0, thirdLane = 0, rollingCount = 0;
   private boolean carOneReset = false, carTwoReset = false, 
   carThreeReset = false, gameStart = false;
   private Font myFont = new Font("Times", Font.BOLD, 24);
   
   //Get player Name
   protected String playerName;
   private JTextArea nameInput = new JTextArea(1, 8);
   
   //High SCore menu
   private JTextArea scoresField = new JTextArea(15, 100);
   private String newName = "";
   private JButton menuBtn2 = new JButton(new ImageIcon("Menu2.png"));
   
   //For game over screen
   private JLabel gameOver = new JLabel(new ImageIcon("GameOver.png"));
   private JButton menuBtn = new JButton(new ImageIcon("Menu.png"));
   private JButton highScoresBtn = new JButton(new ImageIcon("HighScores.png"));
  

   public static void main(String[] args)
   {
      new RaceGame();
   }

   public RaceGame()
   {
   //Default Constructor - Sets size, title, background color, location
   //on screen, default close operation, and sets teh frame so it can not be 
   //changed in size
      super("Krash Kourse Pro");
      setSize(WIDTH, HEIGHT);
      setBackground(Color.LIGHT_GRAY);
      setLayout(null);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //add items to the game
      initComp();
      
      //Show the main menu screen
      showMenu();
      
      //centers window on screen
      setLocationRelativeTo(null);
      setVisible(true);
   
   }
   
   /**
    * Hides main game screen
    */
   public void hideGame()
   {
      //Method hides any game pieces so a different menu can be shown
      mainScreen.setVisible(false);
      movementPanel.setVisible(false);
      car.setVisible(false);
      scoreLbl.setVisible(true);
   
      for(int i = 0; i<roadOne.length; i++)
      {
         roadOne[i].setVisible(false);
         roadTwo[i].setVisible(false);
         roadThree[i].setVisible(false);
         roadFour[i].setVisible(false);
         roadFive[i].setVisible(false);
      }
   }
   
   /**
    * Shows main Game screen
    */
   public void showGame()
   {
   //Method shows all game pieces so the game can be played
      mainScreen.setVisible(true);
      movementPanel.setVisible(true);
      car.setVisible(true);
      scoreLbl.setVisible(true);
      scoresField.setVisible(false);
      menuBtn.setVisible(false);
      menuBtn2.setVisible(false);
      gameOver.setVisible(false);
      highScoresBtn.setVisible(false);
      
      oncomingOne.setVisible(true);
      oncomingTwo.setVisible(true);
      oncomingThree.setVisible(true);
   
      for(int i = 0; i<roadOne.length; i++)
      {
         roadOne[i].setVisible(true);
         roadTwo[i].setVisible(true);
         roadThree[i].setVisible(true);
         roadFour[i].setVisible(true);
         roadFive[i].setVisible(true);
      }
   
   }
   
   /**
    * Hides Main Menu
    */
   public void hideMenu()
   {
   //Method hides any menu item so a different menu can be shown
      menu.setVisible(false);
      title.setVisible(false);
      playGame.setVisible(false);
      highScores.setVisible(false);
      carOne.setVisible(false);
      carTwo.setVisible(false);
      scoreLbl.setVisible(true);
      scoresField.setVisible(false);
   }
   
   /**
    * Show main Menu
    */
   public void showMenu()
   {
   //Method shows all menu items so the main menu can be shown
      menu.setVisible(true);
      menuBtn2.setVisible(false);
      title.setVisible(true);
      playGame.setVisible(true);
      highScores.setVisible(true);
      carOne.setVisible(true);
      carTwo.setVisible(true);
      scoreLbl.setText("Player Name: ");
      scoreLbl.setVisible(true);
      nameInput.setVisible(true);
      scoresField.setVisible(false);
   }
   /**
    * Shows generated High Score Screen
    */
   public void showScores()
   {
   //Method hshows all items in the highScore menu
   // so the user can see their scores
      scoreSheet.setVisible(true);
      scoreLbl.setVisible(false);
      nameInput.setVisible(false);
      scoresField.setVisible(true);
      menuBtn2.setVisible(true);
   }
   
   /**
    * Hide High Score Screen
    */
   public void hideScores()
   {
   //Method hides any high score menu item so a different menu can be shown
      scoreSheet.setVisible(false);
      scoreLbl.setVisible(true);
      nameInput.setVisible(true);
      scoresField.setVisible(false);
      menuBtn2.setVisible(false);
   }

   /**
    * Initializes All components to the Main Frame
    */
   public void initComp()
   {
   //adds compenents to frame
   //Adds a file menu
      JMenu fileMenu = new JMenu("Game Options");
      
      scoreLbl.setVisible(true);
      scoreLbl.setText("Player Name: ");
      
      JMenuItem scores = new JMenuItem("High Scores");
      scores.addActionListener(new MenuListener());
      fileMenu.add(scores);
      
      JMenuItem mainMenu = new JMenuItem("Main Menu");
      mainMenu.addActionListener(new MenuListener());
      fileMenu.add(mainMenu);
      
      JMenuItem exit = new JMenuItem("Close Window");
      exit.addActionListener(new MenuListener());
      fileMenu.add(exit);
      
      JMenuBar bar = new JMenuBar();
      bar.add(fileMenu);
      
      add(bar);
      setJMenuBar(bar);
   
      menu.setBounds(0, 50, WIDTH, 747);
      menu.setLayout(null);
      menu.setBackground(Color.GRAY);
      addMenuOptions();
      menu.setVisible(true);
      
      add(menu);
      
      //add the main screen to the game
      mainScreen.setBounds(0, 50, WIDTH, 747);
      mainScreen.setLayout(null);
      mainScreen.setBackground(Color.LIGHT_GRAY);
      mainScreen.addMouseListener(new FindX());
      addRoad();
      chooseLaneOne();
      chooseLaneTwo();
      chooseLaneThree();
      add(mainScreen);
   
      //add the items to the high score panel
      scorePanel.add(scoreLbl);
      scorePanel.add(nameInput);
      scorePanel.setBounds(0, 0, WIDTH, 50);
      scorePanel.setBackground(Color.BLACK);
      scoreLbl.setForeground(Color.WHITE);
      scorePanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
      add(scorePanel);
      
      scoreSheet.setBounds(0, 50, WIDTH, 747);
      scoreSheet.setLayout(null);//no layout so we can use setBounds()
      scoreSheet.setBackground(Color.WHITE);
      addScoreItems();
      add(scoreSheet);
     
   }
   
   /**
    * Adds menu options to the JMenuBar
    */
   public void addMenuOptions()
   {
   //Show menu options on the main menu
      playGame.addActionListener(new Game());
      highScores.addActionListener(new HighScoreView());
      selectCar.addActionListener(new SelectCar());
      
      //Set locations on frame
      playGame.setBounds(250, 440, 200, 100);
      highScores.setBounds(130, 570, 200, 100);
      selectCar.setBounds(370, 570, 200, 100);
      title.setBounds(0, -5, WIDTH, 406);
      carOne.setBounds(5, 450, 110, 226);
      carTwo.setBounds(580, 450, 110, 226);
      
      //add items to the frame
      menu.add(highScores);
      menu.add(title);
      menu.add(carOne);
      menu.add(carTwo);
      menu.add(selectCar);
      menu.add(playGame);
   }
   
   /**
    * 
    * @author Justin
    *Opens class for user to select a different car
    */
   private class SelectCar implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
      //Creates a way so if the user clicks on the "select car"
      //btn, a new window will appear allowing them to change their car
         new CarSelect();
         showMenu();
      }
   }
   
   /**
    * Adds the components for the score Screen
    */
   public void addScoreItems()
   {
      //adds items to the high score menu
      topScore.setBounds(310,180, 100, 100);
      scoreSheet.add(topScore);
      
      scoresField.setBounds(175, 235, WIDTH - 350, 465);
      scoresField.setBackground(Color.LIGHT_GRAY);
      scoresField.setLineWrap(true);
      scoresField.setWrapStyleWord(true);
      scoresField.setFont(myFont);
      addTextToScores();
      scoresField.setEditable(false);
      scoreSheet.add(scoresField);
      
      menuBtn2.setBounds(10, 300, 150, 75);
      menuBtn2.addActionListener(
         //adds a btn to the menu so the user can go back to the main men
         //easily
            new ActionListener()
            {
               public void actionPerformed(ActionEvent e)
               {
                  hideGame();
                  timer.stop();
                  gameStart = false;
                  showMenu();
                  resetCars();
               }	
            });
   
      scoreSheet.add(menuBtn2);
      
      //adds cars for scenic beauty
      carOne2.setBounds(35, 450, 110, 226);
      carTwo2.setBounds(552, 450, 110, 226);
      
      scoreSheet.add(carOne2);
      scoreSheet.add(carTwo2);
      
   }
   
   /**
    * Gathers the appropriate data to display the users and the scores of this game
    */
   public void addTextToScores()
   {
   //adds the scores from the text file to the high score view
      readFileIntoMap scoreInfo = new readFileIntoMap();
      String temp = scoreInfo.sendData();
      scoresField.setText(temp);
      
   }
   
   /**
    * Shows a high score view and manages listeners
    * @author Justin
    *
    */
   private class HighScoreView implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
      //This is going to add another JPanel that will load in the high scores
      //The files will come in from a text file and be read in JLabels
      //becase they are going to be sorted so the greatest are first
      
      //First, hide the menu
         hideMenu();
         hideGame();
         
         addTextToScores();
         
         //Show the High Score screen
         showScores();
         timer.stop();
         
         //High Score Design
         header.setBounds(0, 0, WIDTH, 231);
         scoreSheet.setBackground(Color.GRAY);
         topScore.setForeground(Color.WHITE);
         scoreSheet.add(header);
         
         gameStart = false;
         
      }
   }
   /**
    * 
    * @author Justin
    *	Starts the main game after clicking the start button
    */
   private class Game implements ActionListener
   {
   //Class that starts a new game from any where there is a play btn
      public void actionPerformed(ActionEvent e)
      {
         //Get the player name
         playerName = nameInput.getText();
         
         
         if(!playerName.equals(""))
         {
         //Save the player name
            newName = playerName.replaceAll("\\s+","-");
            nameInput.setVisible(false);
         //Hide the menu
            hideMenu();
            showGame();
            gameStart = false;
         
         //Load car
            addCar();
         
         //Show Oncoming Traffic
            chooseLaneOne();
            chooseLaneTwo();
            chooseLaneThree();
         
         //Show car in starting position
            carMovement = 0;
         
         //Start the timer
            timer.start();
         
         //resets Score
            gameScore = 0;
         }
         
         else
         {
         //If there is no user name entered
            scoreLbl.setText("Please enter player Name!");
         }
      }
   }
   
   /**
    * Adds a car to the view at the bottom of the screen, in which the user can control
    */
   public void addCar()
   {
   //adds user's car to the game
      Scanner inputStream = null;
      try
      {
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
      
      
      if(carChoice == null)
      {
         carChoice = "CarOne.png";
      }
      
      //Set icon of jlabel to be the users car
      ImageIcon carIcon = new ImageIcon(carChoice);
      car.setIcon(carIcon);
      car.setBounds(300, 450, 110, 226);
   }
   
   /**
    * Selects the traffic car that will be displayed in a traffic lane
    */
   public void chooseLaneOne()
   {
         
      if(gameStart == true)
      {
         Random rand = new Random(); 
         lane = rand.nextInt(5) + 1;
         int trafficOne = rand.nextInt(5) + 1;
         String choiceOne = null;
      
      
         if(carOneReset == false){
         //for Car one
         //Choose what car is heading your way
          choiceOne = carArray[trafficOne];	//Chooses a random Car from the oncoming traffic array
            ImageIcon oncomingTrafficOne = new ImageIcon(choiceOne);
            oncomingOne.setIcon(oncomingTrafficOne);
         
            switch(lane)
            {
            //Choose what lane oncoming car 1 will be in
               case 1:
                  oncomingOne.setBounds(20, roadOne[0].getY(), 110, 164);
                  break;
            
               case 2:
                  oncomingOne.setBounds(160, roadOne[0].getY(), 110, 164);
                  break;
            
               case 3:
                  oncomingOne.setBounds(300, roadOne[0].getY(), 110, 164);
                  break;
            
               case 4:
                  oncomingOne.setBounds(440, roadOne[0].getY(), 110, 164);
                  break;
            
               case 5:
                  oncomingOne.setBounds(580, roadOne[0].getY(), 110, 164);
                  break;
            
               default:
                  break;                
            }
            carOneReset = true;
         }
      }
   }
   /**
    * Chooses whre the second traffic car will be located
    */
   public void chooseLaneTwo()
   {
      if(gameStart == true)
      {
         if (carTwoReset == false){
         //For car 2
            Random rand = new Random();
            secondLane = rand.nextInt(5) + 1;
            int trafficTwo = rand.nextInt(5) + 1;
            String choiceTwo = null;
            
           choiceTwo = carArray[trafficTwo];
           ImageIcon oncomingTrafficTwo = new ImageIcon(choiceTwo);
           oncomingTwo.setIcon(oncomingTrafficTwo);
         
         //for Car 2
            switch(secondLane)
            {
            //what lane is that car in
               case 1:
                  oncomingTwo.setBounds(20, roadTwo[0].getY(), 110, 226);
                  break;
            
               case 2:
                  oncomingTwo.setBounds(160, roadTwo[0].getY(), 110, 226);
                  break;
            
               case 3:
                  oncomingTwo.setBounds(300, roadTwo[0].getY(), 110, 226);
                  break;
            
               case 4:
                  oncomingTwo.setBounds(440, roadTwo[0].getY(), 110, 226);
                  break;
            
               case 5:
                  oncomingTwo.setBounds(580, roadTwo[0].getY(), 110, 226);
                  break;
            
               default:
                  break;                
            }
            carTwoReset = true;
         }
      }
   }
   /**
    * Chooses where the third car will be located
    */
   public void chooseLaneThree()
   {
      if(gameStart == true)
      {
         if (carThreeReset == false){
         //For car 3
            Random rand = new Random();
            thirdLane = rand.nextInt(5) + 1;
            int trafficThree = rand.nextInt(5) + 1;
            String choiceThree = null;
            
            choiceThree = carArray[trafficThree];
            ImageIcon oncomingTrafficThree = new ImageIcon(choiceThree);
            oncomingThree.setIcon(oncomingTrafficThree);
         
         //for Car 3
            switch(thirdLane)
            {
            //What lane is it in
               case 1:
                  oncomingThree.setBounds(20, roadThree[0].getY(), 110, 226);
                  break;
            
               case 2:
                  oncomingThree.setBounds(160, roadThree[0].getY(), 110, 226);
                  break;
            
               case 3:
                  oncomingThree.setBounds(300, roadThree[0].getY(), 110, 226);
                  break;
            
               case 4:
                  oncomingThree.setBounds(440, roadThree[0].getY(), 110, 226);
                  break;
            
               case 5:
                  oncomingThree.setBounds(580, roadThree[0].getY(), 110, 226);
                  break;
            
               default:
                  break;                
            }
            carThreeReset = true;
         }
      }
   }

   /**
    * Displays a screen informaing the user that the game is over (Happens after a collision)
    */
   public void gameOverScreen()
   {
   //If the user hits an oncoming car
   //Show game over screen
      gameOver.setBounds(0, 0, WIDTH, 231);
      menuBtn.setBounds(150, 300, 200, 100);
      highScoresBtn.setBounds(360, 300, 200, 100);
      
      //Show a btn that takes them back to the menu
      menuBtn.addActionListener(
            new ActionListener()
            {
               public void actionPerformed(ActionEvent e)
               {
                  hideGame();
                  timer.stop();
                  gameStart = false;
                  showMenu();
                  resetCars();
               }	
            });
   	
      //Show a btn that takes them to the high score screen
      highScoresBtn.addActionListener(new HighScoreView());
   
      gameOver.setVisible(false);
      menuBtn.setVisible(false);
      highScoresBtn.setVisible(false);
   
      mainScreen.add(gameOver);
      mainScreen.add(menuBtn);
      mainScreen.add(highScoresBtn);
   }
   
   /**
    * Adds the road to the background
    */
   public void addRoad()
   {
   //Add road to game
      mainScreen.add(car);
      mainScreen.add(oncomingOne);
      mainScreen.add(oncomingTwo);
      mainScreen.add(oncomingThree);
      
      //Add the game over menu. The default will be hidden, but
      //will be show when gameOver() is called
      gameOverScreen();
      
      
   //Create an array of JLabels that will each show one piece of the road
   //Then, these JLabels will move down the screen to simulate the car
   //moving on the road
      
      for (int i = 0; i < roadOne.length; i++)
      {
      //Add an image to the road label
         roadOne[i] = new JLabel(new ImageIcon("road.png"));
         roadOne[i].setBounds(0 + xOffset, roadOneY, 140, 249); 
         mainScreen.add(roadOne[i]);
         xOffset += 140;
         if (xOffset >= WIDTH)
         {
            xOffset = 0;
            yOffset += 249;
         }
      }
      
      for (int i = 0; i < roadTwo.length; i++)
      {
      //Add an image to the road label
         roadTwo[i] = new JLabel(new ImageIcon("road.png"));
         roadTwo[i].setBounds(0 + xOffset, roadOne[i].getY() + yOffset, 140, 249); 
         mainScreen.add(roadTwo[i]);
         xOffset += 140;
         if (xOffset >= WIDTH)
         {
            xOffset = 0;
         }
      }
      
      for (int i = 0; i < roadThree.length; i++)
      {
      //Add an image to the road label
         roadThree[i] = new JLabel(new ImageIcon("road.png"));
         roadThree[i].setBounds(0 + xOffset, roadTwo[i].getY() + yOffset, 140, 249); 
         mainScreen.add(roadThree[i]);
         xOffset += 140;
         if (xOffset >= WIDTH)
         {
            xOffset = 0;
         }
      }
      
      for (int i = 0; i < roadFour.length; i++)
      {
      //Add an image to the road label
         roadFour[i] = new JLabel(new ImageIcon("road.png"));
         roadFour[i].setBounds(0 + xOffset, roadThree[i].getY() + yOffset, 140, 249); 
         mainScreen.add(roadFour[i]);
         xOffset += 140;
         if (xOffset >= WIDTH)
         {
            xOffset = 0;
            yOffset += 249;
         }
      }
      
      for (int i = 0; i < roadFive.length; i++)
      {
      //Add an image to the road label
         roadFive[i] = new JLabel(new ImageIcon("road.png"));
         roadFive[i].setBounds(0 + xOffset, roadFour[i].getY() + yOffset, 140, 249); 
         mainScreen.add(roadFive[i]);
         xOffset += 140;
         if (xOffset >= WIDTH)
         {
            xOffset = 0;
         }
      }
      
   
   }
   
   /**
    * Gets the x location of where the user clicked the mouse on the screen so the car can move in that location
    * @author Justin
    *
    */
   public class FindX implements MouseListener
   {
      //Adds a mouse listener so the user can click anywhere
      //on the frame and the game will adjust the location 
      //of the car based on what side of the car hte user clicked
      public void mousePressed(MouseEvent e) 
      {
         
         int mouseX = e.getX();
         
         if(mouseX > car.getX())
         {
            carMovement += 140;
         }
         else if (mouseX < car.getX())
         {
            carMovement -= 140;
         }
      }
      
      //To make the compiler happy
      public void mouseExited(MouseEvent e){}
      public void mouseEntered(MouseEvent e){}
      public void mouseReleased(MouseEvent e){}
      public void mouseClicked(MouseEvent e){}
      public void mouseMoved(MouseEvent e){}
   
   }
   /**
    * Ends the current game
    */
   public void endGame()
   {
      timer.stop();
      //Save score to file
      new SaveScore(newName, gameScore);
      
      //Sets a counter to allow the game to reset after 
      //each game the user played
      rollingCount = 0;
      movement = 1;
      
      //Hide all cars
      oncomingOne.setVisible(false);
      oncomingTwo.setVisible(false);
      oncomingThree.setVisible(false);
      
      //Show final score in center of the screen with a bigger font and
      //layout similar to the High Score screen
      gameOver.setVisible(true);
      //Show the main menu btn that will allow the user to return to the main
      //menu
     
      menuBtn.setVisible(true);
      
      //add high score btn so the user can view high scores
      highScoresBtn.setVisible(true);

	   DecimalFormat df = new DecimalFormat("###,###,##0");
      scoreLbl.setText("Final Score: " + df.format(gameScore));
   }
   
   /**
    * 
    * @author Justin
    *	Manages all moving components and items that should be updated every time something happens
    */
   public class TimerListener implements ActionListener
   {
   //for every 30 ms, move the road, determine if the user hit another car, 
   //and check to see if the car is still in view
   // Handle ActionEvent
      public void actionPerformed(ActionEvent e)
      {
      //Add to score 
         gameScore += 1;
         
         //If the car hits oncoming traffic
         if((oncomingOne.getX() == car.getX()) && (gameStart == true) && (rollingCount >= 15))
         {
            if((oncomingOne.getY() >= car.getY()-180) && (oncomingOne.getY() <= car.getY()))
            {
               endGame();
            }
         }
         if((oncomingTwo.getX() == car.getX()) && (gameStart == true) && (rollingCount >= 15))
         {
            if((oncomingTwo.getY() >= car.getY()-180) && (oncomingTwo.getY() <= car.getY()))
            {
               endGame();
            }
         }
         if((oncomingThree.getX() == car.getX()) && (gameStart == true) && (rollingCount >= 15))
         {
            if((oncomingThree.getY() >= car.getY()-180) && (oncomingThree.getY() <= car.getY()))
            {
               endGame();
            }
         }
         
      //Update score label

   	   DecimalFormat df = new DecimalFormat("###,###,##0");
         scoreLbl.setText("Score: \n" + df.format(gameScore));
      
      //Update road locations on screen based on the movement of the
      //road. 
         for(int i = 0; i < roadOne.length; i++)
         {
            int x = roadOne[i].getX();
            int y = roadOne[i].getY();
         
            roadOne[i].setBounds(x, y + movement, 140, 249);
         
            if(roadOne[i].getY() > HEIGHT)
            {
               roadOne[i].setBounds(x, roadTwo[0].getY() - 240, 140, 249);
            }
         }
      
         for(int i = 0; i < roadTwo.length; i++)
         {
            int x = roadTwo[i].getX();
            int y = roadTwo[i].getY();
         
            roadTwo[i].setBounds(x, y + movement, 140, 249);
         
            if(roadTwo[i].getY() > HEIGHT)
            {
               roadTwo[i].setBounds(x, roadThree[0].getY() - 240, 140, 249);
            }
         }
      
         for(int i = 0; i < roadThree.length; i++)
         {
            int x = roadThree[i].getX();
            int y = roadThree[i].getY();
         
            roadThree[i].setBounds(x, y + movement, 140, 249);
         
            if(roadThree[i].getY() > HEIGHT)
            {
               roadThree[i].setBounds(x, roadFour[0].getY() - 240, 140, 249);
            }
         }
      
         for(int i = 0; i < roadFour.length; i++)
         {
            int x = roadFour[i].getX();
            int y = roadFour[i].getY();
         
            roadFour[i].setBounds(x, y + movement, 140, 249);
         
            if(roadFour[i].getY() > HEIGHT)
            {
               roadFour[i].setBounds(x, roadFive[0].getY() - 240, 140, 249);
            }
         }
      
         for(int i = 0; i < roadFive.length; i++)
         {
            int x = roadFive[i].getX();
            int y = roadFive[i].getY();
            
            roadFive[i].setBounds(x, y + movement, 140, 249);
         
            if(roadFive[i].getY() > HEIGHT)
            {
               roadFive[i].setBounds(x, roadOne[0].getY() - 240, 140, 249);
               
               rollingCount +=1;
               
               if(rollingCount == 5)
               {
               
                  chooseLaneOne();
                  chooseLaneTwo();
                  chooseLaneThree();
                  
                  oncomingOne.setVisible(true);
                  oncomingTwo.setVisible(true);
                  oncomingThree.setVisible(true);
               }
               
               if(rollingCount >= 10)
               {
                  gameStart = true;
               }
               
               //Move the road faster
               if (rollingCount == 50)
               {
                  movement += 1;
               }
               
               //Move the road faster
               if (rollingCount == 100)
               {
                  movement += 1;
               }
            
            }
         }
      //Check to make sure car is in bounds 
      
         car.setBounds(300 + carMovement, 450, 110, 226);
      
         if(car.getX() < 20)
         {
            carMovement +=140;
            car.setBounds(20, 450, 110, 226);
         }
         else if(car.getX() > 580)
         {
            carMovement -= 140;
            car.setBounds(580, 450, 110, 226);
         }
      
      //Move Traffic
         oncomingOne.setBounds(oncomingOne.getX(), roadOne[0].getY() + movement, 110, 226);
      
         if(oncomingOne.getY() > HEIGHT)
         {
            chooseLaneOne();
            oncomingOne.setBounds(oncomingOne.getX(), roadOne[0].getY(), 140, 249);
            carOneReset = false;
         }
      //Move Traffic
         oncomingTwo.setBounds(oncomingTwo.getX(), roadTwo[0].getY() + movement, 110, 226);
      
         if(oncomingTwo.getY() > HEIGHT)
         {
            chooseLaneTwo();
            oncomingTwo.setBounds(oncomingTwo.getX(), roadTwo[0].getY(), 140, 249);
            carTwoReset = false;
         }
         
         oncomingThree.setBounds(oncomingThree.getX(), roadThree[0].getY() + movement, 110, 226);
      
         if(oncomingThree.getY() > HEIGHT)
         {
            chooseLaneThree();
            oncomingThree.setBounds(oncomingThree.getX(), roadThree[0].getY(), 140, 249);
            carThreeReset = false;
         }
         
         //Make sure the game did not start. If it didn't, hide
         //the oncoming traffic
         if(gameStart == false)
         {
            oncomingOne.setBounds(oncomingOne.getX(), roadOne[0].getY(), 110, 226);
            oncomingTwo.setBounds(oncomingTwo.getX(), roadTwo[0].getY(), 110, 226);
            oncomingThree.setBounds(oncomingThree.getX(), roadThree[0].getY(), 110, 226);
            oncomingOne.setIcon(null);
            oncomingTwo.setIcon(null);
            oncomingThree.setIcon(null);
         }
      
      }
   } 
   
   /**
    * New game will soon be in place. Reset the cars here
    */
   public void resetCars()
   {
      gameStart = false;
   }

   /**
    * 
    * @author Justin
    *	Create a listener for the main menu
    */
   private class MenuListener implements ActionListener
   {
   //Class to check to see what item from the menu the user clicked
      public void actionPerformed(ActionEvent e)
      {
         String option = e.getActionCommand();
         //System.out.println(option);
         
         if (option.equals("Main Menu"))
         {
            hideGame();
            timer.stop();
            gameStart = false;
            showMenu();
            
         }
         else if(option.equals("High Scores"))
         {
            HighScoreView testing = new HighScoreView();
            testing.actionPerformed(e);           
         }
         else if(option.equals("Close Window"))
         {
            System.exit(0);
         }
         
         resetCars();
         gameStart = false;
         
      }
   }
   

}