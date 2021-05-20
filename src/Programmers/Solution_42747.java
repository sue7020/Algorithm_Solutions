package Programmers;

import java.util.*;

// 정렬 > H-Index
public class Solution_42747 {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        solution(citations);
    }

    public static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        // 0 1 3 5 6
        // n = 5
        for(int i=0; i<citations.length; i++)
        {
            if(citations[i] >= citations.length-i) {
                answer = citations.length-i;
                break;
            }
        }

        return answer;
    }
}
