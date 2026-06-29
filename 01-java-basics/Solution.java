import java.util.*;

public class Solution {

    // Returning Array

    // public int[] getArray(){
    //     return new int[]{1,2,3,4,5};
    // }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1 :: Conditional Statements

        // if-else

        System.out.print("Enter your age : ");
        int age = sc.nextInt();

        if (age > 18) {
            System.out.println("You can apply for Driving License");
        } else {
            System.out.println("You can't apply for Driving License");
        }

        // if-else ladder

        System.out.print("Enter your percentage : ");
        float percentage = sc.nextFloat();

        if (percentage >= 0 && percentage < 35) {
            System.out.println("You are failed!");
        } else if (percentage >= 35 && percentage < 50) {
            System.out.println("You are average Student!");
        } else if (percentage >= 50 && percentage < 90) {
            System.out.println("You are good student!");
        } else if (percentage >= 90 && percentage <= 100) {
            System.out.println("You are excellent student!");
        } else {
            System.out.println("You entered wrong percentage!");
        }

        System.out.print("Enter any value between 1-3 : ");
        int value = sc.nextInt();

        // Switch Case
        switch (value) {
            case 1:
                System.out.println("Value is 1");
                break;
            case 2:
                System.out.println("Value is 2");
                break;
            case 3:
                System.out.println("Value is 3");
                break;
            default:
                System.out.println("Value is " + value);
                break;
        }

        // Enhanced Switch Case
        // No need to write break

        switch (value) {
            case 1 -> {
                System.out.println("Value is 1");
            }
            case 2 -> {
                System.out.println("Value is 2");
            }
            default -> {
                System.out.println("Value is " + value);
            }
        }

        // 2 :: Loops

        // For Loop
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        int i = 0;

        // While Loop
        while (i < 10) {
            System.out.println(i);
            i++;
        }

        // Do While Loop
        do {
            System.out.println("Hello World!");
        } while (false);

        // ==========================================================
        // Arrays
        // ==========================================================

        // Array Creation

        int[] arr = {1, 2, 3, 4, 5};

        // Another Way
        // int[] arr2 = new int[5];

        // For Each Loop

        for (int j : arr) {
            System.out.println(j);
        }

        // Jagged Array

        int[][] jaggedArray = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9},
                {10}
        };

        System.out.println("\nJagged Array:");

        for (int row = 0; row < jaggedArray.length; row++) {

            for (int col = 0; col < jaggedArray[row].length; col++) {

                System.out.print(jaggedArray[row][col] + " ");
            }

            System.out.println();
        }

        // ==========================================================
        // String Methods
        // ==========================================================

        String name = "Shaad Bangi";

        System.out.println(name.toUpperCase());
        System.out.println(name.toLowerCase());

        System.out.println(Arrays.toString(name.toCharArray()));

        System.out.println(name.charAt(3));

        System.out.println(name.indexOf("a"));
        System.out.println(name.lastIndexOf("a"));

        System.out.println(name.indexOf("a", 5));

        // Searches between index 5 (inclusive) and 7 (exclusive)
        // Returns -1 if not found

        System.out.println(name.indexOf("a", 5, 7));

        // Searches backward from index 5

        System.out.println(name.lastIndexOf("a", 5));

        System.out.println(name.startsWith("S"));

        System.out.println(name.endsWith("."));

        sc.close();
    }
}