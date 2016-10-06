package com.tonyjs.modernjava;

import java.util.ArrayList;
import java.util.List;

public class TestMethods
{
    public static void main(String[] args)
    {
        List<Integer> empty = new ArrayList<Integer>();

        List<String> strings = new ArrayList<String>();
        strings.add("Hello");
        strings.add("World!");
        strings.add("Hear");
        strings.add("me");
        strings.add("roar!");

        List<Integer> ints = new ArrayList<Integer>();
        ints.add(3);
        ints.add(11);
        ints.add(7);
        ints.add(2);
        ints.add(19);
        ints.add(5);
        ints.add(6);

        System.out.println("Empty list as is: " + empty);
        System.out.println("Empty list reversed: " + ModernJava.reverse(empty) + "\n");

        System.out.println("List of strings as is: " + strings);
        System.out.println("List of strings reversed: " + ModernJava.reverse(strings));
        System.out.println("List of strings is not mutated: " + strings + "\n");

        System.out.println("List of integers as is: " + ints);
        System.out.println("List of integers reversed: " + ModernJava.reverse(ints));
        System.out.println("List of integers is not mutated: " + ints);

        System.out.println("\nPerfect numbers up to 1000:");
        Long start = System.currentTimeMillis();
        ModernJava.perfectNumbersUpTo(1000);
        Long end = System.currentTimeMillis();
        System.out.println("\nTotal run time: " + (end - start) + " ms");

        System.out.println("\nImperative perfect numbers up to 1000:");
        Long startImperative = System.currentTimeMillis();
        System.out.println(ModernJava.imperativePerfectNumbers(1000));
        Long endImperative = System.currentTimeMillis();
        System.out.println("Total run time: " + (endImperative - startImperative) + " ms\n");

        ChurchNumeral zero = new ChurchNumeral(0);
        ChurchNumeral one = new ChurchNumeral(1);
        ChurchNumeral two = new ChurchNumeral(2);
        ChurchNumeral three = new ChurchNumeral(3);
        ChurchNumeral four = three.plusOne();
        ChurchNumeral seven = new ChurchNumeral(three.plusOne().getCN() + two.plusOne().getCN());

        System.out.println(one.toString());
        System.out.println(two.toString());
        System.out.println(four.toString());
        System.out.println(seven);

        System.out.println("\nApplying timesTwo UnaryOperator:");
        System.out.println(zero.apply(ChurchNumeral.timesTwo(), 15));
        System.out.println(one.apply(ChurchNumeral.timesTwo(), 2));
        System.out.println(two.apply(ChurchNumeral.timesTwo(), 4));
        System.out.println(seven.apply(ChurchNumeral.timesTwo(), 3));

        System.out.println("\nApplying doubleUp UnaryOperator:");
        System.out.println(one.apply(ChurchNumeral.doubleUp(), 2));
        System.out.println(two.apply(ChurchNumeral.doubleUp(), 4));
        System.out.println(three.apply(ChurchNumeral.doubleUp(), 3));

        System.out.println("\nAdding church numerals:");
        System.out.println(two.plus(three));
        System.out.println(seven.plus(two));
        System.out.println(seven.plus(seven.plus(seven)));

        System.out.println("\nSubtracting church numerals:");
        System.out.println(seven.minus(three));
        System.out.println(three.minus(three));
        System.out.println(seven.minus(one));
    }
}
