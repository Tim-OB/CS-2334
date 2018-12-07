package lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *  @author Tim O'Brien
 *  @version 8/23/18
 *  Lab 1
 *  
 *  Takes input from a BufferedReader and inputs the info into an
 *  instance of Lab. Then prints out the result of the Lab class.
 *  
 */
public class Driver
{
    /**
     * @param args command line arguments
     * @throws IOException in case any weird characters are thrown into input
     */
    public static void main(String[] args) throws IOException
    {
        //Intialize a Buffered Reader to recieve keyboard input.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        //Input the info obtained from the BufferedReader into an instance of Lab
        Lab lab = new Lab(input);
        System.out.println(lab);
        
        //Close the BufferedReader
        br.close();
        
    }

}
