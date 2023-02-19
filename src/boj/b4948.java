package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 만약에 123456 을 30 번 반복입력받으면 어떻게 될까?
// 앞서 이미 세어줬음에도 계속 반복문이 돌 때마다 세어준다.

public class b4948 {
    static boolean[] divided = new boolean[246913];
    static int[] primes = new int[246913];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n;

        has_divisor();
        count_primes();

        while(true){
            n = Integer.parseInt(br.readLine());
            if(n==0)    break;
            sb.append(primes[2*n]-primes[n]).append('\n');
        }

        System.out.println(sb);
    }

    private static void count_primes() {
        for(int i=2;i<246913; i++){
            if(!divided[i])  primes[i] = primes[i-1]+1;
            else primes[i] = primes[i-1];
        }
    }

    private static void has_divisor() {

        divided[0] = true;
        divided[1] = true;
        for(int i=2; i<=496; i++){ // 496.xx
            if(divided[i]) {
                continue;
            }
            for(int j=i*i; j<246913; j+=i){
                divided[j] = true;

            }
        }
    }

}
