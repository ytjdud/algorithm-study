package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b9663 {
    static int N;
    static int[] board;
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];

        nQueen(0);
        System.out.println(cnt);
    }

    private static void nQueen(int depth) {
        if(depth == N){
            cnt++;
            return;
        }

        for(int i=0;i<N;i++){
            board[depth] = i;
            if(is_possible(depth)){
                nQueen(depth+1);
            }
        }

    }

    private static boolean is_possible(int col) {
        for(int i=0;i<col;i++){
            if(board[i] == board[col]){
                return false;
            }else if(Math.abs(i - col) == Math.abs(board[i] - board[col])){
                // 가로 차 와 세로높이 차 가 같으면 대각선에 있는거
                return false;
            }
        }
        return true;
    }
}
