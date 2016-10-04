package com.tonyjs.modernjava;

import java.util.function.UnaryOperator;

public class ChurchNumeral
{
    private int cn;

    public ChurchNumeral(int num)
    {
        this.cn = num;
    }

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + " " + this.cn;
    }

    public int apply(UnaryOperator<Integer> f, Integer arg)
    {
        int finalResult = arg;

        for (int i = 0; i < this.cn; i++) {
            finalResult = f.apply(finalResult);
        }

        return finalResult;
    }

    public ChurchNumeral plusOne()
    {
        return new ChurchNumeral(this.cn + 1);
    }

    public ChurchNumeral plus(ChurchNumeral cnum)
    {
        return new ChurchNumeral(this.cn + cnum.cn);
    }

    private static UnaryOperator<Integer> timesTwo()
    {
        return i -> i * 2;
    }

    private static UnaryOperator<Integer> doubleUp()
    {
        return i -> i * i;
    }

    public static void main(String[] args)
    {
        ChurchNumeral one = new ChurchNumeral(1);
        ChurchNumeral two = new ChurchNumeral(2);
        ChurchNumeral three = new ChurchNumeral(3);
        ChurchNumeral seven = new ChurchNumeral(three.plusOne().cn + two.plusOne().cn);

        System.out.println(one.toString());
        System.out.println(two.toString());
        System.out.println(seven.toString());

        System.out.println("\nApplying timesTwo UnaryOperator:");
        System.out.println(one.apply(timesTwo(), 2));
        System.out.println(two.apply(timesTwo(), 4));
        System.out.println(three.apply(timesTwo(), 3));

        System.out.println("\nApplying doubleUp UnaryOperator:");
        System.out.println(one.apply(doubleUp(), 2));
        System.out.println(two.apply(doubleUp(), 4));
        System.out.println(three.apply(doubleUp(), 3));

        System.out.println("\nAdding church numerals:");
        System.out.println(two.plus(three));
        System.out.println(seven.plus(seven));
    }
}
