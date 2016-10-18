package com.example;
import java.util.*;

public class NextFullMoon
{



    public static void main(String[] args)
    {
        // Variables
        int day, month, year;
        int moonday = 0, moonmonth = 0, moonyear = 0;
        boolean a = true;
        Scanner CalendarDates = new Scanner(System.in);
        Calendar fullMoonDates = Calendar.getInstance();
        Calendar userDates = Calendar.getInstance();

        //User inputs
        System.out.println("Please enter a year: ");
        year = CalendarDates.nextInt();
        System.out.println("Please enter a month: ");
        month = CalendarDates.nextInt();
       --month; //Corrects the month in Java. For example, the user may input a 1 for January, but that would actually be 0.
        System.out.println("Please enter a day: ");
        day = CalendarDates.nextInt();

        // Hard coded date for a full moon
        fullMoonDates.set(Calendar.YEAR, 1980);
        fullMoonDates.set(Calendar.MONTH, 0);
        fullMoonDates.set(Calendar.DATE, 2);

        // user inputted date is inserted into this calendar
        userDates.set(Calendar.YEAR, year);
        userDates.set(Calendar.MONTH, month);
        userDates.set(Calendar.DATE, day);

        while(a == true) //For loop used to determine the date of the next full moon
        {
            a = isFullMoon(fullMoonDates, userDates);// Function that determines if the moon is full or not

            if (a == true)
            {
                fullMoonDates.add(Calendar.SECOND,2551442); // Java doesn't allow for the inserting of decimals into the add function. I converted it to seconds.




            }
        }

        // the date of the full moons are entered into those variables
        moonday = fullMoonDates.get(Calendar.DATE);
        moonmonth = fullMoonDates.get(Calendar.MONTH);
        moonyear = fullMoonDates.get(Calendar.YEAR);

        ++moonmonth; // Moon month is incremented by one in order to display the correct month
        System.out.println("The next full moon will be on: " + moonmonth + "/" + moonday + "/"+ moonyear); // Outputs the date of the next full moon
        //System.out.println("The next full moon will be on: " + fullMoonDates.getTime());

    }

    public static boolean isFullMoon(Calendar fullMoonDates, Calendar userDates) //Function used to compare current date with full moon dates
    {

        // if the comparison is true, than the next full moon date will be displayed
        if(fullMoonDates.get(Calendar.YEAR) >= userDates.get(Calendar.YEAR) && fullMoonDates.get(Calendar.MONTH) >= userDates.get(Calendar.MONTH)&& fullMoonDates.get(Calendar.DATE) >= userDates.get(Calendar.DATE)  )
        {
            return false; // If this is returned, than the loop will finish and the next full moon date will be displayed
        }
        else
        {

            return true; // This means the full moon date isn't later than the user inputted date
        }

    }
}
