package ch06.sec01;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.IntFunction;

// 1. E 타입 요소로 구성된 배열 리스트를 관리하는 Stack<E> 클래스를 구현하라(push, pop, isEmpty 메서드를 제공해야 한다).

    // class Stack<E> {
    //     private ArrayList<E> elements;

    //     public Stack() {
    //         elements = new ArrayList<>();
    //     }

    //     public void push(E e) {
    //         elements.add(e);
    //     }

    //     public E pop() {
    //         if (elements.isEmpty()) {
    //             throw new EmptyStackException();
    //         }
    //         return elements.remove(elements.size() - 1); // 마지막 요소를 삭제하고 반환
    //     }

    //     public boolean isEmpty() {
    //         return elements.isEmpty();
    //     }
    // }

    // class TestDriver {
    //     public static void main(String[] args) {
    //         Stack<String> stack = new Stack<>();
    //         stack.push("A");
    //         stack.push("B");
    //         stack.push("C");
    //         while (!stack.isEmpty()) {
    //             System.out.println(stack.pop());
    //         }
    //     }
    // }

// 2. 요소를 배열에 저장하는 방법으로 Stack<E> 클래스를 다시 구현하라. 
// 필요하면 push 메서드에서 배열 크기를 늘려라. 
// E[ ] 배열과 Object[ ] 배열로 해법을 두 가지 제시하라. 
// 두 해법 모두 경고 없이 컴파일할 수 있어야 한다. 
// 어느 배열을 선호하는지 답하고, 그 이유를 설명하라.
    // class Stack<E> {
    //     private E[] elements;
    //     private int size = 0;
    //     private static final int DEFAULT_CAPACITY = 10;

    //     // 가능하면 제네릭 배열 생성을 피하고, 대신 ArrayList와 같은 컬렉션 클래스를 사용하는 것이 좋다.
    //     @SuppressWarnings("unchecked") // 경고를 숨기기만 할 뿐, 실제 문제를 해결하지는 않는다.
    //     public Stack() {
    //         elements = (E[]) new Object[DEFAULT_CAPACITY];

    //     }

    //     public void push(E e) {
    //         if (size == elements.length) {
    //             elements = Arrays.copyOf(elements, 2 * size + 1);
    //         }
    //         elements[size++] = e; 
    //     }

    //     public E pop() {
    //         if (size == 0) {
    //             throw new EmptyStackException();
    //         }
    //         E result = elements[--size];
    //         elements[size] = null;
    //         return result;
    //     }

    //     public boolean isEmpty() {
    //         return size == 0;
    //     }
    // }

    // class TestDriver {
    //     public static void main(String[] args) {
    //         Stack<String> stack = new Stack<>();
    //         stack.push("A");
    //         stack.push("B");
    //         stack.push("C");
    //         while (!stack.isEmpty()) {
    //             System.out.println(stack.pop());
    //         }
    //     }
    // }

    // class Stack<E> {
    //     private Object[] elements;
    //     private int size = 0;
    //     private static final int DEFAULT_CAPACITY = 10;

    //     public Stack() {
    //         elements = new Object[DEFAULT_CAPACITY];
    //     }

    //     public void push(E e) {
    //         if (size == elements.length) {
    //             elements = Arrays.copyOf(elements, 2 * size + 1);
    //         }
    //         elements[size++] = e; // Object 배열에 E 타입을 저장할 수 있다.
    //     }

    //     public E pop() {
    //         if (size == 0) {
    //             throw new EmptyStackException();
    //         }
    //         @SuppressWarnings("unchecked")
    //         E result = (E) elements[--size]; // 형변환을 해야 한다. : 코드가 지저분해진다.
    //         elements[size] = null;
    //         return result;
    //     }

    //     public boolean isEmpty() {
    //         return size == 0;
    //     }
    // }

    // class TestDriver {
    //     public static void main(String[] args) {
    //         Stack<String> stack = new Stack<>();
    //         stack.push("A");
    //         stack.push("B");
    //         stack.push("C");
    //         while (!stack.isEmpty()) {
    //             System.out.println(stack.pop());
    //         }
    //     }
    // }

    // 형변환 문제가 발생하므로, 두 가지 방법 중, E[] 배열을 사용하는 것이 좋다.
    // 하지만, 제네릭 배열 생성을 피하고, 대신 ArrayList와 같은 컬렉션 클래스를 사용하는 것이 가장 좋다.

// 3. Entry<K, V> 요소로 구성된 배열 리스트를 관리하는 Table<K, V> 클래스를 구현하라. 
// 키와 연관된 값을 얻어 오는 메서드와 키에 대응하는 값을 집어넣는 메서드, 키를 삭제하는 메서드를 제공해야 한다.

    // class Table<K, V> {
    //         private ArrayList<Entry<K, V>> entries;

    //         public Table() {
    //             entries = new ArrayList<>();
    //         }

    //         public V get(K key) {
    //             for (Entry<K, V> entry : entries) {
    //                 if (entry.getKey().equals(key)) {
    //                     return entry.getValue();
    //                 }
    //             }
    //             return null;
    //         }

    //         public void put(K key, V value) {
    //             for (Entry<K, V> entry : entries) {
    //                 if (entry.getKey().equals(key)) {
    //                     entry.setValue(value);
    //                     return;
    //                 }
    //             }
    //             entries.add(new Entry<>(key, value));
    //         }

    //         public void remove(K key) {
    //             for (int i = 0; i < entries.size(); i++) {
    //                 if (entries.get(i).getKey().equals(key)) {
    //                     entries.remove(i);
    //                     return;
    //                 }
    //             }
    //         }

    //         private static class Entry<K, V> {
    //             private final K key;
    //             private V value;

    //             public Entry(K key, V value) {
    //                 this.key = key;
    //                 this.value = value;
    //             }

    //             public K getKey() {
    //                 return key;
    //             }

    //             public V getValue() {
    //                 return value;
    //             }

    //             public void setValue(V value) {
    //                 this.value = value;
    //             }
    //         }
    // }

    // class TestDriver {
    //         public static void main(String[] args) {
    //             Table<String, Integer> table = new Table<>();
    //             table.put("A", 1);
    //             table.put("B", 2);
    //             table.put("C", 3);
    //             table.put("D", 4);
    //             table.put("E", 5);
    //             table.put("F", 6);
    //             table.put("G", 7);
    //             table.put("H", 8);
    //             table.put("I", 9);
    //             table.put("J", 10);
    //             table.put("K", 11);
    //             table.put("L", 12);
    //             table.put("M", 13);
    //             table.put("N", 14);
    //             table.put("O", 15);
    //             table.put("P", 16);
    //             table.put("Q", 17);
    //             table.put("R", 18);
    //             table.put("S", 19);
    //             table.put("T", 20);
    //             table.put("U", 21);
    //             table.put("V", 22);
    //             table.put("W", 23);
    //             table.put("X", 24);
    //             table.put("Y", 25);
    //             table.put("Z", 26);

    //             System.out.println(table.get("A"));
    //             System.out.println(table.get("B"));
    //             System.out.println(table.get("C"));
    //             System.out.println(table.get("D"));
    //             System.out.println(table.get("E"));
    //             System.out.println(table.get("F"));
    //             System.out.println(table.get("G"));
    //             System.out.println(table.get("H"));
    //             System.out.println(table.get("I"));
    //             System.out.println(table.get("J"));
    //             System.out.println(table.get("K"));
    //             System.out.println(table.get("L"));
    //             System.out.println(table.get("M"));
    //             System.out.println(table.get("N"));
    //             System.out.println(table.get("O"));
    //             System.out.println(table.get("P"));
    //             System.out.println(table.get("Q"));
    //             System.out.println(table.get("R"));
    //             System.out.println(table.get("S"));
    //             System.out.println(table.get("T"));
    //             System.out.println(table.get("U"));
    //             System.out.println(table.get("V"));
    //             System.out.println(table.get("W"));
    //             System.out.println(table.get("X"));
    //             System.out.println(table.get("Y"));
    //             System.out.println(table.get("Z"));

    //             table.remove("A");
    //             table.remove("B");
    //     }
    // }

// 4. 연습문제 3의 Entry를 중첩 클래스로 만들어라. 이 클래스가 제네릭이어야 하는가?
// 5. 배열을 가변 인수로 전달할 수 있게 하는 swap 메서드가 있다고 하자.
// 오류 메시지가 개선되었는가? 문제를 해결하려면 어떻게 해야 하는가?
    // class TestDriver {
    //     public static <T> T[ ] swap(int i, int j, T... values) {

    //     T temp = values[i];

    //     values[i] = values[j];

    //     values[j] = temp;

    //     return values;
    //     }

    //     public static void main(String[] args) {
    //         // 반환값의 타입이 일치하지 않음
    //         // Double[ ] result = TestDriver.swap(0, 1, 1.5, 2, 3); // Type mismatch: cannot convert error

    //         // 인자와 타입이 일치하지 않음
    //         // Double[ ] result = TestDriver.<Double>swap(0, 1, 1.5, 2, 3); // parameterized method

    //         Double[ ] result = TestDriver.<Double>swap(0, 1, 1.5, 2.0, 3.0);
    //         System.out.println(result[0] + " " + result[1] + " " + result[2]);
    //     }
    // }





// 6. 한 배열 리스트에 들어 있는 모든 요소를 다른 배열 리스트에 추가하는 제네릭 메서드를 구현하라. 
// 타입 인수 중 하나에 와일드카드를 사용하라. 동등한 해법을 두 가지 제시하되, 
// 하나는 ? extends E 와일드카드를 사용하고 다른 하나는 ? super E를 사용하게 만들어라.

    // class ListUtils {

    //     // ? extends E 와일드카드를 사용한 해법
    //     public static <E> void addAll(List<? extends E> source, List<E> target) { 
    //         for (E element : source) {
    //             target.add(element);
    //         }
    //     }

    //     // ? super E 와일드카드를 사용한 해법
    //     public static <E> void addAll2(List<E> source, List<? super E> target) {
    //         for (E element : source) {
    //             target.add(element);
    //         }
    //     }

    //     public static void main(String[] args) {
    //         List<Integer> source = new ArrayList<>();
    //         source.add(1);
    //         source.add(2);
    //         source.add(3);
            
    //         // Integer는 Number의 하위 타입이므로 가능
    //         List<Number> target = new ArrayList<>(); 
    //         ListUtils.addAll(source, target);
    //         System.out.println(target);

    //         List<Number> target2 = new ArrayList<>(); 
    //         ListUtils.addAll2(source, target2);
    //         System.out.println(target2);
    //     }
    // }

// 7. E 타입 요소 쌍을 저장하는 Pair<E> 클래스를 구현하라(첫 번째와 두 번째 요소를 얻어 오는 접근자를 구현해야 한다).

    // class Pair<E> {

    //     private final E first;
    //     private final E second;

    //     public Pair(E first, E second) {
    //         this.first = first;
    //         this.second = second;
    //     }

    //     // 접근자
    //     public E getFirst() {
    //         return first;
    //     }
    //     public E getSecond() {
    //         return second;
    //     }
    // }

    // class TestDriver {
    //     public static void main(String[] args) {
    //         Pair<String> pair = new Pair<>("Hello", "World");
    //         System.out.println(pair.getFirst());
    //         System.out.println(pair.getSecond());
    //     }
    // }



// 8. 연습문제 7에서 만든 클래스를 수정해서 각각 두 요소 중 큰 요소와 작은 요소를 얻어 오는 max와 min을 추가하라. 
// E에 적절한 타입 경계를 지정하라.

    // class Pair<E extends Comparable<E>> { // E에 적절한 타입 경계를 지정

    //     private final E first;
    //     private final E second;

    //     public Pair(E first, E second) {
    //         this.first = first;
    //         this.second = second;
    //     }

    //     public E getFirst() {
    //         return first;
    //     }

    //     public E getSecond() {
    //         return second;
    //     }

    //     public E max() {
    //         if (first.compareTo(second) >= 0) {
    //             return first;
    //         } else {
    //             return second;
    //         }
    //     }

    //     public E min() {
    //         if (first.compareTo(second) <= 0) {
    //             return first;
    //         } else {
    //             return second;
    //         }
    //     }
    // }

    // class TestDriver {
    //     public static void main(String[] args) {
    //         Pair<String> pair = new Pair<>("Hello", "World");
    //         System.out.println(pair.getFirst());
    //         System.out.println(pair.getSecond());
    //         System.out.println(pair.max());
    //         System.out.println(pair.min());
    //     }
    // }

// 9. 유틸리티 클래스 Arrays에 다음 메서드를 작성하라.
// public static <E> Pair<E> firstLast(ArrayList<_ _ _> a)
// 이 메서드는 a의 첫 번째와 마지막 요소로 구성된 쌍을 반환해야 한다. 적절한 타입 인수도 제공해야 한다.

    // class Pair<E> {
    //     private final E first;
    //     private final E second;
        
    //     public Pair(E first, E second) {
    //         this.first = first;
    //         this.second = second;
    //     }
        
    //     public E getFirst() {
    //         return first;
    //     }
        
    //     public E getSecond() {
    //         return second;
    //     }
    // }

    // class Arrs {
    //     public static <E> Pair<E> firstLast(ArrayList<E> a) {
    //         if (a == null || a.isEmpty()) {
    //             return null;
    //         }
            
    //         E first = a.get(0);
    //         E last = a.get(a.size() - 1);
            
    //         return new Pair<E>(first, last);
    //     }

    //     public static <T extends Comparable<T>> T min(T[] array) {
    //         if (array == null || array.length == 0) {
    //             return null;
    //         }
            
    //         T min = array[0];
    //         for (int i = 1; i < array.length; i++) {
    //             if (array[i].compareTo(min) < 0) {
    //                 min = array[i];
    //             }
    //         }
            
    //         return min;
    //     }
        
    //     public static <T extends Comparable<T>> T max(T[] array) {
    //         if (array == null || array.length == 0) {
    //             return null;
    //         }
            
    //         T max = array[0];
    //         for (int i = 1; i < array.length; i++) {
    //             if (array[i].compareTo(max) > 0) {
    //                 max = array[i];
    //             }
    //         }
            
    //         return max;
    //     }

    //     static <T> void minmax(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
    //         if (elements == null || elements.isEmpty()) {
    //             return;
    //         }

    //         T min = Collections.min(elements, comp);
    //         T max = Collections.max(elements, comp);

    //         result.clear();
    //         result.add(min);
    //         result.add(max);
    //     }
    // }

    // class TestDriver {
    //     public static void main(String[] args) {
    //         ArrayList<String> list = new ArrayList<>();
    //         list.add("Hello");
    //         list.add("World");
    //         list.add("!");
            
    //         Pair<String> pair = Arrs.firstLast(list);
    //         System.out.println(pair.getFirst());
    //         System.out.println(pair.getSecond());
    //     }
    // }

// 10. Arrays 유틸리티 클래스에 각 배열에서 가장 작은 요소와 가장 큰 요소를 돌려주는 제네릭 메서드 min과 max를 구현하라.
// 11. 연습문제 10에 이어서 최솟값과 최댓값으로 구성된 Pair를 돌려주는 minMax 메서드를 구현하라.
// 12. elements에서 가장 작은 요소와 가장 큰 요소를 result 리스트에 저장하는 다음 메서드를 구현하라.
// public static <T> void minmax(List<T> elements, Comparator<? super T> comp, List<? super T> result)
// 마지막 매개변수에 있는 와일드카드에 유의하자(어떤 타입이든 T의 슈퍼타입이면 결과를 저장할 수 있다).
// 13. 연습문제 12에서 구현한 메서드가 있는 상태에서 다음 메서드를 생각해 보자.

        // static <T> void maxmin(List<T> elements, Comparator<? super T> comp, List<? super T> result) {

        //     minmax(elements, comp, result);
        //     Lists.swapHelper(result, 0, 1);

        // }

// 와일드카드 캡처가 일어나지 않아 이 메서드가 컴파일되지 않는다. 그 이유가 무엇인가? 
// Lists.<_ _ _> swapHelper(result, 0, 1) 형태로 명시적인 타입을 전달한다.

        // 하지만, 와일드카드 타입에서는 타입 캡처가 일어납니다. 
        // 타입 캡처란, 컴파일러가 해당 메서드가 실행될 때 타입 인자를 무엇으로 대체할 지를 결정하는 과정입니다. 
        // 따라서 maxmin 메서드에서 result 리스트에 저장되는 요소 타입이 어떤 것인지는 컴파일 시간에 결정되어야 하지만, 
        // minmax 메서드에서는 런타임 시간에 결정되는 최솟값과 최댓값을 저장하고 있기 때문에 이러한 교환이 불가능합니다.

        // 따라서, maxmin 메서드에서 minmax 메서드를 호출할 때, 결과를 저장하기 위한 별도의 리스트를 만들어 사용하거나, 
        // result 리스트를 복제한 후 교환 작업을 수행하는 등의 방법을 사용해야 합니다.

// 14. 6.3 타입 경계에서 나온 closeAll 메서드를 개선한 버전을 구현하라. 
// 일부 호출에서 예외를 던지더라도 모든 요소를 닫아야 한다. 
// 이때는 닫기를 마친 후 예외를 던진다. 
// 호출 두 개 이상에서 예외를 던지면 이들을 연결하라.

    // class Closeables {
    //     public static void closeAll(List<? extends AutoCloseable> elems) throws Exception { 
    //         Exception exception = null; 
    //         for (AutoCloseable elem : elems) {  
    //             try {
    //                 elem.close();
    //             } catch (Exception e) {
    //                 if (exception == null) {
    //                     // MultiException은 예외를 연결하기 위해 addSuppressed 메서드를 제공합니다.
    //                     exception = new MultiException(); 
    //                 }
    //                 exception.addSuppressed(e); // 예외를 연결합니다.
    //             }
    //         }
    //         if (exception != null) {
    //             throw exception; // 예외를 던집니다.
    //         }
    //     }

    //     private static class MultiException extends Exception {
    //         private static final long serialVersionUID = 1L; 

    //         public void addSuppressed(Exception e) {
    //             super.addSuppressed(e); // 예외를 연결합니다.
    //         }
    //     }

    //     public static void main(String[] args) {
    //         List<AutoCloseable> elems = new ArrayList<>();
    //         elems.add(new AutoCloseable() {
    //             @Override
    //             public void close() throws Exception {
    //                 System.out.println("1");
    //                 throw new Exception("1");
    //             }
    //         });
    //         elems.add(new AutoCloseable() {
    //             @Override
    //             public void close() throws Exception {
    //                 System.out.println("2");
    //                 throw new Exception("2");
    //             }
    //         });
    //         elems.add(new AutoCloseable() {
    //             @Override
    //             public void close() throws Exception {
    //                 System.out.println("3");
    //                 throw new Exception("3");
    //             }
    //         });
    //         try {
    //             closeAll(elems);
    //         } catch (Exception e) {
    //             e.printStackTrace();
    //         }
    //     }
    // }


// 15. 배열 리스트 한 개와 Function<T, R> 객체(3장 인터페이스와 람다 표현식 참고)를 한 개 받고, 
// 전달받은 함수를 리스트에 있는 요소에 적용한 결과로 구성된 배열 리스트를 반환하는 map 메서드를 구현하라.

    // class Arrs {

    //     public static <T, R> ArrayList<R> map(ArrayList<T> list, Function<T, R> function) { // T 타입을 R 타입으로 변환하는 함수
    //         ArrayList<R> result = new ArrayList<R>(list.size()); // 결과를 저장할 리스트
    //         for (T t : list) {
    //             result.add(function.apply(t)); // 리스트의 요소를 함수에 적용한 결과를 저장
    //         }
    //         return result;
    //     }

    //     public static void main(String[] args) {
    //         ArrayList<Integer> intList = new ArrayList<Integer>();
    //         intList.add(1);
    //         intList.add(2);
    //         intList.add(3);

    //         // 각 요소에 2를 곱한 결과를 구성하는 ArrayList<Integer>를 반환
    //         ArrayList<Double> multipliedList = map(intList, x -> x * 2.5); 

    //         System.out.println(multipliedList); // [2.5, 5.0, 7.5]
    //     }
    // }

// 16. Collection 클래스에 들어 있는 다음 메서드에서 소거 대상은?

    // public static <T extends Comparable<? super T>>

    // void sort(List<T> list) // Comparable<T> 인터페이스의 제네릭 타입 매개변수 T에 대한 정보가 소거된다.

    // public static <T extends Object & Comparable<? super T>>

    // T max(Collection<? extends T> coll) // Collection 인터페이스의 와일드카드 타입인 Collection<? extends T>에 대한 정보와 
    // Comparable<T> 인터페이스의 제네릭 타입 매개변수 T에 대한 정보가 소거된다.


// 17. Comparable<Employee>를 구현하는 Employee 클래스를 정의하라. 
// javap 유틸리티로 브리지 메서드가 만들어졌다는 사실을 입증하라. 이 브리지 메서드는 무슨 일을 하는가?

    // class Employee implements Comparable<Employee> {
    //     private String name;
    //     private int age;

    //     public Employee(String name, int age) {
    //         this.name = name;
    //         this.age = age;
    //     }

    //     public String getName() {
    //         return name;
    //     }

    //     public int getAge() {
    //         return age;
    //     }

    //     @Override
    //     public int compareTo(Employee other) {
    //         return Integer.compare(this.age, other.age);
    //     }
    // }

    // 이 클래스를 javap 유틸리티로 디컴파일하면 다음과 같은 결과가 나옵니다.

            // Compiled from "Employee.java"
            // public class Employee implements java.lang.Comparable<Employee> {
            // public Employee(java.lang.String, int);
            // public java.lang.String getName();
            // public int getAge();
            // public int compareTo(Employee);

            // 브리지 메서드 : 컴파일러가 자동으로 생성하는 메서드로, 
            // 제네릭 타입에 대한 호환성을 보장하는 역할을 합니다.
            // 따라서 Comparable<Employee>를 구현하는 클래스에서는 
            // compareTo 메서드를 오버라이드하면서 
            // compareTo(Object) 메서드도 함께 오버라이드하게 됩니다.

            // public int compareTo(java.lang.Object); // 브리지 메서드
            // }
    

// 18. 6.6.3 타입 변수를 인스턴스화할 수 없다에서 나온 다음 메서드를 생각해 보자.

    // class TestDriver {
    //     public static <T> T[ ] repeat(int n, T obj, IntFunction<T[ ]> constr) {

    //         T[ ] result = constr.apply(n);

    //         for (int i = 0; i < n; i++) result[i] = obj;

    //         return result;

    //     }

    //     public static void main(String[] args) {

    //         Integer[ ] integers = repeat(10, 42, Integer[ ]::new); // int[ ]::new 대신 Integer[ ]::new를 사용
    //         // 

    //         for (Integer i : integers) System.out.println(i);
    //     }
    // }



// Arrays.repeat(10, 42, int[ ]::new) 호출은 실패한다. 그 이유는? 
// 이 문제를 어떻게 고칠 수 있는가? 다른 기본 타입이라면 어떤 작업을 해야 하는가?

        // 이유는 int[]::new가 IntFunction<int[]> 형식에 맞지 않기 때문입니다. 
        // int[]는 기본 타입이므로 참조 타입으로 감싸야 합니다.

        // 이 문제를 해결하기 위해서는 int[] 대신 Integer[]을 사용하거나, 
        // 람다 표현식으로 IntFunction<int[]>를 직접 구현해야 합니다.

// 19. 6.6.3절에서 나온 다음 메서드를 생각해 보자.

    // class TestDriver {
    //     public static <T> ArrayList<T> repeat(int n, T obj) {

    //         ArrayList<T> result = new ArrayList<>(); // OK

    //         for (int i = 0; i < n; i++) result.add(obj);

    //         return result;

    //     }
    // }


// 이 메서드는 T 값의 배열을 담는 ArrayList<T>를 문제없이 생성할 수 있다. 
// Class 값이나 생성자 참조를 이용하지 않고도 이 배열 리스트에서 T[ ] 배열을 만들어 낼 수 있는가? 만들 수 없다면 그 이유는?
    // T[] 배열 생성은 허용되지 않습니다. 제네릭 배열 생성이 허용되지 않는 이유는 타입 안전성 때문입니다. 
    // 제네릭 타입 정보는 컴파일 타임에만 존재하고 런타임에는 지워지기 때문에 런타임에는 제네릭 배열의 실제 타입을 알 수 없습니다. 
    // 이로 인해 런타임에 잘못된 타입의 객체가 배열에 저장될 수 있습니다.
// 20. 다음 메서드를 구현하라.

    // class TestDriver {
    //     @SafeVarargs
    //     public static final <T> T[] repeat(int n, T... objs) {
    //         T[] result = Arrays.copyOf(objs, n * objs.length);
    //         for (int i = 1; i < n; i++) {
    //             System.arraycopy(objs, 0, result, i * objs.length, objs.length); // objs를 result에 복사
    //         }
    //         return result;
    //     }

    //     public static void main(String[] args) {
    //         String[] strings = repeat(10, "Hello", "World");
    //         for (String s : strings) {
    //             System.out.println(s);
    //         }
    //     }
    // }
    

// 이 메서드는 전달받은 객체의 사본 n개로 구성된 배열을 반환해야 한다. 
// 리플렉션으로 objs를 증식할 수 있으므로 Class 값이나 생성자 참조가 필요 없다는 점에 주목하라.
// 21. @SafeVarargs 애너테이션을 이용해 제네릭 타입의 배열을 생성하는 메서드를 작성하라. 예를 들어 다음과 같다.
// List<String>[ ] result = Arrays.<List<String>>construct(10);
// // result를 크기 10인 List<String>[ ]으로 설정한다.


    // class GenericArray {
        
    //     @SafeVarargs // 경고 억제 애너테이션
    //     public static <T> T[] construct(int length, T... elements) {
    //         T[] array = Arrays.copyOf(elements, length);
    //         return array;
    //     }

    //     public static void main(String[] args) {
    //         List<String>[] result = GenericArray.<List<String>>construct(10);
    //         System.out.println(Arrays.toString(result)); 
    //     }
    // }

// 22. 6.6.7 예외와 제네릭에서 나온 public static <V, T extends Throwable> V doWork(Callable<V> c, T ex) throws T 메서드를 
// 개선해서 절대 사용되지 않을 예외 객체를 전달하지 않아도 되게 하라. 
// 그 대신 예외 클래스의 생성자 참조를 받게 하라.

    // class TestDriver {
    //     public static <V, T extends Throwable> V doWork(Callable<V> c, T ex) throws T {

    //         try {
    //             return c.call();

    //         } catch (Throwable realEx) {

    //             ex.initCause(realEx);
    //             throw ex;
    //         }
    //     }
    // }

    // class TestDriver {
    //     public static <V, T extends Throwable> V doWork(Callable<V> c, Class<T> exClass) throws T {
    //         try {
    //             return c.call();
    //         } catch (Throwable ex) {
    //             try {
    //                 T exception = exClass.getConstructor(String.class, Throwable.class)
    //                                     .newInstance("Error executing task", ex);
    //                 throw exception;
    //             } catch (Exception e) {
    //                 throw new RuntimeException("Failed to create exception", e);
    //             }
    //         }
    //     }
    // }



// 23. 6.6.7절 끝부분에 있는 주의 항목에서는 throwAs 헬퍼 메서드를 사용해 ex를 
// RuntimeException으로 ‘캐스트’해서 다시 던졌다. 
// 일반적인 캐스트, 즉 throw (RuntimeException) ex를 사용할 수 없는 이유는?

    // throw (RuntimeException) ex와 같은 일반적인 캐스트는 사용할 수 없는 이유는 예외 클래스가 다형성을 지원하지 않기 때문입니다.

    // 예외 클래스는 Throwable 클래스를 상속하며, 
    // 모든 예외 클래스는 Throwable 클래스의 서브 클래스입니다. 
    // 이 때, 예외 클래스는 다형성을 지원하지 않습니다. 예외 객체는 컴파일 타임에 정확한 타입으로 결정되며, 
    // 런타임에 다른 예외 타입으로 변경될 수 없습니다.

    // 따라서, throw (RuntimeException) ex와 같이 일반적인 캐스트를 사용하면 컴파일러는 이를 허용하지 않습니다. 
    // 대신, RuntimeException의 생성자를 사용하여 새로운 RuntimeException 객체를 생성하고, 
    // 원본 예외 객체를 그 객체의 cause로 설정하는 것이 가능합니다. 
    // 이렇게 생성된 RuntimeException 객체를 throw하여 예외를 다시 던지면, 
    // 호출자는 이를 처리할 수 있습니다.

    // 위 내용을 적용하여 throwAs 헬퍼 메서드를 사용하면, 
    // ex를 RuntimeException으로 "캐스트"하여 다시 던질 수 있습니다. 
    // throwAs 메서드는 예외 객체를 던지기 전에 RuntimeException 객체를 생성하고, 
    // 예외 객체를 cause로 설정하여 이를 던집니다. 이렇게 하면 호출자가 RuntimeException을 처리할 수 있으며, 
    // RuntimeException 객체의 cause를 통해 원본 예외 객체를 추적할 수 있습니다.


// 24. 캐스트를 사용하지 않고 Class<?> 타입 변수로 호출할 수 있는 메서드는?
    // class TestDriver {

    //     public static void exampleMethod(Class<?> clazz) {
    //         // 클래스 정보를 출력하는 예시 코드
    //         System.out.println("Class Name: " + clazz.getName());
    //         System.out.println("Is Interface: " + clazz.isInterface());
    //         System.out.println("Is Enum: " + clazz.isEnum());
    //         System.out.println("Is Array: " + clazz.isArray());
    //         // ... 추가적인 클래스 정보를 출력하는 코드
    //     }

    //     public static void main(String[] args) {
    //         // String 클래스의 정보를 출력하는 예시 코드
    //         exampleMethod(String.class);

    //         // Integer 클래스의 정보를 출력하는 예시 코드
    //         exampleMethod(Integer.class);
    //     }
    // }

    


// 25. m 메서드의 선언을 반환하는 public static String genericDeclaration(Method m) 메서드를 작성하라
// (이 선언은 타입 경계를 포함해 타입 매개변수를 나열하고, 
// 제네릭 타입일 때는 타입 인수를 포함해 메서드 매개변수의 타입을 나열해야 한다).

    // class TestDriver {
    //     public static String genericDeclaration(Method m) {
    //         // 메서드 선언을 저장할 StringBuilder 객체를 생성한다.
    //         StringBuilder sb = new StringBuilder();

    //         // 메서드의 반환 타입을 StringBuilder 객체에 추가한다.
    //         Type returnType = m.getGenericReturnType();
    //         sb.append(returnType.getTypeName());

    //         // 메서드의 이름을 StringBuilder 객체에 추가한다.
    //         sb.append(" ");
    //         sb.append(m.getName());

    //         // 메서드의 매개변수 타입을 StringBuilder 객체에 추가한다.
    //         sb.append("(");
    //         Type[] parameterTypes = m.getGenericParameterTypes();
    //         for (int i = 0; i < parameterTypes.length; i++) {
    //             if (i > 0) {
    //                 sb.append(", ");
    //             }
    //             sb.append(parameterTypes[i].getTypeName());
    //         }
    //         sb.append(")");

    //         // 메서드의 타입 매개변수와 타입 경계를 StringBuilder 객체에 추가한다.
    //         TypeVariable<Method>[] typeParameters = m.getTypeParameters();
    //         if (typeParameters.length > 0) {
    //             sb.append("<");
    //             for (int i = 0; i < typeParameters.length; i++) {
    //                 if (i > 0) {
    //                     sb.append(", ");
    //                 }
    //                 sb.append(typeParameters[i].getName());
    //                 Type[] bounds = typeParameters[i].getBounds();
    //                 if (bounds.length > 0 && bounds[0] != Object.class) {
    //                     sb.append(" extends ");
    //                     sb.append(bounds[0].getTypeName());
    //                 }
    //             }
    //             sb.append(">");
    //         }

    //         return sb.toString();
    //     }

    //     public static void main(String[] args) {
    //         String s = genericDeclaration(TestDriver.class.getMethods()[0]);
    //         System.out.println(s);
    //     }
    // }