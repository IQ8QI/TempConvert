# TempConvert
CLI application to convert temperature between various units

# Syntax
TempConvert --[input unit] --[output unit] [temperature] {--precision [decimal digits]}

# Example usage
TempConvert -c -f 18 -p 4\
TempConvert --celsius --kelvin 32 --precision 3\
TempConvert ?

# Description
Converts temperature between commonly used units. Currently are supported operations between celsius, kelvin and fahrenheit. You can also specify precision of the operation, default is 2 digits.