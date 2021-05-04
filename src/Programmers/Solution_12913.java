package Programmers;

// DFS -- 시간초과
public class Solution_12913 {

    static int N;
    static int maxSum = 0;
    static boolean[][] visited;
    
    public static void main(String[] args) {

        int[][] land = {{4, 3, 2, 1}, {2, 2, 2, 1}, {6, 6, 6, 4}, {8, 7, 6, 5}};

        System.out.println(solution(land));
    }

    static int solution(int[][] land)
    {
       int answer = 0;
       N = land.length;

       visited = new boolean[land.length][land[0].length];

       for(int col =0; col<4; col++) // 1행 열
       {
           visited[0][col] = true;
           dfs(land, 1, land[0][col]);
           visited[0][col] = false;
       }

       System.out.println(maxSum);
       return answer;
    }

    static void dfs(int[][] land, int row, int sum)
    {
        if(row == N)
        {
            if(maxSum < sum)
                maxSum = sum;
            return;
        }

        for(int c=0; c<4; c++)
        {
            if(!visited[row-1][c])
            {
                visited[row][c] = true;
                sum+= land[row][c];
                dfs(land, row+1, sum);

                visited[row][c] = false;
                sum-= land[row][c];
            }
        }
    }
}
