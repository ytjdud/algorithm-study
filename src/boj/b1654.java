package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// upper bound

public class b1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] LANs = new int[K];
        long max = 0;
        for(int i=0;i<K;i++) {
            LANs[i] = Integer.parseInt(br.readLine());
            if (max < LANs[i]) max = LANs[i];
        }
        max++; // (G) upper bound 이므로 최대보다+1

        long min =0, mid; // K ≦ N 이므로 min 은 0부터 시작
        while(min<max){
            mid = (min+max)/2;

            int cnt=0;
            for(int i=0;i<K;i++){
                cnt += LANs[i]/mid ;
            }

            if(cnt < N){ // 랜선 개수 부족 == 더 짧게 잘라서 많이 만들어야함. == max 위치가 줄어야함
                max = mid;
            }else{ // 랜선 개수가 같거나 많음 == 더 길게 잘라서 적게 만들어야함 == min 위치가 올라야함
                min = mid+1;
            }
        }

        System.out.println(min-1);
    }
}
