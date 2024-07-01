package ilhwa.codingtest.baekjoon.recursion;


import java.util.Scanner;

// 재귀 함수 사용
public class Factorial_10872 {
    // 재귀문 사용
    public void solution1() {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        in.close();

        int sum = factorial(N);

        System.out.println(sum);

    }

    // 재귀 함수
    public static int factorial(int N) {
        System.out.println("N: " + N);
        // N이 1또는 0이 될 경우 return 1
        if(N <= 1) {
            return 1;	// 재귀 종료조건
        }

        return N * factorial(N - 1);
    }


    /* 재귀문 대신 반복문을 사용하였을 경우
     * 함수 호출이 아닌 변수 값 변경을 통해 유사 재귀처럼 푼다.
     */
    public void solution2() {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        in.close();

        int sum = 1;

        // N 이 0이 아닐 때 까지 1씩 감소하면서 sum에 반복적으로 곱해준다
        while(N != 0) {
            sum = sum * N;
            N--;
        }

        System.out.println(sum);
    }
}
