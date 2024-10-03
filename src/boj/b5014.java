package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int maxFloor = Integer.parseInt(inputs[0]);
        int currentFloor = Integer.parseInt(inputs[1]);
        int targetFloor = Integer.parseInt(inputs[2]);
        int goingUp = Integer.parseInt(inputs[3]);
        int goingDown = Integer.parseInt(inputs[4]);

        boolean[] visited = new boolean[maxFloor + 1];
        int[] pushes = new int[maxFloor + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(currentFloor);
        visited[currentFloor] = true;

        while (!q.isEmpty()) {
            int current = q.poll();

            if(current == targetFloor){
                System.out.println(pushes[current]);
                return;
            }

            for(int i = 0; i< 2; i++){
                int next;
                if(i == 0){ // 첫 번째는 up, 두 번째는 down 적용
                    next = current + goingUp;
                }else{
                    next = current - goingDown;
                }

                if(next > maxFloor || next < 1){
                    continue;
                }

                if(!visited[next]){
                    q.add(next);
                    visited[next] = true;
                    pushes[next] = pushes[current] + 1;
                }

            }
        }
        System.out.println("use the stairs");
    }
}
