/*
 * Name: Rojyx L. Yangyang
 * Course: Computer Engineering Section - 1 
 * Lab Activity: Array Implementation and For Loop Practice - Problem 4
 * Submission Date: December 08, 2024
 *
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg1st.semester;

import java.util.Scanner;

/**
 *
 * @author YANGYANG_COMP111
 */
public class Yangyang_Rojyx_LabArrayActivity_Problem4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome to frequency checker!!");
        int freq = frequency(10);
        System.out.println("It's frequency is: " + freq);
        
        
    }
    static int frequency(int a){
    Scanner in = new Scanner(System.in);
        System.out.print("Input array Index: ");
        int num[] = new int[a];
        for (int i = 0; i < a; i++) {
            System.out.println("Enter array index: " + i);
            num[i] = in.nextInt(); 
        }
         StringBuilder haha=new StringBuilder("The Array: ");
        for (int g:num) {
            haha.append(g).append("| ");//to append so that every number inside the array has a "|" when printed and to allow the user know they are a seperate element
        }
        System.out.println(haha);
        System.out.print("Choose the number that you want check for it's frequency: ");
        int freq = in.nextInt();
        int inte = 0;
        for (int y:num) {
            if (y==freq) {
                inte++;
            }//where the number chosen by the get checked ob how frequent it is
        } 
        
   return inte; 
    }
}

/*
Enter 10 integers between 1 and 100:
10 20 10 30 40 50 10 60 70 80
Enter the number to check its frequency:
10

It's Frequency is: 3

*/
