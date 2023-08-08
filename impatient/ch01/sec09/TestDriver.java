package ch01.sec09;

import java.util.Arrays;
import java.util.Scanner;
/* sec 09. disassemble function */

    // average
    // class TestDriver {
    //     public static double average(double x, double y) {
    //         double sum = x + y;
    //         return sum / 2;
    //     }
    //     public static void main(String[] args) {
    //         System.out.print("Enter two numbers: ");
    //         Scanner in = new Scanner(System.in);
    //         double a = in.nextDouble();
    //         double b = in.nextDouble();
    //         double result = average(a, b);
    //         System.out.println("Average: " + result);
    //     }
    // }

    // array
    // public class TestDriver {
    //     public static void swap(int[] values, int i, int j) {
    //         int temp = values[i];
    //         values[i] = values[j];
    //         values[j] = temp;
    //     }
        
    //     public static int[] firstLast(int[] values) {
    //         if (values.length == 0) return new int[0]; // defensive
    //         else return new int[] { values[0], values[values.length - 1] };
    //     }
        
    //     public static void main(String[] args) {
    //         int[] fibs = { 1, 1, 2, 3, 5, 8, 11, 13 };
    //         swap(fibs, 2, fibs.length - 2); // [1, 1, 11, 3, 5, 8, 2, 13]
    //         System.out.println(Arrays.toString(fibs));
    //         System.out.println(Arrays.toString(firstLast(fibs)));        
    //     }
    // }

    // 가변 인수(varargs) : ...을 붙여서 가변 인수 매개변수를 선언한다.
    // public class TestDriver {
    //     public static double average(double... values) {
    //         double sum = 0;
    //         for (double v : values) sum += v;
    //         return values.length == 0 ? 0 : sum / values.length;
    //     }    
        
    //     public static double max(double first, double... rest) {
    //         double result = first;
    //         for (double v : rest) result = Math.max(v, result);
    //         return result;
    //     }
        
    //     public static void main(String[] args) {
    //         int n = 42;
    //         System.out.printf("%d\n", n);
    //         System.out.printf("%d %s\n", n, "widgets");
            
    //         double[] scores = { 3, 4.5, 10, 0 };
    //         double avg = average(scores);
    //         System.out.println(avg);
    //         double largest = max(3, 4.5, 10, 0);
    //         System.out.println(largest);
    //             // average()는 0을 반환하지만 max()는 컴파일되지 않는다.
    //     }
    // }