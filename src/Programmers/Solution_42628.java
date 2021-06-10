package Programmers;

import java.util.*;

public class Solution_42628 {
    public static void main(String[] args) {
        String[] operations = {"I 7","I 5","I -5","D -1"};
        solution(operations);
    }

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());

        for(String op : operations) {
            String[] opArr = op.split(" ");


            if(opArr[0].equals("I")) {
                pqueue.add(Integer.valueOf(opArr[1]));
            } else {
                if(!pqueue.isEmpty()) {
                    if (opArr[1].equals("1")) {
                        pqueue.remove();
                    } else if (opArr[1].equals("-1")) {
                        PriorityQueue<Integer> temp = new PriorityQueue<>();
                        while(pqueue.size() > 1)
                            temp.add(pqueue.remove());
                        pqueue.clear();

                        while(!temp.isEmpty())
                            pqueue.add(temp.remove());
                    }
                }
            }
        }


        // 최대값
        if(!pqueue.isEmpty())
            answer[0] = pqueue.poll();
        // 최대값
        while(!pqueue.isEmpty()) {
            if(pqueue.size() == 1)
                answer[1] = pqueue.peek();
            pqueue.remove();
        }

        System.out.print(answer[0] + " " + answer[1]);

        return answer;
    }
}
