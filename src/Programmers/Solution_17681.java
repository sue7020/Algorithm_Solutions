package Programmers;

import java.util.Locale;

public class Solution_17681 {

    public static void main(String[] args) {

        int n = 5;
        int[] arr1 =  {9, 20, 28, 18, 11};
        int[] arr2 =  {30, 1, 21, 17, 28};
        solution(n, arr1, arr2);
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            String[] binary = new String[arr1.length];

            for(int i =0; i<n; i++) {
                binary[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
                System.out.println(binary[i]);
            }

            for(int i =0; i<n; i++) {

                StringBuilder temp = new StringBuilder();

                for(int j=0; j<binary[i].length(); j++)
                {
                    if(binary[i].charAt(j) == '1')
                        temp.append("#");
                    else
                        temp.append(" ");
                }

                int space = n - binary[i].length();

                for(int k=0; k<space; k++)
                    temp.insert(0, " ");

                answer[i] = temp.toString();
            }

            return answer;
        }



}
