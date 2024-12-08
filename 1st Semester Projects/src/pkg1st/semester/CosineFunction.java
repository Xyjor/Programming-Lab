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
public class CosineFunction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner in = new Scanner (System.in);
        System.out.println("Input the a side, b side, and the angle respectively");
        System.out.print("a side: ");
    double a = in.nextDouble();
        System.out.print("b side: ");
    double b = in.nextDouble();
        System.out.print("C angle: ");
    double degree = in.nextDouble();
    double C = (degree * Math.PI)/180;
    double angle = Math.cos(C);
    double c = calculateTriangleSide(a, b, angle);
        System.out.println("The side c is: " + c);
        
    
    }
    static double calculateTriangleSide(double a, double b, double C){
    
       double cosine = (a * a) + (b * b) - ((2*a*b)*C);
       double angle  = Math.sqrt(cosine);
    return angle;
    }
    

}// end
