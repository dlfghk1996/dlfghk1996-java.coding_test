package ilhwa.codingtest.baekjoon.binarySearch;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
/**
 * https://www.acmicpc.net/problem/1920
 * 이진 탐색 (처음 중간의 값을 임의로 선택하여, 중간의 값과 찾고자 하는 값의 대/소를 비교하는 방식이다.)
 * 문제 : N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때,이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
 * 쉬운 접근 : Arrays.binarySearch() , Arrays.sort()=> 정렬 필수
 * */

// HashSet Contains() 방법도 생각보자
public class BinarySearch_1920 {

    public void sulution(final int[] array, final int searchValue) throws IOException {
        int[] A;
        Scanner sc = new Scanner(System.in);
        // N 입력 받음
        int N = sc.nextInt();
        A = new int[N];

        // N개의 정수 배열을 입력 받음
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // N개의 정수 배열을 오름차순으로 정렬
        Arrays.sort(A);
        int M = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();
            binarySearch(A, num);
        }
    }
    public void binarySearch(int[] array, int searchValue) throws IOException {

        int min = 0; // 맨 왼쪽 Index
        int max = array.length - 1; // 맨 오른쪽 Index
        int answer = 0;
        while (min <= max) {
            // 1. 중간 Index를 구한다.
            int mid = (min + max) / 2;

            // 2. 찾고자 하는 값과 중간값 을 비교하여 찾는값이 중간값보다 클 경우 => 중간값 커서 오른쪽으로 1이동
            if (array[mid] < searchValue) {
                min = mid + 1;
                // 3.찾는 값이 중간값보다 작은 경우 => 중간값 커서 왼쪽으로 1이동
            } else if (array[mid] > searchValue) {
                max = mid - 1;
            } else { // 4. 찾는값을 발견한 경우 탐색을 종료
                answer = 1;
                break;
            }
        }
        System.out.println(answer);
    }
}

