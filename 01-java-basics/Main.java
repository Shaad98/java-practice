import java.util.*;
import java.io.*;

public class Main {

    // ==========================================================
    // 4. METHODS / FUNCTIONS
    // ==========================================================

    /**
     * Normal method that returns the sum of two integers.
     */
    public static int addTwoInt(int a, int b) {
        return a + b;
    }

    // ==========================================================
    // 5. VARIABLE ARGUMENTS (Varargs)
    // ==========================================================

    /**
     * Accepts any number of integers.
     */

    public static int sumAll(int... arr) {

        // Traditional way

        /*
        int sum = 0;

        for (int num : arr) {
            sum += num;
        }

        return sum;
        */

        // Using Stream API

        return Arrays.stream(arr).sum();
    }

    // ==========================================================
    // 6. METHOD OVERLOADING
    // ==========================================================

    public static void greet() {
        System.out.println("Good Morning!");
    }

    public static void greet(String name) {
        System.out.println("Hello, " + name);
    }

    /*
     * NOTE:
     *
     * Method overloading DOES NOT consider return type.
     *
     * The following method will produce a compile-time error.
     */

    /*
    public static String greet(String name) {
        return "Hello " + name;
    }
    */

    // ==========================================================
    // MAIN METHOD
    // ==========================================================

    public static void main(String[] args) throws IOException {

        // ======================================================
        // 1. DATA TYPES
        // ======================================================

        /*
        int age = 22;
        short year = 2025;
        byte value = 120;

        long population = 8500000000L;

        float percentage = 95.50f;
        double salary = 150000.75;

        boolean isJavaFun = true;

        char grade = 'A';

        String name = "Shaad Bangi";

        System.out.println(age);
        System.out.println(year);
        System.out.println(value);
        System.out.println(population);
        System.out.println(percentage);
        System.out.println(salary);
        System.out.println(isJavaFun);
        System.out.println(grade);
        System.out.println(name);
        */

        // ======================================================
        // 2. TAKING INPUT USING SCANNER
        // ======================================================

        /*
        Scanner sc = new Scanner(System.in);

        int intValue = sc.nextInt();

        float floatValue = sc.nextFloat();

        double doubleValue = sc.nextDouble();

        short shortValue = sc.nextShort();

        byte byteValue = sc.nextByte();

        long longValue = sc.nextLong();

        String word = sc.next();

        // Remove newline left in buffer
        sc.nextLine();

        String sentence = sc.nextLine();

        char character = sc.next().charAt(0);

        System.out.println(intValue);
        System.out.println(floatValue);
        System.out.println(doubleValue);
        System.out.println(shortValue);
        System.out.println(byteValue);
        System.out.println(longValue);
        System.out.println(word);
        System.out.println(sentence);
        System.out.println(character);

        sc.close();
        */

        /*
         * IMPORTANT NOTE
         *
         * Do not use Scanner and BufferedReader together on
         * System.in in the same program.
         *
         * Closing Scanner also closes System.in.
         */

        // ======================================================
        // 3. TAKING INPUT USING BUFFEREDREADER
        // ======================================================

        /*
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int number = Integer.parseInt(line);

        float decimal = Float.parseFloat(br.readLine());

        double dbl = Double.parseDouble(br.readLine());

        long lng = Long.parseLong(br.readLine());

        String text = br.readLine();

        char ch = (char) br.read();

        // Remove remaining newline
        br.readLine();

        String anotherLine = br.readLine();

        System.out.println(number);
        System.out.println(decimal);
        System.out.println(dbl);
        System.out.println(lng);
        System.out.println(text);
        System.out.println(ch);
        System.out.println(anotherLine);
        */

        // ======================================================
        // 4. METHOD CALLS
        // ======================================================

        /*
        System.out.println(addTwoInt(10, 20));

        System.out.println(sumAll(10, 20, 30, 40, 50));

        greet();

        greet("Shaad");
        */
    }
}