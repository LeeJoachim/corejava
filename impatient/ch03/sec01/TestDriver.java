package ch03.sec01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;
import java.util.function.IntConsumer;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;



/* sec 01. Interface : IntSequenceDemo */
    // interface IntSequence { // abstract function
    //     boolean hasNext();
    //     double next();
    // }

    // class DigitSequence implements IntSequence {
    //     int number;

    //     DigitSequence(int n) {
    //         number = n;
    //     }

    //     @Override
    //     public boolean hasNext() {
    //         return number != 0;
    //     }

    //     @Override
    //     public double next() {
    //         int result = number % 10;
    //         number /= 10;
    //         return result;
    //     }
        
    //     public int getNumber() {
    //         return number;
    //     }
    // }

    // class SquareSequence implements IntSequence {
    //     int i;

    //     @Override
    //     public boolean hasNext() {
    //         return true;
    //     }
    //     @Override
    //     public double next() {
    //         i++;
    //         return i * i;
    //     }
        
    // }

    // public class TestDriver {
    //     public static double average(IntSequence seq, int n) {
    //         int count = 0;
    //         double sum = 0;
    //         while (seq.hasNext() && count < n) {
    //             count++;
    //             sum += seq.next();
    //             System.out.println("sum = " + sum);
    //         }
    //         return count == 0 ? 0 : sum / count;
    //     }

    //     public static void main(String[] args) {
    //         // SquareSequence squares = new SquareSequence();
    //         // double avg = average(squares, 100);
    //         // System.out.println("Average of first 100 squares: " + avg);
            
    //         // IntSequence digits = new DigitSequence(1729);
    //         // while (digits.hasNext()) System.out.print(digits.next() + " "); // 9.0 2.0 7.0 1.0 
    //         // System.out.println();
            
    //         IntSequence digits = new DigitSequence(1729);
    //         double avg = average(digits, 100); // 9 > 9+2 > 9+2+7 > 9+2+7+1
    //         System.out.println("Average of the digits: " + avg); // 19 / 4
    //     }
    // }
/**/

/* sec 02. Interface : default function */
    // interface Identified {
    //     default int getId() { return Math.abs(hashCode()); } 
    // }
    // interface Person {
    //     String getName();
    //     default int getId() { return 0; }
    // }
    // class Employee implements Person, Identified {
    //     private String name;
    //     private double salary;
            
    //     public Employee(String name, double salary) {
    //         this.name = name;
    //         this.salary = salary;
    //     }
    //     public void raiseSalary(double byPercent) {
    //         double raise = salary * byPercent / 100;
    //         salary += raise;    
    //     }

    //     public String getName() {
    //         return name;
    //     }
    //     public double getSalary() {
    //         return salary;
    //     }
    //     // public int getId() { return Identified.super.getId(); } // special syntax
    //     public int getId() { return Person.super.getId(); } // special syntax
    // }
    // class TestDriver {
    //     public static void main(String[] args) {
    //         Employee e = new Employee("Peter", 1000);
    //         System.out.println(e.getId());
    //     }
    // }
/**/

/* sec 03. comparator and thread */

    // thread : Runnable Demo
    // public class TestDriver {
    //     public static void main(String[] args) {
    //         Runnable task = new HelloTask(); // create a task
    //         Thread thread = new Thread(task); // create a thread
    //         thread.start(); // start the thread
    //         System.out.println("Thread started");

    //         Runnable task2 = () -> System.out.println("Good bye!");
    //         task2.run();

    //         Runnable task3 = TestDriver::goodBye;
    //         task3.run();
    //     }

    //     static void goodBye() {
    //         System.out.println("Good bye!");
    //     }
    // }

    // class HelloTask implements Runnable {
    //     public void run() {
    //         for (int i = 0; i < 5; i++) {
    //             System.out.println("Hello, World!");
    //         }
    //     }
    // }

    // Comparator Demo
    // class Employee implements Comparable<Employee> {
    //     private String name;
    //     private double salary;
            
    //     public Employee(String name, double salary) {
    //         this.name = name;
    //         this.salary = salary;
    //     }
        
    //     public int compareTo(Employee other) {
    //         // return Double.compare(salary, other.salary); // ascending order
    //         return Double.compare(other.salary, salary); // descending order
    //     }
    //     public String getName() {
    //         return name;
    //     }
    //     public double getSalary() {
    //         return salary;
    //     }
    //     public String toString() {
    //         return "[name=" + name + ",salary=" + salary + "]";
    //     }
    // }


    // // sort demo
    // public class TestDriver {
    //     public static void main(String[] args) {
    //         // sort by natural order
    //         String[] friends = { "Peter", "Paul", "Lilian" };
    //         Arrays.sort(friends); 
    //         System.out.println(Arrays.toString(friends)); // [Lilian, Paul, Peter]

    //         // lambda expression
    //         Arrays.sort(friends, (String first, String second) -> first.length() - second.length()); // [Paul, Peter, Lilian]
    //         Arrays.sort(friends, Comparator.comparing(String::length).reversed()); // [Lilian, Peter, Paul]
    //         System.out.println(Arrays.toString(friends));

    //         // sort by length
    //         friends = new String[] { "Peter", "Paul", "Lilian" }; 
    //         Arrays.sort(friends, new LengthComparator()); // [Paul, Peter, Lilian]
    //         System.out.println(Arrays.toString(friends)); 

    //         // sort by salary
    //         Employee[] staff = new Employee[3];
    //         staff[0] = new Employee("Peter", 1000);
    //         staff[1] = new Employee("Paul", 2000);
    //         staff[2] = new Employee("Lilian", 3000);
    //         Arrays.sort(staff); // descending order
    //         System.out.println(Arrays.toString(staff)); // [Lilian, Paul, Peter]
    //     }
    // }
    // class LengthComparator implements Comparator<String> {
    //     public int compare(String first, String second) { 
    //         return first.length() - second.length(); // ascending order
    //     }
    // }



/**/

/* sec 04. lambda expression */
    // class TestDriver {
    //     public static void main(String[] args) {
    //         String[] friends = { "Peter", "Paul", "Lilian" };
    //         Arrays.sort(friends,
    //             (first, second) -> first.length() - second.length()); // [Paul, Peter, Lilian]
    //         System.out.println(Arrays.toString(friends));

    //         ArrayList<String> enemies = new ArrayList<>(Arrays.asList("Malfoy", "Crabbe", "Goyle", null));
    //         enemies.removeIf(e -> e == null); // remove null : Predicate designed for lambda
    //         System.out.println(enemies);
    //     }
    // }
/**/

/* sec 05. special syntax : for method reference and constructor reference */

    // method reference demo :: syntax : Class::method
    // public class TestDriver {
    //     public static void main(String[] args) {
    //         String[] strings = { "Mary", "had", "a", "little", "lamb" }; 
    //         // 1. 첫 번째 매개변수가 메서드의 인스턴스로 전달되는 경우, 나머지 매개변수는 메서드의 매개변수로 전달된다.
    //         Arrays.sort(strings, String::compareToIgnoreCase); // [a, had, lamb, little, Mary]
    //         // Arrays.sort(strings, (s1, s2) -> s1.compareToIgnoreCase(s2)); // same as above
    //         System.out.println(Arrays.toString(strings));

    //         ArrayList<String> list = new ArrayList<>(Arrays.asList("Malfoy", "Crabbe", "Goyle", null));
    //         // 2. 정적 함수를 참조하는 경우, 모든 매개변수는 함수의 매개변수로 전달된다.
    //         // list.removeIf(Objects::isNull); // remove null : Predicate designed for lambda
    //         list.removeIf(e -> e == null); // same as above
    //         // list.removeIf(e -> Objects.isNull(e)); // same as above

    //         // 3. 주어진 객체로 메서드를 호출하며, 매개변수는 인스턴스 메서드의 매개변수로 전달된다.
    //         list.forEach(System.out::println);
    //         // list.forEach(e -> System.out.println(e)); // same as above
    //     }
    // }

    // constructor reference demo :: syntax : Class::new
    // public class TestDriver {
    //     public static void main(String[] args) {
    //         ArrayList<String> names = new ArrayList<>();
    //         names.add("Peter");
    //         names.add("Paul");
    //         names.add("Mary");
    //         Employee[] employees = names.stream().map(Employee::new).toArray(Employee[]::new);
    //         for (Employee e : employees) System.out.println(e.getName());
    //     }
    // }

    // class Employee {
    //     private String name;
    //     public Employee(String name) {
    //         this.name = name;
    //     }
    //     public String getName() {
    //         return name;
    //     }
    // }
    
/**/

/* sec 06. deferred execution : lambda expression */

    // RepeatDemo
    // public class TestDriver {

    //     public static void repeat(int n, Runnable action) { // Runnable is a functional interface
    //         for (int i = 0; i < n; i++)
    //             action.run();
    //     }

    //     public static void repeat(int n, IntConsumer action) { // IntConsumer is a functional interface
    //         for (int i = 0; i < n; i++)
    //             action.accept(i);
    //     }

    //     public static void repeatMessage(String text, int count) {
    //         Runnable r = () -> {
    //            for (int i = 0; i < count; i++) {
    //               System.out.println(text);
    //            }
    //         };
    //         new Thread(r).start();                  
    //      }
        
    //     public static void main(String[] args) {
    //         // repeat(10, () -> System.out.println("Hello, World!"));
    //         // repeat(10, i -> System.out.println("Countdown: " + (9 - i))); 
    //         repeat(10, (Runnable)System.out::println); // modified ambiguous method call : () -> (Runnable)
    //         // repeatMessage("Hello", 10); 
    //     }
    // }

    // @FunctionalInterface
    // interface PixelFunction {
    //     Color apply(int x, int y);
    // }

    // // ImageDemo
    // class TestDriver {
    //     public static BufferedImage createImage(int width, int height, PixelFunction f) {
    //         BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    
    //         for (int x = 0; x < width; x++)
    //             for (int y = 0; y < height; y++) {
    //                 Color color = f.apply(x, y); 
    //                 image.setRGB(x, y, color.getRGB());
    //             }
    //         return image;
    //     } 
        
    //     public static void main(String[] args) throws IOException {
    //         BufferedImage frenchFlag = TestDriver.createImage(150, 100,
    //             (x, y) -> x < 50 ? Color.BLUE : x < 100 ? Color.WHITE : Color.RED); 
    //         Path path = Paths.get("flag.png");
    //         ImageIO.write(frenchFlag, "PNG", path.toFile());
    //         System.out.println("Image saved to " + path.toAbsolutePath());
    //     }
    // }

/**/

/* sec 07. free variable */

    // scope demo
    // public class TestDriver {

    //     // example : free variable
    //     static void printNumbers() {
    //         // start, end : free variables 
    //         // start, end are captured by the lambda expression
    //         // start, end are effectively final
    //         // start, end are fixed at the time of lambda expression creation
    //         int start = 1; 
    //         int end = 10; 
    //         // int i = 0; // Local variable i defined in an enclosing scope must be final or effectively final
        
    //         Runnable runnable = () -> {
    //             for (int i = start; i <= end; i++) {
    //                 System.out.println(i);
    //             }
    //         };
        
    //         new Thread(runnable).start();
    //     }
        
        
    //     public static void repeatMessage(String text, int count) { // text and count are free variables

    //         Runnable r = () -> {
    //         for (int i = 0; i < count; i++) {  // value of count is captured
    //             System.out.println(text); // value of text is captured
    //         }
    //         };
    //         new Thread(r).start();                  
    //     }
    //     public static void main(String[] args) {
    //         printNumbers(); // print 1 to 10 in a new thread
    //         repeatMessage("Hello", 10); // print 10 times in a new thread
            
    //         String[] message = new String[] { "Mary", "had", "a", "little", "lamb" }; // message is a free variable
    //         for (String a : message) 
    //             new Thread(() -> System.out.println(a)).start(); // print 5 times in 5 threads
    //     }
    // }
/**/

/* sec 08. higher-order function */

    // 함수를 처리하거나 반환하는 함수를 고차함수(higher-order function)라고 한다.

    // higher-order function demo
    // public class TestDriver {
    //     public static Comparator<String> compareInDirecton(int direction) { // compareInDirecton is a higher-order function
    //         return (x, y) -> direction * x.compareTo(y); 
    //     }
        
    //     public static Comparator<String> reverse(Comparator<String> comp) { // reverse is a higher-order function
    //         return (x, y) -> -comp.compare(x, y); // -1 : reverse order
    //     }
        
    //     public static void main(String[] args) {
    //         String[] words = { "Mary", "had", "a", "little", "lamb" };
    //         Arrays.sort(words, compareInDirecton(-1)); // reverse order
    //         Arrays.sort(words, Comparator.comparingInt(String::length)); // length order (method reference)
    //         Arrays.sort(words, (x, y) -> x.length() - y.length()); // length order (lambda expression)
    //         System.out.println(Arrays.toString(words));
    //         Arrays.sort(words, reverse(String::compareToIgnoreCase)); // case-insensitive reverse order
    //         System.out.println(Arrays.toString(words));        
    //     }
    // }

    // class Person {
    //     private String first;
    //     private String middle;
    //     private String last;
    
    //     public Person(String first, String middle, String last) {
    //         this.first = first;
    //         this.middle = middle;
    //         this.last = last;
    //     }
    
    //     public Person(String first, String last) {
    //         this.first = first;
    //         this.last = last;
    //     }
        
    //     public String getFirstName() {
    //         return first;
    //     }
        
    //     public String getMiddleName() {
    //         return middle;
    //     }
        
    //     public String getLastName() {
    //         return last;
    //     }
        
    //     public String getName() {
    //         if (middle == null) {
    //             return first + " " + last;
    //         }
    //         else {
    //             return first + " " + middle + " " + last;
    //         }
    //     }
        
    //     public String toString() {
    //         return getName();
    //     }
    // }

    // // Comparator Demo
    // class ComparatorDemo {
    //     public static void main(String[] args) {
    //         Person[] people = {
    //                 new Person("George", "Washington"),
    //                 new Person("John", "Adams"),
    //                 new Person("Thomas", "Jefferson"),
    //                 new Person("James", "Madison"),
    //                 new Person("James", "Monroe"),
    //                 new Person("John", "Quincy", "Adams"),
    //                 new Person("Andrew", "Jackson"),
    //                 new Person("Martin", "van Buren"),
    //                 new Person("William", "Henry", "Harrison"),
    //                 new Person("John", "Tyler"),
    //                 new Person("James", "Knox", "Polk"),
    //                 new Person("Zachary", "Taylor"),
    //                 new Person("Millard", "Fillmore"),
    //                 new Person("Franklin", "Pierce"),
    //                 new Person("James", "Buchanan"),
    //                 new Person("Abraham", "Lincoln"),
    //                 new Person("Andrew", "Johnson"),
    //                 new Person("Ulysses", "S.", "Grant"),
    //                 new Person("Rutherford", "Birchard", "Hayes"),
    //                 new Person("James", "Abram", "Garfield"),
    //                 new Person("Grover", "Cleveland"),
    //                 new Person("Benjamin", "Harrison"),
    //                 new Person("Grover", "Cleveland"),
    //                 new Person("William", "McKinley"),
    //                 new Person("Theodore", "Roosevelt"),
    //                 new Person("William", "Howard", "Taft"),
    //                 new Person("Woodrow", "Wilson"),
    //                 new Person("Warren", "Gamaliel", "Harding"),
    //                 new Person("Calvin", "Coolidge"),
    //                 new Person("Herbert", "Hoover"),
    //                 new Person("Franklin", "Delano", "Roosevelt"),
    //                 new Person("Harry", "S.", "Truman"),
    //                 new Person("Dwight", "David", "Eisenhower"),
    //                 new Person("John", "Fitzgerald", "Kennedy"),
    //                 new Person("Lyndon", "Baines", "Johnson"),
    //                 new Person("Richard", "Mulhouse", "Nixon"),
    //                 new Person("Gerald", "Ford"),
    //                 new Person("James", "Earl", "Carter"),
    //                 new Person("Ronald", "Reagan"),
    //                 new Person("George", "Herbert Walker", "Bush"),
    //                 new Person("William", "Jefferson", "Clinton"),
    //                 new Person("George", "Walker", "Bush"),
    //                 new Person("Barack", "Hussein", "Obama")
    //         };
            
    //         Arrays.sort(people, Comparator.comparing(Person::getName)); // sort by name 
    //         System.out.println(Arrays.toString(people));
            
    //         Arrays.sort(people,
    //                 Comparator.comparing(Person::getLastName)
    //                 .thenComparing(Person::getFirstName)); // sort by last name, then first name 
    //         System.out.println(Arrays.toString(people));
            
    //         Arrays.sort(people, Comparator.comparing(Person::getName,
    //                 (s, t) -> s.length() - t.length())); // sort by name length
            
    //         Arrays.sort(people, Comparator.comparingInt(p -> p.getName().length())); // sort by name length 
    //         System.out.println(Arrays.toString(people));
            
    //         Arrays.sort(people, Comparator.comparing(Person::getMiddleName,
    //                 Comparator.nullsFirst(Comparator.naturalOrder()))); // sort by middle name with nulls first
    //         System.out.println(Arrays.toString(people));
    
    //         Arrays.sort(people, Comparator.comparing(Person::getName,
    //                 Comparator.reverseOrder()));  // sort by name in reverse order 
    //         System.out.println(Arrays.toString(people));
    //     }
    // }
    
/**/

/* sec 09. Anonymous and local class */
    
    // interface IntSequence {
    //     boolean hasNext();
    //     int next();
    // }

    // // benefit of local class : 1. 클래스 이름이 메서드의 유효 범위 안으로 숨는다. 2. 람다 표현식처럼 지역 클래스의 메서드 안에서 유효 범위에 속한 변수에 접근할 수 있다.
    // class LocalClassDemo {
    //     private static Random generator = new Random();

    //     public static IntSequence randomInts(int low, int high) {
    //         class RandomSequence implements IntSequence {
    //             public int next() { return low + generator.nextInt(high - low + 1); } // return random int between low and high
    //             public boolean hasNext() { return true; }
    //         }

    //         return new RandomSequence();
    //     }

    //     public static void main(String[] args) {
    //         IntSequence dieTosses = randomInts(1, 6); // create a sequence of random ints between 1 and 6
    //         for (int i = 0; i < 10; i++) System.out.println(dieTosses.next());
    //     }
    // }

    // // benefit of anonymous class : 1. 클래스 이름이 없다. 2. 클래스 정의와 객체 생성을 동시에 한다.
    // class AnonymousClassDemo {
    //     private static Random generator = new Random();
    
    //     public static IntSequence randomInts(int low, int high) {
    //         return new IntSequence() { // anonymous class
    //             public int next() { return low + generator.nextInt(high - low + 1); } // return random int between low and high
    //             public boolean hasNext() { return true; }
    //         };
    //     }
    
    //     public static void main(String[] args) {
    //         IntSequence dieTosses = randomInts(1, 6); // create a sequence of random ints between 1 and 6
    //         for (int i = 0; i < 10; i++) System.out.println(dieTosses.next());
    //     }
    // }
    

/**/