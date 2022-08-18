package TempConvert;

import java.util.ArrayList;
import java.util.List;

public class TempConvert
{
    public static void main(String[] args)
    {

        //If no input, or invalid number of parameters, or user asks for help, then show help and terminate
        if( !(args.length == 3 || args.length == 5) || args[0].equals("-h") || args[0].equals("--help") || args[0].equals("?") || args[0].equals(""))
        {
            help();
        }

        //Get the input and output unit parameters, and add them to units list
        //Get temperature and add it to inputTemp
        //Get precision
        double inputTemp = Double.NaN;
        int precision = 2;
        List<String> units = new ArrayList<>(2);
        for(int i = 0; i < args.length; i++)
        {
            if(args[i].equals("--precision") || args[i].equals("-p") || args[i].equals("-precision") || args[i].equals("--p")) {
                try {
                    precision = Integer.parseInt(args[i + 1]);
                    if(precision < 0)
                        throw new Exception();
                } catch (Exception e) {
                    unknownInput(args[i+1]);
                }
                i++;
            } else if (args[i].charAt(0) == '-')
                units.add(args[i]);
            else
                try {
                    inputTemp = Double.parseDouble(args[i]);
                } catch (Exception e) {
                    unknownInput(args[i]);
                }
        }


        //Decide what kind of conversion operation should be done on input temperature
        if(units.get(0).equals("-c") || units.get(0).equals("--celsius") || units.get(0).equals("--c") || units.get(0).equals("-celsius"))
        {
            if(units.get(1).equals("-f") || units.get(1).equals("--fahrenheit") || units.get(1).equals("--f") || units.get(1).equals("-fahrenheit"))
            {
                System.out.printf("%." + precision + "f\n", Convert.celsiusToFahrenheit(inputTemp));
                System.exit(0);
            }
            else if(units.get(1).equals("-k") || units.get(1).equals("--kelvin") || units.get(1).equals("--k") || units.get(1).equals("-kelvin"))
            {
                System.out.printf("%." + precision + "f\n", Convert.celsiusToKelvin(inputTemp));
                System.exit(0);
            }
            else
                unknownInput(units.get(1));
        }
        else if(units.get(0).equals("-f") || units.get(0).equals("--fahrenheit") || units.get(0).equals("--f") || units.get(0).equals("-fahrenheit"))
        {
            if(units.get(1).equals("-c") || units.get(1).equals("--celsius") || units.get(1).equals("--c") || units.get(1).equals("-celsius"))
            {
                System.out.printf("%." + precision + "f\n", Convert.fahrenheitToCelsius(inputTemp));
                System.exit(0);
            }
            else if(units.get(1).equals("-k") || units.get(1).equals("--kelvin") || units.get(1).equals("--k") || units.get(1).equals("-kelvin"))
            {
                System.out.printf("%." + precision + "f\n", Convert.fahrenheitToKelvin(inputTemp));
                System.exit(0);
            }
            else
                unknownInput(units.get(1));
        }
        else if(units.get(0).equals("-k") || units.get(0).equals("--kelvin") || units.get(0).equals("--k") || units.get(0).equals("-kelvin"))
        {
            if(units.get(1).equals("-f") || units.get(1).equals("--fagrenheit") || units.get(1).equals("--f") || units.get(1).equals("-fahrenheit"))
            {
                System.out.printf("%." + precision + "f\n", Convert.kelvinToFahrenheit(inputTemp));
                System.exit(0);
            }
            else if(units.get(1).equals("-c") || units.get(1).equals("--celsius") || units.get(1).equals("--c") || units.get(1).equals("-celsius"))
            {
                System.out.printf("%." + precision + "f\n", Convert.kelvinToCelsius(inputTemp));
                System.exit(0);
            }
            else
                unknownInput(units.get(1));
        }
        else
            unknownInput(units.get(0));

    }

    //Function displays application help
    public static void help()
    {
        System.out.println(
                """
                        NAME
                        \tTempConvert - converts temperature value between units
                        SYNTAX
                        \tTempConvert --[input unit] --[output unit] [temperature] {--precision *precision_value*}
                        DESCRIPTION
                        \tConverts temperature between commonly used units and outputs result in command line. Currently supported are operations between celsius, kelvin and fahrenheit.
                        -c, --celsius - conversion from/to celsius
                        -f, --fahrenheit - conversion from/to fahrenheit
                        -k, --kelvin - conversion from/to kelvin
                        -p, --precision - specify number of decimal points in the result
                        Example usage:
                        TempConvert -c -f 18 -p 2
                        TempConvert --celsius --kelvin 32 --precision 5
                        AUTHOR
                        \tWrote by Bartłomej Konecki
                        BUG REPORT
                        \thttps://github.com/IQ8QI/TempConvert"""
        );
        System.exit(0);
    }

    //Error message giving the place were is the unknown parameter
    public static void unknownInput(String input)
    {
        System.out.println("ERROR\nUnknown input format at:" + input + "\nExample usage:\nTempConvert -c -k 28.5\nTempConvert --fahrenheit --kelvin 13 --precision 4");
        System.exit(-1);
    }

}
