package ch05.sec01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

// 1. 부동소수점 수가 저장된 파일을 읽는 public ArrayList<Double> readValues(String filename) throws… 메서드를 작성하라. 
// 파일을 열 수 없거나 입력 중 일부가 부동소수점 수가 아니면 적절한 예외를 던져야 한다.

    // class FileParser {
    //     public ArrayList<Double> readValues(String filename) throws IOException {
    //         ArrayList<Double> values = new ArrayList<>();

    //         try (BufferedReader reader = new BufferedReader(new FileReader(filename))) { // try-with-resources : 자동으로 close() 호출
    //             String line;
    //             while ((line = reader.readLine()) != null) {
    //                 try {
    //                     double value = Double.parseDouble(line);
    //                     values.add(value);
    //                 } catch (NumberFormatException e) {
    //                     throw new IOException("Invalid value in file", e);
    //                 }
    //             }
    //         } catch (IOException e) {
    //             throw new IOException("Error reading file", e);
    //         }
    //         return values;
    //     }
    // }

    // class TestDriver {
    //     public static void main(String[] args) {
    //         FileParser parser = new FileParser();
    //         try {
    //             ArrayList<Double> values = parser.readValues("ch05/sec01/numbers.txt"); 
    //             System.out.println(values);
    //         } catch (IOException e) {
    //             System.out.println(e.getMessage());
    //         }
    //     }
    // }

// 2. 연습문제 1에서 만든 메서드를 호출해서 파일에 들어 있는 값의 합계를 반환하는 public double sumOfValues(String filename) throws… 메서드를 작성하라. 예외가 일어나면 호출한 쪽으로 전파해야 한다.
    // class FileParser {
    //     public double sumOfValues(String filename) throws IOException {
    //         ArrayList<Double> values = new ArrayList<>();

    //         try (BufferedReader reader = new BufferedReader(new FileReader(filename))) { // try-with-resources : 자동으로 close() 호출
    //             String line;
    //             while ((line = reader.readLine()) != null) {
    //                 try {
    //                     double value = Double.parseDouble(line);
    //                     values.add(value);
    //                 } catch (NumberFormatException e) {
    //                     throw new IOException("Invalid value in file", e);
    //                 }
    //             }
    //         } catch (IOException e) {
    //             throw new IOException("Error reading file", e);
    //         }

    //         double sum = 0;
    //         for (double value : values) {
    //             sum += value;
    //         }
    //         return sum;
    //     }
    // }
    // class TestDriver {
    //     public static void main(String[] args) {
    //         FileParser parser = new FileParser();
    //         try {
    //             double sum = parser.sumOfValues("ch05/sec01/numbers.txt"); 
    //             System.out.println(sum);
    //         } catch (IOException e) {
    //             System.out.println(e.getMessage());
    //         }
    //     }
    // }

// 3. 연습문제 2에서 만든 메서드를 호출해 나온 결과를 출력하는 프로그램을 작성하라. 예외가 일어나면 잡아서 사용자에게 오류 상황을 피드백하라.
    // same above
// 4. 연습문제 1~3을 반복하되, 이번에는 예외를 사용하지 말아야 한다. 그 대신 readValues와 sumOfValues에서 어떤 종류의 오류 코드를 반환하게 만들어라.
// 5. 5.1.5 try-with-resources 문에서 다룬 Scanner와 PrintWriter를 이용하는 코드를 포함하는 메서드를 구현하라. try-with-resources 문은 사용하지 말고 catch 절을 이용하라. 
// 두 객체를 올바르게 생성했다면 확실히 닫아야 한다. 그리고 다음 상황을 고려해야 한다.

    // • Scanner 생성자는 예외를 던진다.

    // • PrintWriter 생성자는 예외를 던진다.

    // • hasNext, next, println은 예외를 던진다.

    // • out.close()는 예외를 던진다.

    // • in.close()는 예외를 던진다.

    // class ScannerPrintWriterExample {
        
    //     public static void readWriteFile(String inputFile, String outputFile) {
    //         Scanner in = null;
    //         PrintWriter out = null;
    //         try {
    //             in = new Scanner(new File(inputFile)); 
    //             out = new PrintWriter(outputFile); 
    //             while (in.hasNext()) { // 파일에 더 이상 읽을 내용이 없을 때까지 반복
    //                 double num;
    //                 try {
    //                     num = Double.parseDouble(in.next());
    //                 } catch (NumberFormatException e) { // 입력된 내용이 부동소수점 수가 아니면
    //                     System.out.println("Invalid input format");
    //                     return;
    //                 }
    //                 out.println(num * 2); // 입력된 숫자를 2배로 곱해서 출력
    //             }
    //         } catch (FileNotFoundException e) {
    //             System.out.println("File not found");
    //             return;
    //         } finally { // 예외가 발생하든 안하든 무조건 실행
    //             in.close();
    //             out.close();
    //         }
    //     }
        
    //     public static void main(String[] args) {
    //         readWriteFile("ch05/sec01/input.txt", "ch05/sec01/output.txt");
    //     }
    // }

// try-with-resources 문을 이용하면 다음과 같이 간단하게 구현할 수 있다.
    // class ScannerPrintWriterDemo {
    //     public static void readFileAndWriteDouble(String inputFileName, String outputFileName) {
    //         try (Scanner in = new Scanner(new FileReader(inputFileName));
    //             PrintWriter out = new PrintWriter(outputFileName)) { // try-with-resources 문
    //             while (in.hasNext()) {
    //                 if (in.hasNextDouble()) {
    //                     double d = in.nextDouble();
    //                     out.printf("%f%n", d);
    //                 } else {
    //                     in.next();
    //                 }
    //             }
    //         } catch (IOException e) {
    //             e.printStackTrace();
    //         }
    //     }

    //     public static void main(String[] args) {
    //         String inputFileName = "ch05/sec01/input.txt";
    //         String outputFileName = "ch05/sec01/output.txt";
    //         readFileAndWriteDouble(inputFileName, outputFileName);
    //     }
    // }

// 6. 5.1.6 finally 절에는 catch와 finally 절이 있는 잘못된 try 문 예제가 있다. 
// (a) finally 절에서 예외를 잡는 방법, 
// (b) try/finally 문을 포함하는 try/catch 문, 
// (c) catch 절을 이용하는 try-with-resources 문으로 코드를 고쳐라.

// 7. 다음 코드를 보자.


    // try (Scanner in = new Scanner(Paths.get("/usr/share/dict/words")); // try-with-resources 문

    //         PrintWriter out = new PrintWriter(outputFile)) {

    //     while (in.hasNext())

    //         out.println(in.next().toLowerCase());

    // }

    // 위의 코드가 다음 코드보다 나은 이유를 설명하라.

    // Scanner in = new Scanner(Paths.get("/usr/share/dict/words"));

    // PrintWriter out = new PrintWriter(outputFile);

    // try (in; out) { // try-with-resources with semicolon

    //     while (in.hasNext())

    //         out.println(in.next().toLowerCase());

    // }

    // try-with-resources with semicolon 문은 자원을 자동으로 닫아주지 않습니다. 
    // 따라서 try-with-resources with semicolon 문을 사용하면 finally 절에서 자원을 닫는 코드를 따로 작성해야 합니다.



// 8. 이 문제를 풀려면 java.util.Scanner 클래스의 소스 코드를 읽어야 한다. 
// Scanner를 사용할 때 입력이 잘못되면 Scanner 클래스는 해당 예외를 잡아내고 입력 소스에서 읽기를 중단한다. 
// 스캐너가 닫힐 때 무슨 일이 일어날까? 그리고 입력 소스를 닫는 도중에 예외가 일어날까? 
// 이 동작을 try-with-resources 문에서 억제된 예외를 다루는 방법과 비교하라.

    // Scanner 클래스의 close() 메소드를 호출하면 스캐너가 닫히고 입력 소스도 닫힙니다. 
    // 입력 소스를 닫는 도중에 예외가 발생하면 해당 예외가 발생합니다. 
    // try-with-resources 문에서는 자동으로 리소스를 닫아주기 때문에 명시적으로 close() 메소드를 호출할 필요가 없습니다. 
    // 이 경우 억제된 예외는 addSuppressed() 메소드로 추가되고 getSuppressed() 메소드로 검색할 수 있습니다.

// 9. try-with-resources 문에서 ReentrantLock을 사용할 수 있도록 헬퍼 메서드를 설계하라. 
// 이 메서드는 lock을 호출하고, AutoCloseable을 반환해야 한다. 
// 또 해당 AutoCloseable은 close 메서드에서 unlock을 호출하고 예외는 던지지 않아야 한다.
    // class TestDriver {
    //     public static void main(String[] args) {
    //         ReentrantLock myLock = new ReentrantLock();
    //         try (AutoCloseable ignored = lock(myLock)) { // 블록을 빠져나가면 자동으로 unlock()이 호출됨
    //             // lock을 사용하는 코드 블록 : critical section
    //         } catch (Exception e) { 
    //             // 예외 처리
    //             e.printStackTrace();
    //         }
    //     }
    //     public static AutoCloseable lock(ReentrantLock lock) {
    //         lock.lock(); 
    //         return lock::unlock;
    //     }
    // }


// 10. Scanner와 PrintWriter 클래스의 메서드는 초보 프로그래머도 쉽게 사용하게 하려고 검사 예외를 던지지 않는다. 
// 읽기나 쓰기 도중에 오류가 일어났는지 여부를 어떻게 알 수 있을까? 생성자는 검사 예외를 던질 수 있다는 점에 유의한다. 
// 이 점이 초보자도 사용하기 쉽게 만든다는 목표를 저해하는 이유를 설명하라.

    // Scanner와 PrintWriter 클래스의 메서드는 검사 예외를 던지지 않기 때문에 읽기나 쓰기 도중에 오류가 발생했는지 여부를 직접 확인하기 어렵습니다. 
    // 하지만 이들 클래스의 생성자는 검사 예외를 던질 수 있습니다. 
    // 따라서 파일을 열거나 네트워크 연결을 설정하는 등의 작업에서 오류가 발생하면 생성자에서 예외가 발생하여 해당 오류를 알 수 있습니다.

    // 이러한 설계 방식은 초보 프로그래머가 쉽게 사용할 수 있도록 하는 목표와 일부 충돌할 수 있습니다. 
    // 검사 예외를 처리하는 것은 프로그래밍 초보자에게 어려울 수 있기 때문입니다. 
    // 따라서 이들 클래스의 생성자에서 검사 예외가 발생하면 초보 프로그래머는 이를 처리하는 방법을 찾아야 합니다.

// 11. factorial 메서드를 재귀 형태로 작성하라. 
// 이 메서드에서는 값을 반환하기 전에 모든 스택 프레임을 출력해야 한다. 
// 종류에 관계없이 예외 객체를 생성해(그렇지만 던지지는 말아야 한다) 5.1.8 미처리 예외와 스택 추적에서 설명한 스택 추적을 얻어라.

    // class TestDriver {

    //     public static int factorial(int n) {
    //         if (n == 0) {
    //             return 1;
    //         } else {
    //             Exception e = new Exception();
    //             StackTraceElement[] frames = e.getStackTrace();
    //             for (StackTraceElement frame : frames) {
    //                 System.out.println(frame);
    //             }
    //             int result = n * factorial(n - 1);
    //             return result;
    //         }
    //     }

    //     public static void main(String[] args) {
    //         System.out.println(factorial(5));
    //     }

    // }


// 12. Objects.requireNonNull(obj)와 assert obj != null을 사용하는 경우를 비교하라. 또 각각을 적절하게 사용하는 예를 제시하라.

        // 모두 객체가 null인지 확인하는 방법입니다. 

        // Objects.requireNonNull(obj)는 코드 실행 중에 객체가 null인 경우 NullPointerException을 발생시키며, 
        // 이는 일반적으로 메소드의 매개변수로 전달된 객체가 null이 아닌지 확인할 때 사용됩니다.

        // 반면에 assert obj != null은 단언문(assertion)으로서 개발 중에만 활성화되며 코드 실행 중에는 무시됩니다. 
        // 따라서 이는 일반적으로 개발자가 코드를 작성할 때 가정한 조건을 검증하는 데 사용됩니다.

        // 예를 들어, 어떤 메소드에서 매개변수로 전달된 객체가 반드시 null이 아니어야 하는 경우 다음과 같이 작성할 수 있습니다:

        // public void someMethod(Object obj) {
        //     Objects.requireNonNull(obj); 
        //     // do something with obj
        // }
        // 또한 개발자가 어떤 변수의 값이 특정 조건을 만족한다고 가정하고 코드를 작성한 경우 다음과 같이 단언문을 사용하여 검증할 수 있습니다:

        // int x = getX();
        // assert x > 0;
        // // do something with x

        // 단언문은 기본적으로 비활성화되어 있으므로 실행 시 -ea 옵션을 추가하여 활성화해야 합니다. 예를 들어 다음과 같이 실행할 수 있습니다:
        //     java -ea MyApp

    // class TestDriver {
    //     public static void main(String[] args) {
    //         Integer i = null;
    //         someMethod2(i);
    //         someMethod(i); // NullPointerException 발생
    //     }

    //     public static void someMethod(Object obj) {
    //         Objects.requireNonNull(obj); // 검사 예외를 던짐 : NullPointerException
    //         obj.toString(); // 도착하지 않음
    //     }

    //     public static void someMethod2(Object obj) {
    //         assert obj != null : "obj is null"; // 단언문 : AssertionError : 조건이 false 일 때 발생
    //         obj.toString(); // 도착하지 않음
    //     }
    // }

// 13. int min(int[ ] values) 메서드를 작성하라. 
// 이 메서드는 가장 작은 값을 반환하기에 앞서 해당 값이 실제로 배열에 들어 있는 모든 값보다 작거나 같음(≤)을 단정해야 한다. 
// 비공개 헬퍼 메서드를 사용하거나 8장 스트림의 내용을 미리 훑어보았다면 Stream.allMatch를 사용하라. 
// 단정을 활성화, 비활성화하고 제거한 상태에서 큰 배열을 인수로 전달해 해당 메서드를 반복해서 호출한 후 실행 시간을 측정하라.
// 14. 섹스(sex), 마약(drug), C++ 같은 나쁜 단어가 포함된 로그 레코드를 걸러 내는 로그 레코드 필터를 구현하고 테스트하라.

    // class BadWordFilter implements Filter {
    //     private List<String> badWords = Arrays.asList("badword1", "badword2");

    //     @Override
    //     public boolean isLoggable(LogRecord record) {
    //         String message = record.getMessage();
    //         for (String badWord : badWords) { // traverse and compare
    //             if (message.contains(badWord)) {
    //                 return false;
    //             }
    //         }
    //         return true;
    //     }
    // }

    // class TestBadWordFilter {
    //     public static void main(String[] args) {
    //         Logger logger = Logger.getLogger(TestBadWordFilter.class.getName()); // 로거 생성
    //         logger.setFilter(new BadWordFilter());
    
    //         logger.info("This is a normal log message");
    //         logger.info("This is a badword1 log message"); // 필터링 : 출력되지 않음

    //     }
    // }

// 15. HTML 파일을 만들어 내는 로그 레코드 포매터를 구현하고 테스트하라.