package Programmers;

// DP
public class Solution_43105 {

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        solution(triangle);
    }

    private static void solution(int[][] triangle) {

        int answer = 0;

        for(int row=1; row < triangle.length; row++)
        {
            for(int col=0; col < triangle[row].length; col++)
            {
                if(col == 0)
                    triangle[row][col] += triangle[row-1][0];
                else if(col == triangle[row].length-1)
                    triangle[row][col] += triangle[row-1][col-1];
                else
                    triangle[row][col] += Math.max(triangle[row-1][col-1], triangle[row-1][col]);
            }
        }

        for(int col=0; col < triangle[triangle.length-1].length; col++)
            if(answer < triangle[triangle.length-1][col])
                answer = triangle[triangle.length-1][col];


        System.out.println(answer);


    }
}
