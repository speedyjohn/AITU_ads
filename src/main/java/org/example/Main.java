package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1
        System.out.println("Enter length of the array: ");
        int size = sc.nextInt();

        System.out.println("Enter " + size + " numbers: ");
        int[] numbers = new int[size];
        for(int i = 0; i < size; i++) {
            numbers[i] = sc.nextInt();
        }

        int min = solution1(numbers);
        System.out.println("The minimum value is: " + min);
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
}