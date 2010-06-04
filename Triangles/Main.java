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

		// assign the sides to a sorted array
		// this means sides[0] is the shortest side
		// and sides[2] is the longest side
		double[] sides = new double[]{ side_x, side_y, side_z};
		java.util.Arrays.sort(sides );
		
		try {

			check_valid_triangle( sides );
		
    	String strTriOut = "";
    	String equil = "";
    	String isos = "";
    	String scal = "";

    	//Triangle Determination

    	//Right Triangle
    	if ( ( Math.pow(sides[0], 2) + Math.pow(sides[1], 2)) == Math.pow(sides[3], 2) )
    	{
				System.out.println("right triangle");
        strTriOut = "right triangle and ";
			}
    
    	//equilateral triangle
    	if ( sides[0] == sides[2] )
    	{
				System.out.println("equilateral triangle");
    		equil += "equilateral triangle "; 
			}
    	//isosceles triangle
    	else if ( sides[0] == sides[1] )
    	{
				System.out.println("isosceles triangle");
    		isos += "isosceles triangle "; 
			}
    	//scalene triangle
    	else 
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

  protected static void check_valid_triangle( double triangle[] ) throws TriangleException {
		if ( triangle[0] <= 0 )
		{
			throw new TriangleException("Triangles cannot be formed with sides of length less than zero.");
		}
		else if ( (triangle[0] + triangle[1] ) < triangle[2] )
		{
			throw new TriangleException("These sides do not form a triangle.");
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
