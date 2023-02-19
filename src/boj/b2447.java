package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 무한재귀 주의, 인자값(인덱스) 계산 꼼꼼히

public class b2447 {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                board[i][j] = ' ';
            }
        }

        print_star(N,0,0);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void print_star(int N, int I, int J){ // N = 3^k
//        if(N==1) {
//                board[I][J] = '*';
//        }else {
//            for (int i = 0; i < 3; i++) {
//                for (int j = 0; j < 3; j++) {
//                    if( !(i==1 && j ==1) )
//                        print_star(N / 3, N / 3 * i + I, N / 3 * j + J);
//                }
//            }
//        }
        if(N==1) {
            board[I][J] = '*';
            return;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if( !(i==1 && j ==1) )
                    print_star(N / 3, N / 3 * i + I, N / 3 * j + J);
            }
        }
    }
}
