package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        /**
         * Initialization of default variables and variables that can be used several times.
         */
        int size, number, a, b, n, k;
        int[] numbers;
        String s;
        double startTime, endTime, duration;

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
        /**
         * While cycle to be able to rerun the program and solve different tasks.
         * Try-catch construction to handle incorrect input.
         * Switch case to choose problem to solve including default to handle incorrect number of problem.
         */
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
                    /**
                     * The start time is measured after receiving input from the user,
                     * because otherwise the system counts the time spent by the user entering data.
                     */
                    case 1:
                        System.out.println("Enter length of the array: ");
                        size = sc.nextInt();
                        System.out.println("Enter " + size + " numbers: ");
                        numbers = new int[size];
                        for(int i = 0; i < size; i++) {
                            numbers[i] = sc.nextInt();
                        }
                        startTime = System.nanoTime();
                        int min = minValue(numbers);
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                        System.out.println("The minimum value is: " + min);
                        System.out.println("Time taken: " + duration + " milliseconds");
                        break;
                    case 2:
                        System.out.println("Enter length of the array: ");
                        size = sc.nextInt();
                        System.out.println("Enter " + size + " numbers: ");
                        numbers = new int[size];
                        for(int i = 0; i < size; i++) {
                            numbers[i] = sc.nextInt();
                        }
                        startTime = System.nanoTime();
                        double average = averageValue(numbers);
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                        System.out.println("Average number is: " + average);
                        System.out.println("Time taken: " + duration + " milliseconds");
                        break;
                    case 3:
                        System.out.println("Enter the number: ");
                        number = sc.nextInt();
                        startTime = System.nanoTime();
                        if(isPrime(number)) {
                            System.out.println(number + " is prime number.");
                        } else {
                            System.out.println(number + " is composite number.");
                        }
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                        System.out.println("Time taken: " + duration + " milliseconds");
                        break;
                    case 4:
                        System.out.println("Enter the number: ");
                        number = sc.nextInt();
                        startTime = System.nanoTime();
                        int fact = factorial(number);
                        System.out.println("Factorial of the number " + number + " = " + fact);
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                        System.out.println("Time taken: " + duration + " milliseconds");
                        break;
                    case 5:
                        System.out.println("Enter the number: ");
                        number = sc.nextInt();
                        startTime = System.nanoTime();
                        int fibonacci = fibonacciSequence(number);
                        System.out.println("n-th number in Fibonacci sequence is " + fibonacci);
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                        System.out.println("Time taken: " + duration + " milliseconds");
                        break;
                    case 6:
                        System.out.println("Enter the number and the degree:");
                        number = sc.nextInt();
                        int degree = sc.nextInt();
                        startTime = System.nanoTime();
                        int numberInDegree = pow(number, degree);
                        System.out.println(number + " to the power " + degree + " = " + numberInDegree);
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                        System.out.println("Time taken: " + duration + " milliseconds");
                        break;
                    case 7:
                        System.out.println("Enter length of the sequence: ");
                        number = sc.nextInt();
                        startTime = System.nanoTime(); // We are taking input sequence inside method, so time taken includes time to input sequence
                        System.out.println("Enter " + number + " numbers: ");
                        reverseSequence(number);
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                        System.out.println("Time taken: " + duration + " milliseconds");
                        break;
                    case 8:
                        System.out.println("Enter the string: ");
                        sc.nextLine(); // Without this line, s takes the value 8(input value to select the problem)
                        s = sc.nextLine();
                        startTime = System.nanoTime();
                        if(isDigit(s, 0)) {
                            System.out.println("String is all consist of digits.");
                        } else {
                            System.out.println("String is not all consist of digits.");
                        }
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                        System.out.println("Time taken: " + duration + " milliseconds");
                        break;
                    case 9:
                        System.out.println("Enter the numbers n and k: ");
                        n = sc.nextInt();
                        k = sc.nextInt();
                        startTime = System.nanoTime();
                        int coefficient = binomialCoefficient(n, k);
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                        System.out.println("Binomial coefficient for the given numbers " + coefficient);
                        System.out.println("Time taken: " + duration + " milliseconds");
                        break;
                    case 10:
                        System.out.println("Enter the numbers: ");
                        a = sc.nextInt();
                        b = sc.nextInt();
                        startTime = System.nanoTime();
                        System.out.println(gcd(a, b));
                        endTime = System.nanoTime();
                        duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                        System.out.println("Time taken: " + duration + " milliseconds");
                        break;
                    default:
                        // If input number is not correct
                        System.out.println(incorrectInput);
                        break;
                }
            } catch(InputMismatchException e) {
                // If input is not correct
                System.out.println(incorrectInput);
                sc.nextLine();
            }
        }
    }
    /**
     * This method returns the smallest number from an array.
     * It uses a for cycle.
     * Time complexity: O(n), where n is length of input array.
     * For cycle iterates through the array and searches the smallest number,
     * resulting in linear time complexity.
     * @param array The array of integers where we need to find smallest.
     * @return min The smallest integer from the array
     */
    public static int minValue(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }
    /**
     * This method returns average number from the array.
     * It uses a for cycle.
     * Time complexity: O(n), where n length of input array.
     * For cycle iterating through the array and calculating sum of all elements,
     * after this, algorithm divides the sum by length of an array and return average.
     * The result is linear time complexity.
     * @param array The array of integers where we need to find average.
     * @return average The average number from the given array.
     */
    public static double averageValue(int[] array) {
        int sum = 0;
        for (int i: array) {
            sum += i;
        }
        double average = (double) sum / array.length;

        return average;
    }

    /**
     * This method returns whether the number is prime or not.
     * It uses a for cycle.
     * Time complexity: O(sqrt(n)), where n is the input number.
     * For cycle iterating through the numbers between 2 and square root of n,
     * resulting in square root time complexity.
     * @param number The number to check for primary.
     * @return boolean True if number is prime, false if not.
     */
    public static boolean isPrime(int number) {
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

    /**
     * This method returns the factorial of the input number.
     * It uses recursion.
     * Time complexity: O(n), where n is the input number.
     * Using recursion, the method multiplies all numbers from n to 1 by calling itself with the parameter n - 1.
     * The result is linear time complexity.
     * @param number The number whose factorial is to be found.
     * @return factorial The factorial of the input number.
     */
    public static int factorial(int number) {
        if(number == 1) { // Base case
            return 1;
        }

        return number * factorial(number - 1);
    }

    /**
     * This method calculates a number in the Fibonacci sequence at a given position.
     * It uses recursion to calculate the previous two numbers until it reaches the base cases.
     * Time complexity: O(2^n), where n is the position in the Fibonacci sequence.
     * The method uses a binary recursion, which results in an exponential number of calls.
     * The result is exponential time complexity due to the number of recursive calls doubling with each increase in input size.
     * @param number The position in the Fibonacci sequence to find the corresponding number for.
     * @return fibonacciNumber The number in the Fibonacci sequence at the given position.
     */
    public static int fibonacciSequence(int number) {
        if(number == 0) { // Base case
            return 0;
        }
        if(number == 1) { // Base case
            return 1;
        }

        return fibonacciSequence(number - 1) + fibonacciSequence(number - 2);
    }

    /**
     * This method calculates the power of a given number raised to a specified degree using recursion.
     * The method recursively multiplies the number by itself degree times until the base case is reached.
     * Time complexity: O(n), where n is the exponent to which the number is raised.
     * The method makes a number of recursive calls equal to the degree, resulting in linear time complexity.
     * @param number The base number to be raised to a power.
     * @param degree The exponent to which the base number is raised.
     * @return The result of raising the base number to the given power.
     */
    public static int pow(int number, int degree) {
        if(degree == 0) { // Base case
            return 1;
        }

        return number * pow(number, degree - 1);
    }

    /**
     * This method reads a sequence of integers from standard input and prints them in reverse order.
     * It uses recursion to read the numbers and then prints them from the last one to the first one as the recursive calls return.
     * Time complexity: O(n), where n is the number of integers to read. Each recursive call processes one number.
     * The recursion depth is equal to the number of integers, resulting in linear time complexity.
     * @param number The count of integers to read from standard input.
     */
    public static void reverseSequence(int number) {
        if(number == 0) { // Base case
            return;
        }
        int value = sc.nextInt();
        reverseSequence(number - 1);

        System.out.print(value + " ");
    }

    /**
     * This method checks if all characters in a string are digits using recursion.
     * It starts from the first character and checks each one; if a non-digit is found, it returns false.
     * Time complexity: O(n), where n is the length of the string. Each recursive call processes one character of the string.
     * The method makes a number of recursive calls equal to the length of the string, resulting in linear time complexity.
     * @param s The string to check for digit-only characters.
     * @param index The current index being checked in the recursive call.
     * @return boolean True if all characters are digits, false otherwise.
     */
    public static boolean isDigit(String s, int index) {
        if(index == s.length()) { // Base case
            return true;
        }
        if(!Character.isDigit(s.charAt(index))) {
            return false;
        }

        return isDigit(s, index + 1);
    }

    /**
     * This method calculates the binomial coefficient (n choose k), which represents the number of ways to choose k elements from a set of n elements without regard to the order.
     * It uses a recursive approach based on the recurrence relation C(n, k) = C(n-1, k-1) + C(n-1, k).
     * Time complexity: O(n*k), where n is the total number of items and k is the number of items to choose.
     * The number of recursive calls expands as it depends on the values of n and k, leading to a total of n*k calls in the worst case.
     * @param n The total number of items.
     * @param k The number of items to choose.
     * @return The binomial coefficient representing the number of possible combinations.
     */
    public static int binomialCoefficient(int n, int k) {
        if(k == 0 || k == n) { // base case
            return 1;
        }

        return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k );
    }

    /**
     * This method calculates the greatest common divisor (GCD) of two integers using the Euclidean algorithm.
     * It recursively applies the operation gcd(b, a % b) until a % b is zero, at which point b is the GCD.
     * Time complexity: O(log(min(a, b))), where a and b are the input integers.
     * The recursive calls continue until the remainder is 0, with the number of calls logarithmically decreasing with respect to the smaller number.
     * @param a The first integer to find the GCD for.
     * @param b The second integer to find the GCD for.
     * @return The greatest common divisor of a and b.
     */
    public static int gcd(int a, int b) {
        if(a < b) { // Checking if a > b and replace them if needed.
            int x = a;
            a = b;
            b = x;
        }
        if(a % b == 0) { // Base case
            return b;
        }

        return gcd(b, a % b);
    }
}