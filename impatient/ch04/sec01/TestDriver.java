package ch04.sec01;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.ServiceLoader;

/* sec 01 : class extension */
    // step 01 : inheritance
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
        // class Manager extends Employee {
        //     private double bonus;
            
        //     public Manager(String name, double salary) {
        //         super(name, salary);
        //         bonus = 0;
        //     }
            
        //     public void setBonus(double bonus) {
        //         this.bonus = bonus;
        //     }
            
        //     public double getSalary() { // 슈퍼클래스의 메서드를 오버라이드한다.
        //         return super.getSalary() + bonus;
        //     }
        // }
        // class InheritanceDemo {
        //     public static void main(String[] args) {
        //         Manager boss = new Manager("Fred", 200000);
        //         boss.setBonus(10000); 
        //         System.out.println(boss.getName() + ": " + boss.getSalary());
        //         boss.raiseSalary(5); 
        //         System.out.println(boss.getName() + ": " + boss.getSalary());
        //         Employee empl = boss; // upcasting : 슈퍼클래스 변수에 서브클래스 객체를 대입한다.
        //         empl.raiseSalary(5); 
        //         System.out.println(boss.getName() + ": " + boss.getSalary());

        //         if (empl instanceof Manager) {
        //             Manager mgr = (Manager) empl;
        //             mgr.setBonus(20000);
        //         }
        //         System.out.println(boss.getName() + ": " + boss.getSalary());
        //     }
        // }
    // step 02 : abstract class & abstract method

        // interface Named {
        //     default String getName() { return ""; }
        // }
        
        // abstract class Person {
        //     private String name;

        //     public Person(String name) { this.name = name; }
        //     public final String getName() { return name; }

        //     public abstract int getId();
        // }

        // class Student extends Person implements Named {
        //     private int id;
        
        //     public Student(String name, int id) { super(name); this.id = id; }
        //     public int getId() { return id; }
        // }

        // class StudentDemo {
        //     public static void main(String[] args) {
        //         // // Person p3 = new Person("Peter"); // 추상 메서드를 구현하지 않았으므로 할당할 수 없다.

        //         // Person p = new Student("Fred", 1729); // 구체적인 서브클래스이므로 할당해도 된다.
        //         // Person p2 = new Person("Fred") { // 익명 클래스
        //         //     public int getId() { return 0; } // 추상 메서드를 구현하여 할당할 수 있다.
        //         // };
        //         // System.out.println(p2.getName());
        //         // Student s = (Student) p; // 다운캐스팅
        //         // System.out.println(s.getName());
        //         // Named n = s; // 업캐스팅
        //         // System.out.println(n.getName());
        //     }
        // }
    

    // step 03 : anonymous subclass
        // class AnonymousSubclassDemo {
        //     public static void main(String[] args) {
        //         ArrayList<String> names = new ArrayList<String>(100) {
        //             public void add(int index, String element) {
        //                 super.add(index, element);
        //                 System.out.printf("Adding %s at %d\n", element, index);
        //             }
        //         };
        //         System.out.println(names); // []
                
        //         names.add(0, "Peter");
        //         names.add(1, "Paul");
        //         names.add(0, "Mary");
        //         System.out.println(names);  // [Mary, Peter, Paul]

        //     }
        // }

    // step 04 : 

        // class Worker {
        //     public void work() { 
        //         for (int i = 0; i < 100; i++) System.out.println("Working"); 
        //     }
        // }
        // class ConcurrentWorker extends Worker {
        //     public void work() { 
        //         Thread t = new Thread(super::work);
        //         t.start();
        //     }
        // }
        // class ConcurrentWorkerTest {
        //     public static void main(String[] args) {
        //         ConcurrentWorker worker = new ConcurrentWorker();
        //         worker.work();
        //         System.out.println("Done");
        //     }
        // }


/**/
/* sec 02 : Object, super class */
    // step 01 : equals
        // class Item {
        //     String description;
        //     Double price;

        //     public Item(String description, double price) {
        //         this.description = description;
        //         this.price = price;
        //     }

        //     @Override
        //     public boolean equals(Object otherObject) {
        //         if (this == otherObject) return true; // 두 객체가 같은 객체인지 검사한다.
        //         if (otherObject == null) return false; // otherObject가 null인지 검사한다.
        //         if (getClass() != otherObject.getClass()) return false; // otherObject가 Item의 인스턴스인지 검사한다.
        //         Item other = (Item) otherObject; // otherObject를 Item으로 형변환한다.
        //         return description.equals(other.description) // 인스턴스 변수들의 값이 동일한지 검사한다.
        //             && price.equals(other.price); // NaN, infinity safe : Double.equals() // null safe : String.equals()
        //     }

        //     public int hashCode() {
        //         return Objects.hash(description, price);
        //     }
        // }
        // class DiscountedItem extends Item {

        //     double discount;

        //     public DiscountedItem(String description, double price) {
        //         super(description, price);
        //         this.discount = discount;
        //     }

        //     @Override
        //     public boolean equals(Object otherObject) {
        //         if (!super.equals(otherObject)) return false; // 슈퍼클래스의 equals()를 호출한다. 
        //         DiscountedItem other = (DiscountedItem) otherObject; 
        //         return discount == other.discount;
        //     }

        //     public int hashCode() {
        //         return Objects.hash(super.hashCode(), discount);
        //     } 
        // }

    // step 02 : equals or instanceof
        // class Employee {
        //     int id;
            
        //     public Employee(int id) {
        //         this.id = id;
        //     }
        //     @Override
        //     public final boolean equals(Object otherObject) {
        //         if (this == otherObject) return true;
        //         // equals를 final로 선언하였다.
        //             // if (otherObject == null) return false;
        //             // if (getClass() != otherObject.getClass()) return false;
        //         // 위의 코드를 대신하여 instanceof 연산자를 사용하는 경우는 동등성 개념이 슈퍼클래스에 고정되어 있으면서 서브클래스에서 절대 변하지 않을 때다.
                
        //         if (!(otherObject instanceof Employee)) return false; // instanceof 연산자를 사용한다.
        //         Employee other = (Employee) otherObject;
        //         return id == other.id;
        //     }
        // }

    // step 03 : override Object.clone()

        // 일반적으로 클래스를 구현할 때는 다음 상황을 판단해야 한다.
        // 1. clone 메서드를 구현하지 않아도 되는가? : clone 메서드는 Object의 protected 메서드이다. : 상위 클래스에서 clone 메서드를 콜한다.
        // 2. 구현해야 한다면, 상속받은 clone 메서드를 사용해도 괜찮은가? : Cloneable 인터페이스를 구현하고, clone 메서드를 오버라이드 한다. : Object.clone 메서드는 얕은 복사를 수행하기에 앞서 클래스가 Cloneable 인터페이스를 구현했는지 검사하고, 구현하지 않았다면 CloneNotSupportedException을 던진다.
        // 3. 그렇지 않다면, clone 메서드에서 깊은 복사를 수행해야 하는가?

        // 마땅한 이유가 없다면, clone() 메서드는 오버라이드 하지 않는 것이 좋다. (5%)
        // shallow copy 를 수행한다. : 인스턴스 변수가 기본 타입이거나, 불변 타입이면 문제가 없다. (String, Integer, Double, ...)
        // 인스턴스 변수가 가변 타입이면, 원본과 복제본이 상태를 공유하므로 문제의 소지가 있다. (ArrayList, HashMap, ...)
        // 불변 타입 종류 : String, Integer, Double, Boolean, Character, BigInteger, BigDecimal, ...
        // 가변 타입 종류 : ArrayList, HashMap, ...

        // class Employee implements Cloneable{
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
            
        //     public String toString() {
        //         return "[name=" + name
        //              + ",salary=" + salary + "]";
        //     }
            
        //     public Employee clone() throws CloneNotSupportedException {
        //         return (Employee) super.clone();
        //     }
        // }
        // class Manager extends Employee {
        //     private double bonus;
            
        //     public Manager(String name, double salary) {
        //         super(name, salary);
        //         bonus = 0;
        //     }
            
        //     public void setBonus(double bonus) {
        //         this.bonus = bonus;
        //     }
            
        //     public double getSalary() { // 슈퍼클래스의 메서드를 오버라이드한다.
        //         return super.getSalary() + bonus;
        //     }
            
        //     public String toString() {
        //         return super.toString() + "[bonus=" + bonus + "]";
        //     }
            
        //     public Manager clone() throws CloneNotSupportedException {
        //         return (Manager) super.clone();
        //     }
        // }
        // class CloneTest {
        //     public static void main(String[] args) {
        //         try {
        //             Employee original = new Employee("John Q. Public", 50000);
        //             original.raiseSalary(10);
        //             Employee copy = original.clone();
        //             copy.raiseSalary(10);
        //             System.out.println("original=" + original);
        //             System.out.println("copy=" + copy);
        //         }
        //         catch (CloneNotSupportedException e) {
        //             e.printStackTrace();
        //         }
        //     }
        // }

        // Cloneable 인터페이스를 구현하지 않은 클래스에서 clone() 메서드를 호출하면 CloneNotSupportedException 예외가 발생합니다.
        // 이는 Cloneable 인터페이스를 구현하지 않은 클래스에서는 clone() 메서드를 사용하여 객체를 복제할 수 없다는 것을 나타냅니다.
        // Cloneable 인터페이스는 마커 인터페이스이므로 메서드를 갖지 않습니다.
        // 그러나, 객체를 복제할 수 있는지 여부를 확인하기 위해 Object 클래스의 clone() 메서드에서 Cloneable 인터페이스를 구현했는지 여부를 체크합니다.
        // 이 때, Cloneable 인터페이스를 구현하지 않은 클래스에서 clone() 메서드를 호출하면 예외가 발생합니다.

        // final class Message implements Cloneable { // Cloneable 인터페이스 : clone() 메서드를 호출할 수 있도록 허용한다.
        //     private ArrayList<String> recipients;

        //     public Message() {
        //         recipients = new ArrayList<>();
        //     }
        //     public void addRecipient(String recipient) { 
        //         recipients.add(recipient);
        //     };
            
            // 원본과 복제본이 recipients 필드를 공유하게 된다. 
            // 그러므로 Message 클래스는 clone 메서드를 오버라이드해서, 그 구현을 변경하여 깊은 복사를 수행해야 한다.
            // public Message clone() {
                // try {
                //     Message cloned = (Message) super.clone();
                //     return cloned; // 얕은 복사 : Object.clone() 

                //     // @SuppressWarnings("unchecked") // @SuppressWarnings("unchecked") 어노테이션을 사용하여 경고를 무시할 수 있다.
                //     // ArrayList<String> clonedRecipients // 깊은 복사
                //     //     = (ArrayList<String>) recipients.clone(); // ArrayList는 Cloneable 인터페이스를 구현하고 있다.
                //     // cloned.recipients = clonedRecipients; // 깊은 복사 : ArrayList.clone()
                //     // return cloned;
                // } catch (CloneNotSupportedException ex) { // Cloneable 인터페이스를 구현하지 않은 클래스에서 clone() 메서드를 호출하면 CloneNotSupportedException 예외가 발생합니다.
                //     return null; // 이 예외는 발생하지 않는다. : ArrayList.clone()은 CloneNotSupportedException을 던지지 않는다. : Cloneable 인터페이스를 구현하고 있기 때문이다.
                // }

                // deep copy simple
                // Message cloned = new Message();
                // cloned.recipients = new ArrayList<>(recipients); // deep copy
                // return cloned;

                // deep copy 2
                // Message msg = new Message();
                // @SuppressWarnings("unchecked")ArrayList<String> temp = (ArrayList<String>) recipients.clone(); // 선언에만 애너테이션을 붙일 수 있다.
                // msg.recipients = temp;
                // return msg;
            // }
        //     public static void main(String[] args) {
        //         Message message = new Message();
        //         message.addRecipient("recipient");
        //         System.out.println("message.recipients = " + message.recipients);

        //         Message cloned = message.clone(); 
        //         cloned.addRecipient("recipient2");
        //         System.out.println("cloned.recipients = " + cloned.recipients); // message 객체에도 영향을 미친다.
        //         System.out.println("message.recipients = " + message.recipients); 
        //     }
        // }

/**/
/* sec 03 : enum */
    // step 01 : enumeration's method
        // enum Size { SMALL, MEDIUM, LARGE, EXTRA_LARGE };

        // class EnumTest {
        //     public static void main(String[] args) {
        //         // Size s = Size.MEDIUM;
        //         // System.out.println(s); // MEDIUM

        //         // Size notMySize = Size.valueOf("SMALL");
        //         // System.out.println(notMySize); // SMALL

        //         Size[] values = Size.values();
        //         for (Size value : values) {
        //             System.out.println(value);
        //         }
        //         System.out.println(Size.MEDIUM.ordinal()); // 1
        //     }
        // }

    // step 02 : enum with constructor, method, field

        // enum Size {
        //     SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
        
        //     private String abbreviation;
        
        //     Size(String abbreviation) {
        //         this.abbreviation = abbreviation;
        //     }
        
        //     public String getAbbreviation() { return abbreviation; }
        // }

        // class TestDriver {

        //     public static void main(String[] args) {
            
        //         for (Size s : Size.values()) {
        //             System.out.println(s + " " + s.getAbbreviation()); 
        //         }
        //     }
        // }

    // step 03 : enum with instance body

        // enum Operation {
        //     ADD("+") {
        //         public int eval(int arg1, int arg2) { return arg1 + arg2; }
        //     },
        //     SUBTRACT("-") {
        //         public int eval(int arg1, int arg2) { return arg1 - arg2; }
        //     },
        //     MULTIPLY("*") {
        //         public int eval(int arg1, int arg2) { return arg1 * arg2; }
        //     },
        //     DIVIDE("/") {
        //         public int eval(int arg1, int arg2) { return arg1 / arg2; }
        //     };
        
        //     private String symbol;
        //     Operation(String symbol) { this.symbol = symbol; }
        //     public String getSymbol() { return symbol; }
            
        //     public abstract int eval(int arg1, int arg2);
        // }
        // class Calculator {
        //     public static void main(String[] args) {
        //         // System.out.println(Operation.ADD.eval(1, 2));
        //         // Operation op = Operation.ADD;
        //         // System.out.println(op.eval(1, 2));
        //         // System.out.println(op.getSymbol());

        //         Scanner in = new Scanner(System.in);
        //         System.out.print("First operand: ");
        //         int a = in.nextInt();
        //         System.out.print("Operator: ");
        //         String opSymbol = in.next();
        //         System.out.print("Second operand: ");
        //         int b = in.nextInt();
        //         for (Operation op : Operation.values()) {
        //             if (op.getSymbol().equals(opSymbol)) {
        //                 int result = op.eval(a, b);
        //                 System.out.println(result);
        //             } 
        //         }  
        //     }
        // }

        // simple enum
        // enum Operation {
        //     ADD {
        //         public int eval(int arg1, int arg2) { return arg1 + arg2; }
        //     },
        //     SUBTRACT {
        //         public int eval(int arg1, int arg2) { return arg1 - arg2; }
        //     },
        //     MULTIPLY {
        //         public int eval(int arg1, int arg2) { return arg1 * arg2; }
        //     },
        //     DIVIDE {
        //         public int eval(int arg1, int arg2) { return arg1 / arg2; }
        //     };
            
        //     public abstract int eval(int arg1, int arg2);
        // }
        // class TestDriver {
        //     public static void main(String[] args) {
        //         System.out.println(Operation.ADD.eval(1, 2));
        //     }
        // }
       
    // step 04 : enum with static member

        // error : cannot refer to static field in constructor
        // enum Modifier {
        //     PUBLIC, PRIVATE, PROTECTED, STATIC, FINAL, ABSTRACT;
        //     private static int maskBit = 1;
        //     private int mask;
        //     Modifier() { // constructor
        //         mask = maskBit; // cannot refer to static field in constructor
        //         maskBit *= 2;
        //     }
        // }

        // enum Modifier2 {
        //     PUBLIC, PRIVATE, PROTECTED, STATIC, FINAL, ABSTRACT;
        //     private static int maskBit = 1;
        //     private int mask;
        //     static { // static initializer
        //         for (Modifier2 m : Modifier2.values()) { 
        //             m.mask = maskBit; 
        //             maskBit *= 2; 
        //         }
        //     }
        //     public int getMask() { return mask; }
        // }

        // class TestDriver {
        //     public static void main(String[] args) {
        //         System.out.println(Modifier2.PUBLIC.getMask());
        //         System.out.println(Modifier2.PRIVATE.getMask());
        //         System.out.println(Modifier2.PROTECTED.getMask());
        //         System.out.println(Modifier2.STATIC.getMask());
        //         System.out.println(Modifier2.FINAL.getMask());
        //         System.out.println(Modifier2.ABSTRACT.getMask());
        //     }
        // }

    // step 05 : enum with switch

        // i think it is better to not use enum with switch
        // enum Operation { 
        //     ADD, SUBTRACT, MULTIPLY, DIVIDE;

        //     public String getSymbol() {
        //         switch (this) { // 1:1 mapping
        //             case ADD: return "+";
        //             case SUBTRACT: return "-";
        //             case MULTIPLY: return "*";
        //             case DIVIDE: return "/";
        //             default: throw new AssertionError("Unknown op: " + this);
        //         }
        //     }
        // }
        // class Calculator2 {

        //     public static int eval(Operation op, int arg1, int arg2) {
        //         int result = 0;
        //         switch (op) {
        //             case ADD: result = arg1 + arg2; break;
        //             case SUBTRACT: result = arg1 - arg2; break;
        //             case MULTIPLY: result = arg1 * arg2; break;
        //             case DIVIDE: result = arg1 / arg2; break;
        //         }
        //         return result;
        //     }
            
        //     public static void main(String[] args) {
        //         Scanner in = new Scanner(System.in);
        //         System.out.print("First operand: ");
        //         int op1 = in.nextInt();
        //         System.out.print("Operator: ");
        //         String opSymbol = in.next();
        //         System.out.print("Second operand: ");
        //         int op2 = in.nextInt();
        //         for (Operation o : Operation.values()) {
        //             if (o.getSymbol().equals(opSymbol)) {
        //                 System.out.println(eval(o, op1, op2));
        //             }
        //             System.out.println(o.getSymbol()); // + - * /
        //         }
        //     }
        // }
/**/
/* sec 04 : runtime type information and resource */
    // setp 01 : Class
        // class TestDriver {
        //     public static void main(String[] args) {
        //         Object obj = new Object();
        //         Class<?> c1 = obj.getClass();
        //         System.out.println("This object is an instance of " + c1.getName());

        //         String className = "java.util.Date";
        //         try {
        //             Class<?> c2 = Class.forName(className);
        //             System.out.println("This object is an instance of " + c2.getName());
        //         } catch (ClassNotFoundException e) {
        //             System.out.println("Class not found: " + className);
        //         }
        //     }
        // }

        // class ClassDemo {
        //     public static void main(String[] args) throws ReflectiveOperationException {
        //         Object obj = System.out;
        //         Class<?> cl = obj.getClass();
                
        //         System.out.println("This object is an instance of " + cl.getName());
        
        //         String className = "java.util.Scanner";
        //         cl = Class.forName(className);
                
        //         // java.util.Scanner 클래스를 기술하는 객체다.
        //         cl = java.util.Scanner.class;
        //         System.out.println(cl.getName()); // java.util.Scanner

        //         Class<?> cl2 = String[].class; // String[] 배열 타입을 기술한다.
        //         System.out.println(cl2.getName()); // [Ljava.lang.String;
        //         System.out.println(cl2.getCanonicalName()); // java.lang.String[]

        //         Class<?> cl3 = Runnable.class; // Runnable  인터페이스를 기술한다. 
        //         System.out.println(cl3.getName()); // java.lang.Runnable

        //         Class<?> cl4 = int.class; // int 타입을 기술한다.
        //         System.out.println(cl4.getName()); // int

        //         Class<?> cl5 = void.class; // void 타입을 기술한다.
        //         System.out.println(cl5.getName()); // void
        //     }
        // }

    // step 02 : resource load
        // class TestDriver {
        //     public static void main(String[] args) {
        //         InputStream stream = TestDriver.class.getResourceAsStream("/text.txt");
        //         Scanner in = new Scanner(stream);
        //         while (in.hasNextLine()) {
        //             String line = in.nextLine();
        //             System.out.println(line);
        //         }
        //         in.close();
        //     }
        // }
    // step 03 : encryption

    // step 04 : reflection
    
        // class ArrayReflection {
        //     public static Object[] badCopyOf(Object[] array, int newLength) { // 유용하지 않다.
        //         Object[] newArray = new Object[newLength];
        //         for (int i = 0; i < Math.min(array.length, newLength); i++)
        //             newArray[i] = array[i];
        //         return newArray;
        //     }
            
        //     public static Object goodCopyOf(Object array, int newLength) {
        //         Class<?> cl = array.getClass();
        //         System.out.println(array.getClass()); // class [I
        //         if (!cl.isArray()) return null;
        //         Class<?> componentType = cl.getComponentType();
        //         System.out.println(componentType); // int
        //         int length = Array.getLength(array);
        //         Object newArray = Array.newInstance(componentType, newLength);
        //         for (int i = 0; i < Math.min(length, newLength); i++)
        //             Array.set(newArray, i, Array.get(array,  i));
        //         return newArray;
        //     }
            
        //     public static void main(String[] args) {
        //         int[] primes = { 2, 3, 5, 7, 11 };
        //         primes = (int[]) goodCopyOf(primes, 10);
        //         System.out.println(Arrays.toString(primes));
        //     }
        // }
        
/**/