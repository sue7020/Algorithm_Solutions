package Programmers;

// DP
public class Solution_1293_dp {

    public static void main(String[] args) {
        int[][] land = {{1,2,3,5}, {5,6,7,8}, {4,3,2,1}};
        System.out.println(solution(land));
    }

    static int solution(int[][] land)
    {
        int answer = 0;

        // 각 행열이 가질 수 있는 최대합 기록
        int[][] maxSums = new int[land.length][land[0].length];

        // 첫번째 row가 가질 수 있는 최대합
        for(int col=0; col<4; col++) {
            maxSums[0][col] = land[0][col];
        }

        for(int row =1; row< land.length; row++)
        {
            for(int col=0; col<4; col++)
            {
                int max = 0;
                // [row-1][prevCol] 과의 합이 최대인 것을 기록
                // col != prevCol 제약
                for(int prevCol=0; prevCol<4; prevCol++) {
                    if (col != prevCol && maxSums[row - 1][prevCol] + land[row][col] > max)
                        max = maxSums[row - 1][prevCol] + land[row][col];
                }

                maxSums[row][col] = max;
            }
        }

        for(int row =0; row< land.length; row++)
        {
            for(int col =0; col<land[row].length; col++)
                System.out.print(maxSums[row][col] + " ");
            System.out.println();
        }

        // 마지막 열에 최대합들 존재
        for(int col =0; col<4; col++)
        {
            if(answer < maxSums[land.length-1][col])
                answer = maxSums[land.length-1][col];
        }

        return answer;
    }

}
