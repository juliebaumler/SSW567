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

	double side_x = 0;
	double side_y = 0;
	double side_z = 0;


    // Enter the first side of the triangle
    String numberString1 = JOptionPane.showInputDialog(null,
      "Enter the first length of the triangle ",
      "Assignment 1 Input", JOptionPane.QUESTION_MESSAGE);


    // Enter the second side of the triangle
    String numberString2 = JOptionPane.showInputDialog(null,
      "Enter the second length of the triangle ",
      "Assignment 1 Input", JOptionPane.QUESTION_MESSAGE);


    // Enter the third side of the triangle
    String numberString3 = JOptionPane.showInputDialog(null,
      "Enter the third length of the triangle ",
      "Assignment 1 Input", JOptionPane.QUESTION_MESSAGE);

 
    // Convert strings to double
		try {
    	side_x = Double.parseDouble(numberString1);
      side_y = Double.parseDouble(numberString2);
    	side_z = Double.parseDouble(numberString3);
			//System.out.println(side_x + " " + side_y + " " + side_z );
		}
		catch ( NumberFormatException ex ) {
			JOptionPane.showMessageDialog( null, 
				"Entries for all sides must be numbers, ie (1.12347, 3, 1.234e2)", 
				"Error:", JOptionPane.ERROR_MESSAGE);
    	System.exit(1);
			
		}
		catch ( NullPointerException ex ) {
			JOptionPane.showMessageDialog( null, 
				"Values for all three sides are required.", 
				"Error:", JOptionPane.ERROR_MESSAGE);
    	System.exit(1);
		}


		// assign the sides to a sorted array
		// this means sides[0] is the shortest side
		// and sides[2] is the longest side
		double[] sides = new double[]{ side_x, side_y, side_z};
		java.util.Arrays.sort(sides );
		
		try {

			check_valid_triangle( sides );
		
    	String strTriOut = "";

    	//Triangle Determination
    	//equilateral triangle
    	if ( sides[0] == sides[2] )
    	{
				//System.out.println("equilateral triangle");
    		strTriOut = " equilateral triangle "; 
			}
			else
			{

    		//Right Triangle
				// Use sqrt( A^2 + B^2) = C  because 
				// programmer tests show it
				// evens out Java rounding errors 
				// whereas A^2 + B^2 = C^2 does not
				if (Double.compare(Math.sqrt( Math.pow(sides[0], 2) + Math.pow(sides[1], 2)), sides[2]  ) == 0 )
    		{
					//System.out.println("right triangle");
						if ( Double.isInfinite( Math.pow(sides[2], 2) ) )
						{
       	 			strTriOut = "Due to size of triangle, unable to determine whether it is a right triangle. ";
						}
						else
						{
       	 			strTriOut = " right triangle and ";
						}
				} 

    		//isosceles triangle
    		if ( sides[0] == sides[1] || sides[1] == sides[2] )
    		{
					//System.out.println("isosceles triangle");
    			strTriOut += " isosceles triangle "; 
				}
    		//scalene triangle
    		else 
    		{
					//System.out.println("scalene triangle");
    			strTriOut += " scalene triangle "; 
				}
			}

			// Dialog Box Output for Showing Triangle Type
 			JOptionPane.showMessageDialog(null,
      	"The triangle type is:" + strTriOut, 
      	"Assignment 1 Output", JOptionPane.INFORMATION_MESSAGE);
    	System.exit(0);
		}
		catch ( TriangleException triex )
  	{
			JOptionPane.showMessageDialog( null, 
				triex.getMessage(), "Error:", JOptionPane.ERROR_MESSAGE);
    	System.exit(1);
		}
	}

  protected static void check_valid_triangle( double triangle[] ) throws TriangleException {


		if ( triangle[0] <= 0 )
		{
			throw new TriangleException("Triangles cannot be formed with sides of length zero or less.");
		}
		else if ( Double.isInfinite( triangle[2] ) )
		{
			throw new TriangleException("Sorry cannot process triangles with sides longer than " + Double.MAX_VALUE);
		}
		else if ( (triangle[0] + triangle[1] ) <= triangle[2] )
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
