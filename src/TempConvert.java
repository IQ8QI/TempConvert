import java.util.Arrays;

public class TempConvert
{
    enum Unit { Celsius, Kelvin, Fahrenheit }

    public static void main(String[] args)
    {
        //System.out.println(Arrays.toString(args));
        //TempConvert -c -f 45
        //TempConvert -k -c 78
        //TempConvert --celsius --kelvin 500
        //TempConvert -h
        //TempConvert --help

        if(args[0].equals("-h") || args[0].equals("--help") || args[0].equals("?"))
        {
            help();
            System.exit(0);
        }

        Unit in;
        Unit out;

        if(args[0].equals("-c") || args[0].equals("--celsius"))
        {
            if(args[1].equals("-f") || args[1].equals("--fahrenheit"))
            {
                System.out.println(Convert.celsiusToFahrenheit(Float.parseFloat(args[2])));
                System.exit(0);
            }
            else if(args[1].equals("-k") || args[1].equals("--kelvin"))
            {
                System.out.println(Convert.celsiusToKelvin(Float.parseFloat(args[2])));
                System.exit(0);
            }
            else
                unknownInput();
        }
        else if(args[0].equals("-f") || args[0].equals("--fahrenheit"))
        {
            if(args[1].equals("-c") || args[1].equals("--celsius"))
            {
                System.out.println(Convert.fahrenheitToCelsius(Float.parseFloat(args[2])));
                System.exit(0);
            }
            else if(args[1].equals("-k") || args[1].equals("--kelvin"))
            {
                System.out.println(Convert.fahrenheitToKelvin(Float.parseFloat(args[2])));
                System.exit(0);
            }
            else
                unknownInput();
        }
        else if(args[0].equals("-k") || args[0].equals("--kelvin"))
        {
            if(args[1].equals("-f") || args[1].equals("--fahrenheit"))
            {
                System.out.println(Convert.kelvinToFahrenheit(Float.parseFloat(args[2])));
                System.exit(0);
            }
            else if(args[1].equals("-c") || args[1].equals("--celsius"))
            {
                System.out.println(Convert.kelvinToCelsius(Float.parseFloat(args[2])));
                System.exit(0);
            }
            else
                unknownInput();
        }
        else
            unknownInput();

    }

    public static void help()
    {
        System.out.println(
                """
                        NAME
                        \tTempConvert - converts temperature units
                        SYNTAX
                        \tTempConvert --[input unit] --[output unit] [temperature]
                        DESCRIPTION
                        \tConverts temperature between commonly used units. Currently supported are operations between celsius, kelvin and fahrenheit
                        Example usage:
                        TempConvert -c -f 18
                        TempConvert --celsius --kelvin 32
                        AUTHOR
                        \tWrote by Bartłomej Konecki
                        BUG REPORT
                        \tTODO"""
        );
    }

    public static void unknownInput()
    {
        System.out.println("Unknown input format\nExample usage:\nTempConvert -c -k 28");
        System.exit(-1);
    }

}

class Convert
{
    public static float celsiusToFahrenheit(float input)
    {
        return ((input * 9f) / 5f) + 32;
    }

    public static float celsiusToKelvin(float input)
    {
        return input + 273.15f;
    }

    public static float fahrenheitToCelsius(float input)
    {
        return ((input - 32) * 5f) / 9f;
    }

    public static float fahrenheitToKelvin(float input)
    {
        return celsiusToKelvin(fahrenheitToCelsius(input));
    }

    public static float kelvinToCelsius(float input)
    {
        return input - 273.15f;
    }

    public static float kelvinToFahrenheit(float input)
    {
        return celsiusToFahrenheit(kelvinToCelsius(input));
    }
}
