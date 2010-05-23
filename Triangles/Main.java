/*
 * SSW 567 Assignment 1 - Triangle Program
 * Project Team/Authors:  Lisa Jankovich, Julie Baumler Heiner
 */

package sw_test567_assignment1;

// Assignment 1 - Triangle Program
import javax.swing.JOptionPane;

public class Main {
  /**Main method*/
  public static void main(String[] args) {



    // Enter the first side of the triangle
    String numberString = JOptionPane.showInputDialog(null,
      "Enter the first length of the triangle ",
      "Assignment 1 Input", JOptionPane.QUESTION_MESSAGE);
    // Convert string to double
    double side_x = Double.parseDouble(numberString);


    // Enter the second side of the triangle
    numberString = JOptionPane.showInputDialog(null,
      "Enter the second length of the triangle ",
      "Assignment 1 Input", JOptionPane.QUESTION_MESSAGE);
    // Convert string to double
    double side_y = Double.parseDouble(numberString);


    // Enter the third side of the triangle
    numberString = JOptionPane.showInputDialog(null,
      "Enter the third length of the triangle ",
      "Assignment 1 Input", JOptionPane.QUESTION_MESSAGE);
    // Convert string to double
    double side_z = Double.parseDouble(numberString);

    //Triangle Determination

    //Right Triangle
    if (((side_x * side_x) + (side_y * side_y)) == (side_z * side_z))
    System.out.println("right triangle");
    if (((side_x * side_x) + (side_z * side_z)) == (side_y * side_y))
    System.out.println("right triangle");
    if (((side_z * side_z) + (side_y * side_y)) == (side_x * side_x))
    System.out.println("right triangle");


    //equilateral triangle
    if ((side_x == side_y) && (side_x == side_z) && (side_y == side_z))
    System.out.println("equilateral triangle");

    //isosceles triangle
    if (((side_x == side_y) || (side_y == side_z) || (side_x == side_z)) && !((side_x == side_y) && (side_x == side_z) && (side_y == side_z)))
    System.out.println("isosceles triangle");

    //scalene triangle
    else if (!((side_x == side_y) && (side_x == side_z) && (side_y == side_z)))
    System.out.println("scalene triangle");

    //Display the resultant triangle outputs
//  "Assignment 1 Input" = JOptionPane.showoutputDialog(null,
//      "The triangle is ",
//      "Main Input", JOptionPane.QUESTION_MESSAGE);
   

    System.exit(0);
  }
}

