package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2580 {
    static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=0; i<9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sudoku(0,0);
    }

    private static void sudoku(int row, int col) {
        if(col==9){
            sudoku(row+1,0);
            return;
        }
        if(row==9){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }

        if(board[row][col] == 0){
            for(int i=1;i<10;i++){ // i=0으로 써놓아서 계속 출력안되었음...
                if(is_possible(row, col, i)){
                    board[row][col] = i;
                    sudoku(row,col+1);
                }
            }
            board[row][col] = 0;
            return;
        }
        sudoku(row, col+1); // 옆으로 이동
    }

    private static boolean is_possible(int row, int col, int i) {
        int ini_row = row/3*3;
        int ini_col = col/3*3;

        for(int k=0; k<9; k++){
            int get_row = k/3;
            int get_col = k%3;
            // 가로줄에 중복 확인
            if(board[row][k] == i) return false;
            // 세로줄!!!!!!!!에 중복 확인
            else if(board[k][col] == i) return false;
            // 3*3에 중복 확인
            else if(board[ini_row+get_row][ini_col+get_col] == i)   return false;
        }
        return true;
    }
}
