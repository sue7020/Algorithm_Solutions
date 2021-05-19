package Programmers;

// 연습문제 > 피보나치 수

public class Solution_12945 {
    public static void main(String[] args) {
        int n = 5;
        solution(n);
    }

    private static void solution(int n) {
        int answer;
        int[] d = new int[n+1];

        d[0] = 0;
        d[1] = 1;

        for(int i=2; i<=n; i++) {
            d[i] = (d[i-1]+d[i-2])%1234567;
        }

        answer = d[n];
        System.out.println(answer);
    }
}
