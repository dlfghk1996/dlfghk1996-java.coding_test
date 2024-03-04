package ilhwa.codingtest.baekjoon.recursion;

public class BasicRecursion {
    public static int sum(int k) {

        if (k > 0) {
            return k + sum(k - 1);
        } else {
            return 0;
        }
    }
}
