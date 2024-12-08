/*
 * Name: Rojyx L. Yangyang
 * Course: Computer Engineering Section - 1 
 * Lab Activity: Array Implementation and For Loop Practice - Problem 2
 * Submission Date: December 08, 2024
 *
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg1st.semester;

import java.util.Scanner;
import static pkg1st.semester.MinArray.findMax;

/**
 *
 * @author YANGYANG_COMP111
 */
public class Yangyang_Rojyx_LabArrayActivity_Problem2 {

    /**
     * @param args the command line arguments
     */
    public static void main (String[] args){
        int Finder = findMax_Min(15);   
    }
    
    static int findMax_Min(int a){
    Scanner in = new Scanner (System.in);
    int roj[] = new int[a];
    
    for (int i = 0; i < a; i++) {
        
        System.out.print("Enter array index:" + i + "\nInput number: ");
        roj[i] = in.nextInt();  
    }
    
  int max = roj[0], min = roj[0];
    for (int array : roj) {
        if (max < array) {
            max = array;
        }
        if (min > array) {
            min = array;
        }
      }
        System.out.println("\n\nThe maximum is: " + max);
        System.out.println("The minimum is: " + min);
    return max;

    }
     
 }

/*
Sample Input:
1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15

Sample Output:
Maximum element: 95
Minimum element: 7
*/
