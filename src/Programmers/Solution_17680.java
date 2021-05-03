package Programmers;

import java.util.*;

// 05.03 월
public class Solution_17680 {

    public static void main(String[] args) {
        int cachSize = 3;
        String[] cities = {
               // "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"
               // "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"
               // "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"
               // "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"
//                "Seoul", "Seoul", "Seoul"
                "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"
        };

        System.out.println(solution(cachSize, cities));
    }

    static int solution(int cachSize, String[] cities)
    {
        int answer = 0;

        for(int i=0; i< cities.length; i++)
            cities[i] = cities[i].toUpperCase();

        Queue<String> cache = new LinkedList<>();

        if(cachSize == 0) {
            answer = cities.length * 5;
        }
        else {
            for (int i = 0; i < cities.length; i++) {
                String city = cities[i];

                    // cache 에 존재하는지 확인
                    if (lookUpCache(city, cache)) {
                        answer++; // hit
                        cache.remove(city);// Least Recently Used
                        cache.add(city); // 가장 뒤로 넣어줌
                    } else {
                        answer += 5; // miss
                        if(cache.size() >= cachSize) // ★ 틀렸던 부분 (없으면 remove하지 않고, size가 넘칠때 add)
                            cache.remove();
                        cache.add(city); // 캐시에 새로운 city 저장
                    }

                System.out.println(city);
                System.out.println(answer);

                System.out.println("Cache안에 ");

                for(String c : cache)
                    System.out.print(c + " / ");

                System.out.println();
                System.out.println();



            }
        }


        return answer;
    }

    static boolean lookUpCache(String city, Queue<String> cache)
    {
        boolean exist = false;

        for(String c : cache)
        {
            if(c.equals(city)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
