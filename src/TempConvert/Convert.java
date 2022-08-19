package TempConvert;

public class Convert
{
    public static final double ABSOLUTE_ZERO = 273.15d;

    public static double celsiusToFahrenheit(double input)
    {
        return ((input * 9d) / 5d) + 32d;
    }

    public static double celsiusToKelvin(double input)
    {
        return input + ABSOLUTE_ZERO;
    }

    public static double fahrenheitToCelsius(double input)
    {
        return ((input - 32d) * 5d) / 9d;
    }

    public static double fahrenheitToKelvin(double input)
    {
        return celsiusToKelvin(fahrenheitToCelsius(input));
    }

    public static double kelvinToCelsius(double input)
    {
        return input - ABSOLUTE_ZERO;
    }

    public static double kelvinToFahrenheit(double input)
    {
        return celsiusToFahrenheit(kelvinToCelsius(input));
    }
}
