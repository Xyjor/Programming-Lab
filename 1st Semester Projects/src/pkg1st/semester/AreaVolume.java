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
public class AreaVolume {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Scanner in = new Scanner (System.in);
     boolean contin;
     
       do { System.out.print("""
                           What do you want to solve?
                           2D:
                           Circle    Area   [1]
                           Rectangle Area   [2]
                           Triangle  Area   [3]
                           ----------------------------------------------
                           3D:
                           Sphere    Volume [4]
                           Cylinder  Volume [5]
                           ----------------------------------------------
                           Exit             [6]
                           
                         
                           Input the number of your choosing: 
                           """);
        
        
        int areasolver = in.nextInt();
        
        switch (areasolver) {
            case 1:
                    double circle = Circle();
                    System.out.println("The area of the circle is: " + circle + " unit/s ^2");
                break;
                
            case 2:
                    double rectangle = Rectangle();
                    System.out.println("The area of the rectangle is: " + rectangle + " unit/s ^2");
                break;
                
            case 3:
                double Triangle = Triangle();
                System.out.println("The area of the triangle is: " + Triangle + " unit/s ^2");
                break;    
                
            case 4: 
                double Sphere = Sphere();
                System.out.println("The volume of the sphere is: " + Sphere + " unit/s ^3");
                
            case 5:
                double Cylinder = Cylinder();
                System.out.println("The volume of the cylinder is: " + Cylinder + " unit/s ^3");
                
            case 6:
                break;
                
            default: System.out.println("You've input an invalid number of choice.");
                
        } 
        
           System.out.println("\nDo you want to solve another problem?"
                   + "\nInput \"yes\" if YES and input \"no\" if NO.");
           String choice = in.next();
           
           if (choice.equals("yes")) {
               contin = true;
           }else{
               contin = false;
           }
    }while(contin);
       
        System.out.println("Thank you for using this program!");
    
    
    
    
    }
    static double Circle    (){
        Scanner in = new Scanner (System.in);
        
        System.out.print("The formula of the area of circle is: pi x r^2"
                            + "\nInput the number of radius of the circle you want to know the area of: ");
                    double radius = in.nextDouble();
                    double area = (radius*radius)*Math.PI;
    return area;}

    static double Rectangle (){
        Scanner in = new Scanner (System.in);
        
        System.out.print("The formula of the area of rectangle is: Length x Width"
                            + "\nInput the length you want: ");
                    double length = in.nextDouble();
                    System.out.print("Input the Width: ");
                    double width  = in.nextDouble();
                    double area   = length * width;
    return area;}
    
    static double Triangle  (){
    Scanner in = new Scanner (System.in);
    
    System.out.print("The formula of the area of Triangle is: 1/2 x base x height"
                        + "\nInput the base: ");
                double base   = in.nextDouble();
                System.out.print("Input the height: ");
                double height = in.nextDouble();
                double area = 0.5 * base * height;
    return area;}
    
    static double Sphere    (){
    Scanner in = new Scanner (System.in);
    
    System.out.print("The formula for getting the Volume of sphere is: 4/3 x pi x r^3"
                        + "\nInput the radius: ");
                double radiuss = in.nextDouble();     
                double Volume  =  ((4 * Math.PI * (radiuss*radiuss*radiuss))/3);
    return Volume;}
    
    static double Cylinder  (){
    Scanner in = new Scanner (System.in);
    System.out.print("The formula for getting the Volume of cylinder is: pi x r^2 x height"
                        + "\nInput the radius: ");
                double radii = in.nextDouble();
                System.out.print("Input the height: ");
                double heightt = in.nextDouble();
                double Volume = Math.PI * (radii*radii) * heightt;
    
    return Volume;}


}//end bracket