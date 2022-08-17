import java.util.ArrayList;
import java.util.List;

public class TempConvert
{
    public static void main(String[] args)
    {

        //If no input, or invalid number of parameters, or user asks for help, then show help and terminate
        if(args.length != 3 || args[0].equals("-h") || args[0].equals("--help") || args[0].equals("?") || args[0].equals(""))
        {
            help();
        }

        //Get the parameters, and add them to params list
        //Get temperature and add it to inputTemp
        float inputTemp = Float.NaN;
        List<String> params = new ArrayList<>(2);
        for (String arg : args)
            if (arg.charAt(0) == '-')
                params.add(arg);
            else {
                try {
                    inputTemp = Float.parseFloat(arg);
                } catch (Exception e) {
                    unknownInput(arg);
                }
            }

        /*Not needed???
        if(Float.isNaN(inputTemp))
        {
            unknownInput(args[i]);
        }
         */

        //Decide what kind of conversion operation should be done on input temperature
        if(params.get(0).equals("-c") || params.get(0).equals("--celsius") || params.get(0).equals("--c") || params.get(0).equals("-celsius"))
        {
            if(params.get(1).equals("-f") || params.get(1).equals("--fahrenheit") || params.get(1).equals("--f") || params.get(1).equals("-fahrenheit"))
            {
                System.out.println(Convert.celsiusToFahrenheit(inputTemp));
                System.exit(0);
            }
            else if(params.get(1).equals("-k") || params.get(1).equals("--kelvin") || params.get(1).equals("--k") || params.get(1).equals("-kelvin"))
            {
                System.out.println(Convert.celsiusToKelvin(inputTemp));
                System.exit(0);
            }
            else
                unknownInput(params.get(1));
        }
        else if(params.get(0).equals("-f") || params.get(0).equals("--fahrenheit") || params.get(0).equals("--f") || params.get(0).equals("-fahrenheit"))
        {
            if(params.get(1).equals("-c") || params.get(1).equals("--celsius") || params.get(1).equals("--c") || params.get(1).equals("-celsius"))
            {
                System.out.println(Convert.fahrenheitToCelsius(inputTemp));
                System.exit(0);
            }
            else if(params.get(1).equals("-k") || params.get(1).equals("--kelvin") || params.get(1).equals("--k") || params.get(1).equals("-kelvin"))
            {
                System.out.println(Convert.fahrenheitToKelvin(inputTemp));
                System.exit(0);
            }
            else
                unknownInput(params.get(1));
        }
        else if(params.get(0).equals("-k") || params.get(0).equals("--kelvin") || params.get(0).equals("--k") || params.get(0).equals("-kelvin"))
        {
            if(params.get(1).equals("-f") || params.get(1).equals("--fagrenheit") || params.get(1).equals("--f") || params.get(1).equals("-fahrenheit"))
            {
                System.out.println(Convert.kelvinToFahrenheit(inputTemp));
                System.exit(0);
            }
            else if(params.get(1).equals("-c") || params.get(1).equals("--celsius") || params.get(1).equals("--c") || params.get(1).equals("-celsius"))
            {
                System.out.println(Convert.kelvinToCelsius(inputTemp));
                System.exit(0);
            }
            else
                unknownInput(params.get(1));
        }
        else
            unknownInput(params.get(0));

    }

    //Function displays application help
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
        System.exit(0);
    }

    //Error message giving the place were is the unknown parameter
    public static void unknownInput(String input)
    {
        System.out.println("ERROR\nUnknown input format at:" + input + "\nExample usage:\nTempConvert -c -k 28.5");
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
