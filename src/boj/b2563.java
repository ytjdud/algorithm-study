package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 겹친 색종이 넓이 구하기

public class b2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int cnt =0;

        int[][] board = new int[100][100];
        // [n] = n~n+1 (예) [0] = 0~1, [99] = 99~100

        for(int i=0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());


            for(int m=x; m<x+10; m++){
                for(int n=y; n<y+10; n++){
                    if(board[m][n] == 0){
                        board[m][n] = 1;
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
