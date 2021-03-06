package BoJ;

import java.util.*;

// DFS > 섬의 개수

public class DFS_4963 {
    static int[] dx = {0,0,-1,1,-1,-1,1,1};
    static int[] dy = {-1,1,0,0,-1,1,-1,1};
    static int w;
    static int h;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int answer = 0;
            w = sc.nextInt();
            h = sc.nextInt();

            if(w == 0 && h == 0)
                break;

            int[][] map = new int[h][w];
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++)
                    map[i][j] = sc.nextInt();
            }

            // DFS
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(map[i][j] == 1) {
                        dfs(i, j, map);
                        answer++;
                    }
                }
            }

            // BFS
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(map[i][j] == 1) {
                        bfs(i, j, map);
                        answer++;
                    }
                }
            }

            System.out.println(answer);

        }

    }

    private static void bfs(int i, int j, int[][] map) {
        Queue<Integer> que_x = new LinkedList<>();
        Queue<Integer> que_y = new LinkedList<>();

        que_x.add(i);
        que_y.add(j);
        map[i][j] = 0;

        while(!que_x.isEmpty() && !que_y.isEmpty())
        {
            int x = que_x.remove();
            int y = que_y.remove();

            for(int k=0; k<dx.length; k++)
            {
                int xx = x+dx[k];
                int yy = y+dy[k];


                if(check(xx, yy) && map[xx][yy] == 1) {

                    map[xx][yy] = 0;
                    que_x.add(xx);
                    que_y.add(yy);
                }
            }
        }
    }

    private static void dfs(int x, int y, int[][] map) {
        map[x][y] = 0; // visit 처리

        for(int k=0; k<dx.length; k++)
        {
            int xx = x+dx[k];
            int yy = y+dy[k];
            if(check(xx, yy) && map[xx][yy] == 1)
                dfs(xx, yy, map);
        }
    }

    private static boolean check(int xx, int yy) {
        return xx >=0 && yy >=0 && xx < h && yy < w;
    }
}
