package ch07.sec02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* sec 02 : iterator */

    // 한 자료 구조를 방문 중인 반복자가 여러 개 있을 때, 
    // 그중 하나가 해당 자료 구조를 변경하면 나머지는 유효하지 않은 반복자가 될 수 있다. 
    // 유효하지 않은 반복자를 계속 사용하면 ConcurrentModificationException이 일어난다.

    // class ConcurrentModificationDemo {
    //     public static void main(String[] args) {
    //         Collection<String> coll = new ArrayList<>();
    //         coll.add("Peter");
    //         coll.add("Paul");
    //         coll.add("Mary");
    //         System.out.println(coll);
    //         Iterator<String> iter1 = coll.iterator();
    //         Iterator<String> iter2 = coll.iterator();
    //         iter2.next(); // Peter
    //         iter2.remove(); // removes Peter
    //         System.out.println(coll);
    //         // iter1.next(); // throws ConcurrentModificationException
    //         // System.out.println(coll); // never reached
    //     }
    // }

    // class IteratorDemo {
    //     public static void main(String[] args) {
    //         Collection<String> coll = new ArrayList<>();
    //         coll.add("Peter");
    //         coll.add("Paul");
    //         coll.add("Mary");
    //         Iterator<String> iter = coll.iterator();
    //         while (iter.hasNext()) {
    //             String element = iter.next();
    //             process(element);
    //         }
            
    //         iter = coll.iterator(); // 순회가 끝난 후에는 반복자를 다시 얻어야 한다.
    //         while (iter.hasNext()) {
    //             String element = iter.next();
    //             if (element.startsWith("M"))
    //                 iter.remove();
    //         } 

    //         coll.removeIf(e -> e.startsWith("M")); // 위의 코드와 같은 기능을 한다.
    //         coll.removeIf(e -> e.endsWith("r"));
            
    //         for (String element : coll) 
    //             process(element);
    //     }
        
    //     public static void process(String s) { System.out.println("Processing " + s); }
    // }

    // class ListIteratorDemo {
    //     public static void main(String[] args) {
    //         List<String> friends = new LinkedList<>();
    //         ListIterator<String> iter = friends.listIterator();
    //         iter.add("Fred"); 
    //         System.out.println(friends);
    //         iter.add("Wilma"); 
    //         System.out.println(friends);
    //         iter.previous(); // index 1
    //         iter.set("Barney"); // replaces index 1
    //         System.out.println(friends);
    //     }
    // }

/**/

/* sec 03 : set */
    // class SetDemo {
    //     public static void main(String[] args) {
    //         Set<String> badWords = new HashSet<>();
    //         badWords.add("sex");
    //         badWords.add("drugs");
    //         badWords.add("c++");
            

    //         Scanner in = new Scanner(System.in);
    //         System.out.print("Please choose a user name: "); 
    //         String username = in.next();        


    //         if (badWords.contains(username.toLowerCase()))
    //             System.out.println("Please choose a different user name");
    //         else
    //             System.out.println("Registered " + username + " since it wasn't one of " + badWords);
            
    //         // 중첩 삼항 연산자
    //             // 기본적으로 삼항 연산자는 다음과 같은 형태를 가진다. 조건식 ? 결과 1 : 결과 2
    //             // 조건식이 참인 경우 결과 1을, 거짓인 경우 결과 2를 반환한다.

    //             // 삼항 연산자가 중첩되어 사용되었을 경우 다음과 같은 형태를 가진다.
    //             // 조건식1 ? 결과1 
    //             // : 조건식2 ? 결과2 
    //             // : 조건식3 ? 결과3

    //             // 각 조건식이 순서대로 평가되며, 모든 조건식이 거짓인 경우 마지막 결과를 반환한다.
    //         // 아래의 코드는 USA가 먼저 출력되도록 정렬하고, USA가 아닌 경우 사전 순으로 정렬한다.
    //         TreeSet<String> countries = new TreeSet<>((u, v) ->
    //             u.equals(v) ? 0 // u와 v가 같은 경우: 0 반환
    //             : u.equals("USA") ? -1 // u가 "USA"인 경우: -1 반환
    //             : v.equals("USA") ? 1 // v가 "USA"인 경우: 1 반환
    //             : u.compareTo(v)); // u와 v가 같지 않은 경우: u.compareTo(v) 반환 (u와 v의 대소 비교)
            
    //         countries.add("Bahrain");
    //         countries.add("Australia"); 
    //         countries.add("USA");
    //         countries.add("Canada");

    //         System.out.println(countries);

    //         in.close();
    //     }
    // }
/**/

/* sec 04 : map */
    // class LinkedHashMapDemo {
    //     public static void main(String[] args) {
    //         Map<String, Integer> weekdays = new HashMap<>();
    //         initialize(weekdays); 
    //         System.out.println(weekdays); // HashMap은 키의 순서를 보장하지 않는다.
            
    //         weekdays = new TreeMap<>();
    //         initialize(weekdays);
    //         System.out.println(weekdays); // TreeMap은 키를 사전 순으로 정렬한다.
            
    //         weekdays = new LinkedHashMap<>();
    //         initialize(weekdays);
    //         System.out.println(weekdays); // LinkedHashMap은 value의 순서를 보장한다.
    //     }
        
    //     public static void initialize(Map<String, Integer> weekdays) {
    //         weekdays.put("Monday", 1);
    //         weekdays.put("Tuesday", 2);
    //         weekdays.put("Wednesday", 3);
    //         weekdays.put("Thursday", 4);
    //         weekdays.put("Friday", 5);
    //         weekdays.put("Saturday", 6);
    //         weekdays.put("Sunday", 7);
    //     }
    // }

    // class MapDemo {
    //     public static void main(String[] args) {
    //         Map<String, Integer> counts = new HashMap<>();
    //         counts.put("Alice", 1); // 맵에 키/값 쌍을 추가한다.
    //         counts.put("Alice", 2); // 키에 대응하는 값을 업데이트한다.
            
    //         int count = counts.get("Alice");
    //         System.out.println(count); // 2

    //         count = counts.getOrDefault("Barney", 0); // get 보다 더 나은 방법 : null 대신 기본값을 반환한다.
    //         System.out.println(count);
            
    //         // Fred가 키로 존재하지 않는다면, 1을 맵에 추가한다.
    //         // Integer::sum = 키가 존재하는 경우, 기존 값을 가져와서 1을 더한다.
    //         String word = "Fred";
    //         counts.merge(word, 1, Integer::sum);
    //         System.out.println(counts.get(word)); // 1
    //         counts.merge(word, 1, Integer::sum); // Fred가 키로 존재하므로, 1을 더한다.
    //         System.out.println(counts.get(word)); // 2
    
    //         // traverse 1
    //         for (Map.Entry<String, Integer> entry : counts.entrySet()) { // entrySet() : 맵의 모든 키/값 쌍을 반환한다.
    //             String key = entry.getKey();
    //             Integer value = entry.getValue();
    //             process(key, value);
    //         }
            
    //         // traverse 2
    //         counts.forEach((k, v) -> process(k, v));
    //     }
        
    //     public static void process(String key, Integer value) {
    //         System.out.printf("Processing key %s and value %d\n", key, value);
    //     }
            
    // }
    
/**/

/* sec 04 :  */
/**/

/* sec 04 :  */
/**/