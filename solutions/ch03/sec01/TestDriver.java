package ch03.sec01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.io.File;
import java.io.FileFilter;
import java.math.*;

// 1. 먼저 객체를 어떤 방법으로 측정하는 double getMeasure() 메서드를 가진 Measurable 인터페이스를 만든다. 
// 그다음 Employee가 Measurable을 구현하게 한다. 
// 마지막으로 평균 측정치를 계산하는 double average(Measurable[ ] objects) 메서드를 만들어 직원 배열의 평균 급여를 계산하는 데 사용하라.

    // interface Measurable {
    //     double getMeasure();
    // }

    // class Employee implements Measurable {
    //     private String name;
    //     private double salary;

    //     public Employee(String name, double salary) {
    //         this.name = name;
    //         this.salary = salary;
    //     }

    //     public String getName() {
    //         return name;
    //     }

    //     public double getSalary() {
    //         return salary;
    //     }

    //     @Override
    //     public double getMeasure() {
    //         return salary;
    //     }
    // }

    // class TestDriver {
    //     public static void main(String[] args) {
    //         Employee[] employees = new Employee[3];
    //         employees[0] = new Employee("홍길동", 1000);
    //         employees[1] = new Employee("김길동", 2000);
    //         employees[2] = new Employee("박길동", 3000);

    //         System.out.println("평균 급여: " + average(employees));
    //         // System.out.println("가장 높은 급여: " + largest(employees).getName());
    //     }

    //     public static double average(Measurable[] objects) {
    //         double sum = 0;
    //         for (Measurable obj : objects) {
    //             sum += obj.getMeasure();
    //         }
    //         return sum / objects.length;
    //     }
    // }

// 2. 연습문제 1에 이어서 Measurable largest(Measurable[ ] objects) 메서드를 만든다. 이 메서드로 급여가 가장 높은 직원의 이름을 구하라. 이때 캐스트가 필요한 이유는?

    // public static Employee largest(Measurable[] objects) {
    //     Employee largest = (Employee)objects[0]; // type mismatch: cannot convert from Measurable to Employee
    //     for (Measurable obj : objects) {
    //         if (largest.getMeasure() < obj.getMeasure()) {
    //             largest = (Employee)obj;
    //         }
    //     }
    //     return largest;
    // }

// 3. String, Scanner, ImageOutputStream의 슈퍼타입을 모두 나열하라. 
// (각 타입은 그 자신의 슈퍼타입이라는 점을 유의한다. 
// 슈퍼타입을 선언하지 않은 클래스나 인터페이스는 Object를 슈퍼타입으로 둔다.)
    // String의 슈퍼타입: Serializable, Comparable<String>, CharSequence
    // Scanner의 슈퍼타입: Object, Iterator<String>, Closeable
    // ImageOutputStream의 슈퍼타입: DataOutput, ImageInputStream
// 4. 인수들로 구성된 시퀀스를 돌려주는 IntSequence 클래스의 정적 메서드 of를 구현하라. 
// (예를 들어 IntSequence.of(3, 1, 4, 1, 5, 9)는 값 여섯 개로 구성된 시퀀스를 돌려준다. 익명 클래스의 인스턴스를 반환하게 하면 추가 점수가 있다.)

    // class IntSequence implements Iterable<Integer>{
    //     private final int[] values;

    //     private IntSequence(int... values) {
    //         this.values = values;
    //     }

    //     public static IntSequence of(int... values) {
    //         return new IntSequence(values);
    //     }

    //     @Override
    //     public Iterator<Integer> iterator() {
    //         return new Iterator<Integer>() {
    //             private int i = 0;
    //             public boolean hasNext() {
    //                 return i < values.length;
    //             }
    //             public Integer next() {
    //                 if (!hasNext()) {
    //                     throw new NoSuchElementException();
    //                 }
    //                 return values[i++];
    //             }
    //         };
    //     }

    // }
    // class TestDriver {
    //     public static void main(String[] args) {
    //         IntSequence seq = IntSequence.of(3, 1, 4, 1, 5, 9);
    //         for (int i : seq) {
    //             System.out.print(i + " ");
    //         }
    //     }
    // }

// 5. 무한 상수 시퀀스를 돌려주는 IntSequence 클래스의 정적 메서드 constant를 추가하라. (예를 들어 IntSequence.constant(1)은 값 1 1 1…을 돌려준다. 람다 표현식으로 만들면 추가 점수가 있다.)

    // class IntSequence {
    //     public static IntSequence constant(int value) {
    //         return new IntSequence() {
    //             public int next() {
    //                 return value;
    //             }
    //         };
    //     }

    //     public int next() {
    //         return 0;
    //     }
    // }

    // public class TestDriver {
    //     public static void main(String[] args) {
    //         IntSequence constantSequence = IntSequence.constant(1);
    //         for (int i = 0; i < 10; i++) {
    //             System.out.println(constantSequence.next());
    //         }
    //     }
    // }

    // lambda expression version 1
    // public class TestDriver {
    //     public static void main(String[] args) {
    //         IntSupplier constantSequence = () -> 1; // IntSupplier is a functional interface with a single method getAsInt that returns an int value and takes no arguments.
    //         for (int i = 0; i < 10; i++) { 
    //             System.out.println(constantSequence.getAsInt()); 
    //         }
    //     }
    // }

    // lambda expression version 2
    // public class TestDriver {
    //     public static void main(String[] args) {
    //         IntSupplier constantSequence = () -> 1;
    //         IntStream.generate(constantSequence).limit(10).forEach(System.out::println); // IntStream.generate() returns an infinite sequential unordered stream where each element is generated by the provided IntSupplier.
    //     }
    // }

    // lambda expression version 3
    // public class TestDriver {
    //     public static void main(String[] args) {
    //         IntStream.generate(() -> 1).limit(10).forEach(System.out::println);
    //     }
    // }

    // lambda expression version 4
    // @FunctionalInterface
    // interface IntSequence {
    //     int next();
    //     static IntSequence constant(int value) {
    //         return () -> value;
    //     }
    // }

    // class TestDriver {
    //     public static void main(String[] args) {
    //         IntSequence constantSequence = IntSequence.constant(1);
    //         IntSequence constantSequence2 = () -> 2;
    //         for (int i = 0; i < 10; i++) {
    //             System.out.println(constantSequence.next());
    //             System.out.println(constantSequence2.next());
    //         }
    //     }
    // }

// 6. SquareSequence 클래스는 정수 오버플로 때문에 실제로 사각형의 무한 시퀀스를 주지 않는다. 구체적으로 어떻게 작동할까? 
// Sequence<T> 인터페이스와 Sequence<BigInteger>를 구현하는 SquareSequence 클래스를 정의해 문제를 해결하라.

    // interface Sequence<T> {
    //     T next();
    // }

    // class SquareSequence implements Sequence<BigInteger> {

    //     private BigInteger current = BigInteger.ZERO;

    //     public BigInteger next() {
    //         current = current.add(BigInteger.ONE);
    //         return current.pow(2);
    //     }
    // }

    // class TestDriver {
    //     public static void main(String[] args) {
    //         SquareSequence squareSequence = new SquareSequence();
    //         for (int i = 0; i < 10; i++) {
    //             System.out.println(squareSequence.next());
    //         }
    //     }
    // }

// 7. 이제 인터페이스에 메서드를 추가하면 무슨 일이 일어나는지 시험해 보자. 자바 7로 IntSequence가 아니라 Iterator<Integer>를 구현하는 DigitSequence 클래스를 구현하라. 
// hasNext, next, 아무 일도 하지 않는 remove를 구현해야 한다. 그다음 인스턴스의 요소들을 출력하는 프로그램을 작성한다. 
// 자바 8의 Iterator 클래스에는 또 다른 forEachRemaining 메서드가 추가되었다. 자바 8로 전환해도 작성한 코드가 여전히 컴파일되는가? 
// 자바 7용으로 작성한 클래스를 JAR 파일에 넣어 두고 다시 컴파일하지 않아도 자바 8에서 제대로 작동하는가? forEachRemaining 메서드를 호출하면 어떻게 되는가? 
// 자바 8에서는 remove 메서드가 UnsupportedOperationException을 던지는 기본 메서드가 되었다. 작성한 클래스의 인스턴스에 remove를 호출하면 어떻게 되는가?

    // default void forEachRemaining(Consumer<? super T> action) { // 자바 8로 전환해도 작성한 코드가 여전히 컴파일된다.
    
    // class DigitSequence implements Iterator<Integer> {

    //     private int number;

    //     public DigitSequence(int number) {
    //         this.number = number;
    //     }

    //     public boolean hasNext() {
    //         return number != 0;
    //     }

    //     public Integer next() {
    //         int result = number % 10;
    //         number /= 10;
    //         return result;
    //     }

    //     public void remove() {
    //         throw new UnsupportedOperationException();
    //     }
    // }

    // class TestDriver {
    //     public static void main(String[] args) {
    //         DigitSequence digitSequence = new DigitSequence(12345);
    //         digitSequence.forEachRemaining(System.out::println); // iterator의 요소들을 출력한다.
    //         digitSequence.remove(); // UnsupportedOperationException을 던진다.
    //         // while (digitSequence.hasNext()) {
    //         //     System.out.println(digitSequence.next());
    //         // }
    //     }
    // }


// 8. 비교자로 판별했을 때 요소들이 오름차순으로 정렬될 때까지 배열 리스트를 대상으로 Collections.shuffle을 계속 호출하는 
// void luckySort(ArrayList<String> strings, Comparator<String> comp) 메서드를 구현하라.

    // public class TestDriver {
    //     static int count;
    //     public static void main(String[] args) {
    //         ArrayList<String> strings = new ArrayList<>();
    //         strings.add("e");
    //         strings.add("d");
    //         strings.add("c");
    //         strings.add("b");
    //         strings.add("a");
    //         luckySort(strings, (first, second) -> first.compareTo(second));
    //         System.out.println(strings);
    //         System.out.println(count);
    //     }

    //     public static void luckySort(ArrayList<String> strings, Comparator<String> comp) {

    //         while (!isSorted(strings, comp)) {
    //             Collections.shuffle(strings);
    //             count++;
    //         }
    //     }

    //     public static boolean isSorted(ArrayList<String> strings, Comparator<String> comp) {
    //         for (int i = 0; i < strings.size() - 1; i++) {
    //             if (comp.compare(strings.get(i), strings.get(i + 1)) > 0) { // 오름차순이 아니면
    //                 return false;
    //             }
    //         }
    //         return true;
    //     }
    // }

// 9. Runnable을 구현하는 Greeter 클래스를 작성하라. 이 클래스의 run 메서드는 "Hello, " + target을 n번 출력해야 한다. 
// n과 target은 생성자에서 설정한다. 각기 다른 메시지로 인스턴스를 두 개 생성해 두 스레드에서 동시에 실행하라.
    
        // class Greeter implements Runnable {
    
        //     private int n;
        //     private String target;
    
        //     public Greeter(int n, String target) {
        //         this.n = n;
        //         this.target = target;
        //     }
    
        //     public void run() {
        //         for (int i = 0; i < n; i++) {
        //             System.out.println("Hello, " + target);
        //         }
        //     }
        // }
    
        // class TestDriver {
        //     public static void main(String[] args) {
        //         Greeter greeter1 = new Greeter(10, "world");
        //         Greeter greeter2 = new Greeter(10, "java");
        //         Thread thread1 = new Thread(greeter1);
        //         Thread thread2 = new Thread(greeter2);
        //         thread1.start();
        //         thread2.start();
        //     }
        // }

// 10. 다음 메서드를 구현하라.
// 첫 번째 메서드는 각 태스크를 별도의 스레드에서 실행한 후 반환해야 한다. 두 번째 메서드는 모든 태스크를 현재 스레드에서 실행하고 마지막 태스크가 완료될 때 반환해야 한다.

    // class TestDriver {
    //     public static void runTogether(Runnable... tasks) {
    //         for (Runnable task : tasks) {
    //             // Thread thread = new Thread(task);
    //             // thread.start();

    //             // 각 태스크를 별도의 스레드에서 실행한 후 반환한다.
    //             new Thread(task).start(); // 위의 두 줄을 한 줄로 줄인 것.

    //         }
    //     }
    //     public static void runInOrder(Runnable... tasks) { 
    //         for (Runnable task : tasks) {
    //             // 각 태스크를 하나의 스레드에서 실행한 후 마지막 태스크가 완료될 때 반환한다.
    //             task.run(); // 현재 스레드에서 실행한다.
    //         }
    //     }

    //     public static void main(String[] args) {
    //         Runnable task1 = () -> System.out.println("Hello, world!");
    //         Runnable task2 = () -> System.out.println("Hello, java!");
    //         runTogether(task1, task2);
    //         runInOrder(task1, task2);
    //     }


    // }







// 11. java.io.File 클래스의 listFiles(FileFilter)와 isDirectory 메서드를 사용해 주어진 디렉터리의 모든 서브디렉터리를 반환하는 메서드를 작성하라. 
// FileFilter 객체 대신 람다 표현식을 사용한다. 메서드 표현식과 익명 클래스로 같은 작업을 반복하라.

    /* lambda */
        // class Subdirectories {
        //     public static List<File> getSubdirectories(File directory) {
        //         List<File> subdirectories = new ArrayList<>();
        //         File[] files = directory.listFiles(file -> file.isDirectory());
        //         if (files != null) {
        //             subdirectories.addAll(Arrays.asList(files));
        //             for (File file : files) {
        //                 subdirectories.addAll(getSubdirectories(file));
        //             }
        //         }
        //         return subdirectories;
        //     }
        //     public static void main(String[] args) {
        //         List<File> subdirectories = getSubdirectories(new File("."));
        //         for (File file : subdirectories) {
        //             System.out.println(file);
        //         }
        //     }
        // }
    /**/

    /* method referencing */
        // class Subdirectories {
        //         public static List<File> getSubdirectories(File directory) {
        //             List<File> subdirectories = new ArrayList<>();
        //             File[] files = directory.listFiles(File::isDirectory);
        //             if (files != null) {
        //                 subdirectories.addAll(Arrays.asList(files));
        //                 for (File file : files) {
        //                     subdirectories.addAll(getSubdirectories(file));
        //                 }
        //             }
        //             return subdirectories;
        //         }
        //         public static void main(String[] args) {
        //             List<File> subdirectories = getSubdirectories(new File("."));
        //             for (File file : subdirectories) {
        //                 System.out.println(file);
        //             }
        //         }
        //     }
    /**/

    /* anonymous class */
        // class Subdirectories {
        //         public static List<File> getSubdirectories(File directory) {
        //             List<File> subdirectories = new ArrayList<>();
        //             File[] files = directory.listFiles(new FileFilter() {
        //                 @Override
        //                 public boolean accept(File file) {
        //                     return file.isDirectory();
        //                 }
        //             });
        //             if (files != null) {
        //                 subdirectories.addAll(Arrays.asList(files));
        //                 for (File file : files) {
        //                     subdirectories.addAll(getSubdirectories(file));
        //                 }
        //             }
        //             return subdirectories;
        //         }
        //         public static void main(String[] args) {
        //             List<File> subdirectories = getSubdirectories(new File("."));
        //             for (File file : subdirectories) {
        //                 System.out.println(file);
        //             }
        //         }
        //     }
    /**/
// 12. java.io.File 클래스의 list(FilenameFilter) 메서드를 사용해 주어진 디렉터리에서 주어진 확장자를 가진 모든 파일을 반환하는 메서드를 작성하라. 
// FilenameFilter를 사용하지 말고 람다 표현식을 사용한다. 이 메서드는 자신을 감싸는 유효 범위에 있는 변수 중 어느 것을 캡처하는가?

    /* lambda */
        // class Subdirectories {
        //     public static List<File> getSubdirectories(File directory) {
        //         List<File> javaLists = new ArrayList<>();
        //         File[] javaFiles = directory.listFiles(file -> file.getName().endsWith(".java")); 
        //         if (javaFiles != null) {
        //             javaLists.addAll(Arrays.asList(javaFiles));
        //         }
        //         return javaLists;
        //     }
        //     public static void main(String[] args) {
        //         List<File> javaLists = getSubdirectories(new File("./ch01/sec01"));
        //         for (File file : javaLists) {
        //             System.out.println(file);
        //         }
        //     }
        // }
    /**/

// 13. File 객체의 배열을 받아서 디렉터리가 파일 앞에 나타나도록 정렬하라. 
// 그리고 각 그룹 안에서는 요소들을 경로 이름으로 정렬한다. Comparator를 지정할 때 람다 표현식을 사용하라.
    /* lambda */
            // class Subdirectories {
            //     public static List<File> getSubdirectories(File directory) {
            //         List<File> subdirectories = new ArrayList<>();
            //         List<File> result = new ArrayList<>();
            //         File[] files = directory.listFiles(file -> file.isDirectory()); // 캡처하는 변수는 file 하나뿐이다.
            //         File[] javaFiles = directory.listFiles(file -> file.getName().endsWith(".java")); 
            //         if (files != null) {
            //             subdirectories.addAll(Arrays.asList(files));
            //             result.addAll(Arrays.asList(javaFiles));
            //             for (File file : files) {
            //                 subdirectories.addAll(getSubdirectories(file));
            //                 result.addAll(getSubdirectories(file));
            //             }
            //         }
            //         // sort
            //         // Collections.sort(result, (f1, f2) -> f1.getPath().compareTo(f2.getPath()));
            //         // sort 2
            //         Collections.sort(result, Comparator.comparing(File::getPath));
            //         return result;
            //     }
            //     public static void main(String[] args) {
            //         List<File> subdirectories = getSubdirectories(new File("."));
            //         for (File file : subdirectories) {
            //             System.out.println(file);
            //         }
            //     }
            // }
    /**/
// 14. Runnable 인스턴스의 배열을 받고, run 메서드에서 이 인스턴스들을 차례로 실행하는 Runnable을 반환하는 메서드를 작성하라. 결과를 람다 표현식으로 반환한다.
    /* lambda */
        // class TestDriver {
        //     public static Runnable andThen(Runnable first, Runnable second) {
        //         return () -> {
        //             first.run();
        //             second.run();
        //         };
        //     }
        //     public static void main(String[] args) {
        //         Runnable runnable = andThen(() -> System.out.println("Hello"), () -> System.out.println("World"));
        //         runnable.run();
        //     }
        // }
    /**/

// 15. 급여에 따라 직원을 정렬하는 Arrays.sort 호출을 작성하라. 순위가 같은 직원은 이름으로 정렬하라. 
// 이때는 Comparator.thenComparing을 사용하면 된다. 그런 다음 이 작업을 역순으로 수행하라.
    /* lambda */
        // class Employee {
        //     private String name;
        //     private double salary;
        //     public Employee(String name, double salary) {
        //         this.name = name;
        //         this.salary = salary;
        //     }
        //     public String getName() {
        //         return name;
        //     }
        //     public double getSalary() {
        //         return salary;
        //     }
        //     public String toString() {
        //         return getClass().getName() + "[name=" + name + ",salary=" + salary + "]";
        //     }
        // }
        // class TestDriver {
        //     public static void main(String[] args) {
        //         Employee[] employees = new Employee[3];
        //         employees[0] = new Employee("홍길동", 1000);
        //         employees[1] = new Employee("김길동", 2000);
        //         employees[2] = new Employee("박길동", 1000);
        //         Arrays.sort(employees, Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName));
        //         for (Employee employee : employees) {
        //             System.out.println(employee);
        //         }
        //         System.out.println("역순");
        //         Arrays.sort(employees, Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName).reversed());
        //         for (Employee employee : employees) {
        //             System.out.println(employee);
        //         }
        //     }
        // }
    /**/
// 16. 3.9.1 지역 클래스에서 다룬 RandomSequence를 randomInts 메서드 외부에 있는 중첩 클래스로 구현하라
    // interface IntSequence {
    //     boolean hasNext();
    //     int next();
    // }
    // class TestDriver {
    //     static class RandomSequence implements IntSequence {
    //         private int low;
    //         private int high;

    //         RandomSequence(int low, int high) {
    //             this.low = low;
    //             this.high = high;
    //         }
    //         private Random generator = new Random();
    //         public int next() {
    //             return low + generator.nextInt(high - low + 1);
    //         }
    //         public boolean hasNext() {
    //             return true;
    //         }
    //     }
    //     public static IntSequence randomInts(int low, int high) {
    //         return new RandomSequence(low, high);
    //     }
    //     public static void main(String[] args) {
    //         IntSequence randoms = randomInts(3, 6);
    //         for (int i = 0; i < 10; i++) {
    //             System.out.println(randoms.next());
    //         }
    //     }
    // }