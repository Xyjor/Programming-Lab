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
public class CircleSegment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner in = new Scanner (System.in);
        System.out.print("Input the radius and angle to get the circle segment (sector)"
                + "\nThe formula for getting the circle segment is: A = ((r^2)(theta - sin(theta)))/2"
                + "\nRadius: ");
        double r = in.nextDouble();
        System.out.print("Theta: ");
        double a = in.nextDouble();
        double sine = Math.sin(a);
        
        
        double sector = calculateCircleSegmentArea(r, a,sine);
        System.out.println("The circle segmet is: " + sector);
    }
    static double calculateCircleSegmentArea(double radius, double theta, double angle){
         double segment = ((radius * radius) * (theta - angle))/2;
    
        return segment;
    }
}
