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
public class JavaMethodsforMathematicalOperations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean contin;

        do {
            System.out.print("""
                           Choose one of the ff:
                             
                             [1] Area of 2D Shapes (Circle, Rectangle, and Triangle)
                                 and the volumes of 3S objects (Sphere and Cylinder)
                             
                             [2] Triangle side C (Law of Cosines)
                             
                             [3] Geometry (Area of a Circle Segment) 
                             
                             [4] Solid Mensuration (Volume and Surface Area of a Sphere)
                             
                             [0] Exit
                         
                           Input the number of your choosing: 
                           """);

            int areasolver = in.nextInt();

            switch (areasolver) {
                case 0:
                    break;

                case 1:
                    System.out.print("""
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

                    int Choice = in.nextInt();

                    switch (Choice) {

                        case 1:
                            double circle = calculateCircleArea();
                            System.out.println("The area of the circle is: " + circle + " unit/s ^2");
                            break;

                        case 2:
                            double rectangle = calculateRectangleArea();
                            System.out.println("The area of the rectangle is: " + rectangle + " unit/s ^2");
                            break;

                        case 3:
                            double Triangle = calculateTriangleArea();
                            System.out.println("The area of the triangle is: " + Triangle + " unit/s ^2");
                            break;

                        case 4:
                            double Sphere = calculateSphereVolume();
                            System.out.println("The volume of the sphere is: " + Sphere + " unit/s ^3");
                            break;

                        case 5:
                            double Cylinder = calculateCylinderVolume();
                            System.out.println("The volume of the cylinder is: " + Cylinder + " unit/s ^3");
                            break;

                        case 6:
                            break;

                        default:
                            System.out.println("You've input an invalid number of choice.");
                    }
                    break;

                case 2:
                    System.out.println("Input the a side, b side, and the angle respectively");
                    System.out.print("a side: ");
                    double a = in.nextDouble();
                    System.out.print("b side: ");
                    double b = in.nextDouble();
                    System.out.print("Angle: ");
                    double degree = in.nextDouble();
                    double C = (degree * Math.PI) / 180;
                    double angle = Math.cos(C);
                    double c = calculateTriangleSide(a, b, angle);
                    System.out.println("The side c is: " + c);
                    break;

                case 3:
                    System.out.print("Input the radius and angle to get the circle segment (sector)"
                            + "\nThe formula for getting the circle segment is: A = ((r^2)(theta - sin(theta)))/2"
                            + "\nRadius: ");
                    double r = in.nextDouble();
                    System.out.print("Theta: ");
                    double A = in.nextDouble();
                    double sine = Math.sin(A);
                    double sector = calculateCircleSegmentArea(r, A, sine);
                    System.out.println("The circle segmet is: " + sector);
                    break;

                case 4:
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
                        case 0:
                            break;

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
                            System.out.println("You've input an invalid number of choice.");
                    }
                    break;

                default:
                    System.out.println("You've input an invalid number of choice.");
                    break;
            }

            System.out.println("\nDo you want to solve another problem?"
                    + "\nInput \"yes\" if YES and input \"no\" if NO.");
            String choice = in.next();

            if (choice.equals("yes")) {
                contin = true;
            } else {
                contin = false;
            }
        } while (contin);

        System.out.println("Thank you for using this program!");

    }

    static double calculateCircleArea() {
        Scanner in = new Scanner(System.in);

        System.out.print("The formula of the area of circle is: pi x r^2"
                + "\nInput the number of radius of the circle you want to know the area of: ");
        double radius = in.nextDouble();
        double area = (radius * radius) * Math.PI;
        return area;
    }

    static double calculateRectangleArea() {
        Scanner in = new Scanner(System.in);

        System.out.print("The formula of the area of rectangle is: Length x Width"
                + "\nInput the length you want: ");
        double length = in.nextDouble();
        System.out.print("Input the Width: ");
        double width = in.nextDouble();
        double area = length * width;
        return area;
    }

    static double calculateTriangleArea() {
        Scanner in = new Scanner(System.in);

        System.out.print("The formula of the area of Triangle is: 1/2 x base x height"
                + "\nInput the base: ");
        double base = in.nextDouble();
        System.out.print("Input the height: ");
        double height = in.nextDouble();
        double area = 0.5 * base * height;
        return area;
    }

    static double calculateSphereVolume() {
        Scanner in = new Scanner(System.in);

        System.out.print("The formula for getting the Volume of sphere is: 4/3 x pi x r^3"
                + "\nInput the radius: ");
        double radiuss = in.nextDouble();
        double Volume = ((4 * Math.PI * (radiuss * radiuss * radiuss)) / 3);
        return Volume;
    }

    static double calculateCylinderVolume() {
        Scanner in = new Scanner(System.in);
        System.out.print("The formula for getting the Volume of cylinder is: pi x r^2 x height"
                + "\nInput the radius: ");
        double radii = in.nextDouble();
        System.out.print("Input the height: ");
        double heightt = in.nextDouble();
        double Volume = Math.PI * (radii * radii) * heightt;

        return Volume;
    }

    static double calculateTriangleSide(double a, double b, double C) {

        double cosine = (a * a) + (b * b) - ((2 * a * b) * C);
        double angle = Math.sqrt(cosine);
        return angle;
    }

    static double calculateCircleSegmentArea(double radius, double theta, double angle) {
        double segment = ((radius * radius) * (theta - angle)) / 2;

        return segment;
    }

    static double calculateSphereVolume(double radius) {
        double V;
        V = (4 * Math.PI * Math.pow(radius, 3)) / 3;
        return V;
    }

    static double calculateSphereSurfaceArea(double radius) {
        double sa;
        sa = 4 * Math.PI * Math.pow(radius, 2);
        return sa;
    }

}//end bracket
