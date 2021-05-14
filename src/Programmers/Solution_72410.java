package Programmers;

import java.util.regex.Pattern;

// 2021 KAKAO BLIND RECRUITMENT > 신규 아이디 추천
public class Solution_72410 {
    
    // substring
    // 정규식
    
    public static void main(String[] args) {
        
        String new_id = "....A__B..";
        //String new_id = "abcdefghijklmn.p";

        solution(new_id);
    }

    public static String solution(String new_id) {
        String answer = "";
        String tempStr = "";

        // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = new_id.toLowerCase();

        // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        for(int i=0; i<new_id.length(); i++) {
            String s = String.valueOf(new_id.charAt(i));
            if( Pattern.matches("^[a-z0-9]$", s))
                tempStr+= s;

            if(s.equals("_"))
                tempStr+= s;

            if(s.equals("-"))
                tempStr+= s;

            if(s.equals("."))
                tempStr+= s;
        }
        new_id = tempStr;


        tempStr = "";
        // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        for(int i=0; i<new_id.length(); i++) {

            if(String.valueOf(new_id.charAt(i)).equals("."))
            {
                if(i+1 <new_id.length() && String.valueOf(new_id.charAt(i+1)).equals("."))
                    continue;
                else
                    tempStr+= String.valueOf(new_id.charAt(i));
            }
            else
                tempStr+= String.valueOf(new_id.charAt(i));
        }

        new_id = tempStr;

        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if(new_id.startsWith(".")) {
            if(new_id.length() > 1)
                new_id = new_id.substring(1, new_id.length());
            else
                new_id = "";
        }
        if(new_id.endsWith("."))
            if(new_id.length() > 1)
                new_id = new_id.substring(0, new_id.length()-1);

        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(new_id.isEmpty())
            new_id = "a";

        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(new_id.length() >= 16)
            new_id = new_id.substring(0,15);
        if(new_id.endsWith("."))
            new_id = new_id.substring(0, new_id.length()-1);

        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(new_id.length() <=2) {
            String endChar = String.valueOf(new_id.charAt(new_id.length()-1));
            while (new_id.length() <3) {
                new_id+=endChar;
            }
        }


        answer = new_id;

        return answer;
    }
}
