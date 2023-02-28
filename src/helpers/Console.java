package helpers;

import java.util.Scanner;

public class Console
{
    private Scanner console = new Scanner(System.in);

    public void println(String message)
    {
        System.out.println(message);
    }

    public void print(String message)
    {
        System.out.print(message);
    }

    public void newLine()
    {
        System.out.println();
    }

    public String getString(String prompt)
    {
        System.out.println(prompt + ": ");
        return console.nextLine();
    }

    public String[] getStrings(String prompt, int numValues)
    {
        String[] results = new String[numValues];

        for (int i = 0; i < results.length; i++)
        {
            String value = getString(prompt);
            results[i] = value;
        }

        return results;
    }

    public int getInt(String prompt)
    {
        System.out.println(prompt + ": ");
        while (!console.hasNextInt())
        {
            System.out.println("Please enter a valid integer: ");
            console.nextLine(); //clear the scanner buffer
        }

        int result = console.nextInt();
        console.nextLine(); //clear the scanner buffer

        return result;
    }

    public double getDouble(String prompt)
    {
        System.out.println(prompt + ": ");
        while (!console.hasNextDouble())
        {
            System.out.println("Please enter a valid double: ");
            console.nextLine(); //clear the scanner buffer
        }

        double result = console.nextDouble();
        console.nextLine(); //clear the scanner buffer

        return result;
    }

    public boolean getBoolean(String prompt)
    {
        System.out.println(prompt + ": ");
        while (!console.hasNextBoolean())
        {
            System.out.println("Please enter true/false: ");
            console.nextLine(); //clear the scanner buffer
        }

        boolean result = console.nextBoolean();
        console.nextLine(); //clear the scanner buffer

        return result;
    }

    public String toString()
    {
        return "A wrapper class for the Java helpers.Console";
    }
}
