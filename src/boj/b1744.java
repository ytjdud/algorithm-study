package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> negQ = new PriorityQueue<>();
        PriorityQueue<Integer> posQ = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            int n = Integer.parseInt(br.readLine());
            if(n<=0){
                negQ.add(n);
            } else if (n>0) {
                posQ.add(n);
            }
        }


        int sum =0;
        while(!negQ.isEmpty()){
            int i1 = negQ.poll();
            if(!negQ.isEmpty()){
                int i2 = negQ.poll();
                sum += i1*i2;
            }else{
                sum += i1;
            }
        }

        if(posQ.size()%2==1){
            sum += posQ.poll();
        }
        while(!posQ.isEmpty()){
            int i1 = posQ.poll();
            if(!posQ.isEmpty()){
                int i2 = posQ.poll();
                if(i1==1){
                    sum+=i1+i2;
                    continue;
                }
                sum += i1*i2;
            }else{
                sum += i1;
            }
        }

        System.out.println(sum);
    }
}
