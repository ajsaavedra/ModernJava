package com.tonyjs.modernjava;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ModernJava
{
    /**
     * Returns a parameterized List whose elements are in reverse.
     * This method takes a parameterized list as an argument and
     * returns a new parameterized list of the same type whose 
     * elements are in the reverse order. It does not mutate the
     * original parameterized list.
     * 
     * @param   list    the parameterized list to reverse
     * @return          a new list, whose elements are of the
     *                  given list, in the reverse order
     */
    public static <T> List<T> reverse(List<T> list)
    {
        List<T> toReturn = new ArrayList<T>();
        for (int i = list.size()-1; i >= 0; i--) {
            toReturn.add(list.get(i));
        }

        return toReturn;
    }

    /**
     * Prints out a list of perfect numbers up to the given argument.
     * This method iterates over all numbers from 1 to the argument.
     * Using a helper function, it then prints out which of those numbers
     * in that range is considered a perfect number.
     * 
     * @param   x   the maximum number in the range of perfect numbers
     */
    public static void perfectNumbersUpTo(int x)
    {
        IntStream.rangeClosed(1, x).filter(n -> isPerfect(n)).forEach(i -> System.out.print(i + " "));
    }

    /**
     * Returns if the factors of a number add up to that number.
     * This method takes a number as an argument and checks all the
     * numbers leading up to it that add up to itself. It is an
     * exclusive range that does not include the argument.
     * 
     * @param   n   the number whose factors must add up to itself
     * @return      the boolean value that says whether or not the
     *              factors of a number add up to that number
     */
    public static boolean isPerfect(int n)
    {
        return IntStream.range(1, n).filter(x -> n % x == 0).sum() == n;
    }

    /**
     * Returns a parameterized list of perfect numbers up to the given argument.
     * This method works imperatively to find all of the factors of each number
     * in a range that goes up to the given argument. A number is considered
     * perfect is all its factors leading up to it add up to itself.
     * 
     *  @param  x   the max number in the range of perfect numbers
     *  @return     the parameterized list of perfect numbers up to x
     */
    public static List<Integer> imperativePerfectNumbers(int x)
    {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i <= x; i++) {
            int sum = 0;
            for (int j = 1; j <= i/2; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (sum == i) {
                list.add(i);
            }
        }
        return list;
    }
}
