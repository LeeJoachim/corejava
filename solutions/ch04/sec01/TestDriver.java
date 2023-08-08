package ch04.sec01;

import java.io.PrintStream;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
// 1. Point 클래스를 만들고, public Point(double x, double y) 생성자와 getX, getY 접근자 메서드를 정의하라. 
// 또 Point의 서브클래스인 LabeledPoint를 만들고, public LabeledPoint(String label, double x, double y) 생성자와 getLabel 접근자 메서드를 정의하라.
// 2. 연습문제 1에서 만든 Point와 LabeledPoint 클래스에 toString, equals, hashCode 메서드를 정의하라.
// 3. 연습문제 1에서 만든 Point 클래스의 인스턴스 변수 x와 y를 protected로 바꾸어라. 
// LabeledPoint 클래스는 오직 LabeledPoint 인스턴스에 있는 이 변수에만 접근할 수 있음을 보여라.
    // class Point {
    //         protected double x;
    //         protected double y;
    //         public Point(double x, double y) {
    //             this.x = x;
    //             this.y = y;
    //         }
    //         public double getX() { return x; }
    //         public double getY() { return y; }
    //     }
    //     class LabeledPoint extends Point {
    //         private String label;
    //         public LabeledPoint(String label, double x, double y) {
    //             super(x, y);
    //             this.label = label;
    //         }
    //         public String getLabel() { return label; }


    //         public String toString() {
    //             return "LabeledPoint [label=" + label + ", x=" + getX() + ", y=" + getY() + "]";
    //         }

    //         public boolean equals(Object otherObject) {
    //             if (this == otherObject) return true; // 두 객체가 같은 객체인지 검사한다.
    //             if (otherObject == null) return false; // otherObject가 null인지 검사한다.
    //             if (getClass() != otherObject.getClass()) return false; // otherObject가 Item의 인스턴스인지 검사한다.
    //             LabeledPoint other = (LabeledPoint) otherObject; // otherObject를 Item으로 형변환한다.
    //             return label.equals(other.label) // 인스턴스 변수들의 값이 동일한지 검사한다.
    //                 && x == other.x && y == other.y;
    //         }

    //         public int hashCode() {
    //             return Objects.hash(x, y, label);
    //     }
    // }

// 4. Shape 추상 클래스를 정의하라. 
// 이 클래스는 Point 클래스에 인스턴스 변수, 생성자, 지정한 양만큼 점을 옮기는 구체적인 public void moveBy(double dx, double dy) 메서드, 
// public Point getCenter() 추상 메서드를 작성해야 한다. Circle, Rectangle, Line 서브클래스를 구체적으로 정의하고 
// 각각 public Circle(Point center, double radius), public Rectangle(Point topLeft, double width, double height), 
// public Line(Point from, Point to) 생성자를 포함하도록 만들어라.
// 5. 연습문제 4에서 만든 클래스에 clone 메서드를 정의하라.
        // class Point {
        //     public double x;
        //     public double y;
        // }
        // abstract class Shape {
        //     protected Point center;
        //     public Shape(Point center) {
        //         this.center = center;
        //     }
        //     public void moveBy(double dx, double dy) {
        //         center.x += dx;
        //         center.y += dy;
        //     }
        //     public abstract Point getCenter();
        // }
        // class Circle extends Shape {
        //     private double radius;
        //     public Circle(Point center, double radius) {
        //         super(center);
        //         this.radius = radius;
        //     }
        //     public double getRadius() {
        //         return radius;
        //     }
        //     @Override
        //     public Point getCenter() {
        //         return center;
        //     }
        //     // deep copy clone
        //     public Circle clone() {
        //         Circle cloned = new Circle(new Point(), radius);
        //         cloned.center.x = center.x;
        //         cloned.center.y = center.y;
        //         return cloned;
        //     }

            
        // }
        // class Rectangle extends Shape {
        //     private double width;
        //     private double height;
        //     public Rectangle(Point topLeft, double width, double height) {
        //         super(topLeft);
        //         this.width = width;
        //         this.height = height;
        //     }
        //     public double getWidth() {
        //         return width;
        //     }
        //     public double getHeight() {
        //         return height;
        //     }
        //     @Override
        //     public Point getCenter() {
        //         return center;
        //     }
        //     // deep copy clone
        //     public Rectangle clone() {
        //         Rectangle cloned = new Rectangle(new Point(), width, height);
        //         cloned.center.x = center.x;
        //         cloned.center.y = center.y;
        //         return cloned;
        //     }
        // }
        // class Line extends Shape {
        //     private Point from;
        //     private Point to;
        //     public Line(Point from, Point to) {
        //         super(from);
        //         this.from = from;
        //         this.to = to;
        //     }
        //     public Point getFrom() {
        //         return from;
        //     }
        //     public Point getTo() {
        //         return to;
        //     }
        //     @Override
        //     public Point getCenter() {
        //         return center;
        //     }
        //     // deep copy clone
        //     public Line clone() {
        //         Line cloned = new Line(new Point(), new Point());
        //         cloned.center.x = center.x;
        //         cloned.center.y = center.y;
        //         cloned.from.x = from.x;
        //         cloned.from.y = from.y;
        //         cloned.to.x = to.x;
        //         cloned.to.y = to.y;
        //         return cloned;
        //     }
        // }
// 6. 4.2.2 equals 메서드에서 다룬 Item.equals 메서드가 instanceof 검사를 사용한다고 하자. 
// DiscountedItem.equals를 구현해 otherObject가 Item이면 슈퍼클래스만 비교하지만 DiscountedItem이면 할인까지 포함해서 비교하게 하라. 
// 이 메서드가 대칭성은 유지하지만, 추이적(transitive)이지는 않음을 보여라. 
// 다시 말해 x.equals(y)와 y.equals(z)는 성립하지만, x.equals(z)는 성립하지 않는 아이템과 할인 아이템의 조합을 찾아라.

    // class Item {
    //     private String name;
    //     private int price;

    //     public Item(String name, int price) {
    //         this.name = name;
    //         this.price = price;
    //     }

    //     @Override
    //     public boolean equals(Object o) {
    //         if (this == o) return true; // 같은 객체인지 확인 : x.equals(x)는 true
    //         if (o == null || getClass() != o.getClass()) return false; // null이 아니고, 클래스가 같은지 확인
    //         Item item = (Item) o; 
    //         return price == item.price && // 필드가 같은지 확인
    //                 Objects.equals(name, item.name); // 필드가 같은지 확인
    //     }

    //     @Override
    //     public int hashCode() {
    //         return Objects.hash(name, price);
    //     }
    // }
    // class DiscountedItem extends Item {
    //     private double discount;

    //     public DiscountedItem(String name, int price, double discount) {
    //         super(name, price);
    //         this.discount = discount;
    //     }

    //     @Override
    //     public boolean equals(Object o) {
    //         if (this == o) return true; // 같은 객체인지 확인 : x.equals(x)는 true
    //         if (!super.equals(o)) return false; // 슈퍼클래스의 equals를 호출
    //         if (getClass() != o.getClass()) return false; // 클래스가 같은지 확인
    //         DiscountedItem that = (DiscountedItem) o; // 클래스가 같으므로 안전하게 형변환
    //         return Double.compare(that.discount, discount) == 0; // 필드가 같은지 확인
    //     }

    //     @Override
    //     public int hashCode() {
    //         return Objects.hash(super.hashCode(), discount);
    //     }
    // }
    // class TestDriver {
    //     public static void main(String[] args) {
    //         Item item = new Item("apple", 100);
    //         DiscountedItem discountedItem = new DiscountedItem("apple", 100, 0.2);
    //         DiscountedItem discountedItem2 = new DiscountedItem("apple", 100, 0.3);
            
    //         System.out.println(item.equals(discountedItem)); // false : 다른 클래스
    //     }
    // }
// 7. 원색의 조합 여덟 개(BLACK, RED, BLUE, GREEN, CYAN, MAGENTA, YELLOW, WHITE)를 나타내고 getRed, getGreen, getBlue 메서드를 포함하는 열거 타입을 정의하라.

    // enum Color {
    //     BLACK(0, 0, 0),
    //     RED(255, 0, 0),
    //     BLUE(0, 0, 255),
    //     GREEN(0, 255, 0),
    //     CYAN(0, 255, 255),
    //     MAGENTA(255, 0, 255),
    //     YELLOW(255, 255, 0),
    //     WHITE(255, 255, 255);

    //     private int red;
    //     private int green;
    //     private int blue;

    //     Color(int red, int green, int blue) {
    //         this.red = red;
    //         this.green = green;
    //         this.blue = blue;
    //     }

    //     public int getRed() {
    //         return red;
    //     }

    //     public int getGreen() {
    //         return green;
    //     }

    //     public int getBlue() {
    //         return blue;
    //     }
    // }

    // class TestDriver {
    //     public static void main(String[] args) {
    //         Color color = Color.RED; // 255, 0, 0
    //         System.out.println(color.getRed()); // 255
    //         System.out.println(color.getGreen()); // 0
    //         System.out.println(color.getBlue()); // 0
    //     }
    // }
// 8. Class 클래스에는 Class 객체로 나타내는 타입의 문자열 표현을 돌려주는 메서드가 여섯 개 있다. 
// 배열, 제네릭 타입, 내부 클래스, 기본 타입에 이 메서드들을 적용하면 동작이 어떻게 달라지는가?
    
            // getName(): 클래스의 이름을 문자열로 반환합니다.
            // getSimpleName(): 클래스의 간결한 이름을 문자열로 반환합니다.
            // getCanonicalName(): 클래스의 정규 이름을 문자열로 반환합니다.
            // getTypeName(): 클래스의 이름을 문자열로 반환합니다. 제네릭 타입과 내부 클래스에 대한 정보를 포함합니다.
            // toGenericString(): 클래스의 문자열 표현을 반환합니다. 제네릭 타입과 내부 클래스에 대한 정보를 포함합니다.
            // toString(): 클래스의 문자열 표현을 반환합니다. 배열 타입에 대한 정보를 포함합니다.

        // class TestDriver {
        //     public static void main(String[] args) {
        //         // 배열
        //         int[] arr = new int[10];
        //         System.out.println(arr.getClass().getName()); // [I
        //         System.out.println(arr.getClass().getSimpleName()); // int[]
        //         System.out.println(arr.getClass().getCanonicalName()); // int[]
        //         System.out.println(arr.getClass().getTypeName()); // int[]
        //         System.out.println(arr.getClass().toGenericString()); // class [I
        //         System.out.println(arr.getClass().toString()); // class [I

        //         // 제네릭 타입
        //         List<String> list = new ArrayList<>();
        //         System.out.println(list.getClass().getName()); // java.util.ArrayList
        //         System.out.println(list.getClass().getSimpleName()); // ArrayList
        //         System.out.println(list.getClass().getCanonicalName()); // java.util.ArrayList
        //         System.out.println(list.getClass().getTypeName()); // java.util.ArrayList
        //         System.out.println(list.getClass().toGenericString()); // class java.util.ArrayList
        //         System.out.println(list.getClass().toString()); // class java.util.ArrayList

        //         // 내부 클래스
        //         class InnerClass {}
        //         InnerClass innerClass = new InnerClass();
        //         System.out.println(innerClass.getClass().getName()); // TestDriver$1InnerClass
        //         System.out.println(innerClass.getClass().getSimpleName()); // TestDriver$1InnerClass
        //         System.out.println(innerClass.getClass().getCanonicalName()); // TestDriver$1InnerClass
        //         System.out.println(innerClass.getClass().getTypeName()); // TestDriver$1InnerClass
        //         System.out.println(innerClass.getClass().toGenericString()); // class TestDriver$1InnerClass
        //         System.out.println(innerClass.getClass().toString()); // class TestDriver$1InnerClass

        //         // 기본 타입 : 제대로 동작하지 않는다.
        //         Class<?> intClass = int.class;
        //         System.out.println(intClass.getName()); // int
        //         System.out.println(intClass.getSimpleName()); // int
        //         System.out.println(intClass.getCanonicalName()); // int
        //         System.out.println(intClass.getTypeName()); // int
        //         System.out.println(intClass.toGenericString()); // int
        //         System.out.println(intClass.toString()); // int

        //         System.out.println(int.class.getName()); // int
        //         System.out.println(int.class.getSimpleName()); // int
        //         System.out.println(int.class.getCanonicalName()); // int
        //         System.out.println(int.class.getTypeName()); // int
        //         System.out.println(int.class.toGenericString()); // int
        //         System.out.println(int.class.toString()); // int

        //     }
        // }
// 9. 리플렉션을 이용해 객체의 인스턴스 변수를 모두 포함하는 문자열을 만들어 내는 ‘범용’ toString 메서드를 작성하라
// (순환 참조를 처리하면 추가 점수가 있다).

    // 리플렉션을 이용하여 객체의 모든 인스턴스 변수를 문자열로 만들기 위해서는 해당 객체의 클래스 객체를 얻어와야 합니다. 
    // 그리고 그 클래스 객체를 이용하여 해당 객체의 모든 필드를 가져와야 합니다. 
    // 이때, 필드에는 인스턴스 변수뿐만 아니라 상위 클래스의 인스턴스 변수도 포함되어야 합니다.

    // class Earth {
    //     private int population;
    //     private int area;
    // }
    // class Person extends Earth {
    //     private String name;
    //     private int age;

    //     public Person(String name, int age) {
    //         this.name = name;
    //         this.age = age;
    //     }
    // }
    // class TestDriver {
    //     public static void main(String[] args) {
    //         Person person = new Person("홍길동", 20);
    //         System.out.println(toString(person));
    //     }

    //     public static String toString(Object obj) {
    //         Class<?> c = obj.getClass(); // 파라미터의 클래스 객체를 가져옵니다.
    //         StringBuilder sb = new StringBuilder(); // 문자열을 만들기 위한 StringBuilder 객체를 생성합니다.
    //         sb.append(c.getName()); // 클래스 이름을 StringBuilder에 추가합니다.
    //         sb.append("["); // [를 추가합니다.

    //         while (c != null) { // 파라미터의 클래스 객체가 null이 아닐 때까지
    //             Field[] fields = c.getDeclaredFields();  // 해당 클래스의 모든 필드를 가져옵니다.
    //             AccessibleObject.setAccessible(fields, true); // 모든 필드에 접근할 수 있도록 설정합니다.
    //             for (Field f : fields) { 
    //                 if (!Modifier.isStatic(f.getModifiers())) { // static 필드가 아닌 경우
    //                     if (!sb.toString().endsWith("[") && !sb.toString().endsWith(":")) sb.append(","); // [과 :로 끝나지 않는 경우에만 ,를 추가합니다.
    //                     sb.append(f.getName()); // 필드 이름을 StringBuilder에 추가합니다.
    //                     sb.append("=");
    //                     try {
    //                         Object val = f.get(obj); // 필드의 값을 가져옵니다.
    //                         sb.append(val); // 필드의 값을 StringBuilder에 추가합니다.
    //                     } catch (Exception e) {
    //                         e.printStackTrace(); // 예외가 발생하면 예외를 출력합니다.
    //                     }
    //                 }
    //             }
    //             sb.append("][");
    //             c = c.getSuperclass(); // 상위 클래스의 클래스 객체를 가져옵니다.
    //             sb.append( c == null ? "null" : "super:" + c.getSimpleName() + ":" ); // 상위 클래스의 클래스 객체가 null이 아닌 경우에만 클래스 이름을 추가합니다.
    //         }
    //         sb.append("]");
    //         return sb.toString();
    //     }
    // }



// 10. 4.5.1 클래스 멤버 나열에서 다룬 MethodPrinter 프로그램6을 사용해 int[ ] 클래스의 모든 메서드를 나열하라
// (잘못 기술된 메서드 하나(이 장에서 설명한 메서드)를 찾아내면 추가 점수가 있다).

    // class TestDriver {
    //     public static void main(String[] args) {
    //         try {
    //             Class<?> c = int[].class; 
    //             Method[] methods = c.getDeclaredMethods(); // int[]가 메서드를 직접 가지고 있지 않습니다.
    //             // Method[] methods = c.getSuperclass().getDeclaredMethods(); // Object의 메서드를 가져옵니다.
    //             for (Method m : methods) {
    //                 System.out.println(m); 
    //             }
    //         } catch (Exception e) {
    //             e.printStackTrace();
    //         }
    //     }
    // }

// 11. HelloWorld 프로그램을 작성하라. 
// 이 프로그램에서 리플렉션을 이용해 java.lang.System의 out 필드를 찾은 후 invoke로 println 메서드를 호출해야 한다.

    // class HelloWorld {
    //     public static void main(String[] args) {
    //         try {
    //             // java.lang.System 클래스의 out 필드를 가져옴
    //             Field outField = System.class.getField("out");

    //             // out 필드가 가리키는 PrintStream 객체의 println 메서드를 가져옴
    //             Method printlnMethod = PrintStream.class.getMethod("println", String.class); // 메서드 이름과 매개변수 타입을 이용하여 메서드를 가져옵니다.

    //             // out 필드가 가리키는 PrintStream 객체를 가져옴
    //             PrintStream out = (PrintStream) outField.get(null); // static 필드이므로 null을 넘겨줍니다.

    //             // println 메서드 호출
    //             printlnMethod.invoke(out, "Hello, world!");
    //         } catch (Exception e) {
    //             e.printStackTrace();
    //         }
    //     }
    // }
    
// 12. 일반 메서드 호출과 리플렉션을 이용한 메서드 호출에서 나타나는 성능 차이를 측정하라.


    // class MethodCallBenchmark {
    //     public static void main(String[] args) throws Exception {
    //         // 측정할 메서드가 포함된 클래스를 로딩
    //         Class<?> clazz = TestClass.class;
    //         // 측정할 메서드를 가져옴
    //         Method method = clazz.getMethod("testMethod"); // 메서드 이름을 이용하여 메서드를 가져옵니다.

    //         // 일반 메서드 호출 측정
    //         long startTime = System.nanoTime();
    //         TestClass obj = new TestClass();
    //         obj.testMethod();
    //         long endTime = System.nanoTime();
    //         System.out.println("Direct method call time: " + (endTime - startTime) + " ns");

    //         // 리플렉션을 이용한 메서드 호출 측정
    //         startTime = System.nanoTime();
    //         obj = new TestClass(); 
    //         method.invoke(obj); // 메서드를 호출합니다.
    //         endTime = System.nanoTime();
    //         System.out.println("Reflection method call time: " + (endTime - startTime) + " ns");
    //     }

    //     static class TestClass {
    //         public void testMethod() {
    //             // do nothing
    //         }
    //     }
    // }


// 13. double 또는 Double 타입 매개변수를 받는 정적 메서드를 나타내는 Method 값들을 표로 출력하는 메서드를 작성하라. 
// Method 객체 외에도 하한, 상한, 증감 크기를 받도록 만들어라. 이 메서드로 Math.sqrt와 Double.toHexString의 값들을 표로 출력하는 예를 보여라. 
// Method 대신 DoubleFunction<Object>를 사용해 풀이를 반복하라(3.6.2 함수형 인터페이스 선택 참고). 두 접근법의 안전성, 효율성, 편의성을 비교하라.

    // 안전성: Method는 컴파일 타임에 메서드의 시그니처를 검증하지 않으므로, 잘못된 시그니처를 가진 메서드를 호출할 수 있습니다. 반면에 DoubleFunction은 제네릭을 사용하여 매개변수 및 반환 값의 타입 안정성을 보장합니다.

    // 효율성: Method는 리플렉션 API를 사용하기 때문에 실행 속도가 느릴 수 있습니다. 반면에 DoubleFunction은 람다 함수를 사용하기 때문에 일반적으로 빠릅니다.

    // 편의성: Method는 호출하려는 메서드의 이름을 문자열로 전달해야 하기 때문에 오타 등의 실수가 발생할 가능성이 있습니다. 반면에 DoubleFunction은 람다 함수를 직접 정의하기 때문에 오타 등의 실수를 줄일 수 있습니다.

    // 따라서, 안전성과 편의성 측면에서 DoubleFunction이 우수하며, 효율성 측면에서는 Method보다 빠릅니다. 그러나, 호출하려는 메서드의 이름을 동적으로 결정해야하는 경우에는 Method를 사용해야 합니다.
