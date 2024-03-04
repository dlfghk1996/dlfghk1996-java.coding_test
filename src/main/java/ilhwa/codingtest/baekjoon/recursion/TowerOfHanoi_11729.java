import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;//package ilhwa.codingtest.baekjoon.recursion;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.math.BigInteger;
//import java.io.*;
//import java.math.BigInteger;
//import java.util.*;
//import javax.print.attribute.standard.JobMessageFromOperator;
//
//public class TowerOfHanoi_11729 {
//    // 채점 번호 : 19840016  -  방법 4 : BufferedReader + BufferedWriter
//    //
//    //채점 번호 : 19840012  -  방법 3 : BufferedReader + StringBuilder
//    //
//    //채점 번호 : 19840008  -  방법 2 : Scanner + BufferedWriter
//    //
//    //채점 번호 : 19840005  -  방법 1 : Scanner + StringBuilder
//    //
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static int N = 0;
//
//    public void Hanoi(int N, int start, int mid, int to) throws IOException {
//        // 원판의 개수 입력
//        N = Integer.parseInt(br.readLine());
//
//        // N이 20 이하일 경우 과정 출력
//        if (N <= 20) {
//            hanoi(N, 1, 2, 3);
//        }
//
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//
////    FROM 1
////    TMP 2
////    TO 3
//    // [로직] n 옮길 원판, from 시작 기둥, tmp 거쳐갈 기둥, to 도착 기둥
//    // 원판 3개, 시작기둥 1, 거처갈 기둥2, 도착기둥 3
//    //1. hanoi(n - 1, from, to, tmp) = hanoi(2, 1, 3, 2)
//    //2. hanoi(n - 1, from, to, tmp) = hanoi(1, 1, 2, 3) 첫번째 재귀
//    //3. hanoi(n - 1, from, to, tmp) = hanoi(1, 1, 2, 3) 두번째 재귀
//    public static void hanoi(int n, int from, int tmp, int to) throws IOException {
//        System.out.println("hanoi method 진입");                                                                ");
//        // n == 1 일경우 바로 이동
//        if (n == 1) {
//            System.out.println("n == 1 일경우 바로 이동");
//            bw.write(from + " " + to + "\n"); // 이동
//            return;
//        }
//
//        // A -> C로 옮긴다고 가정할 떄,
//        // STEP 1 : N-1개를 A에서 B로 이동 (= start 지점의 N-1개의 원판을 mid 지점으로 옮긴다.)
//        hanoi(n - 1, from, to, tmp);
//
//        // STEP 2 : 1개를 A에서 C로 이동 (= start 지점의 N번째 원판을 to지점으로 옮긴다.)
//        bw.write(from + " " + to + "\n"); // 이동
//
//        // STEP 3 : N-1개를 B에서 C로 이동 (= mid 지점의 N-1개의 원판을 to 지점으로 옮긴다.)
//        hanoi(n-1, tmp, from, to);
//    }
//
//    첫째 줄에 옮긴 횟수 K를 출력한다.
//
//    두 번째 줄부터 수행 과정을 출력한다.
//    두 번째 줄부터 K개의 줄에 걸쳐 두 정수 A B를 빈칸을 사이에 두고 출력하는데,
//    이는 A번째 탑의 가장 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다는 뜻이다
//
//
//
//
//
//
//
//
//        // 이동할 원반의 수가 1개라면?
//        if (N == 1) {
//            print(start + " " + to + "\n");
//            return;
//        }
//
//        // A -> C로 옮긴다고 가정할 떄,
//        // STEP 1 : N-1개를 A에서 B로 이동 (= start 지점의 N-1개의 원판을 mid 지점으로 옮긴다.)
//        Hanoi(N - 1, start, to, mid);
//
//        // STEP 2 : 1개를 A에서 C로 이동 (= start 지점의 N번째 원판을 to지점으로 옮긴다.)
//        print(start + " " + to + "\n");
//
//        // STEP 3 : N-1개를 B에서 C로 이동 (= mid 지점의 N-1개의 원판을 to 지점으로 옮긴다.)
//        Hanoi(N - 1, mid, start, to);
//
//    }
//}
//static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
