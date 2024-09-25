package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2606_2 {
    static int computers = 0;
    static boolean[][] arr;
    static boolean[] check;

    static Queue<Integer> queue = new LinkedList<Integer>();

    // by BFS
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         computers = Integer.parseInt(br.readLine());
         int inputs = Integer.parseInt(br.readLine());

         arr = new boolean[computers+1][computers+1];
         check = new boolean[computers+1];

         for(int i=0; i<inputs; i++){
             StringTokenizer st = new StringTokenizer(br.readLine());
             int com1 = Integer.parseInt(st.nextToken());
             int com2 = Integer.parseInt(st.nextToken());
             arr[com1][com2] = arr[com2][com1] = true;
         }

         System.out.println(bfs(1));

    }

    private static int bfs(int start) {
        queue.add(start);
        check[start] = true;
        int computerWorms = 0;

        while(!queue.isEmpty()){
            start = queue.poll();

            for(int i = 1; i <= computers; i++){
                if(arr[start][i] && !check[i]){
                    queue.add(i);
                    check[i] = true;
                    computerWorms++;
                }
            }
        }

        return computerWorms;
    }
}
