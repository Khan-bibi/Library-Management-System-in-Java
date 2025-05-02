package utils;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CheckInput
{
    private static Scanner scannerObj = new Scanner(System.in);

    public static int getInput(String input)
    {
        int n;
        while(true)
        {
            try
            {
                System.out.print(input);
                n=Integer.parseInt(scannerObj.nextLine());
                if(n<0)
                {
                    throw new NumberFormatException("Sorry! Negative integer not allowed.");
                }
                return n;
            }
            catch (NumberFormatException eobj)
            {
                System.out.println("Invalid input. Try again");
            }
        }
    }

    public static String getInputString(String input)
    {
        System.out.print(input);
        return scannerObj.nextLine().trim();
    }

    public static LocalDate getInputDate(String input)
    {
        while(true)
        {
            try
            {
                System.out.print(input + "(YYYY-MM-DD): ");
                return LocalDate.parse(scannerObj.nextLine());
            }
            catch (DateTimeParseException eobj)
            {
                System.out.println("Invalid date format. Try again");
            }  
        }
    }
}