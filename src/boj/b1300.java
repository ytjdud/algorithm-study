package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// lower bound
/*
K값에 대해 𝑥 보다 작은 수가 K값이랑 같은 경우의 수가 여러개일 가능성이 발생하기 때문에
'찾고자 하는 값과 같거나 큰 수가 있는 첫 번째 인덱스'를 찾는 Lower-Bound를 써주어야 한다는 것이다.
 */

public class b1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int min=1, max=k, mid; // max=N*N 이지만 =k 로 범위를 좁힐 수 있다. 그리고 N*N 으로 할당 시 자료형은 long 으로 선언해야 한다.
        while(min<max){
            // B[*] = mid,
            mid = (min+max)/2;

            // *값 구하기(k와 비교)
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
        // index *
        System.out.println(min);
    }
}
