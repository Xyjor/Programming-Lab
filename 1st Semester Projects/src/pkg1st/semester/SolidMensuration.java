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
public class SolidMensuration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        double radius, volume, surfacearea;
        System.out.print("""
                           What do you want to calculate?
                           -Sphere Volume-          [1]
                           -Sphere Surface Area-    [2]
                           -Exit-                   [0]
                           Input the number of your choosing: 
                           """);
        int VorSa = in.nextInt();
        
        switch (VorSa) {
            case 1:
                System.out.print("Input the radius of the sphere you want (it should be non-integer): ");
                radius = in.nextInt();
                volume = calculateSphereVolume(radius);
                System.out.println("The Volume of the sphere is: " + volume);
                
                break;
                
            case 2:
                System.out.print("Input the radius of the Sphere you want (it should be non-integer): ");
                radius = in.nextInt();
                surfacearea = calculateSphereSurfaceArea(radius);
                System.out.println("The Surface area of the Sphere is: " + surfacearea);
                
                break;
               
            default:
                System.out.println("Thank you for choosing this program!");
        }
        
        
        
    }
    static double calculateSphereVolume (double radius){
    double V;
    V = (4 * Math.PI * Math.pow(radius, 3))/3;
    return V;}
    
    static double calculateSphereSurfaceArea (double radius){
    double sa;
    sa = 4 * Math.PI * Math.pow(radius, 2);
        return sa;}
}//end
