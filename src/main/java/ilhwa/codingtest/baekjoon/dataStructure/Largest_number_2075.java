package ilhwa.codingtest.baekjoon.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * https://bcp0109.tistory.com/29
 * https://www.acmicpc.net/problem/2075
 * 문제 : N×N의 표에 수 N2개 채워져 있다. 이러한 표가 주어졌을 때, N번째 큰 수를 찾는 프로그램을 작성하시오. 표에 채워진 수는 모두 다르다.
 *
 * 유형 : 자료구조 / 슬라이딩 윈도우 / 우선순위 큐
 * */
public class Largest_number_2075 {

    public void solution () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            pq.offer(temp);
        }

        for(int i=1; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int temp = Integer.parseInt(st.nextToken());

                if(pq.peek() < temp) {
                    pq.poll();
                    pq.offer(temp);
                }
            }
        }

        System.out.println(pq.poll());
    }
}
