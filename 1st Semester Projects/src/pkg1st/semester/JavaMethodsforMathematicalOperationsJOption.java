/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg1st.semester;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author YANGYANG_COMP111
 */
public class JavaMethodsforMathematicalOperationsJOption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean contin;

        do {
            String menu = """
                Choose one of the ff:
                
                [1] Area of 2D Shapes (Circle, Rectangle, Triangle)
                    and the volumes of 3D objects (Sphere, Cylinder)
                [2] Triangle side C (Law of Cosines)
                [3] Geometry (Area of a Circle Segment)
                [4] Solid Mensuration (Volume and Surface Area of a Sphere)
                [0] Exit
                
                Input the number of your choice:""";

            int areasolver = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (areasolver) {
                case 0 -> contin = false;

                case 1 -> {
                    String subMenu = """
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
                        
                        Input the number of your choice:""";

                    int choice = Integer.parseInt(JOptionPane.showInputDialog(subMenu));

                    switch (choice) {
                        case 1 -> {
                            double circle = calculateCircleArea();
                            JOptionPane.showMessageDialog(null, "The area of the circle is: " + circle + " unit/s^2");
                        }
                        case 2 -> {
                            double rectangle = calculateRectangleArea();
                            JOptionPane.showMessageDialog(null, "The area of the rectangle is: " + rectangle + " unit/s^2");
                        }
                        case 3 -> {
                            double triangle = calculateTriangleArea();
                            JOptionPane.showMessageDialog(null, "The area of the triangle is: " + triangle + " unit/s^2");
                        }
                        case 4 -> {
                            double sphere = calculateSphereVolume();
                            JOptionPane.showMessageDialog(null, "The volume of the sphere is: " + sphere + " unit/s^3");
                        }
                        case 5 -> {
                            double cylinder = calculateCylinderVolume();
                            JOptionPane.showMessageDialog(null, "The volume of the cylinder is: " + cylinder + " unit/s^3");
                        }
                        case 6 -> {}
                        default -> JOptionPane.showMessageDialog(null, "Invalid choice!");
                    }
                }

                case 2 -> {
                    double a = Double.parseDouble(JOptionPane.showInputDialog("Input side a:"));
                    double b = Double.parseDouble(JOptionPane.showInputDialog("Input side b:"));
                    double degree = Double.parseDouble(JOptionPane.showInputDialog("Input the angle (in degrees):"));
                    double C = (degree * Math.PI) / 180;
                    double angle = Math.cos(C);
                    double c = calculateTriangleSide(a, b, angle);
                    JOptionPane.showMessageDialog(null, "The side c is: " + c);
                }

                case 3 -> {
                    double r = Double.parseDouble(JOptionPane.showInputDialog("Input the radius of the circle:"));
                    double theta = Double.parseDouble(JOptionPane.showInputDialog("Input the angle (in radians):"));
                    double sine = Math.sin(theta);
                    double segment = calculateCircleSegmentArea(r, theta, sine);
                    JOptionPane.showMessageDialog(null, "The area of the circle segment is: " + segment);
                }

                case 4 -> {
                    String sphereMenu = """
                        What do you want to calculate?
                        - Sphere Volume          [1]
                        - Sphere Surface Area    [2]
                        - Exit                   [0]

                        Input the number of your choice:""";

                    int vorSa = Integer.parseInt(JOptionPane.showInputDialog(sphereMenu));

                    switch (vorSa) {
                        case 0 -> {}

                        case 1 -> {
                            double radius = Double.parseDouble(JOptionPane.showInputDialog("Input the radius of the sphere:"));
                            double volume = calculateSphereVolume(radius);
                            JOptionPane.showMessageDialog(null, "The volume of the sphere is: " + volume);
                        }
                        case 2 -> {
                            double radius = Double.parseDouble(JOptionPane.showInputDialog("Input the radius of the sphere:"));
                            double surfaceArea = calculateSphereSurfaceArea(radius);
                            JOptionPane.showMessageDialog(null, "The surface area of the sphere is: " + surfaceArea);
                        }
                        default -> JOptionPane.showMessageDialog(null, "Invalid choice!");
                    }
                }

                default -> JOptionPane.showMessageDialog(null, "Invalid choice!");
            }

            int response = JOptionPane.showConfirmDialog(null, "Do you want to solve another problem?", "Continue?", JOptionPane.YES_NO_OPTION);
            contin = (response == JOptionPane.YES_OPTION);

        } while (contin);

        JOptionPane.showMessageDialog(null, "Thank you for using this program!");
    }

    static double calculateCircleArea() {
        double radius = Double.parseDouble(JOptionPane.showInputDialog("Input the radius of the circle:"));
        return (radius * radius) * Math.PI;
    }

    static double calculateRectangleArea() {
        double length = Double.parseDouble(JOptionPane.showInputDialog("Input the length of the rectangle:"));
        double width = Double.parseDouble(JOptionPane.showInputDialog("Input the width of the rectangle:"));
        return length * width;
    }

    static double calculateTriangleArea() {
        double base = Double.parseDouble(JOptionPane.showInputDialog("Input the base of the triangle:"));
        double height = Double.parseDouble(JOptionPane.showInputDialog("Input the height of the triangle:"));
        return 0.5 * base * height;
    }

    static double calculateSphereVolume() {
        double radius = Double.parseDouble(JOptionPane.showInputDialog("Input the radius of the sphere:"));
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    static double calculateCylinderVolume() {
        double radius = Double.parseDouble(JOptionPane.showInputDialog("Input the radius of the cylinder:"));
        double height = Double.parseDouble(JOptionPane.showInputDialog("Input the height of the cylinder:"));
        return Math.PI * Math.pow(radius, 2) * height;
    }

    static double calculateTriangleSide(double a, double b, double angle) {
        double cosine = (a * a) + (b * b) - ((2 * a * b) * angle);
        return Math.sqrt(cosine);
    }

    static double calculateCircleSegmentArea(double radius, double theta, double angle) {
        return ((radius * radius) * (theta - angle)) / 2;
    }

    static double calculateSphereVolume(double radius) {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    static double calculateSphereSurfaceArea(double radius) {
        return 4 * Math.PI * Math.pow(radius, 2);
    }
}
