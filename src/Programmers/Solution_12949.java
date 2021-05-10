package Programmers;

// 연습문제 > 행렬의 곱셈
public class Solution_12949 {
    public static void main(String[] args) {
        Solution_12949 s = new Solution_12949();
        
        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        s.solution(arr1, arr2);
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int row1=0; row1<arr1.length; row1++)
        {
            int col2 = 0;

            while(col2 < arr2[0].length)
            {
                int multiple = 0;

                for(int n=0; n<arr1[0].length; n++)
                    multiple += (arr1[row1][n] * arr2[n][col2]);

                answer[row1][col2] = multiple;

                col2++;
            }

        }


        return answer;
    }

}
