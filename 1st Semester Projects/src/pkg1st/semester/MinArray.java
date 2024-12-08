/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg1st.semester;

import java.util.Scanner;

/**
 *
 * @author YANGYANG_COMP111
 */
public class MinArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        int min = findMax(6) ;
        System.out.println("\nThe maximum number is: " + min);
        
    }
    
static int findMax(int a){
    Scanner in = new Scanner (System.in);
    int roj[] = new int[a];
    
    for (int i = 0; i < a; i++) {
        
        System.out.print("Enter value index:" + i + "\nInput number: ");
        roj[i] = in.nextInt();  
    }
    
  
    int min = roj[0];

    for (int minimum : roj) {
        if (min > minimum ) {
            min = minimum;
        }
      }
  
    return min;

    }
 }
