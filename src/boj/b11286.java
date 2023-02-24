package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class b11286 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> absHeap = new PriorityQueue<>((pq1,pq2) ->{
            int abs1 = Math.abs(pq1);
            int abs2 = Math.abs(pq2);
            /*
            이 함수가 리턴하는 값이 0보다 작을 경우,  a가 b보다 앞에 오도록 정렬하고,
            이 함수가 리턴하는 값이 0보다 클 경우, b가 a보다 앞에 오도록 정렬합니다.
            만약 0을 리턴하면, a와 b의 순서를 변경하지 않습니다.
             */
            if(abs1 == abs2){
                return pq1-pq2;
            }else{
                return abs1 - abs2;
            }
        });

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(N-- >0){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(absHeap.isEmpty()){
                    sb.append(0).append('\n');
                }else{
                    sb.append(absHeap.poll()).append('\n');
                }
            }else{
                absHeap.add(x);
            }
        }
        System.out.println(sb);
    }
}
