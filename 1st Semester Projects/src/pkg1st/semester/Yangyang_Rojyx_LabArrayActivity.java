/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg1st.semester;

import java.util.Scanner;

/**
 *
 * @author airaicon
 */
public class Yangyang_Rojyx_LabArrayActivity {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int Choice;
        System.out.println("""
                           Choose what you want:
                           
                           1. Sum and Average
                           2. Max and Minimum
                           3. Reverse Order of Array
                           4. Frequency Checker
                           """);
        Choice =  in.nextInt();
        switch (Choice) {
            case 1:
                double ProblemSet1 = Sum_Average(10);
                break;
            case 2:
                int max = findMax_Min(15) ;
                break;
            case 3:
                String reverse = reversearray(5);
                System.out.println("the array in reverse order is: " + reverse);
                break;
            case 4:
                System.out.println("Welcome to frequency checker!!");
                int freq = frequency(10);
                System.out.println("It's frequency is: " + freq);
                break;
            default:
                System.out.println("Input a valid number from the given choices.");
        }
    }
    
    
    static double Sum_Average (int a){
    Scanner in = new Scanner (System.in);
    double Numbers[] = new double[a];
        for (int i = 0; i < a; i++) {
            System.out.print("Enter array index " + i + "\n");
            Numbers[i] = in.nextDouble();
        }
        
        double average = 0;
        double sum = 0;
        for (int i = 0; i < Numbers.length; i++) {
            
            sum += Numbers[i];
            average = sum / Numbers.length;
        }
        
        System.out.println("The Sum is: " + sum);
        System.out.println("The Average is: " + average);
    return sum;
    }
    
    
    
    static int findMax_Min(int a){
    Scanner in = new Scanner (System.in);
    int roj[] = new int[a];
    
    for (int i = 0; i < a; i++) {
        
        System.out.print("Enter array index:" + i + "\nInput number: ");
        roj[i] = in.nextInt();  
    }
    
  int max = roj[0], min = roj[0];
    for (int array : roj) {
        if (max < array) {
            max = array;
        }
        if (min > array) {
            min = array;
        }
      }
        System.out.println("\n\nThe maximum is: " + max);
        System.out.println("The minimum is: " + min);
    return max;

    }
    

    static String reversearray(int a) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input array Index: ");
        float[] num = new float[a];
        for (int i = 0; i < a; i++) {
            System.out.println("Enter array index: " + i);
            num[i] = in.nextFloat();

        }
        String rev = num[4] + " " + num[3] + " " + num[2] + " " + num[1] + " " + num[0];
        return rev;
    }

        
    static int frequency(int a){
    Scanner in = new Scanner(System.in);
        System.out.print("Input 10 array Index between 1 - 100: ");
        int num[] = new int[a];
        for (int i = 0; i < a; i++) {
            System.out.println("Enter array index: " + i);
            num[i] = in.nextInt(); 
        }
         StringBuilder haha=new StringBuilder("The array:  ");
        for (int g:num) {
            haha.append(g).append(", ");
        }
        System.out.println(haha);
        System.out.print("\n\nChoose the number that you want check for it's frequency: ");
        int freq = in.nextInt();
        int inte = 0;
        for (int y:num) {
            if (y==freq) {
                inte++;
            }
        } 
        
   return inte; 
    }
}