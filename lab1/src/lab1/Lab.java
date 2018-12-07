package lab1;

/**
 *  @author Tim O'Brien
 *  @version 8/23/18
 *  Lab 1
 *  
 *  Creates a new Lab instance with an array that holds input taken
 *  from the Driver class, then calculates the number of TA's per student.
 *  Which then decides the coverage of TA's to students.
 *  
 */
public class Lab
{
    /** Instance variables */
    private String data[] = new String[4];
    
    /** Create an instance of our lab based 
     * of the input info
     * @param input string of information about our lab
     * and this string is of the form:
     * Lab#numberOfStudents#numberOfTA
     *  */
    public Lab(String input)
    {
        String temp[] = input.split("#");
        data[0] = temp[0].toUpperCase();
        data[1] = temp[1];
        data[2] = temp[2];
        
        /** Number of students in the class */
        float numberOfStudents = Float.parseFloat(data[1]);
        /** Number of Teachers Assistants */
        float numberOfTA = Float.parseFloat(data[2]);
        /** Teachers Assistants to Students */
        float taPerStudent = numberOfStudents / numberOfTA;
        
        //Check the number of Teachers Assistants to Students
        if (taPerStudent <= 20)
        {
            data[3] = "Extremely Well Covered";
        }
        else if (taPerStudent <= 30)
        {
            data[3] = "Very Well Covered";
        }
        else if (taPerStudent <= 35)
        {
            data[3] = "Well Covered";
        }
        else if (taPerStudent > 35)
        {
            data[3] = "Covered";
        }
    }
    /** 
     * Construct a string representation of our object
     * which is of the form:
     * Lab: Lab name, Number of students: numberOfStudents, Number of Teachers 
     * assistants: numberOfTA, 
     * Teachers assistants per student: taPerStudent
     * */
    public String toString()
    {
        return String.format("Lab: %s, Students: %s, Teaching Assistants: %s,"
                + " %s", data[0], data[1], data[2], data[3]);
    }
    
}

