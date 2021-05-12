package BoJ;

import java.util.Scanner;

// DFS > 안전 영역

public class DFS_2468 {
    public static int N;
    public static int[] d_x = {1,-1,0,0};
    public static int[] d_y = {0,0,1,-1};

    public static void main(String[] args) {
        int answer = 0;

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int[][] land = new int[N][N];
        int maxDepth = 0;

        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                land[i][j] = sc.nextInt();
                maxDepth = Math.max(land[i][j], maxDepth);
            }
        }

        int[][] checkMap;
        int[] safeLandCounts = new int[maxDepth+1];

        for(int depth = 0; depth <=maxDepth; depth++) {
            int cnt = 0;
            checkMap = new int[N][N];

            for(int i=0; i<N; i++) {
                for (int j = 0; j < N; j++)
                    checkMap[i][j] = land[i][j] > depth ? 0 : 1; // 물이차지않은 지역 0
            }

            for(int i=0; i<N; i++)
                for (int j = 0; j < N; j++) {
                    if(checkMap[i][j] == 0) {
                       dfs(i, j, checkMap);
                       cnt++;

                    }
                }
            safeLandCounts[depth] = cnt;
        }

        for (int safeLandCount : safeLandCounts) {
            System.out.print(safeLandCount + ", ");
            answer = Math.max(answer, safeLandCount);
        }

        System.out.println("answer: "+answer);

    }


    public static void dfs(int x, int y, int[][] checkMap) {

        checkMap[x][y] = 1;

        for(int k=0; k<4; k++) {
           int xx = x+d_x[k];
           int yy = y+d_y[k];

           if(checkPoint(xx, yy, checkMap))
               dfs(xx, yy, checkMap);
        }
    }

    public static boolean checkPoint(int x, int y, int[][] checkMap) {
        return x >= 0 && y >= 0 && x < N && y < N && checkMap[x][y] == 0;
    }


}
