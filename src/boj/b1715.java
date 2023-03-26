package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 퀵소트 보다 PQ 가 더 빠르걸랑
/*
https://www.acmicpc.net/board/view/71943
처음에는 이런 생각을 했다.
그래서 정렬도 한 번만 하면 되는 걸로 착각한 것 같다.
하지만 계속 (없어지고 추가되는 데이터가 있어) 정렬을 해줘야 하기 때문에 PQ 를 사용하는 것 같다.
 */

public class b1715 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        for(int i=1;i<N;i++){ // 마지막에 pq.add(now) 되는 건 무시됨. i 에 의해
            int now = pq.poll()+ pq.poll();
            sum += now;
            pq.add(now);
        }
        System.out.println(sum);
    }
}
