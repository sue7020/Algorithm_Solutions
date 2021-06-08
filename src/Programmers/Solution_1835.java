package Programmers;

import java.util.*;

// 2017 카카오코드 본선 > 단체사진 찍기

public class Solution_1835 {
    public static List<Conditions> datas;
    public static int answer;

    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        solution(n, data);
    }

    public static class Conditions {
        String first;
        String second;
        char compare;
        int compareNum;

        public Conditions(String data) {
            this.first = String.valueOf(data.charAt(0));
            this.second = String.valueOf(data.charAt(2));
            this.compare = data.charAt(3);
            this.compareNum = Character.getNumericValue(data.charAt(4));
        }
    }

    public static int solution(int n, String[] data) {
        char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

        datas = new ArrayList<>();

        for (String datum : data) datas.add(new Conditions(datum));

        answer = 0;
        permutation(friends, 0, 8, 8);

        return answer;
    }



    static void permutation(char[] arr, int depth, int n, int r) {
        if (depth == r) {
            validate(arr);
            return;
        }

        for (int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(char[] arr, int depth, int i) {
        char temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }


    // 조건에 맞는지 점검
    static void validate(char[] arr) {

        boolean isValid = true;
        StringBuilder all = new StringBuilder();

        for (char c : arr) all.append(c);

        for (Conditions condition : datas) {
            int firstIndx = all.indexOf(condition.first);
            int secondIndx = all.indexOf(condition.second);

            int diff = Math.abs(firstIndx - secondIndx) - 1;
            if (condition.compare == '<')
                isValid = diff < condition.compareNum;
            else if (condition.compare == '>')
                isValid = diff > condition.compareNum;
            else
                isValid = diff == condition.compareNum;

            if (!isValid)
                break;
        }

        if(isValid)
            answer++;

    }
}
