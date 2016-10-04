package com.tonyjs.modernjava;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ModernJava
{
	public static <T> List<T> reverse(List<T> list)
	{
		List<T> toReturn = new ArrayList<T>();
		for (int i = list.size()-1; i >= 0; i--) {
			toReturn.add(list.get(i));
		}

		return toReturn;
	}

	public static void perfectNumbersUpTo(int x)
	{
		IntStream.rangeClosed(1, x).filter(n -> isPerfect(n)).forEach(i -> System.out.print(i + " "));
	}

	public static boolean isPerfect(int n)
	{
		return IntStream.range(1, n).filter(x -> n % x == 0).sum() == n;
	}

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

	public static void main(String[] args)
	{
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

		System.out.println("String array as is: " + strings);
		System.out.println("String array reversed: " + reverse(strings));
		System.out.println("String array is not mutated: " + strings + "\n");

		System.out.println("Integer array as is: " + ints);
		System.out.println("Integer array reversed: " + reverse(ints));
		System.out.println("Integer array is not mutated: " + ints);

		System.out.println("\nPerfect numbers up to 1000:");
		Long start = System.currentTimeMillis();
		perfectNumbersUpTo(1000);
		Long end = System.currentTimeMillis();
		System.out.println("\nTotal run time: " + (end - start) + " ms");
		
		System.out.println("\nImperative perfect numbers up to 1000:");
		Long startImperative = System.currentTimeMillis();
		System.out.println(imperativePerfectNumbers(1000));
		Long endImperative = System.currentTimeMillis();
		System.out.println("\nTotal run time: " + (endImperative - startImperative) + " ms");
	}
}
