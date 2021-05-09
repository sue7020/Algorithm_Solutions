package Programmers;

import java.util.*;
import java.util.regex.Pattern;

// 2020 [카카오 인턴] 수식 최대화
public class Solution_67257 {

    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        solution(expression);
    }

    private static void solution(String expression) {

        long answer = 0;

        LinkedList<String> cal = new LinkedList<>();
        List<String> exs = new ArrayList<>();


        if(expression.contains("+")) {
            cal.add("+");
        }
        if(expression.contains("-")) {
            cal.add("-");
        }
        if(expression.contains("*")) {
            cal.add("*");
        }

        StringBuilder temp = new StringBuilder();
        // 숫자와 연산자 분리
        for(int i=0; i<expression.length(); i++)
        {
            if(Pattern.matches("^[0-9]*$", String.valueOf(expression.charAt(i))))
              temp.append(expression.charAt(i));
            else {
                exs.add(temp.toString());
                temp = new StringBuilder();
                exs.add(String.valueOf(expression.charAt(i)));
            }

            if(i == expression.length()-1)
                exs.add(temp.toString());
        }

        // 배열복사
        List<String> tempExs = new ArrayList<>(exs);

        // 연산자가 한개인경우
        if(cal.size() == 1)
        {
            String first = cal.get(0);
            if(tempExs.contains(first))
                calculate(tempExs, first);

            answer = Math.max(answer, Math.abs(Long.parseLong(tempExs.get(0))));
        }


        for(int i=0; i<cal.size(); i++)
        {
            String first = cal.get(i);
            String second;
            String third = "";

            for(int j =0; j<cal.size(); j++)
            {
                if(j==i)
                    continue;
                else
                {
                    second = cal.get(j);

                    for(int k=0; k<cal.size(); k++)
                    {
                        if(k!=i && k!=j)
                            third = cal.get(k);
                    }
                }

                if(tempExs.contains(first))
                    calculate(tempExs, first);

                if(!second.equals("") && tempExs.contains(second))
                    calculate(tempExs, second);

                if(!third.equals("") && tempExs.contains(third))
                    calculate(tempExs, third);


                answer = Math.max(answer, Math.abs(Long.parseLong(tempExs.get(0))));

                // 다시 배열 복사후 경우에 대한 재탐색
                tempExs = new ArrayList<>(exs);
            }

        }


        System.out.println(answer);


    }

    // 연산
    public static void calculate(List<String> tempExs, String expression) {

        int exIndex = 0;

        while(tempExs.contains(expression))
        {
            // parameter로 받은 연산자의 위치를 찾음
            for(int i=0; i<tempExs.size(); i++) {
                if(tempExs.get(i).equals(expression)) {
                    exIndex = i;
                    break;
                }
            }

            int num1Indx = exIndex -1;
            int num2Indx = exIndex +1;
            long result = 0;

            switch (expression) {
                case "+":
                    result = Long.parseLong(tempExs.get(num1Indx)) + Long.parseLong(tempExs.get(num2Indx));
                    break;
                case "-":
                    result = Long.parseLong(tempExs.get(num1Indx)) - Long.parseLong(tempExs.get(num2Indx));
                    break;
                case "*":
                    result = Long.parseLong(tempExs.get(num1Indx)) * Long.parseLong(tempExs.get(num2Indx));
                    break;
            }

            // x 연산 y 인경우 
            tempExs.remove(num2Indx); // y제거
            tempExs.remove(exIndex);  // 연산제거
            tempExs.set(num1Indx, String.valueOf(result)); // 계산결과로 x대체

        }
    }
}
