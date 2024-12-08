/*
 * Name: Rojyx L. Yangyang
 * Course: Computer Engineering Section - 1 
 * Lab Activity: Array Implementation and For Loop Practice - Problem 1
 * Submission Date: December 08, 2024
 *
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template     
*/ 
package pkg1st.semester;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author YANGYANG_COMP111
 */
public class Yangyang_Rojyx_LabArrayActivity_Problem1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("");
        double sum = Sum_Average(5);// Call the method "Sum". Sum - a method where all the calculations can be located at.

    }
   static double Sum_Average (int a){
    Scanner in = new Scanner (System.in);
    double Numbers[] = new double[a];
        for (int i = 0; i < a; i++) {
            System.out.print("Enter array index " + i + "\n");
            Numbers[i] = in.nextDouble();
        }// This is where you input the numbers that is contained inside the array.
        
        double average = 0;
        double sum = 0;
        for (int i = 0; i < Numbers.length; i++) {
            
            sum += Numbers[i];
            average = sum / Numbers.length;
        }// This is where the calculations occur.
        
        System.out.println("The Sum is: " + sum);
        System.out.println("The Average is: " + average);
    return sum;// Printing the Sum and Average, then returning it.
    }
}

/* 
Sample Input:  
1, 2, 3, 4, 5

Sample Output:
Sum of array: 15
Average of array: 3
*/

