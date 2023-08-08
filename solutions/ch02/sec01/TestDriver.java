package ch02.sec01;

import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.*;

// 1. 달력 출력 프로그램을 수정해서 한 주가 일요일부터 시작하게 하라. 또 줄 넘김은 끝에 한 번만 출력하게 만들어라.

    // class CalendarPrinter {
    //     public static void printCalendar(int year, int month) {
    //         Calendar cal = Calendar.getInstance();
    //         cal.set(year, month - 1, 1); // 입력 받은 연도와 월로 달력의 첫 날 설정 (달은 0부터 시작하므로 1을 빼준다)

    //         int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 첫 날의 요일
    //         int lastDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 해당 월의 마지막 날

    //         // 달력 출력
    //         System.out.printf("%d년 %d월\n", year, month);
    //         System.out.println(" 일  월  화  수  목  금  토");

    //         for (int i = 1; i < firstDayOfWeek; i++) {
    //             System.out.print("    "); // 첫 주의 첫 날까지 공백 출력 (일요일부터 시작하므로 1부터 시작) 
    //         }

    //         for (int i = 1; i <= lastDayOfMonth; i++) {
    //             System.out.printf("%3d ", i); // 날짜 출력 (3칸을 차지하도록) 
    //             if ((i + firstDayOfWeek - 1) % 7 == 0) { // 토요일이면 
    //                 System.out.println();
    //             }
    //         }

    //         if ((lastDayOfMonth + firstDayOfWeek - 1) % 7 != 0) { 
    //             System.out.println(); // 마지막 날이 토요일이 아니면 줄바꿈
    //         }
    //     }
    //     public static void main(String[] args) {
    //         printCalendar(2023, 2);
    //     }
    // }

// 2. Scanner 클래스의 nextInt 메서드를 생각해 보자. 이 메서드는 접근자인가, 변경자인가? 그 이유는? Random 클래스의 nextInt 메서드는 어떤가?

    // Scanner 클래스의 nextInt 메서드는 입력 스트림에서 다음 정수를 읽어와 반환하는 접근자 메서드입니다. 
    // 입력 스트림 자체를 변경하지는 않기 때문에 변경자 메서드가 아닙니다.

    // Random 클래스의 nextInt 메서드는 호출할 때마다 다른 값을 반환하는 변경자 메서드입니다. 
    // 내부 상태를 변경하기 때문에 변경자 메서드입니다. 
    // nextInt 메서드는 Random 클래스의 내부 상태를 바탕으로 난수를 생성하며, 이를 위해 시드값을 설정하고 다음에 사용될 난수를 생성하는 알고리즘을 적용합니다. 
    // 따라서 호출할 때마다 반환되는 값이 다르며 내부 상태를 변경하는 메서드이기 때문에 변경자 메서드입니다.

// 3. void 외의 것을 반환하는 변경자 메서드가 있을 수 있는가? void를 반환하는 접근자 메서드가 있을 수 있는가? 가능하면 예를 제시하라.

    // void 이외의 것을 반환하는 변경자 메서드는 일반적으로 존재하지 않습니다. 
    // 변경자 메서드는 객체의 상태를 변경하고 반환값이 없는 것이 일반적인 규칙입니다.

    // 그러나, 다음과 같이 반환값을 가지는 변경자 메서드를 정의할 수 있습니다.

    // public class Counter {
    //     private int count;
    
    //     public int incrementAndGet() {
    //         count++;
    //         return count;
    //     }
    // }

    // void를 반환하는 접근자 메서드는 일반적으로 존재하지 않습니다.
    // 접근자 메서드는 해당 클래스의 필드 값을 반환하므로 일반적으로 반환값이 필요합니다.

    // 하지만, void를 반환하는 접근자 메서드는 특정한 상황에서 유용할 수 있습니다.
    // 예를 들어, GUI 프로그램에서 버튼을 클릭하면 특정한 동작을 수행하는 이벤트 핸들러 메서드가 호출됩니다.
    // 이 이벤트 핸들러 메서드는 보통 반환값이 없지만, 인터페이스에 따라서 void를 반환해야 합니다.
    // 이런 경우에는 void를 반환하는 접근자 메서드가 존재할 수 있습니다.

    // 아래는 버튼 클릭 시 메시지를 출력하는 예제 코드입니다.

    // class MyButtonHandler implements ActionListener {
    //     public void actionPerformed(ActionEvent e) {
    //         showMessage(); // 버튼 클릭 시 메시지 출력
    //     }
    
    //     public void showMessage() {
    //         System.out.println("Button clicked!"); 
    //     }
    //     // 위 코드에서 showMessage() 메서드는 void를 반환하지만, actionPerformed() 메서드에서는 이 메서드를 호출하여 버튼 클릭 시 메시지를 출력합니다.
    // }

// 4. 자바에서는 왜 두 int 변수의 내용을 맞바꾸는 메서드를 구현할 수 없는가? 그 대신 두 IntHolder 객체의 내용을 맞바꾸는 메서드를 작성하라
// (API 문서에서 잘 알려지지 않은 IntHolder 클래스를 찾아보자). 두 Integer 객체의 내용을 맞바꿀 수 있는가?

    // 자바에서는 기본 자료형(primitive type)의 값에 대한 참조(reference)가 존재하지 않기 때문에 두 int 변수의 내용을 맞바꾸는 메서드를 직접 구현할 수 없습니다.
    // 하지만 Integer 클래스는 immutable(불변)한 객체이기 때문에 두 Integer 객체의 내용을 맞바꿀 수 없습니다.

    // 대신, IntHolder 클래스와 같이 int 값을 저장하는 객체를 만들어서 이를 매개변수로 받는 메서드를 구현할 수 있습니다. 
    // IntHolder 클래스는 API 문서에서 찾을 수 없는 클래스이기 때문에, 직접 클래스를 작성해 보겠습니다.

    // class IntHolder {
    //     private int value;
    
    //     public IntHolder(int value) {
    //         this.value = value;
    //     }
    
    //     public int getValue() {
    //         return value;
    //     }
    
    //     public void setValue(int value) {
    //         this.value = value;
    //     }
    // }
    
    // class TestDriver {
    //     public static void swapInts(IntHolder a, IntHolder b) {
    //         int temp = a.getValue();
    //         a.setValue(b.getValue());
    //         b.setValue(temp);
    //     }
    
    //     public static void main(String[] args) {
    //         IntHolder x = new IntHolder(1);
    //         IntHolder y = new IntHolder(2);
    //         System.out.println("Before: x=" + x.getValue() + ", y=" + y.getValue());
    //         swapInts(x, y);
    //         System.out.println("After: x=" + x.getValue() + ", y=" + y.getValue());
    //     }
    // }

// 5. 평면에 놓인 점을 기술하는 불변 클래스 Point를 구현하라. 특정 점으로 설정하는 생성자와 원점으로 설정하는 인수 없는 생성자, getX, getY, translate, scale 메서드를 구현하라. 
// translate 메서드는 x와 y 방향으로 주어진 길이만큼 점을 옮긴다. scale 메서드는 주어진 비율로 두 좌표의 크기를 조절한다. 결과로 새로운 점을 반환하도록 이 메서드들을 구현하라. 
// 예를 들어 다음 문장은 p를 (2, 3.5) 좌표에 있는 점으로 설정해야 한다. Point p = new Point(3, 4).translate(1, 3).scale(0.5);

    // final class Point {
    //     private final double x;
    //     private final double y;

    //     public Point() {
    //         this.x = 0;
    //         this.y = 0;
    //     }

    //     public Point(double x, double y) {
    //         this.x = x;
    //         this.y = y;
    //     }

    //     public double getX() {
    //         return this.x;
    //     }

    //     public double getY() {
    //         return this.y;
    //     }

    //     public Point translate(double dx, double dy) { // translate 메서드는 x와 y 방향으로 주어진 길이만큼 점을 옮긴다.
    //         return new Point(this.x + dx, this.y + dy); 
    //     }

    //     public Point scale(double d) { // scale 메서드는 주어진 비율로 두 좌표의 크기를 조절한다.
    //         return new Point(this.x * d, this.y * d);
    //     }
    // }

    // class TestDriver {
    //     public static void main(String[] args) {
    //         Point p = new Point(3, 4).translate(1, 3).scale(0.5);
    //         System.out.println("x=" + p.getX() + ", y=" + p.getY());
    //     }
    // }




// 6. 연습문제 5를 반복하되 이번에는 translate와 scale을 변경자로 만들어라.
    // final class Point {
    //         private double x;
    //         private double y;

    //         public Point() {
    //             this.x = 0;
    //             this.y = 0;
    //         }

    //         public Point(double x, double y) {
    //             this.x = x;
    //             this.y = y;
    //         }

    //         public double getX() {
    //             return this.x;
    //         }

    //         public double getY() {
    //             return this.y;
    //         }

    //         public Point translate(double dx, double dy) { // translate 메서드는 x와 y 방향으로 주어진 길이만큼 점을 옮긴다.
    //             this.x = this.x + dx;
    //             this.y = this.y + dy;
    //             return this;
    //         }

    //         public Point scale(double d) { // scale 메서드는 주어진 비율로 두 좌표의 크기를 조절한다.
    //             this.x = this.x * d;
    //             this.y = this.y * d;
    //             return this;
    //         }
    //     }

    //     class TestDriver {
    //         public static void main(String[] args) {
    //             Point p = new Point(3, 4).translate(1, 3).scale(0.5);
    //             System.out.println("x=" + p.getX() + ", y=" + p.getY());
    //         }
    //     }
// 7. 연습문제 5~6에서 만든 Point 클래스의 두 버전에 javadoc 주석을 추가하라.
    // /**
    //  * The Point class represents a point in a two-dimensional plane.
    //  * This class is mutable.
    //  */
    // final class Point {

    //     /**
    //      * x-coordinate of the point.
    //      */
    //     private double x;

    //     /**
    //      * y-coordinate of the point.
    //      */
    //     private double y;

    //     /**
    //      * Creates a new point at the origin (0, 0).
    //      */
    //     public Point() {
    //         this.x = 0;
    //         this.y = 0;
    //     }

    //     /**
    //      * Creates a new point with the specified x and y coordinates.
    //      *
    //      * @param x the x-coordinate of the point
    //      * @param y the y-coordinate of the point
    //      */
    //     public Point(double x, double y) {
    //         this.x = x;
    //         this.y = y;
    //     }

    //     /**
    //      * Returns the x-coordinate of the point.
    //      *
    //      * @return the x-coordinate of the point
    //      */
    //     public double getX() {
    //         return this.x;
    //     }

    //     /**
    //      * Returns the y-coordinate of the point.
    //      *
    //      * @return the y-coordinate of the point
    //      */
    //     public double getY() {
    //         return this.y;
    //     }

    //     /**
    //      * Translates the point by the specified amounts in x and y directions.
    //      *
    //      * @param dx the amount to translate in the x-direction
    //      * @param dy the amount to translate in the y-direction
    //      * @return the translated point
    //      */
    //     public Point translate(double dx, double dy) {
    //         this.x = this.x + dx;
    //         this.y = this.y + dy;
    //         return this;
    //     }

    //     /**
    //      * Scales the point by the specified amount.
    //      *
    //      * @param d the scale factor
    //      * @return the scaled point
    //      */
    //     public Point scale(double d) {
    //         this.x = this.x * d;
    //         this.y = this.y * d;
    //         return this;
    //     }
    // }

    // /**
    //  * A Test Driver class to test the Point class.
    //  */
    // class TestDriver {
    //     public static void main(String[] args) {
    //         Point p = new Point(3, 4).translate(1, 3).scale(0.5);
    //         System.out.println("x=" + p.getX() + ", y=" + p.getY());
    //     }
    // }

    // /**
    //  * 가변 클래스 Point는 평면 상의 점을 나타냅니다.
    //  */
    // final class Point {
    //     private double x; // x 좌표
    //     private double y; // y 좌표

    //     /**
    //      * x, y 좌표가 0인 점을 생성합니다.
    //      */
    //     public Point() {
    //         this.x = 0;
    //         this.y = 0;
    //     }

    //     /**
    //      * 주어진 x, y 좌표를 갖는 점을 생성합니다.
    //      * @param x x 좌표
    //      * @param y y 좌표
    //      */
    //     public Point(double x, double y) {
    //         this.x = x;
    //         this.y = y;
    //     }

    //     /**
    //      * 이 점의 x 좌표를 반환합니다.
    //      * @return x 좌표
    //      */
    //     public double getX() {
    //         return this.x;
    //     }

    //     /**
    //      * 이 점의 y 좌표를 반환합니다.
    //      * @return y 좌표
    //      */
    //     public double getY() {
    //         return this.y;
    //     }

    //     /**
    //      * 주어진 dx, dy만큼 이 점을 이동시킨 새로운 점을 반환합니다.
    //      * @param dx x 방향으로 이동할 거리
    //      * @param dy y 방향으로 이동할 거리
    //      * @return 이동시킨 새로운 점
    //      */
    //     public Point translate(double dx, double dy) {
    //         this.x = this.x + dx;
    //         this.y = this.y + dy;
    //         return this;
    //     }

    //     /**
    //      * 주어진 비율만큼 이 점의 크기를 조절한 새로운 점을 반환합니다.
    //      * @param d 크기를 조절할 비율
    //      * @return 크기를 조절한 새로운 점
    //      */
    //     public Point scale(double d) {
    //         this.x = this.x * d;
    //         this.y = this.y * d;
    //         return this;
    //     }
    // }

    // /**
    //  * Point 클래스를 테스트하는 클래스입니다.
    //  */
    // class TestDriver {
    //     public static void main(String[] args) {
    //         Point p = new Point(3, 4).translate(1, 3).scale(0.5);
    //         System.out.println("x=" + p.getX() + ", y=" + p.getY());
    //     }
    // }

// 8. 앞의 연습문제에서 Point 클래스의 생성자와 게터 메서드를 작성하는 것은 다소 반복적인 일이었다. 대부분의 IDE에는 상투적으로 반복되는 코드를 작성하는 단축 기능이 있다. 여러분이 사용하는 IDE는 어떤 단축 기능을 제공하는가?
    //   - IntelliJ IDEA에서는 Getter, Setter, Constructor, toString, hashCode, equals, finalize, clone 등을 자동으로 생성해주는 기능을 제공한다.
// 9. x 축을 따라 이동하며 가스를 소비하는 자동차를 모델링하는 Car 클래스를 구현하라. 
// 지정한 마일(mile)만큼 드라이브하는 메서드, 지정한 수만큼 가스 탱크에 갤런을 채우는 메서드, 
// 원점과 연료 레벨로 현재 거리를 구하는 메서드를 구현하라. 생성자에 갤런당 마일 단위(miles/gallons)로 연료 효율성을 지정하라. 
// 불변 클래스로 만들어야 하는가? 그렇거나 그렇지 않은 이유를 제시하라.
    // class Car {
    //     private double fuelEfficiency; // 갤런당 마일 단위 연료 효율성
    //     private double fuelLevel; // 현재 가스 탱크에 있는 갤런 수
    //     private double distanceTraveled; // 원점으로부터 현재까지의 거리

    //     public Car(double fuelEfficiency) {
    //         this.fuelEfficiency = fuelEfficiency;
    //         this.fuelLevel = 10;
    //         this.distanceTraveled = 0;
    //     }

    //     public void drive(double miles) {
    //         double gallonsNeeded = miles / fuelEfficiency; // 주행에 필요한 갤런 수
    //         if (gallonsNeeded > fuelLevel) { // 가스 탱크에 있는 갤런 수가 주행에 필요한 갤런 수보다 적을 경우
    //             distanceTraveled += fuelLevel * fuelEfficiency; // 가스 탱크에 있는 갤런 수만큼만 주행
    //             fuelLevel = 0; // 가스 탱크에 있는 갤런 수를 0으로 만듦
    //         } else {
    //             fuelLevel -= gallonsNeeded; // 가스 탱크에 있는 갤런 수에서 주행에 필요한 갤런 수만큼 빼기
    //             distanceTraveled += miles; // 원점으로부터의 거리에 주행한 거리만큼 더하기
    //         }
    //     }

    //     public void fill(double gallons) {
    //         fuelLevel += gallons; // 가스 탱크에 갤런 수 더하기
    //     }

    //     public double distanceToOrigin() {
    //         return distanceTraveled; // 원점으로부터의 거리 반환
    //     }
    //     @Override
    //     public String toString() {
    //         return "Car{" +
    //                 "fuelEfficiency=" + fuelEfficiency +
    //                 ", fuelLevel=" + fuelLevel +
    //                 ", distanceTraveled=" + distanceTraveled +
    //                 '}';
    //     }
    // }

    // class TestDriver {
    //     public static void main(String[] args) {
    //         Car car = new Car(20); // 갤런당 20마일 연료 효율성
    //         System.out.println(car);
    //         car.drive(30); // 30마일 주행
    //         System.out.println(car);
    //         car.fill(5); // 5갤런 가스 탱크에 채우기
    //         System.out.println(car);
    //         double distanceToOrigin = car.distanceToOrigin(); // 원점으로부터의 거리 측정
    //         System.out.println(distanceToOrigin); // 30.0
    //     }
    // }
    // Car 클래스는 불변 클래스로 만들 필요가 없습니다. 
    // 자동차 객체가 생성된 이후에는 연료 효율성이나 현재 갤런 수, 원점으로부터의 거리를 변경할 수 있기 때문입니다. 
    // 이 클래스는 자동차 객체를 모델링하기 위한 변할 수 있는 속성을 가지고 있으므로 불변 클래스로 만들 필요가 없습니다.

// 10. RandomNumbers 클래스 안에 정적 메서드 randomElement를 두 개 구현하라. 
// randomElement는 정수의 배열이나 배열 리스트에서 임의의 요소를 얻는다(해당 배열이나 배열 리스트가 비어 있으면 0을 반환한다). 
// 이 메서드들을 int[ ]나 ArrayList<Integer>의 인스턴스 메서드로 만들 수 없는 이유는?
    // class RandomNumbers {
    //     public int randomElement(int[] a) { // possible access Math.random() method
    //         if (a.length == 0) return 0; // 배열이 비어 있으면 0 반환
    //         int randomIndex = (int) (Math.random() * a.length); // 0부터 배열의 길이-1 사이의 임의의 정수
    //         return a[randomIndex]; // 임의의 인덱스에 해당하는 배열 요소 반환
    //     }

    //     public static int randomElement(ArrayList<Integer> a) { 
    //         if (a.size() == 0) return 0; // 배열 리스트가 비어 있으면 0 반환
    //         int randomIndex = (int) (Math.random() * a.size()); // 0부터 배열 리스트의 길이-1 사이의 임의의 정수
    //         return a.get(randomIndex); // 임의의 인덱스에 해당하는 배열 리스트 요소 반환
    //     }
    // }
    // class TestDriver {
    //     public static void main(String[] args) {
    //         RandomNumbers randomNumbers = new RandomNumbers();
    //         int[] a = {1, 2, 3, 4, 5};
    //         System.out.println(randomNumbers.randomElement(a)); // 1, 2, 3, 4, 5 중 임의의 정수 출력
    //         ArrayList<Integer> b = new ArrayList<>();
    //         b.add(1);
    //         b.add(2);
    //         b.add(3);
    //         b.add(4);
    //         b.add(5);
    //         System.out.println(RandomNumbers.randomElement(b)); // 1, 2, 3, 4, 5 중 임의의 정수 출력
    //     }
    // }

    // int[ ]나 ArrayList<Integer>의 인스턴스 메서드로 만들 수 없는 이유는?
    // 인스턴스 메서드는 인스턴스 변수에 접근할 수 있지만 정적 메서드는 인스턴스 변수에 접근할 수 없기 때문입니다.


// 11. Cal 클래스에서 System과 LocalDate 클래스를 정적으로 임포트해서 사용하도록 Cal 클래스를 재작성하라.

    // import static java.lang.System.out;
    // import static java.time.LocalDate.of;

    // class Cal {
    //     public static void main(String[] args) {
    //         int month = 2;
    //         int year = 2022;
    //         out.println("    " + of(year, month, 3).getMonth() + " " + year);
    //         out.println("Su Mo Tu We Th Fr Sa");

    //         int startDay = of(year, month, 3).getDayOfWeek().getValue();
    //         int numDays = of(year, month, 3).lengthOfMonth();

    //         for (int i = 1; i < startDay; i++) {
    //             out.print("   ");
    //         }
    //         for (int i = 1; i <= numDays; i++) {
    //             if (i < 10) {
    //                 out.print(" " + i + " ");
    //             } else {
    //                 out.print(i + " ");
    //             }
    //             if ((startDay + i - 1) % 7 == 0) {
    //                 out.println();
    //             }
    //         }
    //     }
    // }

// 12. ch01.sec01 패키지에 HelloWorld 클래스를 선언하는 HelloWorld.java 파일을 만든다. 
// 만든 파일을 서브디렉터리 ch01/sec01이 아닌 다른 디렉터리에 넣는다. 
// 해당 디렉터리에서 javac HelloWorld.java 명령을 실행한다. 
// 클래스 파일이 생겼는가? 어디에 생겼는가? 이제 java HelloWorld 명령을 실행해 보자. 
// 무슨 일이 일어나는가? 그 이유는?(javap HelloWorld 명령을 실행한 후 경고 메시지를 연구해 보자.)
// 마지막으로 javac -d . HelloWorld.java 명령을 실행해 보자. 이 방법이 왜 더 좋은가?

        // javac ch01/sec01/HelloWorld.java // success compile
        // 위 명령을 실행하면 컴파일러는 현재 디렉토리에 ch01/sec01 디렉토리를 생성하고 해당 디렉터리에 HelloWorld.class 파일을 생성합니다.
        // javac HelloWorld.java // fail compile
        // 이제 java HelloWorld 명령을 실행하면 컴파일러는 현재 디렉토리에서 HelloWorld.class 파일을 찾으려고 합니다.
        // 하지만 현재 디렉토리에는 HelloWorld.class 파일이 없기 때문에 컴파일러는 HelloWorld.class 파일을 찾을 수 없다는 메시지를 출력합니다.

        // javap HelloWorld 명령을 실행하면 다음과 같은 경고 메시지가 출력됩니다.
        // Warning: Binary file HelloWorld contains ch01.sec01.HelloWorld
        // 이 경고 메시지는 HelloWorld.class 파일에 ch01.sec01.HelloWorld라는 클래스가 포함되어 있다는 것을 알려줍니다.
        // HelloWorld.class 파일에는 ch01.sec01.HelloWorld라는 클래스가 포함되어 있지만,
        // HelloWorld.class 파일이 현재 디렉토리에 있지 않기 때문에 컴파일러는 HelloWorld.class 파일을 찾을 수 없다는 메시지를 출력합니다.

        // javac -d . HelloWorld.java 명령을 실행하면 컴파일러는 현재 디렉토리에 HelloWorld.class 파일을 생성합니다.
        // 이 방법이 더 좋은 이유는 컴파일러가 클래스 파일을 생성할 때 클래스 파일의 위치를 지정할 수 있기 때문입니다.

// 13. 먼저 http://opencsv.sourceforge.net에서 OpenCSV의 JAR 파일을 내려받는다. 
// 여러분이 선택한 CSV 파일을 읽고 내용 일부를 출력하는 main 메서드를 가진 클래스를 작성하라. 
// OpenCSV 웹 사이트에 소스 코드가 있다. 
// 예외를 다루는 방법은 아직 배우지 않았으니 main 메서드 헤더를 다음과 같이 작성하자.
// public static void main(String[ ] args) throws Exception
// 이 연습문제는 CSV 파일로 유용한 작업을 하는 것이 아니라 JAR 파일로 배포되는 라이브러리를 사용하는 것이 목적이다.
// 14. Network 클래스를 컴파일하자. 내부 클래스 파일의 이름이 Network$Member.class라는 것에 유의한다. 생성된 코드를 javap 프로그램으로 조사해 보자(리눅스, macOS에서는 javap를 실행할 때 $ 기호 앞에 \를 붙여야 한다).
// 다음 명령은 메서드와 인스턴스 변수를 표시한다.
// $ javap -private Classname
// 외부 클래스 참조는 어디에 있는가?
    // Network 클래스에 있는 내부 클래스 Member의 파일 이름이 "Network$Member.class"인 것으로 보아 Member 클래스는 Network 클래스 내부에서 선언되고 정의되어 있습니다.
    // Network 클래스에서 Member 클래스를 참조하면 "Network$Member"로 참조해야합니다. 이러한 참조는 해당 내부 클래스를 포함하는 외부 클래스의 이름과 $ 기호 뒤에 내부 클래스의 이름을 결합하여 만듭니다.
    // Network 클래스에서 Member 클래스를 참조하는 예시는 다음과 같습니다.
    // Network.Member member = new Network.Member("name", 1); // 정적 내부 클래스 Member를 참조하는 방법 
// 15. 2.6.1 정적 중첩 클래스의 Invoice 클래스를 완전히 구현하라. 청구서를 출력하는 메서드와 샘플 청구서를 만들어 출력하는 데모 프로그램도 작성하라.

    // class Invoice {
    //     static class Item { // static nested class
    //         String description;
    //         int quantity;
    //         double unitPrice;

    //         double price() {return quantity * unitPrice;}
    //         @Override
    //         public String toString() {
    //             return quantity + " x " + description + " @ $" + unitPrice + " each";
    //         }
    //     }
    //     private ArrayList<Item> items = new ArrayList<>();


    //     public void addItem(String description, int quantity, double unitPrice) {
    //         // 정적 내부 클래스의 데이터 멤버는 일반적으로 외부 클래스에서 직접 접근할 수 없습니다. 
    //         // 이는 정적 내부 클래스가 외부 클래스의 인스턴스와는 별개의 클래스이기 때문입니다.
    //         Item newItem = new Item(); 
    //         newItem.description = description;
    //         newItem.quantity = quantity;
    //         newItem.unitPrice = unitPrice;
    //         items.add(newItem);
    //     }

    //     public void print() {
    //         double totalPrice = 0;
    //         for (Item item : items) {
    //             System.out.println(item);
    //             totalPrice += item.price();
    //         }
    //         System.out.println("Total Price : " + totalPrice);
    //     }
        
    // }

    // // static nested class : invoice demo
    // public class TestDriver {
    //     public static void main(String[] args) {
    //         Invoice invoice = new Invoice();
    //         invoice.addItem("Blackwell Toaster", 2, 24.95);
    //         invoice.addItem("ZapXpress Microwave Oven", 1, 49.95);
    //         invoice.print();
    //     }
    // }
    
// 16. 경계가 없는 문자열의 큐를 표현하는 Queue 클래스를 구현하라. 
// 뒤에 추가하는 add 메서드와 앞에서 제거하는 remove 메서드를 구현하라. 
// 요소들은 노드의 연결 리스트로 저장한다. 
// Node는 중첩 클래스로 만든다. 
// Node가 정적 클래스여야 하는가, 그렇지 않아야 하는가?
    // class Queue {
    //     private Node head;
    //     private Node tail;
        
    //     // Node 클래스는 Queue 클래스의 인스턴스 변수에 액세스하므로, Node 클래스는 정적 클래스가 아니라 내부 클래스로 구현해야 합니다.
    //     private class Node {
    //         String item;
    //         Node next;
    //     }
        
    //     public void add(String item) {
    //         Node node = new Node();
    //         node.item = item;
    //         if (head == null) {
    //             head = node;
    //             tail = node;
    //         } else {
    //             tail.next = node;
    //             tail = node;
    //         }
    //     }
        
    //     public String remove() {
    //         if (head == null) {
    //             return null;
    //         }
    //         String item = head.item;
    //         head = head.next;
    //         if (head == null) {
    //             tail = null;
    //         }
    //         return item;
    //     }

    //     Iterator iterator() {
    //         return new Iterator();
    //     }

    //     class Iterator {
    //         private Node current = head;
    //         public boolean hasNext() {
    //             return current != null;
    //         }
    //         public String next() {
    //             String item = current.item;
    //             current = current.next;
    //             return item;
    //         }
    //     }
    // }

    // class TestDriver {
    //     public static void main(String[] args) {
    //         Queue queue = new Queue();
    //         queue.add("1");
    //         queue.add("2");
    //         queue.add("3");
    //         queue.add("4");
    //         queue.add("5");
    //         // Queue.Iterator iterator = queue.new Iterator(); // Queue의 내부 클래스 Iterator를 참조하는 방법
    //         Queue.Iterator iterator = queue.iterator(); // Queue의 내부 클래스 Iterator를 참조하는 방법
    //         while (iterator.hasNext()) {
    //             System.out.println(iterator.next());
    //         }
    //     }
    // }
// 17. 연습문제 16에서 만든 Queue 클래스용 반복자(이터레이터(iterator))를 구현하라. 
// 큐 반복자는 큐의 요소들을 차례로 내어 주는 객체다. 
// Iterator 클래스는 next와 hasNext 메서드를 구현한 중첩 클래스로 만든다. 
// Queue.Iterator를 돌려주는 Queue의 iterator() 메서드를 구현하라. 
// Iterator가 정적 클래스여야 하는가, 그렇지 않아야 하는가?
    // Queue 클래스의 내부 클래스 Iterator는 Queue 클래스의 인스턴스 변수에 액세스하므로, Queue 클래스의 내부 클래스 Iterator는 정적 클래스가 아니라 내부 클래스로 구현해야 합니다.
    // 솔루션은 연습문제 16을 참조하십시오.