package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class b1021 {
    static LinkedList<Integer> dq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dq = new LinkedList<>();
        for(int i=1;i<=N;i++){
            dq.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int target;
        int cnt=0;
        while(M-- >0){
            target = Integer.parseInt(st.nextToken());
            int half = dq.size()/2;
            int target_pos = dq.indexOf(target);

            if(target_pos<=half){
                while(dq.element()!=target){
                    dq.addLast(dq.pollFirst());
                    cnt++;
                }
                dq.pollFirst();
            }else{
                while(dq.element() !=target){
                    dq.addFirst(dq.pollLast());
                    cnt++;
                }
                dq.pollFirst();
            }
        }
        System.out.println(cnt);
    }
}
