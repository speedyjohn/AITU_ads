package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int size, number, a, b, n, k;
        int[] numbers;
        String s;
        String incorrectInput = """
                =============================================
                Incorrect input.
                =============================================
                """;
        System.out.println("""
                Enter 0 if you want to quit the program
                Programs:
                1: Find the minimum value of the array
                2: Find the average value of the array
                3: Check whether number prime or nor
                4: Find n!
                5: Find n-th number of the Fibonacci sequence
                6: Raise a number to a certain degree
                7: Reverse the sequence
                8: Check whether string is all consist of digits or not
                9: Find binomial coefficient for certain numbers
                10: Find GCD for certain numbers
                """);
        while(true) {
            try{
                System.out.println("\n=============================================");
                System.out.println("Enter the number of the problem you want to solve(1-10): ");
                System.out.println("=============================================\n");
                int task = sc.nextInt();
                if(task == 0) {
                    break;
                }
                switch(task) {
                    case 1:
                        System.out.println("Enter length of the array: ");
                        size = sc.nextInt();
                        System.out.println("Enter " + size + " numbers: ");
                        numbers = new int[size];
                        for(int i = 0; i < size; i++) {
                            numbers[i] = sc.nextInt();
                        }
                        int min = solution1(numbers);
                        System.out.println("The minimum value is: " + min);
                        break;
                    case 2:
                        System.out.println("Enter length of the array: ");
                        size = sc.nextInt();
                        System.out.println("Enter " + size + " numbers: ");
                        numbers = new int[size];
                        for(int i = 0; i < size; i++) {
                            numbers[i] = sc.nextInt();
                        }
                        double average = solution2(numbers);
                        System.out.println("Average number is: " + average);
                        break;
                    case 3:
                        System.out.println("Enter the number: ");
                        number = sc.nextInt();
                        if(solution3(number)) {
                            System.out.println(number + " is prime number.");
                        } else {
                            System.out.println(number + " is composite number.");
                        }
                        break;
                    case 4:
                        System.out.println("Enter the number: ");
                        number = sc.nextInt();
                        int factorial = solution4(number);
                        System.out.println("Factorial of the number " + number + " = " + factorial);
                        break;
                    case 5:
                        System.out.println("Enter the number: ");
                        number = sc.nextInt();
                        int fibonacci = solution5(number);
                        System.out.println("n-th number in Fibonacci sequence is " + fibonacci);
                        break;
                    case 6:
                        System.out.println("Enter the number and the degree:");
                        number = sc.nextInt();
                        int degree = sc.nextInt();
                        int numberInPow = solution6(number, degree);
                        System.out.println(number + "to the power " + degree + " = " + numberInPow);
                        break;
                    case 7:
                        System.out.println("Enter length of the sequence: ");
                        number = sc.nextInt();
                        System.out.println("Enter " + number + " numbers: ");
                        solution7(number);
                        break;
                    case 8:
                        System.out.println("Enter the string: ");
                        s = sc.nextLine();
                        if(solution8(s, 0)) {
                            System.out.println("String is all consist of digits.");
                        } else {
                            System.out.println("String is not all consist of digits.");
                        }
                        break;
                    case 9:
                        System.out.println("Enter the numbers n and k: ");
                        n = sc.nextInt();
                        k = sc.nextInt();
                        int coefficient = solution9(n, k);
                        System.out.println("Binomial coefficient for the given numbers " + coefficient);
                        break;
                    case 10:
                        System.out.println("Enter the numbers: ");
                        a = sc.nextInt();
                        b = sc.nextInt();
                        System.out.println(solution10(a, b));
                        break;
                    default:
                        System.out.println(incorrectInput);
                        break;
                }
            } catch(InputMismatchException e) {
                System.out.println(incorrectInput);
                sc.nextLine();
            }
        }
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
    public static int solution5(int number) {
        if(number == 0) {
            return 0;
        }
        if(number == 1) {
            return 1;
        }
        return solution5(number - 1) + solution5(number - 2);
    }
    public static int solution6(int number, int degree) {
        if(degree == 0) {
            return 1;
        }
        return number * solution6(number, degree - 1);
    }
    public static void solution7(int number) {
        if(number == 0) {
            return;
        }
        int value = sc.nextInt();
        solution7(number - 1);
        System.out.print(value + " ");
    }
    public static boolean solution8(String s, int index) {
        if(index == s.length()) {
            return true;
        }
        if(!Character.isDigit(s.charAt(index))) {
            return false;
        }
        return solution8(s, index + 1);
    }
    public static int solution9(int n, int k) {
        if(k == 0 || k == n) {
            return 1;
        }
        return solution9(n - 1, k - 1) + solution9(n - 1, k );
    }

    public static int solution10(int a, int b) {
        if(a < b) {
            int x = a;
            a = b;
            b = x;
        }
        if(a % b == 0) {
            return b;
        }
        return solution10(b, a % b);
    }
}