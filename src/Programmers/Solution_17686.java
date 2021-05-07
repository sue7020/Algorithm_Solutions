package Programmers;

import java.util.*;
import java.util.regex.Pattern;

public class Solution_17686 {
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        //출력: ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]

        solution(files);

    }

    public static class File implements Comparable<File>{
        String head ;
        String number;
        String tail;
        int originalIndex;


        public File(String head, String number, String tail , int originalIndex)
        {
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.originalIndex = originalIndex;
        }

        @Override
        public int compareTo(File o) {

            if(this.head.equalsIgnoreCase(o.head))
            {
                if(Integer.valueOf(this.number) == Integer.valueOf(o.number))
                {
                    // 두 파일의 HEAD 부분과, NUMBER의 숫자도 같을 경우, 원래 입력에 주어진 순서를 유지한다.
                    // MUZI01.zip과 muzi1.png가 입력으로 들어오면, 정렬 후에도 입력 시 주어진 두 파일의 순서가 바뀌어서는 안 된다.
                    if(this.originalIndex > o.originalIndex)
                        return 1;
                    else
                        return -1;
                }
                else  // 파일명의 HEAD 부분이 대소문자 차이 외에는 같을 경우, NUMBER의 숫자 순으로 정렬한다.
                    // 9 < 10 < 0011 < 012 < 13 < 014 순으로 정렬된다. 숫자 앞의 0은 무시되며, 012와 12는 정렬 시에 같은 같은 값으로 처리된다.
                    return Integer.valueOf(this.number) - Integer.valueOf(o.number);
            }
            else // 파일명은 우선 HEAD 부분을 기준으로 사전 순으로 정렬한다.
                 // 이때, 문자열 비교 시 대소문자 구분을 하지 않는다. MUZI와 muzi, MuZi는 정렬 시에 같은 순서로 취급된다.
                return (this.head.toUpperCase()).compareTo(o.head.toUpperCase());
        }
    }



    private static void solution(String[] files) {

        String[] answer = new String[files.length];
        List<File> fileArray = new ArrayList<>();

        for(int o=0; o<files.length; o++)
        {
            String file = files[o];
            String head = "";
            String num = "";
            String tail = "";

            String numPattern = "^[0-9]*$"; //숫자만

            int i;

            //head
            for(i=0; i<file.length(); i++)
            {
                if(!Pattern.matches(numPattern, String.valueOf(file.charAt(i))))
                   head+=  file.charAt(i);
                else break;
            }

            // number
            for(; i<file.length(); i++)
            {
                if(Pattern.matches(numPattern, String.valueOf(file.charAt(i))))
                    num+=  file.charAt(i);
                else break;
            }

            // tail
            for(; i<file.length(); i++)
                    tail+=  file.charAt(i);

            fileArray.add(new File(head, num, tail, o));
        }

        Collections.sort(fileArray);

        for(int f =0; f<  fileArray.size(); f++)
            answer[f] = fileArray.get(f).head + fileArray.get(f).number + fileArray.get(f).tail;

        for(String a : answer)
            System.out.println(a);
    }


}
