package edu.miracosta.cs113.hw1;

import java.util.Random;
import java.util.Scanner;

public class Clue {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Enter which assistant you want to use: ");
        int theory = keyboard.nextInt();
        
        switch(theory)
        {
            case 1:
                theoryChecker1();
                break;
            case 2:
                theoryChecker2();
                break;
            case 3:
                theoryChecker3();
                break;
            default:
                System.out.println("Invalid selection!");
                break;
        }
        keyboard.close();
    }
    
    /**
     * This method randomly finds the correct murder, location and weapon used.
     */    
    public static void theoryChecker1()
    {
        Random random = new Random();
        int solution = Theory.theoryTest1(random.nextInt(6)+1, random.nextInt(10)+1, random.nextInt(6)+1);
        int totalChecks = 0;
        
        while(solution != 0)
        {
            solution = Theory.theoryTest1(random.nextInt(6)+1, random.nextInt(10)+1, random.nextInt(6)+1);
            totalChecks++;
        }
        Theory.checkTheory();
        System.out.println("Total Checks = " + totalChecks);
    }
    
    /**
     * This method randomly finds the correct murder, location and weapon used.
     */        
    public static void theoryChecker2()
    {
        Random random = new Random();
        int solution = Theory.theoryTest2(random.nextInt(6)+1, random.nextInt(10)+1, random.nextInt(6)+1);
        int totalChecks = 0;
        
        while(solution != 0)
        {
            solution = Theory.theoryTest2(random.nextInt(6)+1, random.nextInt(10)+1, random.nextInt(6)+1);
            totalChecks++;
        }
        Theory.checkTheory();
        System.out.println("Total Checks = " + totalChecks);
    }
    
    /**
     * This method randomly finds the correct murder, location and weapon used.
     */        
    public static void theoryChecker3()
    {
        Random random = new Random();
        int solution = Theory.theoryTest3(random.nextInt(6)+1, random.nextInt(10)+1, random.nextInt(6)+1);
        int totalChecks = 0;
        
        while(solution != 0)
        {
            solution = Theory.theoryTest3(random.nextInt(6)+1, random.nextInt(10)+1, random.nextInt(6)+1);
            totalChecks++;
        }
        Theory.checkTheory();
        System.out.println("Total Checks = " + totalChecks);
    }

}