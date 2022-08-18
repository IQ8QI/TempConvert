package TempConvert;

public class Convert
{
    public static double celsiusToFahrenheit(double input)
    {
        return ((input * 9f) / 5f) + 32;
    }

    public static double celsiusToKelvin(double input)
    {
        return input + 273.15f;
    }

    public static double fahrenheitToCelsius(double input)
    {
        return ((input - 32) * 5f) / 9f;
    }

    public static double fahrenheitToKelvin(double input)
    {
        return celsiusToKelvin(fahrenheitToCelsius(input));
    }

    public static double kelvinToCelsius(double input)
    {
        return input - 273.15f;
    }

    public static double kelvinToFahrenheit(double input)
    {
        return celsiusToFahrenheit(kelvinToCelsius(input));
    }
}
