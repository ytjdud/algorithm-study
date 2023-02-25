package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// upper bound

public class b1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int min=1, max=k, mid; // max=N*N 이지만 =k 로 범위를 좁힐 수 있다. 그리고 N*N 로 하면 틀렸습니다 가 뜬다.
        while(min<max){
            // B[*] = mid,
            mid = (min+max)/2;
            // *값 구하기
            long cnt =0;
            for(int i=1;i<=N; i++){
                if(i > k)   break;
                cnt += Math.min(mid/i, N);
            }

            if(cnt < k){
                min = mid +1;
            }else{
                max = mid;
            }
        }
        System.out.println(min);
    }
}
