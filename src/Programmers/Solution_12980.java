package Programmers;

// 05.03 월
public class Solution_12980 {

    public static void main(String[] args) {
        int n = 6;
        solution(n);
    }

    public static int solution(int n)
    {
        int answer = 0;

        while(n >= 1)
        {
            if(n%2 == 0)
                n /= 2;
            else {
                n -= 1;
                answer++;
            }

        }

        return answer;
    }


}
