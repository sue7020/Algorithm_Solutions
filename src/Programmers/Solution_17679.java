package Programmers;

import java.util.*;

// 2018 KAKAO BLIND RECRUITMENT > [1차] 프렌즈4블록

public class Solution_17679 {

    public static Queue<Point> que = new LinkedList<>();
    public static int N;
    public static int M;

    public static void main(String[] args) {
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        solution(6,6,board);
    }

    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        M = m;
        N = n;

        Character[][] boards = new Character[m][n];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                boards[i][j] = board[i].charAt(j);


            while(true) {
                // 4블록 찾기
                if(!find4Blocks(boards))
                    break;

                // 4블록 제거
                while(!que.isEmpty()) {
                    Point point = que.remove();
                    if(boards[point.x][point.y] != '*')
                        boards[point.x][point.y] = '*';
                }

                // 아래 빈칸으로 나머지 블록 내려주기 ★
                for(int i=m-1; i>=0; i--) {
                    for (int j = 0; j < n; j++) {
                        int x = i;
                        while(x+1 < m && boards[x+1][j] == '*')
                            x++;

                        if(x!=i) {
                            boards[x][j] = boards[i][j];
                            boards[i][j] = '*';
                        }
                    }
                }

                // 단계별 결과 확인
                for(int r=0; r<m; r++) {
                    for (int c = 0; c < n; c++)
                        System.out.print(boards[r][c] + " ");
                    System.out.println();
                }
                System.out.println();
            }


            // 빈칸 갯수 세기
            for(int r=0; r<m; r++) {
                for (int c = 0; c < n; c++) {
                    if(boards[r][c] == '*')
                        answer++;
                }
            }

        return answer;
    }

    // 4개 단위가 있는지 여부
    public static boolean find4Blocks(Character[][] boards) {

        for(int i=0; i<boards.length; i++)
        {
            for(int j=0; j<boards[i].length; j++)
            {
                if(check(i,j) && check(i,j+1) && check(i+1, j) && check(i+1,j+1))
                {
                    if(boards[i][j] != '*' &&
                            boards[i][j] == boards[i][j+1] && boards[i][j] == boards[i+1][j] &&  boards[i][j] == boards[i+1][j+1]) {
                        que.add(new Point(i, j));
                        que.add(new Point(i, j+1));
                        que.add(new Point(i+1, j));
                        que.add(new Point(i+1, j+1));
                    }
                }
            }
        }

        return !que.isEmpty();

    }

    public static boolean check(int x, int y) {
        return x>=0 && y>=0 && x<M && y<N;
    }
}
