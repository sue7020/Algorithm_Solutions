package Programmers;

import java.util.ArrayList;
import java.util.*;

// 2021 KAKAO BLIND RECRUITMENT > 메뉴 리뉴얼

public class Solution_72411 {
    public static Map<String, Integer> answerMap = new HashMap<>();
    public static List<String> answerArr = new ArrayList<>();

    public static void main(String[] args) {
        String[] ordrs = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        //{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,5};
        solution(ordrs, course);
    }

    // ABCDEFGH 전체 메뉴 구하기
    // 2,3,4 에 대한 조합을 구함
    // orders 각 원소가 해당 조합을 갖고있는지 확인
    // ★ 메뉴조합갯수가 2,3,4인 조합중에서도 가장 유명한 메뉴조합 고르기
    // ArrayList 안에 add -> 오름차순 정렬

    public static String[] solution(String[] orders, int[] course) {
        String[] answer;

        // 전체 메뉴 구하기
        StringBuilder menus = new StringBuilder();
        for (String order : orders) {
            for (char menu : order.toCharArray()) {
                if (!menus.toString().contains(String.valueOf(menu)))
                    menus.append(menu);
            }
        }

        // 전체 메뉴 조합 구하기
        char[] arr = menus.toString().toCharArray();
        Arrays.sort(arr);
        boolean[] visited = new boolean[menus.length()];

        for (int r : course) {
            comb(arr, visited, orders, 0, arr.length, r);
        }

        // 코스 수에 따른 가장 많은 조합 구하기 ★
        findPopularCourse(course);

        // 오름차순 정렬
        Collections.sort(answerArr);

        answer = new String[answerArr.size()];
        for(int i=0; i<answerArr.size(); i++) 
            answer[i] = answerArr.get(i);

        return answer;
    }


    // 메뉴 조합
    static void comb(char[] arr, boolean[] visited, String[] orders, int depth, int n, int r) {
        if(r == 0) {
            StringBuilder menuComb = new StringBuilder();
            for(int i=0; i<visited.length; i++) {
                if(visited[i])
                    menuComb.append(arr[i]);
            }
            validateCourse(orders, menuComb.toString());
            return;
        }
        if(depth == n) {
            return;
        } else {
            visited[depth] = true;
            comb(arr, visited, orders, depth + 1, n, r - 1);

            visited[depth] = false;
            comb(arr, visited, orders, depth + 1, n, r);
        }
    }

    // orders에 메뉴 조합이 있는지 확인
    private static void validateCourse(String[] orders, String menuComb) {

        int orderCnt = 0;

        for (String order : orders) { // ABCFG

            boolean isNewMenus = true;

            for (int m = 0; m < menuComb.length(); m++) { // AC
                String menu = String.valueOf(menuComb.charAt(m)); // A
                if (!order.contains(menu)) {
                    isNewMenus = false;
                    break;
                }
            }

            if (isNewMenus)
                orderCnt++;
        }

        // 최소 2명이상이 주문한 조합의 경우
        if(orderCnt>=2) {
            if (answerMap.containsKey(menuComb))
                answerMap.put(menuComb, answerMap.get(menuComb) + 1);
            else
                answerMap.put(menuComb, orderCnt);
        }
    }

    private static void findPopularCourse(int[] course) {
        for (int c : course) {
            // 조합된 메뉴 개수가 course[i] 인 것중에 가장 빈도수가 많은 메뉴구성 구하기
            int maxCount = 0;
            for (String key : answerMap.keySet()) {
                if (key.length() == c) {
                    maxCount = Math.max(maxCount, answerMap.get(key));
                }
            }

            for (String key : answerMap.keySet()) {
                if (key.length() == c && answerMap.get(key) == maxCount)
                    answerArr.add(key);
            }
        }
    }



}
