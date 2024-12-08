/*
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
public class Exponent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
         
        System.out.print("Enter the base number: ");
        int base     = in.nextInt();
        
        System.out.print("Enter the exponent number: ");
        int exponent = in.nextInt();
        
        
        long result   = 1;
  
        for (int i = 0; i < exponent; i++) {
            
            
            result *= base;
        }
        
        System.out.printf("%d raised to %d = %d: ",base,exponent, result);
    
        
            
        }
    
    
    }
