package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b11729 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 점화식 a(n+1) = 2an +1 (n>=2), a1 = 1 a2 = 3 a3 = 7 a4= 15
        sb.append((int) (Math.pow(2, N) - 1)).append('\n');

        hanoi(N,1,2,3);

        System.out.println(sb);

    }
    public static void hanoi(int N, int from,int via, int to){
        if(N==1){
            sb.append(from).append(' ').append(to).append("\n");
            return;
        }
        // A -> C
        hanoi(N-1, from, to, via);
        // 가장 밑 원판
        sb.append(from).append(' ').append(to).append("\n");
        // B->C
        hanoi(N-1, via, from, to);
    }
}
