package Programmers;

import java.lang.reflect.Array;
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
                if(this.number.equals(o.number))
                {
                    if(this.originalIndex < o.originalIndex)
                        return 1;
                    else
                        return -1;
                }
                else
                    return Integer.valueOf(this.number) - Integer.valueOf(o.number);
            }
            else
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

            int i=0;
            for(i=0; i<file.length(); i++)
            {
                if(!Pattern.matches(numPattern, String.valueOf(file.charAt(i))))
                   head+=  file.charAt(i);
                else break;
            }

            for(; i<file.length(); i++)
            {
                if(Pattern.matches(numPattern, String.valueOf(file.charAt(i))))
                    num+=  file.charAt(i);
                else break;
            }

            for(; i<file.length(); i++)
                    tail+=  file.charAt(i);

            fileArray.add(new File(head, num, tail, o));
        }

        Collections.sort(fileArray);


        for(int f =0; f<  fileArray.size(); f++)
            answer[f] = fileArray.get(f).head + fileArray.get(f).number + fileArray.get(f).tail;

    }


}
