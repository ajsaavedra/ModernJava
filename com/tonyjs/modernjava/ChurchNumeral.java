package com.tonyjs.modernjava;

import java.util.function.UnaryOperator;

/**
 * This class contains instance methods that implement Church numerals via
 * functional programming, and static methods that allow instances of the class
 * to perform arithmetic evaluations. 
 * <p>
 * Defining an instance of the class with a number allows application of a 
 * given function to a given argument by the numerical value of the current 
 * Church Numeral instance.
 * 
 * @author Tony Saavedra
 *
 */
public class ChurchNumeral
{
    private int cn;

    /**
     * Constructs an instance of a ChurchNumeral.
     * This method takes a number that represents the number
     * of times it will apply a function to an argument.
     *  
     * @param cn    the numerical value of the ChurchNumeral
     * @throws IllegalArgumentException If the user input is neither a 
     *                                  primitive int nor a positive int
     */
    public ChurchNumeral(int cn) throws IllegalArgumentException
    {
        if (Integer.class.isInstance(cn) && cn >= 0) {
            this.cn = cn;
        } else {
            throw new IllegalArgumentException("Argument not an integer greater or equal to 0.");
        }
    }

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + " " + this.cn;
    }

    /**
     * Returns the result of applying a function to an argument x amount of times.
     * This instance method takes a UnaryOperator and an argument, where the operator
     * is applied to the argument by the numerical value of the ChurchNumeral
     * that calls it.
     * <p>
     * It recursively calls itself on the function and argument, each time decrementing
     * the numerical value of the current ChurchNumeral, while storing its original
     * value in a temporary variable. It returns the original second argument when reaching
     * the base case of zero, and then recursively applies the operator f the return value.
     * 
     * @param f     the UnaryOperator that will be applied to the argument arg
     *              by the ChurchNumeral's numerical representation
     * @param arg   the argument that will be applied to the function f
     *              by the ChurchNumeral's numerical representation
     * @return      the final result of applying arg to f by the ChurchNumeral's
     *              numerical representation
     */
    public int apply(UnaryOperator<Integer> f, Integer arg)
    {
        if (this.cn != 0) {
            int temp = this.cn;
            this.cn--;
            int finalResult = apply(f, f.apply(arg));
            this.cn = temp;
            return finalResult;
        }

        return arg;
    }

    /**
     * Returns a new ChurchNumeral one larger than the current one.
     * This instance method creates a new instance of a ChurchNumeral whose
     * value is exactly one greater than the ChurchNumeral that calls the method.
     * 
     * @return  the instance of a ChurchNumeral that succeeds the current one by one
     */
    public ChurchNumeral plusOne()
    {
        return new ChurchNumeral(this.cn + 1);
    }

    /**
     * Returns a new ChurchNumeral that is the sum of two ChurchNumerals.
     * This instance method takes another ChurchNumeral as an argument and takes its
     * numerical value to add to the numerical value of the ChurchNumeral that called
     * the method.
     * 
     * @param cnum  the second ChurchNumeral to add to the caller
     * @return      the new ChurchNumeral whose value is the result adding both the 
     *              argument and the current ChurchNumeral
     */
    public ChurchNumeral plus(ChurchNumeral cnum)
    {
        return new ChurchNumeral(this.cn + cnum.cn);
    }

    /**
     * Returns a new ChurchNumeral that is the subtraction of two ChurchNumerals.
     * This instance method takes another ChurchNumeral as an argument and takes its
     * numerical value and subtracts the numerical value of the current ChurchNumeral.
     * 
     * @param cnum  the ChurchNumeral whose value is subtracted from the current one
     * @return      the new ChurchNumeral whose value is the result of subtracting
     *              the current ChurchNumeral by the argument
     */
    public ChurchNumeral minus(ChurchNumeral cnum)
    {
        if (this.cn - cnum.cn < 0) {
            return new ChurchNumeral(0);
        }
        return new ChurchNumeral(this.cn - cnum.cn);
    }

    /**
     * Returns a unary operator that multiplies a number by two.
     * This static method is passed as the first argument of the apply method,
     * and is applied by the numerical value of the current ChurchNumeral
     * to an argument.
     * 
     * @return  the unary operator that will return its input evaluation
     */
    public static UnaryOperator<Integer> timesTwo()
    {
        return i -> i * 2;
    }

    /**
     * Returns a unary operator that multiplies a number by itself.
     * This static method is passed as the first argument of the apply method,
     * and is applied by the numerical value of the current ChurchNumeral
     * to an argument.
     * 
     * @return  the unary operator that will return its input evaluation
     */
    public static UnaryOperator<Integer> doubleUp()
    {
        return i -> i * i;
    }

    /**
     * Returns the numerical representation of a ChurchNumeral
     * 
     * @return  the private numerical value of the current ChurchNumeral
     */
    public int getCN()
    {
        return cn;
    }
}
