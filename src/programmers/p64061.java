package programmers;

import java.util.Stack;

public class p64061 {
    int[][] board;

    public int solution(int[][] board, int[] moves) {
        this.board = board;

        int answer = 0;
        Stack<Integer> bomb = new Stack<>();

        // []moves 인덱스 0 접근 이해하기 쉽도록
        for(int i: moves){
            i -= 1;

            int character = get_character(i);
            if(character != 0) {
                bomb.add(character);
                if (bomb.size() >= 2 &&
                        bomb.peek() == bomb.get(bomb.size() - 2)) {
                    bomb.pop();
                    bomb.pop();
                    answer+= 2;
                }
            }
        }

        return answer;
    }

    private int get_character(int pos) {
        int character=0;

        int len = this.board.length;

        // if 0행의 lastest 뽑기
        for(int i=0; i< len; i++){
            if(this.board[i][pos] != 0){
                character = this.board[i][pos];
                this.board[i][pos] = 0 ;
                break;
            }
        }

        return character;
    }
}
