package Exponent;

public class Exponent {
    public static int exponent(int number, int exponent){
        if(exponent == 1)
            return number;
        return number * exponent(number, exponent-1);
    }
}
