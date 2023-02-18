package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 어렵게 생각x, 비교군의 크기가 크지 않으면 직접 만든다.

public class b1018 {
    static String[][] w_board = {
            {"W","B","W","B","W","B","W","B"},
            {"B","W","B","W","B","W","B","W"},
            {"W","B","W","B","W","B","W","B"},
            {"B","W","B","W","B","W","B","W"},
            {"W","B","W","B","W","B","W","B"},
            {"B","W","B","W","B","W","B","W"},
            {"W","B","W","B","W","B","W","B"},
            {"B","W","B","W","B","W","B","W"}};
    static String[][] b_board = {
            {"B","W","B","W","B","W","B","W"},
            {"W","B","W","B","W","B","W","B"},
            {"B","W","B","W","B","W","B","W"},
            {"W","B","W","B","W","B","W","B"},
            {"B","W","B","W","B","W","B","W"},
            {"W","B","W","B","W","B","W","B"},
            {"B","W","B","W","B","W","B","W"},
            {"W","B","W","B","W","B","W","B"}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[][] board = new String[N][M];
        for(int i=0;i<N;i++){
            String[] a = br.readLine().split("");
            for(int j=0; j<M; j++){
                board[i][j] = a[j];
            }
        }

        int i_limit = N-8;
        int j_limit = M-8;
        int cnt = 0;
        for(int i=0;i<=i_limit;i++){
            for(int j=0;j<=j_limit; j++){
                if(i==0 && j ==0)   cnt = 32;
                cnt = count_board(board,i,j,cnt); // 0 5
                if(cnt == 0)   break;
            }
        }
        System.out.println(cnt);
    }

    private static int count_board(String[][] board,int I,int J, int previous_cnt) {
        int present_w_cnt = 0 ;
        int present_b_cnt = 0 ;

        for(int i=I, x=0;i<I+8;i++, x++){ // 0 8
            for(int j=J, y=0; j<J+8; j++, y++){ // 6 13
                if(!board[i][j].equals(w_board[x][y])){
                    present_w_cnt++;
                }
                if(!board[i][j].equals(b_board[x][y])){
                    present_b_cnt++;
                }
                if(Math.min(present_w_cnt,present_b_cnt) >= previous_cnt) return previous_cnt;
            }
        }
        return Math.min(present_w_cnt,present_b_cnt);
    }
}
