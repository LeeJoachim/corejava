package ch01.sec01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.math.BigInteger;

// 1. 정수를 읽어서 2진수, 8진수, 16진수로 출력하는 자바 프로그램을 작성하라. 읽어 온 정수의 역수를 16진 부동소수점 수로 출력하라.

    // class NumberConversion {
    //     public static void main(String[] args) {
    //         Scanner scanner = new Scanner(System.in);

    //         // 정수 입력 받기
    //         System.out.print("정수를 입력하세요: ");
    //         int number = scanner.nextInt();

    //         // 2진수, 8진수, 16진수로 변환하여 출력
    //         System.out.println("2진수: " + Integer.toBinaryString(number));
    //         System.out.println("8진수: " + Integer.toOctalString(number));
    //         System.out.println("16진수: " + Integer.toHexString(number));

    //         // 입력받은 수의 역수를 16진 부동소수점으로 출력
    //         double reciprocal = 1.0 / number;
    //         System.out.println("입력받은 수의 역수: " + Double.toHexString(reciprocal));
    //     }
    // }

// 2. 정수(양의 정수 또는 음의 정수)로 된 각도를 읽고 0~359도 사이의 값으로 정규화하는 자바 프로그램을 작성하라(먼저 % 연산자를 사용한 후 floorMod 메서드를 이용해 작성한다).

    // class AngleNormalization {
    //     public static void main(String[] args) {
    //         Scanner scanner = new Scanner(System.in);

    //         // 각도 입력 받기
    //         System.out.print("각도를 입력하세요: ");
    //         int angle = scanner.nextInt();

    //         // % 연산자를 사용한 방법
    //         int normalizedAngle = angle % 360;
    //         if (normalizedAngle < 0) {
    //             normalizedAngle += 360;
    //         }
    //         System.out.println("정규화된 각도: " + normalizedAngle);

    //         // floorMod 메소드를 사용한 방법
    //         // floorMod 메소드는 음수의 경우에도 양수가 나오도록 정규화한다.
    //         // floorMod and % are equivalent for positive numbers
    //         // % 연산자는 나머지를 계산하는 연산자이므로 음수의 경우에도 음수가 나올 수 있다.
    //         // % is not equivalent to floorMod for negative numbers
    //         normalizedAngle = Math.floorMod(angle, 360);
    //         System.out.println("정규화된 각도: " + normalizedAngle);
    //     }
    // }

// 3. 조건 연산자만 사용해 정수 세 개를 읽고 최댓값을 출력하는 자바 프로그램을 작성하라. Math.max를 사용해 같은 자바 프로그램을 작성하라.

    // class MaxNumber {
    //     public static void main(String[] args) {
    //         Scanner scanner = new Scanner(System.in);

    //         // 정수 세 개 입력 받기
    //         System.out.print("정수 1을 입력하세요: ");
    //         int num1 = scanner.nextInt();
    //         System.out.print("정수 2을 입력하세요: ");
    //         int num2 = scanner.nextInt();
    //         System.out.print("정수 3을 입력하세요: ");
    //         int num3 = scanner.nextInt();

    //         // 조건 연산자를 사용하여 최댓값 구하기
    //         // int max = num1 > num2 ? (num1 > num3 ? num1 : num3) : (num2 > num3 ? num2 : num3);
    //         // System.out.println("최댓값: " + max);

    //         // Math.max를 사용하여 최댓값 구하기
    //         int max = Math.max(num1, Math.max(num2, num3));
    //         System.out.println("최댓값: " + max);
    //     }
    // }


// 4. double 타입인 양수 값 중 가장 작은 값과 가장 큰 값을 출력하는 자바 프로그램을 작성하라(자바 API에서 Math.nextUp을 찾는다).
    // class MinMaxDoubleValues {
    //     public static void main(String[] args) {
    //         double minDouble = Math.nextUp(0.0); // 0.0보다 큰 가장 작은 double 값
    //         // double minDouble = Double.MIN_VALUE; // 0.0보다 큰 가장 작은 double 값
    //         double maxDouble = Double.MAX_VALUE;

    //         System.out.println("Double 타입에서 가장 작은 양수 값: " + minDouble);
    //         System.out.println("Double 타입에서 가장 큰 양수 값: " + maxDouble);
    //     }
    // }

// 5. int의 최댓값보다 큰 double을 int 타입으로 변환하면 무슨 일이 일어나는가? 직접 시도해 보라.
    // class IntToDoubleConversion {
    //     public static void main(String[] args) {
    //         double largeDouble = 2_147_483_648.0; // [int의 최댓값 : 2,147,483,647] + 1.0
    //         int convertedInt = (int) largeDouble; 

    //         System.out.println("Converted int: " + convertedInt); // int의 최댓값인 2,147,483,647이 출력된다.
    //     }
    // }

// 6. BigInteger를 사용해 팩토리얼 n! = 1 × 2 × … × n을 계산하는 자바 프로그램을 작성하라. 그리고 자바 프로그램을 이용해 1,000!을 계산하라.

    // class Factorial {
    //     public static void main(String[] args) {
    //         Scanner scanner = new Scanner(System.in);
    //         System.out.print("Enter a non-negative integer: ");
    //         int n = scanner.nextInt();
    //         scanner.close();

    //         BigInteger factorial = BigInteger.ONE;
    //         for (int i = 2; i <= n; i++) {
    //             factorial = factorial.multiply(BigInteger.valueOf(i));
    //             // System.out.println("factorial" + "*" + i + "=" + factorial);
    //         }

    //         System.out.println(n + "! = " + factorial);
    //     }
    // }

// 7. 0~4294967295 사이의 정수 두 개를 읽어서 int 변수에 저장한 후 부호 없는 합계, 차이, 곱, 몫, 나머지를 계산해 표시하는 자바 프로그램을 작성하라(long 값으로 변환하지 않아야 한다).
    // class TestDriver {
    //     public static void main(String[] args) {
    //         Scanner scanner = new Scanner(System.in);

    //         System.out.print("정수 a를 입력하세요: ");
    //         BigInteger a = new BigInteger(scanner.next());

    //         System.out.print("정수 b를 입력하세요: ");
    //         BigInteger b = new BigInteger(scanner.next());

    //         BigInteger sum = a.add(b);
    //         BigInteger diff = a.subtract(b);
    //         BigInteger prod = a.multiply(b);

    //         BigInteger[] quotientAndRemainder = a.divideAndRemainder(b); // 몫과 나머지를 배열로 반환
    //         BigInteger quotient = quotientAndRemainder[0];
    //         BigInteger remainder = quotientAndRemainder[1];

    //         System.out.println("Sum: " + sum);
    //         System.out.println("Difference: " + diff);
    //         System.out.println("Product: " + prod);
    //         System.out.println("Quotient: " + quotient);
    //         System.out.println("Remainder: " + remainder);
    //     }
    // }

// 8. 문자열을 읽어서 비어 있지 않는 부분 문자열을 모두 출력하는 자바 프로그램을 작성하라.
    // public class TestDriver {
    //     public static void main(String[] args) {
    //         Scanner scanner = new Scanner(System.in);
    //         String str = scanner.nextLine();

    //         for (int i = 0; i < str.length(); i++) {
    //             for (int j = i + 1; j <= str.length(); j++) {

    //                 String substr = str.substring(i, j);
    //                 if (!substr.isEmpty()) { // 빈 문자열을 제외하고 출력
    //                     System.out.println(substr);
    //                 }
    //             }
    //         }
    //     }
    // }
// 9. 1.5.3 문자열 비교에는 s.equals(t)이지만 s!=t인 두 문자열 s와 t를 비교하는 예제가 있다. substring을 사용하지 않는 다른 예를 제시하라.

    // class TestDriver {
    //     public static void main(String[] args) {
    //         // 1.5.3 문자열 비교
    //         // String location = "";
    //         // String greeting = "";

    //         // String result = builder.toString();
    //         // 부분 문자열 : 문자열 분리
    //         // System.out.println(result.substring(0, 200) + "...");
    //         // System.out.println(result.length());            
            
    //         // 부분 문자열 : 문자열 분리
    //         // greeting = "Hello, World!";
    //         // location = greeting.substring(7, 12);
    //         // System.out.println(location);
    //         // 동등성 검사
    //         // System.out.println(location.equals("World")); // true : compare String
    //         // System.out.println(location == "World"); // false : compare Address
    //         // System.out.println(location.equalsIgnoreCase("world")); // true
    //         // System.out.println("word".compareTo("world")); // -8 : for sorting

    //         // 두 문자열 s와 t를 비교하는 예제
    //         String s = "Hello, World!";
    //         String t = "World!";

    //         if (s.length() != t.length()) { // 길이가 다르면 다른 문자열
    //             System.out.println("s and t are different."); 
    //         } else {
    //             boolean different = false; // s와 t가 다른지를 나타내는 플래그
    //             for (int i = 0; i < s.length(); i++) {
    //                 if (s.charAt(i) != t.charAt(i)) { // 문자가 다르면 다른 문자열
    //                     different = true;
    //                     break;
    //                 }
    //             }
    //             if (different) {
    //                 System.out.println("s and t are different.");
    //             } else {
    //                 System.out.println("s and t are the same.");
    //             }
    //         }
    //     }
    // }
            
        

// 10. 임의의 long 값을 생성한 후 36진수로 출력해 임의 글자와 숫자로 구성된 문자열을 만들어 내는 자바 프로그램을 작성하라.

    // class RandomStringGenerator {
    //     public static void main(String[] args) {
    //         // 임의의 long 값을 생성
    //         long value = new Random().nextLong();

    //         // 36진수로 변환
    //         String base36 = Long.toString(value, 36);

    //         // 출력
    //         System.out.println("Random long value in base 36: " + base36); 

    //         // 임의의 글자와 숫자로 구성된 문자열 생성
    //         StringBuilder sb = new StringBuilder();
    //         Random random = new Random();
    //         int length = random.nextInt(10) + 5; // 길이는 5~14
    //         for (int i = 0; i < length; i++) {
    //             if (random.nextBoolean()) { // 50% 확률로 숫자를 생성
    //                 sb.append(random.nextInt(10)); // 0~9
    //             } else {
    //                 sb.append((char) (random.nextInt(26) + 'a')); // 50% 확률로 영문자를 생성
    //             }
    //         }
    //         String randomString = sb.toString();

    //         // 출력
    //         System.out.println("Random string: " + randomString);
    //     }
    // }
// 11. 텍스트 한 줄을 읽고 아스키 외의 모든 문자를 유니코드 값과 함께 출력하는 자바 프로그램을 작성하라.
    // class PrintNonASCIICharacters {
    //     public static void main(String[] args) {
    //         Scanner scanner = new Scanner(System.in);
    //         String line = scanner.nextLine();

    //         for (int i = 0; i < line.length(); i++) {
    //             char c = line.charAt(i);
    //             if (c > 127) { // ASCII 이외의 문자 검사
    //                 System.out.printf("%c: U+%04X%n", c, (int) c); // 유니코드 값 출력 : U+XXXX
    //             }
    //         }
    //     }
    // }
// 12. JDK에는 자바 라이브러리의 소스 코드가 담긴 src.zip 파일이 있다. 이 파일의 압축을 해제한 후 평소에 쓰는 텍스트 검색 도구로 레이블이 붙은 break와 continue의 사용 예를 찾아라. 그중 하나를 선별해 레이블을 붙이지 않은 문장으로 재작성하라.

    // class TestDriver {
    //     public static void main(String[] args) {

    //         // break 와 continue의 사용 예
    //         System.out.print("break example    : ");
    //         for (int i = 0; i < 10; i++) {
    //             if (i == 5) {
    //                 break; // 반복문을 빠져나간다.
    //             }
    //             System.out.print(i + " "); // 0~4
    //         }
    //         System.out.print("\ncontinue example : ");
    //         for (int i = 0; i < 10; i++) {
    //             if (i == 5) {
    //                 continue; // 반복문의 끝으로 이동한다.
    //             }
    //             System.out.print(i + " "); // 0~4 6~9
    //         }
    //     }
    // }

// 13. 1~49 사이의 서로 다른 숫자를 여섯 개 골라 복권의 숫자 조합을 출력하는 자바 프로그램을 작성하라. 
// (서로 다른 숫자를 여섯 개 골라내려고 먼저 1…49로 채워진 배열 리스트를 만든다. 임의의 인덱스를 골라 해당하는 요소를 제거한다. 이 작업을 여섯 번 반복한다. 그런 다음 결과를 정렬해 출력한다.)
    // class LotteryNumbers {
    //     public static void main(String[] args) {
    //         ArrayList<Integer> numbers = new ArrayList<>();
    //         for (int i = 1; i <= 49; i++) {
    //             numbers.add(i);
    //         }
            
    //         for (int i = 1; i <= 6; i++) {
                
    //             Collections.shuffle(numbers); // 요소를 무작위로 섞는다.
    //             System.out.print("복권의 " + i + "번째 " + "숫자 조합: ");
    //             for (int j = 0; j < 6; j++) {
    //                 int number = numbers.get(j);
    //                 System.out.print(number + " ");
    //             }
    //             System.out.println();
    //         }
    //     }
    // }



// 14. 2차원 정수 배열을 읽고 매직 스퀘어(즉, 모든 행과 열, 대각선의 합이 같은 사각형)인지 판별하는 자바 프로그램을 작성하라. 
// (프로그램은 입력 줄을 받아서 개별 정수로 분리하고, 사용자가 빈 줄을 입력하면 중단한다. 예를 들어 입력이 다음과 같으면 프로그램은 긍정으로 응답해야 한다.)

    //   16 3 2 13

    //   5 10 11 8

    //   9 6 7 12

    //   4 15 14 1

    //   (빈 줄)

    // class MagicSquareChecker {
    //     public static void main(String[] args) {
    //         Scanner sc = new Scanner(System.in);

    //         System.out.println("2차원 배열의 크기를 입력하세요:");
    //         int n = sc.nextInt();
    //         int[][] arr = new int[n][n];

    //         System.out.println("2차원 배열을 입력하세요:");
    //         for (int i = 0; i < n; i++) {
    //             for (int j = 0; j < n; j++) {
    //                 arr[i][j] = sc.nextInt();
    //             }
    //         }

    //         // 각 행, 열, 대각선의 합
    //         int magicSum = n * (n * n + 1) / 2;

    //         // 행 검사
    //         for (int i = 0; i < n; i++) {
    //             int rowSum = 0;
    //             for (int j = 0; j < n; j++) {
    //                 rowSum += arr[i][j];
    //             }
    //             if (rowSum != magicSum) {
    //                 System.out.println("매직 스퀘어가 아닙니다.");
    //                 return;
    //             }
    //         }

    //         // 열 검사
    //         for (int i = 0; i < n; i++) {
    //             int colSum = 0;
    //             for (int j = 0; j < n; j++) {
    //                 colSum += arr[j][i];
    //             }
    //             if (colSum != magicSum) {
    //                 System.out.println("매직 스퀘어가 아닙니다.");
    //                 return;
    //             }
    //         }

    //         // 대각선 검사
    //         int diag1Sum = 0;
    //         int diag2Sum = 0;
    //         for (int i = 0; i < n; i++) {
    //             diag1Sum += arr[i][i];
    //             diag2Sum += arr[i][n - 1 - i];
    //         }
    //         if (diag1Sum != magicSum || diag2Sum != magicSum) {
    //             System.out.println("매직 스퀘어가 아닙니다.");
    //             return;
    //         }

    //         // 모든 검사를 통과한 경우 매직 스퀘어임
    //         System.out.println("매직 스퀘어입니다.");
    //     }
    // }

  

// 15. 지정한 숫자 n까지 파스칼 삼각형을 ArrayList<ArrayList<Integer>>에 저장하는 자바 프로그램을 작성하라.

    // class PascalTriangle {
    //     public static void main(String[] args) {
    //         int n = 5; // 생성할 삼각형의 크기
    //         ArrayList<ArrayList<Integer>> triangle = new ArrayList<>(); // 삼각형을 저장할 리스트

    //         for (int i = 0; i < n; i++) {
    //             ArrayList<Integer> row = new ArrayList<>();
    //             row.add(1); // 각 행의 첫 번째 원소는 1

    //             for (int j = 1; j < i; j++) {
    //                 ArrayList<Integer> prevRow = triangle.get(i - 1); // 이전 행
    //                 int val = prevRow.get(j - 1) + prevRow.get(j); // 이전 행의 j-1번째와 j번째 원소의 합
    //                 row.add(val); // 이전 행의 j-1번째와 j번째 원소의 합을 현재 행에 추가
    //             }

    //             if (i > 0) {
    //                 row.add(1); // 각 행의 마지막 원소는 1
    //             }

    //             triangle.add(row); // 현재 행을 삼각형에 추가
    //         }

    //         // 출력
    //         for (ArrayList<Integer> row : triangle) {
    //             for (int val : row) {
    //                 System.out.print(val + " ");
    //             }
    //             System.out.println();
    //         }
    //     }
    // }

// 16. average 메서드를 개선해 매개변수를 적어도 한 개 이상 받으면 호출되게 하라.
    // class Average {
    //     public static void main(String[] args) {
    //         System.out.println(average(1, 2, 3, 4, 5));
    //         System.out.println(average(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    //     }

    //     public static double average(double first, double... rest) {
    //         double sum = first;
    //         for (double value : rest) {
    //             sum += value;
    //         }
    //         return rest.length > 0 ? sum / (1 + rest.length) : first; // 매개변수가 적어도 두 개 이상이면 평균을 반환하고, 그렇지 않으면 첫 번째 매개변수를 반환
    //     }
    // }