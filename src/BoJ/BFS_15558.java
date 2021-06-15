package BoJ;

import java.awt.*;
import java.util.*;

// 점프 게임 15558
public class BFS_15558 {
    public static int N;
    public static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        k = sc.nextInt();

        String left = sc.next();
        String right = sc.next();

        int[][] arr = new int[2][N];

        for(int i=0; i<left.length(); i++)
            arr[0][i] = Character.getNumericValue(left.charAt(i));

        for(int i=0; i<right.length(); i++)
            arr[1][i] = Character.getNumericValue(right.charAt(i));

        int[][] time = new int[2][N];

        int answer = bfs(arr, time);

        System.out.println(answer);
    }

    public static int bfs(int[][] arr, int [][] time) {
        int success = 0;

        Queue<Point> locationQue = new LinkedList<>();

        // 첫번째칸
        time[0][0] = 1;
        locationQue.add(new Point(0,0));

        while(!locationQue.isEmpty())
        {
            Point head = locationQue.remove();
            int map = head.x;
            int index = head.y;

            // +1
            if(check(index+1) && time[map][index+1] == 0 && arr[map][index+1] ==1) {
                locationQue.add(new Point(map, index+1));
                time[map][index+1] = time[map][index]+1;
            }
            // -1
            if(check(index-1) && time[map][index-1] == 0 && arr[map][index-1] ==1) {
                
                // 중요 : n초 마다 칸이 사라지는 조건이 있으므로
                // index 초보다 시간이 오래걸린 경우 무시한다
                if(index >= time[map][index]+1)
                {
                    locationQue.add(new Point(map, index-1));
                    time[map][index-1] = time[map][index]+1;
                }
            }

            int oppositeMap = map == 0 ? 1 : 0;
            // +k
            if(check(index+k) && time[oppositeMap][index+k] == 0 && arr[oppositeMap][index+k] ==1) {
                locationQue.add(new Point(oppositeMap, index +k));
                time[oppositeMap][index + k] = time[map][index] + 1;
            }
        }

        for(int i=0; i<time.length; i++) {
            for (int j = 0; j < time[i].length; j++)
                System.out.print(time[i][j] + " ");
            System.out.println();
        }

        for(int t = 0; t < N; t++) {
            if(time[0][t] !=0 && t+1 >= time[0][t]) {
                if( t+1 >= N || t+k >= N) {
                    success = 1;
                    break;
                }
            }
            else if(time[1][t] !=0 && t+1 >= time[1][t]) {
                if( t+1 >= N || t+k >= N) {
                    success = 1;
                    break;
                }
            }

        }

        return success;

    }

    public static boolean check(int index) {
        return  index >=0 && index < N;
    }



}
