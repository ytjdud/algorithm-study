package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1389 {
    static int users, t;
    static int[][] arr;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        users = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        arr = new int[users+1][users+1];

        for(int i =0; i< t; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        int min = Integer.MAX_VALUE;
        int num = 0;
        for(int i = 1; i <= users; i++){
            visited = new int[users+1];
            int res = bfs(i);
            if(min > res){
                min = res;
                num = i;
            }
        }

        System.out.println(num);
    }

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        int total = 0;
        while(!q.isEmpty()){

                int now = q.poll();

                for (int i = 1; i <= users; i++) {
                    if (visited[i] == 0 && arr[now][i] > 0) {
                        q.add(i);
                        visited[i] = visited[now] + 1;
                        total += visited[i];
                    }
                }

        }

        return total;
    }
}
