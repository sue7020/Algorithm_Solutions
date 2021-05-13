package BoJ;

import java.util.*;

// 연결 요소의 개수
public class DFS_11724 {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] graph = new int[n+1][n+1];
        boolean[] visited = new boolean[n+1];

        for(int i=0; i<m; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a][b] = 1;
            graph[b][a] = 1;
        }


        for(int i=1; i<graph.length; i++)
        {
            if(!visited[i]) {
                dfs(i, graph, visited);
                answer++;
            }
        }

        System.out.println(answer);

    }

    public static void dfs(int component, int[][] graph, boolean[] visited)
    {
        visited[component] = true;

        for(int i=1; i<graph.length; i++)
        {
            if(!visited[i] && graph[component][i] == 1)
                dfs(i, graph, visited);
        }
    }
}
