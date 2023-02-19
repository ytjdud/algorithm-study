package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2581 {
    static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        prime = new boolean[N+1];
        has_divisor();

        int sum =0, min=10001 ;
        for(int i=M;i<=N;i++){
            if(!prime[i]) {
                sum += i;
                if(min == 10001){
                    min = i;
                }
            }
        }

        if(sum==0){
            System.out.println(-1);
        }else{
            System.out.println(sum);
            System.out.println(min);
        }

    }

    private static void has_divisor() {
        int len = prime.length;
        int sqrt_len = (int) Math.sqrt(prime.length);

        prime[0] = true;
        prime[1] = true;
        for(int i=2; i<=sqrt_len; i++){
            if(prime[i])
                continue;
            for(int j=i*i; j<len; j+=i){
                prime[j] = true;
            }
        }
    }
}
