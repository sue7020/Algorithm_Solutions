package Programmers;

import java.util.*;

// Greedy
public class Solution_42885 {

    public static void main(String[] args) {
        int[] people = {70,50,80,50};
        int limit = 100;
        solution(people, limit);
    }

    // index 활용
    private static void solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int i = people.length-1; // 최대값
        int j = 0; // 최소값
        for(;j <= i; i--)
        {
            answer++;

            if(i!=j && people[i] + people[j] <= limit)
                j++;
        }

        System.out.println(answer);

    }

}
