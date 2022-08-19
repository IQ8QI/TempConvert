package TempConvert;

public class TempConvert
{
    public static void main(String[] args)
    {

        //If no input, or invalid number of parameters, or user asks for help, then show help and terminate
        if( !(args.length == 3 || args.length == 5) || args[0].equals("-h") || args[0].equals("--help") || args[0].equals("?") || args[0].equals(""))
        {
            terminateHelp();
        }

        //Get the input and output unit parameters, and add them to units list
        //Get temperature and add it to inputTemp
        //Get precision
        double inputTemp = Double.NaN;
        int precision = 2;
        String fromUnit = "";
        String toUnit = "";

        for(int i = 0; i < args.length; i++) {
            //If input is a parameter
            //Remove all dashes
            if (args[i].charAt(0) == '-') {
                while(args[i].charAt(0) == '-')
                    args[i] = args[i].substring(1);
                args[i] = args[i].substring(0, 1);
                if(args[i].equals("p")) {
                    try {
                        precision = Integer.parseInt(args[i + 1]);
                        if(precision < 0)
                            throw new Exception();
                    } catch (Exception e) {
                        terminateUnknownInput(args[i+1]);
                    }
                    i++;
                } else if(fromUnit.equals(""))
                    fromUnit = args[i].toLowerCase();
                else if(!fromUnit.equals(""))
                    toUnit = args[i].toLowerCase();
                else
                    terminateUnknownInput(args[i]);
            } else
                try {
                    inputTemp = Double.parseDouble(args[i]);
                } catch (Exception e) {
                    terminateUnknownInput(args[i]);
                }
        }


        //Decide what kind of conversion operation should be done on input temperature
        String result = "";
        if(fromUnit.equals("c"))
            if(toUnit.equals("f"))
                result = String.format("%." + precision + "f\n", Convert.celsiusToFahrenheit(inputTemp));
            else if(toUnit.equals("k"))
                result = String.format("%." + precision + "f\n", Convert.celsiusToKelvin(inputTemp));
            else
                terminateUnknownInput(toUnit);
        else if(fromUnit.equals("f"))
            if(toUnit.equals("c"))
                result = String.format("%." + precision + "f\n", Convert.fahrenheitToCelsius(inputTemp));
            else if(toUnit.equals("k"))
                result = String.format("%." + precision + "f\n", Convert.fahrenheitToKelvin(inputTemp));
            else
                terminateUnknownInput(toUnit);
        else if(fromUnit.equals("k"))
            if(toUnit.equals("f"))
                result = String.format("%." + precision + "f\n", Convert.kelvinToFahrenheit(inputTemp));
            else if(toUnit.equals("c"))
                result = String.format("%." + precision + "f\n", Convert.kelvinToCelsius(inputTemp));
            else
                terminateUnknownInput(toUnit);
        else
            terminateUnknownInput(fromUnit);

        if(result.equals(""))
            terminateHelp();
        System.out.print(result);

    }

    //Function displays application help
    public static void terminateHelp()
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
    public static void terminateUnknownInput(String input)
    {
        System.out.println("ERROR\nUnknown input format at:" + input + "\nExample usage:\nTempConvert -c -k 28.5\nTempConvert --fahrenheit --kelvin 13 --precision 4");
        System.exit(-1);
    }
}
