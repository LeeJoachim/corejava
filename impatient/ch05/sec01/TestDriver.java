package ch05.sec01;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/* sec 01 : exception handling */

    // step 01 : throw demo
        // class ThrowDemo {
        //     public static int randInt(int low, int high) {
        //         if (low > high)
        //             throw new IllegalArgumentException(
        //                 "low should be <= high but low is "
        //                 + low + " and high is " + high); // 실행을 멈춘다. // 값은 반환하지 않는다. 제어는 예외 핸들러로 전달된다.
        

        //         return low + (int)(Math.random() * (high - low + 1));
        //     }
            
        //     public static void main(String[] args) {
        //         System.out.println("Generating a random number...");
        //         int r = randInt(10, 20);
        //         System.out.println("r = " + r);
        //         System.out.println("And another...");
        //         r = randInt(10, 5);
        //         System.out.println("r = " + r);
        //     }
        // }

    // step 02 : exception hierarchy
    // step 03 : checked exception
    // step 04 : exception catch : try catch

        // class TryCatchExample {
        //     public static void main(String[] args) {
        //         try {
        //             int[] a = new int[5];
        //             a[5] = 10;
        //         } catch (ArrayIndexOutOfBoundsException e) {
        //             System.out.println("Array index out of bounds"); // try 블록에서 예외가 발생하면 catch 블록이 실행된다.
        //         }
        //         System.out.println("After catch"); // try 블록에서 예외가 발생하면 catch 블록이 실행된다. 그리고 다음 문장이 실행된다.
        //     }
        // }

    // step 05 : exception catch : try with resources

        // class TryWithResourcesExample {

            // 이 코드에서 PrintWriter 클래스의 close() 메소드는 출력 스트림을 닫아서 자원을 반환합니다. 
            // 그러나 만약 PrintWriter 객체 생성 중 예외가 발생한다면 PrintWriter 객체는 생성되지 않으므로 close() 메소드를 호출할 수 없게 됩니다. 

            // public static void main(String[] args) {
            //     ArrayList<String> list = new ArrayList<>();
            //     PrintWriter out = new PrintWriter("output.txt");
            //     for (String string : list) {
            //         out.println(string.toLowerCase());
            //     }
            //     out.close(); // 예외를 던지면 close()가 호출되지 않는다.
                
            // }

            // try-with-resources 문을 사용하면 이런 문제를 해결할 수 있습니다.

            // try-with-resources 문을 사용하여 PrintWriter 객체를 생성하면, 이 객체는 try 블록 안에서 생성되고 자동으로 초기화됩니다. 
            // 그리고 try 블록을 빠져나갈 때 자동으로 close() 메소드가 호출됩니다. 
            // 이렇게 try-with-resources 문을 사용하면, 명시적으로 close() 메소드를 호출할 필요가 없으며 예외가 발생하더라도 출력 스트림이 자동으로 닫히므로 안전하게 자원을 반환할 수 있습니다.

            // 즉, try-with-resources 문은 자동으로 자원을 해제해주는 기능을 제공하며, AutoCloseable 인터페이스를 구현하는 객체를 사용할 수 있습니다. 
            // PrintWriter 클래스도 AutoCloseable 인터페이스를 구현하고 있으므로, try-with-resources 문을 사용하여 PrintWriter 객체를 생성하면 자원을 안전하게 해제할 수 있습니다.
            
            // public static void main(String[] args) {
            //     ArrayList<String> list = new ArrayList<>();
            //     list.add("Hello");
            //     list.add("World");

            //     try (PrintWriter out = new PrintWriter("output.txt")) {
            //         for (String string : list) {
            //             out.println(string.toLowerCase());
            //         }
            //     } catch (FileNotFoundException e) {
            //         // TODO Auto-generated catch block
            //         e.printStackTrace();
            //     }
                
            // }
            
        // }

        // class TryWithResourcesDemo { 
        //     public static void print(Scanner in, PrintWriter out) { 
        //         try (in; out) { // 사실상 최종(final) 변수들
        //             while (in.hasNext()) 
        //                 out.println(in.next().toLowerCase());          
        //         }
        //     }
            
        //     public static void main(String[] args) throws IOException {
        //         List<String> lines = List.of("Mary had a little lamb. Its fleece was white as snow.".split(" "));
        //         try (PrintWriter out = new PrintWriter("output1.txt")) {
        //             for (String line : lines) {
        //                 out.println(line.toLowerCase());
        //             }
        //         }
        //         try (Scanner in = new Scanner(Paths.get("output.txt")); 
        //                 PrintWriter out = new PrintWriter("output2.txt")) { 
        //             while (in.hasNext())
        //                 out.println(in.next().toLowerCase());
        //         }
                
        //         PrintWriter out3 = new PrintWriter("output3.txt");
        //         try (out3) {
        //             for (String line : lines) {
        //                 out3.println(line.toLowerCase());
        //             }
        //         }                
        //     }
        // }

    // step 06 : finally 

        // order of priority : try > generate exception > catch > finally > exit
        // try - catch - finally : 보통은 finally에서 예외를 놓친다. try-with-resources 또는 try-catch 안에 try-finally를 중첩하자.

        // finally 절은 정상적으로든 예외가 일어나서든 try 블록에서 빠져나올 때 실행된다.
        // 어떤 예외가 일어나든, 동작을 수행한다.
        // finally 블록의 리턴문은 try 블록의 리턴문을 덮어쓴다. : 리턴문을 사용하지 말아야 한다.

        // finally 가 덮어쓰는 경우
        // class FinallyNotCompletingNormallyDemo {
        //     public static int parseInt(String number) {
        //         try {
        //             int n = Integer.parseInt(number);
        //             return n;
        //         } catch (NumberFormatException ex) {
        //             return 0;            
        //         } finally {
        //             return -1; // 실제로는 이 값이 반환된다.
        //         }
        //     }
            
        //     public static double parseDouble(String number) {
        //         try {
        //             double x = Double.parseDouble(number);
        //             return x;
        //         } 
        //         finally {
        //             throw new IllegalStateException(); // NumberFormatException을 가린다. // finally 블록에서 예외를 던지면, try 블록에서 발생한 예외는 무시된다.
        //         }
        //     }
            
        //     public static void main(String[] args) {
        //         System.out.println(parseInt("Fred"));
        //         System.out.println(parseInt("123"));
        //         try {
        //             System.out.println(parseDouble("Fred"));            
        //         } catch(Exception ex) {
        //             System.out.println("Caught " + ex.getClass().getName());
        //         }
        //         try {
        //             System.out.println(parseDouble("12.3"));            
        //         } catch(Exception ex) {
        //             System.out.println("Caught " + ex.getClass().getName());
        //         }
        //     }
        // }
        
        // 락을 사용하여 여러 스레드가 동시에 counter 변수를 증가시키는 예제
        // class TryFinallyDemo {
        //     public static Lock myLock = new ReentrantLock(); 
        //     private static int counter = 0; 

        //     public static void main(String[] args) throws InterruptedException{
        //         Thread[] threads = new Thread[2];
        //         for (int i = 0; i < threads.length; i++) {

        //             threads[i] = new Thread(() -> {
        //                 try {
        //                     for (int k = 1; k <= 1000; k++) {
        //                         myLock.lock(); // 이때, myLock.lock() 메서드로 락을 얻은 후에 
                                
        //                         try { // try-finally 블록을 사용하여 counter 변수를 증가시키고 
        //                             counter++; 
        //                             Thread.sleep(1); 
        //                         } finally {
        //                             myLock.unlock(); // myLock.unlock() 메서드로 락을 해제합니다.
        //                         }
        //                     }
        //                 } catch (InterruptedException ex) {
        //                     ex.printStackTrace(); 
        //                 }
        //             });

        //         }
        //         for (Thread t : threads) t.start(); // 스레드를 시작한다.
                
        //         // 다음과 같이 해보자: (1) 다음 줄의 주석을 해제한다.
        //         // threads[0].interrupt(); 
        //         // 프로그램을 실행한다. 무슨 일이 일어나는가? 그 이유는 무엇인가? 
        //             // 스레드 0이 Thread.sleep(1) 메서드를 호출하면서 InterruptedException을 던지게 되고, 이를 처리하기 위해 catch 블록이 실행됩니다.
        //             // catch 블록에서는 ex.printStackTrace() 메서드를 호출하여 예외 정보를 출력합니다.

        //         // (2) try {, } finally {, } 줄을 주석 처리한다.
        //         // 프로그램을 실행한다. 무슨 일이 일어나는가? 그 이유는 무엇인가?
        //             // 각 스레드에서 myLock.lock() 메서드를 호출한 후, try-finally 블록이 없기 때문에, myLock.unlock() 메서드가 호출되지 않습니다.
        //             // 따라서, ReentrantLock 클래스에서 사용하는 내부 변수들의 상태가 일관성이 없게 됩니다. 
        //             // 이러한 상황을 방지하기 위해, finally 블록을 사용하여 락을 해제하는 것이 좋습니다.
        //             // 따라서, try-finally 블록은 예외 발생 여부에 관계없이 락을 해제하고, 락을 해제하지 않을 경우 발생할 수 있는 문제를 예방하는 데 중요한 역할을 합니다.
            
        //         for (Thread t : threads) t.join(); // 스레드를 시작한 후, join() 메서드를 호출하여 모든 스레드가 종료될 때까지 대기하고, counter 변수의 값을 출력합니다.
        //         System.out.println(counter); 
        //     }
        // }
        


    // step 07 : record log
    // step 08 : uncaught exception
        // class DefaultUncaughtExceptionHandlerDemo {
        //     public static void main(String[] args) {
        //         Thread.setDefaultUncaughtExceptionHandler((thread, ex) -> { // 스레드에서 예외가 발생하면, 이 예외를 처리하는 핸들러를 지정할 수 있습니다.
        //             System.err.println(ex.getMessage()); // 예외 메시지를 출력합니다.
        //             System.err.println("Goodbye, cruel world!"); // "Goodbye, cruel world!" 메시지를 출력합니다.
        //         });
        //         System.out.println(1 / 0); // 0으로 나누어 예외를 발생시킵니다.
        //     }
        // }
    

        // stack trace : 예외가 발생한 위치를 추적하는 정보
            // class StackTraceDemo {
            //     public static void bad() {
            //         System.out.println(1 / 0);
            //     }
                
            //     public static void goodOrBad(boolean ok) {
            //         if (ok) good(); else bad();
            //     }
                
            //     public static void good() {
            //         StackWalker walker = StackWalker.getInstance();
            //         walker.forEach(frame -> System.err.println("Frame: " + frame));        
            //     }
                
            //     public static void main(String[] args) {
            //         try {
            //             goodOrBad(false);
            //         } catch (Exception ex) {
            //             ByteArrayOutputStream out = new ByteArrayOutputStream(); // 예외 정보를 저장할 바이트 배열 출력 스트림을 생성한다.
            //             ex.printStackTrace(new PrintStream(out)); // 예외 정보를 바이트 배열 출력 스트림에 출력한다. 
            //             String description = out.toString(); // 바이트 배열 출력 스트림에 저장된 예외 정보를 문자열로 변환한다.
            //             System.out.println("The stack trace in a string: " + description.replaceAll("\\s+",  " ")); // 문자열에 저장된 예외 정보를 출력한다.
            //         }
            //         goodOrBad(true);
            //     }
            // }
        // 

/**/

/* sec 02 : assertion */

    // public class TestDriver {
    //     public static void main(String[] args) {
    //         double x = -1;
    //         // if (x <= 0) throw new IllegalArgumentException("x must be positive"); // 단정을 사용하지 않고 예외를 던진다.
    //         // 위의 조건문은 테스트를 마친 후에도 프로그램에 남아서 실행을 느리게 한다.
    //         // 단정 메커니즘을 이용하면 테스트 중에만 검사를 하고, 제품용 코드에서는 자동으로 삭제되게 할 수 있다.
    //         // assert x <= 0 : "x must be positive"; // 단정을 사용한다.
    //         double y = Math.sqrt(x);
    //         System.out.println(y);
    //     }
    // }

    // 일반적으로 단정은 비활성화되어 있다.
    // 단정 오류를 확인하려면 단정을 활성화한 채로 실행해야 한다.

    // class AssertionDemo {
    //     public static double[] solveQuadraticEquation(double a, double b, double c) {
    //         double discriminant = b * b - 4 * a * c;
    //         assert discriminant >= 0;
    //         assert a != 0 : "a == 0; not a quadradic equation"; // 단정을 사용하여 a가 0이 아닌지 확인한다.
    //         double discrRoot = Math.sqrt(discriminant);
    //         return new double[] { 
    //                 (-b - discrRoot) / (2 * a),
    //                 (-b + discrRoot) / (2 * a)
    //         };
    //     }
        
    //     public static void main(String[] args) {
    //         try (Scanner in = new Scanner(System.in)) {
    //             System.out.println("Enter a b c (e.g. 0 2 1)");
    //             double a = in.nextDouble();
    //             double b = in.nextDouble();
    //             double c = in.nextDouble();
    //             System.out.println(Arrays.toString(solveQuadraticEquation(a, b, c)));
    //         }
    //     }
    // }

    // assertion example
        // class AssertionExample {
        //     public static void main(String[] args) {
        //         int x = 0;
        //         assert x == 1 : "x is not 1"; // 단정을 사용하여 x가 1인지 확인한다.
        //         assert x == 0 : "x is not 0"; // 단정을 사용하여 x가 0인지 확인한다.
        //         System.out.println("x is 0");
        //     }
        // }
/**/

/* sec 03 : logging */
    
    // logging : sysout을 사용하여 동작을 파악하는 행위를 대신하기 위하여 설계되었다.

    // class LoggingDemo {
    //     public static void main(String[] args) {
    //         // Logger.getGlobal().info("Starting program"); // 3월 09, 2023 6:56:51 오후 ch05.sec01.LoggingDemo main INFO: Starting program
    //         // Logger.getGlobal().setLevel(Level.OFF); // 로그를 출력하지 않도록 설정한다.
    //         // Logger.getGlobal().info("Global logger turned off"); // 출력되지 않는다.

    //         Logger logger = Logger.getLogger("com.horstmann.corejava");
    //         logger.fine("Global logger turned off"); // 출력되지 않는다.
    //         logger.setLevel(Level.FINE); // Level.FINE : 로그 레벨이 FINE 이상인 경우에만 출력된다.
    //         logger.fine("Set logger to fine"); // 출력되지 않는다.

    //             // 출력되지 않는 이유는, 프로그램에서 로그 메시지를 출력하는 핸들러를 설정하지 않았기 때문입니다. 
    //             // Logger 객체는 로그 메시지를 생성하고, 이 메시지를 출력하는 Handler 객체를 사용합니다. 
    //             // 따라서 Logger 객체는 로그 메시지를 생성할 뿐, 이 메시지를 출력하지는 않습니다.
    //             // 이러한 이유로, 로그 메시지를 출력하려면 Logger 객체에 적절한 Handler 객체를 설정하고, 해당 Handler 객체가 출력을 수행하도록 설정해주어야 합니다. 
    //             // 예를 들어, ConsoleHandler 객체를 사용하여 콘솔에 로그 메시지를 출력할 수 있습니다.

    //         logger.setUseParentHandlers(false); // 부모 핸들러를 사용하지 않도록 설정한다.
    //         logger.fine("this"); // 출력되지 않는다.

                    // Java 로깅에서 Logger 객체는 자신의 로그 메시지를 출력하는 Handler 객체를 가지고 있습니다. 
                    // 이 Handler 객체는 Logger 객체에 의해 직접 설정될 수 있지만, Handler 객체는 다른 Handler 객체를 부모로 가질 수도 있습니다. 
                    // 이때, Logger 객체는 자신의 Handler 객체로 설정된 Handler 객체부터 상위 Handler 객체까지의 계층 구조를 따라가며, 모든 Handler 객체에 로그 메시지를 전달합니다.

                    // 부모 Handler를 사용하지 않도록 설정한다는 것은, Logger 객체가 자신의 Handler 객체를 통해 로그 메시지를 출력하고, 부모 Handler를 거치지 않도록 설정하는 것입니다. 
                    // 이렇게 함으로써, Logger 객체가 상위 Handler 객체에 의해 처리되는 로그 메시지를 중복으로 출력하는 것을 방지할 수 있으며, 불필요한 리소스 소비를 줄일 수 있습니다.

                    // 하지만 부모 Handler를 사용하지 않도록 설정하면, Logger 객체가 상위 Handler 객체에 의해 처리되는 로그 메시지를 놓치게 되므로, 
                    // 이 경우 로그 메시지가 중요하다면 상위 Handler 객체까지 모두 처리할 수 있도록 Logger 객체를 구성해주어야 합니다.

    //         Handler handler = new ConsoleHandler(); // 콘솔 핸들러를 생성한다. 콘솔 핸들러는 로그를 콘솔에 출력한다. 
    //         handler.setLevel(Level.FINE); // 콘솔 핸들러의 로그 레벨을 설정한다. 
    //         logger.addHandler(handler); // 로거에 콘솔 핸들러를 추가한다. 
    //         logger.fine("Configured handler"); // 콘솔 핸들러가 로그를 출력한다.
    //     }
    // }

/**/
