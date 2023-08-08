package ch01.sec01;

import java.util.Random;

// class TestDriver {
//     public static void main(String[] args) {
//         /* sec 01. Random Part */
//             // System.out.println("Hello, World!"); // Hello, World!
//             // System.out.println("Hello, World!".length()); // 13
            
//             // Random Number within int range 
//             // System.out.println(new Random().nextInt());
//             // Random generator = new Random();
//             // System.out.println(generator.nextInt());
//             // System.out.println(generator.nextInt());
//         /**/

//         /* sec 02. Primitive Type */
//             // System.out.println(4000000000L); // long 리터럴
//             // System.out.println(0xCAFEBABE);  // 16진수 리터럴
//             // System.out.println(0b1001);      // 2진수 리터럴
//             // System.out.println(011);         // 8진수 리터럴
            
//             // 리터럴에 밑줄 사용 : used for humans
//             // System.out.println(1_000_000_000); 
//             // System.out.println(0b1111_0100_0010_0100_0000);

//             // 고급 주제: 부호 없는 수량
//             // System.out.println(Byte.toUnsignedInt((byte )-127));

//             // 부동소수점 리터럴
//             // System.out.println(3.14F);       // float 리터럴 : F
//             // System.out.println(3.14);        // double 리터럴 : Not F
//             // System.out.println(3.14D);       // double 리터럴
//             // System.out.println(0x1.0p-3);    // 16진수 double 리터럴
//             // System.out.println((byte)127);   // byte 리터럴
//             // System.out.println((short)127);  // short 리터럴

//             // 무한대와 NaN
//             // System.out.println(1.0 / 0.0); // Infinity
//             // System.out.println(-1.0 / 0.0); // -Infinity
//             // System.out.println(0.0 / 0.0); // Not a Number, NaN
//             // System.out.println(1.0 / 0.0 == Double.POSITIVE_INFINITY); // true
//             // System.out.println(-1.0 / 0.0 == Double.NEGATIVE_INFINITY); // true
//             // NaN은 서로 다른 값으로 간주한다.
//             // System.out.println(0.0 / 0.0 == Double.NaN); // Caution! : false
//             // System.out.println(Double.isInfinite(1.0 / 0.0));
//             // System.out.println(Double.isNaN(0.0 / 0.0));
//             // System.out.println(Double.isFinite(0.0 / 0.0));
            
//             // 반올림 오류 : 부동소수점 수는 금융 계산에는 적합하지 않다.
//             // System.out.println(2.0 - 1.1); // 0.8999999999999999
            
//             // 문자 리터럴
//             // System.out.println('J'); 
//             // System.out.println('J' == 74); // true
//             // System.out.println('\u004A'); // J
//             // System.out.println('\u263A'); // ☺
//         /**/

//         /* sec 03. Initialization */
//             // int total = 0;
//             // int i = 0, count; // Caution! : count is not initialized
//             // Random generator = new Random(); // instantiation

//             // Variable names
//             // double lotsa$ = 1000000000.0; // 변수명 : 규칙에 어긋나지는 않지만 좋은 생각은 아니다.
//             // double élévation = 0.0; // possible
//             // double π = 3.141592653589793; // possible
//             // String Count = "Dracula"; // 대소문자 구분 : count와 다른 변수다.
//             // int countOfInvalidInputs = 0; // 낙타 표기법의 예
//             // final int DAYS_PER_WEEK = 7; // 상수 표기법의 예, 메크로
//             // Weekday startDay = Weekday.MONDAY;
//             // System.out.println(startDay); // MONDAY
//             // // count가 초기화되지 않았으므로 다음 줄의 주석을 해제하면 오류가 일어난다.
//             // // System.out.println(count); 
//         /**/
//     }

//     /* sec 03. Initialization */
//         // public static final int DAYS_PER_YEAR = 365;
//         // enum Weekday { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY };
//     /**/

// }