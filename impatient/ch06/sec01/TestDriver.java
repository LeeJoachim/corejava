package ch06.sec01;

import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/* sec 01 : generic classs */
    // class Entry<K, V> {
    //     private K key;
    //     private V value;
        
    //     public Entry(K key, V value) {
    //         this.key = key;
    //         this.value = value;
    //     }
        
    //     public K getKey() { return key; }
    //     public V getValue() { return value; }
    // }

    // class TestDriver {
    //     public static void main(String[] args) {
    //         Entry<String, Integer> e = new Entry<>("Fred", 123);
    //         System.out.println(e.getKey() + " " + e.getValue());
    //     }
    // }
/**/

/* sec 02 : generic method */
    // class ArrayUtil {
    //     // 제네릭 메서드를 선언할 때는 
    //     // 타입 매개변수를 제어자(public이나 static 같은)와 반환 타입 사이에 두어야 한다.
    //     public static <T> void swap(T[] array, int i, int j) {
    //         T temp = array[i];
    //         array[i] = array[j];
    //         array[j] = temp;
    //     }
    //     public static <T> T[] swap(int i, int j, T... values) {
    //         T temp = values[i];
    //         values[i] = values[j];
    //         values[j] = temp;
    //         return values;
    //     }
    // }
    // class ArrayUtilDemo {
    //     public static void main(String[] args) {
    //         String[] friends = { "Peter", "Paul", "Mary" };
    //         // ArrayUtil.swap(friends, 0, 1);
    //         ArrayUtil.<String>swap(friends, 0, 1);
    //         System.out.println(Arrays.toString(friends));
    //     }
    // }
/**/

/* sec 03 : type bound */

    // 타입 경계 extends AutoCloseable은 요소 타입이 AutoCloseable의 서브타입임을 보장한다.
    // 따라서 elem.close(); 호출은 유효하다.
    // class Closeables {
    //     public static <T extends AutoCloseable> void closeAll(ArrayList<T> elems) 
    //         throws Exception {

    //             for (T elem : elems) elem.close();

    //     }
    // }

    // class CloseablesDemo {
    //     public static void main(String[] args) throws Exception {
    //         PrintStream p1 = new PrintStream("/tmp/1");
    //         PrintStream p2 = new PrintStream("/tmp/2");
    //         ArrayList<PrintStream> ps = new ArrayList<>();
    //         ps.add(p1);
    //         ps.add(p2);
    //         Closeables.closeAll(ps);
    //     }
    // }

/**/

/* sec 04 : type variance and wildcard */

    // <? extends T> : T와 그 서브타입만 가능
    // <? super T> : T와 그 슈퍼타입만 가능
        // class Employee {
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
            
        //     public final String getName() {
        //         return name;
        //     }
            
        //     public double getSalary() {
        //         return salary;
        //     }
        // }
        // class Employees {
        //     public static void printNames(ArrayList<? extends Employee> staff) {
        //         for (int i = 0; i < staff.size(); i++) {
        //             Employee e = staff.get(i);
        //             System.out.println(e.getName());
        //         }
        //     }
            
        //     public static void printAll1(Employee[] staff, Predicate<Employee> filter) {
        //         for (Employee e : staff) 
        //             if (filter.test(e))
        //                 System.out.println(e.getName());
        //     }

        //     public static void printAll2(Employee[] staff, Predicate<? super Employee> filter) {
        //         for (Employee e : staff) 
        //             if (filter.test(e))
        //                 System.out.println(e.getName());
        //     }
            
        //     public static void main(String[] args) {
        //         Employee[] employees = {
        //         new Employee("Fred", 50000),
        //         new Employee("Wilma", 60000),
        //         };
        //         printAll1(employees, e -> e.getSalary() > 100000);
        //         printAll2(employees, e -> e.getSalary() > 100000);

        //         Predicate<Object> evenLength = e -> e.toString().length() % 2 == 0; 
        //         // printAll1(employees, evenLength); // compile error 
        //         printAll2(employees, evenLength); // <? super Employee> : Object는 Employee의 슈퍼타입이므로 가능
        //     }
        // }

    // Heap pollution
        // class HeapPollutionDemo {
        //     public static void demo(List<String> words) {
        //         List<?> elements = words; 


        //         System.out.println("Cast to List<Integer>");
        //         @SuppressWarnings("unchecked")
        //         List<Integer> numbers = (List<Integer>) elements; 
        //         System.out.println("Success");


        //         System.out.println("Inserting an integer");
        //         numbers.add(42);
        //         System.out.println("Success");


        //         System.out.println("Removing it as a string");
        //         String word = words.get(0); // ClassCastException
        //         System.out.println(word);
        //     }

        //     public static void main(String[] args) {
        //         try {
        //             demo(new ArrayList<>());
        //         } catch (Throwable ex) {
        //             ex.printStackTrace();
        //         }
        //         try {
        //             demo(Collections.checkedList(new ArrayList<>(), String.class)); 
        //         } catch (Throwable ex) {
        //             ex.printStackTrace();
        //         }
        //     }
        // }


    // Array Util demo
        // class ArrayUtil {
        //     public static <T> void printAll(T[] elements, Predicate<? super T> filter) { 
        //         for (T e : elements) 
        //             if (filter.test(e)) // <? super T> : Object는 T의 슈퍼타입이므로 가능
        //                 System.out.println(e.toString());
        //     }
        // }

        // class ArrayUtilDemo {
        //     public static void main(String[] args) {
        //         String[] words = { "Mary", "had", "a", "little", "lamb" };
        //         ArrayUtil.printAll(words, e -> e.length() > 3);
        //     }
        // }


    // lists

    // class Lists {
    //     public static boolean hasNulls(List<?> elements) {
    //         for (Object e : elements) {
    //             if (e == null) return true;
    //         }
    //         return false;
    //     }

    //     // ? : wildcard 의 제한으로 Helper method를 통해서 swap을 구현
    //     public static void swap(List<?> elements, int i, int j) {
    //         swapHelper(elements, i, j);
    //     }
        
    //     private static <T> void swapHelper(List<T> elements, int i, int j) {
    //         T temp = elements.get(i); // ?를 사용할 수 잆음
    //         elements.set(i, elements.get(j));
    //         elements.set(j, temp);
    //     }
    // }

    // class ListsDemo {
    //     public static void main(String[] args) {
    //         List<String> friends = Arrays.asList("Peter", "Paul", "Mary");
    //         System.out.println(Lists.hasNulls(friends)); // false
    //         Lists.swap(friends, 0, 1); // OK
    //         System.out.println(friends);
    //     }
    // }




/**/

/* sec 05 : */
    // class WordList extends ArrayList<String> {
    //     public boolean add(String e) {
    //         return isBadWord(e) ? false : super.add(e);
    //     }  

    //     public static boolean isBadWord(String s) {
    //         return List.of("sex", "drugs", "c++").contains(s.toLowerCase()); // 
    //     }        
    // }

    // class WordListDemo {
    //     public static void main(String[] args) {
    //         WordList words = new WordList();
    //         ArrayList<String> strings = words; // 슈퍼클래스로 변환하므로 괜찮다. : upcasting
    //         strings.add("Hello");
    //         strings.add("C++");
    //         System.out.println(words);
    //     }
    // }
/**/