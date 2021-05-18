package Programmers;

// 약수의 개수와 덧셈
public class Solution_77884 {
    public static void main(String[] args) {
        int left = 13;
        int right = 17;
        System.out.println(solution(left, right));
    }

    public static int solution(int left, int right) {
        int answer = 0;

        for(int num=left; num<=right; num++) {
            int divCount = num != 1 ? 2 : 1;
            for(int i=2; i<num; i++) {
                if(num%i == 0)
                    divCount++;
            }

            if(divCount%2 == 0)
                answer+= num;
            else
                answer-=num;
        }

        return answer;
    }
}
