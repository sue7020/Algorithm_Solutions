package Programmers;

// 로또의 최고 순위와 최저 순위
public class Solution_77484 {

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        solution(lottos, win_nums);
    }
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer;

        int min = 0;
        int zeroCount = 0;

        for(int i=0; i<win_nums.length; i++) {
            if(lottos[i] == 0)
                zeroCount++;

            for (int lotto : lottos) {
                if (win_nums[i] == lotto)
                    min++;
            }
        }

        answer = new int[]{getRank(min + zeroCount), getRank(min)};

        return answer;
    }

    public static int getRank(int counts) {
        switch (counts) {
            case 6 :
                return 1;
            case 5 :
                return 2;
            case 4 :
                return 3;
            case 3 :
                return 4;
            case 2 :
                return 5;
            default:
                return 6;
        }
    }
}
