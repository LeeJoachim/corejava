package ch01.sec04;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class TestDriver {
    public static void main(String[] args) {
        /* sec 04-1. Arithmetic */
            // 나눗셈과 나머지
            // System.out.println(17 / 5); // 몫 : 3
            // System.out.println(17 % 5); // 나머지 : 2
            // System.out.println(Math.floorMod(17, 5)); // 나머지 : 2
            // 음수 처리는 주의해야 한다.
            // System.out.println(-17 / 5); // -3
            // System.out.println(-17 % 5); // Caution! : -2
            // System.out.println(Math.floorMod(-17, 5)); // 3
            
            // init
            // int[] a = { 17, 29 };
            // int n = 0;
            // double x;
            // float f;

            // 'n++' vs '++n'           
            // System.out.printf("%d %d\n", a[n++], n); 
            // n = 0;
            // System.out.printf("%d %d\n", a[++n], n);
            
            // 제곱과 제곱근
            // System.out.println(Math.pow(2, 8)); // 256.0 : 2^8
            // System.out.println(Math.sqrt(100)); // 10.0
            
            // 숫자 변환
            // x = 42;
            // System.out.println(x); // 42.0
            // f = 123456789;
            // System.out.println(f); // 1.23456792E8
            // x = 3.75;
            // n = (int) x; // 소수부를 버린다.
            // System.out.println(n); // 3
            // n = (int) Math.round(x); // 반올림 한다.
            // System.out.println(n); // 4
            // System.out.println('J' + 1); // 75
            // char next = (char)('J' + 1); 
            // System.out.println(next); // 'K'
            // n = (int) 3000000000L; // illegality : down casting
            // System.out.println(n); // -1294967296
        /**/

        /* sec 04-2. 관계 연산자와 논리 연산자 */
            // int length = 10;
            // int n = 7;
            // System.out.println(0 <= n && n < length);
            
            // 단락 평가(Short circuit evaluation)
            // int s = 30;
            // System.out.println(n != 0 && s + (100 - s) / n < 50);
            // n = 0; // 2번째 조건문을 검사하지 않는다.
            // System.out.println(n != 0 && s + (100 - s) / n < 50);
            // System.out.println(n == 0 || s + (1 - s) / n >= 50);
            
            // 조건(conditional) 연산자 : '?'
            // int time = 7;
            // System.out.println(time < 12 ? "am" : "pm");
        /**/

        /* sec 04-3. Big Number */
            // BigInteger n;
            // BigInteger k;
            // BigInteger r;
            
            // n = BigInteger.valueOf(876543210123456789L); // val to BigInteger
            // System.out.println(n);
            // k = new BigInteger("9876543210123456789");
            // System.out.println(k);
            // // 자바에서는 객체에 연산자를 사용할 수 없다.
            // r = BigInteger.valueOf(5).multiply(n.add(k)); // r = 5 * (n + k)
            // System.out.println(r);
            // // 부동소수점 타입에서의 뺄셈 문제
            // System.out.println(2.0 - 1.1); // 0.8999999999999999
            // // 문제의 해결
            // BigDecimal d = BigDecimal.valueOf(2, 0).subtract(BigDecimal.valueOf(11, 1));
            // System.out.println(d);
        /**/

        /* sec 05. String */
            // String location = "";
            // String greeting = "";

            // 문자열 결합
            // location = "Java";
            // greeting = "Hello " + location;
            // System.out.println(greeting);
            // int age = 42;
            // String output = age + " years";
            // System.out.println(output);
            // 문자열을 다른 값과 연결하면 연결되는 값이 문자열로 변환된다.
            // System.out.println("Next year, you will be " + age + 1); // 문자열 : 421
            // System.out.println("Next year, you will be " + (age + 1)); // 계산 : 43
            // String names = String.join(", ", "Peter", "Paul", "Mary");
            // System.out.println(names);
            
            // 문자열 결합 2 : 문자열 빌더
            // StringBuilder builder = new StringBuilder();
            // for (String id : ZoneId.getAvailableZoneIds()) {
            //     builder.append(id);
            //     builder.append(", ");
            // }
            // String result = builder.toString();
            // 부분 문자열 : 문자열 분리
            // System.out.println(result.substring(0, 200) + "...");
            // System.out.println(result.length());            
            
            // 부분 문자열 : 문자열 분리
            // greeting = "Hello, World!";
            // location = greeting.substring(7, 12);
            // System.out.println(location);
            // 동등성 검사
            // System.out.println(location.equals("World")); // true : compare String
            // System.out.println(location == "World"); // false : compare Address
            // System.out.println(location.equalsIgnoreCase("world")); // true
            // System.out.println("word".compareTo("world")); // -8 : for sorting
            // 숫자와 문자열 간 변환
            // // Integer to String
            // int n = 42;
            // String str = Integer.toString(n); // String str = "" + n;
            // System.out.println(str); // 42
            // str = Integer.toString(n, 2);
            // System.out.println(str); // 101010 : 2진수
            // // String to Integer
            // n = Integer.parseInt(str);
            // System.out.println(n); // 101010
            // n = Integer.parseInt(str, 2);
            // System.out.println(n); // 42
            // // String to Double
            // double x = Double.parseDouble("3.14"); 
            // System.out.println(x);
            // System.out.println(greeting.toUpperCase()); 
            // System.out.println(greeting); // greeting은 변경되지 않았다.
            
            // 유니코드
            // 유효한 유니코드 값을 코드 포인트(code point)라고 한다. e.g. A문자의 코드 포인트 : U+0041
            // String javatm = "Java\u2122";
            // System.out.println(javatm);
            // System.out.println(Arrays.toString(javatm.codePoints().toArray())); 
            // System.out.println(javatm.length());
            
            // String octonions = "\ud835\udd46";
            // System.out.println(octonions);
            // System.out.println(Arrays.toString(octonions.codePoints().toArray()));
            // System.out.println(octonions.length()); // 유니코드 코드 포인트가 아니라 코드 유닛을 센다.
        /**/

        /* sec 06. Input Output */
            // Scanner in = new Scanner(System.in);
            // System.out.println("What is your name?");
            // String name = in.nextLine();
            // System.out.println("How old are you?");
            // if (in.hasNextInt()) {
            //     int age = in.nextInt();
            //     System.out.printf("Hello, %s. Next year, you'll be %d.\n", name, age + 1);
            // } else {
            //     System.out.printf("Hello, %s. Are you too young to enter an integer?", name);
            // }
        /**/

        /* sec 07. Do, For, While */
            // Random generator = new Random();     
            // int target = 0;
            // int count = 0;
            // int next = 0; 
            // int sum = 0;
            
            // // while
            // generator = new Random();
            // sum = 0;
            // count = 0;
            // target = 90;
            // while (sum < target) {
            //     next = generator.nextInt(); // range of int
            //     next = generator.nextInt(10); // 0 ~ 9 : under 10
            //     sum = sum + next;
            //     count++;
            // }
            // System.out.println("After " + count 
            //     + " iterations, the sum is " + sum);
            
            // // do-while
            // target = 5;
            // count = 1;
            // do {
            // next = generator.nextInt(10);
            // count++;
            // } while (next != target);
            // System.out.println("After " + count 
            //     + " iterations, there was a values of " + target);

            // // for
            // generator = new Random();      
            // count = 20;
            // sum = 0;
            // for (int i = 1; i <= count; i++) {
            // next = generator.nextInt(10);
            // sum = sum + next;         
            // }
            // System.out.println("After " + count 
            // + " iterations, the sum is " + sum);

        /**/

        /* sec 08-1. Array */
            // String[] names = new String[10];
            // for (int i = 0; i < names.length / 2; i++) { // traverse 5
            //     names[i] = "";
            // }
            // names[0] = "Fred";
            // names[1] = names[0];
            // System.out.println("names="+Arrays.toString(names)); // names=[Fred, Fred, , , , null, null, null, null, null]
            
            // init
            // int[] primes = { 17, 19, 23, 29, 31 }; // shortened syntax
            // int[] primes = new int[] { 2, 3, 5, 7, 11, 13 };
            // init : not null but length 0
            // int[] tempArr = new int[0];
            // tempArr = new int[]{}; // same new int[0]
            
            // 향상된 for 루프
            // int sum = 0;
            // for (int n : primes) {
            //     sum += n;
            // }
            // System.out.println("sum=" +sum);
            
            // difference '=' and 'copyOf'
            // int[] numbers = primes; // sending address and sharing 
            // numbers[5] = 42; // primes도 변경된다.
            // System.out.println("primes=" + Arrays.toString(primes));
            // primes[5] = 13;
            // int[] copiedPrimes = Arrays.copyOf(primes, primes.length);
            // copiedPrimes[5] = 31; // primes를 변경하지 않는다.
            // System.out.println("primes=" + Arrays.toString(primes));
            // System.out.println("copiedPrimes=" + Arrays.toString(copiedPrimes));
        /**/

        /* sec 08-2. ArrayList */
            // ArrayList<String> friends = new ArrayList<>();
            // friends.add("Peter");
            // friends.add("Paul");
            // friends.remove(1); // Paul is out
            // friends.add(0, "Paul"); // 인덱스 0 앞에 추가한다.
            // System.out.println("friends=" + friends); // friends=[Paul, Peter]

            // String first = friends.get(0); // return "Paul"
            // System.out.println("first=" + first); // first=Paul
            // friends.set(1, "Mary"); // change Peter to Mary
            // for (int i = 0; i < friends.size(); i++) {
            //     System.out.println("i=" + i + " " + friends.get(i));
            // }
            
            // difference '=' and 'copy'
            // ArrayList<String> people = friends; // sending address and sharing
            // people.set(0, "Mary"); // 이제 friends.get(0)도 "Mary"를 반환한다.
            // System.out.println("friends=" + friends); // friends=[Mary, Mary]
            
            // ArrayList<String> copiedFriends = new ArrayList<>(friends); // copy
            // copiedFriends.set(0, "Fred"); // friends를 변경하지 않는다.
            // System.out.println("copiedFriends=" + copiedFriends);
            // System.out.println("friends=" + friends);
            
            // friends = new ArrayList<>(List.of("Peter", "Paul", "Mary")); // init
            // String[] names = friends.toArray(new String[0]); // because of type matching
            // System.out.println("names=" + Arrays.toString(names));
            
            // ArrayList<String> moreFriends = new ArrayList<>(List.of(names));
            // System.out.println("moreFriends=" + moreFriends);   
            
            // // reverse, shuffle, sort
            // Collections.reverse(friends);
            // System.out.println("After reversing, friends=" + friends);
            // Collections.shuffle(friends);
            // System.out.println("After shuffling, friends=" + friends);
            // Collections.sort(friends);        
            // System.out.println("After sorting, friends=" + friends);
        /**/

        /* sec 08-3. Two Dimension Array */
            // int[][] square = {
            //     { 16, 3, 2, 13 },
            //     { 3, 10, 11, 8 },
            //     { 9, 6, 7, 12 },
            //     { 4, 15, 14, 1}
            // };
        
            // // 두 행을 맞바꾼다. : swap
            // int[] temp = square[0];
            // square[0] = square[1];
            // square[1] = temp;
            // System.out.println(Arrays.deepToString(square)); // [[3, 10, 11, 8], [16, 3, 2, 13], [9, 6, 7, 12], [4, 15, 14, 1]]
            
            // int n = 5;
            // int[][] triangle = new int[n][];
            // for (int i = 0; i < n; i++) {
            //     triangle[i] = new int[i + 1]; // 행 길이가 증가하는 배열
            //     triangle[i][0] = 1;
            //     triangle[i][i] = 1;
            //     for (int j = 1; j < i; j++) {
            //         triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            //     }
            // }
            // // traverse
            // for (int r = 0; r < triangle.length; r++) {
            //     for (int c = 0; c < triangle[r].length; c++) {
            //         System.out.printf("%4d", triangle[r][c]);
            //     }
            //     System.out.println();
            // }
            // // traverse 2
            // for (int[] row : triangle) {
            //     for (int element : row) {
            //     System.out.printf("%4d", element);
            //     }
            //     System.out.println();
            // }
        /**/

        /* sec 08-4. command line args */
            // not working in vscode
            // for (int i = 0; i < args.length; i++) {
            //     String arg = args[i];
            //     if (arg.equals("-h")) arg = "Hello";
            //     else if (arg.equals("-g")) arg = "Goodbye";
            //     System.out.println(arg);
            // }
        /**/
    }    
}
