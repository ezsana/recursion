package com.codecool.zsana.recursion;

import java.util.ArrayList;
import java.util.List;

public class Recursion {

    /**
     * classic Fibonacci
     */

    static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    /**
     * Given a string, find all possible palindromic partitions of given string.
     * The idea is to go through every substring starting from first character,
     * check if it is palindrome. If yes, then add the substring to solution and
     * recur for remaining part.
     */

    static void letsFindPalindromes(String s) {
        List<String> palindromes = new ArrayList<String>();
        findPalindromes(s, 0, palindromes);
    }

    static void findPalindromes(String s, int start, List<String> palindromes) {
        if (start > s.length()) {
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i+1);
            if (sub.equals(new StringBuilder(sub).reverse().toString())) {
                System.out.println(sub);
            }
        }
        findPalindromes(s, start+1, palindromes);
    }

    // method instead of StringBuilder reverse:
    static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    /**
     *Given an integer, write a function that returns true if the given number is palindrome, else false.
     * For example, 12321 is palindrome, but 1451 is not palindrome.
     */


    static boolean isNumberPalindrome(int number) {
        String n = String.valueOf(number);
        return new StringBuilder(n).reverse().toString().equals(n);
    }

    /**
     * The idea is to create a copy of num and recursively pass the copy by reference,
     * and pass num by value. In the recursive calls, divide num by 10 while moving down
     * the recursion tree. While moving up the recursion tree, divide the copy by 10.
     * When they meet in a function for which all child calls are over, the last digit of num
     * will be ith digit from the beginning and the last digit of copy will be ith digit from the end.
     */

    static boolean isPalindrome(int number) {
        if (number < 0) {
            number = Math.abs(number);
        }
        try {
            divideByTen(number, number);
            return true;
        } catch (Error e) {
            return false;
        }
    }

                                 // pass by value---pass by reference
    private static Integer divideByTen(int number, int copyOfNumber) {
        if (number == 0) {
            return copyOfNumber;
        } else {
            copyOfNumber = divideByTen(number / 10, copyOfNumber);

        }
        if (number % 10 == copyOfNumber % 10) {
            return copyOfNumber / 10;
        } else {
            throw new Error("The number is not a palindrome");
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-2));
    }

}
