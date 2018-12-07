import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import org.json.*;

public class TodoChecker
{
    private final static String TODO_FILENAME = "TODO.json";
    
    private final static int[] VALID_SECTIONS = {11, 12, 13, 14};
    
    private final static int VALID_ID_LENGTH = 9;
    
    // Lightweight date checker:
    private final static String VALID_DATE_REGEX = "20[0-9][0-9]-[0-1][0-9]-[0-3][0-9]";
    private final static String VALID_DATE_FORMAT_INFO = "YYYY-MM-DD";
    
    private final static String VALID_EMAIL_SUFFIX = "@ou.edu";
    
    public static void main(String[] args)
    {
        boolean valid = true;
        
        try (FileInputStream fs = new FileInputStream(new File(TODO_FILENAME));
             BufferedReader br = new BufferedReader(new InputStreamReader(fs)))
        {
            // Read in the file text:
            String inputText = "";
            String nextLine = br.readLine();
            while (nextLine != null)
            {
                inputText += nextLine;
                nextLine = br.readLine();
            }
            
            // Parse .json file with expected format:
            try {  // Make sure that the root is valid JSON.
                JSONObject root = new JSONObject(inputText);
                
                // Get the metadata and tasks; validate the metadata:
                try {
                    int section = root.getInt("Lab Section");
                    String lastModified = root.getString("Last Modified");
                    int id = root.getInt("OU ID");
                    String email = root.getString("OU EMAIL");
                    JSONArray tasks = root.getJSONArray("Tasks");
                    
                    if (Arrays.binarySearch(VALID_SECTIONS, section) < 0)  // Invalid section number.
                    {
                        System.out.println(String.format("Invalid section number %d. Valid section numbers are: %s", 
                                section, Arrays.toString(VALID_SECTIONS)));
                        valid = false;
                    }
                    
                    String[] splitDate = lastModified.split(VALID_DATE_REGEX);
                    if (splitDate.length != 0)  // Invalid last date modified.
                    {
                        System.out.println(String.format("Invalid date format for last modified %s. Be sure that the"
                                + "format matches %s", lastModified, VALID_DATE_FORMAT_INFO));
                        valid = false;
                    }
                    
                    // ID should not have any leading zeros.
                    if (String.format("%d", id).length() != VALID_ID_LENGTH)  // Invalid OU ID length.
                    {
                        System.out.println(String.format("Invalid OU ID %d. OU IDs must be %d digits long", 
                                id, VALID_ID_LENGTH));
                        valid = false;
                    }
                    
                    if (!email.endsWith(VALID_EMAIL_SUFFIX))
                    {
                        System.out.println(String.format("Invalid email %s. Make sure that your email ends with %s",
                                email, VALID_EMAIL_SUFFIX));
                        valid = false;
                    }
                    
                    // Validate the tasks:
                    for (Object objTask : tasks) {
                        try
                        {
                            JSONObject task = (JSONObject) objTask;
                            
                            try
                            {
                                String description = task.getString("Description");
                                int estimatedTime = task.getInt("Estimated Time (Minutes)");
                                int actualTime = task.getInt("Actual Time (Minutes)");
                                
                                if (estimatedTime <= 0)
                                {
                                    System.out.println("Estimated time must be > 0 minutes!");
                                    valid = false;
                                }
                                if (actualTime <= 0)
                                {
                                    System.out.println("Actual time must be > 0 minutes!");
                                    valid = false;
                                }
                            }
                            catch (JSONException e)
                            {
                                System.out.println(String.format("Key does not exist or is incorrect type! Make sure"
                                        + "that %s matches our specified .json file format (refer to the template and"
                                        + "spec document on canvas if needbe). Error is as below:\n %s",
                                        TODO_FILENAME, e.getMessage()));
                                valid = false;
                            }
                        }
                        catch (ClassCastException e)
                        {
                            System.out.println(String.format("The list of tasks contains an entry (%s) that is not a"
                                    + "JSON object { ... }. Make sure that %s matches our specified .json file format"
                                    + "(refer to the template and spec document on canvas if needbe). "
                                    + "Error is as below:\n %s", objTask, TODO_FILENAME, e.getMessage()));
                            valid = false;
                        }
                    }
                }
                catch (JSONException e) {
                    System.out.println(String.format("Key does not exist or is incorrect type! Make sure that %s"
                            + "matches our specified .json file format (refer to the template and spec document on"
                            + "canvas if needbe). Error is as below:\n %s", TODO_FILENAME, e.getMessage()));
                    valid = false;
                }
            }
            catch (JSONException e) {
                System.out.println(String.format("%s is not a valid JSON file. Look for JSON format errors. You can"
                        + "try a validation tool such as https://jsonlint.com/", TODO_FILENAME));
                valid = false;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(String.format("File %s not found! Make sure that your %s file is not in the src folder"
                    + "but is at the project level. Make sure that the extension is .json",
                    TODO_FILENAME, TODO_FILENAME));
            valid = false;
        } catch (IOException e) {
            System.out.println("Error while reading file! Try running the program again. The error is as below:");
            e.printStackTrace();
            valid = false;
        }
        
        // Output valid if successful:
        if (valid)
        {
            System.out.println(String.format("%s sucessfully validated!", TODO_FILENAME));
        }
        else
        {
            System.out.println(String.format("Validation on %s failed! Review the above errors to resolve your issues",
                    TODO_FILENAME));
        }
    }
}
