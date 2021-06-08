package Programmers;

import java.util.PriorityQueue;

public class Solution_42626 {

    public static void main(String[] args) {
        int[] scoville = {1,2,3,9,10,12};
        int K = 7;
        solution(scoville, K);
    }

    public static void solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int s : scoville)
            priorityQueue.add(s);

        while(priorityQueue.size() > 1 && priorityQueue.peek() < K) {

            int first = priorityQueue.poll();
            int second = priorityQueue.poll();

            int newScoville = first+ (second*2);
            priorityQueue.add(newScoville);
            answer++;
        }

        if(priorityQueue.size() <=1 && priorityQueue.peek() < K)
            answer = -1;

        System.out.println(answer);
    }


}
