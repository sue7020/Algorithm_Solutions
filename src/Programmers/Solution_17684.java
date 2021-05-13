package Programmers;

import java.util.*;

// 2018 KAKAO BLIND RECRUITMENT > [3차] 압축

public class Solution_17684 {

    public static void main(String[] args) {
        String msg = "ABABABABABABABAB";
        solution(msg);
    }

    public static int[] solution(String msg) {
        int[] answer = {};
        List<Integer> answerlist = new ArrayList<>();
        List<String> dic = new ArrayList<>();

        // 0 번째
        dic.add("");
        // 1-26 번째
        for(int i = 0 ; i < 26; i++) {
            dic.add(String.valueOf((char)('A'+i)));
        }

        int i=0;
        while(i<msg.length())
        {
            String w;
            String c;
            w = String.valueOf(msg.charAt(i));

            int add = 1;
            while(i+add < msg.length())
            {
                c = String.valueOf(msg.charAt(i+add));

                if(dic.contains(w+c)) {
                    w = w + c;
                    add++;
                }
                else {
                    dic.add(w + c);
                    answerlist.add(dic.indexOf(w));
                    break;
                }
            }

            if(i+add == msg.length()) {
                if(dic.contains(w))
                    answerlist.add(dic.indexOf(w));
            }

            i = i+add;
        }

        answer = new int[answerlist.size()];
        for(int a=0; a<answerlist.size(); a++) {
            answer[a] = answerlist.get(a);
        }

        return answer;
    }
}
