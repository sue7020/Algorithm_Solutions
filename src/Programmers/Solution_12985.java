package Programmers;

import java.util.*;

// 2017 팁스타운 > 예상 대진표
public class Solution_12985 {

    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;

        System.out.println(solution(n,a,b));
    }
    
    public static int solution(int n, int a, int b) {
        int answer = 1;

        // 1Round : 1 2 / 3 4 / 5 6 / 7 8    원소 2묶음으로 비교
        // 2Round : ? ?   ? 4 / ? ?   7 ?    원소 4묶음으로 비교
        // 3Round : ? ?   ? 4   ? ?   7 ?    원소 8묶음으로 비교

        List<Integer> arr = new ArrayList<>();
        for(int i=1; i<=n; i++)
            arr.add(i);

        // 비교갯수
        int group = 2;

        while(group <= n) {

            boolean isSameGroup = false;

            int i=0;
            while(i < n) {
                boolean aExist = false;
                boolean bExist = false;

                int count = group + i;
                for (; i < count; i++) {
                    if(arr.get(i) == a )
                        aExist = true;
                    else if(arr.get(i) == b)
                        bExist = true;

                    System.out.print(arr.get(i) + " vs ");
                }
                System.out.println();

                isSameGroup = aExist && bExist;
                if(isSameGroup)
                    break;
            }

            if(isSameGroup)
                break;

            group*=2; // 비교할 원소묶음
            answer++; // Stage

        }

          return answer;
    }

}
