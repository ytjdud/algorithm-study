package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b9020 {
    static boolean[] not_prime = new boolean[10001]; // false 여야 소수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        is_divided();

        StringBuilder sb = new StringBuilder();
        while(T-- >0) {
            int n = Integer.parseInt(br.readLine());
            int mid = n / 2;

            int i = mid, j = mid;
            while (i > 0 && j < n) {
                if (!not_prime[i] && !not_prime[j] && (i + j == n) ) {
                    sb.append(i).append(' ').append(j).append('\n');
                    break;
                }else{
                    i--;j++;
                }
            }
        }

        System.out.println(sb);
    }

    private static void is_divided() {
        not_prime[0] = true;
        not_prime[1] = true;

        for(int i=2;i<=100;i++){
            if(not_prime[i])  continue;
            for(int j=i*i;j<=10000;j+=i){
                not_prime[j] = true;
            }
        }
    }


}
