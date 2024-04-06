package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1
//        System.out.println("Enter length of the array: ");
//        int size = sc.nextInt();
//
//        System.out.println("Enter " + size + " numbers: ");
//        int[] numbers = new int[size];
//        for(int i = 0; i < size; i++) {
//            numbers[i] = sc.nextInt();
//        }
//
//        int min = solution1(numbers);
//        System.out.println("The minimum value is: " + min);

        // 2
//        System.out.println("Enter length of the array: ");
//        int size = sc.nextInt();
//
//        System.out.println("Enter " + size + " numbers: ");
//        int[] numbers = new int[size];
//        for(int i = 0; i < size; i++) {
//            numbers[i] = sc.nextInt();
//        }
//        double average = solution2(numbers);
//        System.out.println("Average number is: " + average);

        // 3
//        System.out.println("Enter the number: ");
//        int number = sc.nextInt();
//        if(solution3(number)) {
//            System.out.println(number + " is prime number.");
//        } else {
//            System.out.println(number + " is composite number.");
//        }

        // 4
        System.out.println("Enter the number: ");
        int number = sc.nextInt();
        int factorial = solution4(number);
        System.out.println("Factorial of the number " + number + " = " + factorial);

    }
    public static int solution1(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }
    public static double solution2(int[] array) {
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return sum / array.length;
    }
    public static boolean solution3(int number) {
        if(number < 1) {
            return false;
        }
        for(int i = 2; i < Math.sqrt(number); i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static int solution4(int number) {
        if(number == 1) {
            return 1;
        }
        return number * solution4(number - 1);
    }
}