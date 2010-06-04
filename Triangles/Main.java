/*
 * SSW 567 Assignment 1 - Triangle Program
 * Project Team/Authors:  Lisa Jankovich, Julie Baumler Heiner
 */

//package sw_test567_assignment1;

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
		
		try {

			if ( valid_triangle( side_x, side_y, side_z ))
			{
				System.out.println("valid\n");
			}
		
    	String strTriOut = "";
    	String equil = "";
    	String isos = "";
    	String scal = "";

    	//Triangle Determination

    	//Right Triangle
    	if (((side_x * side_x) + (side_y * side_y)) == (side_z * side_z))
    	{
				System.out.println("right triangle");
        strTriOut = "right triangle and ";
			}
    
    	if (((side_x * side_x) + (side_z * side_z)) == (side_y * side_y))
    	{   
				System.out.println("right triangle");
        strTriOut = "right triangle and ";
			}
        
    	if (((side_z * side_z) + (side_y * side_y)) == (side_x * side_x))
    	{
				System.out.println("right triangle");
        strTriOut = "right triangle and ";
			}
        
    	//equilateral triangle
    	if ((side_x == side_y) && (side_x == side_z) && (side_y == side_z))
    	{
				System.out.println("equilateral triangle");
    		equil += "equilateral triangle "; 
			}

    	//isosceles triangle
    	if (((side_x == side_y) || (side_y == side_z) || (side_x == side_z)) && !((side_x == side_y) && (side_x == side_z) && (side_y == side_z)))
    	{
				System.out.println("isosceles triangle");
    		isos += "isosceles triangle "; 
			}

    	//scalene triangle
    	else if (!((side_x == side_y) && (side_x == side_z) && (side_y == side_z)))
    	{
				System.out.println("scalene triangle");
    		scal += "scalene triangle "; 
			}

			// Dialog Box Output for Showing Triangle Type
 			JOptionPane.showMessageDialog(null,
      	"The triangle type is: " + strTriOut + equil + isos + scal,
      	"Assignment 1 Output", JOptionPane.INFORMATION_MESSAGE);
    	System.exit(0);
		}
		catch ( TriangleException triex )
  	{
			JOptionPane.showMessageDialog( null, 
				triex.getMessage(), "Error:", JOptionPane.INFORMATION_MESSAGE);
    	System.exit(1);
		}
	}

  protected static boolean valid_triangle( double a, double b, double c ) throws TriangleException {
		if ( a > 0  && b > 0 && c > 0 )
		{
			return true;
		}
		else
		{
			throw new TriangleException("All sides must have a length larger than zero.");
		}
	}

}

// NOTES: wiki link for test data on right triangles: http://en.wikipedia.org/wiki/Pythagorean_theorem

class TriangleException extends Exception
{
  String problem;

	//----------------------------------------------
	// Default constructor - initializes instance variable to unknown
  public TriangleException()
  {
    super();             // call superclass constructor
    problem = "unknown";
  }

	//-----------------------------------------------
	// Constructor receives some kind of message that is saved in an instance variable.

  public TriangleException(String err)
  {
    super(err);     // call super class constructor
    problem = err;  // save message
  }
  
	//------------------------------------------------  
	// public method, callable by exception catcher. It returns the error message.

  public String getMessage()
  {
    return problem;
  }
}
