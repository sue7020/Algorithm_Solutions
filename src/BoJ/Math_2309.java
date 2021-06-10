package BoJ;

import java.util.Arrays;
import java.util.Scanner;

// 브루트포스 > 일곱 난쟁이
public class Math_2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 100;
        int[] heights = new int[9];
        for(int i=0; i<9; i++)
            heights[i] = sc.nextInt();

        boolean found = false;
        int exceptIndex1 = -1;
        int exceptIndex2 = -1;

        for(int i=0; i<9; i++) {
            for(int j=i+1; j<9; j++) {
                int sum = 0;
                for(int k=0; k<9; k++) {
                    if(k!= i && k !=j)
                        sum+= heights[k];
                }

                if(sum == total) {
                    found = true;
                    exceptIndex1 = j;
                }
            }

            if(found) {
                exceptIndex2 = i;
                break;
            }
        }

        int[] arr = new int[7];
        int cnt = 0;
        for(int i=0; i<9; i++) {
            if(i!= exceptIndex1 && i!= exceptIndex2)
                arr[cnt++] = heights[i];
        }

        Arrays.sort(arr);

        for(int a : arr)
            System.out.println(a);

    }

}
