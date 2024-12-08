/*
 * Name: Rojyx L. Yangyang
 * Course: Computer Engineering Section - 1 
 * Lab Activity: Array Implementation and For Loop Practice - Problem 3
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
public class Yangyang_Rojyx_LabArrayActivity_Problem3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("\"The length of the array is 5\"");
        String reverse = reversearray(5);
        System.out.println("The array in reverse order is: " + reverse);
    }

    static String reversearray(int a) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input array Index: ");
        float[] num = new float[a];
        for (int i = 0; i < a; i++) {
            System.out.println("Enter array index: " + i);
            num[i] = in.nextFloat();//Where you input the index/s inside the array.

        }
        String rev = num[4] + " " + num[3] + " " + num[2] + " " + num[1] + " " + num[0];//Where the reversing happens.
        return rev;
    }
}

/*
Enter 5 floating-point numbers:
3.5| 2.7| 9.1| 4.6| 5.2|

Array in reverse order:
5.2 4.6 9.1 2.7 3.5
*/
