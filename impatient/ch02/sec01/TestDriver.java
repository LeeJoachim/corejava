package ch02.sec01;

import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;


import static java.lang.Math.*; // static import

/* sec 01. LocalDate Class && Calendar */

    // Make Calendar
    // class TestDriver {
    //     public static void main(String[] args) {

    //         LocalDate date = LocalDate.now().withDayOfMonth(1); // 2023-02-XX

    //             // Execution of Console
    //             // int month;
    //             // if (args.length >= 2) {        
    //             //     month = Integer.parseInt(args[0]);
    //             //     int year = Integer.parseInt(args[1]);
    //             //     date = LocalDate.of(year, month, 1);
    //             // } else {
    //             //     month = date.getMonthValue();
    //             // }
                
            
    //         // Calendar
    //         System.out.println(" Month : " + date.getMonth());
    //         System.out.println(" Mon Tue Wed Thu Fri Sat Sun");
    //         DayOfWeek weekday = date.getDayOfWeek();
    //         int value = weekday.getValue(); // 1 = 월요일(Monday), ... 7 = 일요일(Sunday)
    //         for (int i = 1; i < value; i++) System.out.print("    ");
                
    //         int temp = date.getMonthValue();
    //         while (date.getMonthValue() == temp) {
    //             System.out.printf("%4d", date.getDayOfMonth());
    //             date = date.plusDays(1); // 접근자(accessor) 메서드 : 새로운 객체를 리턴한다.
    //              // <-> 변경자(mutator) 메서드 : 객체 상태를 변경하고 아무것도 리턴하지 않는다.
    //             if (date.getDayOfWeek().getValue() == 1) 
    //                 System.out.println();
    //         }
    //         System.out.println();
    //     }
    // }

    // Reference Demo
    // public class TestDriver {
    //     public static void main(String[] args) {
    //         ArrayList<String> friends = new ArrayList<>();
    //             // friends는 비어 있다.
    //         friends.add("Peter");
    //             // friends의 길이는 1이다.
    //         ArrayList<String> people = friends;
    //             // 이제 people과 friends는 같은 객체를 참조한다.
    //         people.add("Paul");
    //         System.out.println(friends); // [Peter, Paul]
    //     }
    // }

/**/

/* sec 02. implementation */

    // example 1 : raise salary by percent
    // class Employee {
    //     String name;
    //     double salary;

    //     public Employee(String name, double salary) {
    //         this.name = name;
    //         this.salary = salary;
    //     }

    //     public void raiseSalary(double byPercent) {
    //         double raise = salary * byPercent / 100; // 10%
    //         salary += raise;
    //     }

    //     public String getName() {
    //         return name;
    //     }

    //     public double getSalary() {
    //         return salary;
    //     }
        
    // }

    // public class TestDriver {
    //     public static void main(String[] args) {
    //         Employee fred = new Employee("Fred", 50000);
    //         fred.raiseSalary(10); // raise 10%
    //         System.out.println(fred.getName());
    //         System.out.println(fred.getSalary());
    //     }
    // }


    // example 2 : call by value demo
    // class EvilManager {

    //     Random generator;

    //     EvilManager() {
    //         generator = new Random();
    //     }
        
    //     void giveRandomRaise(Employee e) {
    //         double p = 10 * generator.nextDouble(); // 0 ~ 10% 
    //         e.raiseSalary(p);
    //         System.out.println(p + " percentage up");
    //         System.out.printf("%4.2f" + " percentage up\n", p);
    //     }

    //     void increaseRandomly(double x) { 
    //         double amount = x * generator.nextDouble();
    //         x += amount; // 의도한 대로 작동하지 않는다.
    //     }

    //     void replaceWithZombie(Employee e) {
    //         // step 1 : working
    //         e.name = "ZOMBIE Fred";
    //         e.salary = 0;

    //         // setp 2 : not working
    //         e = new Employee("ZOMBIE Fred", 0);
    //     }
    // }

    // public class TestDriver {
    //     public static void main(String[] args) {
    //         EvilManager boss = new EvilManager();
            
    //         Employee fred = new Employee("Fred", 50000);
    //         System.out.println("Salary before: " + fred.getSalary());            
    //         boss.giveRandomRaise(fred);
    //         System.out.println("Salary after: " + fred.getSalary());

    //         double sales = 100000;
    //         System.out.println("Sales before: " + sales);
    //         boss.increaseRandomly(sales); // call by value
    //         System.out.println("Sales after: " + sales);
            
    //         System.out.println("Employee before: " + fred.getName());            
    //         System.out.println("Salary before: " + fred.getSalary());            
    //         boss.replaceWithZombie(fred);
    //         System.out.println("Employee after: " + fred.getName());            
    //         System.out.println("Salary after: " + fred.getSalary());            
    //     }
/**/

/* sec 03. call Constructor and data members initialization */
    // class Employee {

    //     String name = ""; // defence nullPointException
    //     double salary;
    //     final int id; // reserved word final : variable's value is not changed

    //     { // 초기화 블록
    //         Random generator = new Random(); 
    //         id = 1 + generator.nextInt(1_000_000);
    //     }

    //     // constructor is overloaded
    //     public Employee(String name, int salary) {
    //         this.name = name; this.salary = salary;
    //         System.out.println("HERE!");
    //     }

    //     public Employee(String name) {
    //         this(name, 0);
    //     }

    //     public Employee() {
    //         this("", 0);
    //     }
        
    // }

    // public class TestDriver {
    //     public static void main(String[] args) {
    //         Employee e = new Employee(); // HERE!
    //         e = new Employee("Paul"); // HERE!
    //     }
    // }

/**/

/* sec 04. static method demo */
    // class RandomNumbers {
    //     static Random generator = new Random();

    //     public static int nextInt(int low, int high) {
    //         return low + generator.nextInt(high - low + 1); // no problem
    //     }
    // }

    // public class TestDriver {
    //     public static void main(String[] args) {
    //         int dieToss = RandomNumbers.nextInt(1, 6); 
    //         System.out.println(dieToss);
            
    //         // Factory Method : Formatter
    //         NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    //         NumberFormat percentFormatter = NumberFormat.getPercentInstance();
    //         double x = 0.1;
    //         System.out.println(currencyFormatter.format(x)); // ₩0를 출력한다.
    //         System.out.println(percentFormatter.format(x)); // 10%를 출력한다.

    //         // traverse
    //         for (Integer i : CreditCardForm.expirationYear) {
    //             System.out.println(i);
    //         }
    //     }
    // }

    // // multi thread programming problems : not good code
    // class Employee {
    //     int id;
    //     static int lastId = 0; // be sharing

    //     public Employee() {
    //         lastId++;
    //         id = lastId;
    //     }
    // }

    // // 정적 초기화 블록
    // class CreditCardForm {
    //     static final ArrayList<Integer> expirationYear = new ArrayList<>();
    //     static { // 정적 초기화 블록
    //         // 배열 리스트 expirationYear에 다음 20년을 추가한다.
    //         int year = LocalDate.now().getYear();
    //         for (int i = year; i <= year + 20; i++) {
    //             expirationYear.add(i);
    //         }
    //     }
    //     // ...
    // }

/**/

/* sec 05. static import Math for shorten syntax */
    // public class TestDriver {
    //     public static void main(String[] args) {
    //         double x = 3;
    //         double y = 4;
    //         double hypothenuse = sqrt(pow(x, 2) + pow(y, 2)); // Math.sqrt, Math.pow
    //         System.out.println(hypothenuse);        
    //     }
    // }
/**/

/* sec 06. nested class */

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
    

    // class Network {
    //     class Member { // inner class
    //         String name;
    //         ArrayList<Member> friends = new ArrayList<>();

    //         public Member(String name) {
    //             this.name = name;
    //         }
    //         void deactivate() {
    //             members.remove(this);
    //         }
    //         public void addFriend(Member newFriends) {
    //             friends.add(newFriends);
    //         }
    //         public boolean belongsTo(Network n) {
    //             return Network.this == n; // inner class special syntax : XXX.this
    //         }
    //         public String toString() {
    //             StringBuilder result = new StringBuilder(name);
    //             result.append(" with friends ");
    //             for (Member friend : friends) {
    //                 result.append(friend.name);
    //                 result.append(", ");
    //             }
    //             return result.subSequence(0, result.length() - 2).toString();
    //         }
            
    //     }
    //     ArrayList<Member> members = new ArrayList<>();

    //     public Member enroll(String name) {
    //         Member newMember = new Member(name);
    //         members.add(newMember);
    //         System.out.println("add : " + name);
    //         return newMember;
    //     }
    //     public String toString() {
    //         return members.toString();
    //     }


    // }
    // public class TestDriver {
    //     public static void main(String[] args) {
    //         Network facebook = new Network();
    //         Network twiter = new Network();
    //         Network.Member fred = facebook.enroll("Fred");
    //         // 이 문제를 피하려면 생성자를 비공개로 만들어야 한다.
    //         Network.Member wilma = facebook.new Member("Wilma"); // not added to members
    //         fred.addFriend(wilma);

    //         Network.Member barney = twiter.enroll("Barney");
    //         fred.addFriend(barney);
    //         System.out.println(facebook);
    //         // 다른 네트워크에 속한 친구를 추가할 수 없게 하려면
    //         // belongsTo를 호출해야 한다.
    //         System.out.println(barney.belongsTo(facebook));
    //     }
    // }
/**/