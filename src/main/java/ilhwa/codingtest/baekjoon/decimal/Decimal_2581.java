package ilhwa.codingtest.baekjoon.decimal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Decimal_2581 {


    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        // M 이상 N 이하의 자연수 중 소수 찾기
        boolean[] prime= findPrimesInRange(N);

        // 소수의 합과 최솟값 계산
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for(int i = M; i <= N; i++) {
            if(prime[i]) {
                sum += i;
                if(i < min) {
                    min = i;
                }
            }
        }

        if(sum == 0) {	// 소수가 없다면
            System.out.println(-1);
        }
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }


    // 에라토스테네스 체 알고리즘
    public static boolean[] findPrimesInRange(int N) {
        // 초기에 모든 값은 true로 설정되며, 0과 1은 소수가 아니므로 false로 설정
        boolean[] prime = new boolean[N + 1];
        Arrays.fill(prime, true);
        // 0과 1은 소수가 아님
        prime[0] = prime[1] = false;

        // 에라토스테네스의 체 알고리즘: 소수일때 true
        for(int i = 2; i <= Math.sqrt(N); i++) {
            if(prime[i]) {
                for(int j = i * i; j <= N; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }
}