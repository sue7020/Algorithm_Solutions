package Programmers;

import java.util.*;

public class Solution_64065 {

    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        int[] result = solution(s);

        for(int value : result)
            System.out.print(value + " ");
    }

    static int[] solution(String s) {

        int[] answers;

        // 맨처음, 맨마지막 괄호 제거
        s = s.substring(1, s.length() - 2);
        String[] sArr = s.split("},");
        
        // 참고
        // replaceAll("[}]") 로 } 제거 가능
        // replaceAll("[{]") 로 } 제거 가능
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = sArr[i].replace(",", " ");
            sArr[i] = sArr[i].replace("{", "");
        }

        // 원소 길이 순서대로 정렬
        Arrays.sort(sArr, (o1, o2) -> o1.length() - o2.length());

        answers = new int[sArr.length];

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < sArr.length; i++) {

            String[] tempArr = sArr[i].split(" ");

            for (String value : tempArr) {
                int temp = Integer.parseInt(value);
                if (set.add(temp)) { // set.add() returns boolean
                    answers[i] = temp;
                    break;
                }
            }
        }

        return answers;
    }
}
