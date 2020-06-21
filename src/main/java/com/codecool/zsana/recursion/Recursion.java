package com.codecool.zsana.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion {

    /**
     * classic Fibonacci: 1,1,2,3...
     */

    static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
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

    /**
     * Given a set of characters and a positive integer k, print all possible strings
     * of length k that can be formed from the given set.
     * For a given set of size n, there will be n^k possible strings of length k.
     * The idea is to start from an empty output string.
     * One by one add all characters to it. For every character added, print all possible
     * strings with current prefix by recursively calling for k equals to k-1.
     */

    private static void getSubstrings(String[] s, int len, String str) {
        if (len == 0) {
            System.out.println(str);
            return;
        }
        for (int i = 0; i < s.length; i++) {
            String temp = str + s[i];
            getSubstrings(s, len-1, temp);
        }
    }

    /**
     * The atoi() function in C takes a string (which represents an integer) as an argument
     * and returns its value of type int. So basically the function is used to convert a string argument to an integer.
     * Parameters: The function accepts one parameter s which refers to the string argument
     * that is needed to be converted into its integer equivalent.
     */

    static int atoiNonRecursive(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 10 + s.charAt(i) - '0';
        }
        return result;
    }

    static int atoiRecursive(String s, int index) {
        if (s.length() == 0) {
            return 0;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(4));
        //System.out.println(atoiRecursive("234", 0));
    }

}
